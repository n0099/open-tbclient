package com.xiaomi.push;

import java.util.Calendar;
import java.util.TimeZone;
/* loaded from: classes10.dex */
public class ae {
    public static final TimeZone a = TimeZone.getTimeZone("Asia/Shanghai");

    public static int a() {
        return (int) (((m257a() / 3600000) % 24) + 8);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static final long m257a() {
        return Calendar.getInstance(a).getTimeInMillis();
    }

    public static long b() {
        return m257a() / 86400000;
    }
}
