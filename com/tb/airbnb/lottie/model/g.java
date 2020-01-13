package com.tb.airbnb.lottie.model;

import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.LruCache;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes5.dex */
public class g {
    private static final g npT = new g();
    private final LruCache<String, com.tb.airbnb.lottie.d> hD = new LruCache<>(10485760);

    public static g dFD() {
        return npT;
    }

    @VisibleForTesting
    g() {
    }

    @Nullable
    public com.tb.airbnb.lottie.d Rn(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.hD.get(str);
    }

    public void a(@Nullable String str, com.tb.airbnb.lottie.d dVar) {
        if (str != null) {
            this.hD.put(str, dVar);
        }
    }
}
