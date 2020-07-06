package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes13.dex */
public class i extends e {
    private static i mIE = null;

    private i() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static i dzi() {
        if (mIE == null) {
            mIE = new i();
        }
        return mIE;
    }

    @Override // com.facebook.common.b.e, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (dzg()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
