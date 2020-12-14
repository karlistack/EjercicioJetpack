package com.example.ejerciciojetpack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_web.*
import android.graphics.Bitmap
import android.webkit.*
import android.widget.SearchView
import kotlinx.android.synthetic.*

/**
 * A simple [Fragment] subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
class web : Fragment() {
    private var urlP = "https://google.es"
    private val path = "/search?q="

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_web, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        refrescar.setOnRefreshListener {
            vWeb.reload()
        }


        vBuscar.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    if(URLUtil.isValidUrl(it)){
                        //Es una URL
                        vWeb.loadUrl(it)
                    }else{
                        //No es una URL
                        vWeb.loadUrl("$urlP$path$it")
                    }
                }
                return false
            }
        })

        super.onViewCreated(view, savedInstanceState)

        vWeb.webChromeClient = object : WebChromeClient(){

        }

        vWeb.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(
                    view: WebView?,
                    request: WebResourceRequest?
            ): Boolean {
                return false
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)

                vBuscar.setQuery(url, false)
                refrescar.isRefreshing = true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)

                refrescar.isRefreshing= false
            }
        }

        val settings:WebSettings = vWeb.settings
        settings.javaScriptEnabled = true

        vWeb.loadUrl(urlP)
    }
}