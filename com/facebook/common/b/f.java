package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes2.dex */
public class f extends c {
    private static f iiR = null;

    private f() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static f bTQ() {
        if (iiR == null) {
            iiR = new f();
        }
        return iiR;
    }

    @Override // com.facebook.common.b.c, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (bTO()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
