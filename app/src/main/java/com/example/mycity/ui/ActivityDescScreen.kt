package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.R
import com.example.mycity.data.DataSource
import com.example.mycity.data.DescItems
import com.example.mycity.ui.theme.MyCityTheme

@Composable
fun ActivityDescApp(items: DescItems, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(items.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        Text(
            text = stringResource(id = items.ubi)
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_large)))
        Text(
            text = stringResource(id = items.desc),
            modifier = Modifier
                .width(250.dp)
        )
    }
}



@Preview(showBackground = true)
@Composable
fun ActivityDescPreview() {
    MyCityTheme {
        val museums = DataSource.loadMuseum()

        if (museums.isNotEmpty()) {
            ActivityDescApp(items = museums[0])
        }
    }
}