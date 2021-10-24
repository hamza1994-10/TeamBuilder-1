package fr.miage.teambuilder.ui.sportif

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.Switch
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import dagger.hilt.android.AndroidEntryPoint
import fr.miage.teambuilder.R
import fr.miage.teambuilder.utils.SpinnerManager
import java.util.*

@AndroidEntryPoint
class SportifProfilScreen : AppCompatActivity() {

    private val viewModel: SportifProfilViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sportif_profil_screen)

        val sportsSpinner: Spinner = findViewById(R.id.sportSpinner)
        val posteSpinner: Spinner = findViewById(R.id.posteSpinner)
        val geoSpinner: Spinner = findViewById(R.id.geoSpinner)
        val sexeSpinner: Spinner = findViewById(R.id.sexeSpinner)
        val ageTextField: TextInputEditText = findViewById(R.id.editTextAge)
        val toggle: Switch = findViewById(R.id.switchOfferLooking)
        val validateButton: Button = findViewById(R.id.validate)

       SpinnerManager.setAdaptaterSpinner(this, R.array.sports, sportsSpinner)
        SpinnerManager.setAdaptaterSpinner(this, R.array.poste, posteSpinner)
        SpinnerManager.setAdaptaterSpinner(this, R.array.geo, geoSpinner)
        SpinnerManager.setAdaptaterSpinner(this, R.array.sexes, sexeSpinner)

        viewModel.ldScreenState.observe(this, androidx.lifecycle.Observer {
            when(it){
                SportifProfilViewModel.State.SuccessUpdate -> {
                    SuccessUpdate()
                }
                SportifProfilViewModel.State.FailUpdate -> {
                    FailsUpdate()
                }
            }
        })

        validateButton.setOnClickListener {
            viewModel.updateSportifProfil()
        }
    }



    private fun SuccessUpdate(){
        Toast.makeText(this, getString(R.string.update_success), Toast.LENGTH_LONG).show()
    }

    private fun FailsUpdate(){
        Toast.makeText(this, getString(R.string.update_faile), Toast.LENGTH_LONG).show()

    }
}