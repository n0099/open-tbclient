package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
/* loaded from: classes3.dex */
public class ak {
    public static volatile ak a = new ak();

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f57939b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f57940c = 0;

    /* renamed from: d  reason: collision with root package name */
    public volatile PowerManager f57941d;

    public static ak a() {
        return a;
    }

    public boolean a(Context context) {
        if (this.f57940c <= 0 || SystemClock.elapsedRealtime() - this.f57940c >= 600) {
            if (this.f57941d == null && context != null) {
                synchronized (this) {
                    if (this.f57941d == null) {
                        this.f57941d = (PowerManager) context.getApplicationContext().getSystemService("power");
                    }
                }
            }
            this.f57939b = this.f57941d != null ? Build.VERSION.SDK_INT >= 20 ? this.f57941d.isInteractive() : this.f57941d.isScreenOn() : false;
            this.f57940c = SystemClock.elapsedRealtime();
            return this.f57939b;
        }
        return this.f57939b;
    }
}
