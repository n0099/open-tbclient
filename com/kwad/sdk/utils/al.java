package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
/* loaded from: classes10.dex */
public final class al {
    public static volatile al anT = new al();
    public volatile boolean anU;
    public volatile long anV = 0;
    public volatile PowerManager anW;

    public static al zM() {
        return anT;
    }

    public final boolean aJ(Context context) {
        if (this.anV <= 0 || SystemClock.elapsedRealtime() - this.anV >= 600) {
            if (this.anW == null && context != null) {
                synchronized (this) {
                    if (this.anW == null) {
                        this.anW = (PowerManager) context.getApplicationContext().getSystemService("power");
                    }
                }
            }
            this.anU = this.anW != null ? Build.VERSION.SDK_INT >= 20 ? this.anW.isInteractive() : this.anW.isScreenOn() : false;
            this.anV = SystemClock.elapsedRealtime();
            return this.anU;
        }
        return this.anU;
    }
}
