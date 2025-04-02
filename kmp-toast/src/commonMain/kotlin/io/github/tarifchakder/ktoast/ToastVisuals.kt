package io.github.tarifchakder.ktoast

import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Defines the visual properties of a toast message.
 *
 * This interface is used to customize the appearance of a toast, including its message,
 * optional icon, and display duration.
 *
 * @property message The text message to be displayed in the toast. This is a required field.
 * @property icon An optional icon (represented as an [ImageVector]) to be displayed alongside the
 *   message in the toast. If `null`, no icon will be shown.
 * @property duration The duration for which the toast should be displayed. This is determined by
 *   the [ToastDuration] enum.
 */
@Stable
interface ToastVisuals {
    val message: String
    val icon: ImageVector?
    val duration: ToastDuration
}