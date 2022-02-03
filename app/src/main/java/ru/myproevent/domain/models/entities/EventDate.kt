package ru.myproevent.domain.models.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EventDate(
    var currDateInterval: Interval,
    var repeatValue: RepeatInterval?,
    // var repeatNumber: Int? // repeatValue и repeatNumber взимоисключающие поля сделать абстрактный класс
) : Parcelable

@Parcelize
data class RepeatInterval(
    val interval: Interval,
    var repeatFrequency: Long,
) : Parcelable