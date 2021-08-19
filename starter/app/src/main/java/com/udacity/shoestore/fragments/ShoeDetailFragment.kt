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
        val isNew = arguments.isNew

        if (!isNew) {
            arguments.shoe?.let { shoe ->
                binding.shoe = shoe
                binding.imageView.setImageResource(shoe.image)
            }
            binding.buttonSave.text = "OK"
        } else {
            binding.textViewPrice.setText("")
            binding.textViewSize.setText("")
        }

        shoeListViewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)

        binding.buttonCancel.setOnClickListener {
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        binding.buttonSave.setOnClickListener {

            if (isNew) {
                val shoe = Shoe(
                    name = binding.textViewName.text.toString(),
                    company = binding.textViewCompany.text.toString(),
                    price = binding.textViewPrice.text.toString().toDouble(),
                    size = binding.textViewSize.text.toString().toDouble(),
                    description = binding.textViewDescription.text.toString()
                )
                shoeListViewModel.onSave(shoe)
            }

            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        return binding.root
    }
}
