package io.github.tarifchakder.ktoast

import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlin.coroutines.resume

/**
 * Implementation of the [ToastData] interface.
 *
 * This class represents the data associated with a toast that is being displayed.
 * It holds the [ToastVisuals] for the toast and a [CancellableContinuation] that
 * is used to signal when the toast should be dismissed.
 *
 * @property visuals The [ToastVisuals] that describe the content of the toast.
 * @property continuation The [CancellableContinuation] used to signal the dismissal of the toast.
 * It is resumed with `Unit` when the toast should be dismissed.
 */
class ToastDataImpl(
    override val visuals: ToastVisuals,
    private val continuation: CancellableContinuation<Unit>
) : ToastData {

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun dismiss() {
        if (continuation.isActive) {
            continuation.resume(Unit)
        }
    }

    override fun equals(other: Any?): Boolean {
        return other is ToastDataImpl &&
                visuals == other.visuals &&
                continuation == other.continuation
    }

    override fun hashCode(): Int {
        return visuals.hashCode() * 31 + continuation.hashCode()
    }
}