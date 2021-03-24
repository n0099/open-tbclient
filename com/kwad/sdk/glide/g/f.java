package com.kwad.sdk.glide.g;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.SystemClock;
/* loaded from: classes6.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final double f35219a;

    static {
        f35219a = Build.VERSION.SDK_INT >= 17 ? 1.0d / Math.pow(10.0d, 6.0d) : 1.0d;
    }

    public static double a(long j) {
        double a2 = a() - j;
        double d2 = f35219a;
        Double.isNaN(a2);
        return a2 * d2;
    }

    @TargetApi(17)
    public static long a() {
        return Build.VERSION.SDK_INT >= 17 ? SystemClock.elapsedRealtimeNanos() : SystemClock.uptimeMillis();
    }
}
