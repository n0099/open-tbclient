package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
/* loaded from: classes6.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    public static volatile z f34092a = new z();

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f34093b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f34094c = 0;

    /* renamed from: d  reason: collision with root package name */
    public volatile PowerManager f34095d;

    public static z a() {
        return f34092a;
    }

    public boolean a(Context context) {
        if (this.f34094c <= 0 || SystemClock.elapsedRealtime() - this.f34094c >= 600) {
            if (this.f34095d == null && context != null) {
                synchronized (this) {
                    if (this.f34095d == null) {
                        this.f34095d = (PowerManager) context.getApplicationContext().getSystemService("power");
                    }
                }
            }
            this.f34093b = this.f34095d != null ? Build.VERSION.SDK_INT >= 20 ? this.f34095d.isInteractive() : this.f34095d.isScreenOn() : false;
            this.f34094c = SystemClock.elapsedRealtime();
            return this.f34093b;
        }
        return this.f34093b;
    }
}
