package yt.javi.meditationdiary.domain.repositories

import yt.javi.meditationdiary.domain.entity.Meditation
import java.util.*


interface MeditationRepository {
    fun nextId(): UUID

    fun save(meditation: Meditation)
}