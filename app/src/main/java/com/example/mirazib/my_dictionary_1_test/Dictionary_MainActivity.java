package com.example.mirazib.my_dictionary_1_test;

import com.example.mirazib.my_dictionary_1_test.Database.*;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Dictionary_MainActivity extends AppCompatActivity {

    DatabaseHandler db;
    Cursor data;
    ArrayList<String> theList ;

    private Button btn_bmark,btn_quiz,btn_edit;
    private ListView listView;
    private SearchView searchview;



    private void uifind()
    {

        btn_bmark=(Button)findViewById(R.id.btn_bmark);
        btn_quiz=(Button)findViewById(R.id.btn_quiz);
        btn_edit=(Button)findViewById(R.id.btn_edit);
        listView=(ListView)findViewById(R.id.listview);
        searchview=(SearchView) findViewById(R.id.searchview);

    }


    //populating arrylist
    private void populatelistfunc()
    {

        theList = new ArrayList<>();
        Cursor data = db.getListDictmodel();
        if(data.getCount() == 0){
            Toast.makeText(getApplicationContext(), "There are no words in this list!",Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()){
                theList.add(data.getString(1));
            }
        }


    }


    private void editintent()
    {
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Editdictmodel.class);
                startActivity(intent);
            }
        });
    }

    private void bmark_intent()
    {
        btn_bmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Show_bookmark_list_Activity.class);
                startActivity(intent);
            }
        });
    }

    private void quiz_intent()
    {
        btn_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Quiz.class);
                startActivity(intent);
            }
        });
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary_main2);

        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        db=new DatabaseHandler(this);
        uifind();

       searchview.setQueryHint("Search Here");
       searchview.setQueryRefinementEnabled(true);

        editintent();
        bmark_intent();
        quiz_intent();

        populatelistfunc();

        final ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,theList);
        listView.setAdapter(arrayAdapter);

        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                arrayAdapter.getFilter().filter(s);
                return false;
            }
        });

        clicklist();




    }
    // >>>>>>>>>>> onCreate >>>>>>>>




    // >>>>>>>>>>> ONRESUME >>>>>>>>
    @Override
    public void onResume()
    {  // After a pause OR at startup
        super.onResume();


        db=new DatabaseHandler(this);
        uifind();

        searchview.setQueryHint("Search Here");
        searchview.setQueryRefinementEnabled(true);

        editintent();
        bmark_intent();

        populatelistfunc();

        final ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,theList);
        listView.setAdapter(arrayAdapter);

        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                arrayAdapter.getFilter().filter(s);
                return false;
            }
        });

        clicklist();




    }

    /* >>>>>>>>>>> ONRESUME >>>>>>>> */









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
                Intent myintent=new Intent(getApplicationContext(), Main_to_show_second_Activity.class);

                myintent.putExtra("name",newword);

                startActivity(myintent);
                // }
            }
        });

    }





// last one
}
