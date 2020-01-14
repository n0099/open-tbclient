package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes12.dex */
public class i extends e {
    private static i lHB = null;

    private i() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static i djq() {
        if (lHB == null) {
            lHB = new i();
        }
        return lHB;
    }

    @Override // com.facebook.common.b.e, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (djo()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
