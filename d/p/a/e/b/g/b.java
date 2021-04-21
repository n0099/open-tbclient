package d.p.a.e.b.g;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final Context f68104a;

    /* renamed from: b  reason: collision with root package name */
    public j f68105b;

    /* renamed from: c  reason: collision with root package name */
    public k f68106c;

    /* renamed from: d  reason: collision with root package name */
    public i f68107d;

    /* renamed from: e  reason: collision with root package name */
    public d.p.a.e.b.f.i f68108e;

    /* renamed from: f  reason: collision with root package name */
    public d.p.a.e.b.o.a f68109f;

    /* renamed from: g  reason: collision with root package name */
    public d.p.a.e.b.o.j f68110g;

    /* renamed from: h  reason: collision with root package name */
    public d.p.a.e.b.o.h f68111h;
    public l i;
    public h j;
    public p k;
    public d.p.a.e.b.e.b l;
    public d.p.a.e.b.f.e n;
    public ExecutorService o;
    public ExecutorService p;
    public ExecutorService q;
    public ExecutorService r;
    public ExecutorService s;
    public ExecutorService t;
    public ExecutorService u;
    public ExecutorService v;
    public int w;
    public int x;
    public boolean y;
    public List<d.p.a.e.b.f.p> m = new ArrayList();
    public boolean z = true;
    public int A = 1056964607;

    public b(Context context) {
        this.f68104a = context;
    }

    public p A() {
        return this.k;
    }

    public d.p.a.e.b.f.i B() {
        return this.f68108e;
    }

    public ExecutorService C() {
        return this.v;
    }

    public int D() {
        return this.x;
    }

    public b E(d.p.a.e.b.o.a aVar) {
        this.f68109f = aVar;
        return this;
    }

    public boolean F() {
        return this.y;
    }

    public boolean G() {
        return this.z;
    }

    public b H(d.p.a.e.b.f.i iVar) {
        this.f68108e = iVar;
        return this;
    }

    public b a(d.p.a.e.b.f.p pVar) {
        synchronized (this.m) {
            if (pVar != null) {
                if (!this.m.contains(pVar)) {
                    this.m.add(pVar);
                    return this;
                }
            }
            return this;
        }
    }

    public a b() {
        return new a(this);
    }

    public b c(h hVar) {
        this.j = hVar;
        return this;
    }

    public b d(int i) {
        this.A = i;
        return this;
    }

    public b e(d.p.a.e.b.f.e eVar) {
        this.n = eVar;
        return this;
    }

    public ExecutorService f() {
        return this.o;
    }

    public h g() {
        return this.j;
    }

    public i h() {
        return this.f68107d;
    }

    public ExecutorService i() {
        return this.u;
    }

    public Context j() {
        return this.f68104a;
    }

    public ExecutorService k() {
        return this.t;
    }

    public j l() {
        return this.f68105b;
    }

    public List<d.p.a.e.b.f.p> m() {
        return this.m;
    }

    public d.p.a.e.b.o.h n() {
        return this.f68111h;
    }

    public int o() {
        return this.A;
    }

    public l p() {
        return this.i;
    }

    public d.p.a.e.b.e.b q() {
        return this.l;
    }

    public d.p.a.e.b.f.e r() {
        return this.n;
    }

    public d.p.a.e.b.o.j s() {
        return this.f68110g;
    }

    public d.p.a.e.b.o.a t() {
        return this.f68109f;
    }

    public ExecutorService u() {
        return this.p;
    }

    public k v() {
        return this.f68106c;
    }

    public int w() {
        return this.w;
    }

    public ExecutorService x() {
        return this.s;
    }

    public ExecutorService y() {
        return this.q;
    }

    public ExecutorService z() {
        return this.r;
    }
}
