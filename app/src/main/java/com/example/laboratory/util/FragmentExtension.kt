package com.example.laboratory.util

import androidx.fragment.app.Fragment
import com.example.laboratory.App
import com.example.laboratory.ViewModelFactory

fun Fragment.getViewModelFactory() : ViewModelFactory {
    val repository = (requireContext().applicationContext as App).taskRepository
    return ViewModelFactory(repository, this)
}