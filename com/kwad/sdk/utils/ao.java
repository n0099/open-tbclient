package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
/* loaded from: classes10.dex */
public final class ao {
    public static volatile ao aNT = new ao();
    public volatile boolean aNU;
    public volatile long aNV = 0;
    public volatile PowerManager aNW;

    public static ao Ky() {
        return aNT;
    }

    public final boolean cs(Context context) {
        if (this.aNV > 0 && SystemClock.elapsedRealtime() - this.aNV < 600) {
            return this.aNU;
        }
        boolean z = false;
        if (this.aNW == null && context != null) {
            synchronized (this) {
                if (this.aNW == null) {
                    this.aNW = (PowerManager) context.getApplicationContext().getSystemService("power");
                }
            }
        }
        if (this.aNW != null) {
            if (Build.VERSION.SDK_INT >= 20) {
                z = this.aNW.isInteractive();
            } else {
                z = this.aNW.isScreenOn();
            }
        }
        this.aNU = z;
        this.aNV = SystemClock.elapsedRealtime();
        return this.aNU;
    }
}
