package android.reserver.com

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import android.reserver.com.ui.theme.Reserver1Theme
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Reference the layout file

        val seatInput = findViewById<EditText>(R.id.seat_input)
        val submitButton = findViewById<Button>(R.id.submit_button)

        submitButton.setOnClickListener {
            val seatText = seatInput.text.toString()

            if (seatText.isEmpty()) {
                seatInput.error = "Please enter a number between 1 and 6"
                return@setOnClickListener
            }

            try {
                val seats = seatText.toInt()
                when {
                    seats < 1 || seats > 6 -> {
                        if (seats > 6) {
                            Toast.makeText(this, "Please call 123-456-7890 for reservations larger than 6.", Toast.LENGTH_LONG).show()
                        } else {
                            seatInput.error = "Please enter a number between 1 and 6"
                        }
                    }
                    else -> {
                        Toast.makeText(this, "Thank you for your reservation!", Toast.LENGTH_LONG).show()
                    }
                }
            } catch (e: NumberFormatException) {
                seatInput.error = "Invalid input. Please enter a valid number between 1 and 6."
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    Reserver1Theme {
//        Greeting("Android")
//    }
//}