package io.github.tarifchakder.ktoast

/**
 * Represents the duration for which a toast message should be displayed.
 *
 * This class provides predefined durations for short and long toast messages,
 * allowing for consistent timing across the application.
 *
 * @property time The duration of the toast in milliseconds.
 */
open class ToastDuration(val time: kotlin.Long) {
    object Short : ToastDuration(3500L)
    object Long : ToastDuration(6500L)
}