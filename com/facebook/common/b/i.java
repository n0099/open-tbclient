package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes13.dex */
public class i extends e {
    private static i lRv = null;

    private i() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static i dmW() {
        if (lRv == null) {
            lRv = new i();
        }
        return lRv;
    }

    @Override // com.facebook.common.b.e, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (dmU()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
