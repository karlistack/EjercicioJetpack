package com.example.ejerciciojetpack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_calculadora.*
import kotlinx.android.synthetic.main.fragment_menuapp.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Calculadora.newInstance] factory method to
 * create an instance of this fragment.
 */
class Calculadora : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculadora, container, false)
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            Calculadora().apply {
                arguments = Bundle().apply {
                }
            }
    }
    var calculo: Int = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        botonCalculadora.setOnClickListener{
            val num1 = Integer.parseInt(editTextTextPersonName.text.toString())
            val num2 = Integer.parseInt(editTextTextPersonName2.text.toString())

            if(radioButtonSum.isChecked){
                calculo = num1+num2
                val bundle = Bundle()
                bundle.putString("key", ""+calculo)
                Navigation.findNavController(it).navigate(R.id.cal_a_suma, bundle)
            }else if(radioButtonRes.isChecked){
                calculo = num1-num2
                val bundle = Bundle()
                bundle.putString("key", ""+calculo)
                Navigation.findNavController(it).navigate(R.id.cal_a_resta, bundle)
            }else if(radioButtonMul.isChecked){
                calculo = num1*num2
                val bundle = Bundle()
                bundle.putString("key", ""+calculo)
                Navigation.findNavController(it).navigate(R.id.cal_a_multiplicacion, bundle)
            }else if(radioButtonDiv.isChecked) {

                val bundle = Bundle()
                if(num2 == 0){
                    bundle.putString("key", "Error de calculo, no se puede dividir entre 0.")
                }else{
                    calculo = num1/num2
                    bundle.putString("key", ""+calculo)
                }
                Navigation.findNavController(it).navigate(R.id.cal_a_division, bundle)
            }
        }
    }
}