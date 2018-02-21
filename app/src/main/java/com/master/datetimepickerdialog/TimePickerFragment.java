package com.master.datetimepickerdialog;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {

    public TimePickerInterface delegate = null;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        int hour, minute;

        try {
            hour = getArguments().getInt("hour");
            minute = getArguments().getInt("minute");

        } catch (Exception e) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            hour = c.get(Calendar.HOUR_OF_DAY);
            minute = c.get(Calendar.MINUTE);
        }

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                /*DateFormat.is24HourFormat(getActivity())*/true);
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        delegate.onTimeSelected(hourOfDay, minute);
    }

}
