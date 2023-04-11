package com.yy.gslbsdk.util;

import android.annotation.SuppressLint;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"SimpleDateFormat"})
/* loaded from: classes9.dex */
public class FormatTools {
    public static final String TAG = "FormatTools";
    public static SimpleDateFormat full_date_time_format1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    public static SimpleDateFormat full_date_time_format2 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
    public static SimpleDateFormat full_date_time_format3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat full_date_format1 = new SimpleDateFormat("yyyy/MM/dd");
    public static SimpleDateFormat full_date_format2 = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat full_time_format = new SimpleDateFormat("HH:mm:ss");
    public static SimpleDateFormat time_hour_minute_format = new SimpleDateFormat("HH:mm");
    public static SimpleDateFormat year_format = new SimpleDateFormat("yyyy");
    public static DecimalFormat two_decimal = new DecimalFormat("0.00");

    public static boolean containInList(List<?> list, Object obj) {
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().equals(obj)) {
                return true;
            }
        }
        return false;
    }

    public static String getDateStr(SimpleDateFormat simpleDateFormat, long j) {
        try {
            return simpleDateFormat.format(new Date(j));
        } catch (Exception e) {
            LogTools.printWarning(TAG, e);
            return null;
        }
    }

    public static long getDateTimestamp(SimpleDateFormat simpleDateFormat, String str) {
        try {
            if (str == null) {
                return new Date().getTime();
            }
            return simpleDateFormat.parse(str).getTime();
        } catch (ParseException e) {
            LogTools.printWarning(TAG, e);
            return 0L;
        }
    }

    public static int daysOfTwo(String str, String str2) {
        try {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            calendar.setTime(simpleDateFormat.parse(str + " 00:00:00"));
            int i = calendar.get(6);
            calendar.setTime(simpleDateFormat.parse(str2 + " 00:00:00"));
            return calendar.get(6) - i;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String getDayBeginFromOne(SimpleDateFormat simpleDateFormat, String str, int i) {
        try {
            Calendar calendar = Calendar.getInstance();
            if (str == null) {
                calendar.setTime(new Date());
            } else {
                calendar.setTime(simpleDateFormat.parse(str));
            }
            calendar.add(5, i);
            return simpleDateFormat.format(calendar.getTime());
        } catch (Exception e) {
            LogTools.printWarning(TAG, e);
            return null;
        }
    }

    public static Date getSecondBeginFromOne(SimpleDateFormat simpleDateFormat, String str, int i) {
        try {
            Calendar calendar = Calendar.getInstance();
            if (str == null) {
                calendar.setTime(new Date());
            } else {
                calendar.setTime(simpleDateFormat.parse(str));
            }
            calendar.add(13, i);
            return calendar.getTime();
        } catch (Exception e) {
            LogTools.printWarning(TAG, e);
            return null;
        }
    }
}
