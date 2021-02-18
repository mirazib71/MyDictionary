package com.example.mirazib.my_dictionary_1_test.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.mirazib.my_dictionary_1_test.Dictmodel;
import com.example.mirazib.my_dictionary_1_test.Dictmodel_bmark;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by M.I.RAZIB on 2/1/2018.
 */

public class DatabaseHandler extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="mydictionary.db";

    private static final String TABLE_NAME="total_words";

    private static final String KEY_ID="id";
    private static final String KEY_WORD="word";
    private static final String KEY_MEANING="meaning";

    private static final String TABLE_NAME_BMARK="bmark_words";

    private static final String KEY_ID_BMARK="idbmark";
    private static final String KEY_WORD_BMARK="wordbmark";
    private static final String KEY_MEANING_BMARK="meaningbmark";

    public static final String SQL_TABLE_USERS = " CREATE TABLE " + TABLE_NAME
            + " ( "
            + KEY_ID + " INTEGER PRIMARY KEY, "
            + KEY_WORD + " TEXT, "
            + KEY_MEANING + " TEXT"
            + " ) ";


    private static final String SQL_TABLE_BMARKS = "CREATE TABLE "
            + TABLE_NAME_BMARK + "(" + KEY_ID_BMARK + " INTEGER PRIMARY KEY," + KEY_WORD_BMARK
            + " TEXT," + KEY_MEANING_BMARK + " TEXT" + ")";



    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(SQL_TABLE_USERS);
        sqLiteDatabase.execSQL(SQL_TABLE_BMARKS);

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME_BMARK);

        onCreate(sqLiteDatabase);

    }


    //. >>>>>>>   MAIN TABLE FUNCTIONS <<<<<<<<<<<<


    // adding dictmodel for edit_dictmodel
    public void addDictmodel(Dictmodel model)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_WORD, model.getWord());
        values.put(KEY_MEANING, model.getMeaning());

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    // Getting one Dictmodel  for edit_dictmodel
    public Dictmodel getDictmodel(String word ) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[] { KEY_ID,
                        KEY_WORD, KEY_MEANING }, KEY_WORD + "=?",
                new String[] {word}, null, null, null, null);

        Dictmodel mymodel=null;

        if (cursor.moveToFirst())
        {
             mymodel = new Dictmodel(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2));

        }
        return mymodel;
    }

    // Getting one Dictmodel by id  for quiz
    public Dictmodel getDictmodel_ID(int id ) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[] { KEY_ID,
                        KEY_WORD, KEY_MEANING }, KEY_ID + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);

        Dictmodel mymodel=null;

        if (cursor.moveToFirst())
        {
            mymodel = new Dictmodel(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2));

        }
        return mymodel;
    }







    // getting all dictmodel for edit_dictmodel
    public List<Dictmodel> getAllDictmodel()
    {
        List<Dictmodel> mymodellist=new ArrayList<Dictmodel>();

        String selectquery="SELECT * FROM "+ TABLE_NAME;

        Log.i("info","selectquery: passed****");

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery(selectquery, null);

        if(cursor.moveToFirst())
        {
            do
            {
                Dictmodel mymodel= new Dictmodel(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2));
                mymodellist.add(mymodel);
            }while(cursor.moveToNext());
        }

        return mymodellist;
    }

    // Updating a Dictmodel  for edit_dictmodel
    public boolean updateDictmodel(Dictmodel model) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_WORD, model.getWord());
        values.put(KEY_MEANING, model.getMeaning());

        db.update(TABLE_NAME, values, KEY_ID + " = ?",
                new String[]{String.valueOf(model.getId())});
         return true;

    }


    //getting all for Listview
    public Cursor getListDictmodel(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;

    }

    //Delete from dictmodel

    public void deleteDictmodel(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        db.delete(TABLE_NAME, KEY_ID+"=?",
                new String[]{String.valueOf(id)});
        db.close();
    }







    //. >>>>>>>   BOOK_MARKS TABLE FUNCTIONS <<<<<<<<<<<<




    // adding dictmodel for edit_dictmodel_bmark
    public void addDictmodel_bmark(Dictmodel_bmark model)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_WORD_BMARK, model.getWord());
        values.put(KEY_MEANING_BMARK, model.getMeaning());

        db.insert(TABLE_NAME_BMARK, null, values);

        db.close();
    }

    // Getting one Dictmodel  for edit_dictmodel_bark
    public Dictmodel_bmark getDictmodel_bmark(String word ) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME_BMARK, new String[] { KEY_ID_BMARK,
                        KEY_WORD_BMARK, KEY_MEANING_BMARK }, KEY_WORD_BMARK + "=?",
                new String[] {word}, null, null, null, null);

        Dictmodel_bmark mymodel=null;

        if (cursor.moveToFirst())
        {
            mymodel = new Dictmodel_bmark(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2));

        }
        return mymodel;
    }

    // getting all dictmodel for edit_dictmodel_BMARK

    public List<Dictmodel_bmark> getAllDictmodel_bmark()
    {
        List<Dictmodel_bmark> mymodellist=new ArrayList<Dictmodel_bmark>();

        String selectquery="SELECT * FROM "+ TABLE_NAME_BMARK;

        Log.i("info","selectquery_bmark: passed****");

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery(selectquery, null);

        if(cursor.moveToFirst())
        {
            do
            {
                Dictmodel_bmark mymodel= new Dictmodel_bmark(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2));
                mymodellist.add(mymodel);
            }while(cursor.moveToNext());
        }

        return mymodellist;
    }

    // Updating a Dictmodel  for edit_dictmodel_BMARK

    public int updateDictmodel_bmark(Dictmodel_bmark model) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_WORD_BMARK, model.getWord());
        values.put(KEY_MEANING_BMARK, model.getMeaning());
        return db.update(TABLE_NAME_BMARK, values, KEY_ID_BMARK + " = ?",
                new String[]{String.valueOf(model.getId())});

    }


    //getting all for Listview_BMARK

    public Cursor getListDictmodel_bmark(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME_BMARK, null);
        return data;

    }

    //Delete from dictmodel_bmark

    public void deleteDictmodel_bmark(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        db.delete(TABLE_NAME_BMARK, KEY_ID_BMARK +"=?",
                new String[]{String.valueOf(id)});
        db.close();
    }













// last one
}
