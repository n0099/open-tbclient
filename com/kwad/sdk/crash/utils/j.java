package com.kwad.sdk.crash.utils;

import java.text.SimpleDateFormat;
/* loaded from: classes3.dex */
public class j {
    public static SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String a(long j2) {
        String valueOf;
        String valueOf2;
        long j3 = j2 / 60000;
        long j4 = (j2 - (60000 * j3)) / 1000;
        if (j3 < 10) {
            valueOf = "0" + j3;
        } else {
            valueOf = String.valueOf(j3);
        }
        if (j4 < 10) {
            valueOf2 = "0" + j4;
        } else {
            valueOf2 = String.valueOf(j4);
        }
        return valueOf + ":" + valueOf2;
    }
}
