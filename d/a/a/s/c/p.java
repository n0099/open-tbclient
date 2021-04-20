package d.a.a.s.c;

import androidx.annotation.Nullable;
import java.util.Collections;
/* loaded from: classes.dex */
public class p<K, A> extends a<K, A> {
    public final A i;

    public p(d.a.a.y.c<A> cVar) {
        this(cVar, null);
    }

    @Override // d.a.a.s.c.a
    public float c() {
        return 1.0f;
    }

    @Override // d.a.a.s.c.a
    public A h() {
        d.a.a.y.c<A> cVar = this.f41599e;
        A a2 = this.i;
        return cVar.b(0.0f, 0.0f, a2, a2, f(), f(), f());
    }

    @Override // d.a.a.s.c.a
    public A i(d.a.a.y.a<K> aVar, float f2) {
        return h();
    }

    @Override // d.a.a.s.c.a
    public void j() {
        if (this.f41599e != null) {
            super.j();
        }
    }

    @Override // d.a.a.s.c.a
    public void l(float f2) {
        this.f41598d = f2;
    }

    public p(d.a.a.y.c<A> cVar, @Nullable A a2) {
        super(Collections.emptyList());
        m(cVar);
        this.i = a2;
    }
}
