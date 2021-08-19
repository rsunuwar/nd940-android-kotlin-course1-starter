package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.ShoeListViewModel

/**
 * 8/11/2021
 */
class ShoeListFragment : Fragment() {

    private val shoeListViewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentShoeListBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        //shoeListViewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)

        val layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutParams.setMargins(30, 10, 15, 10)

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(
                ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment(
                    isNew = true,
                    shoe = null
                )
            )
        }

        shoeListViewModel.shoeList.observe(this, Observer { shoeList ->

            shoeList.forEach { shoe ->
                val textView = TextView(context)
                textView.layoutParams = layoutParams
                textView.text = shoe.name
                textView.textSize = 20.0F
                textView.setOnClickListener {
                    findNavController().navigate(
                        ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment(
                            isNew = false,
                            shoe = shoe
                        )
                    )
                }
                binding.shoeItems.addView(textView)
            }
        })

        /**
         * Code review suggestion:-
         *  you can add some dynamic shoe images in future to enhance the user experience.
         *  To show Images, I would recommend you to use either of the following libraries:

        Coil -> this is the latest library with complete Kotlin support along with coroutines support
        Glide -> this is the age old library which is the most recommended for larger projects as its evolved very over the years
         *
         */

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}
