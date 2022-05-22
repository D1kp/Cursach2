package ru.samsung.itschool.myapplication

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import android.widget.Toast


import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.samsung.itschool.myapplication.databinding.Fragment4Binding


class BlankFragment4 : Fragment(),RVAdapter.MyOnClickListener {
    private var listview:ListView? = null
    private var recview:RecyclerView?=null
    private val myRef =  FirebaseDatabase.getInstance("https://robostem-f9d54-default-rtdb.firebaseio.com/").getReference("Comands")
    private var dataBase:ArrayList<String> ?= null
    private var adapter:ArrayAdapter<String> ?=null
    lateinit var binding:Fragment4Binding
    private var memberlist = ArrayList<Member>()
    private var listdata = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        getData()
    }

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment4, container, false)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = Fragment4Binding.bind(view)
        init()
        getData()
        binding.apply {
            button4.setOnClickListener(object : View.OnClickListener{
                override fun onClick(p0: View?) {
                    val adapt = RVAdapter(memberlist,this@BlankFragment4)
                    recview?.layoutManager = LinearLayoutManager(requireContext())
                    recview?.adapter = adapt
                    adapt.addMember(dataBase!!)
                }

            })
        }
    }


    private fun init(){
        listview = view?.findViewById(R.id.listView)
        dataBase = ArrayList()
        listdata = ArrayList()

        recview = view?.findViewById(R.id.REc1)

    }



   private fun getData()
    {
        val vListener: ValueEventListener = object:ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
                if(dataBase?.size!! > 0) {
                    dataBase!!.clear()
                }
                for(ds:DataSnapshot in snapshot.children){
                    val userModel= ds.value as HashMap<*, *>
                    val name = userModel.get("komand")
                    //Toast.makeText(requireContext(),"$userModel",Toast.LENGTH_LONG).show()
                    dataBase!!.add(name.toString())
                }
                adapter?.notifyDataSetChanged()
            }
            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        }
        myRef.addValueEventListener(vListener)

        for(i in 0 until dataBase!!.size){
            val member = Member(null,dataBase!![i])
            memberlist.add(member)
        }
    }

    fun getlinkUser(name:String){

        val vListener: ValueEventListener = object:ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
                if(listdata.size > 0) {
                    listdata.clear()
                }
                for(ds:DataSnapshot in snapshot.children){
                    val userModel= ds.value as HashMap<*, *>
                    val zadacha = userModel.get("zadacha")

                         if(userModel.get("komand") == name){
                             val splitzad = zadacha.toString().split(", ").toMutableList()
                             for(i in 0 until splitzad.size){
                                 splitzad[i] = splitzad[i].replace("[","")
                                 splitzad[i] = splitzad[i].replace("]","")
                                 listdata.add(splitzad[i])
                             }
                    }
                    adapter?.notifyDataSetChanged()
                }

            }
            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        }
        myRef.addListenerForSingleValueEvent(vListener)
    }
    override fun OnClick(member:Member) {
        getlinkUser(member.komand)
        adapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1, listdata)
        listview?.adapter = adapter
    }
}




