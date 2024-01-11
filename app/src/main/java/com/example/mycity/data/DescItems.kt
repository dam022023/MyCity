package com.example.mycity.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class DescItems(
    @DrawableRes val image: Int,
    @StringRes val ubi: Int,
    @StringRes val desc: Int,
)
