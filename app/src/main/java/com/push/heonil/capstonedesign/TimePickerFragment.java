package com.push.heonil.capstonedesign;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import java.util.Calendar;


/**
 * Created by HEONIL on 2018-04-11.
 */

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    private AlarmManager mAlarmManager;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle SaveInstanceState) {

        mAlarmManager = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);

        Calendar c =  Calendar.getInstance();
        int PickerHour = c.get(Calendar.HOUR_OF_DAY);
        int PickerMinute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getContext(), this, PickerHour, PickerMinute,
                DateFormat.is24HourFormat(getContext()));
    }

    @Override
    public void onTimeSet(TimePicker View, int hourOfDay, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calendar.set(Calendar.MINUTE, minute);

        Intent intent = new Intent(getContext(), MainActivity.class);
        PendingIntent operation = PendingIntent.getActivity(getContext(), 0, intent, 0);

        mAlarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), operation);

    }
}
