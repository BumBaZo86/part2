import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    // Referenser till knappar och TextView för att visa kort
    private lateinit var buttonHigh: Button
    private lateinit var buttonLow: Button
    private lateinit var buttonRules: Button
    private lateinit var cardText: TextView
    private lateinit var resultText: TextView

    // Skapa en lista av kort från 2 till 14
    private val deck = (2..14).toList()

    // För att lagra det dragna kortet
    private var drawnCard: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)  // Din layoutfil

        // Initiera knappar och TextView
        buttonHigh = findViewById(R.id.button_high)
        buttonLow = findViewById(R.id.button_low)
        buttonRules = findViewById(R.id.button_rules)
        cardText = findViewById(R.id.card_text)
        resultText = findViewById(R.id.result_text)  // TextView för resultatet

        // Sätt onClickListeners för knapparna
        buttonHigh.setOnClickListener {
            onHighButtonClicked()
        }

        buttonLow.setOnClickListener {
            onLowButtonClicked()
        }

        buttonRules.setOnClickListener {
            onRulesButtonClicked()
        }
    }

    private fun onHighButtonClicked() {
        // Dra ett kort för High och visa det
        drawnCard = drawCard()
        showCard("High Card: $drawnCard")

        // Jämför kortet
        if (drawnCard > 7) { // Förutsätt att du vinner om kortet är större än 7
            showResult("WOW! Gratz!", isWin = true)
        } else {
            showResult("Better luck next time!", isWin = false)
        }
    }

    private fun onLowButtonClicked() {
        // Dra ett kort för Low och visa det
        drawnCard = drawCard()
        showCard("Low Card: $drawnCard")

        // Jämför kortet
        if (drawnCard < 7) { // Förutsätt att du vinner om kortet är mindre än 7
            showResult("WOW! Gratz!", isWin = true)
        } else {
            showResult("Better luck next time!", isWin = false)
        }
    }

    private fun onRulesButtonClicked() {
        // Hantera logik för Rules-knappen här (t.ex. visa regler)
    }

    private fun drawCard(): Int {
        // Slumpa fram ett kort mellan 2 och 14
        return deck.random()
    }

    private fun showCard(cardTextValue: String) {
        // Uppdatera TextView med kortets värde och visa det
        cardText.text = cardTextValue
        cardText.visibility = View.VISIBLE
    }

    // Metod för att visa resultatet på skärmen
    private fun showResult(result: String, isWin: Boolean) {
        // Uppdatera TextView med resultatet och visa det
        resultText.text = result
        resultText.visibility = View.VISIBLE // Gör TextView synlig

        // Sätt färg beroende på om användaren vinner eller förlorar
        if (isWin) {
            resultText.setTextColor(ContextCompat.getColor(this, android.R.color.black)) // Svart text för vinst
        } else {
            resultText.setTextColor(ContextCompat.getColor(this, android.R.color.white)) // Vit text för förlust
        }
    }
}