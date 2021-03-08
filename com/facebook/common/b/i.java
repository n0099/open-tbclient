package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes4.dex */
public class i extends e {
    private static i pBp = null;

    private i() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static i esN() {
        if (pBp == null) {
            pBp = new i();
        }
        return pBp;
    }

    @Override // com.facebook.common.b.e, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (esL()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
