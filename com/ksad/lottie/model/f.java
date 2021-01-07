package com.ksad.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes5.dex */
public class f<T> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    T f8389a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    T f8390b;

    private static boolean b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void a(T t, T t2) {
        this.f8389a = t;
        this.f8390b = t2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            return b(pair.first, this.f8389a) && b(pair.second, this.f8390b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f8389a == null ? 0 : this.f8389a.hashCode()) ^ (this.f8390b != null ? this.f8390b.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f8389a) + " " + String.valueOf(this.f8390b) + "}";
    }
}
