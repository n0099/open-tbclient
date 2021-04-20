package d.a.a;

import androidx.annotation.Nullable;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class l<V> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final V f41494a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final Throwable f41495b;

    public l(V v) {
        this.f41494a = v;
        this.f41495b = null;
    }

    @Nullable
    public Throwable a() {
        return this.f41495b;
    }

    @Nullable
    public V b() {
        return this.f41494a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (b() == null || !b().equals(lVar.b())) {
                if (a() == null || lVar.a() == null) {
                    return false;
                }
                return a().toString().equals(a().toString());
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{b(), a()});
    }

    public l(Throwable th) {
        this.f41495b = th;
        this.f41494a = null;
    }
}
