package com.qq.e.comm.plugin.util;

import java.util.Locale;
/* loaded from: classes3.dex */
public class au {
    public static String a(long j) {
        return String.format(Locale.ENGLISH, "%.2f M", Float.valueOf(((float) j) / 1048576.0f));
    }

    public static String b(long j) {
        return String.format(Locale.ENGLISH, "%.2f K", Float.valueOf(((float) j) / 1024.0f));
    }

    public static String c(long j) {
        return j > 1048576 ? a(j) : b(j);
    }
}
