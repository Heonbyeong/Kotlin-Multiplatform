package com.example.kotlinmultiplatform.logic

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

enum class OperatorType(val sign: String) {
    ADD("+"),
    MINUS("-"),
    DIVIDE("/"),
    MULTIPLE("*"),
    EQUAL("="),
    CLEAR("C")
}

class Calculator {

    var leftValue: MutableState<String> = mutableStateOf("")
    var rightValue: MutableState<String> = mutableStateOf("")
    var operator: MutableState<OperatorType?> = mutableStateOf(null)

    fun inputValue(value: String) {
        if (operator.value == null) {
            leftValue.value += value
        } else {
            rightValue.value += value
        }
    }

    fun onClickOperator(operatorType: OperatorType) {
        when (operatorType) {
            OperatorType.EQUAL -> {
                if (leftValue.value.isNotEmpty() && rightValue.value.isNotEmpty()) {
                    leftValue.value = when (operator.value) {
                        OperatorType.ADD -> {
                            leftValue.value.toInt() + rightValue.value.toInt()
                        }
                        OperatorType.MINUS -> {
                            leftValue.value.toInt() - rightValue.value.toInt()
                        }
                        OperatorType.DIVIDE -> {
                            leftValue.value.toInt() / rightValue.value.toInt()
                        }
                        OperatorType.MULTIPLE -> {
                            leftValue.value.toInt() * rightValue.value.toInt()
                        }
                        else -> { "" }
                    }.toString()
                    rightValue.value = ""
                    operator.value = null
                }
            }
            OperatorType.CLEAR -> {
                operator.value = null
                leftValue.value = ""
                rightValue.value = ""
            }
            else -> {
                if (leftValue.value.isNotEmpty()) {
                    operator.value = operatorType
                }
            }
        }
    }
}