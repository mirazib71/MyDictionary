package com.example.mirazib.my_dictionary_1_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mirazib.my_dictionary_1_test.Database.DatabaseHandler;

public class Bmark_show_second_Activity extends AppCompatActivity {


    DatabaseHandler db;
    Dictmodel model;

    private Button btn_bmark,btn_home;
    private TextView tv_word_view,tv_mening_view;
    private  String wordcatch;
    int src_id;
    String src_word;
    String src_meaning;

    private void uifind()
    {
        btn_bmark=(Button)findViewById(R.id.btn_bmark);
        btn_home=(Button)findViewById(R.id.btn_home);
        tv_word_view=(TextView)findViewById(R.id.tv_word_view);
        tv_mening_view=(TextView)findViewById(R.id.tv_mening_view);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmark_show_second);

        //>>>>>>>>>>>>> start >>>>>>>>>>  MY_DICTIONARY_1_TEST

        db=new DatabaseHandler(this);

        uifind();
        //back_home();
        tv_word_view.setText(getIntent().getStringExtra("name"));

        wordcatch=tv_word_view.getText().toString();
        getmodel(wordcatch);

        src_id=model.getId();
        src_word=tv_word_view.getText().toString();
        src_meaning=model.getMeaning().toString();

        //bookmark();
        deletefun();


    }
    //>>> ONCREATE >>>>>>>>>>>


//    private void back_home()
//    {
//        btn_home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent myintent=new Intent(getApplicationContext(), Show_bookmark_list_Activity.class);
//
//                startActivity(myintent);
//                finish();
//
//            }
//        });
//
//    }


    private void getmodel(String wordcatch)
    {

        if(wordcatch.equals(""))
        {
            Toast.makeText (getApplicationContext(),"Information Missing",Toast.LENGTH_SHORT).show();
        }
        else{
            model=db.getDictmodel_bmark(wordcatch);
            String result = "";
            if(model == null)
            {
                result = "No contact to display.";
            }
            else{
                result +=model.getMeaning();
            }
            tv_mening_view.setText(result);
        }

    }

    private void bookmark()
    {

        btn_bmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String wordvalue= src_word;
                String meaningvalue=src_meaning;
                if(wordvalue.equals("") || meaningvalue.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Information missing",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    db.addDictmodel_bmark(new Dictmodel_bmark(wordvalue,meaningvalue));
                    Toast.makeText (getApplicationContext(),"Added to Bookmark.",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


    private void deletefun()
    {

        btn_bmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String contactIdValue= src_id+"";
                if(contactIdValue.equals(""))
                {
                    Toast.makeText (getApplicationContext(),"Information Missing",Toast.LENGTH_SHORT).show();
                }
                else{
                    db.deleteDictmodel_bmark(Integer.parseInt(contactIdValue));
                    Toast.makeText (getApplicationContext(),"Removed From BookMark",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


    //<<<<<<<<<<<<<<<<<<<<< last one >>>>>>>>>>>
}
