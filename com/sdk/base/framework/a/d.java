package com.sdk.base.framework.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    public static long f36423c = 60000;

    /* renamed from: d  reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f36424d;

    /* renamed from: a  reason: collision with root package name */
    public final com.sdk.base.framework.a.a.c<String, String> f36425a;

    /* renamed from: b  reason: collision with root package name */
    public int f36426b;

    static {
        ConcurrentHashMap<String, Boolean> concurrentHashMap = new ConcurrentHashMap<>(10);
        f36424d = concurrentHashMap;
        concurrentHashMap.put(j.f36447a.toString(), Boolean.TRUE);
        new ConcurrentHashMap(10);
    }

    public d() {
        this(102400, 60000L);
    }

    public d(int i2, long j) {
        this.f36426b = 102400;
        this.f36426b = 102400;
        f36423c = 60000L;
        this.f36425a = new e(this, 102400);
    }

    public static long a() {
        return f36423c;
    }

    @SuppressLint({"DefaultLocale"})
    public static boolean b(String str) {
        Boolean bool;
        if (TextUtils.isEmpty(str) || (bool = f36424d.get(str.toUpperCase())) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final String a(String str) {
        if (str != null) {
            return this.f36425a.a((com.sdk.base.framework.a.a.c<String, String>) str);
        }
        return null;
    }

    public final void a(String str, String str2, long j) {
        if (str == null || str2 == null || j < 1) {
            return;
        }
        this.f36425a.a((com.sdk.base.framework.a.a.c<String, String>) str, str2, System.currentTimeMillis() + j);
    }
}
