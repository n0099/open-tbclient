package d.a.m0.a.t1.c.d;

import android.text.TextUtils;
import com.baidu.swan.apps.SwanAppActivity;
/* loaded from: classes3.dex */
public abstract class a extends d.a.m0.a.t1.c.d.b {

    /* renamed from: d.a.m0.a.t1.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0886a implements d.a.m0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.t1.c.b.b f48549e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.h0.j.b f48550f;

        public C0886a(d.a.m0.a.t1.c.b.b bVar, d.a.m0.a.h0.j.b bVar2) {
            this.f48549e = bVar;
            this.f48550f = bVar2;
        }

        @Override // d.a.m0.a.m.a
        public void onResult(int i2) {
            if (i2 != 0) {
                d.a.m0.a.t1.c.c.a aVar = new d.a.m0.a.t1.c.c.a(this.f48549e.f48539f);
                aVar.f48543a = this.f48549e.f48538e;
                this.f48550f.a(aVar);
                return;
            }
            a.this.o(this.f48549e, this.f48550f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.m0.a.v2.e1.b<d.a.m0.a.e2.d.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f48552e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f48553f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.t1.c.b.b f48554g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.h0.j.b f48555h;

        public b(d.a.m0.a.a2.e eVar, SwanAppActivity swanAppActivity, d.a.m0.a.t1.c.b.b bVar, d.a.m0.a.h0.j.b bVar2) {
            this.f48552e = eVar;
            this.f48553f = swanAppActivity;
            this.f48554g = bVar;
            this.f48555h = bVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.m0.a.e2.d.a aVar) {
            a.this.p(this.f48553f, this.f48552e.D(), this.f48554g, aVar, this.f48555h);
        }
    }

    @Override // d.a.m0.a.t1.c.d.b
    public d.a.m0.a.t1.c.b.a f(d.a.m0.a.t1.c.b.b bVar) {
        return null;
    }

    @Override // d.a.m0.a.t1.c.d.b
    public d.a.m0.a.u.h.b j(String str, d.a.m0.a.t1.c.b.b bVar) {
        return new d.a.m0.a.u.h.b(0);
    }

    @Override // d.a.m0.a.t1.c.d.b
    public boolean k() {
        return false;
    }

    @Override // d.a.m0.a.t1.c.d.b
    public d.a.m0.a.u.h.b m(d.a.m0.a.t1.c.b.b bVar, d.a.m0.a.h0.j.b<d.a.m0.a.t1.c.c.a> bVar2) {
        if (bVar == null || TextUtils.isEmpty(bVar.f48534a)) {
            return new d.a.m0.a.u.h.b(1001, "get fun page info, provider appKey is empty");
        }
        if (bVar2 == null) {
            return new d.a.m0.a.u.h.b(1001, "get fun page info, cb is null");
        }
        d.a.m0.a.a2.e r = d.a.m0.a.a2.d.g().r();
        SwanAppActivity x = r.x();
        if (x != null && !x.isFinishing()) {
            if (!r.j().e(r)) {
                r.j().f(x, null, new C0886a(bVar, bVar2));
                return new d.a.m0.a.u.h.b(1001, "not login");
            }
            o(bVar, bVar2);
            return new d.a.m0.a.u.h.b(0);
        }
        return new d.a.m0.a.u.h.b(1001, "get fun page info, master has dead");
    }

    public final void o(d.a.m0.a.t1.c.b.b bVar, d.a.m0.a.h0.j.b<d.a.m0.a.t1.c.c.a> bVar2) {
        d.a.m0.a.t1.d.a.a("start get open data");
        d.a.m0.a.a2.e r = d.a.m0.a.a2.d.g().r();
        SwanAppActivity x = r.x();
        d.a.m0.a.e2.d.a.C(x, g(), bVar.f48534a, true, h(), new b(r, x, bVar, bVar2));
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, d.a.m0.a.t1.c.b.b bVar, d.a.m0.a.e2.d.a aVar, d.a.m0.a.h0.j.b<d.a.m0.a.t1.c.c.a> bVar2);
}
