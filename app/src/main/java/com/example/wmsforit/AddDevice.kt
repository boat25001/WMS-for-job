package com.example.wmsforit

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class AddDevice : AppCompatActivity() {

    // Initialize variable
    var textview: TextView? = null
    var arrayList: ArrayList<String>? = null
    var dialog: Dialog? = null

    @SuppressLint("MissingInflatedId", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_device)

        // assign variable
        textview = findViewById(R.id.bt_Select_course)


        // initialize array list
        // initialize array list
        arrayList = ArrayList()

        // set value in array list

        // set value in array list
        arrayList!!.addAll(listOf("UPS","Cashier printer","Barcode printer","Cash Drawer","Price Checker","Printer HP Deskjet","Monitor PC","Battery UPS","Cashier Scanner","Zebex scanner","Switch network"))

        textview?.setOnClickListener(View.OnClickListener {
            // Initialize dialog
            dialog = Dialog(this@AddDevice)

            // set custom dialog
            dialog!!.setContentView(R.layout.dialog_searchable_spinner)

            // set custom height and width
            dialog!!.window!!.setLayout(900, 1500)

            // set transparent background
            dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            // show dialog
            dialog!!.show()

            // Initialize and assign variable
            val editText = dialog!!.findViewById<EditText>(R.id.edit_text)
            val listView = dialog!!.findViewById<ListView>(R.id.list_view)

            // Initialize array adapter
            val adapter = ArrayAdapter<String>(
                this@AddDevice, R.layout.text_color_layout,
                arrayList!!
            )

            // set adapter
            listView.adapter = adapter
            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    adapter.filter.filter(s)
                }

                override fun afterTextChanged(s: Editable) {}
            })
            listView.onItemClickListener =
                OnItemClickListener { parent, view, position, id -> // when item selected from list
                    // set selected item on textView
                    textview!!.text = adapter.getItem(position)

                    // Dismiss dialog
                    dialog!!.dismiss()
                }

        })


    }
}