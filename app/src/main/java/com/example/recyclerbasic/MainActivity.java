package com.example.recyclerbasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  RecyclerView recyclerView;
  ArrayList<ContactModel> arrContacts = new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.idRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrContacts.add(new ContactModel(R.drawable.boy,"A","9363685525"));
        arrContacts.add(new ContactModel(R.drawable.girl,"B","9363685525"));
        arrContacts.add(new ContactModel(R.drawable.boy,"A","9363685525"));
        arrContacts.add(new ContactModel(R.drawable.girl,"B","9363685525"));
        arrContacts.add(new ContactModel(R.drawable.boy,"A","9363685525"));
        arrContacts.add(new ContactModel(R.drawable.girl,"B","9363685525"));
        arrContacts.add(new ContactModel(R.drawable.boy,"A","9363685525"));
        arrContacts.add(new ContactModel(R.drawable.girl,"B","9363685525"));
        arrContacts.add(new ContactModel(R.drawable.boy,"A","9363685525"));
        arrContacts.add(new ContactModel(R.drawable.girl,"B","9363685525"));
        arrContacts.add(new ContactModel(R.drawable.boy,"A","9363685525"));
        arrContacts.add(new ContactModel(R.drawable.girl,"B","9363685525"));
        arrContacts.add(new ContactModel(R.drawable.boy,"A","9363685525"));
        arrContacts.add(new ContactModel(R.drawable.girl,"B","9363685525"));
        arrContacts.add(new ContactModel(R.drawable.boy,"A","9363685525"));

        RecyclerContactAdapter recyclerContactAdapter = new RecyclerContactAdapter(this,arrContacts);
        recyclerView.setAdapter(recyclerContactAdapter);

    }
}