package com.example.mycity.data

import com.example.mycity.R

object DataSource {

    data class ActivityType(val typeName: Int, val activities: List<Int>)

    val activityTypeName= listOf(
        R.string.activity_type1,
        R.string.activity_type2,
        R.string.activity_type3,
        R.string.activity_type4
    )

    val museumActivities= listOf(
        R.string.museum_activity1,
        R.string.museum_activity2,
        R.string.museum_activity3,
        R.string.museum_activity4
    )

    val theatreActivities= listOf(
        R.string.theatre_activity1,
        R.string.theatre_activity2,
        R.string.theatre_activity3,
        R.string.theatre_activity4
    )

    val turismActivities= listOf(
        R.string.turism_activity1,
        R.string.turism_activity2,
        R.string.turism_activity3,
        R.string.turism_activity4
    )

    val shoppingActivities= listOf(
        R.string.shopping_activity1,
        R.string.shopping_activity2,
        R.string.shopping_activity3,
        R.string.shopping_activity4
    )

    fun loadMuseum(): List<DescItems>{
        return listOf<DescItems>(
            DescItems(R.drawable.prado, R.string.ubi_prado, R.string.desc_prado),
            DescItems(R.drawable.sofia, R.string.ubi_sofia, R.string.desc_sofia),
            DescItems(R.drawable.historia, R.string.ubi_historia, R.string.desc_historia),
            DescItems(R.drawable.romanticismo, R.string.ubi_romanticismo, R.string.desc_romanticismo)
        )
    }

    fun loadTheatre(): List<DescItems>{
        return listOf<DescItems>(
            DescItems(R.drawable.luchana,R.string.ubi_luchana,R.string.desc_luchana),
            DescItems(R.drawable.lara,R.string.ubi_lara,R.string.desc_lara),
            DescItems(R.drawable.alcazar,R.string.ubi_alcazar,R.string.desc_alcazar),
            DescItems(R.drawable.marquina,R.string.ubi_marquina,R.string.desc_marquina)
        )

    }


}