package com.udacity.shoestore.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_login, container, false)

        val binding: FragmentLoginBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        // textWatcher to enable buttons
        val textWatcher = object : TextWatcher {

            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val enableButton = binding.textEmail.text.toString().trim().isNotEmpty() &&
                        binding.textPassword.text.toString().trim().isNotEmpty()

                binding.buttonLogin.isEnabled = enableButton
                binding.buttonSignup.isEnabled = enableButton
            }
        }

        binding.textEmail.addTextChangedListener(textWatcher)
        binding.textPassword.addTextChangedListener(textWatcher)

        // navigation
        binding.buttonLogin.setOnClickListener { view ->
            view.findNavController()
                .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }
        binding.buttonSignup.setOnClickListener { view ->
            view.findNavController()
                .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }

        return binding.root
    }
}
