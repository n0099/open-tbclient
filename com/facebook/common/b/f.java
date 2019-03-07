package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes2.dex */
public class f extends c {
    private static f jzB = null;

    private f() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static f ctw() {
        if (jzB == null) {
            jzB = new f();
        }
        return jzB;
    }

    @Override // com.facebook.common.b.c, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (ctu()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
