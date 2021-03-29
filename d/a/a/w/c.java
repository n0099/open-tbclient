package d.a.a.w;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
/* loaded from: classes.dex */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public final b<T> f41460a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public T f41461b;

    public c() {
        this.f41460a = new b<>();
        this.f41461b = null;
    }

    @Nullable
    public T a(b<T> bVar) {
        return this.f41461b;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final T b(float f2, float f3, T t, T t2, float f4, float f5, float f6) {
        b<T> bVar = this.f41460a;
        bVar.a(f2, f3, t, t2, f4, f5, f6);
        return a(bVar);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void c(@Nullable d.a.a.q.b.a<?, ?> aVar) {
    }

    public c(@Nullable T t) {
        this.f41460a = new b<>();
        this.f41461b = null;
        this.f41461b = t;
    }
}
