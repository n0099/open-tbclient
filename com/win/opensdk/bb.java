package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes3.dex */
public final class bb {
    private static Handler qjV;

    static {
        qjV = null;
        qjV = new Handler(Looper.getMainLooper());
    }

    public static void C(Runnable runnable) {
        qjV.post(runnable);
    }
}
