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
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.GridView


class MainActivity : AppCompatActivity() {
    private var adapter: ListViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var array = arrayOf(
            Seance(
                "TP SGBD",
                "Demanche 08:30",
                "Salle:CPI7",
                "Mme Benkrid",
                "30h",
                "SGBD et base de donees avancé "
            ),
            Seance(
                "TD IHM",
                "Demanche 11:00 ",
                "Salle:CPI5",
                "M Hassini",
                "15h",
                "Interaction Homme Machine"
            ),
            Seance(
                "TDM",
                "Demanche 13:00",
                "Salle:visio",
                "M Mostfai",
                "40h",
                "Technologie et Developpement Mobile"
            ),

            Seance("Cours HPC", "Lundi 08:30", "Salle:A4", "M Hadji", "25h", "high performance computing"),
            Seance("TP HPC", "Lundi 10:00", "Salle:MC", "M Hadji", "30h", "high performance computing"),
            Seance("Cour Alog", "Lundi a 13h00", "A2", "Mme Zakaria", "30", "Qualite Logiciel"),
            Seance(
                "Cours SGBD",
                "Mardi 08:30 ",
                "Salle:17",
                "Mme Benkrid",
                "30h",
                "SGBD et base de donnes avancee"
            ),
            Seance("TD Alog", "Mardi 10:00", "Salle:MC4", "M Tolba", "25h", "architecture logicielle"),
            Seance("TP BDM", "Mercredi a 08h30", "Salle:CP5", "Mme HAMDAD", "30H", ""),
            Seance("Cours BDM", "Mercredi 10:30", "A2", "HAMDAD L", "30H", "BigData Mining"),
            Seance(
                "Cours Alog",
                "Mercredi 13:00",
                "A3",
                "M Chebieb",
                "30h",
                "Architectures Logiciels"
            ),
            Seance("TD Qlog", "Mercredi 15:00", "Salle:CPI1", "Mme ZAKARIA", "30H", "Qualité logiciel"),
            Seance("PRJSIL", "Jeudi 08:30 ", "Salle:Visio", "M Batata et M HAKIMI", "30H", "Projet"),
            Seance(
                "Cour IHM ",
                "Jeudi 13:00",
                "A04",
                "Mme Hassini",
                "30h",
                "Interaction Homme Machine"
            )


        )




        movieNamesArrayList = ArrayList()

        for (i in array!!.indices) {
            val movieNames = array!![i]
            // Binds all strings into an array
            movieNamesArrayList.add(movieNames)
        }

        adapter = ListViewAdapter(this)

        // Binds the Adapter to the ListView

        //   val adapter = ArrayAdapter(activity!!, R.layout.lv_item, movieNamesArrayList)
        if (isTablet(this)) {

            val grid = findViewById(R.id.grid) as GridView
            grid.adapter = adapter
            grid.onItemClickListener = object : AdapterView.OnItemClickListener {

                override fun onItemClick(
                    parent: AdapterView<*>, view: View,
                    position: Int, id: Long
                ) {
                    val fragment = BlankFragment()
                    val fragment1 = BlankFragment2()

                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.contaner1, fragment)
                    transaction.replace(R.id.contaner2, fragment1)
                    transaction.commit()
                }
            }

        } else {


            val lv = findViewById(R.id.liste) as ListView

            lv.adapter = adapter
            lv.onItemClickListener = object : AdapterView.OnItemClickListener {

                override fun onItemClick(
                    parent: AdapterView<*>, view: View,
                    position: Int, id: Long
                ) {


                    val ens: String = array[position].getEnseignant()
                    val duree: String = array[position].getDureeTotal()
                    val intitule: String = array[position].getIntitule()


                    val intent = Intent(baseContext, Main2Activity::class.java)

                    intent.putExtra("ens", ens)
                    intent.putExtra("duree", duree)
                    intent.putExtra("intitule", intitule)



                    startActivity(intent)

                    //   view.findNavController().navigate(R.id.action_mainFragment2_to_secondFragment, bundle)


                }
            }


        }
    }
    companion object {
        var movieNamesArrayList = ArrayList<Seance>()
    }
    fun isTablet(context:Context):Boolean
    {
        return ((context.resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE
                  or( context.resources.configuration.orientation and  Configuration.ORIENTATION_LANDSCAPE)
                )
    }
}
