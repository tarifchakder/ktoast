package io.github.tarifchakder.ktoast

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ContentTransform
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalAccessibilityManager
import androidx.compose.ui.zIndex
import kotlinx.coroutines.delay

private const val TOAST_Z_INDEX = 100f

/**
 * ToastHost handles displaying toast messages with animations and automatic dismissal.
 *
 * @param hostState The state of the toast, containing the current toast data.
 * @param modifier Modifier for styling the container of the ToastHost.
 * @param alignment Alignment of the toast on the screen, defaults to BottomCenter.
 * @param transitionSpec Animation specification for displaying and hiding toasts.
 * @param toast Composable defining how a toast should look.
 */
@Composable
fun ToastHost(
    hostState: ToastState,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    transitionSpec: AnimatedContentTransitionScope<ToastData?>.() -> ContentTransform = { ToastDefaults.FADE },
    toast: @Composable (ToastData) -> Unit = { ToastContent(toastData = it) }
) {
    val currentToastData = hostState.currentToastData
    val accessibilityManager = LocalAccessibilityManager.current

    LaunchedEffect(currentToastData) {
        currentToastData?.let {
            val duration = it.visuals.duration.toMillis(accessibilityManager)
            delay(duration)
            it.dismiss()
        }
    }

    AnimatedContent(
        targetState = currentToastData,
        transitionSpec = transitionSpec,
        label = "animated_toast"
    ) { toastData ->
        Box(modifier = modifier) {
            Box(modifier = Modifier.align(alignment)) {
                toastData?.let { toast(it) }
            }
        }
    }
}