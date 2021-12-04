package com.proyect.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.proyect.fragments.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnNewFragment.setOnClickListener {
            activity?.let {
                println(it.actionBar)
                it.actionBar?.setDisplayHomeAsUpEnabled(true)
                it.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment_activity_main, NewFragment())
                    .addToBackStack("New Fragment")
                    .commit()


            }
        }
    }

}