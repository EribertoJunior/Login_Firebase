package com.eriberto.loginfirebase.ui.login

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.eriberto.loginfirebase.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    companion object {
        const val CHAVE_IMAGEM_LOGIN_LOGO = "login_logo"
    }

    private var _binding: FragmentLoginBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val animacao =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        sharedElementEnterTransition = animacao
        sharedElementReturnTransition = animacao
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
        ViewCompat.setTransitionName(binding.ivLogo, CHAVE_IMAGEM_LOGIN_LOGO)
        carregarImagem()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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