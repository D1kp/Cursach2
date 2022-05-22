package ru.samsung.itschool.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import me.dm7.barcodescanner.zbar.Result
import me.dm7.barcodescanner.zbar.ZBarScannerView

class ScannerActivity : Fragment(), ZBarScannerView.ResultHandler {
    private lateinit var zbView: ZBarScannerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        zbView = ZBarScannerView(requireContext())

        return zbView
    }

    //zbView = ZBarScannerView(this)
    //setContentView(zbView)
    override fun onPause() {
        super.onPause()
        zbView.stopCamera()
    }

    override fun onResume() {
        super.onResume()
        zbView.setResultHandler(this)
        zbView.startCamera()
    }

    override fun handleResult(result: Result?) {
        Log.d("MyLog","Result:${result?.contents}")
        val qr:Int? = result?.contents?.toIntOrNull()
        val bundle = Bundle()
        if (qr != null) {
            bundle.putInt("key",qr)
        }
        else{
            bundle.putString("error","Гы гы гы )))) Не то")
        }
        val fragment:Int? =arguments?.getInt("fragment")
        bundle.putInt("count", arguments?.getInt("count")!!)
        bundle.putString("quest", arguments?.getString("quest"))
        bundle.putString("help", arguments?.getString("help"))
        when (fragment) {
            7 -> view?.findNavController()?.navigate(R.id.action_scannerActivity_to_blankFragment7,bundle)
            5 -> view?.findNavController()?.navigate(R.id.action_scannerActivity_to_blankFragment5,bundle)
            else -> { // Note the block
                view?.findNavController()?.navigate(R.id.action_scannerActivity_to_blankFragment2,bundle)
            }
        }

    }
}