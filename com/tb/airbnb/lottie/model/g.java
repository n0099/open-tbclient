package com.tb.airbnb.lottie.model;

import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.LruCache;
import com.baidu.android.common.logging.Log;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes7.dex */
public class g {
    private static final g oiX = new g();
    private final LruCache<String, com.tb.airbnb.lottie.d> Eu = new LruCache<>(Log.FILE_LIMETE);

    public static g ede() {
        return oiX;
    }

    @VisibleForTesting
    g() {
    }

    @Nullable
    public com.tb.airbnb.lottie.d VF(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.Eu.get(str);
    }

    public void a(@Nullable String str, com.tb.airbnb.lottie.d dVar) {
        if (str != null) {
            this.Eu.put(str, dVar);
        }
    }
}
