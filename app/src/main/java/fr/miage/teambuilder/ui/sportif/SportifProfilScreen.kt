package fr.miage.teambuilder.ui.sportif

import android.os.Bundle
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import fr.miage.teambuilder.R
import fr.miage.teambuilder.utils.SpinnerManager

@AndroidEntryPoint
class SportifProfilScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sportif_profil_screen)

        val sportsSpinner: Spinner = findViewById(R.id.sportSpinner)
        val posteSpinner: Spinner = findViewById(R.id.posteSpinner)
        val geoSpinner: Spinner = findViewById(R.id.geoSpinner)
        val sexeSpinner: Spinner = findViewById(R.id.sexeSpinner)

       SpinnerManager.setAdaptaterSpinner(this, R.array.sports, sportsSpinner)
        SpinnerManager.setAdaptaterSpinner(this, R.array.poste, posteSpinner)
        SpinnerManager.setAdaptaterSpinner(this, R.array.geo, geoSpinner)
        SpinnerManager.setAdaptaterSpinner(this, R.array.sexes, sexeSpinner)
    }
}