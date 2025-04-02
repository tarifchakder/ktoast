package io.github.tarifchakder.ktoast

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Implementation of the [ToastVisuals] interface, providing a concrete way to define the
 * visual aspects of a toast notification.
 *
 * This class encapsulates the message, optional icon, and duration for a toast.
 *
 * @property message The text message to be displayed in the toast.
 * @property icon An optional [ImageVector] to be displayed alongside the message. If null, no icon will be shown.
 * @property duration The [ToastDuration] specifying how long the toast should be displayed.
 */
class ToastVisualsImpl(
    override val message: String,
    override val icon: ImageVector? = null,
    override val duration: ToastDuration
) : ToastVisuals {

    override fun equals(other: Any?): Boolean {
        return other is ToastVisualsImpl &&
                message == other.message &&
                icon == other.icon &&
                duration == other.duration
    }

    override fun hashCode(): Int {
        return message.hashCode() * 31 + (icon?.hashCode() ?: 0) * 31 + duration.hashCode()
    }
}