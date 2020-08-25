package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes9.dex */
public class i extends e {
    private static i nkD = null;

    private i() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static i dOv() {
        if (nkD == null) {
            nkD = new i();
        }
        return nkD;
    }

    @Override // com.facebook.common.b.e, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (dOt()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
