package yt.javi.meditationdiary.fragments

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import android.text.format.DateFormat
import android.widget.TimePicker
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*

class TimePickerFragment : androidx.fragment.app.DialogFragment(), TimePickerDialog.OnTimeSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return TimePickerDialog(
            activity, this, Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
            Calendar.getInstance().get(Calendar.MINUTE), DateFormat.is24HourFormat(activity)
        )
    }

    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
        input_time.text = LocalTime.of(hourOfDay, minute).format(DateTimeFormatter.ofPattern("HH:mm"))
    }
}