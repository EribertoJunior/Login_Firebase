package com.eriberto.loginfirebase.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.eriberto.loginfirebase.databinding.FragmentHomeBinding
import com.eriberto.loginfirebase.ui.login.LoginFragment.Companion.CHAVE_IMAGEM_LOGIN_LOGO

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val controlador by lazy { findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        carregarImagem()
        configuraBotaoLoginEmail()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun configuraBotaoLoginEmail() {
        binding.loginEmail.setOnClickListener {
            val extras = FragmentNavigatorExtras(binding.ivLogo to CHAVE_IMAGEM_LOGIN_LOGO)
            val direcao = HomeFragmentDirections.actionHomeFragmentToLoginFragment()
            controlador.navigate(direcao, extras)
        }
    }

    private fun carregarImagem() {
        val imageView = binding.ivLogo
        context?.let {
            Glide.with(it)
                .load("https://rockcontent.com/br/wp-content/uploads/sites/2/2019/04/firebase.png")
                .circleCrop()
                .into(imageView)
        }
    }
}