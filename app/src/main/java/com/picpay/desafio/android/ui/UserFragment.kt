package com.picpay.desafio.android.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.picpay.desafio.android.R
import com.picpay.desafio.android.data.model.User
import com.picpay.desafio.android.databinding.FragmentUserBinding
import com.picpay.desafio.android.utils.Resource
import com.picpay.desafio.android.utils.extensions.setVisible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserFragment : Fragment() {

    private val viewModel: UserViewModel by viewModels()
    private lateinit var binding: FragmentUserBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setView()
        displayUsers()
    }

    private fun setView() {
        binding.userListProgressBar.setVisible(true)
    }

    private fun displayUsers() {
        val userAdapter = UserListAdapter()

        binding.apply {
            recyclerView.apply {
                adapter = userAdapter
                layoutManager = LinearLayoutManager(context)
            }

            viewModel.users.observe(viewLifecycleOwner) { result ->
                userAdapter.submitList(result.data)

                userListProgressBar.setVisible(result is Resource.Loading && result.data.isNullOrEmpty())
                if(result is Resource.Error && result.data.isNullOrEmpty()) {
                    displayError()
                }
            }
        }
    }

    private fun displayError() {
        val message = getString(R.string.error)

        binding.userListProgressBar.setVisible(false)
        binding.recyclerView.setVisible(false)

        Toast.makeText(context, message, Toast.LENGTH_SHORT)
            .show()
    }
}