package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
/* loaded from: classes6.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    public static volatile z f34163a = new z();

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f34164b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f34165c = 0;

    /* renamed from: d  reason: collision with root package name */
    public volatile PowerManager f34166d;

    public static z a() {
        return f34163a;
    }

    public boolean a(Context context) {
        if (this.f34165c <= 0 || SystemClock.elapsedRealtime() - this.f34165c >= 600) {
            if (this.f34166d == null && context != null) {
                synchronized (this) {
                    if (this.f34166d == null) {
                        this.f34166d = (PowerManager) context.getApplicationContext().getSystemService("power");
                    }
                }
            }
            this.f34164b = this.f34166d != null ? Build.VERSION.SDK_INT >= 20 ? this.f34166d.isInteractive() : this.f34166d.isScreenOn() : false;
            this.f34165c = SystemClock.elapsedRealtime();
            return this.f34164b;
        }
        return this.f34164b;
    }
}
