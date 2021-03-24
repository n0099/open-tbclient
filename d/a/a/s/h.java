package d.a.a.s;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class h<T> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public T f41347a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public T f41348b;

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void b(T t, T t2) {
        this.f41347a = t;
        this.f41348b = t2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            return a(pair.first, this.f41347a) && a(pair.second, this.f41348b);
        }
        return false;
    }

    public int hashCode() {
        T t = this.f41347a;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.f41348b;
        return hashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f41347a) + " " + String.valueOf(this.f41348b) + "}";
    }
}
