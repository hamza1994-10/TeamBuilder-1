package fr.miage.teambuilder.repository

import android.app.Activity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import fr.miage.teambuilder.ui.signIn.SignInViewModel
import javax.inject.Inject

class UserRepository @Inject constructor() {

    val db = Firebase.firestore

    fun createUser(email:String? = null, nom:String? = null, prenom: String?= null, userType:String? = null){
            val user = hashMapOf(
                "email" to email,
                "nom" to nom,
                "prenom" to prenom,
                "userType" to userType,
                "sexe" to null,
                "age" to null
            )
        db.collection("users").add(user)
    }




}

