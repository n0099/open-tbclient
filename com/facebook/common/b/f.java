package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes2.dex */
public class f extends c {
    private static f hYu = null;

    private f() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static f bQU() {
        if (hYu == null) {
            hYu = new f();
        }
        return hYu;
    }

    @Override // com.facebook.common.b.c, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (bQS()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
