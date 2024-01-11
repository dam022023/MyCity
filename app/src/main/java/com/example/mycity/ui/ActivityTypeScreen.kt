package com.example.mycity.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.R
import com.example.mycity.data.DataSource
import com.example.mycity.ui.theme.MyCityTheme


@Composable
fun ActivityTypeApp(
    onButtonClicked: (String) -> Unit,
    activityNames: List<String>,
    navigate: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(activityNames) { buttonId ->
            Button(
                onClick = {
                    navigate()
                    onButtonClicked(buttonId)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(buttonId)
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun ActivityTypePreview() {
    MyCityTheme {
        val activityNamesList = DataSource.activityTypeName.map { stringResource(it) }
        ActivityTypeApp(
            navigate = {},
            onButtonClicked = {},
            activityNames = activityNamesList,
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_medium))
                .fillMaxSize()
        )
    }
}
