package com.tb.airbnb.lottie.model;

import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.LruCache;
import com.baidu.android.common.logging.Log;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes17.dex */
public class g {
    private static final g pKJ = new g();
    private final LruCache<String, com.tb.airbnb.lottie.e> EM = new LruCache<>(Log.FILE_LIMETE);

    public static g eyL() {
        return pKJ;
    }

    @VisibleForTesting
    g() {
    }

    @Nullable
    public com.tb.airbnb.lottie.e YX(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.EM.get(str);
    }

    public void a(@Nullable String str, com.tb.airbnb.lottie.e eVar) {
        if (str != null) {
            this.EM.put(str, eVar);
        }
    }
}
