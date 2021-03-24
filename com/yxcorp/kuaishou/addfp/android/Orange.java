package com.yxcorp.kuaishou.addfp.android;

import android.content.Context;
import d.q.a.a.c.b.b;
/* loaded from: classes7.dex */
public class Orange {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f41110a = true;

    /* renamed from: b  reason: collision with root package name */
    public static volatile Orange f41111b;

    public Orange() {
        g();
    }

    public static Orange a() {
        if (f41111b == null) {
            synchronized (Orange.class) {
                if (f41111b == null) {
                    f41111b = new Orange();
                }
            }
        }
        return f41111b;
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
            f41110a = false;
            b.e("so loaded");
        } catch (Throwable th) {
            b.e("so load failed");
            f41110a = true;
            b.c(th);
        }
    }

    public final boolean h() {
        return f41110a;
    }
}
