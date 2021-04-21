package d.a.a.y;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
/* loaded from: classes.dex */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public final b<T> f41905a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public T f41906b;

    public c() {
        this.f41905a = new b<>();
        this.f41906b = null;
    }

    @Nullable
    public T a(b<T> bVar) {
        return this.f41906b;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final T b(float f2, float f3, T t, T t2, float f4, float f5, float f6) {
        b<T> bVar = this.f41905a;
        bVar.a(f2, f3, t, t2, f4, f5, f6);
        return a(bVar);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void c(@Nullable d.a.a.s.c.a<?, ?> aVar) {
    }

    public c(@Nullable T t) {
        this.f41905a = new b<>();
        this.f41906b = null;
        this.f41906b = t;
    }
}
