package com.facebook.common.b;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes12.dex */
public class i extends e {
    private static i mQG = null;

    private i() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static i dCu() {
        if (mQG == null) {
            mQG = new i();
        }
        return mQG;
    }

    @Override // com.facebook.common.b.e, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (dCs()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
