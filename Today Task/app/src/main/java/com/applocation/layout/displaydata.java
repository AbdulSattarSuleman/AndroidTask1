package com.applocation.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class displaydata extends AppCompatActivity {

    public TextView name, listviewdata;
    public Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaydata);
        name = (TextView)findViewById(R.id.outputname);
        listviewdata = (TextView)findViewById(R.id.outputlistview);
        back = (Button)findViewById(R.id.back);

        Bundle extras = getIntent().getExtras();
        String Name = extras.getString("Name");
        String ListItem = extras.getString("ListItem");

        name.setText(Name);
        listviewdata.setText(ListItem);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backActivity();
            }
        });
    }
    public  void backActivity(){
        Intent intent = new Intent(displaydata.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
