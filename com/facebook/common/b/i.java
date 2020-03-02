package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes13.dex */
public class i extends e {
    private static i lIk = null;

    private i() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static i dkF() {
        if (lIk == null) {
            lIk = new i();
        }
        return lIk;
    }

    @Override // com.facebook.common.b.e, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (dkD()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
