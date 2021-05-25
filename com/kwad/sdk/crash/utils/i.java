package com.kwad.sdk.crash.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/* loaded from: classes6.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f33032c;

    /* renamed from: d  reason: collision with root package name */
    public static String f33033d;

    /* renamed from: a  reason: collision with root package name */
    public static final Object f33030a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final Object f33031b = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static SimpleDateFormat f33034e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: f  reason: collision with root package name */
    public static char[] f33035f = new char[29];

    /* renamed from: g  reason: collision with root package name */
    public static char[] f33036g = new char[29];

    public static String a(long j) {
        return j <= 0 ? "unknown" : f33034e.format(new Date(j));
    }
}
