package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes2.dex */
public class f extends c {
    private static f ijY = null;

    private f() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static f bUy() {
        if (ijY == null) {
            ijY = new f();
        }
        return ijY;
    }

    @Override // com.facebook.common.b.c, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (bUw()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
