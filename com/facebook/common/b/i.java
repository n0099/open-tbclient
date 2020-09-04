package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes9.dex */
public class i extends e {
    private static i nkV = null;

    private i() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static i dOE() {
        if (nkV == null) {
            nkV = new i();
        }
        return nkV;
    }

    @Override // com.facebook.common.b.e, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (dOC()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
