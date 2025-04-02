package io.github.tarifchakder.ktoast

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

/**
 * State holder for managing toast messages.
 */
@Stable
class ToastState {

    private val mutex = Mutex()

    var currentToastData by mutableStateOf<ToastData?>(null)
        private set

    /**
     * Displays a toast message with the specified parameters.
     * @param message The message to display.
     * @param icon Optional icon to show with the toast.
     * @param duration The duration of the toast.
     */
    @OptIn(ExperimentalMaterial3Api::class)
    suspend fun showToast(
        message: String,
        icon: ImageVector? = null,
        duration: ToastDuration = ToastDuration.Short
    ) = showToast(ToastVisualsImpl(message, icon, duration))

    /**
     * Displays an empty toast (useful for predefined UI elements).
     * @param duration The duration of the toast.
     */
    suspend fun showEmpty(
        duration: ToastDuration = ToastDuration(DEFAULT_EMPTY_DURATION)
    ) = showToast(message = "", duration = duration)

    /**
     * Displays a toast based on the provided [ToastVisuals].
     * @param visuals The visuals to show for this toast.
     */
    @ExperimentalMaterial3Api
    suspend fun showToast(visuals: ToastVisuals) = mutex.withLock {
        try {
            suspendCancellableCoroutine { continuation ->
                currentToastData = ToastDataImpl(visuals, continuation)
            }
        } finally {
            currentToastData = null
        }
    }

    companion object {
        private const val DEFAULT_EMPTY_DURATION = 4500L // Default duration for empty toasts
    }
}