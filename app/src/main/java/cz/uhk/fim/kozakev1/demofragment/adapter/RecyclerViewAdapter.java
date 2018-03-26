package cz.uhk.fim.kozakev1.demofragment.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import cz.uhk.fim.kozakev1.demofragment.MainActivity;
import cz.uhk.fim.kozakev1.demofragment.R;
import cz.uhk.fim.kozakev1.demofragment.model.Person;
import cz.uhk.fim.kozakev1.demofragment.model.PersonData;

/**
 * Created by kozakev1 on 19.03.2018.
 */
// adapter - trida, co se stara o data
    //ViewHolder spravuje jeden radek
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.PersonViewHolder> {
    private PersonData personData;

    private OnItemDeleteClickListener onItemDeleteClickListener;


    public RecyclerViewAdapter(PersonData personData) {
        this.personData = personData;
    }



    @Override //kontroler nad radky, vola se na zacatku vytvori radky, co se vejdou na obrazovku
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // kazdy radek bude textView
        // kontext . prevezmu z parent


        // z xml vygeneruje java kod (Inflater)
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_person, null);


        PersonViewHolder viewHolder = new PersonViewHolder(view);
        return viewHolder;
    }

    @Override //kdyz je potreba, prehodí se data
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        Person person = personData.get(position);
        holder.setPerson(person);

    }

    @Override
    public int getItemCount() {
        return personData.size();
    }

    public void setOnItemDeleteClickListener(OnItemDeleteClickListener listener) {
        this.onItemDeleteClickListener = listener;
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private View viewGender;
        private SeekBar seekBarAge;
        private Button btnCall;

        public PersonViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            viewGender = itemView.findViewById(R.id.viewGender);
            seekBarAge= itemView.findViewById(R.id.seekBar);
            btnCall = itemView.findViewById(R.id.btnCallPerson);

        }

        public void setPerson(final Person person) {
            textViewName.setText(person.getName());
            if (person.isMale()) {
                viewGender.setBackgroundResource(R.color.colorMale);
            } else {
                viewGender.setBackgroundResource(R.color.colorFemale);
            }
            seekBarAge.setProgress(person.getAge());
            btnCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   onItemDeleteClickListener.onItemDelete(getAdapterPosition());
                }
            });

        }
    }

}
