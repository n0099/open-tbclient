package d.a.h0.a.l1.c.d;

import android.text.TextUtils;
import com.baidu.swan.apps.SwanAppActivity;
/* loaded from: classes3.dex */
public abstract class a extends d.a.h0.a.l1.c.d.b {

    /* renamed from: d.a.h0.a.l1.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0701a implements d.a.h0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.l1.c.b.b f43258e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e0.n.b f43259f;

        public C0701a(d.a.h0.a.l1.c.b.b bVar, d.a.h0.a.e0.n.b bVar2) {
            this.f43258e = bVar;
            this.f43259f = bVar2;
        }

        @Override // d.a.h0.a.m.a
        public void onResult(int i2) {
            if (i2 != 0) {
                d.a.h0.a.l1.c.c.a aVar = new d.a.h0.a.l1.c.c.a(this.f43258e.f43248f);
                aVar.f43252a = this.f43258e.f43247e;
                this.f43259f.a(aVar);
                return;
            }
            a.this.n(this.f43258e, this.f43259f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.d.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f43261e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f43262f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.l1.c.b.b f43263g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e0.n.b f43264h;

        public b(d.a.h0.a.r1.e eVar, SwanAppActivity swanAppActivity, d.a.h0.a.l1.c.b.b bVar, d.a.h0.a.e0.n.b bVar2) {
            this.f43261e = eVar;
            this.f43262f = swanAppActivity;
            this.f43263g = bVar;
            this.f43264h = bVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.d.a aVar) {
            a.this.o(this.f43262f, this.f43261e.B(), this.f43263g, aVar, this.f43264h);
        }
    }

    @Override // d.a.h0.a.l1.c.d.b
    public d.a.h0.a.l1.c.b.a f(d.a.h0.a.l1.c.b.b bVar) {
        return null;
    }

    @Override // d.a.h0.a.l1.c.d.b
    public d.a.h0.a.t.e.b i(String str, d.a.h0.a.l1.c.b.b bVar) {
        return new d.a.h0.a.t.e.b(0);
    }

    @Override // d.a.h0.a.l1.c.d.b
    public boolean j() {
        return false;
    }

    @Override // d.a.h0.a.l1.c.d.b
    public d.a.h0.a.t.e.b l(d.a.h0.a.l1.c.b.b bVar, d.a.h0.a.e0.n.b<d.a.h0.a.l1.c.c.a> bVar2) {
        if (bVar == null || TextUtils.isEmpty(bVar.f43243a)) {
            return new d.a.h0.a.t.e.b(1001, "get fun page info, provider appKey is empty");
        }
        if (bVar2 == null) {
            return new d.a.h0.a.t.e.b(1001, "get fun page info, cb is null");
        }
        d.a.h0.a.r1.e p = d.a.h0.a.r1.d.e().p();
        SwanAppActivity v = p.v();
        if (v != null && !v.isFinishing()) {
            if (!p.i().e(p)) {
                p.i().f(v, null, new C0701a(bVar, bVar2));
                return new d.a.h0.a.t.e.b(1001, "not login");
            }
            n(bVar, bVar2);
            return new d.a.h0.a.t.e.b(0);
        }
        return new d.a.h0.a.t.e.b(1001, "get fun page info, master has dead");
    }

    public final void n(d.a.h0.a.l1.c.b.b bVar, d.a.h0.a.e0.n.b<d.a.h0.a.l1.c.c.a> bVar2) {
        d.a.h0.a.l1.d.a.a("start get open data");
        d.a.h0.a.r1.e p = d.a.h0.a.r1.d.e().p();
        SwanAppActivity v = p.v();
        d.a.h0.a.v1.d.a.v(v, g(), bVar.f43243a, true, new b(p, v, bVar, bVar2));
    }

    public abstract void o(SwanAppActivity swanAppActivity, String str, d.a.h0.a.l1.c.b.b bVar, d.a.h0.a.v1.d.a aVar, d.a.h0.a.e0.n.b<d.a.h0.a.l1.c.c.a> bVar2);
}
