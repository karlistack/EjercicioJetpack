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
/**
 * A simple [Fragment] subclass.
 * Use the [Calculadora.newInstance] factory method to
 * create an instance of this fragment.
 */
class Calculadora : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
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


        botonresultado.setOnClickListener{
            val num1 = Integer.parseInt(editTextTextPersonName.text.toString())
            val num2 = Integer.parseInt(editTextTextPersonName2.text.toString())

            if(radioButtonSum.isChecked){
                calculo = num1+num2
                val bundle = Bundle()
                bundle.putString("key", ""+calculo)
                Navigation.findNavController(it).navigate(R.id.suma, bundle)
            }else if(radioButtonRes.isChecked){
                calculo = num1-num2
                val bundle = Bundle()
                bundle.putString("key", ""+calculo)
                Navigation.findNavController(it).navigate(R.id.resta, bundle)
            }else if(radioButtonMul.isChecked){
                calculo = num1*num2
                val bundle = Bundle()
                bundle.putString("key", ""+calculo)
                Navigation.findNavController(it).navigate(R.id.multiplicacion, bundle)
            }else if(radioButtonDiv.isChecked) {

                val bundle = Bundle()
                if(num2 == 0){
                    bundle.putString("key", "Error de calculo, no se puede dividir entre 0.")
                }else{
                    calculo = num1/num2
                    bundle.putString("key", ""+calculo)
                }
                Navigation.findNavController(it).navigate(R.id.divide, bundle)
            }
        }
    }
}