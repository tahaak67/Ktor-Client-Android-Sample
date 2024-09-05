package com.example.democlass.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.democlass.data.Provider
import com.example.democlass.data.post.PostItem
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.launch

/* Created by Taha https://github.com/tahaak67/ at 5/9/2024 */

class PostsViewModel : ViewModel() {

    val client = Provider.client

    var postsList by mutableStateOf(emptyList<PostItem>())
        private set

    init {
        viewModelScope.launch {
            // TODO: Handle failure ex: no internet
            postsList = client.get("https://freefakeapi.io/api/posts").body<List<PostItem>>()
        }
    }

}
