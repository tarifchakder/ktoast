package io.github.tarifchakder.ktoast

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/**
 * Composable function that displays the content of a toast.
 *
 * This function renders a Card containing the message and optional icon specified
 * in the [ToastData] object. It handles default styling for toasts, including
 * background color, text color, shape, padding, and positioning.
 *
 * @param modifier Modifier to be applied to the card container. Defaults to a modifier that wraps content size,
 *                 adds ime and system bars padding, and sets an alpha of 0.95.
 * @param toastData The data representing the content of the toast. This includes the message
 *                  and an optional icon.
 * @param shape The shape of the toast card. Defaults to [ToastDefaults.shape].
 * @param containerColor The background color of the toast card. Defaults to [ToastDefaults.color].
 * @param contentColor The color of the text and icon within the toast. Defaults to [ToastDefaults.contentColor].
 *
 * @see ToastData
 * @see ToastDefaults
 */
@Composable
fun ToastContent(
    modifier: Modifier = Modifier,
    toastData: ToastData,
    shape: Shape = ToastDefaults.shape,
    containerColor: Color = ToastDefaults.color,
    contentColor: Color = ToastDefaults.contentColor,
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        modifier = if (modifier != Modifier) modifier else
            Modifier
                .wrapContentSize()
                .imePadding()
                .systemBarsPadding()
                .alpha(0.95f),
        shape = shape
    ) {
        Row(
            Modifier.padding(horizontal = 15.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            toastData.visuals.icon?.let { Icon(it, null) }
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                style = MaterialTheme.typography.bodySmall,
                text = toastData.visuals.message,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(end = 5.dp)
            )
        }
    }
}