package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
/* loaded from: classes3.dex */
public class ak {
    public static volatile ak a = new ak();

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f57894b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f57895c = 0;

    /* renamed from: d  reason: collision with root package name */
    public volatile PowerManager f57896d;

    public static ak a() {
        return a;
    }

    public boolean a(Context context) {
        if (this.f57895c <= 0 || SystemClock.elapsedRealtime() - this.f57895c >= 600) {
            if (this.f57896d == null && context != null) {
                synchronized (this) {
                    if (this.f57896d == null) {
                        this.f57896d = (PowerManager) context.getApplicationContext().getSystemService("power");
                    }
                }
            }
            this.f57894b = this.f57896d != null ? Build.VERSION.SDK_INT >= 20 ? this.f57896d.isInteractive() : this.f57896d.isScreenOn() : false;
            this.f57895c = SystemClock.elapsedRealtime();
            return this.f57894b;
        }
        return this.f57894b;
    }
}
