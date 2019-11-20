package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes2.dex */
public class f extends c {
    private static f kaa = null;

    private f() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static f cCG() {
        if (kaa == null) {
            kaa = new f();
        }
        return kaa;
    }

    @Override // com.facebook.common.b.c, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (cCE()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
