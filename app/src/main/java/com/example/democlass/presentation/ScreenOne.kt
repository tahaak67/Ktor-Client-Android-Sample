package com.example.democlass.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.screen.Screen
import coil.compose.AsyncImage

class ScreenOne() : Screen {

    @Composable
    override fun Content() {
        ScreenOneContent() // <- screen content here
    }

}

@Composable
fun ScreenOneContent(modifier: Modifier = Modifier) {
    val postsViewModel: PostsViewModel = viewModel()
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            if (postsViewModel.postsList.isEmpty()) {
                CircularProgressIndicator()
            }
        }
        items(postsViewModel.postsList) { post ->
            PostItem(
                modifier = Modifier.fillMaxWidth(),
                title = post.title,
                content = post.content,
                picture = post.picture
            )
        }
    }
}

@Composable
fun PostItem(modifier: Modifier = Modifier, title: String, content: String, picture: String) {
    Card(modifier = Modifier) {
        Column(modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            AsyncImage(model = picture, contentDescription = "", modifier = Modifier.size(150.dp))
            Text(title, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(content, fontSize = 16.sp)
        }
    }
}

@Preview
@Composable
private fun PostItemPreview() {
    PostItem(title = "title", content = "content", picture = "")
}
