package com.kwad.sdk.crash.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/* loaded from: classes7.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f35254c;

    /* renamed from: d  reason: collision with root package name */
    public static String f35255d;

    /* renamed from: a  reason: collision with root package name */
    public static final Object f35252a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final Object f35253b = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static SimpleDateFormat f35256e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: f  reason: collision with root package name */
    public static char[] f35257f = new char[29];

    /* renamed from: g  reason: collision with root package name */
    public static char[] f35258g = new char[29];

    public static String a(long j) {
        return j <= 0 ? "unknown" : f35256e.format(new Date(j));
    }
}
