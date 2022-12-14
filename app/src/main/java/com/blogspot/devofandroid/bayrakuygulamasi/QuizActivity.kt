package com.blogspot.devofandroid.bayrakuygulamasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {
    private lateinit var sorular : ArrayList<Bayraklar>
    private lateinit var yanlissecenek : ArrayList<Bayraklar>
    private lateinit var dogruSoru : Bayraklar
    private lateinit var tumsecenekler : HashSet<Bayraklar>
    private lateinit var vt :VeritabaniYardimcisi
    private var sorusayac = 0
    private var dogrusayac = 0
    private var yanlissayac = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        vt = VeritabaniYardimcisi(this)
        sorular= Bayraklardao().rastgelebayrakgetir(vt)
        soruyukle()
        buttonA.setOnClickListener {
            dogrukontrol(buttonA)
            sorusayackontrol()
        }
        buttonB.setOnClickListener {
            dogrukontrol(buttonB)
            sorusayackontrol()
        }
        buttonC.setOnClickListener {
            dogrukontrol(buttonC)
            sorusayackontrol()
        }
        buttonD.setOnClickListener {
            dogrukontrol(buttonD)
            sorusayackontrol()
        }
    }

    fun soruyukle(){
        textViewSoruSayi.text = "${sorusayac+1}.Soru"
        dogruSoru = sorular.get(sorusayac)
        imageViewBayrak.setImageResource(resources.getIdentifier(dogruSoru.bayrak_resim, "drawable", packageName))
        yanlissecenek = Bayraklardao().rastgeleyanlissecenekgetir(vt,dogruSoru.bayrak_id)
        tumsecenekler = HashSet()
        tumsecenekler.add(dogruSoru)
        tumsecenekler.add(yanlissecenek.get(0))
        tumsecenekler.add(yanlissecenek.get(1))
        tumsecenekler.add(yanlissecenek.get(2))
        tumsecenekler.add(yanlissecenek.get(3))

        buttonA.text=tumsecenekler.elementAt(0).bayrak_ad
        buttonB.text=tumsecenekler.elementAt(1).bayrak_ad
        buttonC.text=tumsecenekler.elementAt(2).bayrak_ad
        buttonD.text=tumsecenekler.elementAt(3).bayrak_ad
    }

    fun sorusayackontrol(){
        sorusayac++
        if(sorusayac != 5)
        {
            soruyukle()

        }else{
            val intent= Intent(this@QuizActivity, ResultActivity::class.java)
            intent.putExtra("dogrusayac",dogrusayac)
            startActivity(intent)
            finish()
        }
    }

    fun dogrukontrol(button: Button)
    {
        val buttonyazi = button.text.toString()
        val dogrucevap = dogruSoru.bayrak_ad

        if(buttonyazi ==dogrucevap)
            dogrusayac++
        else
            yanlissayac++
        textViewDogru.text="Doğru : $dogrusayac"
        textViewYanlis.text="Yanış : $yanlissayac"
    }
}