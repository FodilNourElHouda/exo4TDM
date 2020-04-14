package com.example.tp4exo4

class Seance {
    private val name: String
    private val  date:String
    private val  Salle:String
    private val enseignant: String
    private val  duree:String
    private val  Intitule:String


    constructor(name: String, date:String, salle:String,ens:String,duree:String,intitule:String){
        this.name = name
        this.date=date
        this.Salle=salle
        this.enseignant=ens
        this.duree=duree
        this.Intitule=intitule
    }

    fun getNameM(): String {
        return this.name
    }
    fun getDateS(): String {
        return this.date
    }
    fun getSalle(): String {
        return this.Salle
    }

    fun getEnseignant(): String {
        return this.enseignant
    }

    fun getDureeTotal(): String {
        return this.duree
    }
    fun getIntitule(): String {
        return this.Intitule
    }


}