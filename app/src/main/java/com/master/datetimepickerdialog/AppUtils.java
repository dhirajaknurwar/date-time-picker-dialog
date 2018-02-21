package com.master.datetimepickerdialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class AppUtils {
    public static long timeIntoTimeStamp(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy hh:mm", Locale.getDefault());
        Date d;
        long time = 0;
        try {
            d = sdf.parse(date);
            Calendar c = Calendar.getInstance();
            c.setTime(d);
            time = c.getTimeInMillis();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    public static long dateIntoTimeStamp(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy", Locale.getDefault());
        Date d;
        long time = 0;
        try {
            d = sdf.parse(date);
            Calendar c = Calendar.getInstance();
            c.setTime(d);
            time = c.getTimeInMillis();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    public static String formatCharLength(int length, int data) {
        return formatCharLength(length, String.valueOf(data));

    }

    public static String formatCharLength(int length, String data) {
        int currentLength = data.length();
        String header = "";

        if (currentLength != length) {
            for (int i = 0; i < length - currentLength; i++) {
                header += "0";
            }
        }
        return header + data;

    }
}
