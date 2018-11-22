package yt.javi.meditationdiary.fragments

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.widget.DatePicker
import android.widget.TextView
import yt.javi.meditationdiary.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(activity, this, year, month, day)
    }

    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
        activity?.findViewById<TextView>(R.id.input_date)?.text =
                LocalDate.of(year, month, day).format(DateTimeFormatter.ISO_LOCAL_DATE)
    }
}
