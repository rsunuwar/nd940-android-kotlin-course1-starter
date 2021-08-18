package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeListViewModel

/**
 * 8/15/2021
 */

class ShoeDetailFragment : Fragment() {

    private lateinit var shoeListViewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentShoeDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        // set arguments to the view
        val arguments = ShoeDetailFragmentArgs.fromBundle(requireArguments())
        if (!arguments.isNew) {

            arguments.shoe?.let { shoe ->
                binding.shoe = shoe
                binding.imageView.setImageResource(shoe.image)
            }
        }

        shoeListViewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)

        binding.buttonCancel.setOnClickListener {
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        binding.buttonSave.setOnClickListener {
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        return binding.root
    }
}
