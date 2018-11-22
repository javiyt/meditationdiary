package yt.javi.meditationdiary

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import yt.javi.meditationdiary.fragments.DatePickerFragment
import yt.javi.meditationdiary.fragments.TimePickerFragment
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.input_date).text = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE)
        findViewById<TextView>(R.id.input_time).text = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))
    }

    fun showDatePickerDialog(v: View) {
        DatePickerFragment().show(supportFragmentManager, "datePicker")
    }

    fun showTimePickerDialog(v: View) {
        TimePickerFragment().show(supportFragmentManager, "timePicker")
    }

    fun saveMeditation(v: View) {
        val intent = Intent(this, CalendarActivity::class.java)
        startActivity(intent)
    }
}
