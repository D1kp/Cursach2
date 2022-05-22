package ru.samsung.itschool.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController


class BlankFragment3 : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view:View=inflater.inflate(R.layout.fragment3, container, false)

        val btn = view.findViewById<ImageButton>(R.id.imageButton2)
        btn.setOnClickListener{
            view.findNavController().navigate(R.id.action_blankFragment3_to_blankFragment)
        }
        val icon = view.findViewById<ImageView>(R.id.imageView2)
        icon.setOnClickListener{
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("http://robostem.ru"))
            startActivity(i)
        }

        return view
    }

}
