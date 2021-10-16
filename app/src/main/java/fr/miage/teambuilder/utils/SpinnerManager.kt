package fr.miage.teambuilder.utils

import android.content.Context
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.annotation.ArrayRes
import fr.miage.teambuilder.R

class SpinnerManager {
    companion object{
        fun setAdaptaterSpinner(context: Context, @ArrayRes arrayRes: Int, spinner: Spinner ){
            ArrayAdapter.createFromResource(context, arrayRes, android.R.layout.simple_spinner_item).also {
                    adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner.adapter = adapter
            }
        }
    }
}