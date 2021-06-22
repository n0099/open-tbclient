package com.ksad.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class f<T> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public T f32193a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public T f32194b;

    public static boolean b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void a(T t, T t2) {
        this.f32193a = t;
        this.f32194b = t2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            return b(pair.first, this.f32193a) && b(pair.second, this.f32194b);
        }
        return false;
    }

    public int hashCode() {
        T t = this.f32193a;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.f32194b;
        return hashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f32193a) + " " + String.valueOf(this.f32194b) + "}";
    }
}
