package ru.myproevent.domain.models.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Interval(
    var start: Long,
    var end: Long
) : Parcelable