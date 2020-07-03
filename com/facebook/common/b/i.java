package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes13.dex */
public class i extends e {
    private static i mIA = null;

    private i() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static i dze() {
        if (mIA == null) {
            mIA = new i();
        }
        return mIA;
    }

    @Override // com.facebook.common.b.e, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (dzc()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
