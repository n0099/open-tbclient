package d.a.l0.a.c2;

import com.baidu.pyramid.annotation.Service;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.c2.f.g;
import d.a.l0.a.c2.f.w;
import d.a.l0.a.k;
import d.a.l0.a.p0.f.d.f;
import d.a.l0.a.p0.f.d.h;
import d.a.l0.a.p0.f.d.i;
import d.a.l0.a.p0.f.d.j;
import java.util.List;
@Service
/* loaded from: classes3.dex */
public class d extends e {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f40947b = k.f43199a;

    @Override // d.a.l0.a.c2.e
    public void a() {
        List<a0> b2;
        List<a0> a2;
        this.f40948a.clear();
        b(new d.a.l0.a.f1.a(this));
        b(new d.a.l0.a.e0.f.e.a(this));
        b(new d.a.l0.a.e0.f.f.a(this));
        b(new d.a.l0.a.e0.f.d.a(this));
        b(new w(this));
        b(new g(this));
        b(new d.a.l0.a.c2.f.n0.a(this));
        b(new d.a.l0.a.p0.f.d.a(this));
        b(new h(this));
        b(new d.a.l0.a.p0.f.d.b(this));
        b(new d.a.l0.a.p0.f.d.e(this));
        b(new f(this));
        b(new d.a.l0.a.p0.f.d.d(this));
        b(new i(this));
        b(new d.a.l0.a.p0.f.d.c(this));
        b(new d.a.l0.a.p0.f.d.g(this));
        d.a.l0.a.p.b.a.b d2 = d.a.l0.a.c1.b.d();
        if (d2 != null && (a2 = d2.a(this)) != null && !a2.isEmpty()) {
            for (a0 a0Var : a2) {
                b(a0Var);
            }
        }
        if (f40947b) {
            b(new j(this));
            b(new d.a.l0.a.c2.f.a(this));
            if (d2 == null || (b2 = d2.b(this)) == null || b2.isEmpty()) {
                return;
            }
            for (a0 a0Var2 : b2) {
                b(a0Var2);
            }
        }
    }
}
