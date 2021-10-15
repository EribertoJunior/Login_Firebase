package com.eriberto.loginfirebase.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.eriberto.loginfirebase.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        carregarImagem()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun carregarImagem() {
        val imageView = binding.imageView
        context?.let {
            Glide.with(it)
                .load("https://rockcontent.com/br/wp-content/uploads/sites/2/2019/04/firebase.png")
                .circleCrop()
                .into(imageView)
        }
    }
}