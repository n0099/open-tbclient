package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes12.dex */
public class i extends e {
    private static i oME = null;

    private i() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static i ejY() {
        if (oME == null) {
            oME = new i();
        }
        return oME;
    }

    @Override // com.facebook.common.b.e, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (ejW()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
