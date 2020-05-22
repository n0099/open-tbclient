package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes13.dex */
public class i extends e {
    private static i mlr = null;

    private i() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static i dun() {
        if (mlr == null) {
            mlr = new i();
        }
        return mlr;
    }

    @Override // com.facebook.common.b.e, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (dul()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
