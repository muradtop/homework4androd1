package com.example.lesson4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;


    String s1[], s2[];
    int images[] = {  R.drawable.java,

            R.drawable.python,
            R.drawable.php,
            R.drawable.javascript,
            R.drawable.kotlin};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        s1 = getResources().getStringArray(R.array.programming_languges);
        s2 = getResources().getStringArray(R.array.description);


        RecyclerviewAdapter recyclerviewAdapter = new RecyclerviewAdapter(this, s1, s2, images);
        recyclerView.setAdapter(recyclerviewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}