package com.example.kotlinmultiplatform

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinmultiplatform.logic.Calculator
import com.example.kotlinmultiplatform.logic.OperatorType

@Composable
fun App() {
    val calculator by remember { mutableStateOf(Calculator()) }

    MaterialTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 100.dp),
                text = "${calculator.leftValue.value} ${calculator.operator.value?.sign.orEmpty()} ${calculator.rightValue.value}",
                style = TextStyle(fontSize = 32.sp),
                textAlign = TextAlign.Center
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Button(
                    modifier = Modifier.weight(1f),
                    content = { Text(text = "1") },
                    onClick = { calculator.inputValue("1") }
                )
                Button(
                    modifier = Modifier.weight(1f),
                    content = { Text(text = "2") },
                    onClick = { calculator.inputValue("2") }
                )
                Button(
                    modifier = Modifier.weight(1f),
                    content = { Text(text = "3") },
                    onClick = { calculator.inputValue("3") }
                )
                Button(
                    modifier = Modifier.weight(1f),
                    content = { Text(text = "4") },
                    onClick = { calculator.inputValue("4") }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Button(
                    modifier = Modifier.weight(1f),
                    content = { Text(text = "5") },
                    onClick = { calculator.inputValue("5") }
                )
                Button(
                    modifier = Modifier.weight(1f),
                    content = { Text(text = "6") },
                    onClick = { calculator.inputValue("6") }
                )
                Button(
                    modifier = Modifier.weight(1f),
                    content = { Text(text = "7") },
                    onClick = { calculator.inputValue("7") }
                )
                Button(
                    modifier = Modifier.weight(1f),
                    content = { Text(text = "8") },
                    onClick = { calculator.inputValue("8") }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Button(
                    modifier = Modifier.weight(1f),
                    content = { Text(text = "9") },
                    onClick = { calculator.inputValue("9") }
                )
                Button(
                    modifier = Modifier.weight(1f),
                    content = { Text(text = "0") },
                    onClick = { calculator.inputValue("0") }
                )
                Button(
                    modifier = Modifier.weight(1f),
                    content = { Text(text = "+") },
                    onClick = { calculator.onClickOperator(OperatorType.ADD) }
                )
                Button(
                    modifier = Modifier.weight(1f),
                    content = { Text(text = "-") },
                    onClick = { calculator.onClickOperator(OperatorType.MINUS) }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Button(
                    modifier = Modifier.weight(1f),
                    content = { Text(text = "*") },
                    onClick = { calculator.onClickOperator(OperatorType.MULTIPLE) }
                )
                Button(
                    modifier = Modifier.weight(1f),
                    content = { Text(text = "/") },
                    onClick = { calculator.onClickOperator(OperatorType.DIVIDE) }
                )
                Button(
                    modifier = Modifier.weight(1f),
                    content = { Text(text = "=") },
                    onClick = { calculator.onClickOperator(OperatorType.EQUAL) }
                )
                Button(
                    modifier = Modifier.weight(1f),
                    content = { Text(text = "C") },
                    onClick = { calculator.onClickOperator(OperatorType.CLEAR) }
                )
            }
        }
    }
}