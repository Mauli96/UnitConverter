package com.example.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter() {

    var inputValue by remember {
        mutableStateOf("")
    }
    var outputValue by remember {
        mutableStateOf("")
    }
    var inputUnit by remember {
        mutableStateOf("Meter")
    }
    var outputUnit by remember {
        mutableStateOf("Meter")
    }
    var iExpanded by remember {
        mutableStateOf(false)
    }
    var oExpanded by remember {
        mutableStateOf(false)
    }
    val iConversionFactor = remember {
        mutableStateOf(1.00)
    }
    val oConversionFactor = remember {
        mutableStateOf(1.00)
    }

    fun convertsUnit() {
        val inputValueInDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result = (inputValueInDouble * iConversionFactor.value * 100.0 / oConversionFactor.value).roundToInt() / 100.0
        outputValue = result.toString()
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Unit Converter",
                style =  MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = inputValue,
                onValueChange = {
                    inputValue = it
                    convertsUnit()
                },
                label = {
                    Text(text = "Enter Value")
                },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                //Input Box
                Box {
                    Button(
                        onClick = { iExpanded = true }
                    ) {
                        Text(text = inputUnit)
                        Icon(
                            Icons.Default.ArrowDropDown,
                            contentDescription = "Arrow DropDown"
                        )
                    }
                    DropdownMenu(
                        expanded = iExpanded,
                        onDismissRequest = { iExpanded = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("Millimeter") },
                            onClick = {
                                iExpanded = false
                                inputUnit = "Millimeter"
                                iConversionFactor.value = 0.001
                                convertsUnit()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Centimeter") },
                            onClick = {
                                iExpanded = false
                                inputUnit = "Centimeter"
                                iConversionFactor.value = 0.01
                                convertsUnit()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Meter") },
                            onClick = {
                                iExpanded = false
                                inputUnit = "Meter"
                                iConversionFactor.value = 1.00
                                convertsUnit()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Kilometer") },
                            onClick = {
                                iExpanded = false
                                inputUnit = "Kilometer"
                                iConversionFactor.value = 1000.0
                                convertsUnit()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Inch") },
                            onClick = {
                                iExpanded = false
                                inputUnit = "Inch"
                                iConversionFactor.value = 0.0254
                                convertsUnit()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Foot") },
                            onClick = {
                                iExpanded = false
                                inputUnit = "Foot"
                                iConversionFactor.value = 0.3048
                                convertsUnit()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Mile") },
                            onClick = {
                                iExpanded = false
                                inputUnit = "Mile"
                                iConversionFactor.value = 1609.34
                                convertsUnit()
                            }
                        )
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))

                //Output Box
                Box {
                    Button(
                        onClick = { oExpanded = true }
                    ) {
                        Text(text = outputUnit)
                        Icon(
                            Icons.Default.ArrowDropDown,
                            contentDescription = "Arrow DropDown"
                        )
                    }
                    DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false }) {
                        DropdownMenuItem(
                            text = { Text("Millimeter") },
                            onClick = {
                                oExpanded = false
                                outputUnit = "Millimeter"
                                oConversionFactor.value = 0.001
                                convertsUnit()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Centimeter") },
                            onClick = {
                                oExpanded = false
                                outputUnit = "Centimeter"
                                oConversionFactor.value = 0.01
                                convertsUnit()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Meter") },
                            onClick = {
                                oExpanded = false
                                outputUnit = "Meter"
                                oConversionFactor.value = 1.00
                                convertsUnit()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Kilometer") },
                            onClick = {
                                oExpanded = false
                                outputUnit = "Kilometer"
                                oConversionFactor.value = 1000.0
                                convertsUnit()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Inch") },
                            onClick = {
                                oExpanded = false
                                outputUnit = "Inch"
                                oConversionFactor.value = 0.0254
                                convertsUnit()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Foot") },
                            onClick = {
                                oExpanded = false
                                outputUnit = "Foot"
                                oConversionFactor.value = 0.3048
                                convertsUnit()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Mile") },
                            onClick = {
                                oExpanded = false
                                outputUnit = "Mile"
                                oConversionFactor.value = 1609.34
                                convertsUnit()
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Result : $outputValue $outputUnit",
                style =  MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverter()
}