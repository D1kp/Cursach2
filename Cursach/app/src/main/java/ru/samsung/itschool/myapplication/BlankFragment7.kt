package ru.samsung.itschool.myapplication

import android.Manifest
import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.firebase.database.FirebaseDatabase


class BlankFragment7 : Fragment() {
    private var openLink: Button? = null
    private var bScanner: Button? = null
    private var backButton: ImageButton?= null
    private val base = FirebaseDatabase.getInstance("https://robostem-f9d54-default-rtdb.firebaseio.com/")
    private val user = base.getReference("Viewer")
    private val bundle = Bundle()
    private var flag_apdate: Int = 0
    private val ListArrey :Array<Int> = arrayOf(
        379903,
        379903,
        379903,
        379903,
        379903,
        379903,
        379903,
        379903,
        379903,
        379903,
        379903
    )

    private val QuestArrey :Array<String> = arrayOf(
        "Двигайся туда, опираясь только на конечности, напоминающие ноги живого существа. Ваши стопы в ходе движения не должны быть выше, чем связаная с ней точка крепления.",
        "В зоне мероприятия, есть место где сортируют отходы, вам нужно найти его. Но может эти отходы и разбрасывают, кто знает этих робото",
        "Идите туда где вам помогут в уборной, в срочной ситуации, ведь доставка это очень важная вещь, когда это так необходимо",
        "Вам надоело ожидать груз по часу после прилета, ничего страшного, на нашем мероприятии роботы сами доставляют груз, и возможно делают это быстрее, сходите и проверьте",
        "Пытаясь не вытолкнуть никого из мероприятия, двигайся туда где есть ринг",
        "Тут стоит двигаться в сторону Северного Ледовитого океана, там вы наткнетесь на архипилаг, который состоит из 192 островов",
        "Вы наверно уже запутались в нашем лабиринте , но ничего страшного ведь есть место, в котором роботы проходят лабиринты, может они подскажут вам выход?",
        "Найдите место где линией изображено очертание морского котика, раньше это был логотип мероприятия робонорд",
        "Найдите место, где роботы справляются с работой лучше, чем работники ЖКХ. Если программу для робота написал хороший программист, иначе вы увидите робота из ЖКХ)",
        "После сортировки мусора нужна же его доставка, найдите место, где происходит доставка"

    )

    private val HelpArrey :Array<String> = arrayOf(
        "Не правильно)) Подсказка: 2 возростная группа))",
        "Не правильно)) Подсказка: 4 возростная группа))",
        "Не правильно)) Подсказка: 2 возростная группа))",
        "Не правильно)) Подсказка: 5 возростная группа))",
        "Не правильно)) Подсказка: 1 возростная группа))",
        "Не правильно)) Подсказка: 3 возростная группа))",
        "Не правильно)) Подсказка: 5 возростная группа))",
        "Не правильно)) Подсказка: 1 возростная группа))",
        "Не правильно)) Подсказка: 3 возростная группа))",
        "Не правильно)) Подсказка: 4 возростная группа))",
        "Сканируй!"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view:View=inflater.inflate(R.layout.fragment7, container, false)
        openLink = view.findViewById(R.id.button5)
        bScanner = view.findViewById(R.id.button25)


        bScanner?.setOnClickListener{
            checkCameraPermission()
        }
        backButton = view.findViewById(R.id.imageButton)
        backButton?.setOnClickListener{
            view.findNavController().navigate(R.id.action_blankFragment7_to_blankFragment6)
        }

        return view
    }

    private fun checkCameraPermission(){//разрешение камеры
        if(ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(requireActivity(),
                arrayOf(Manifest.permission.CAMERA), 12)

        } else {
            bundle.putInt("fragment",7)
            flag_apdate = 1
            bundle.putInt("flag",flag_apdate)
            bundle.putString("uid7",arguments?.getString("uid7"))
            view?.findNavController()?.navigate(R.id.action_blankFragment7_to_scannerActivity, bundle)
        }
    }

    override fun onResume() {
        super.onResume()
        val link: EditText? = view?.findViewById(R.id.Link3)
        val link1: TextView? = view?.findViewById(R.id.Link2)
        val next_btn: Button? = view?.findViewById(R.id.button26)
        var txt:Int = 379903
        var count: Int = 0

        var quest = ""
        var help = ""
        if (link1 != null) {
            link1.setElegantTextHeight(true)
            link1.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE)
            link1.setSingleLine(false)
        }
        if(arguments?.getInt("key")==null){txt = 10}
        else{txt = arguments?.getInt("key")!!
        }
        if(arguments?.getInt("count")==null){count = 0}
        else{count = arguments?.getInt("count")!!
        }
        if(arguments?.getInt("flag")==null){flag_apdate = 0}
        else{flag_apdate = arguments?.getInt("flag")!!
        }
        bundle.putString("help","Плавильно продолжай!")
        if(arguments?.getString("quest")==null){quest = "abc"}
        else{link1?.text = arguments?.getString("quest")
            quest = arguments?.getString("quest")!!
        }
        if(arguments?.getString("help")==null){quest = "abc"}
        else{link?.setText(arguments?.getString("help"))
            help = arguments?.getString("help")!!
        }
        for(i in 0 .. 9) {
            if (txt == ListArrey[count] && count == i) {
                count += 1
                bundle.putInt("count",count)
                val uid = arguments?.getString("uid7")
                flag_apdate = 2
                user.child(uid!!).updateChildren(mapOf("score" to count))
                if(count == 9)
                {
                    dialogwin()
                }
                break
            }
        }

        bundle.putInt("flag",flag_apdate)
        next_btn?.setOnClickListener {
            var flag = true
            for(i in 0 .. QuestArrey.size-1){
                if (txt == ListArrey[count] && count == i) {
                    link1?.text = QuestArrey[i]
                    quest = QuestArrey[i]
                    link?.setText(HelpArrey[10])
                    bundle.putString("quest",quest)
                    flag = false
                    break
                }
            }
            if(flag) {
                Toast.makeText(
                    requireContext(),
                    "Отскань правильно и продолжай",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }

        if(flag_apdate == 0) {
            link?.setText(HelpArrey[10])
            link1?.text=QuestArrey[count]
            bundle.putString("help",help)
            bundle.putString("quest",QuestArrey[count])

        }else {
            if (flag_apdate == 1) {
                link?.setText(HelpArrey[count])
                link1?.text=QuestArrey[count]
                bundle.putString("help",help)
                bundle.putString("quest",QuestArrey[count])
            }else{
                link?.setText("Плавильно продолжай!")
                link1?.text=QuestArrey[count-1]
                flag_apdate = 0
            }
        }

    }
    fun dialogwin(){
        val dialogwin = Dialog(requireContext())
        dialogwin.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogwin.setContentView(R.layout.dialogwin)
        dialogwin.setCancelable(false)
        val btnbackmenu:Button = dialogwin.findViewById(R.id.backmenu)
        btnbackmenu.setOnClickListener {
            dialogwin.dismiss()
            findNavController().navigate(R.id.action_blankFragment7_to_blankFragment)

        }
        dialogwin.show()
    }
    override fun onRequestPermissionsResult(//разрешение камеры
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)


        if(requestCode == 12){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                startActivity(Intent(requireContext(), ScannerActivity::class.java))
            }
        }
    }
}