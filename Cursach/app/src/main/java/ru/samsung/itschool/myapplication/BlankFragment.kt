package ru.samsung.itschool.myapplication

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase



class BlankFragment : Fragment() {

    private val pasword:String = "111"
    private var user:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view:View=inflater.inflate(R.layout.fragment1, container, false)
        // ============= Button обработчик, способ записи 1
        var btn8:Button = view.findViewById(R.id.button8)
        btn8.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                if (p0 != null) {
                    p0.findNavController().navigate(R.id.action_blankFragment_to_blankFragment2)
                }
            }
        })
        var btn:Button=view.findViewById(R.id.button)
        btn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                val bundle = Bundle()
                val editText:EditText = view.findViewById(R.id.TextPersonName)
                val base = FirebaseDatabase.getInstance("https://robostem-f9d54-default-rtdb.firebaseio.com/")
                user = editText.text.toString()
                var comands = base.getReference("Comands")
                var member = Member("none",user)
                if(!TextUtils.isEmpty(user)) {
                    comands.push().setValue(member)
                    bundle.putString("name",user)
                    if (p0 != null) {
                        p0.findNavController().navigate(R.id.action_blankFragment_to_blankFragment2,bundle)
                    }
                }
                else{
                    Toast.makeText(context,"Пустое поле",Toast.LENGTH_SHORT).show()
                }
            }
        })
        // ============= Button3 обработчик, способ записи 2
        var btn3:Button=view.findViewById(R.id.button3)
        btn3.setOnClickListener(View.OnClickListener { view -> view.findNavController().navigate(R.id.action_blankFragment_to_blankFragment3) })
        // ============= Button5 обработчик, способ записи 3
        var btn5:Button = view.findViewById(R.id.button5)
        btn5.setOnClickListener { p0 ->
            var textfield: TextView = view.findViewById(R.id.TextPersonName)
            if (textfield.text.toString() == pasword) {
                p0?.findNavController()?.navigate(R.id.action_blankFragment_to_blankFragment4)
            } else {
                Toast.makeText(requireContext(), "Вы не администратор", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }

}
