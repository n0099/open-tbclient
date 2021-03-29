package d.a.a;

import androidx.annotation.Nullable;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class k<V> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final V f41188a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final Throwable f41189b;

    public k(V v) {
        this.f41188a = v;
        this.f41189b = null;
    }

    @Nullable
    public Throwable a() {
        return this.f41189b;
    }

    @Nullable
    public V b() {
        return this.f41188a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (b() == null || !b().equals(kVar.b())) {
                if (a() == null || kVar.a() == null) {
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

    public k(Throwable th) {
        this.f41189b = th;
        this.f41188a = null;
    }
}
