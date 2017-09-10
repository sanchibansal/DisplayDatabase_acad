package com.example.sakshi.displaydatabase_acad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button show, save;
    EditText first, last;
    DataHandler dataHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = (Button) findViewById(R.id.show);
        save = (Button) findViewById(R.id.insert);
        first = (EditText) findViewById(R.id.first);
        last = (EditText) findViewById(R.id.last);
        dataHandler = new DataHandler(MainActivity.this);
        //on click listener for show button
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //moves to the next activity
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
        //set on click listener for save button
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String first_name = first.getText().toString();
                String last_name = last.getText().toString();
                //inserting data in the database
                Boolean status=dataHandler.insert_Data(first_name,last_name);
                if(status){
                    //displays this toast if the data is inserted successfully
                    Toast.makeText(MainActivity.this, "Employee Data inserted", Toast.LENGTH_SHORT).show();
                }else{
                    //displays this if not
                    Toast.makeText(MainActivity.this,"Can not insert Data",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
