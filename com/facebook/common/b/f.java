package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes2.dex */
public class f extends c {
    private static f jzM = null;

    private f() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static f ctJ() {
        if (jzM == null) {
            jzM = new f();
        }
        return jzM;
    }

    @Override // com.facebook.common.b.c, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (ctH()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
