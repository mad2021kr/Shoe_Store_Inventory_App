package org.worldskills.shoestoreinventoryapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import org.worldskills.shoestoreinventoryapp.databinding.InstructionFragmentBinding
import org.worldskills.shoestoreinventoryapp.databinding.WelcomeFragmentBinding

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: WelcomeFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.welcome_fragment, container, false
        )

        binding.nextBtn.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_welcome_fragment_to_instruction_frgament)
        }

        return binding.root
    }


}