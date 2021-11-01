package fr.miage.teambuilder.models.rest

import fr.miage.teambuilder.models.dao.ClubEntity

class Club constructor
    (
    val uid: String,
    val email: String? = null,
    val userType: String = "club",
    val nomClub: String? = null,
    val equipesUid: ArrayList<String> = arrayListOf()
) {
    fun toEntity(): ClubEntity {
        return ClubEntity(
            email = email,
            userType = userType,
            nomClub = nomClub,
            equipesUid = equipesUid,
            uid = uid
        )
    }
}