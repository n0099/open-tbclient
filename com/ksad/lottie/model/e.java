package com.ksad.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import com.baidu.android.common.logging.Log;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final e f8089a = new e();

    /* renamed from: b  reason: collision with root package name */
    private final LruCache<String, com.ksad.lottie.d> f8090b = new LruCache<>(Log.FILE_LIMETE);

    @VisibleForTesting
    e() {
    }

    public static e a() {
        return f8089a;
    }

    @Nullable
    public com.ksad.lottie.d a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.f8090b.get(str);
    }

    public void a(@Nullable String str, com.ksad.lottie.d dVar) {
        if (str == null) {
            return;
        }
        this.f8090b.put(str, dVar);
    }
}
