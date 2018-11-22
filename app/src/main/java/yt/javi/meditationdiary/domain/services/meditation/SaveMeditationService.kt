package yt.javi.meditationdiary.domain.services.meditation

import yt.javi.meditationdiary.domain.entity.Meditation
import yt.javi.meditationdiary.domain.repositories.MeditationRepository
import java.time.LocalDate
import java.time.LocalTime
import java.util.*


class SaveMeditationService(private val repository: MeditationRepository) {
    fun execute(request: MeditationRequest): MeditationResponse {
        val meditation = Meditation(
            request.id ?: repository.nextId(),
            request.date,
            request.time,
            request.notes
        )
        repository.save(meditation)

        return MeditationResponse(
            meditation.id,
            meditation.date,
            meditation.time,
            meditation.notes
        )
    }

    data class MeditationRequest(val id: UUID?, val date: LocalDate, val time: LocalTime, val notes: String)

    data class MeditationResponse(val id: UUID, val date: LocalDate, val time: LocalTime, val notes: String)
}