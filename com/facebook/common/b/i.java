package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes6.dex */
public class i extends e {
    private static i pyK = null;

    private i() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static i esw() {
        if (pyK == null) {
            pyK = new i();
        }
        return pyK;
    }

    @Override // com.facebook.common.b.e, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (esu()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
