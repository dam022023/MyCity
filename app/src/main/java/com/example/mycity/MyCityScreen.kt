package com.example.mycity

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mycity.data.DataSource
import com.example.mycity.ui.ActivityApp
import com.example.mycity.ui.ActivityDescApp
import com.example.mycity.ui.ActivityTypeApp
import com.example.mycity.ui.CityTitleApp


enum class MyCityScreen() {
    Start, ActivityType, ActivityList, DescActivity
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityTopBar(
    currentScreen: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(currentScreen) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityApp(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = backStackEntry?.destination?.route ?: MyCityScreen.Start.name

    var selectedActivityType by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            MyCityTopBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = MyCityScreen.Start.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(MyCityScreen.Start.name) {
                CityTitleApp(
                    onMoveButtonClick = { navController.navigate(MyCityScreen.ActivityType.name) }
                )
            }

            composable(MyCityScreen.ActivityList.name) {
                val activityNames = selectedActivityType?.let { type ->
                    when (type) {
                        "Museos" -> DataSource.museumActivities
                        "Teatros" -> DataSource.theatreActivities
                        "Turismo" -> DataSource.turismActivities
                        "Centros comerciales" -> DataSource.shoppingActivities
                        else -> emptyList()
                    }
                } ?: emptyList()

                Log.d("MyCityApp", "Activity List: $activityNames")

                ActivityApp(
                    onMoveButtonClick = { navController.navigate(MyCityScreen.DescActivity.name) },
                    activityNames = activityNames
                )
            }

            composable(MyCityScreen.ActivityType.name) {
                ActivityTypeApp(
                    navigate = {
                        navController.navigate(MyCityScreen.ActivityList.name)
                    },
                    activityNames = DataSource.activityTypeName.map { stringResource(it) },
                    onButtonClicked = { buttonId ->
                        selectedActivityType = buttonId
                        Log.d("MyCityApp", "Selected Activity Type: $selectedActivityType")
                    }
                )
            }

            composable(MyCityScreen.DescActivity.name) {
                val dataSourceIndex = when (selectedActivityType) {

                    "Museo del Prado" -> 0
                    "Teatros" -> 1
                    // Agrega más casos según sea necesario
                    else -> 1
                }
                ActivityDescApp(
                    items = DataSource.loadMuseum().get(dataSourceIndex)
                )
            }
        }
    }
}





