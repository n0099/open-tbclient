package d.b.g0.a.l1.c.d;

import android.text.TextUtils;
import com.baidu.swan.apps.SwanAppActivity;
/* loaded from: classes2.dex */
public abstract class a extends d.b.g0.a.l1.c.d.b {

    /* renamed from: d.b.g0.a.l1.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0742a implements d.b.g0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.l1.c.b.b f45593e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.n.b f45594f;

        public C0742a(d.b.g0.a.l1.c.b.b bVar, d.b.g0.a.e0.n.b bVar2) {
            this.f45593e = bVar;
            this.f45594f = bVar2;
        }

        @Override // d.b.g0.a.m.a
        public void onResult(int i) {
            if (i != 0) {
                d.b.g0.a.l1.c.c.a aVar = new d.b.g0.a.l1.c.c.a(this.f45593e.f45584f);
                aVar.f45587a = this.f45593e.f45583e;
                this.f45594f.a(aVar);
                return;
            }
            a.this.n(this.f45593e, this.f45594f);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.d.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f45596e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f45597f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.l1.c.b.b f45598g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.n.b f45599h;

        public b(d.b.g0.a.r1.e eVar, SwanAppActivity swanAppActivity, d.b.g0.a.l1.c.b.b bVar, d.b.g0.a.e0.n.b bVar2) {
            this.f45596e = eVar;
            this.f45597f = swanAppActivity;
            this.f45598g = bVar;
            this.f45599h = bVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.d.a aVar) {
            a.this.o(this.f45597f, this.f45596e.B(), this.f45598g, aVar, this.f45599h);
        }
    }

    @Override // d.b.g0.a.l1.c.d.b
    public d.b.g0.a.l1.c.b.a f(d.b.g0.a.l1.c.b.b bVar) {
        return null;
    }

    @Override // d.b.g0.a.l1.c.d.b
    public d.b.g0.a.t.e.b i(String str, d.b.g0.a.l1.c.b.b bVar) {
        return new d.b.g0.a.t.e.b(0);
    }

    @Override // d.b.g0.a.l1.c.d.b
    public boolean j() {
        return false;
    }

    @Override // d.b.g0.a.l1.c.d.b
    public d.b.g0.a.t.e.b l(d.b.g0.a.l1.c.b.b bVar, d.b.g0.a.e0.n.b<d.b.g0.a.l1.c.c.a> bVar2) {
        if (bVar == null || TextUtils.isEmpty(bVar.f45579a)) {
            return new d.b.g0.a.t.e.b(1001, "get fun page info, provider appKey is empty");
        }
        if (bVar2 == null) {
            return new d.b.g0.a.t.e.b(1001, "get fun page info, cb is null");
        }
        d.b.g0.a.r1.e s = d.b.g0.a.r1.d.e().s();
        SwanAppActivity n = s.n();
        if (n != null && !n.isFinishing()) {
            if (!s.z().e(s)) {
                s.z().f(n, null, new C0742a(bVar, bVar2));
                return new d.b.g0.a.t.e.b(1001, "not login");
            }
            n(bVar, bVar2);
            return new d.b.g0.a.t.e.b(0);
        }
        return new d.b.g0.a.t.e.b(1001, "get fun page info, master has dead");
    }

    public final void n(d.b.g0.a.l1.c.b.b bVar, d.b.g0.a.e0.n.b<d.b.g0.a.l1.c.c.a> bVar2) {
        d.b.g0.a.l1.d.a.a("start get open data");
        d.b.g0.a.r1.e s = d.b.g0.a.r1.d.e().s();
        SwanAppActivity n = s.n();
        d.b.g0.a.v1.d.a.v(n, g(), bVar.f45579a, true, new b(s, n, bVar, bVar2));
    }

    public abstract void o(SwanAppActivity swanAppActivity, String str, d.b.g0.a.l1.c.b.b bVar, d.b.g0.a.v1.d.a aVar, d.b.g0.a.e0.n.b<d.b.g0.a.l1.c.c.a> bVar2);
}
