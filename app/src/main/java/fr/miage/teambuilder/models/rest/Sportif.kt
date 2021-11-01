package fr.miage.teambuilder.models.rest

import fr.miage.teambuilder.models.dao.SportifEntity

data class Sportif constructor(
    val uid: String,
    val email: String = "",
    val nom: String? = null,
    val prenom: String? = null,
    val age: Int? = null,
    val taille: Int? = null,
    val sportFavori: String? = null,
    val poste: String? = null,
    val sexe: String? = null,
    val niveau: String? = null,
    val lookingForOffer: Boolean = false,
    val userType: String? = null
) {

    fun constructor(){

    }

    fun toEntity():SportifEntity{
        return SportifEntity(
            uid, email, nom, prenom, age, taille, sportFavori, poste, sexe, niveau, lookingForOffer, userType
        )
    }
}