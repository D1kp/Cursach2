package ru.samsung.itschool.myapplication

import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.findNavController
import com.google.firebase.database.FirebaseDatabase


class BlankFragment6 : Fragment() {
    private val base = FirebaseDatabase.getInstance("https://robostem-f9d54-default-rtdb.firebaseio.com/")
    private val bundle = Bundle()
    private val user = base.getReference("Viewer")
    private val ref =  user.push()
    private val uid = ref.key
    private  var backButton: ImageButton?= null
    private var btn_save:Button?=null
    private var textPersonName:EditText? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view:View=inflater.inflate(R.layout.fragment6, container, false)
        val link: TextView? = view.findViewById(R.id.Link2)
        val num_rand: Int = (0 until 7).random()
        backButton = view.findViewById(R.id.imageButton2)
        backButton = view.findViewById(R.id.imageButton)
        btn_save = view.findViewById(R.id.button16)

        val ViniPuh_Array :Array<String> = arrayOf(
            "Нужно делать так, как нужно. А как не нужно, делать не нужно!",
            "— Ай-ай-ай, спасите-помогите! Не могу ни взад ни вперёд!",
            "— Кто же это ходит за мёдом с воздушными шарами? — Я хожу!",
            "— Хвост или есть, или его нет. По-моему, тут нельзя ошибиться.",
            "Это «ж-ж-ж» — неспроста!",
            "Воздушным шаром можно кого хочешь утешить.",
            "А зачем тебе жужжать, если ты не пчела?",
            "Можно ничего не делать, и тогда может случится много приятностей!"
        )
        val Button_ = arrayOf<Button?>(
            view.findViewById(R.id.button17),
            view.findViewById(R.id.button18),
            view.findViewById(R.id.button19),
            view.findViewById(R.id.button20),
            view.findViewById(R.id.button21),
            view.findViewById(R.id.button22),
            view.findViewById(R.id.button23),
            view.findViewById(R.id.button24),
        )
        if (link != null) {
            link.setElegantTextHeight(true)
            link.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE)
            link.setSingleLine(false)
        }

        var flag = false
        btn_save?.setOnClickListener {
            textPersonName = view.findViewById(R.id.TextPersonName)
            val viewer = Viewer(textPersonName?.text.toString(),0)
            ref.setValue(viewer)
            bundle.putString("uid7",uid)
            bundle.putString("viewer",textPersonName?.text.toString())
            Toast.makeText(requireContext(),"Запомнили",Toast.LENGTH_SHORT).show()
            flag = true
        }

        backButton?.setOnClickListener{
            view.findNavController().navigate(R.id.action_blankFragment6_to_blankFragment5)
        }

        fun cliker(i : Int){
            Button_[i]!!.setOnClickListener{
                if(num_rand == i){
                    if(flag) {
                        bundle.putInt("count", 0)
                        requireView().findNavController()
                            .navigate(R.id.action_blankFragment6_to_blankFragment7, bundle)
                    }
                    else {
                        link?.text =ViniPuh_Array[i]
                        Toast.makeText(
                            requireContext(),
                            "Запишите свое имя, кнопка номер ${i+1}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
                else
                link?.text =ViniPuh_Array[i]
            }
        }

        for(i in 0 .. Button_.size-1){
            cliker(i)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}