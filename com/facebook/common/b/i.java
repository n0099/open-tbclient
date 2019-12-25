package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes11.dex */
public class i extends e {
    private static i lDY = null;

    private i() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static i din() {
        if (lDY == null) {
            lDY = new i();
        }
        return lDY;
    }

    @Override // com.facebook.common.b.e, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (dil()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
