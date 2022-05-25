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
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController


class BlankFragment5 : Fragment() {
    private var openLink: Button? = null
    private var bScanner: Button? = null
    private var gameBscan: Button? = null
    private  var backButton: ImageButton?= null
    val bundle = Bundle()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View=inflater.inflate(R.layout.fragment5, container, false)
        openLink = view.findViewById(R.id.button14)
        bScanner = view.findViewById(R.id.button13)
        gameBscan = view.findViewById(R.id.button15)
        backButton = view.findViewById(R.id.imageButton2)
        bScanner?.setOnClickListener{
            checkCameraPermission()
        }
        backButton?.setOnClickListener{
            view.findNavController().navigate(R.id.action_blankFragment5_to_blankFragment)
        }
        gameBscan?.setOnClickListener{
            view.findNavController().navigate(R.id.action_blankFragment5_to_blankFragment6)
        }
        checktext()


        return view
    }


    private fun checktext(){
        val txt:Int? =arguments?.getInt("key")
        openLink?.setOnClickListener {
            when (txt) {
                268393 -> {
                    //1-Биатлон
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[0]))
                    startActivity(i)
                }
                309980 -> {
                    //1-Кегельринг
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[1]))
                    startActivity(i)
                }
                694069 -> {
                    //1-КегельрингКВАДРО
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[2]))
                    startActivity(i)
                }
                812709 -> {
                    //1-Линия
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[3]))
                    startActivity(i)
                }
                456793 -> {
                    //2-КегельрингКВАДРО
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[4]))
                    startActivity(i)
                }
                365599 -> {
                    //2-Уборка_мусора
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[5]))
                    startActivity(i)
                }
                581023 -> {
                    //2-Траектория
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[6]))
                    startActivity(i)
                }
                379903 -> {
                    //2-Гонка_шагающих_роботов
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[7]))
                    startActivity(i)
                }
                108990 -> {
                    //2-Попади-в-цель
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[8]))
                    startActivity(i)
                }
                942876 -> {
                    //2-доставка-рулона-бумаги
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[9]))
                    startActivity(i)
                }
                186795 -> {
                    //3-Земля-Франца-
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[10]))
                    startActivity(i)
                }
                699833 -> {
                    //3-Уборка_мусора
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[11]))
                    startActivity(i)
                }
                782301 -> {
                    //3-Гонка_шагающих_роботов
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[12]))
                    startActivity(i)
                }
                865460 -> {
                    //3-Очистка_дороги
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[13]))
                    startActivity(i)
                }
                226501 -> {
                    //3-Склад
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[14]))
                    startActivity(i)
                }
                267336 -> {
                    //4-Покатушки
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[15]))
                    startActivity(i)
                }
                881560 -> {
                    //4-Уборка_Мусора
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[16]))
                    startActivity(i)
                }
                566588 -> {
                    //4-Опасный_контейнер
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[17]))
                    startActivity(i)
                }
                935956 -> {
                    //4-Раздельный_сбор_отходов
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[18]))
                    startActivity(i)
                }
                627352 -> {
                    //5-Силач
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[19]))
                    startActivity(i)
                }
                452561 -> {
                    //5-Гонка_шагающих_роботов
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[20]))
                    startActivity(i)
                }
                439932 -> {
                    //5-Выход_из_лабиринта
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[21]))
                    startActivity(i)
                }
                253343 -> {
                    //5-Харвестер
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[22]))
                    startActivity(i)
                }
                588727 -> {
                    //5-Шереметьево_Грузовой_-терминал
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[23]))
                    startActivity(i)
                }
                360887 -> {
                    //5-Сортировка_Отходов-2
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[24]))
                    startActivity(i)
                }
                695409 -> {
                    //5-доставка-рулона-бумаги
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[25]))
                    startActivity(i)
                }
                636057 -> {
                    //SPIKE-КегельрингКВАДРО
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[26]))
                    startActivity(i)
                }
                467045 -> {
                    //SPIKE-Погрузчик
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[27]))
                    startActivity(i)
                }
                106935 -> {
                    //SPIKE-Склад-1
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[28]))
                    startActivity(i)
                }
                674124 -> {
                    //SPIKE-Контролер
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[29]))
                    startActivity(i)
                }
                412107 -> {
                    //SPIKE-Биатлон
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[30]))
                    startActivity(i)
                }
                408253 -> {
                    //SPIKE-Шорт-трек
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[31]))
                    startActivity(i)
                }
                376126 -> {
                    //SPIKE-ЗФИ
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[32]))
                    startActivity(i)
                }
                643071 -> {
                    //SPIKE-Попади-в-цель
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[33]))
                    startActivity(i)
                }
                840921 -> {
                    //=SPIKE-доставка-рулона-бумаги
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(BlankFragment2().linkArray[34]))
                    startActivity(i)
                }

                else -> { // Note the block
                    Toast.makeText(requireContext(),"Не обнаружено файла соревнований", Toast.LENGTH_SHORT).show()
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
            bundle.putInt("fragment",5)
            view?.findNavController()?.navigate(R.id.action_blankFragment5_to_scannerActivity,bundle)
            // startActivity(Intent(requireContext(), ScannerActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        checkQR()

    }

    private fun checkQR(){
        val link: EditText? = view?.findViewById(R.id.Link)
        val txt:Int? =arguments?.getInt("key")
        when (txt) {
            268393 -> {
                link?.setText(BlankFragment2().linkArray[0])
                //1-Биатлон
                //setdataBaselink(BlankFragment2().linkArray[0])
            }
            309980 -> {
                link?.setText(BlankFragment2().linkArray[1])
                //1-Кегельринг
                //setdataBaselink(BlankFragment2().linkArray[1])
            }
            694069 -> {
                link?.setText(BlankFragment2().linkArray[2])
                //1-КегельрингКВАДРО
                //setdataBaselink(linkArray[2])
            }
            812709 -> {
                link?.setText(BlankFragment2().linkArray[3])
                //1-Линия
                //setdataBaselink(linkArray[3])
            }
            456793 -> {
                link?.setText(BlankFragment2().linkArray[4])
                //2-КегельрингКВАДРО
                //setdataBaselink(linkArray[4])
            }
            365599 -> {
                link?.setText(BlankFragment2().linkArray[5])
                //2-Уборка_мусора
                //setdataBaselink(linkArray[5])
            }
            581023 -> {
                link?.setText(BlankFragment2().linkArray[6])
                //2-Траектория
                //setdataBaselink(linkArray[6])
            }
            379903 -> {
                link?.setText(BlankFragment2().linkArray[7])
                //2-Гонка_шагающих_роботов
                //setdataBaselink(linkArray[7])
            }
            108990 -> {
                link?.setText(BlankFragment2().linkArray[8])
                //2-Попади-в-цель
                //setdataBaselink(linkArray[8])
            }
            942876 -> {
                link?.setText(BlankFragment2().linkArray[9])
                //2-доставка-рулона-бумаги
                //setdataBaselink(linkArray[9])
            }
            186795 -> {
                link?.setText(BlankFragment2().linkArray[10])
                //3-Земля-Франца-
                //setdataBaselink(linkArray[10])
            }
            699833 -> {
                link?.setText(BlankFragment2().linkArray[11])
                //3-Уборка_мусора
                //setdataBaselink(linkArray[11])
            }
            782301 -> {
                link?.setText(BlankFragment2().linkArray[12])
                //3-Гонка_шагающих_роботов
                //setdataBaselink(linkArray[12])
            }
            865460 -> {
                link?.setText(BlankFragment2().linkArray[13])
                //3-Очистка_дороги
                //setdataBaselink(linkArray[13])
            }
            226501 -> {
                link?.setText(BlankFragment2().linkArray[14])
                //3-Склад
                //setdataBaselink(linkArray[14])
            }
            267336 -> {
                link?.setText(BlankFragment2().linkArray[15])
                //4-Покатушки
                //setdataBaselink(linkArray[15])
            }
            881560 -> {
                link?.setText(BlankFragment2().linkArray[16])
                //4-Уборка_Мусора
                //setdataBaselink(linkArray[16])
            }
            566588 -> {
                link?.setText(BlankFragment2().linkArray[17])
                //4-Опасный_контейнер
                //setdataBaselink(linkArray[17])
            }
            935956 -> {
                link?.setText(BlankFragment2().linkArray[18])
                //4-Раздельный_сбор_отходов
                //setdataBaselink(linkArray[18])
            }
            627352 -> {
                link?.setText(BlankFragment2().linkArray[19])
                //5-Силач
                //setdataBaselink(linkArray[19])
            }
            452561 -> {
                link?.setText(BlankFragment2().linkArray[20])
                //5-Гонка_шагающих_роботов
                //setdataBaselink(linkArray[20])
            }
            439932 -> {
                link?.setText(BlankFragment2().linkArray[21])
                //5-Выход_из_лабиринта
                //setdataBaselink(linkArray[21])
            }
            253343 -> {
                link?.setText(BlankFragment2().linkArray[22])
                //5-Харвестер
                //setdataBaselink(linkArray[22])
            }
            588727 -> {
                link?.setText(BlankFragment2().linkArray[23])
                //5-Шереметьево_Грузовой_-терминал
                //setdataBaselink(linkArray[23])
            }
            360887 -> {
                link?.setText(BlankFragment2().linkArray[24])
                //5-Сортировка_Отходов-2
                //setdataBaselink(linkArray[24])
            }
            695409 -> {
                link?.setText(BlankFragment2().linkArray[25])
                //5-доставка-рулона-бумаги
                //setdataBaselink(linkArray[25])
            }
            636057 -> {
                link?.setText(BlankFragment2().linkArray[26])
                //SPIKE-КегельрингКВАДРО
                //setdataBaselink(linkArray[26])
            }
            467045 -> {
                link?.setText(BlankFragment2().linkArray[27])
                //SPIKE-Погрузчик
                //setdataBaselink(linkArray[27])
            }
            106935 -> {
                link?.setText(BlankFragment2().linkArray[28])
                //SPIKE-Склад-1
                //setdataBaselink(linkArray[28])
            }
            674124 -> {
                link?.setText(BlankFragment2().linkArray[29])
                //SPIKE-Контролер
                //setdataBaselink(linkArray[29])
            }
            412107 -> {
                link?.setText(BlankFragment2().linkArray[30])
                //SPIKE-Биатлон
                //setdataBaselink(linkArray[30])
            }
            408253 -> {
                link?.setText(BlankFragment2().linkArray[31])
                //SPIKE-Шорт-трек
                //setdataBaselink(linkArray[31])
            }
            376126 -> {
                link?.setText(BlankFragment2().linkArray[32])
                //SPIKE-ЗФИ
                //setdataBaselink(linkArray[32])
            }
            643071 -> {
                link?.setText(BlankFragment2().linkArray[33])
                //SPIKE-Попади-в-цель
                //setdataBaselink(linkArray[33])
            }
            840921 -> {
                link?.setText(BlankFragment2().linkArray[34])
                //=SPIKE-доставка-рулона-бумаги
                //setdataBaselink(linkArray[34])
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