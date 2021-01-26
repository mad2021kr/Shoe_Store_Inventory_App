package org.worldskills.shoestoreinventoryapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import org.worldskills.shoestoreinventoryapp.databinding.InstructionFragmentBinding
import org.worldskills.shoestoreinventoryapp.databinding.ShoeListFragmentBinding
import java.lang.StringBuilder

class ShoeListFragment : Fragment() {

    private lateinit var viewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: ShoeListFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_list_fragment, container, false
        )

        viewModel = ViewModelProviders.of(this).get(ShoeViewModel::class.java)

        binding.floatingBtn.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_shoe_list_frgament_to_shoe_detail_fragment)
        }

        viewModel.shoeMutableList.observe(viewLifecycleOwner, Observer {
            val result = StringBuilder()

            for (i in 0 until viewModel.shoeMutableList.value!!.size) {
                result.append(viewModel.shoeMutableList.value!![i].name + ", \n")
            }

            binding.shoeItemTextView.text = result
        })

        return binding.root
    }


}