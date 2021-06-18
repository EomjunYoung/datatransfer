package com.example.datatransfer

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.*
import androidx.navigation.fragment.findNavController
import com.example.datatransfer.databinding.FragmentFirstBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment(R.layout.fragment_first) {

    private lateinit var binding: FragmentFirstBinding
    //TODO: 만약 아래와같이(평소쓰던대로) 뷰모델을 만들면 액티비티가 아닌
    //TODO: 이 FirstFragment의 생명주기에 맞는 뷰모델이 생성되므로 화면전환시 파괴됨..
    //val mainViewModel by viewModels<MainViewModel>()

    //TODO: 이렇게해야 이 FirstFragment가 포함된 액티비티의 뷰모델을 사용함(액티비티 생명주기를 따름)
    val mainViewModel by activityViewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding = FragmentFirstBinding.inflate(layoutInflater)

        val binding2 = FragmentFirstBinding.bind(view) // fragment에서 viewBinding 하는법

        //TODO: Fragment간의 데이터공유를 위해 뷰모델이 아닌 Listener로 하는 방법
        //아래는 secondfragment에서 보낸 데이터를 받는 코드
        setFragmentResultListener("requestKey") { resultKey, bundle ->
            val data = bundle.getString("data", "")

            Toast.makeText(requireContext(), data, Toast.LENGTH_LONG).show()

        }

        binding2.button.setOnClickListener {

//            mainViewModel.data = "Hello"

            //TODO: Fragment간의 데이터공유를 위해 뷰모델이 아닌 방법 fragment2로 데이터를 보냄
            setFragmentResult("requestKey", bundleOf("data" to "hello"))
            //bundleof는 bundle을 만들어서 데이터를 넣는 방법임

            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)

        }
    }


}