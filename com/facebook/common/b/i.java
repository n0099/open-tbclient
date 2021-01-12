package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes14.dex */
public class i extends e {
    private static i poy = null;

    private i() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static i eqd() {
        if (poy == null) {
            poy = new i();
        }
        return poy;
    }

    @Override // com.facebook.common.b.e, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (eqb()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
