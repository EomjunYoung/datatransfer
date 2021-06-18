package com.example.datatransfer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.datatransfer.databinding.FragmentFirstBinding
import com.example.datatransfer.databinding.FragmentSecondBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment(R.layout.fragment_second) {
//    val mainViewModel by activityViewModels<MainViewModel>()

    //onCreateView는 View를 생성하는 메소드이며, 해당 메소드에서 return한 view가
    //onViewCreate가 받는것임(fragment)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Fragment에서 Context 받는법
//        Toast.makeText(requireContext(), mainViewModel.data, Toast.LENGTH_LONG).show()

        val binding = FragmentSecondBinding.bind(view)

            //TODO: Fragment간의 데이터공유를 위해 뷰모델이 아닌 Listener로 하는 방법
            //아래는 firstfragment에서 보낸 데이터를 받는 코드
            setFragmentResultListener("requestKey") { resultKey, bundle ->
                val data = bundle.getString("data", "")

                Toast.makeText(requireContext(), data, Toast.LENGTH_LONG).show()

            }
        binding.button2.setOnClickListener {

            //TODO: Fragment간의 데이터공유를 위해 뷰모델이 아닌 방법 firstfragment로 데이터를 보냄
            setFragmentResult("requestKey", bundleOf("data" to "hello2"))
            //bundleof는 bundle을 만들어서 데이터를 넣는 방법임

            findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
           }

    }
}