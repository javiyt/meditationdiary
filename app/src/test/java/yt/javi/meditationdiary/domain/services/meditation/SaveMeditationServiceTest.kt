package yt.javi.meditationdiary.domain.services.meditation

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test
import yt.javi.meditationdiary.domain.repositories.MeditationRepository
import yt.javi.meditationdiary.domain.services.meditation.SaveMeditationService.MeditationRequest
import java.time.LocalDate
import java.time.LocalTime

class SaveMeditationServiceTest {
    private lateinit var service: SaveMeditationService

    val repository = mock<MeditationRepository>()

    val request = mock<MeditationRequest>{}

    @Before
    fun setUp() {
        service = SaveMeditationService(repository)
    }

    @Test
    fun saveANewMeditation() {
        whenever(request.id).thenReturn(null)
        whenever(request.date).thenReturn(LocalDate.MIN)
        whenever(request.time).thenReturn(LocalTime.NOON)
        whenever(request.notes).thenReturn("test")
    }
}