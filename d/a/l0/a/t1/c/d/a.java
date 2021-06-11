package d.a.l0.a.t1.c.d;

import android.text.TextUtils;
import com.baidu.swan.apps.SwanAppActivity;
/* loaded from: classes3.dex */
public abstract class a extends d.a.l0.a.t1.c.d.b {

    /* renamed from: d.a.l0.a.t1.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0883a implements d.a.l0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.t1.c.b.b f48441e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.j.b f48442f;

        public C0883a(d.a.l0.a.t1.c.b.b bVar, d.a.l0.a.h0.j.b bVar2) {
            this.f48441e = bVar;
            this.f48442f = bVar2;
        }

        @Override // d.a.l0.a.m.a
        public void onResult(int i2) {
            if (i2 != 0) {
                d.a.l0.a.t1.c.c.a aVar = new d.a.l0.a.t1.c.c.a(this.f48441e.f48431f);
                aVar.f48435a = this.f48441e.f48430e;
                this.f48442f.a(aVar);
                return;
            }
            a.this.o(this.f48441e, this.f48442f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.d.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f48444e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f48445f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.t1.c.b.b f48446g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.j.b f48447h;

        public b(d.a.l0.a.a2.e eVar, SwanAppActivity swanAppActivity, d.a.l0.a.t1.c.b.b bVar, d.a.l0.a.h0.j.b bVar2) {
            this.f48444e = eVar;
            this.f48445f = swanAppActivity;
            this.f48446g = bVar;
            this.f48447h = bVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.d.a aVar) {
            a.this.p(this.f48445f, this.f48444e.D(), this.f48446g, aVar, this.f48447h);
        }
    }

    @Override // d.a.l0.a.t1.c.d.b
    public d.a.l0.a.t1.c.b.a f(d.a.l0.a.t1.c.b.b bVar) {
        return null;
    }

    @Override // d.a.l0.a.t1.c.d.b
    public d.a.l0.a.u.h.b j(String str, d.a.l0.a.t1.c.b.b bVar) {
        return new d.a.l0.a.u.h.b(0);
    }

    @Override // d.a.l0.a.t1.c.d.b
    public boolean k() {
        return false;
    }

    @Override // d.a.l0.a.t1.c.d.b
    public d.a.l0.a.u.h.b m(d.a.l0.a.t1.c.b.b bVar, d.a.l0.a.h0.j.b<d.a.l0.a.t1.c.c.a> bVar2) {
        if (bVar == null || TextUtils.isEmpty(bVar.f48426a)) {
            return new d.a.l0.a.u.h.b(1001, "get fun page info, provider appKey is empty");
        }
        if (bVar2 == null) {
            return new d.a.l0.a.u.h.b(1001, "get fun page info, cb is null");
        }
        d.a.l0.a.a2.e r = d.a.l0.a.a2.d.g().r();
        SwanAppActivity x = r.x();
        if (x != null && !x.isFinishing()) {
            if (!r.j().e(r)) {
                r.j().f(x, null, new C0883a(bVar, bVar2));
                return new d.a.l0.a.u.h.b(1001, "not login");
            }
            o(bVar, bVar2);
            return new d.a.l0.a.u.h.b(0);
        }
        return new d.a.l0.a.u.h.b(1001, "get fun page info, master has dead");
    }

    public final void o(d.a.l0.a.t1.c.b.b bVar, d.a.l0.a.h0.j.b<d.a.l0.a.t1.c.c.a> bVar2) {
        d.a.l0.a.t1.d.a.a("start get open data");
        d.a.l0.a.a2.e r = d.a.l0.a.a2.d.g().r();
        SwanAppActivity x = r.x();
        d.a.l0.a.e2.d.a.C(x, g(), bVar.f48426a, true, h(), new b(r, x, bVar, bVar2));
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, d.a.l0.a.t1.c.b.b bVar, d.a.l0.a.e2.d.a aVar, d.a.l0.a.h0.j.b<d.a.l0.a.t1.c.c.a> bVar2);
}
