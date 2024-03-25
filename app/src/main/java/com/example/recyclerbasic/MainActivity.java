package com.example.recyclerbasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtName , edtNumber;
    Button btnSave;
    RecyclerView recyclerView;
    RecyclerContactAdapter recyclerContactAdapter;
  ArrayList<ContactModel> arrContacts = new ArrayList<>();
  FloatingActionButton FAB;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FAB = findViewById(R.id.idFAB);
        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update_layoutfile);

        edtName = dialog.findViewById(R.id.idEdtName);
        edtNumber = dialog.findViewById(R.id.idEdtNumber);
        btnSave = dialog.findViewById(R.id.idBtnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = "", number = "";

                if(!edtName.getText().toString().equals("")){
                     name = edtName.getText().toString();
                }else{
                    Toast.makeText(MainActivity.this, "Name is mandatory", Toast.LENGTH_SHORT).show();
                }
                if(!edtNumber.getText().toString().equals("")){
                     number = edtNumber.getText().toString();
                }else {
                    Toast.makeText(MainActivity.this, "Number is mandatory", Toast.LENGTH_SHORT).show();
                }

                arrContacts.add(new ContactModel(name,number));
                recyclerContactAdapter.notifyItemInserted(arrContacts.size()-1);
                recyclerView.scrollToPosition(arrContacts.size()-1);
                dialog.dismiss();
            }
        });
              dialog.show();
            }
        });




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

        recyclerContactAdapter = new RecyclerContactAdapter(this,arrContacts);
        recyclerView.setAdapter(recyclerContactAdapter);

    }
}