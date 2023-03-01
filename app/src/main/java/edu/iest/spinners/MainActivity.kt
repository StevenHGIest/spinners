package edu.iest.spinners

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import edu.iest.spinners.databinding.ActivityMainBinding

class MainActivity : Activity()  {

    private var numero1: Int? = null
    private var numero2: Int? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val adaptador1 = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item)
        val adaptador2 = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item)

        binding.spinner.adapter = adaptador1
        binding.spinner2.adapter = adaptador2
        binding.bnEvaluar.setOnClickListener {
            var sp1 = binding.spinner.selectedItem.toString().toInt()
            var sp2 = binding.spinner2.selectedItem.toString().toInt()

            val alerta = AlertDialog.Builder(this)
            alerta.setTitle("Alerta")
                .setMessage("Desea evaluar?")
                .setCancelable(false)
                .setPositiveButton("Si", DialogInterface.OnClickListener { dialogInterface, i ->
                    val msg = comparar(sp1, sp2)
                    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
                })
                .setNegativeButton("no", DialogInterface.OnClickListener{ dialogInterface, i ->  }).show()
        }
    }

    fun comparar(n1:Int, n2:Int): String {
        if (n1 == n2){
            return "Los numeros son iguales"
        }
        if (n1 > n2) {
            return "$n1 es mayor que $n2"
        }
        return "$n2 es mayor que $n1"
    }

}