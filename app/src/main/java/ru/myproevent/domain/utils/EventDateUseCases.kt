package ru.myproevent.domain.utils

import android.util.Log
import ru.myproevent.domain.models.entities.EventDate
import ru.myproevent.domain.models.entities.Interval

class EventDateUseCases {
    companion object {
        fun toTimeIntervals(eventDates: List<EventDate>): List<Interval> {
            val timeIntervals = dateAndItsRepeatsAsIntervals(eventDates)
            timeIntervals.sortWith { a, b -> (a.start - b.start).toInt() }
            timeIntervals.mergeIntersectingIntervals()
            return timeIntervals
        }

        fun toEventDates(intervals: List<Interval>): List<EventDate> {
            TODO("NOT YET IMPLEMENTED")
        }

        private fun dateAndItsRepeatsAsIntervals(eventDates: List<EventDate>): MutableList<Interval>{
            val timeIntervals = mutableListOf<Interval>()
            for (eventDate in eventDates) {
                with(eventDate) {
                    timeIntervals.add(currDateInterval)
                    repeatValue?.let { repeatValue ->
                        val firstRepeatedDateIntervalStart =
                            //repeatValue.interval.start - (repeatValue.interval.start - currDateInterval.end) % repeatValue.repeatFrequency + repeatValue.repeatFrequency
                            repeatValue.interval.start + (repeatValue.interval.start - currDateInterval.end) % repeatValue.repeatFrequency + (currDateInterval.end - currDateInterval.start) + repeatValue.repeatFrequency

                        Log.d("[TEST]", "firstRepeatedDateIntervalStart: $firstRepeatedDateIntervalStart")

                        var repeatedDateInterval = Interval(
                            firstRepeatedDateIntervalStart,
                            firstRepeatedDateIntervalStart + (currDateInterval.end - currDateInterval.start)
                        )
                        while (repeatedDateInterval.start <= repeatValue.interval.end) {
                            timeIntervals.add(repeatedDateInterval)
                            repeatedDateInterval = Interval(
                                repeatedDateInterval.end + repeatValue.repeatFrequency,
                                repeatedDateInterval.end + repeatValue.repeatFrequency + (currDateInterval.end - currDateInterval.start)
                            )
                        }
                    }
                }
            }
            return timeIntervals
        }
    }
}