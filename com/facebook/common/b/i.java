package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes6.dex */
public class i extends e {
    private static i pzk = null;

    private i() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static i esE() {
        if (pzk == null) {
            pzk = new i();
        }
        return pzk;
    }

    @Override // com.facebook.common.b.e, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (esC()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
