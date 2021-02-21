package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes3.dex */
public final class bb {
    private static Handler qkv;

    static {
        qkv = null;
        qkv = new Handler(Looper.getMainLooper());
    }

    public static void C(Runnable runnable) {
        qkv.post(runnable);
    }
}
