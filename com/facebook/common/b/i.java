package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes3.dex */
public class i extends e {
    private static i pta = null;

    private i() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static i etX() {
        if (pta == null) {
            pta = new i();
        }
        return pta;
    }

    @Override // com.facebook.common.b.e, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (etV()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
