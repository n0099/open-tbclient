package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes2.dex */
public class f extends c {
    private static f jzg = null;

    private f() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static f ctC() {
        if (jzg == null) {
            jzg = new f();
        }
        return jzg;
    }

    @Override // com.facebook.common.b.c, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (ctA()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
