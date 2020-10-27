package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes6.dex */
public class i extends e {
    private static i oBH = null;

    private i() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static i egl() {
        if (oBH == null) {
            oBH = new i();
        }
        return oBH;
    }

    @Override // com.facebook.common.b.e, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (egj()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
