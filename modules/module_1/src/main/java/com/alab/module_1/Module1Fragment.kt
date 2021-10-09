package com.alab.module_1.services

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alab.common.apolloClient
import com.alab.module_1.GetEmployeeQuery
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Представляет фрагмент экрана.
 */
class Module1Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return View(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        GlobalScope.launch {
            val employeeResponse = apolloClient.query(GetEmployeeQuery("12345")).data?.employee
        }

    }
}