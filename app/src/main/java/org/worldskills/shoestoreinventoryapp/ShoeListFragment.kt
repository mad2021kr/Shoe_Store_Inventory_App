package org.worldskills.shoestoreinventoryapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import org.worldskills.shoestoreinventoryapp.databinding.InstructionFragmentBinding
import org.worldskills.shoestoreinventoryapp.databinding.ShoeListFragmentBinding
import java.lang.StringBuilder

class ShoeListFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()
    private lateinit var binding: ShoeListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.shoe_list_fragment, container, false)

        setHasOptionsMenu(true)

        binding.floatingBtn.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_shoe_list_frgament_to_shoe_detail_fragment)
        }

        viewModel.shoeMutableList.observe(viewLifecycleOwner, Observer {
            for (i in 0 until it.size) {
                val str = it[i].name + ", " + it[i].company + ", " + it[i].description + ", " + it[i].size
                val textView = TextView(requireContext())
                val lp = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                textView.text = str
                textView.layoutParams = lp
                textView.id = ViewCompat.generateViewId()

                binding.addArea.addView(textView)
            }
        })

        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> Navigation.findNavController(binding.root).navigate(R.id.action_shoe_list_frgament_to_login_frgament)
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_logout, menu)
    }
}