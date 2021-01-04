package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes4.dex */
public final class bb {
    private static Handler qcJ;

    static {
        qcJ = null;
        qcJ = new Handler(Looper.getMainLooper());
    }

    public static void D(Runnable runnable) {
        qcJ.post(runnable);
    }
}
