package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
/* loaded from: classes7.dex */
public class ak {
    public static volatile ak a = new ak();

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f41347b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f41348c = 0;

    /* renamed from: d  reason: collision with root package name */
    public volatile PowerManager f41349d;

    public static ak a() {
        return a;
    }

    public boolean a(Context context) {
        if (this.f41348c <= 0 || SystemClock.elapsedRealtime() - this.f41348c >= 600) {
            if (this.f41349d == null && context != null) {
                synchronized (this) {
                    if (this.f41349d == null) {
                        this.f41349d = (PowerManager) context.getApplicationContext().getSystemService("power");
                    }
                }
            }
            this.f41347b = this.f41349d != null ? Build.VERSION.SDK_INT >= 20 ? this.f41349d.isInteractive() : this.f41349d.isScreenOn() : false;
            this.f41348c = SystemClock.elapsedRealtime();
            return this.f41347b;
        }
        return this.f41347b;
    }
}
