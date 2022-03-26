package com.example.libraryappui.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.libraryappui.bookItems
import com.example.libraryappui.myBookItems
import com.example.libraryappui.ui.components.TopBarIconButton
import com.example.libraryappui.ui.components.TopBarImage
import com.example.libraryappui.ui.components.TopBarMainText
import com.example.libraryappui.ui.components.TopBarSecondaryText
import com.example.libraryappui.ui.theme.RalewayFamily

@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun MainScreen() {
    val sheetState = rememberBottomSheetScaffoldState()

    BottomSheetScaffold(
        scaffoldState = sheetState,
        sheetPeekHeight = 160.dp,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 12.dp),
        topBar = {
            TopBarContents()
        },
        sheetContent = {
            SheetContents()
        }
    ) {
        Column(Modifier.padding()) {
            NewArrivalsRow()
            Spacer(modifier = Modifier.height(16.dp))
            BookLazyRow()
        }
    }
}

@Composable
fun SheetContents() {
    Spacer(modifier = Modifier.height(16.dp))
    UIText(text = "My books", fontSize = 20.sp, modifier = Modifier.padding(horizontal = 20.dp))
    LazyColumn(contentPadding = PaddingValues(vertical = 16.dp)) {
        items(myBookItems) { book ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(horizontal = 28.dp, vertical = 8.dp)
                    .clickable { },
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Image(
                    painter = painterResource(id = book.book.image),
                    contentScale = ContentScale.FillHeight,
                    contentDescription = "Cover",
                    modifier = Modifier
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(8.dp))
                )
                Column(Modifier.weight(1f)) {
                    UIText(book.book.title, fontSize = 16.sp)
                    UIText(book.book.author, fontSize = 16.sp, color = Color.Gray)
                    Spacer(modifier = Modifier.weight(1f))
                    UIText(
                        "Return until ${book.returnDate}",
                        color = MaterialTheme.colors.primary,
                        fontSize = 13.sp
                    )
                    LinearProgressIndicator(
                        book.timeLeftPercentage,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Menu")
                }
            }

        }
    }
}

@Composable
fun TopBarContents() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 28.dp, end = 28.dp, top = 45.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {
        Row() {
            TopBarMainText()
            TopBarSecondaryText()
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            TopBarIconButton()
            TopBarImage()
        }

    }
}

@Composable
fun BookLazyRow() {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 28.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(bookItems) { book ->
            Column(
                Modifier
                    .width(130.dp)
                    .clickable { }) {
                Image(
                    painter = painterResource(id = book.image),
                    contentDescription = "Book Cover",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.FillWidth
                )
                Spacer(modifier = Modifier.height(8.dp))
                UIText(text = book.title, fontSize = 16.sp)
                UIText(text = book.author, fontSize = 13.sp, color = Color.Gray)
            }
        }
    }
}

@Composable
fun NewArrivalsRow() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 28.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        UIText(
            text = "New arrivals",
            fontSize = 20.sp,
            modifier = Modifier.weight(1f)
        )
        TextButton(
            onClick = { /*TODO*/ },
            contentPadding = PaddingValues(horizontal = 0.dp)
        ) {
            UIText(text = "View all")
            Spacer(modifier = Modifier.width(4.dp))
            Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = "View All")
        }
    }
}

@Composable
fun UIText(
    text: String = "example",
    fontFamily: FontFamily = RalewayFamily,
    fontSize: TextUnit = 14.sp,
    color: Color = Color.Black,
    fontWeight: FontWeight = FontWeight.Normal,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        fontFamily = fontFamily,
        fontSize = fontSize,
        color = color,
        fontWeight = fontWeight,
        modifier = modifier
    )
}