package cn.edu.bistu.cs.se.words;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import cn.edu.bistu.cs.se.words.wordcantract.Words;



public class WordsDBHelper extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "wordsdb";
    private final static int DATABASE_VERSION = 1;
    private final static String SQL_CREATE_DATABASE = "CREATE TABLE " + Words.Word.TABLE_NAME + " (" +
            Words.Word._ID + " VARCHAR(32) PRIMARY KEY NOT NULL," +
            Words.Word.COLUMN_NAME_WORD + " TEXT UNIQUE NOT NULL,"+
            Words.Word.COLUMN_NAME_MEANING + " TEXT,"
            + Words.Word.COLUMN_NAME_SAMPLE + " TEXT)";

    private final static String SQL_DELETE_DATABASE = "DROP TABLE IF EXISTS " + Words.Word.TABLE_NAME;

    public WordsDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_DATABASE);       //创建数据库
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        //当数据库升级时被调用，首先删除旧表，然后调用OnCreate()创建新表
        sqLiteDatabase.execSQL(SQL_DELETE_DATABASE);
        onCreate(sqLiteDatabase);
    }
}