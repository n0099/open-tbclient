package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes13.dex */
public class i extends e {
    private static i lIv = null;

    private i() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static i dkG() {
        if (lIv == null) {
            lIv = new i();
        }
        return lIv;
    }

    @Override // com.facebook.common.b.e, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (dkE()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
