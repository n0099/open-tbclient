package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
/* loaded from: classes6.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    public static volatile z f34918a = new z();

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f34919b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f34920c = 0;

    /* renamed from: d  reason: collision with root package name */
    public volatile PowerManager f34921d;

    public static z a() {
        return f34918a;
    }

    public boolean a(Context context) {
        if (this.f34920c <= 0 || SystemClock.elapsedRealtime() - this.f34920c >= 600) {
            if (this.f34921d == null && context != null) {
                synchronized (this) {
                    if (this.f34921d == null) {
                        this.f34921d = (PowerManager) context.getApplicationContext().getSystemService("power");
                    }
                }
            }
            this.f34919b = this.f34921d != null ? Build.VERSION.SDK_INT >= 20 ? this.f34921d.isInteractive() : this.f34921d.isScreenOn() : false;
            this.f34920c = SystemClock.elapsedRealtime();
            return this.f34919b;
        }
        return this.f34919b;
    }
}
