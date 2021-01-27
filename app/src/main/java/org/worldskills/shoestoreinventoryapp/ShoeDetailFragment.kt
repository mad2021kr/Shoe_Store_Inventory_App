package org.worldskills.shoestoreinventoryapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import org.worldskills.shoestoreinventoryapp.databinding.InstructionFragmentBinding
import org.worldskills.shoestoreinventoryapp.databinding.ShoeDetailFragmentBinding

class ShoeDetailFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: ShoeDetailFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_detail_fragment, container, false
        )

        binding.lifecycleOwner = this
        binding.viewModel = viewModel


//        binding.saveBtn.setOnClickListener {
//            if (binding.nameEditText.text.isEmpty() || binding.companyEditText.text.isEmpty()
//                || binding.descriptionEditText.text.isEmpty() || binding.sizeEditText.text.isEmpty())
//                Toast.makeText(requireContext(), "Empty Field!", Toast.LENGTH_SHORT).show()
//            else {
////                viewModel.addShoeData(ShoeDetail(binding.nameEditText.text.toString(), binding.companyEditText.text.toString(), binding.sizeEditText.text.toString().toInt(), binding.descriptionEditText.text.toString()))
//                Toast.makeText(requireContext(), "Success!", Toast.LENGTH_SHORT).show()
//                Navigation.findNavController(binding.root).navigate(R.id.action_shoe_detail_fragment_to_shoe_list_frgament)
//            }
//        }

        binding.cancelBtn.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_shoe_detail_fragment_to_shoe_list_frgament)
        }

        return binding.root
    }


}