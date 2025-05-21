package vcmsa.ci.flashcardapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btnStart: Button = findViewById<Button>(R.id.button)
        val txtStart: TextView = findViewById<TextView>(R.id.tetxt3)

        btnStart.setOnClickListener{

            val intent =  Intent(this, MainActivity4::class.java)
            startActivity(intent)
        }
    }
}