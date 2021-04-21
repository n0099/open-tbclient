package com.ksad.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.LruCache;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f31940a = new e();

    /* renamed from: b  reason: collision with root package name */
    public final LruCache<String, com.ksad.lottie.d> f31941b = new LruCache<>(10485760);

    public static e a() {
        return f31940a;
    }

    @Nullable
    public com.ksad.lottie.d a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.f31941b.get(str);
    }

    public void a(@Nullable String str, com.ksad.lottie.d dVar) {
        if (str == null) {
            return;
        }
        this.f31941b.put(str, dVar);
    }
}
