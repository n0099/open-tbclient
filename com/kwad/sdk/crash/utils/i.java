package com.kwad.sdk.crash.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/* loaded from: classes6.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f34505c;

    /* renamed from: d  reason: collision with root package name */
    public static String f34506d;

    /* renamed from: a  reason: collision with root package name */
    public static final Object f34503a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final Object f34504b = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static SimpleDateFormat f34507e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: f  reason: collision with root package name */
    public static char[] f34508f = new char[29];

    /* renamed from: g  reason: collision with root package name */
    public static char[] f34509g = new char[29];

    public static String a(long j) {
        return j <= 0 ? "unknown" : f34507e.format(new Date(j));
    }
}
