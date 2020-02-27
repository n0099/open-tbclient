package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes13.dex */
public class i extends e {
    private static i lIi = null;

    private i() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static i dkD() {
        if (lIi == null) {
            lIi = new i();
        }
        return lIi;
    }

    @Override // com.facebook.common.b.e, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (dkB()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
