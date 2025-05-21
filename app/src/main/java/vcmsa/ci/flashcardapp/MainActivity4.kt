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
import java.util.ArrayList

class MainActivity4 : AppCompatActivity() {
    private val questions = arrayOf(
        "George Washington was the first U.S. President.",
        "World War II ended in 1939.",
        "The Roman Empire used Greek as its main language.",
        "Joan of Arc was from France.",
        "The humam skeleton is made up of lees than 100 bones"
    )

    private val answers = booleanArrayOf(true, false, false, true, false)

    private lateinit var questionText: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var questTrue: TextView
    private val userResult = mutableListOf<String>()
    private var currentIndex = 0
    private var score = 0
    private var hasAnswered = false


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)
        questionText = findViewById(R.id.textView)
        trueButton = findViewById(R.id.button2)
        falseButton = findViewById(R.id.button3)
        nextButton = findViewById(R.id.button4)
        questTrue = findViewById(R.id.textView2)

        questionText.text = questions[currentIndex]

        trueButton.setOnClickListener {
            questTrue.text = "True"

        hasAnswered = true
        checkAns(true)

    }

    falseButton.setOnClickListener {
        hasAnswered = true
        questTrue.text = "False"
        checkAns(false)

    }
    nextButton.setOnClickListener {


        if (currentIndex +1 < questions.size) {
            currentIndex++
            updateQuestion()
        } else {
            // Go to result screen
            val intent = Intent(this, MainActivity3::class.java)
            intent.putExtra("score", score)
            intent.putExtra("total", questions.size)
            intent.putStringArrayListExtra("The results", ArrayList(userResult))
            startActivity(intent)

        }
    }
}

private fun updateQuestion() {
    questionText.text = questions[currentIndex]
}
private fun checkAns(ansUser:Boolean) {
    val ansCorrect = answers[currentIndex]
    val txtResult =
        if (ansUser==ansCorrect) {
            score++
            "Q${currentIndex+1} correct"

        } else {
            "Q${currentIndex+1} Incorrect"

        }
    userResult.add(txtResult)
}


}






