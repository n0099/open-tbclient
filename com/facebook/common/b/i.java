package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes13.dex */
public class i extends e {
    private static i lKb = null;

    private i() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static i dld() {
        if (lKb == null) {
            lKb = new i();
        }
        return lKb;
    }

    @Override // com.facebook.common.b.e, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (dlb()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
