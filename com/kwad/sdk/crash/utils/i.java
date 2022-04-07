package com.kwad.sdk.crash.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/* loaded from: classes5.dex */
public class i {
    public static List<String> c;
    public static String d;
    public static final Object a = new Object();
    public static final Object b = new Object();
    public static SimpleDateFormat e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static char[] f = new char[29];
    public static char[] g = new char[29];

    public static String a(long j) {
        return j <= 0 ? "unknown" : e.format(new Date(j));
    }
}
