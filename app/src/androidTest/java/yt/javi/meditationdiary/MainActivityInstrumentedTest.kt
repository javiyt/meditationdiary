package yt.javi.meditationdiary

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.espresso.intent.Intents.*
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.rule.ActivityTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickOn
import com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo
import com.schibsted.spain.barista.interaction.BaristaPickerInteractions.setDateOnPicker
import com.schibsted.spain.barista.interaction.BaristaPickerInteractions.setTimeOnPicker
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith



/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {
    @get:Rule
    var activityActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        init()
    }

    @After
    fun tearDown() {
        release()
    }

    @Test
    fun useAppContext() {
        assertEquals("yt.javi.meditationdiary", InstrumentationRegistry.getTargetContext().packageName)
    }

    @Test
    fun formIsShown() {
        assertDisplayed(R.id.button_date)
        assertDisplayed(R.id.input_date)
        assertDisplayed(R.id.button_time)
        assertDisplayed(R.id.input_time)
        assertDisplayed(R.id.input_notes)
        assertDisplayed(R.id.button_save)
    }

    @Test
    fun formCanBeFilled() {
        clickOn(R.id.button_date)
        setDateOnPicker(1986, 3, 23)
        clickOn(R.id.button_time)
        setTimeOnPicker(17, 3)
        writeTo(R.id.input_notes, "This is a test")
        clickOn(R.id.button_save)

        intended(hasComponent(CalendarActivity::class.java.name))
    }
}
