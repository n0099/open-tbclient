package com.bytedance.sdk.openadsdk.f.a;

import android.util.Log;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f29004a;

    public static void a(boolean z) {
        f29004a = z;
    }

    public static void b(String str) {
        if (f29004a) {
            Log.w("JsBridge2", str);
        }
    }

    public static void a(String str) {
        if (f29004a) {
            Log.i("JsBridge2", str);
        }
    }

    public static void b(String str, Throwable th) {
        if (f29004a) {
            Log.e("JsBridge2", str, th);
            Log.e("JsBridge2", "Stacktrace: " + Log.getStackTraceString(th));
        }
    }

    public static void a(String str, Throwable th) {
        if (f29004a) {
            Log.w("JsBridge2", str, th);
            Log.w("JsBridge2", "Stacktrace: " + Log.getStackTraceString(th));
        }
    }

    public static void a(RuntimeException runtimeException) {
        if (f29004a) {
            throw runtimeException;
        }
    }
}
