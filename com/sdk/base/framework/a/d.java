package com.sdk.base.framework.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    public static long f38842c = 60000;

    /* renamed from: d  reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f38843d;

    /* renamed from: a  reason: collision with root package name */
    public final com.sdk.base.framework.a.a.c<String, String> f38844a;

    /* renamed from: b  reason: collision with root package name */
    public int f38845b;

    static {
        ConcurrentHashMap<String, Boolean> concurrentHashMap = new ConcurrentHashMap<>(10);
        f38843d = concurrentHashMap;
        concurrentHashMap.put(j.f38865a.toString(), Boolean.TRUE);
        new ConcurrentHashMap(10);
    }

    public d() {
        this(102400, 60000L);
    }

    public d(int i, long j) {
        this.f38845b = 102400;
        this.f38845b = 102400;
        f38842c = 60000L;
        this.f38844a = new e(this, 102400);
    }

    public static long a() {
        return f38842c;
    }

    @SuppressLint({"DefaultLocale"})
    public static boolean b(String str) {
        Boolean bool;
        if (TextUtils.isEmpty(str) || (bool = f38843d.get(str.toUpperCase())) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final String a(String str) {
        if (str != null) {
            return this.f38844a.a((com.sdk.base.framework.a.a.c<String, String>) str);
        }
        return null;
    }

    public final void a(String str, String str2, long j) {
        if (str == null || str2 == null || j < 1) {
            return;
        }
        this.f38844a.a((com.sdk.base.framework.a.a.c<String, String>) str, str2, System.currentTimeMillis() + j);
    }
}
