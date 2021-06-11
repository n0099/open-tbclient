package com.kwad.sdk.crash.utils;

import java.text.SimpleDateFormat;
/* loaded from: classes7.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static SimpleDateFormat f35161a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String a(long j) {
        String valueOf;
        String valueOf2;
        long j2 = j / 60000;
        long j3 = (j - (60000 * j2)) / 1000;
        if (j2 < 10) {
            valueOf = "0" + j2;
        } else {
            valueOf = String.valueOf(j2);
        }
        if (j3 < 10) {
            valueOf2 = "0" + j3;
        } else {
            valueOf2 = String.valueOf(j3);
        }
        return valueOf + ":" + valueOf2;
    }
}
