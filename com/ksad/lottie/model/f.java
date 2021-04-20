package com.ksad.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class f<T> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public T f31847a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public T f31848b;

    public static boolean b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void a(T t, T t2) {
        this.f31847a = t;
        this.f31848b = t2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            return b(pair.first, this.f31847a) && b(pair.second, this.f31848b);
        }
        return false;
    }

    public int hashCode() {
        T t = this.f31847a;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.f31848b;
        return hashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f31847a) + " " + String.valueOf(this.f31848b) + "}";
    }
}
