package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes3.dex */
public final class bb {
    private static Handler pZQ;

    static {
        pZQ = null;
        pZQ = new Handler(Looper.getMainLooper());
    }

    public static void D(Runnable runnable) {
        pZQ.post(runnable);
    }
}
