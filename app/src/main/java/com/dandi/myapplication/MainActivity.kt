package com.dandi.myapplication

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var listOperasional = listOf("Perkalian", "Pembagian", "Penjumlahan", "Pengurangan")
    var operasi: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        btHitung.setOnClickListener(this)
        val adapterSp =
            ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, listOperasional)
        adapterSp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spOperasional.adapter = adapterSp
        spOperasional.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                operasi = listOperasional.get(p2)
            }
        }
    }

    override fun onClick(p0: View?) {
        when (p0) {
            btHitung -> {
                if (etA.text.isEmpty()) {
                    etA.error = "Tidak boleh kosong"
                } else if (etB.text.isEmpty()) {
                    etB.error = "Tidak boleh kosong"
                } else {
                    tvHasil.text =
                        "${hitung(
                            operasi,
                            etA.text.toString().toFloat(),
                            etB.text.toString().toFloat()
                        )}"
                }
            }
        }
    }

    private fun hitung(operasi: String, valueA: Float, valueB: Float): Float {
        if (etA.text.toString().isNotEmpty() && etB.text.toString().isNotEmpty()) {
            when (operasi) {
                "Penjumlahan" -> return valueA + valueB
                "Pengurangan" -> return valueA - valueB
                "Pembagian" -> return valueA / valueB
                "Perkalian" -> return valueA * valueB
            }
        }
        return 0f
    }
}