package com.nicootech.aboutme2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.nicootech.aboutme2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
//        val button: Button = findViewById(R.id.done_button)
//        button.setOnClickListener {
//            action(it)
//        }
        binding.doneButton.setOnClickListener {
            action(it)
        }
    }

    private fun action(view:View) {
//        val textName :TextView=findViewById(R.id.textView)
//        val inputEdit:EditText = findViewById(R.id.input_edit)
        binding.apply {
            nameText.text = binding.inputEdit.text
            invalidateAll()
            inputEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nameText.visibility = View.VISIBLE
        }
        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }


}
