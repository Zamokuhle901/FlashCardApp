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


        class MainActivity3 : AppCompatActivity() {
            private lateinit var questions: Array<String>
            private lateinit var answers: Array<Boolean>

            @SuppressLint("MissingInflatedId")
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                enableEdgeToEdge()
                setContentView(R.layout.activity_main3)

                val score = intent.getIntExtra("score", 0)
                questions = intent.getStringArrayExtra("questions") ?: arrayOf()
                answers = intent.getBooleanArrayExtra("answers")?.toTypedArray() ?: arrayOf()

                val txtScore: TextView = findViewById(R.id.textView3)
                val txtFeedback: TextView = findViewById(R.id.textView5)
                val txtResult: TextView = findViewById(R.id.textView4)
                val btnReview: Button = findViewById(R.id.button5)
                val btnExit: Button = findViewById(R.id.button6)
                val results = intent.getStringArrayListExtra("The results")


                txtScore.text = "You scored $score out of 5."

                // Personalized feedback
                txtFeedback.text = when {
                    score == questions.size -> "Amazing! You have got it all right!"
                    score >= 3 -> "Nice one! Just a bit more again."
                    else -> "Keep practicing! You'll improve."

                }

                btnReview.setOnClickListener {
                    finishAffinity()
                }
                btnExit.setOnClickListener {
                    txtResult.text = results?.joinToString("\n") ?: "There is nothing to show"
                }





                }


            }