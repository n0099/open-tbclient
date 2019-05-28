package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes2.dex */
public class f extends c {
    private static f jRY = null;

    private f() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static f cBB() {
        if (jRY == null) {
            jRY = new f();
        }
        return jRY;
    }

    @Override // com.facebook.common.b.c, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (cBz()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
