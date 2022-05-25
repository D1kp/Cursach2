package ru.samsung.itschool.myapplication

import android.content.ContentValues
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class BlankFragment : Fragment() {


    private val ref = FirebaseDatabase.getInstance("https://robostem-f9d54-default-rtdb.firebaseio.com/").getReference("ResourseComands")

    private val pasword:String = "111"
    private var user:String = ""
    private var name:ArrayList<String> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        getData()


        // Inflate the layout for this fragment
        val view:View=inflater.inflate(R.layout.fragment1, container, false)
        // ============= Button обработчик, способ записи 1
        val btn8:Button = view.findViewById(R.id.button8)
        btn8.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                p0?.findNavController()?.navigate(R.id.action_blankFragment_to_blankFragment5)
            }
        })

        val btn:Button=view.findViewById(R.id.button)
        btn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                var flag = false
                val bundle = Bundle()

                val base =
                    FirebaseDatabase.getInstance("https://robostem-f9d54-default-rtdb.firebaseio.com/")
                val editText: EditText = view.findViewById(R.id.TextPersonName)
                user = editText.text.toString()
                for(i in 0 until name.size)
                {
                    if(user == name[i])
                    {
                        flag = true
                        break
                    }
                }
                if(flag){
                    val comands = base.getReference("Comands")
                    val list: ArrayList<String> = ArrayList()
                    list.add("Нет задач")
                    val member = Member(list, user)
                        val ref = comands.push()
                        val uid = ref.key
                        ref.setValue(member)
                        bundle.putString("uid", uid)
                        bundle.putString("name", user)
                        p0?.findNavController()
                            ?.navigate(R.id.action_blankFragment_to_blankFragment2, bundle)
                }
                else{
                    if (!TextUtils.isEmpty(user)) {
                        Toast.makeText(context, "Команда не зарегестрирована", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(context, "Пустое поле", Toast.LENGTH_SHORT).show()
                    }
                }


            }
        })
        // ============= Button3 обработчик, способ записи 2
        val btn3:Button=view.findViewById(R.id.button3)
        btn3.setOnClickListener(View.OnClickListener { view -> view.findNavController().navigate(R.id.action_blankFragment_to_blankFragment3) })
        // ============= Button5 обработчик, способ записи 3
        val btn5:Button = view.findViewById(R.id.button5)
        btn5.setOnClickListener { p0 ->
            val textfield: TextView = view.findViewById(R.id.TextPersonName)
            if (textfield.text.toString() == pasword) {
                p0?.findNavController()?.navigate(R.id.action_blankFragment_to_blankFragment4)
            } else {
                Toast.makeText(requireContext(), "Вы не администратор", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun getData()
    {
        ref.addListenerForSingleValueEvent(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                for(ds: DataSnapshot in snapshot.children){
                    val userModel= ds.value
                    val username = userModel.toString()
                    name.add(username)
                }

            }
            override fun onCancelled(error: DatabaseError) {
                Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
            }
        })
    }

}

