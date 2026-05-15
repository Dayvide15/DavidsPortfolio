/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.wcupa.csc461.shodipe.myapplication.ui.project3

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import edu.wcupa.csc461.shodipe.myapplication.R


@Composable
fun DessertReleaseApp(
    dessertReleaseViewModel: DessertReleaseViewModel = viewModel(
        factory = DessertReleaseViewModel.Factory
    )
) {
    DessertReleaseScreen(
        uiState = dessertReleaseViewModel.uiState.collectAsState().value,
        selectLayout = dessertReleaseViewModel::selectLayout
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DessertReleaseScreen(
    uiState: DessertReleaseUiState,
    selectLayout: (Boolean) -> Unit
) {
    val isLinearLayout = uiState.isLinearLayout

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.top_bar_name)) },
                actions = {
                    IconButton(
                        onClick = { selectLayout(!isLinearLayout) }
                    ) {
                        Icon(
                            painter = painterResource(uiState.toggleIcon),
                            contentDescription = stringResource(uiState.toggleContentDescription)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->

        val modifier = Modifier.padding(innerPadding)

        if (isLinearLayout) {
            DessertReleaseLinearLayout(modifier)
        } else {
            DessertReleaseGridLayout(modifier)
        }
    }
}

@Composable
fun DessertReleaseLinearLayout(modifier: Modifier = Modifier) {

    val items = listOf("Cake", "Ice Cream", "Donut", "Pie", "Cookie", "Brownie")

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items) { dessert ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = dessert,
                    modifier = Modifier.padding(16.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun DessertReleaseGridLayout(modifier: Modifier = Modifier) {

    val items = listOf("Cake", "Ice Cream", "Donut", "Pie", "Cookie", "Brownie")

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
        contentPadding = PaddingValues(8.dp)
    ) {
        items(items.size) { index ->
            Card(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = items[index],
                    modifier = Modifier.padding(16.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    DessertReleaseApp()
}
