package com.example.sakshi.displaydatabase_acad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    TextView textView;
    DataHandler dataHandler;
    ArrayList<Data> datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        dataHandler = new DataHandler(Main2Activity.this);
        datas = new ArrayList<>();
        textView = (TextView) findViewById(R.id.data);
        //getting all data from the database
        datas = dataHandler.getAlldata();
        //is the array list is not empty
        if (!datas.isEmpty()) {

            StringBuilder stringBuilderFull, stringBuilderemployee;
            stringBuilderFull = new StringBuilder();


            for (int i = 0; i < datas.size(); i++) {
                Data data = (Data) datas.get(i);
                stringBuilderemployee = new StringBuilder()
                        .append(data.getId()).append("    ")
                        .append(data.getFirst_name()).append("     ")
                        .append(data.getLast_name())
                        .append("\n").append("\n");
                stringBuilderFull.append(stringBuilderemployee);
            }
            //setting data in the text view
            textView.setText(stringBuilderFull);
        }
        else{
            Toast.makeText(this, "No data in database", Toast.LENGTH_SHORT).show();
        }
    }
}
