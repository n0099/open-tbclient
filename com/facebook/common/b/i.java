package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes19.dex */
public class i extends e {
    private static i pbO = null;

    private i() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static i epO() {
        if (pbO == null) {
            pbO = new i();
        }
        return pbO;
    }

    @Override // com.facebook.common.b.e, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (epM()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
