package ru.samsung.itschool.myapplication

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import com.google.firebase.database.FirebaseDatabase


class BlankFragment2 : Fragment() {
    private val base = FirebaseDatabase.getInstance("https://robostem-f9d54-default-rtdb.firebaseio.com/").getReference("Comands")
    private var name:String? = null
    private var uid:String? = null
    private var key: String? = null
    private var linkarr:ArrayList<String> = ArrayList()
    private var openLink: Button? = null
    private var bScanner: Button? = null
    private  var backButton:ImageButton ?= null

    private val linkArray: Array<String> = arrayOf("http://robostem.ru/wp-content/uploads/2020/11/1-Биатлон.docx",//1-Биатлон
    "http://robostem.ru/wp-content/uploads/2020/11/1-%D0%9A%D0%B5%D0%B3%D0%B5%D0%BB%D1%8C%D1%80%D0%B8%D0%BD%D0%B3.docx",//1-Кегельринг
    "http://robostem.ru/wp-content/uploads/2020/11/1-%D0%9A%D0%B5%D0%B3%D0%B5%D0%BB%D1%8C%D1%80%D0%B8%D0%BD%D0%B3%D0%9A%D0%92%D0%90%D0%94%D0%A0%D0%9E.docx",//1-КегельрингКВАДРО
    "http://robostem.ru/wp-content/uploads/2020/11/1-%D0%9B%D0%B8%D0%BD%D0%B8%D1%8F.docx",//1-Линия
    "http://robostem.ru/wp-content/uploads/2020/11/2-%D0%9A%D0%B5%D0%B3%D0%B5%D0%BB%D1%8C%D1%80%D0%B8%D0%BD%D0%B3%D0%9A%D0%92%D0%90%D0%94%D0%A0%D0%9E.docx",//2-КегельрингКВАДРО
    "http://robostem.ru/wp-content/uploads/2020/11/2-%D0%A3%D0%B1%D0%BE%D1%80%D0%BA%D0%B0_%D0%BC%D1%83%D1%81%D0%BE%D1%80%D0%B0.docx",//2-Уборка_мусора
    "http://robostem.ru/wp-content/uploads/2020/11/2-%D0%A2%D1%80%D0%B0%D0%B5%D0%BA%D1%82%D0%BE%D1%80%D0%B8%D1%8F.docx",//2-Траектория
    "http://robostem.ru/wp-content/uploads/2020/11/2-%D0%93%D0%BE%D0%BD%D0%BA%D0%B0_%D1%88%D0%B0%D0%B3%D0%B0%D1%8E%D1%89%D0%B8%D1%85_%D1%80%D0%BE%D0%B1%D0%BE%D1%82%D0%BE%D0%B2.docx",//2-Гонка_шагающих_роботов
    "http://robostem.ru/wp-content/uploads/2021/10/2-%D0%9F%D0%BE%D0%BF%D0%B0%D0%B4%D0%B8-%D0%B2-%D1%86%D0%B5%D0%BB%D1%8C.docx",//2-Попади-в-цель
    "http://robostem.ru/wp-content/uploads/2021/10/2-%D0%B4%D0%BE%D1%81%D1%82%D0%B0%D0%B2%D0%BA%D0%B0-%D1%80%D1%83%D0%BB%D0%BE%D0%BD%D0%B0-%D0%B1%D1%83%D0%BC%D0%B0%D0%B3%D0%B8.docx",//2-доставка-рулона-бумаги
    "http://robostem.ru/wp-content/uploads/2020/11/3-%D0%97%D0%B5%D0%BC%D0%BB%D1%8F-%D0%A4%D1%80%D0%B0%D0%BD%D1%86%D0%B0-%D0%98%D0%BE%D1%81%D0%B8%D1%84%D0%B0.docx",//2-доставка-рулона-бумаги
    "http://robostem.ru/wp-content/uploads/2020/11/3-%D0%A3%D0%B1%D0%BE%D1%80%D0%BA%D0%B0_%D0%BC%D1%83%D1%81%D0%BE%D1%80%D0%B0.docx",//3-Земля-Франца-
    "http://robostem.ru/wp-content/uploads/2020/11/3-%D0%93%D0%BE%D0%BD%D0%BA%D0%B0_%D1%88%D0%B0%D0%B3%D0%B0%D1%8E%D1%89%D0%B8%D1%85_%D1%80%D0%BE%D0%B1%D0%BE%D1%82%D0%BE%D0%B2.docx",//3-Уборка_мусора
    "http://robostem.ru/wp-content/uploads/2020/11/3-%D0%9E%D1%87%D0%B8%D1%81%D1%82%D0%BA%D0%B0_%D0%B4%D0%BE%D1%80%D0%BE%D0%B3%D0%B8.docx",//3-Склад
    "http://robostem.ru/wp-content/uploads/2020/11/3-%D0%A1%D0%BA%D0%BB%D0%B0%D0%B4.docx",//4-Покатушки
    "http://robostem.ru/wp-content/uploads/2020/11/4-%D0%9F%D0%BE%D0%BA%D0%B0%D1%82%D1%83%D1%88%D0%BA%D0%B8.docx",//4-Уборка_Мусора
    "http://robostem.ru/wp-content/uploads/2020/11/4-%D0%A3%D0%B1%D0%BE%D1%80%D0%BA%D0%B0_%D0%9C%D1%83%D1%81%D0%BE%D1%80%D0%B0.docx",//4-Опасный_контейнер
    "http://robostem.ru/wp-content/uploads/2020/11/4-%D0%9E%D0%BF%D0%B0%D1%81%D0%BD%D1%8B%D0%B9_%D0%BA%D0%BE%D0%BD%D1%82%D0%B5%D0%B9%D0%BD%D0%B5%D1%80.docx",//4-Раздельный_сбор_отходов
    "http://robostem.ru/wp-content/uploads/2020/11/4-%D0%A0%D0%B0%D0%B7%D0%B4%D0%B5%D0%BB%D1%8C%D0%BD%D1%8B%D0%B9_%D1%81%D0%B1%D0%BE%D1%80_%D0%BE%D1%82%D1%85%D0%BE%D0%B4%D0%BE%D0%B2.docx",//5-Силач
    "http://robostem.ru/wp-content/uploads/2021/11/5-%D0%93%D0%BE%D0%BD%D0%BA%D0%B0_%D1%88%D0%B0%D0%B3%D0%B0%D1%8E%D1%89%D0%B8%D1%85_%D1%80%D0%BE%D0%B1%D0%BE%D1%82%D0%BE%D0%B2.docx",//5-Гонка_шагающих_роботов
    "http://robostem.ru/wp-content/uploads/2020/11/5-%D0%92%D1%8B%D1%85%D0%BE%D0%B4_%D0%B8%D0%B7_%D0%BB%D0%B0%D0%B1%D0%B8%D1%80%D0%B8%D0%BD%D1%82%D0%B0.docx",//5-Выход_из_лабиринта
    "http://robostem.ru/wp-content/uploads/2020/11/5-%D0%A5%D0%B0%D1%80%D0%B2%D0%B5%D1%81%D1%82%D0%B5%D1%80.docx",//5-Харвестер
    "http://robostem.ru/wp-content/uploads/2020/11/5-%D0%A8%D0%B5%D1%80%D0%B5%D0%BC%D0%B5%D1%82%D1%8C%D0%B5%D0%B2%D0%BE_%D0%93%D1%80%D1%83%D0%B7%D0%BE%D0%B2%D0%BE%D0%B9_-%D1%82%D0%B5%D1%80%D0%BC%D0%B8%D0%BD%D0%B0%D0%BB.docx",//5-Шереметьево_Грузовой_-терминал
    "http://robostem.ru/wp-content/uploads/2020/11/5-%D0%A1%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0_%D0%9E%D1%82%D1%85%D0%BE%D0%B4%D0%BE%D0%B2-2.docx",//5-Сортировка_Отходов-2
    "http://robostem.ru/wp-content/uploads/2021/10/5-%D0%B4%D0%BE%D1%81%D1%82%D0%B0%D0%B2%D0%BA%D0%B0-%D1%80%D1%83%D0%BB%D0%BE%D0%BD%D0%B0-%D0%B1%D1%83%D0%BC%D0%B0%D0%B3%D0%B8.docx",//5-доставка-рулона-бумаги
    "http://robostem.ru/wp-content/uploads/2020/11/SPIKE-%D0%9A%D0%B5%D0%B3%D0%B5%D0%BB%D1%8C%D1%80%D0%B8%D0%BD%D0%B3%D0%9A%D0%92%D0%90%D0%94%D0%A0%D0%9E.docx",//SPIKE-КегельрингКВАДРО
    "http://robostem.ru/wp-content/uploads/2020/11/SPIKE-%D0%9F%D0%BE%D0%B3%D1%80%D1%83%D0%B7%D1%87%D0%B8%D0%BA.docx",//SPIKE-Погрузчик
    "http://robostem.ru/wp-content/uploads/2020/11/SPIKE-%D0%A1%D0%BA%D0%BB%D0%B0%D0%B4-1.docx",// SPIKE-Склад-1
    "http://robostem.ru/wp-content/uploads/2020/11/SPIKE-%D0%9A%D0%BE%D0%BD%D1%82%D1%80%D0%BE%D0%BB%D0%B5%D1%80.docx",//SPIKE-Контролер
        "http://robostem.ru/wp-content/uploads/2020/11/SPIKE-%D0%91%D0%B8%D0%B0%D1%82%D0%BB%D0%BE%D0%BD.docx",//SPIKE-Биатлон
        "http://robostem.ru/wp-content/uploads/2021/11/SPIKE-%D0%A8%D0%BE%D1%80%D1%82-%D1%82%D1%80%D0%B5%D0%BA.docx",//SPIKE-Шорт-трек
        "http://robostem.ru/wp-content/uploads/2020/11/SPIKE-%D0%97%D0%A4%D0%98.docx",//SPIKE-ЗФИ
        "http://robostem.ru/wp-content/uploads/2021/10/SPIKE-%D0%9F%D0%BE%D0%BF%D0%B0%D0%B4%D0%B8-%D0%B2-%D1%86%D0%B5%D0%BB%D1%8C.docx",//SPIKE-Попади-в-цель
        "http://robostem.ru/wp-content/uploads/2021/10/SPIKE-%D0%B4%D0%BE%D1%81%D1%82%D0%B0%D0%B2%D0%BA%D0%B0-%D1%80%D1%83%D0%BB%D0%BE%D0%BD%D0%B0-%D0%B1%D1%83%D0%BC%D0%B0%D0%B3%D0%B8.docx",//=SPIKE-доставка-рулона-бумаги
    "http://robostem.ru/wp-content/uploads/2017/11/01-2-%D0%9A%D0%B5%D0%B3%D0%B5%D0%BB%D1%8C%D1%80%D0%B8%D0%BD%D0%B3.pdf",//Arduino - кегельринг5/7
    "http://robostem.ru/wp-content/uploads/2017/11/01-3-%D0%A2%D1%80%D0%B0%D0%B5%D0%BA%D1%82%D0%BE%D1%80%D0%B8%D1%8F.pdf",//arduiono - траектория5/7
        "http://robostem.ru/wp-content/uploads/2017/11/01-4-%D0%A8%D0%BE%D1%80%D1%82-%D1%82%D1%80%D0%B5%D0%BA.pdf",//arduiono - Шорт-трек5/7
        "http://robostem.ru/wp-content/uploads/2017/11/02%D0%B0-1-%D0%9A%D0%B5%D0%B3%D0%B5%D0%BB%D1%8C%D1%80%D0%B8%D0%BD%D0%B3.pdf",//Arduino - кегельринг8/11
    "http://robostem.ru/wp-content/uploads/2017/11/02%D0%B0-2-%D0%A2%D1%80%D0%B0%D0%B5%D0%BA%D1%82%D0%BE%D1%80%D0%B8%D1%8F.pdf",//arduiono - траектория8/11
        "http://robostem.ru/wp-content/uploads/2017/11/02%D0%B0-3-%D0%A8%D0%BE%D1%80%D1%82-%D1%82%D1%80%D0%B5%D0%BA.pdf",//arduiono - Шорт-трек8/11
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view:View=inflater.inflate(R.layout.fragment2, container, false)
        openLink = view.findViewById(R.id.button5)
        bScanner = view.findViewById(R.id.button9)
        bScanner?.setOnClickListener{
            checkCameraPermission()
        }
        name = arguments?.getString("name")
        backButton = view.findViewById(R.id.imageButton)
        backButton?.setOnClickListener{
            view.findNavController().navigate(R.id.action_blankFragment2_to_blankFragment)
        }
        uid = arguments?.getString("uid")
        key = base.child(uid!!).key
        checktext()
        return view
    }


    private fun checktext(){
        val txt:Int? =arguments?.getInt("key")
        openLink?.setOnClickListener {
            when (txt) {
                268393 -> {
                    //1-Биатлон
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[0]))
                    startActivity(i)
                }
                309980 -> {
                    //1-Кегельринг
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[1]))
                    startActivity(i)
                }
                694069 -> {
                    //1-КегельрингКВАДРО
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[2]))
                    startActivity(i)
                }
                812709 -> {
                    //1-Линия
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[3]))
                    startActivity(i)
                }
                456793 -> {
                    //2-КегельрингКВАДРО
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[4]))
                    startActivity(i)
                }
                365599 -> {
                    //2-Уборка_мусора
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[5]))
                    startActivity(i)
                }
                581023 -> {
                    //2-Траектория
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[6]))
                    startActivity(i)
                }
                379903 -> {
                    //2-Гонка_шагающих_роботов
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[7]))
                    startActivity(i)
                }
                108990 -> {
                    //2-Попади-в-цель
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[8]))
                    startActivity(i)
                }
                942876 -> {
                    //2-доставка-рулона-бумаги
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[9]))
                    startActivity(i)
                }
                186795 -> {
                    //3-Земля-Франца-
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[10]))
                    startActivity(i)
                }
                699833 -> {
                    //3-Уборка_мусора
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[11]))
                    startActivity(i)
                }
                782301 -> {
                    //3-Гонка_шагающих_роботов
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[12]))
                    startActivity(i)
                }
                865460 -> {
                    //3-Очистка_дороги
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[13]))
                    startActivity(i)
                }
                226501 -> {
                    //3-Склад
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[14]))
                    startActivity(i)
                }
                267336 -> {
                    //4-Покатушки
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[15]))
                    startActivity(i)
                }
                881560 -> {
                    //4-Уборка_Мусора
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[16]))
                    startActivity(i)
                }
                566588 -> {
                    //4-Опасный_контейнер
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[17]))
                    startActivity(i)
                }
                935956 -> {
                    //4-Раздельный_сбор_отходов
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[18]))
                    startActivity(i)
                }
                627352 -> {
                    //5-Силач
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[19]))
                    startActivity(i)
                }
                452561 -> {
                    //5-Гонка_шагающих_роботов
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[20]))
                    startActivity(i)
                }
                439932 -> {
                    //5-Выход_из_лабиринта
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[21]))
                    startActivity(i)
                }
                253343 -> {
                    //5-Харвестер
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[22]))
                    startActivity(i)
                }
                588727 -> {
                    //5-Шереметьево_Грузовой_-терминал
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[23]))
                    startActivity(i)
                }
                360887 -> {
                    //5-Сортировка_Отходов-2
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[24]))
                    startActivity(i)
                }
                695409 -> {
                    //5-доставка-рулона-бумаги
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[25]))
                    startActivity(i)
                }
                636057 -> {
                    //SPIKE-КегельрингКВАДРО
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[26]))
                    startActivity(i)
                }
                467045 -> {
                    //SPIKE-Погрузчик
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[27]))
                    startActivity(i)
                }
                106935 -> {
                    //SPIKE-Склад-1
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[28]))
                    startActivity(i)
                }
                674124 -> {
                    //SPIKE-Контролер
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[29]))
                    startActivity(i)
                }
                412107 -> {
                    //SPIKE-Биатлон
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[30]))
                    startActivity(i)
                }
                408253 -> {
                    //SPIKE-Шорт-трек
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[31]))
                    startActivity(i)
                }
                376126 -> {
                    //SPIKE-ЗФИ
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[32]))
                    startActivity(i)
                }
                643071 -> {
                    //SPIKE-Попади-в-цель
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[33]))
                    startActivity(i)
                }
                840921 -> {
                    //=SPIKE-доставка-рулона-бумаги
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(linkArray[34]))
                    startActivity(i)
                }

                else -> { // Note the block
                    Toast.makeText(requireContext(),"Не обнаружено файла соревнований",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    private fun checkCameraPermission(){//разрешение камеры
        if(ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(requireActivity(),
                arrayOf(Manifest.permission.CAMERA), 12)

        } else {
            val bundle = Bundle()
            bundle.putString("name",name)
            bundle.putString("uid",arguments?.getString("uid"))
            bundle.putStringArrayList("link",linkarr)
            view?.findNavController()?.navigate(R.id.action_blankFragment2_to_scannerActivity,bundle)
           // startActivity(Intent(requireContext(), ScannerActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        checkQR()

    }

    private fun setdataBaselink(save:String){
        linkarr = arguments?.getStringArrayList("link")!!
        linkarr.add(save)
        val listarr = HashMap<String,Any?>()
        for((i,e) in linkarr.withIndex())
        {
            listarr[i.toString()] = e
        }
        base.child(uid!!).child("zadacha").updateChildren(listarr)
    }

    private fun checkQR(){
        val link: EditText? = view?.findViewById(R.id.Link)
        val txt:Int? =arguments?.getInt("key")
        when (txt) {
            268393 -> {
                link?.setText(linkArray[0])
                //1-Биатлон
                setdataBaselink(linkArray[0])
            }
            309980 -> {
                link?.setText(linkArray[1])
                //1-Кегельринг
                setdataBaselink(linkArray[1])
            }
            694069 -> {
                link?.setText(linkArray[2])
                //1-КегельрингКВАДРО
                setdataBaselink(linkArray[2])
            }
            812709 -> {
                link?.setText(linkArray[3])
                //1-Линия
                setdataBaselink(linkArray[3])
            }
            456793 -> {
                link?.setText(linkArray[4])
                //2-КегельрингКВАДРО
                setdataBaselink(linkArray[4])
            }
            365599 -> {
                link?.setText(linkArray[5])
                //2-Уборка_мусора
                setdataBaselink(linkArray[5])
            }
            581023 -> {
                link?.setText(linkArray[6])
                //2-Траектория
                setdataBaselink(linkArray[6])
            }
            379903 -> {
                link?.setText(linkArray[7])
                //2-Гонка_шагающих_роботов
                setdataBaselink(linkArray[7])
            }
            108990 -> {
                link?.setText(linkArray[8])
                //2-Попади-в-цель
                setdataBaselink(linkArray[8])
            }
            942876 -> {
                link?.setText(linkArray[9])
                //2-доставка-рулона-бумаги
                setdataBaselink(linkArray[9])
            }
            186795 -> {
                link?.setText(linkArray[10])
                //3-Земля-Франца-
                setdataBaselink(linkArray[10])
            }
            699833 -> {
                link?.setText(linkArray[11])
                //3-Уборка_мусора
                setdataBaselink(linkArray[11])
            }
            782301 -> {
                link?.setText(linkArray[12])
                //3-Гонка_шагающих_роботов
                setdataBaselink(linkArray[12])
            }
            865460 -> {
                link?.setText(linkArray[13])
                //3-Очистка_дороги
                setdataBaselink(linkArray[13])
            }
            226501 -> {
                link?.setText(linkArray[14])
                //3-Склад
                setdataBaselink(linkArray[14])
            }
            267336 -> {
                link?.setText(linkArray[15])
                //4-Покатушки
                setdataBaselink(linkArray[15])
            }
            881560 -> {
                link?.setText(linkArray[16])
                //4-Уборка_Мусора
                setdataBaselink(linkArray[16])
            }
            566588 -> {
                link?.setText(linkArray[17])
                //4-Опасный_контейнер
                setdataBaselink(linkArray[17])
            }
            935956 -> {
                link?.setText(linkArray[18])
                //4-Раздельный_сбор_отходов
                setdataBaselink(linkArray[18])
            }
            627352 -> {
                link?.setText(linkArray[19])
                //5-Силач
                setdataBaselink(linkArray[19])
            }
            452561 -> {
                link?.setText(linkArray[20])
                //5-Гонка_шагающих_роботов
                setdataBaselink(linkArray[20])
            }
            439932 -> {
                link?.setText(linkArray[21])
                //5-Выход_из_лабиринта
                setdataBaselink(linkArray[21])
            }
            253343 -> {
                link?.setText(linkArray[22])
                //5-Харвестер
                setdataBaselink(linkArray[22])
            }
            588727 -> {
                link?.setText(linkArray[23])
                //5-Шереметьево_Грузовой_-терминал
                setdataBaselink(linkArray[23])
            }
            360887 -> {
                link?.setText(linkArray[24])
                //5-Сортировка_Отходов-2
                setdataBaselink(linkArray[24])
            }
            695409 -> {
                link?.setText(linkArray[25])
                //5-доставка-рулона-бумаги
                setdataBaselink(linkArray[25])
            }
            636057 -> {
                link?.setText(linkArray[26])
                //SPIKE-КегельрингКВАДРО
                setdataBaselink(linkArray[26])
            }
            467045 -> {
                link?.setText(linkArray[27])
                //SPIKE-Погрузчик
                setdataBaselink(linkArray[27])
            }
            106935 -> {
                link?.setText(linkArray[28])
                //SPIKE-Склад-1
                setdataBaselink(linkArray[28])
            }
            674124 -> {
                link?.setText(linkArray[29])
                //SPIKE-Контролер
                setdataBaselink(linkArray[29])
            }
            412107 -> {
                link?.setText(linkArray[30])
                //SPIKE-Биатлон
                setdataBaselink(linkArray[30])
            }
            408253 -> {
                link?.setText(linkArray[31])
                //SPIKE-Шорт-трек
                setdataBaselink(linkArray[31])
            }
            376126 -> {
                link?.setText(linkArray[32])
                //SPIKE-ЗФИ
                setdataBaselink(linkArray[32])
            }
            643071 -> {
                link?.setText(linkArray[33])
                //SPIKE-Попади-в-цель
                setdataBaselink(linkArray[33])
            }
            840921 -> {
                link?.setText(linkArray[34])
                //=SPIKE-доставка-рулона-бумаги
                setdataBaselink(linkArray[34])
            }

            else -> { // Note the block

                val nax = arguments?.getString("error")
                if(nax == null){
                    link?.setText("Гы гы гы )))) Не то")
                }
                link?.setText(nax)
            }
        }
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

