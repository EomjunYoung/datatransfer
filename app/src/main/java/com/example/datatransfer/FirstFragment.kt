package com.example.datatransfer

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding = FragmentFirstBinding.inflate(layoutInflater)

        val binding2 = FragmentFirstBinding.bind(view) // fragment에서 viewBinding 하는법

        binding2.button.setOnClickListener {

            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)

        }
    }


}