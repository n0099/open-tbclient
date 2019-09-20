package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes2.dex */
public class f extends c {
    private static f kcI = null;

    private f() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static f cFK() {
        if (kcI == null) {
            kcI = new f();
        }
        return kcI;
    }

    @Override // com.facebook.common.b.c, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (cFI()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
