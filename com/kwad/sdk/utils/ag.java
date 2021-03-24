package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.webkit.sdk.VideoCloudSetting;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes6.dex */
public class ag {

    /* renamed from: a  reason: collision with root package name */
    public static final SimpleDateFormat f36700a = new SimpleDateFormat("MM/dd", Locale.US);

    /* renamed from: b  reason: collision with root package name */
    public static final SimpleDateFormat f36701b = new SimpleDateFormat("yyyy/MM/dd", Locale.US);

    /* renamed from: c  reason: collision with root package name */
    public static final SimpleDateFormat f36702c = new SimpleDateFormat("MM月dd日", Locale.US);

    /* renamed from: d  reason: collision with root package name */
    public static final SimpleDateFormat f36703d = new SimpleDateFormat("yyyy年MM月dd日", Locale.US);

    /* renamed from: e  reason: collision with root package name */
    public static final SimpleDateFormat f36704e = new SimpleDateFormat("HH:mm", Locale.US);

    /* renamed from: f  reason: collision with root package name */
    public static final SimpleDateFormat f36705f = new SimpleDateFormat("MM-dd", Locale.US);

    /* renamed from: g  reason: collision with root package name */
    public static final SimpleDateFormat f36706g = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    public static String a(long j) {
        if (j <= 9999) {
            return String.valueOf(j);
        }
        if (j < 10000000) {
            double d2 = j;
            Double.isNaN(d2);
            return String.format("%.1fw", Double.valueOf(new BigDecimal(String.valueOf(d2 / 10000.0d)).setScale(1, 1).doubleValue()));
        }
        return "999.9w";
    }

    public static String a(long j, String str) {
        return j <= 0 ? str : a(j);
    }

    public static String a(Context context, long j) {
        if (j < 0) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        long abs = Math.abs(currentTimeMillis - j);
        return abs < 60000 ? "刚刚" : abs < VideoCloudSetting.HOUR_MILLISECOND ? String.format("%d分钟前", Integer.valueOf((int) (abs / 60000))) : abs < 86400000 ? String.format("%d小时前", Integer.valueOf((int) (abs / VideoCloudSetting.HOUR_MILLISECOND))) : j >= (currentTimeMillis - ((((long) Calendar.getInstance().getTimeZone().getRawOffset()) + currentTimeMillis) % 86400000)) - 86400000 ? String.format("昨天%s", c(j)) : a(currentTimeMillis, j) ? d(j) : e(j);
    }

    public static String a(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : str;
    }

    public static boolean a(long j, long j2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        int i = calendar.get(1);
        calendar.setTimeInMillis(j2);
        return i == calendar.get(1);
    }

    public static boolean a(String str) {
        return TextUtils.isEmpty(str) || StringUtil.NULL_STRING.equalsIgnoreCase(str);
    }

    public static String b(long j) {
        if (j <= 9999) {
            return String.valueOf(j);
        }
        int i = (j > 100000000L ? 1 : (j == 100000000L ? 0 : -1));
        double d2 = j;
        if (i < 0) {
            Double.isNaN(d2);
            return String.format("%.1fw", Double.valueOf(new BigDecimal(String.valueOf(d2 / 10000.0d)).setScale(1, 1).doubleValue()));
        }
        Double.isNaN(d2);
        return String.format("%.1f亿", Double.valueOf(new BigDecimal(String.valueOf(d2 / 1.0E8d)).setScale(1, 1).doubleValue()));
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches(".*\\.kpg.*");
    }

    public static String c(long j) {
        String format;
        synchronized (f36704e) {
            format = f36704e.format(new Date(j));
        }
        return format;
    }

    public static String c(String str) {
        return !TextUtils.isEmpty(str) ? str.trim().replaceAll("((\r\n)|\n)[\\s\t ]*(\\1)+", "$1") : "";
    }

    public static String d(long j) {
        String format;
        synchronized (f36705f) {
            format = f36705f.format(new Date(j));
        }
        return format;
    }

    public static String e(long j) {
        String format;
        synchronized (f36706g) {
            format = f36706g.format(new Date(j));
        }
        return format;
    }
}
