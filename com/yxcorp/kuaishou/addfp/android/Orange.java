package com.yxcorp.kuaishou.addfp.android;

import android.content.Context;
import d.q.a.a.c.b.b;
/* loaded from: classes7.dex */
public class Orange {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f39041a = true;

    /* renamed from: b  reason: collision with root package name */
    public static volatile Orange f39042b;

    public Orange() {
        h();
    }

    public static Orange a() {
        if (f39042b == null) {
            synchronized (Orange.class) {
                if (f39042b == null) {
                    f39042b = new Orange();
                }
            }
        }
        return f39042b;
    }

    public static native String getClock(Context context, byte[] bArr, int i2);

    public static native byte[] getMagic(Context context, byte[] bArr, int i2);

    public static native Object jniCommand(int i2, Object obj, Object obj2, Object obj3);

    public synchronized String b(Context context, byte[] bArr, int i2) {
        if (i()) {
            return "";
        }
        return getClock(context, bArr, i2);
    }

    public String c() {
        try {
            return i() ? "" : (String) jniCommand(1114128, null, null, null);
        } catch (Throwable th) {
            b.c(th);
            return "";
        }
    }

    public synchronized byte[] d(Context context, byte[] bArr, int i2) {
        if (i()) {
            return null;
        }
        return getMagic(context, bArr, i2);
    }

    public String e() {
        try {
            return i() ? "" : (String) jniCommand(1179649, null, null, null);
        } catch (Throwable th) {
            b.c(th);
            return "";
        }
    }

    public String f() {
        try {
            return i() ? "" : (String) jniCommand(1179653, null, null, null);
        } catch (Throwable th) {
            b.c(th);
            return "";
        }
    }

    public String g() {
        try {
            return i() ? "" : (String) jniCommand(1114131, null, null, null);
        } catch (Throwable th) {
            b.c(th);
            return "";
        }
    }

    public final void h() {
        try {
            System.loadLibrary("sgcore");
            f39041a = false;
            b.e("so loaded");
        } catch (Throwable th) {
            b.e("so load failed");
            f39041a = true;
            b.c(th);
        }
    }

    public final boolean i() {
        return f39041a;
    }
}
