package fr.miage.teambuilder.ui.sportif

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SportifProfilViewModel @Inject constructor(): ViewModel() {

    private val mlScreenState = MutableLiveData<State>()
    val ldScreenState = mlScreenState

    // MAJ du profil du sportif
    fun updateSportifProfil() = viewModelScope.launch {
    }


    sealed class State {
        object SuccessUpdate: State()
        object FailUpdate: State()
    }

}