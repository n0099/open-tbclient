package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes6.dex */
public class i extends e {
    private static i nKo = null;

    private i() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static i dWn() {
        if (nKo == null) {
            nKo = new i();
        }
        return nKo;
    }

    @Override // com.facebook.common.b.e, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (dWl()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
