package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.kwad.sdk.collector.AppStatusRules;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes5.dex */
public class ag {

    /* renamed from: a  reason: collision with root package name */
    private static final SimpleDateFormat f11071a = new SimpleDateFormat("MM/dd", Locale.US);

    /* renamed from: b  reason: collision with root package name */
    private static final SimpleDateFormat f11072b = new SimpleDateFormat("yyyy/MM/dd", Locale.US);
    private static final SimpleDateFormat c = new SimpleDateFormat("MM月dd日", Locale.US);
    private static final SimpleDateFormat d = new SimpleDateFormat("yyyy年MM月dd日", Locale.US);
    private static final SimpleDateFormat e = new SimpleDateFormat("HH:mm", Locale.US);
    private static final SimpleDateFormat f = new SimpleDateFormat("MM-dd", Locale.US);
    private static final SimpleDateFormat g = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    public static String a(long j) {
        return j <= 9999 ? String.valueOf(j) : j < 10000000 ? String.format("%.1fw", Double.valueOf(new BigDecimal(String.valueOf(j / 10000.0d)).setScale(1, 1).doubleValue())) : "999.9w";
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
        return abs < AppStatusRules.DEFAULT_GRANULARITY ? "刚刚" : abs < BdKVCache.MILLS_1Hour ? String.format("%d分钟前", Integer.valueOf((int) (abs / AppStatusRules.DEFAULT_GRANULARITY))) : abs < 86400000 ? String.format("%d小时前", Integer.valueOf((int) (abs / BdKVCache.MILLS_1Hour))) : j >= (currentTimeMillis - ((((long) Calendar.getInstance().getTimeZone().getRawOffset()) + currentTimeMillis) % 86400000)) - 86400000 ? String.format("昨天%s", c(j)) : a(currentTimeMillis, j) ? d(j) : e(j);
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
        return TextUtils.isEmpty(str) || "null".equalsIgnoreCase(str);
    }

    public static String b(long j) {
        return j <= 9999 ? String.valueOf(j) : j < 100000000 ? String.format("%.1fw", Double.valueOf(new BigDecimal(String.valueOf(j / 10000.0d)).setScale(1, 1).doubleValue())) : String.format("%.1f亿", Double.valueOf(new BigDecimal(String.valueOf(j / 1.0E8d)).setScale(1, 1).doubleValue()));
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches(".*\\.kpg.*");
    }

    public static String c(long j) {
        String format;
        synchronized (e) {
            format = e.format(new Date(j));
        }
        return format;
    }

    public static String c(String str) {
        return !TextUtils.isEmpty(str) ? str.trim().replaceAll("((\r\n)|\n)[\\s\t ]*(\\1)+", "$1") : "";
    }

    public static String d(long j) {
        String format;
        synchronized (f) {
            format = f.format(new Date(j));
        }
        return format;
    }

    public static String e(long j) {
        String format;
        synchronized (g) {
            format = g.format(new Date(j));
        }
        return format;
    }
}
