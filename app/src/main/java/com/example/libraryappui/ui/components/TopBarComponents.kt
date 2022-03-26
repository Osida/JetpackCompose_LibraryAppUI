package com.example.libraryappui.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.libraryappui.R
import com.example.libraryappui.ui.screens.UIText

@Composable
fun TopBarMainText() {
    Box() {
        UIText(
            text = "20",
            fontSize = 28.sp,
            modifier = Modifier.padding(end = 10.dp),
        )
    }
}

@Composable
fun TopBarSecondaryText() {
    Column() {
        UIText(
            text = "Thru",
            color = Color.Gray,
            modifier = Modifier.padding(end = 10.dp),
            fontWeight = FontWeight.Bold
        )
        UIText(
            text = "March 24",
            color = Color.Gray,
            modifier = Modifier.padding(end = 10.dp),
        )
    }
}

@Composable
fun TopBarIconButton() {
    Box() {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.Notifications, contentDescription = "Notify")
        }
    }
}

@Composable
fun TopBarImage() {
    Image(
        painter = painterResource(id = R.drawable.cesar_rincon_profile_pic),
        contentDescription = "Profile Picture",
        modifier = Modifier
            .size(60.dp)
            .padding(start = 10.dp)
            .clip(shape = RoundedCornerShape(100.dp))
    )
}