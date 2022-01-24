package com.kwad.sdk.crash.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f56620c;

    /* renamed from: d  reason: collision with root package name */
    public static String f56621d;
    public static final Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final Object f56619b = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static SimpleDateFormat f56622e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: f  reason: collision with root package name */
    public static char[] f56623f = new char[29];

    /* renamed from: g  reason: collision with root package name */
    public static char[] f56624g = new char[29];

    public static String a(long j2) {
        return j2 <= 0 ? "unknown" : f56622e.format(new Date(j2));
    }
}
