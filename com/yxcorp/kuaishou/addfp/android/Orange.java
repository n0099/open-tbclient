package com.yxcorp.kuaishou.addfp.android;

import android.content.Context;
import d.r.a.a.c.b.b;
/* loaded from: classes7.dex */
public class Orange {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f41495a = true;

    /* renamed from: b  reason: collision with root package name */
    public static volatile Orange f41496b;

    public Orange() {
        g();
    }

    public static Orange a() {
        if (f41496b == null) {
            synchronized (Orange.class) {
                if (f41496b == null) {
                    f41496b = new Orange();
                }
            }
        }
        return f41496b;
    }

    public static native String getClock(Context context, byte[] bArr, int i);

    public static native byte[] getMagic(Context context, byte[] bArr, int i);

    public static native Object jniCommand(int i, Object obj, Object obj2, Object obj3);

    public synchronized String b(Context context, byte[] bArr, int i) {
        if (h()) {
            return "";
        }
        return getClock(context, bArr, i);
    }

    public String c() {
        try {
            return h() ? "" : (String) jniCommand(1114128, null, null, null);
        } catch (Throwable th) {
            b.c(th);
            return "";
        }
    }

    public synchronized byte[] d(Context context, byte[] bArr, int i) {
        if (h()) {
            return null;
        }
        return getMagic(context, bArr, i);
    }

    public String e() {
        try {
            return h() ? "" : (String) jniCommand(1179649, null, null, null);
        } catch (Throwable th) {
            b.c(th);
            return "";
        }
    }

    public String f() {
        try {
            return h() ? "" : (String) jniCommand(1179653, null, null, null);
        } catch (Throwable th) {
            b.c(th);
            return "";
        }
    }

    public final void g() {
        try {
            System.loadLibrary("sgcore");
            f41495a = false;
            b.e("so loaded");
        } catch (Throwable th) {
            b.e("so load failed");
            f41495a = true;
            b.c(th);
        }
    }

    public final boolean h() {
        return f41495a;
    }
}
