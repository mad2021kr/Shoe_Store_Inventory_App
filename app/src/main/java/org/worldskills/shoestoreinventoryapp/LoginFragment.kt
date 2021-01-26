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
import org.worldskills.shoestoreinventoryapp.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: LoginFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.login_fragment, container, false
        )

        binding.newLoginBtn.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_login_frgament_to_welcome_fragment)
        }

        binding.existingAccountLoginBtn.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_login_frgament_to_welcome_fragment)
        }

        return binding.root
    }


}