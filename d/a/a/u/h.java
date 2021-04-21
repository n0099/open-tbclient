package d.a.a.u;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class h<T> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public T f41746a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public T f41747b;

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void b(T t, T t2) {
        this.f41746a = t;
        this.f41747b = t2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            return a(pair.first, this.f41746a) && a(pair.second, this.f41747b);
        }
        return false;
    }

    public int hashCode() {
        T t = this.f41746a;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.f41747b;
        return hashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f41746a) + " " + String.valueOf(this.f41747b) + "}";
    }
}
