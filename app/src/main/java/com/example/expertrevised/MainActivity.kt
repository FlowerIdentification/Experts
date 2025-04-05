package com.example.expertrevised

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.tensorflow.lite.Interpreter

class MainActivity : AppCompatActivity() {

    private var interpreter: Interpreter? = null
    private var model = Model()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val statusText = findViewById<TextView>(R.id.statusText)
        val button = findViewById<Button>(R.id.loadModelButton)

        button.setOnClickListener {
            // Load your model here
            interpreter = model.loadModelFile(this)

            if(interpreter == null){
                Toast.makeText(this, "Failed to load model", Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(this, "Model loaded successfully", Toast.LENGTH_SHORT).show()
            }
        }

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}