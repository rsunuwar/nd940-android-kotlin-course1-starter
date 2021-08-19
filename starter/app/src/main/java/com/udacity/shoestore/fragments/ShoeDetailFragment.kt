package com.udacity.shoestore.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        addTextWatcher()

        // set arguments to the view
        val arguments = ShoeDetailFragmentArgs.fromBundle(requireArguments())
        val isNew = arguments.isNew

        if (!isNew) {
            arguments.shoe?.let { shoe ->
                binding.shoe = shoe
                binding.imageView.setImageResource(shoe.image)
                binding.textViewPrice.setText("$${shoe.price}")
                binding.textViewSize.setText(shoe.size.toString())
            }
            binding.buttonSave.text = "OK"
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

    private fun addTextWatcher() {

        // textWatcher to enable buttons
        val textWatcher = object : TextWatcher {

            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val enableButton = binding.textViewName.text.toString().trim().isNotEmpty() &&
                        binding.textViewPrice.text.toString().trim().isNotEmpty() &&
                        binding.textViewSize.text.toString().trim().isNotEmpty()

                binding.buttonSave.isEnabled = enableButton
            }
        }

        binding.textViewName.addTextChangedListener(textWatcher)
        binding.textViewPrice.addTextChangedListener(textWatcher)
        binding.textViewSize.addTextChangedListener(textWatcher)
    }
}
