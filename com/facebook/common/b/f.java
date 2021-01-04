package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes3.dex */
public class f extends c {
    private static f psT = null;

    private f() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static f etR() {
        if (psT == null) {
            psT = new f();
        }
        return psT;
    }

    @Override // com.facebook.common.b.c, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (etP()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
