package com.kwad.sdk.crash.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/* loaded from: classes8.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f55137c;

    /* renamed from: d  reason: collision with root package name */
    public static String f55138d;
    public static final Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final Object f55136b = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static SimpleDateFormat f55139e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: f  reason: collision with root package name */
    public static char[] f55140f = new char[29];

    /* renamed from: g  reason: collision with root package name */
    public static char[] f55141g = new char[29];

    public static String a(long j2) {
        return j2 <= 0 ? "unknown" : f55139e.format(new Date(j2));
    }
}
