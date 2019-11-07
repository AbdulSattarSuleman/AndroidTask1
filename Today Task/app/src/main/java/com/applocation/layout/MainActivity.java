package com.applocation.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public ListView listView;
    public TextView text, nametxt;
    public String[] listItem;
    public Button close, next;
    public String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView =(ListView) findViewById(R.id.list);
        text = (TextView)findViewById(R.id.textView);
        nametxt = (TextView)findViewById(R.id.nametxt);
        listItem = getResources().getStringArray(R.array.coursesname);
        next = (Button)findViewById(R.id.gotonext);
        close =(Button)findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity();
            }
        });

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 value = adapter.getItem(position);
                Toast toast= Toast.makeText(getApplicationContext(),
                        nametxt.getText().toString()+"\n"+value, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM|Gravity.LEFT, 0, 140);
                toast.show();
            }
        });
    }
    public void nextActivity(){
        Intent intent = new Intent(MainActivity.this,displaydata.class);
            intent.putExtra("Name",nametxt.getText().toString());
            intent.putExtra("ListItem",value);
            startActivity(intent);
            finish();
    }


}
