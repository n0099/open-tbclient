package com.kwad.sdk.crash.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f58790c;

    /* renamed from: d  reason: collision with root package name */
    public static String f58791d;
    public static final Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final Object f58789b = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static SimpleDateFormat f58792e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: f  reason: collision with root package name */
    public static char[] f58793f = new char[29];

    /* renamed from: g  reason: collision with root package name */
    public static char[] f58794g = new char[29];

    public static String a(long j2) {
        return j2 <= 0 ? "unknown" : f58792e.format(new Date(j2));
    }
}
