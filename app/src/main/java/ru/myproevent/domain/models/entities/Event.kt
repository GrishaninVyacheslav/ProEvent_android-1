package ru.myproevent.domain.models.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class Event(
    var id: Long?,
    var name: String,
    var ownerUserId: Long,
    var eventStatus: Status,
    var startDate: Date,
    var endDate: Date,
    //val eventDates: List<Interval> = listOf(Interval(1641024033, 1641067233), Interval(1641155433, 1641165333)),
    var description: String?,
    var participantsUserIds: LongArray?,
    var city: String?,
    var address: Address?,
    var mapsFileIds: LongArray?,
    var pointsPointIds: LongArray?,
    var imageFile: String?,
) : Parcelable {
    @Parcelize
    enum class Status(val value: String) : Parcelable {
        ALL("ALL"),
        ACTUAL("ACTUAL"),
        COMPLETED("COMPLETED"),
        CANCELLED("CANCELLED");

        companion object {
            fun fromString(status: String) = valueOf(status)
        }
    }
}