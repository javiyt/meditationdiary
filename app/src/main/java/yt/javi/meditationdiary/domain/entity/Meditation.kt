package yt.javi.meditationdiary.domain.entity

import java.time.LocalDate
import java.time.LocalTime
import java.util.*


data class Meditation(val id: UUID, val date: LocalDate, val time: LocalTime, val notes: String)