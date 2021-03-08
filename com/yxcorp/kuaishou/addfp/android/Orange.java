package com.yxcorp.kuaishou.addfp.android;

import android.content.Context;
import com.yxcorp.kuaishou.addfp.android.b.b;
/* loaded from: classes3.dex */
public class Orange {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f8620a = true;
    private static volatile Orange qmZ;

    private Orange() {
        e();
    }

    private void e() {
        try {
            System.loadLibrary("sgcore");
            f8620a = false;
            b.b("so loaded");
        } catch (Throwable th) {
            b.b("so load failed");
            f8620a = true;
            b.a(th);
        }
    }

    public static Orange eJq() {
        if (qmZ == null) {
            synchronized (Orange.class) {
                if (qmZ == null) {
                    qmZ = new Orange();
                }
            }
        }
        return qmZ;
    }

    private boolean f() {
        return f8620a;
    }

    private static native String getClock(Context context, byte[] bArr, int i);

    private static native byte[] getMagic(Context context, byte[] bArr, int i);

    private static native Object jniCommand(int i, Object obj, Object obj2, Object obj3);

    public synchronized String a(Context context, byte[] bArr, int i) {
        return f() ? "" : getClock(context, bArr, i);
    }

    public String b() {
        try {
            return f() ? "" : (String) jniCommand(1114128, null, null, null);
        } catch (Throwable th) {
            b.a(th);
            return "";
        }
    }

    public synchronized byte[] b(Context context, byte[] bArr, int i) {
        return f() ? null : getMagic(context, bArr, i);
    }

    public String c() {
        try {
            return f() ? "" : (String) jniCommand(1179649, null, null, null);
        } catch (Throwable th) {
            b.a(th);
            return "";
        }
    }

    public String d() {
        try {
            return f() ? "" : (String) jniCommand(1179653, null, null, null);
        } catch (Throwable th) {
            b.a(th);
            return "";
        }
    }
}
