package com.yxcorp.kuaishou.addfp.android;

import android.content.Context;
import com.yxcorp.kuaishou.addfp.android.b.b;
/* loaded from: classes4.dex */
public class Orange {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f14380a = true;
    private static volatile Orange qbT;

    private Orange() {
        e();
    }

    private void e() {
        try {
            System.loadLibrary("sgcore");
            f14380a = false;
            b.b("so loaded");
        } catch (Throwable th) {
            b.b("so load failed");
            f14380a = true;
            b.a(th);
        }
    }

    public static Orange eHk() {
        if (qbT == null) {
            synchronized (Orange.class) {
                if (qbT == null) {
                    qbT = new Orange();
                }
            }
        }
        return qbT;
    }

    private boolean f() {
        return f14380a;
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
