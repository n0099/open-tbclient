package com.kwad.sdk.utils;

import java.util.Locale;
/* loaded from: classes3.dex */
public class l {
    public static String a(long j2, boolean z) {
        String[] strArr = {" B", " KB", " MB", " GB", " TB", " PB", " EB", " ZB", " YB"};
        if (j2 <= 1) {
            return j2 + "B";
        }
        double d2 = j2;
        double d3 = 1024;
        int log = (int) (Math.log(d2) / Math.log(d3));
        double pow = j2 > 1024 ? d2 / Math.pow(d3, log) : d2 / d3;
        return z ? String.format(Locale.ENGLISH, "%.1f%s", Double.valueOf(pow), strArr[log]) : String.format(Locale.ENGLISH, "%.1f", Double.valueOf(pow));
    }
}
