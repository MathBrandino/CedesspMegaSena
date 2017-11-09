package br.com.caelum.myapplication

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var numeros : ArrayList<Int> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recarregaALista()

        add.setOnClickListener {
            val numero = Random().nextInt(60)

            Log.d("app", ""+numero + "foi gerado")
            val find : Int? = numeros.find { jaCadastrado -> jaCadastrado == numero }

            if (find == null){

                numeros.add(numero)
                recarregaALista()
            }

        }

        sms.setOnClickListener {

            val intent = Intent(Intent.ACTION_VIEW)

            var valores = ""

            numeros.forEach { numero -> valores + numero + ", " }

            intent.data = Uri.parse("sms:"+99999)
            intent.putExtra("sms_body",  valores)

            startActivity(intent)
        }
    }

    fun recarregaALista(){

        lista.adapter = ArrayAdapter<Int>(this, android.R.layout.simple_list_item_1, numeros)

    }
}
