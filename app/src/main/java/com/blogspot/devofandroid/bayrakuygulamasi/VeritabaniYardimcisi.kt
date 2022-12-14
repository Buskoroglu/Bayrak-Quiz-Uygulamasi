package com.blogspot.devofandroid.bayrakuygulamasi

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class VeritabaniYardimcisi(context: Context) : SQLiteOpenHelper(context, "bayrakQuiz.db", null,1){

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(" CREATE TABLE \"bayraklar\" (\n" +
                "\t\"bayrak_id\"\tINTEGER,\n" +
                "\t\"bayrak_ad\"\tTEXT,\n" +
                "\t\"bayrak_resim\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"bayrak_id\")\n" +
                ");")
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS bayraklar")
        onCreate(db)
    }
}