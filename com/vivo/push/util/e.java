package com.vivo.push.util;

import android.os.Looper;
import android.util.Log;
/* loaded from: classes3.dex */
public final class e {
    public static void a(String str) {
        if (m.a() && Looper.myLooper() == Looper.getMainLooper()) {
            Log.w("DebugUtil", "Operation: " + str + " in main thread!", new Throwable());
        }
    }
}
