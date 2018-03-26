package cz.uhk.fim.kozakev1.demofragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cz.uhk.fim.kozakev1.demofragment.adapter.OnItemDeleteClickListener;
import cz.uhk.fim.kozakev1.demofragment.adapter.RecyclerViewAdapter;
import cz.uhk.fim.kozakev1.demofragment.model.PersonData;

public class MainActivity extends AppCompatActivity implements OnItemDeleteClickListener {

// resi seznam radku a dat
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter; //staticka trida v tride RecxclerView, vezme ten seznam dat a sazi je do komponent
    //zpracovani, rovnani radku
    private  RecyclerView.LayoutManager layoutManager;

    private PersonData personData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        layoutManager = new LinearLayoutManager(this); // kontext - odkaz na pozadovanoou tridu
        recyclerView.setLayoutManager(layoutManager);


        personData = new PersonData(); //prazdny
        personData = PersonData.newTestInstance(); //testovaci data


        adapter = new RecyclerViewAdapter(personData);
        adapter.setOnItemDeleteClickListener(this);
        recyclerView.setAdapter(adapter);



        // spojit dva objekty - setter nebo constructor

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onItemDelete(int position) {
        personData.remove(position);
        adapter.notifyDataSetChanged();
    }
}
