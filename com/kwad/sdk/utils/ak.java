package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
/* loaded from: classes4.dex */
public class ak {
    public static volatile ak a = new ak();

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f58106b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f58107c = 0;

    /* renamed from: d  reason: collision with root package name */
    public volatile PowerManager f58108d;

    public static ak a() {
        return a;
    }

    public boolean a(Context context) {
        if (this.f58107c <= 0 || SystemClock.elapsedRealtime() - this.f58107c >= 600) {
            if (this.f58108d == null && context != null) {
                synchronized (this) {
                    if (this.f58108d == null) {
                        this.f58108d = (PowerManager) context.getApplicationContext().getSystemService("power");
                    }
                }
            }
            this.f58106b = this.f58108d != null ? Build.VERSION.SDK_INT >= 20 ? this.f58108d.isInteractive() : this.f58108d.isScreenOn() : false;
            this.f58107c = SystemClock.elapsedRealtime();
            return this.f58106b;
        }
        return this.f58106b;
    }
}
