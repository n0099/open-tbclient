package com.tb.airbnb.lottie.model;

import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.LruCache;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class g {
    private static final g nsA = new g();
    private final LruCache<String, com.tb.airbnb.lottie.d> hG = new LruCache<>(10485760);

    public static g dHp() {
        return nsA;
    }

    @VisibleForTesting
    g() {
    }

    @Nullable
    public com.tb.airbnb.lottie.d Rz(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.hG.get(str);
    }

    public void a(@Nullable String str, com.tb.airbnb.lottie.d dVar) {
        if (str != null) {
            this.hG.put(str, dVar);
        }
    }
}
