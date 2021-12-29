package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
/* loaded from: classes3.dex */
public class ak {
    public static volatile ak a = new ak();

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f60178b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f60179c = 0;

    /* renamed from: d  reason: collision with root package name */
    public volatile PowerManager f60180d;

    public static ak a() {
        return a;
    }

    public boolean a(Context context) {
        if (this.f60179c <= 0 || SystemClock.elapsedRealtime() - this.f60179c >= 600) {
            if (this.f60180d == null && context != null) {
                synchronized (this) {
                    if (this.f60180d == null) {
                        this.f60180d = (PowerManager) context.getApplicationContext().getSystemService("power");
                    }
                }
            }
            this.f60178b = this.f60180d != null ? Build.VERSION.SDK_INT >= 20 ? this.f60180d.isInteractive() : this.f60180d.isScreenOn() : false;
            this.f60179c = SystemClock.elapsedRealtime();
            return this.f60178b;
        }
        return this.f60178b;
    }
}
