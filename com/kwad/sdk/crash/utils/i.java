package com.kwad.sdk.crash.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f6399a = new Object();
    private static final Object b = new Object();
    private static List<String> c = null;
    private static String d = null;
    private static SimpleDateFormat e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static char[] f = new char[29];
    private static char[] g = new char[29];

    public static String a(long j) {
        return j <= 0 ? "unknown" : e.format(new Date(j));
    }
}
