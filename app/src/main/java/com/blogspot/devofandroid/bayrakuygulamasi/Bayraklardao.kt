package com.blogspot.devofandroid.bayrakuygulamasi

class Bayraklardao {
    fun rastgelebayrakgetir(vt:VeritabaniYardimcisi) : ArrayList<Bayraklar> {
        val bayrakliste = ArrayList<Bayraklar>()
        val db = vt.writableDatabase
        val c=db.rawQuery("SELECT * FROM bayraklar ORDER BY RANDOM() LIMIT 5", null)
        while (c.moveToNext()){
            val bayrak = Bayraklar(c.getInt(c.getColumnIndexOrThrow("bayrak_id")),
                c.getString(c.getColumnIndexOrThrow("bayrak_ad")),
                c.getString(c.getColumnIndexOrThrow("bayrak_resim")))
            bayrakliste.add(bayrak)
        }
        return bayrakliste
    }


    fun rastgeleyanlissecenekgetir(vt:VeritabaniYardimcisi,bayrak_id:Int) : ArrayList<Bayraklar> {
        val bayrakliste = ArrayList<Bayraklar>()
        val db = vt.writableDatabase
        val c=db.rawQuery("SELECT * FROM bayraklar WHERE bayrak_id != $bayrak_id ORDER BY RANDOM() LIMIT 5", null)
        while (c.moveToNext()){
            val bayrak = Bayraklar(c.getInt(c.getColumnIndexOrThrow("bayrak_id")),
                c.getString(c.getColumnIndexOrThrow("bayrak_ad")),
                c.getString(c.getColumnIndexOrThrow("bayrak_resim")))
            bayrakliste.add(bayrak)
        }
        return bayrakliste
    }
}