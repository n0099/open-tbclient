package d.a.a;

import androidx.annotation.Nullable;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class l<V> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final V f41589a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final Throwable f41590b;

    public l(V v) {
        this.f41589a = v;
        this.f41590b = null;
    }

    @Nullable
    public Throwable a() {
        return this.f41590b;
    }

    @Nullable
    public V b() {
        return this.f41589a;
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
        this.f41590b = th;
        this.f41589a = null;
    }
}
