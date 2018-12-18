package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes2.dex */
public class f extends c {
    private static f ifH = null;

    private f() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static f bSZ() {
        if (ifH == null) {
            ifH = new f();
        }
        return ifH;
    }

    @Override // com.facebook.common.b.c, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (bSX()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
