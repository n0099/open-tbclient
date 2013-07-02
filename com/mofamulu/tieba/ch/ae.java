package com.mofamulu.tieba.ch;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes.dex */
public class ae {
    public static Calendar a(Calendar calendar, int i) {
        calendar.add(5, i);
        return calendar;
    }

    public static Date a(int i) {
        return a(Calendar.getInstance(), i).getTime();
    }

    public static String a(Date date, String str) {
        if (date == null) {
            return null;
        }
        try {
            return new SimpleDateFormat(str).format(date);
        } catch (Exception e) {
            return null;
        }
    }
}
