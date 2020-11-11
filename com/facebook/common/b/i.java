package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes6.dex */
public class i extends e {
    private static i oLa = null;

    private i() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static i eka() {
        if (oLa == null) {
            oLa = new i();
        }
        return oLa;
    }

    @Override // com.facebook.common.b.e, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (ejY()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
