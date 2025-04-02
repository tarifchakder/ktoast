package io.github.tarifchakder.ktoast

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import kotlin.math.roundToInt

/**
 * Blends two ARGB colors together based on a given ratio.
 *
 * This function takes two ARGB colors (`color1` and `color2`) and a ratio between 0.0 and 1.0.
 * It linearly interpolates between the two colors' alpha, red, green, and blue components based on the ratio.
 * A ratio of 0.0 will return `color1`, a ratio of 1.0 will return `color2`, and a ratio of 0.5 will return a color that is halfway between `color1` and `color2`.
 *
 * @param color1 The first ARGB color, represented as an integer.
 * @param color2 The second ARGB color, represented as an integer.
 * @param ratio The blending ratio, a float value between 0.0 and 1.0 (inclusive).
 *              - 0.0: Returns `color1`.
 *              - 1.0: Returns `color2`.
 *              - 0.5: Returns a color halfway between `color1` and `color2`.
 * @return The blended ARGB color as an integer.
 * @throws IllegalArgumentException if the ratio is not within the range of 0.0 to 1.0.
 */
fun blendARGB(color1: Int, color2: Int, ratio: Float): Int {
    require(ratio in 0.0f..1.0f) { "Ratio must be between 0.0 and 1.0" }
    val inverseRatio = 1.0f - ratio

    val alpha1 = (color1 shr 24) and 0xFF
    val red1 = (color1 shr 16) and 0xFF
    val green1 = (color1 shr 8) and 0xFF
    val blue1 = color1 and 0xFF

    val alpha2 = (color2 shr 24) and 0xFF
    val red2 = (color2 shr 16) and 0xFF
    val green2 = (color2 shr 8) and 0xFF
    val blue2 = color2 and 0xFF

    val a = (alpha1 * inverseRatio + alpha2 * ratio).roundToInt()
    val r = (red1 * inverseRatio + red2 * ratio).roundToInt()
    val g = (green1 * inverseRatio + green2 * ratio).roundToInt()
    val b = (blue1 * inverseRatio + blue2 * ratio).roundToInt()

    return (a shl 24) or (r shl 16) or (g shl 8) or b
}

fun Color.blend(color: Color, fraction: Float = 0.2f): Color {
    return Color(blendARGB(this.toArgb(), color.toArgb(), fraction))
}

/**
 * Harmonizes a given [Color] with the primary color from the [MaterialTheme.colorScheme].
 *
 * This function blends the input color with the primary color using the specified `fraction`.
 * A fraction of 0.0 will result in the original color, while a fraction of 1.0 will result
 * in the primary color. Values between 0.0 and 1.0 create a blend between the two colors,
 * providing a way to create color variations that are still related to the primary color.
 *
 * @param fraction The blending fraction. 0.0 means no blending (original color), 1.0 means
 *                 fully blended to the primary color. Values between 0.0 and 1.0 represent
 *                 a proportional blend. Defaults to 0.2.
 * @return A new [Color] that is a blend of the input color and the primary color.
 * @see blend
 */
@Composable
fun Color.harmonizeWithPrimary(fraction: Float = 0.2f): Color {
    return blend(MaterialTheme.colorScheme.primary, fraction)
}