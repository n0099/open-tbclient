package com.kwad.components.core.m;

import java.util.Locale;
/* loaded from: classes8.dex */
public final class h {
    public static String a(long j, boolean z) {
        String[] strArr = {" B", " KB", " MB", " GB", " TB", " PB", " EB", " ZB", " YB"};
        if (j > 1) {
            double d = j;
            int log = (int) (Math.log(d) / Math.log(1024.0d));
            return String.format(Locale.ENGLISH, "%.1f%s", Double.valueOf(j > 1024 ? d / Math.pow(1024.0d, log) : d / 1024.0d), strArr[log]);
        }
        return j + "B";
    }
}
