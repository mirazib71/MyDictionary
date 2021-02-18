package com.example.mirazib.my_dictionary_1_test;

import com.example.mirazib.my_dictionary_1_test.Database.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Editdictmodel extends AppCompatActivity {

    DatabaseHandler db;

    private EditText et_word,et_meaning,et_id_src,et_word_src;
    private TextView tv;
    private Button btn_add,btn_update,btn_delete,btn_src,btn_getall;
    private static String no_change_id;

    private void uifind()
    {
        et_word=(EditText) findViewById(R.id.et_word);
        et_meaning=(EditText) findViewById(R.id.et_meaning);
        et_id_src=(EditText) findViewById(R.id.et_id_src);
        et_word_src=(EditText) findViewById(R.id.et_word_src);

        tv=(TextView) findViewById(R.id.tv);

        btn_add=(Button) findViewById(R.id.btn_add);
        btn_update=(Button) findViewById(R.id.btn_update);
        btn_delete=(Button) findViewById(R.id.btn_delete);
        btn_src=(Button) findViewById(R.id.btn_src);
        btn_getall=(Button) findViewById(R.id.btn_getall);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editdictmodel);

        db=new DatabaseHandler(getApplicationContext());

        uifind();

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addfunctin();

            }
        });

        btn_getall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Dictmodel> mymodellist=db.getAllDictmodel();
                String result = "";
                for(Dictmodel mymodel : mymodellist)
                {
                    result +="Id: "+ mymodel.getId()+" WORD: "+mymodel.getWord()+" MEANING: "+ mymodel.getMeaning();
                    result +="\n";
                    Log.d("Result",result);
                }
                if(mymodellist.size()  == 0)
                {
                    result = "No contact to display.";
                }
                tv.setText(result);

            }
        });



        // search by one word .....
        btn_src.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wordvalue= et_word_src.getText().toString();
                if(wordvalue.equals(""))
                {
                    Toast.makeText (getApplicationContext(),"Information Missing",Toast.LENGTH_SHORT).show();

                }
                else{
                    Dictmodel model=db.getDictmodel(wordvalue);
                    String result = "";
                    if(model == null)
                    {
                        result = "No contact to display.";

                        Toast.makeText (getApplicationContext(),"Word Mismatched ",Toast.LENGTH_SHORT).show();

                        et_word.setText("");
                        et_meaning.setText("");
                        et_id_src.setText("");


                    }
                    else{
                        result +="Id: "+ model.getId()+" WORD: "+model.getWord()+" MEANING: "+ model.getMeaning();

                        et_word.setText(model.getWord().toString());
                        et_meaning.setText(model.getMeaning().toString());
                        et_id_src.setText(model.getId()+"");
                        no_change_id= model.getId()+"";

                    }
                    tv.setText(result);
                }

            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletefun();
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updatefunctin();

            }
        });







    }

    //>>>>>>>>>>> onCreate >>>>>>


    private void addfunctin()
    {
       String wordvalue= et_word.getText().toString();
       String meaningvalue=et_meaning.getText().toString();
       if(wordvalue.equals("") || meaningvalue.equals(""))
       {
           Toast.makeText(getApplicationContext(),"Information missing",Toast.LENGTH_SHORT).show();
       }
       else
       {
           db.addDictmodel(new Dictmodel(wordvalue,meaningvalue));
           Toast.makeText (getApplicationContext(),"New Contact Is Added.",Toast.LENGTH_SHORT).show();


           Dictmodel model=db.getDictmodel(wordvalue);
           no_change_id= model.getId()+"";


       }

    }


    private void deletefun()
    {
                String contactIdValue= et_id_src.getText().toString();
                if(contactIdValue.equals(""))
                {
                    Toast.makeText (getApplicationContext(),"Information Missing",Toast.LENGTH_SHORT).show();
                }
                else{
                    db.deleteDictmodel(Integer.parseInt(contactIdValue));
                    Toast.makeText (getApplicationContext(),contactIdValue+" is deleted",Toast.LENGTH_SHORT).show();
                }
    }



    private void updatefunctin()
    {
        String wordvalue= et_word.getText().toString();
        String meaningvalue=et_meaning.getText().toString();
        String id=et_id_src.getText().toString();


        if(wordvalue.equals("") || meaningvalue.equals("") || id.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Information missing",Toast.LENGTH_SHORT).show();
        }
//        else
//        {
//            db.updateDictmodel(new Dictmodel(Integer.parseInt(id),wordvalue,meaningvalue));
//            Toast.makeText (getApplicationContext(),"word is updated.",Toast.LENGTH_SHORT).show();
//        }

        else
        {

            if(id.equals(no_change_id)) {

                boolean isupdate = db.updateDictmodel(new Dictmodel(Integer.parseInt(id), wordvalue, meaningvalue));

                if (isupdate == true) {
                    Toast.makeText(getApplicationContext(), "Data Update", Toast.LENGTH_LONG).show();



                    Dictmodel model=db.getDictmodel(wordvalue);
                    String result = "";

                    result +="Id: "+ model.getId()+" WORD: "+model.getWord()+" MEANING: "+ model.getMeaning();
                    tv.setText(result);

                }

                else {
                    Toast.makeText(getApplicationContext(), " Information missing>>Data not Updated ", Toast.LENGTH_LONG).show();
                }

            }
            else
            {
                Toast.makeText(getApplicationContext(), " Please Don't Change Id Value ", Toast.LENGTH_LONG).show();

            }

        }

    }


    

// last one
}
