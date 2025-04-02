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
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.TransformOrigin

/**
 * Contains the default values used by [Toast].
 */
object ToastDefaults {
    val SLIDE: ContentTransform = SLIDE()
    val FADE: ContentTransform = FADE()
    val contentColor: Color @Composable get() = MaterialTheme.colorScheme.inverseOnSurface.harmonizeWithPrimary()
    val color: Color @Composable get() = MaterialTheme.colorScheme.inverseSurface.harmonizeWithPrimary()
    val shape: Shape @Composable get() = MaterialTheme.shapes.extraLarge
}