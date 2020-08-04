package com.tb.airbnb.lottie.e;

import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
/* loaded from: classes5.dex */
public class c<T> {
    private final b<T> nOY;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<?, ?> nQs;
    @Nullable
    protected T value;

    public c() {
        this.nOY = new b<>();
        this.value = null;
    }

    public c(@Nullable T t) {
        this.nOY = new b<>();
        this.value = null;
        this.value = t;
    }

    @Nullable
    public T a(b<T> bVar) {
        return this.value;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final T b(float f, float f2, T t, T t2, float f3, float f4, float f5) {
        return a(this.nOY.c(f, f2, t, t2, f3, f4, f5));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void b(@Nullable com.tb.airbnb.lottie.a.b.a<?, ?> aVar) {
        this.nQs = aVar;
    }
}
