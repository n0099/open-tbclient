package com.ksad.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes3.dex */
public class f<T> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    T f5398a;
    @Nullable
    T b;

    private static boolean b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void a(T t, T t2) {
        this.f5398a = t;
        this.b = t2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            return b(pair.first, this.f5398a) && b(pair.second, this.b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f5398a == null ? 0 : this.f5398a.hashCode()) ^ (this.b != null ? this.b.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f5398a) + " " + String.valueOf(this.b) + "}";
    }
}
