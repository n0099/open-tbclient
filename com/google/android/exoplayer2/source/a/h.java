package com.google.android.exoplayer2.source.a;

import android.util.Log;
import com.google.android.exoplayer2.upstream.HttpDataSource;
/* loaded from: classes4.dex */
public final class h {
    public static boolean a(com.google.android.exoplayer2.b.f fVar, int i, Exception exc) {
        return a(fVar, i, exc, 60000L);
    }

    public static boolean a(com.google.android.exoplayer2.b.f fVar, int i, Exception exc, long j) {
        if (o(exc)) {
            boolean I = fVar.I(i, j);
            int i2 = ((HttpDataSource.InvalidResponseCodeException) exc).responseCode;
            if (I) {
                Log.w("ChunkedTrackBlacklist", "Blacklisted: duration=" + j + ", responseCode=" + i2 + ", format=" + fVar.KC(i));
                return I;
            }
            Log.w("ChunkedTrackBlacklist", "Blacklisting failed (cannot blacklist last enabled track): responseCode=" + i2 + ", format=" + fVar.KC(i));
            return I;
        }
        return false;
    }

    public static boolean o(Exception exc) {
        if (exc instanceof HttpDataSource.InvalidResponseCodeException) {
            int i = ((HttpDataSource.InvalidResponseCodeException) exc).responseCode;
            return i == 404 || i == 410;
        }
        return false;
    }
}
