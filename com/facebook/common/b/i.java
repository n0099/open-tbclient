package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes19.dex */
public class i extends e {
    private static i pbM = null;

    private i() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static i epN() {
        if (pbM == null) {
            pbM = new i();
        }
        return pbM;
    }

    @Override // com.facebook.common.b.e, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (epL()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
