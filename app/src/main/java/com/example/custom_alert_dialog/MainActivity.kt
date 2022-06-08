package com.example.custom_alert_dialog

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    @SuppressLint("InflateParams")

    private lateinit var btnKenalan: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnKenalan = findViewById<Button>(R.id.btnKenalan)

        btnKenalan.setOnClickListener{
            val inflateView = layoutInflater.inflate(R.layout.layout_alert_dialog, null)
            val etNama = inflateView.findViewById<EditText>(R.id.etNama)
            val alb = AlertDialog.Builder(this@MainActivity)
            with(alb) {
                setTitle("Mau kenalan?")
                setIcon(R.drawable.maskot_kotlin)
                setView(inflateView)
                setCancelable(false)
                setPositiveButton("Selesai") { _, _ ->
                    val nama = if ("${etNama.text}".isNotEmpty()) "${etNama.text}" else "orang asing"
                    Toast.makeText(this@MainActivity, "Salam kenal, $nama!" , Toast.LENGTH_SHORT).show()
                }
                setNegativeButton("Siape lu?") { _, _ ->
                    Toast.makeText(this@MainActivity, "Sombong amat sih!", Toast.LENGTH_SHORT).show()
                }
                setNeutralButton("Maaf, cuma numpang lewat", null)
                create().show()
            }
        }
    }
}