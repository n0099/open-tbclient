package com.tb.airbnb.lottie.model;

import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.LruCache;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class g {
    private static final g nqN = new g();
    private final LruCache<String, com.tb.airbnb.lottie.d> hH = new LruCache<>(10485760);

    public static g dGP() {
        return nqN;
    }

    @VisibleForTesting
    g() {
    }

    @Nullable
    public com.tb.airbnb.lottie.d Rz(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.hH.get(str);
    }

    public void a(@Nullable String str, com.tb.airbnb.lottie.d dVar) {
        if (str != null) {
            this.hH.put(str, dVar);
        }
    }
}
