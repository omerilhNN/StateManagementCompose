package com.omrilhn.statemanagementcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtherScreen() {
    Surface(color = Color.DarkGray)//For background color
    {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            //Show updates when textField is changing
            var myString by remember { mutableStateOf("Andorid Compose") }

            TextField(value = myString, onValueChange = {
                myString = it

            })

            Spacer(modifier = Modifier.padding(15.dp))

            //RECOMPOSITION SECOND WAY
            var textString = remember{ mutableStateOf("Hello") }

            Text(text = textString.value,
                fontSize = 26.sp
            )

            Spacer(modifier = Modifier.padding(15.dp))

            Button(onClick = {
                textString.value = "Android"
            }) {
                Text(text = "Test")
                Text(text = "Button")
            }
            Spacer(modifier = Modifier.padding(10.dp))

            Image(bitmap = ImageBitmap.imageResource(id = R.drawable.duman),
                contentDescription ="Duman",
                modifier = Modifier
                    .width(320.dp)
                    .height(240.dp))

            Spacer(modifier = Modifier.padding(20.dp))

            Image(imageVector = ImageVector.vectorResource
                (id = R.drawable.ic_launcher_foreground),
                contentDescription = null)

            Spacer(modifier = Modifier.padding(20.dp))

            Image(painter = ColorPainter(Color.LightGray),
                contentDescription =null,
                modifier = Modifier.size(10.dp,10.dp)//Set size of this PAINTED BOX
            )
        }
    }

}
