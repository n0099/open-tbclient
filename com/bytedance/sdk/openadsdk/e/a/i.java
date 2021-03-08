package com.bytedance.sdk.openadsdk.e.a;

import android.util.Log;
/* loaded from: classes6.dex */
class i {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f4740a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z) {
        f4740a = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str) {
        if (f4740a) {
            Log.i("JsBridge2", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(String str) {
        if (f4740a) {
            Log.w("JsBridge2", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, Throwable th) {
        if (f4740a) {
            Log.w("JsBridge2", str, th);
            Log.w("JsBridge2", "Stacktrace: " + Log.getStackTraceString(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(String str, Throwable th) {
        if (f4740a) {
            Log.e("JsBridge2", str, th);
            Log.e("JsBridge2", "Stacktrace: " + Log.getStackTraceString(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(RuntimeException runtimeException) {
        if (f4740a) {
            throw runtimeException;
        }
    }
}
