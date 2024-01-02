package id.codefadhil.getapi

import android.os.Bundle
import android.os.Debug
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import id.codefadhil.getapi.ui.theme.GetAPITheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.background
//import com.example.valorant.ui.theme.blackV
//import com.example.valorant.ui.theme.blueV
import id.codefadhil.getapi.ui.theme.blueV
import id.codefadhil.getapi.ui.theme.redV
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import coil.compose.AsyncImage
import coil.request.ImageRequest


import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.padding
//
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.platform.LocalContext




import id.codefadhil.getapi.network.ApiService

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.collectAsState

import id.codefadhil.getapi.data.Agents
import id.codefadhil.getapi.data.DataItem
import id.codefadhil.getapi.data.Weapon
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card

import id.codefadhil.getapi.network.AgentsViewModel

//import red
import androidx.compose.ui.graphics.Color
//import h6


//image request


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GetAPITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    AgentsList(AgentsViewModel())
                }
            }
        }
    }
}


@Composable
fun AgentsList(viewModel: AgentsViewModel) {
    val agentsData = viewModel.agentsData.collectAsState()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(blueV)
            .padding(8.dp)
    ) {
        items(count = agentsData.value.size) {
            Card(
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.2f)
                    .padding(8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    // Image
                    AsyncImage(
                        model = ImageRequest.Builder(context = LocalContext.current).data(agentsData.value[it].bustPortrait).build(),
                        error = painterResource(R.drawable.loading_img),
                        placeholder = painterResource(R.drawable.loading_img),
                        contentDescription = "Agent Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.8f)
                    )

                    // Text after the image
                    Text(
                        text = agentsData.value[it].displayName.toString(),
                        color = MaterialTheme.colorScheme.primary,
                        maxLines = 1,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(8.dp)
                    )
                    Text(
                        text = agentsData.value[it].developerName.toString(),
                        color = MaterialTheme.colorScheme.primary,
                        maxLines = 1,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(8.dp)
                    )
                    Text(text = agentsData.value[it].description.toString(),
                        color = MaterialTheme.colorScheme.primary,
                        maxLines = 1,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(8.dp)
                    )

                }
            }
        }
    }
}



