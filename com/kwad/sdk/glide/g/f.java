package com.kwad.sdk.glide.g;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.SystemClock;
/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final double f10023a;

    static {
        f10023a = Build.VERSION.SDK_INT >= 17 ? 1.0d / Math.pow(10.0d, 6.0d) : 1.0d;
    }

    public static double a(long j) {
        return (a() - j) * f10023a;
    }

    @TargetApi(17)
    public static long a() {
        return Build.VERSION.SDK_INT >= 17 ? SystemClock.elapsedRealtimeNanos() : SystemClock.uptimeMillis();
    }
}
