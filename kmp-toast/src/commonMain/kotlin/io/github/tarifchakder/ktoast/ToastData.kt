package io.github.tarifchakder.ktoast

import androidx.compose.runtime.Stable

/**
 * Data class representing the information needed to display a toast.
 *
 * This interface provides access to the visuals of the toast and a method to dismiss it.
 */
@Stable
interface ToastData {
    val visuals: ToastVisuals
    fun dismiss()
}