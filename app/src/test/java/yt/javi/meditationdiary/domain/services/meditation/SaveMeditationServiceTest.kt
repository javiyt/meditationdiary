package yt.javi.meditationdiary.domain.services.meditation

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import yt.javi.meditationdiary.domain.repositories.MeditationRepository
import yt.javi.meditationdiary.domain.services.meditation.SaveMeditationService.MeditationRequest
import java.time.LocalDate
import java.time.LocalTime
import java.util.UUID.randomUUID

class SaveMeditationServiceTest {
    companion object {
        val NOTES = "test"
        val ID = randomUUID()
    }

    private lateinit var service: SaveMeditationService

    val repository = mock<MeditationRepository>()

    val request = mock<MeditationRequest> {}

    @Before
    fun setUp() {
        service = SaveMeditationService(repository)
    }

    @Test
    fun saveANewMeditation() {
        whenever(request.id).thenReturn(null)
        whenever(request.date).thenReturn(LocalDate.MIN)
        whenever(request.time).thenReturn(LocalTime.NOON)
        whenever(request.notes).thenReturn(NOTES)
        whenever(repository.nextId()).thenReturn(ID)

        assertThat(service.execute(request))
            .hasFieldOrPropertyWithValue("id", ID)
            .hasFieldOrPropertyWithValue("date", LocalDate.MIN)
            .hasFieldOrPropertyWithValue("time", LocalTime.NOON)
            .hasFieldOrPropertyWithValue("notes", NOTES)

        verify(repository).nextId()
    }

    @Test
    fun updateAGivenMeditation() {
        whenever(request.id).thenReturn(ID)
        whenever(request.date).thenReturn(LocalDate.MIN)
        whenever(request.time).thenReturn(LocalTime.NOON)
        whenever(request.notes).thenReturn(NOTES)

        assertThat(service.execute(request))
            .hasFieldOrPropertyWithValue("id", ID)
            .hasFieldOrPropertyWithValue("date", LocalDate.MIN)
            .hasFieldOrPropertyWithValue("time", LocalTime.NOON)
            .hasFieldOrPropertyWithValue("notes", NOTES)

        verify(repository, never()).nextId()
    }
}