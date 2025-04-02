package io.github.tarifchakder.ktoast

import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.platform.AccessibilityManager

fun ToastDuration.toMillis(
    accessibilityManager: AccessibilityManager?
): Long {
    val original = this.time
    return accessibilityManager?.calculateRecommendedTimeoutMillis(
        original,
        containsIcons = true,
        containsText = true
    ) ?: original
}

fun FADE(): ContentTransform {
    return scaleIn(
        initialScale = 0.8f, // Starts slightly smaller
        animationSpec = tween(durationMillis = 300)
    ) + fadeIn(
        animationSpec = tween(durationMillis = 300)
    ) togetherWith scaleOut(
        targetScale = 0.8f, // Shrinks slightly before disappearing
        animationSpec = tween(durationMillis = 300)
    ) + fadeOut(
        animationSpec = tween(durationMillis = 300)
    )
}

fun SLIDE(): ContentTransform {
    return fadeIn(tween(300)) +
            scaleIn(tween(500), transformOrigin = TransformOrigin(0.5f, 1f)) +
            slideInVertically(tween(500)) { it / 2 } togetherWith fadeOut(tween(250)) +
            slideOutVertically(tween(500)) { it / 2 } +
            scaleOut(tween(750), transformOrigin = TransformOrigin(0.5f, 1f))
}