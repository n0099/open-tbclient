package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
/* loaded from: classes5.dex */
public class ak {
    public static volatile ak a = new ak();
    public volatile boolean b;
    public volatile long c = 0;
    public volatile PowerManager d;

    public static ak a() {
        return a;
    }

    public boolean a(Context context) {
        if (this.c <= 0 || SystemClock.elapsedRealtime() - this.c >= 600) {
            if (this.d == null && context != null) {
                synchronized (this) {
                    if (this.d == null) {
                        this.d = (PowerManager) context.getApplicationContext().getSystemService("power");
                    }
                }
            }
            this.b = this.d != null ? Build.VERSION.SDK_INT >= 20 ? this.d.isInteractive() : this.d.isScreenOn() : false;
            this.c = SystemClock.elapsedRealtime();
            return this.b;
        }
        return this.b;
    }
}
