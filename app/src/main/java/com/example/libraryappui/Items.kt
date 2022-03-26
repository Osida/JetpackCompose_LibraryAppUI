package com.example.libraryappui

data class Book(val id: String, val title: String, val image: Int, val author: String)

data class MyBook(val book: Book, val returnDate: String, val timeLeftPercentage: Float)

val bookItems = listOf(
    Book("001", "Muscle", R.drawable.book_muscle, "Alan Trotter"),
    Book("002", "Muscle", R.drawable.book_dominicana, "Angie Cruz"),
    Book("003", "Muscle", R.drawable.book_a_new, "Shelly Kaine"),
)

val myBookItems = listOf(
    MyBook(
        Book("004", "Just My Type", R.drawable.book_just_my_type, "Simon Garfield"),
        "25.03.2022",
        75f
    ),
    MyBook(bookItems[0], "25.02.2022", 80f),
    MyBook(bookItems[1], "21.01.2022", 90f),
)