package com.example.tp4exo4

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import java.util.ArrayList
import android.widget.GridView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private var adapter: ListViewAdapter? = null
    fun isTablet(context:Context):Boolean
    {
        return ((context.resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE
                or( context.resources.configuration.orientation and  Configuration.ORIENTATION_LANDSCAPE))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val isLandscape = this.getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE
        var array = arrayOf(
            Seance("TP SGBD","Dimanche 08:00", "Salle I7","Mme Benkrid","30h","SGBD et base de donees avancé " ),
            Seance("TD IHM","Dimanche 11:00 ","Salle CP5","Mme Hassini","15h","Interaction Homme Machine"),
            Seance("TDM","Dimanche 13:00","Salle visio","M Mostefai","40h","Technologie et Developpement Mobile"),


            Seance("Cours HPC", "Lundi 08:30", "Amphi:A4", "M Hadji", "25h", "high performance computing"),
            Seance("TD HPC", "Lundi 10:00", "Salle MC", "M Hadji", "25h", " high performance computing"),
            Seance("Cour Qlog", "Lundi 13:00", "Amphi A2", "Mme Zakaria", "30", "Qualite Logiciel"),
            Seance("TD Alog", "Lundi 13:00", "Salle MC4", "M Tolba", "25h", "architecture logicielle"),

            Seance("Cours SGBD","Mardi 08:30 ","Salle 17","Mme Benkrid","30h", "SGBD et base de donnes avancee"),

            Seance("TP BDM", "Mercredi 08:30", "Salle CP5", "Mme Hamdad", "30h", "BigData Mining"),
            Seance("cours BDM", "Mercredi 10:30", "Amphi A2", "Mme Hamdad", "30h", "BigData Mining"),

            Seance("Cours Alog","Mercredi 13:00","Amphi A3","M Chebeib","30h","Architectures Logiciels"),
            Seance("TD Qlog", "Mercredi 15:00", "CP2", "Mme Zakaria", "30H", " Qualité logiciel"),

            Seance("PRJ2CSSIL", "Jeudi 08:30 ", "Salle DPGR", "M Mostfai et M Chebeib", "30H", "Projet"),
            Seance("Cour IHM ","Jeudi 13:00","A04","Mme Hassini","30h","Interaction Homme Machine")
        )

        seanceArrayList = ArrayList()
        for (i in array!!.indices) {
            val names = array!![i]
            // Binds all strings into an array
            seanceArrayList.add(names)
        }

        adapter = ListViewAdapter(this)

        if (isTablet(this) || isLandscape ) {

            val grid = findViewById(R.id.grid) as GridView
            grid.adapter = adapter
            grid.onItemClickListener = object : AdapterView.OnItemClickListener {

                override fun onItemClick(
                    parent: AdapterView<*>, view: View,
                    position: Int, id: Long
                ) {
                    val bundle = Bundle()
                    var array1 = arrayOf(
                        Enseignant("BENKRID","Selma ","Boumerdas","34 ans","Ingenieur informatique","0623154896"),
                        Enseignant("Hassini","Sabrina","Tipazza","35 ans","Ingenieur Informatique","0526319845"),
                        Enseignant("Mostefai","Mohammed","Alger","30 ans ","Enseignant,Chercheur,Developpeur","0725361849"),

                        Enseignant("Hadji","Hakime","Msila","36 ans","Ingenieur,Chercheur","0623154898"),
                        Enseignant("Zakaria","Chaima","Bejaia","30 ans","Ingenieur","0714623261"),
                        Enseignant("Tolba","Moslim","Bouira","32 ans","Ingenieur","0623154896"),
                        Enseignant("Hamded","Karima","Lila","33 ans","Ingenieur","0526132984"),
                        Enseignant("Chbieb","Farid","Alger","34 ans","Ingenieur","0623159874"))
                    val ens: String = array[position].getEnseignant()
                    val duree: String = array[position].getDureeTotal()
                    val intitule: String = array[position].getIntitule()

                    bundle.putString("ens", ens)
                    bundle.putString("duree", duree)
                    bundle.putString("intitule", intitule)
                    Toast.makeText(this@MainActivity, ens, Toast.LENGTH_LONG).show();

                    if (ens=="Mme Benkrid")
                    {
                        bundle.putString("name", array1[0].getName())
                        bundle.putString("prenom", array1[0].getPrenom())
                        bundle.putString("adresse", array1[0].getAdresse())
                        bundle.putString("age", array1[0].getAge())
                        bundle.putString("deplome", array1[0].getDeplome())
                        bundle.putString("telephone", array1[0].getTelephne())
                    }
                    if (ens.equals("Mme Hassini"))
                    {
                        bundle.putString("name",array1[1].getName())
                        bundle.putString("prenom",array1[1].getPrenom())
                        bundle.putString("adresse",array1[1].getAdresse())
                        bundle.putString("age",array1[1].getAge())
                        bundle.putString("deplome",array1[1].getDeplome())
                        bundle.putString("telephone",array1[1].getTelephne())

                    }
                    if (ens.equals("M Mostefai"))
                    {
                        bundle.putString("name",array1[2].getName())
                        bundle.putString("prenom",array1[2].getPrenom())
                        bundle.putString("adresse",array1[2].getAdresse())
                        bundle.putString("age",array1[2].getAge())
                        bundle.putString("deplome",array1[2].getDeplome())
                        bundle.putString("telephone",array1[2].getTelephne())

                    }
                    if (ens.equals("M Hadji"))
                    {
                        bundle.putString("name",array1[3].getName())
                        bundle.putString("prenom",array1[3].getPrenom())
                        bundle.putString("adresse",array1[3].getAdresse())
                        bundle.putString("age",array1[3].getAge())
                        bundle.putString("deplome",array1[3].getDeplome())
                        bundle.putString("telephone",array1[3].getTelephne())

                    }
                    if (ens.equals("Mme Zakaria"))
                    {
                        bundle.putString("name",array1[4].getName())
                        bundle.putString("prenom",array1[4].getPrenom())
                        bundle.putString("adresse",array1[4].getAdresse())
                        bundle.putString("age",array1[4].getAge())
                        bundle.putString("deplome",array1[4].getDeplome())
                        bundle.putString("telephone",array1[4].getTelephne())

                    }
                    if (ens.equals("M Tolba"))
                    {
                        bundle.putString("name",array1[5].getName())
                        bundle.putString("prenom",array1[5].getPrenom())
                        bundle.putString("adresse",array1[5].getAdresse())
                        bundle.putString("age",array1[5].getAge())
                        bundle.putString("deplome",array1[5].getDeplome())
                        bundle.putString("telephone",array1[5].getTelephne())

                    }
                    if (ens.equals("Mme Hamdad"))
                    {
                        bundle.putString("name",array1[6].getName())
                        bundle.putString("prenom",array1[6].getPrenom())
                        bundle.putString("adresse",array1[6].getAdresse())
                        bundle.putString("age",array1[6].getAge())
                        bundle.putString("deplome",array1[6].getDeplome())
                        bundle.putString("telephone",array1[6].getTelephne())

                    }
                    if (ens.equals("M Chebieb"))
                    {
                        bundle.putString("name",array1[7].getName())
                        bundle.putString("prenom",array1[7].getPrenom())
                        bundle.putString("adresse",array1[7].getAdresse())
                        bundle.putString("age",array1[7].getAge())
                        bundle.putString("deplome",array1[7].getDeplome())
                        bundle.putString("telephone",array1[7].getTelephne())

                    }
                    val fragment = EnseignantFragment()
                    val fragment1 = ModuleFragment()
                    fragment.arguments=bundle
                    fragment1.arguments=bundle
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.contaner1, fragment)
                    transaction.replace(R.id.contaner2, fragment1)
                    transaction.commit()
                }
            }

        } else {
            val liste = findViewById(R.id.liste) as ListView
            liste.adapter = adapter
            liste.onItemClickListener = object : AdapterView.OnItemClickListener {
                override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long
                ) {
                    val ens: String = array[position].getEnseignant()
                    val duree: String = array[position].getDureeTotal()
                    val intitule: String = array[position].getIntitule()
                    val intent = Intent(baseContext, DetailsActivity::class.java)
                    intent.putExtra("ens", ens)
                    intent.putExtra("duree", duree)
                    intent.putExtra("intitule", intitule)
                    startActivity(intent)
                }
            }
        }
    }
    companion object {
        var seanceArrayList = ArrayList<Seance>()
    }
}
