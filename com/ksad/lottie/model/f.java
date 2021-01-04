package com.ksad.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes5.dex */
public class f<T> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    T f8388a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    T f8389b;

    private static boolean b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void a(T t, T t2) {
        this.f8388a = t;
        this.f8389b = t2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            return b(pair.first, this.f8388a) && b(pair.second, this.f8389b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f8388a == null ? 0 : this.f8388a.hashCode()) ^ (this.f8389b != null ? this.f8389b.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f8388a) + " " + String.valueOf(this.f8389b) + "}";
    }
}
