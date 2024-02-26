package com.josecaballero.notificationbell

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.josecaballero.notificationbell.ui.theme.NotificationBellTheme

@Composable
fun NotificationBellScreen(
    newNotifications: List<NotificationData>,
    previousNotifications: List<NotificationData>,
) {
    Surface(
        color = Color(0xFFF6F5F8),
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.padding(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(state = rememberScrollState())
            ) {
                NotificationBellHeader()
                Spacer(modifier = Modifier.height(12.dp))
                NotificationBellButton(
                    text = "Back to Device Details",
                    notificationBellButtonType = NotificationBellButtonType.MEDIUM_PURPLE_REGULAR
                ) {
                    //TODO: Navigate back
                }
                Spacer(modifier = Modifier.height(4.dp))
                Box(modifier = Modifier.padding(start = 12.dp)) {
                    VectorImage(R.drawable.vector_13)
                }
                Spacer(modifier = Modifier.height(8.dp))
                NotificationBellTextSpacer {
                    NotificationBellText(
                        text = "Notifications header",
                        notificationBellTextType = NotificationBellTextType.MEDIUM_BLACK_REGULAR
                    )
                }
                NotificationBellTextSpacer {
                    NotificationBellText(
                        text = "New",
                        notificationBellTextType = NotificationBellTextType.MEDIUM_BLACK_REGULAR
                    )
                }
                NotificationBellTextSpacer {
                    NotificationBellText(
                        text = "Mark all read",
                        notificationBellTextType = NotificationBellTextType.MEDIUM_PURPLE_REGULAR
                    ) {
                        //TODO: Dismiss current all notifications
                    }
                }
                Spacer(modifier = Modifier.height(17.dp))
                NotificationBellFieldSet(
                    text = "New Notifications",
                ) {
                    NotificationBellFieldSetA(newNotifications)
                }
                Spacer(modifier = Modifier.height(2.dp))
                NotificationBellFieldSet(
                    text = "Previous Notifications",
                ) {
                    NotificationBellFieldSetA(previousNotifications)
                }
                Spacer(modifier = Modifier.height(2.dp))
                NotificationBellFieldSet(text = "Global Navigation") {
                    Box(
                        contentAlignment = Alignment.CenterStart,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp, end = 8.dp, top = 20.dp, bottom = 8.dp)
                    ) {
                        Column {
                            NotificationBellButton(
                                text = "Devices",
                                notificationBellButtonType = NotificationBellButtonType.MEDIUM_BLACK_REGULAR
                            ) {
                                //TODO: Navigate to devices
                            }
                            Spacer(modifier = Modifier.height(6.dp))
                            NotificationBellButton(
                                text = "For you",
                                notificationBellButtonType = NotificationBellButtonType.MEDIUM_BLACK_REGULAR
                            ) {
                                //TODO: Navigate to for you
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(2.dp))
                NotificationBellFieldSet(text = "Footer") {
                    Box(
                        contentAlignment = Alignment.CenterStart,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp, end = 8.dp, top = 20.dp, bottom = 8.dp)
                    ) {
                        Column {
                            NotificationBellButton(
                                text = "Privacy",
                                notificationBellButtonType = NotificationBellButtonType.MEDIUM_BLACK_REGULAR
                            ) {
                                //TODO: Navigate to privacy
                            }
                            Spacer(modifier = Modifier.height(6.dp))
                            NotificationBellButton(
                                text = "Terms of use",
                                notificationBellButtonType = NotificationBellButtonType.MEDIUM_BLACK_REGULAR
                            ) {
                                //TODO: Navigate to terms of use
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(2.dp))
            }
        }
    }
}

@Composable
fun NotificationBellHeader() {
    Surface(
        color = Color.White,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color(0xFFD5C7ED)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, bottom = 12.dp)
        ) {
            NotificationBellText(
                text = "Notification bell",
                notificationBellTextType = NotificationBellTextType.BIG_BLACK_BOLD
            )
        }
    }
}

@Composable
fun NotificationBellButton(text: String, notificationBellButtonType: NotificationBellButtonType, onClick: () -> Unit = {}) {
    Surface(
        color = Color.White,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 16.dp, top = 10.dp, bottom = 10.dp)
        ) {
            NotificationBellText(
                text = text,
                notificationBellTextType = when (notificationBellButtonType) {
                    NotificationBellButtonType.MEDIUM_PURPLE_REGULAR -> NotificationBellTextType.MEDIUM_PURPLE_REGULAR
                    else -> NotificationBellTextType.MEDIUM_BLACK_REGULAR
                }
            )
        }
    }
}

@Composable
fun NotificationBellFieldSet(text: String, content: @Composable () -> Unit) {
    Box {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            color = Color(0xFFF6F5F8),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(1.dp, Color(0xFF513786))
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            content()
        }

        Box(
            modifier = Modifier
                .padding(start = 12.dp)
                .background(Color(0xFFF6F5F8))
        ) {
            Box(
                modifier = Modifier.padding(start = 4.dp, end = 4.dp)
            ) {
                NotificationBellText(text, NotificationBellTextType.MEDIUM_BLACK_BOLD)
            }
        }
    }
}

@Composable
fun NotificationBellFieldSetA(notificationDataList: List<NotificationData>) {
    Box(modifier = Modifier.padding(start = 8.dp, bottom = 8.dp, end = 26.dp)) {
        Column {
            Spacer(modifier = Modifier.height(24.dp))
            var counter = 0
            notificationDataList.forEach { notificationData ->
                counter++
                NotificationBellItem(
                    name = "Notification $counter",
                    notificationData = notificationData
                )
                Spacer(modifier = Modifier.height(6.dp))
            }
        }
    }
}

@Composable
fun NotificationBellItem(name: String, notificationData: NotificationData) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 10.dp)
        ) {
            with(notificationData) {
                Column {
                    NotificationBellText(name, NotificationBellTextType.MEDIUM_BLACK_BOLD)
                    NotificationBellTextSpacer {
                        NotificationBellText(
                            badge,
                            NotificationBellTextType.MEDIUM_BLACK_REGULAR
                        )
                    }
                    NotificationBellTextSpacer {
                        NotificationBellText(
                            title,
                            NotificationBellTextType.MEDIUM_BLACK_REGULAR
                        )
                    }
                    NotificationBellTextSpacer {
                        NotificationBellText(
                            message,
                            NotificationBellTextType.MEDIUM_BLACK_REGULAR
                        )
                    }
                    NotificationBellTextSpacer {
                        NotificationBellText(
                            deviceNickName,
                            NotificationBellTextType.MEDIUM_BLACK_REGULAR
                        )
                    }
                    NotificationBellTextSpacer {
                        NotificationBellText(
                            timeStamp,
                            NotificationBellTextType.MEDIUM_BLACK_REGULAR
                        )
                    }
                    NotificationBellTextSpacer {
                        NotificationBellText(
                            "Dismiss Notification",
                            NotificationBellTextType.MEDIUM_PURPLE_REGULAR_CLICKABLE
                        ) {
                            //TODO: Dismiss current notification (is there a notification id?)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun NotificationBellTextSpacer(content: @Composable () -> Unit) {
    Box(modifier = Modifier.padding(start = 10.dp)) {
        content()
    }
}

@Composable
fun NotificationBellText(
    text: String,
    notificationBellTextType: NotificationBellTextType,
    onClick: () -> Unit = {}
) {
    val (fontSize, fontWeight, textColor) = when (notificationBellTextType) {
        NotificationBellTextType.MEDIUM_BLACK_REGULAR -> Triple(
            14.sp,
            FontWeight.Normal,
            Color.Black
        )

        NotificationBellTextType.MEDIUM_BLACK_BOLD -> Triple(14.sp, FontWeight.Bold, Color.Black)
        NotificationBellTextType.MEDIUM_PURPLE_REGULAR,
        NotificationBellTextType.MEDIUM_PURPLE_REGULAR_CLICKABLE -> Triple(
            14.sp,
            FontWeight.Normal,
            Color(0xFF6C25FB)
        )

        NotificationBellTextType.BIG_BLACK_BOLD -> Triple(16.sp, FontWeight.Bold, Color.Black)
    }

    val textStyle = TextStyle(
        fontSize = fontSize,
        fontWeight = fontWeight,
        color = textColor
    )

    val modifier =
        if (notificationBellTextType == NotificationBellTextType.MEDIUM_PURPLE_REGULAR_CLICKABLE) {
            Modifier.clickable(onClick = onClick)
        } else {
            Modifier
        }

    Text(
        text = text,
        style = textStyle,
        modifier = modifier.padding(8.dp)
    )
}

@Composable
fun VectorImage(vectorResId: Int) {
    val painter: Painter = painterResource(id = vectorResId)
    Image(
        painter = painter,
        contentDescription = null
    )
}

enum class NotificationBellButtonType {
    MEDIUM_BLACK_REGULAR,
    MEDIUM_PURPLE_REGULAR,
}

enum class NotificationBellTextType {
    MEDIUM_BLACK_REGULAR,
    MEDIUM_BLACK_BOLD,
    MEDIUM_PURPLE_REGULAR,
    BIG_BLACK_BOLD,
    MEDIUM_PURPLE_REGULAR_CLICKABLE,
}

data class NotificationData(
    val badge: String,
    val title: String,
    val message: String,
    val timeStamp: String,
    val deviceNickName: String
)


@Preview(showBackground = false)
@Composable
fun Test() {
    NotificationBellTheme {
        NotificationBellScreen(
            newNotifications = newNotificationList,
            previousNotifications = previousNotificationList
        )
    }
}

val newNotificationList = listOf(
    NotificationData(
        "ER56312",
        "Tray on fire",
        "Your tray is on fire! You better call the fire department buddy, quick.",
        "02/23/2024",
        "PP12"
    ),
    NotificationData(
        "BH12456",
        "Haunted paper",
        "Better call of GHOST BUSTERS do-do-dom-dom-dom (fancy 80s music)",
        "02/23/2024",
        "PP10"
    )
)

val previousNotificationList = listOf(
    NotificationData("E352312", "AI took over", "Your printer seems alive", "12/01/2023", "PP10"),
    NotificationData(
        "QQ44521",
        "Depressed printer",
        "We are not sure how is this possible",
        "11/29/2023",
        "PP09"
    )
)
