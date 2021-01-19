package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes14.dex */
public class i extends e {
    private static i poz = null;

    private i() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static i eqd() {
        if (poz == null) {
            poz = new i();
        }
        return poz;
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
