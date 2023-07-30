@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.omrilhn.statemanagementcompose

import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    //It is more usable that you set variable above all
    // and send parameter to the SpecialTextField when you want to change smth
    var myString = remember { mutableStateOf("")}

    Surface(modifier = Modifier.fillMaxSize()){
        Column(verticalArrangement = Arrangement.Center
            , horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            SpecialText(myString = "test")
            Spacer(modifier = Modifier.padding(10.dp))
            SpecialText(myString = "android")
            Spacer(modifier = Modifier.padding(10.dp))
            SpecialTextField(myString.value){
                myString.value = it
            }
        }

    }


}
@Composable
fun SpecialText(myString: String){
    Text(text = myString,
        fontSize = 26.sp,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold
        )
}
@Composable
fun SpecialTextField(string:String,function:(String) -> Unit){
//Take function with STRING parameter and void return type
    TextField(value = string,
        onValueChange = function,
        modifier = Modifier.padding(10.dp)
     )
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
        MainScreen()
}