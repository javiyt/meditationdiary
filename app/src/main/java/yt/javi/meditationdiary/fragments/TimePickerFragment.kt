package yt.javi.meditationdiary.fragments

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.text.format.DateFormat
import android.widget.TextView
import android.widget.TimePicker
import yt.javi.meditationdiary.R
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*

class TimePickerFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Use the current time as the default values for the picker
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)

        // Create a new instance of TimePickerDialog and return it
        return TimePickerDialog(activity, this, hour, minute, DateFormat.is24HourFormat(activity))
    }

    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
        activity?.findViewById<TextView>(R.id.input_time)?.text =
                LocalTime.of(hourOfDay, minute).format(DateTimeFormatter.ofPattern("HH:mm"))
    }
}