package com.example.shoppingcartq5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.draw.clip
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape

import com.example.shoppingcartq5.ui.theme.ShoppingCartQ5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoppingCartQ5Theme {
                val snackbarHostState = remember { SnackbarHostState() }

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White),
                    snackbarHost = { SnackbarHost(hostState = snackbarHostState) } // Corrected snackbarHost parameter
                ) { innerPadding ->
                    ShoppingCart(
                        modifier = Modifier
                            .padding(innerPadding),
                        snackbarHostState = snackbarHostState
                    )
                }
            }
        }
    }
}

@Composable
fun ShoppingCart(modifier: Modifier = Modifier, snackbarHostState: SnackbarHostState) {
    val snackbarMessage = "Ordered" // Always show "Ordered" on click
    val imageSize = modifier.size(100.dp)
    var buttonClicked by remember { mutableStateOf(false) }
    LaunchedEffect(buttonClicked) {
        if (buttonClicked) {
            snackbarHostState.showSnackbar(snackbarMessage)
        }
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(24.dp)
    ) {
        Text(
            text = "Your Cart",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Card(
            modifier = modifier
                .wrapContentSize()
                .padding(2.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
            ) {
                Column {
                    Text(text = "  ")
                    Text(
                        text = "Private (1 Hour)",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                    Text(text = "Duration: 1 Hour", color = Color.Black)
                    Text(text = "Price per Hour: $7,777", color = Color.Black)
                }
                Image(
                    painter = painterResource(R.drawable.penguin),
                    contentDescription = null,
                    modifier = imageSize
                )
                HorizontalDivider(thickness = 1.dp)

            }

            HorizontalDivider(thickness = 1.dp)

            HorizontalDivider(thickness = 1.dp)

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = "Egg",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                    Text(text = "Amount: 1", color = Color.Black)
                    Text(text = "Price per: $999.00", color = Color.Black)
                }
                Image(
                    painter = painterResource(R.drawable.egg),
                    contentDescription = null,
                    modifier = imageSize
                )
            }
            HorizontalDivider(thickness = 1.dp)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = "Oil",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                    Text(text = "Amount: 1 Barrel", color = Color.Black)
                    Text(text = "Price per Barrel: $2.00", color = Color.Black)
                    Text(text = " ")
                    Text(
                        text = "Summary",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = "Total cost: $8,778.00",
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                }
                Image(
                    painter = painterResource(R.drawable.oil),
                    contentDescription = null,
                    modifier = imageSize
                )
            }
        }

        HorizontalDivider(thickness = 1.dp)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = {
                    buttonClicked = true
                },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1ED760))
                )
                {
                    Text(text = "Checkout", color = Color.Black)
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ShoppingCartPreview() {
        val snackbarHostState = remember { SnackbarHostState() }
        ShoppingCartQ5Theme {
            ShoppingCart(snackbarHostState = snackbarHostState)
        }
    }
}