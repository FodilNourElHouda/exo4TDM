package com.example.tp4exo4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ModuleFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ModuleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ModuleFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_module, container, false)
        val bundle = this.arguments
        val ens = view.findViewById(R.id.ens) as Button
        val duree = view.findViewById(R.id.duree) as TextView
        val intitule=view.findViewById(R.id.intitule) as TextView
        val index = bundle?.getString("ens")
            val index1 = bundle?.getString("duree")
            val index2 = bundle?.getString("intitule")
            ens.setText(index)
            duree.setText(index1)
            intitule.setText(index2)
        var array = arrayOf(
            Enseignant("BENKRID","Selma ","Boumerdas","34 ans","Ingenieur informatique","0623154896"),
            Enseignant("Hassini","Sabrina","Tipazza","35 ans","Ingenieur Informatique","0526319845"),
            Enseignant("Mostefai","Mohammed","Alger","30 ans ","Enseignant,Chercheur,Developpeur","0725361849"),
            Enseignant("Hadji","Hakime","Msila","36 ans","Ingenieur,Chercheur","0623154898"),
            Enseignant("Zakaria","Chaima","Bejaia","30 ans","Ingenieur","0714623261"),
            Enseignant("Tolba","Moslim","Bouira","32 ans","Ingenieur","0623154896"),
            Enseignant("Hamded","Karima","Media","33 ans","Ingenieur","0526132984"),
            Enseignant("Chbieb","Farid","Alger","34 ans","Ingenieur","0623159874"))

        ens.setOnClickListener {
            val bundle = Bundle()
            Toast.makeText(getActivity(), index,Toast.LENGTH_LONG).show();
            if (index=="Mme Hassini")
            {
            bundle.putString("name", array[1].getName())
            bundle.putString("prenom", array[1].getPrenom())
            bundle.putString("adresse", array[1].getAdresse())
            bundle.putString("age", array[1].getAge())
            bundle.putString("deplome", array[1].getDeplome())
            bundle.putString("telephone", array[1].getTelephne())
        }
            if (index.equals("Mme Benkrid"))
            {
                bundle.putString("name",array[0].getName())
                bundle.putString("prenom",array[0].getPrenom())
                bundle.putString("adresse",array[0].getAdresse())
                bundle.putString("age",array[0].getAge())
                bundle.putString("deplome",array[0].getDeplome())
                bundle.putString("telephone",array[0].getTelephne())

            }
            if (index.equals("M Mostefai"))
            {
                bundle.putString("name",array[2].getName())
                bundle.putString("prenom",array[2].getPrenom())
                bundle.putString("adresse",array[2].getAdresse())
                bundle.putString("age",array[2].getAge())
                bundle.putString("deplome",array[2].getDeplome())
                bundle.putString("telephone",array[2].getTelephne())

            }
            if (index.equals("M Hadji"))
            {
                bundle.putString("name",array[3].getName())
                bundle.putString("prenom",array[3].getPrenom())
                bundle.putString("adresse",array[3].getAdresse())
                bundle.putString("age",array[3].getAge())
                bundle.putString("deplome",array[3].getDeplome())
                bundle.putString("telephone",array[3].getTelephne())

            }
            if (index.equals("Mme Zakaria"))
            {
                bundle.putString("name",array[4].getName())
                bundle.putString("prenom",array[4].getPrenom())
                bundle.putString("adresse",array[4].getAdresse())
                bundle.putString("age",array[4].getAge())
                bundle.putString("deplome",array[4].getDeplome())
                bundle.putString("telephone",array[4].getTelephne())

            }
            if (index.equals("M Tolba"))
            {
                bundle.putString("name",array[5].getName())
                bundle.putString("prenom",array[5].getPrenom())
                bundle.putString("adresse",array[5].getAdresse())
                bundle.putString("age",array[5].getAge())
                bundle.putString("deplome",array[5].getDeplome())
                bundle.putString("telephone",array[5].getTelephne())

            }
            if (index.equals("Mme Benatchba"))
            {
                bundle.putString("name",array[6].getName())
                bundle.putString("prenom",array[6].getPrenom())
                bundle.putString("adresse",array[6].getAdresse())
                bundle.putString("age",array[6].getAge())
                bundle.putString("deplome",array[6].getDeplome())
                bundle.putString("telephone",array[6].getTelephne())

            }
            if (index.equals("M Chebieb"))
            {
                bundle.putString("name",array[7].getName())
                bundle.putString("prenom",array[7].getPrenom())
                bundle.putString("adresse",array[7].getAdresse())
                bundle.putString("age",array[7].getAge())
                bundle.putString("deplome",array[7].getDeplome())
                bundle.putString("telephone",array[7].getTelephne())

            }

            val fragment = EnseignantFragment()

            val fragmentManager = activity!!.supportFragmentManager

            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.contaner, fragment)
            fragment.arguments=bundle
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }




        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //you can set the title for your toolbar here for different fragments different titles
        activity!!.title = "Détails"
    }
}
