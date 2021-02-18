package com.example.mirazib.my_dictionary_1_test;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mirazib.my_dictionary_1_test.Database.DatabaseHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Quiz extends AppCompatActivity {

    DatabaseHandler db;

    ArrayList<String> arr;

    private TextView tv_question,tv_point_wrong,tv_point_correct;
    private Button btn_next;
    private CheckedTextView ctv1,ctv2,ctv3,ctv4;

    private String question,ques_meaning_1,meaning_2,meaning_3,meaning_4;
    private int rnum1,rnum2,rnum3,rnum4;
    private String ctv_txt_1,ctv_txt_2,ctv_txt_3,ctv_txt_4;
    private int green_point=0,red_point=0;

    private int flag=0;


    private void uifind()
    {
        tv_question=(TextView)findViewById(R.id.tv_question);
        tv_point_wrong=(TextView)findViewById(R.id.tv_point_wrong);
        tv_point_correct=(TextView)findViewById(R.id.tv_point_correct);

        btn_next=(Button)findViewById(R.id.btn_next);

        ctv1=(CheckedTextView)findViewById(R.id.ctv1);
        ctv2=(CheckedTextView)findViewById(R.id.ctv2);
        ctv3=(CheckedTextView)findViewById(R.id.ctv3);
        ctv4=(CheckedTextView)findViewById(R.id.ctv4);

    }


    private void set_rnum1_fun()
    {
        Dictmodel model=db.getDictmodel_ID(rnum1);

        question=model.getWord().trim();
        ques_meaning_1=model.getMeaning().trim();

    }

    private void set_rnum2_fun()
    {
        Dictmodel model=db.getDictmodel_ID(rnum2);

        meaning_2=model.getMeaning().trim();

    }

    private void set_rnum3_fun()
    {
        Dictmodel model=db.getDictmodel_ID(rnum3);

        meaning_3=model.getMeaning().trim();

    }

    private void set_rnum4_fun()
    {
        Dictmodel model=db.getDictmodel_ID(rnum4);

        meaning_4=model.getMeaning().trim();

    }

    private void prev_state()
    {
        //color

        ctv1.setBackgroundColor(Color.parseColor("#f4e9f9"));
        ctv1.setTextColor(Color.parseColor("#270404"));

        ctv2.setBackgroundColor(Color.parseColor("#f4e9f9"));
        ctv2.setTextColor(Color.parseColor("#270404"));

        ctv3.setBackgroundColor(Color.parseColor("#f4e9f9"));
        ctv3.setTextColor(Color.parseColor("#270404"));

        ctv4.setBackgroundColor(Color.parseColor("#f4e9f9"));
        ctv4.setTextColor(Color.parseColor("#270404"));

        ctv1.setChecked(false);
        ctv2.setChecked(false);
        ctv3.setChecked(false);
        ctv4.setChecked(false);

        ctv1.setEnabled(true);
        ctv2.setEnabled(true);
        ctv3.setEnabled(true);
        ctv4.setEnabled(true);

    }

    private void enabled_false()
    {
        ctv1.setEnabled(false);
        ctv2.setEnabled(false);
        ctv3.setEnabled(false);
        ctv4.setEnabled(false);

        btn_next.setEnabled(true);
    }


    private void green_point_incre_fun()
    {
        ++green_point;
        String point;
        if(green_point<10)
        {
            point="0"+green_point;
        }
        else
        {
            point=green_point+"";
        }

        tv_point_correct.setText(point);

    }

    private void red_point_incre_fun()
    {
        ++red_point;
        String point;
        if(red_point<10)
        {
            point="0"+red_point;
        }
        else
        {
            point=red_point+"";
        }

        tv_point_wrong.setText(point);

    }

    private void find_corrcet_1()
    {
        if(ctv_txt_2.equals(ques_meaning_1))
        {
            ctv2.setBackgroundColor(Color.parseColor("#e3fbec"));
            ctv2.setTextColor(Color.parseColor("#0a640b"));
        }

        else if(ctv_txt_3.equals(ques_meaning_1))
        {
            ctv3.setBackgroundColor(Color.parseColor("#e3fbec"));
            ctv3.setTextColor(Color.parseColor("#0a640b"));
        }

        else if(ctv_txt_4.equals(ques_meaning_1))
        {
            ctv4.setBackgroundColor(Color.parseColor("#e3fbec"));
            ctv4.setTextColor(Color.parseColor("#0a640b"));
        }

    }

    private void find_corrcet_2()
    {

        if(ctv_txt_1.equals(ques_meaning_1))
        {
            ctv1.setBackgroundColor(Color.parseColor("#e3fbec"));
            ctv1.setTextColor(Color.parseColor("#0a640b"));

        }

        else if(ctv_txt_3.equals(ques_meaning_1))
        {
            ctv3.setBackgroundColor(Color.parseColor("#e3fbec"));
            ctv3.setTextColor(Color.parseColor("#0a640b"));
        }

        else if(ctv_txt_4.equals(ques_meaning_1))
        {
            ctv4.setBackgroundColor(Color.parseColor("#e3fbec"));
            ctv4.setTextColor(Color.parseColor("#0a640b"));
        }

    }

    private void find_corrcet_3()
    {

        if(ctv_txt_1.equals(ques_meaning_1))
        {
            ctv1.setBackgroundColor(Color.parseColor("#e3fbec"));
            ctv1.setTextColor(Color.parseColor("#0a640b"));

        }

        else if(ctv_txt_2.equals(ques_meaning_1))
        {
            ctv2.setBackgroundColor(Color.parseColor("#e3fbec"));
            ctv2.setTextColor(Color.parseColor("#0a640b"));
        }

        else if(ctv_txt_4.equals(ques_meaning_1))
        {
            ctv4.setBackgroundColor(Color.parseColor("#e3fbec"));
            ctv4.setTextColor(Color.parseColor("#0a640b"));
        }

    }

    private void find_corrcet_4()
    {

        if(ctv_txt_1.equals(ques_meaning_1))
        {
            ctv1.setBackgroundColor(Color.parseColor("#e3fbec"));
            ctv1.setTextColor(Color.parseColor("#0a640b"));

        }

        else if(ctv_txt_2.equals(ques_meaning_1))
        {
            ctv2.setBackgroundColor(Color.parseColor("#e3fbec"));
            ctv2.setTextColor(Color.parseColor("#0a640b"));
        }

        else if(ctv_txt_3.equals(ques_meaning_1))
        {
            ctv3.setBackgroundColor(Color.parseColor("#e3fbec"));
            ctv3.setTextColor(Color.parseColor("#0a640b"));
        }

    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // >>>> start >>>>>


            db = new DatabaseHandler(getApplicationContext());
            uifind();
            btn_next.setEnabled(false);


            Random ran = new Random();
            rnum1 = (ran.nextInt(734567) % 200 + 1) + (ran.nextInt(5432) % 100 + 1) + (ran.nextInt(63456) % 100 + 1) + (ran.nextInt(96789) % 170 + 1);
            rnum2 = (ran.nextInt(734567) % 200 + 1) + (ran.nextInt(5432) % 100 + 1) + (ran.nextInt(63456) % 100 + 1) + (ran.nextInt(96789) % 170 + 1);
            rnum3 = (ran.nextInt(734567) % 200 + 1) + (ran.nextInt(5432) % 100 + 1) + (ran.nextInt(63456) % 100 + 1) + (ran.nextInt(96789) % 170 + 1);
            rnum4 = (ran.nextInt(734567) % 200 + 1) + (ran.nextInt(5432) % 100 + 1) + (ran.nextInt(63456) % 100 + 1) + (ran.nextInt(96789) % 170 + 1);

            set_rnum1_fun();
            set_rnum2_fun();
            set_rnum3_fun();
            set_rnum4_fun();

            arr = new ArrayList<>();
            arr.add(ques_meaning_1);
            arr.add(meaning_2);
            arr.add(meaning_3);
            arr.add(meaning_4);

            Collections.shuffle(arr);
            Collections.shuffle(arr);

            tv_question.setText(question);

            ctv1.setText(arr.get(0));
            ctv2.setText(arr.get(1));
            ctv3.setText(arr.get(2));
            ctv4.setText(arr.get(3));

            ctv_txt_1 = ctv1.getText().toString();
            ctv_txt_2 = ctv2.getText().toString();
            ctv_txt_3 = ctv3.getText().toString();
            ctv_txt_4 = ctv4.getText().toString();


            ctv1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    ctv1.setChecked(true);
                    enabled_false();

                    if (ctv_txt_1.equals(ques_meaning_1)) {
                        ctv1.setBackgroundColor(Color.parseColor("#e3fbec"));
                        ctv1.setTextColor(Color.parseColor("#0a640b"));

                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();

                        green_point_incre_fun();

                    } else {
                        ctv1.setTextColor(Color.parseColor("#b00309"));
                        Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();

                        red_point_incre_fun();

                        find_corrcet_1();

                    }


                }
            });

            ctv2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    ctv2.setChecked(true);
                    enabled_false();

                    if (ctv_txt_2.equals(ques_meaning_1)) {
                        ctv2.setBackgroundColor(Color.parseColor("#e3fbec"));
                        ctv2.setTextColor(Color.parseColor("#0a640b"));

                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();

                        green_point_incre_fun();

                    } else {
                        ctv2.setTextColor(Color.parseColor("#b00309"));
                        Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();

                        red_point_incre_fun();

                        find_corrcet_2();

                    }


                }
            });


            ctv3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    ctv3.setChecked(true);
                    enabled_false();

                    if (ctv_txt_3.equals(ques_meaning_1)) {
                        ctv3.setBackgroundColor(Color.parseColor("#e3fbec"));
                        ctv3.setTextColor(Color.parseColor("#0a640b"));

                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();

                        green_point_incre_fun();

                    } else {
                        ctv3.setTextColor(Color.parseColor("#b00309"));
                        Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();

                        red_point_incre_fun();

                        find_corrcet_3();

                    }


                }
            });


            ctv4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    ctv4.setChecked(true);
                    enabled_false();

                    if (ctv_txt_4.equals(ques_meaning_1)) {
                        ctv4.setBackgroundColor(Color.parseColor("#e3fbec"));
                        ctv4.setTextColor(Color.parseColor("#0a640b"));

                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();

                        green_point_incre_fun();

                    } else {
                        ctv4.setTextColor(Color.parseColor("#b00309"));
                        Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();

                        red_point_incre_fun();

                        find_corrcet_4();

                    }

                }
            });


            // <<<<<<<<<<<<<<<<<<<  onClick For BTN_NEXT >>>>>>>>>>>>>>>>


            btn_next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    flag=1;

                    prev_state();
                    btn_next.setEnabled(false);

                    do {

                        flag=0;

                        db = new DatabaseHandler(getApplicationContext());
                        uifind();

                        Random ran = new Random();
                        rnum1 = (ran.nextInt(734567) % 200 + 1) + (ran.nextInt(5432) % 100 + 1) + (ran.nextInt(63456) % 100 + 1) + (ran.nextInt(96789) % 170 + 1);
                        rnum2 = (ran.nextInt(734567) % 200 + 1) + (ran.nextInt(5432) % 100 + 1) + (ran.nextInt(63456) % 100 + 1) + (ran.nextInt(96789) % 170 + 1);
                        rnum3 = (ran.nextInt(734567) % 200 + 1) + (ran.nextInt(5432) % 100 + 1) + (ran.nextInt(63456) % 100 + 1) + (ran.nextInt(96789) % 170 + 1);
                        rnum4 = (ran.nextInt(734567) % 200 + 1) + (ran.nextInt(5432) % 100 + 1) + (ran.nextInt(63456) % 100 + 1) + (ran.nextInt(96789) % 170 + 1);

                        set_rnum1_fun();
                        set_rnum2_fun();
                        set_rnum3_fun();
                        set_rnum4_fun();

                        arr = new ArrayList<>();
                        arr.add(ques_meaning_1);
                        arr.add(meaning_2);
                        arr.add(meaning_3);
                        arr.add(meaning_4);

                        Collections.shuffle(arr);
                        Collections.shuffle(arr);

                        tv_question.setText(question);

                        ctv1.setText(arr.get(0));
                        ctv2.setText(arr.get(1));
                        ctv3.setText(arr.get(2));
                        ctv4.setText(arr.get(3));

                        ctv_txt_1 = ctv1.getText().toString();
                        ctv_txt_2 = ctv2.getText().toString();
                        ctv_txt_3 = ctv3.getText().toString();
                        ctv_txt_4 = ctv4.getText().toString();


                        ctv1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                ctv1.setChecked(true);
                                enabled_false();

                                if (ctv_txt_1.equals(ques_meaning_1)) {
                                    ctv1.setBackgroundColor(Color.parseColor("#e3fbec"));
                                    ctv1.setTextColor(Color.parseColor("#0a640b"));

                                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();

                                    green_point_incre_fun();

                                } else {
                                    ctv1.setTextColor(Color.parseColor("#b00309"));
                                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();

                                    red_point_incre_fun();

                                    find_corrcet_1();

                                }


                            }
                        });

                        ctv2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                ctv2.setChecked(true);
                                enabled_false();

                                if (ctv_txt_2.equals(ques_meaning_1)) {
                                    ctv2.setBackgroundColor(Color.parseColor("#e3fbec"));
                                    ctv2.setTextColor(Color.parseColor("#0a640b"));

                                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();

                                    green_point_incre_fun();

                                } else {
                                    ctv2.setTextColor(Color.parseColor("#b00309"));
                                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();

                                    red_point_incre_fun();

                                    find_corrcet_2();

                                }


                            }
                        });


                        ctv3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                ctv3.setChecked(true);
                                enabled_false();

                                if (ctv_txt_3.equals(ques_meaning_1)) {
                                    ctv3.setBackgroundColor(Color.parseColor("#e3fbec"));
                                    ctv3.setTextColor(Color.parseColor("#0a640b"));

                                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();

                                    green_point_incre_fun();

                                } else {
                                    ctv3.setTextColor(Color.parseColor("#b00309"));
                                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();

                                    red_point_incre_fun();

                                    find_corrcet_3();

                                }

                            }
                        });


                        ctv4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                ctv4.setChecked(true);
                                enabled_false();

                                if (ctv_txt_4.equals(ques_meaning_1)) {
                                    ctv4.setBackgroundColor(Color.parseColor("#e3fbec"));
                                    ctv4.setTextColor(Color.parseColor("#0a640b"));

                                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();

                                    green_point_incre_fun();

                                } else {
                                    ctv4.setTextColor(Color.parseColor("#b00309"));
                                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();

                                    red_point_incre_fun();

                                    find_corrcet_4();

                                }

                            }
                        });




                    }while (flag==1);


                }
            });
            //>>>>>>>>>>> BTN_NEXT END



    }
    //>>>>>>> ONCREAT >>>>>>>>>

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.activity_quiz, menu);
        return true;
    }





}





