package com.ksad.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import com.baidu.android.common.logging.Log;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final e f8386a = new e();

    /* renamed from: b  reason: collision with root package name */
    private final LruCache<String, com.ksad.lottie.d> f8387b = new LruCache<>(Log.FILE_LIMETE);

    @VisibleForTesting
    e() {
    }

    public static e a() {
        return f8386a;
    }

    @Nullable
    public com.ksad.lottie.d a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.f8387b.get(str);
    }

    public void a(@Nullable String str, com.ksad.lottie.d dVar) {
        if (str == null) {
            return;
        }
        this.f8387b.put(str, dVar);
    }
}
