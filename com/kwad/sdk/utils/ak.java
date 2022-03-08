package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
/* loaded from: classes8.dex */
public class ak {
    public static volatile ak a = new ak();

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f56456b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f56457c = 0;

    /* renamed from: d  reason: collision with root package name */
    public volatile PowerManager f56458d;

    public static ak a() {
        return a;
    }

    public boolean a(Context context) {
        if (this.f56457c <= 0 || SystemClock.elapsedRealtime() - this.f56457c >= 600) {
            if (this.f56458d == null && context != null) {
                synchronized (this) {
                    if (this.f56458d == null) {
                        this.f56458d = (PowerManager) context.getApplicationContext().getSystemService("power");
                    }
                }
            }
            this.f56456b = this.f56458d != null ? Build.VERSION.SDK_INT >= 20 ? this.f56458d.isInteractive() : this.f56458d.isScreenOn() : false;
            this.f56457c = SystemClock.elapsedRealtime();
            return this.f56456b;
        }
        return this.f56456b;
    }
}
