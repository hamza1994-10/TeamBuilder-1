package fr.miage.teambuilder.models.rest

import fr.miage.teambuilder.models.dao.MatchEntity

class Match constructor(
    val uid: String,
    val uidSportif: String? = null,
    val uidEquipe: String? = null
) {
    fun toEntity(): MatchEntity{
        return MatchEntity(
            uid = uid,
            uidSportif = uidSportif,
            uidEquipe = uidEquipe
        )
    }
}