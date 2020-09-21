package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes17.dex */
public class i extends e {
    private static i nuV = null;

    private i() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static i dSC() {
        if (nuV == null) {
            nuV = new i();
        }
        return nuV;
    }

    @Override // com.facebook.common.b.e, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (dSA()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
