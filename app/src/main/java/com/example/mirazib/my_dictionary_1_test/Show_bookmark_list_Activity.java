package com.example.mirazib.my_dictionary_1_test;

import com.example.mirazib.my_dictionary_1_test.Database.*;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Show_bookmark_list_Activity extends AppCompatActivity {

    DatabaseHandler db;
    //Cursor data;
    ArrayList<String> bmarklist ;

    private ListView listView;


    private void populatelistfunc_bmark()
    {

        bmarklist = new ArrayList<>();
        Cursor data = db.getListDictmodel_bmark();
        if(data.getCount() == 0){
            Toast.makeText(getApplicationContext(), "There are no words in this list!",Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()){
                bmarklist.add(data.getString(1));
            }
        }


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bookmark_list);

        //>>>>>>>>>>>>>>> On cREATE >>>>>>>>>>>>>>>>>>>

        db=new DatabaseHandler(getApplicationContext());
        listView=(ListView)findViewById(R.id.listview);

        populatelistfunc_bmark();

        final ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,bmarklist);
        listView.setAdapter(arrayAdapter);

        clicklist();



    }
    //>>>>>>>>>>>>>>> On cREATE >>>>>>>>>>>>>>>>>>>



    // >>>>>>>>>>> ONRESUME >>>>>>>>
    @Override
    public void onResume()
    {  // After a pause OR at startup
        super.onResume();


        db=new DatabaseHandler(getApplicationContext());
        listView=(ListView)findViewById(R.id.listview);

        populatelistfunc_bmark();

        final ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,bmarklist);
        listView.setAdapter(arrayAdapter);

        clicklist();


    }
    // >>>>>>>>>>> ONRESUME END>>>>>>>>










    private void clicklist()
    {

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                TextView word=(TextView) view;
                String newword =word.getText().toString();
                int pos= i;

                //Toast.makeText(getApplicationContext(), "you clicked on"+newstr+" position : "+i , Toast.LENGTH_SHORT ).show();

                //if(i==pos)
                //{
                Intent myintent=new Intent(getApplicationContext(), Bmark_show_second_Activity.class);

                myintent.putExtra("name",newword);

                startActivity(myintent);
                // }
            }
        });

    }










 //last one
}
