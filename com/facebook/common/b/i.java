package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes13.dex */
public class i extends e {
    private static i lRz = null;

    private i() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static i dmT() {
        if (lRz == null) {
            lRz = new i();
        }
        return lRz;
    }

    @Override // com.facebook.common.b.e, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (dmR()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
