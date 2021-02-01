package com.kwad.sdk.crash.utils;

import com.kwad.sdk.collector.AppStatusRules;
import java.text.SimpleDateFormat;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static SimpleDateFormat f9670a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String a(long j) {
        long j2 = j / AppStatusRules.DEFAULT_GRANULARITY;
        long j3 = (j - (AppStatusRules.DEFAULT_GRANULARITY * j2)) / 1000;
        return (j2 < 10 ? "0" + j2 : String.valueOf(j2)) + ":" + (j3 < 10 ? "0" + j3 : String.valueOf(j3));
    }
}
