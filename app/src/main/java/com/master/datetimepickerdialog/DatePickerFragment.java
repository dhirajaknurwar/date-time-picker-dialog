package com.master.datetimepickerdialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    public DatePickerSelectionInterface delegate = null;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        int year, month, dayOfMonth;

        try {
            year = getArguments().getInt("year");
            month = getArguments().getInt("month");
            dayOfMonth = getArguments().getInt("day");

        } catch (Exception e) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH);
            dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        }

        // Create a new instance of TimePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, dayOfMonth);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        delegate.onDateSelected(dayOfMonth, month, year);
    }
}
