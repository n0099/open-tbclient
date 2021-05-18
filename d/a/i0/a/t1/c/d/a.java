package d.a.i0.a.t1.c.d;

import android.text.TextUtils;
import com.baidu.swan.apps.SwanAppActivity;
/* loaded from: classes3.dex */
public abstract class a extends d.a.i0.a.t1.c.d.b {

    /* renamed from: d.a.i0.a.t1.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0816a implements d.a.i0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.t1.c.b.b f44591e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.h0.j.b f44592f;

        public C0816a(d.a.i0.a.t1.c.b.b bVar, d.a.i0.a.h0.j.b bVar2) {
            this.f44591e = bVar;
            this.f44592f = bVar2;
        }

        @Override // d.a.i0.a.m.a
        public void onResult(int i2) {
            if (i2 != 0) {
                d.a.i0.a.t1.c.c.a aVar = new d.a.i0.a.t1.c.c.a(this.f44591e.f44581f);
                aVar.f44585a = this.f44591e.f44580e;
                this.f44592f.a(aVar);
                return;
            }
            a.this.o(this.f44591e, this.f44592f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.i0.a.v2.e1.b<d.a.i0.a.e2.d.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f44594e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f44595f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.t1.c.b.b f44596g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.h0.j.b f44597h;

        public b(d.a.i0.a.a2.e eVar, SwanAppActivity swanAppActivity, d.a.i0.a.t1.c.b.b bVar, d.a.i0.a.h0.j.b bVar2) {
            this.f44594e = eVar;
            this.f44595f = swanAppActivity;
            this.f44596g = bVar;
            this.f44597h = bVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.i0.a.e2.d.a aVar) {
            a.this.p(this.f44595f, this.f44594e.D(), this.f44596g, aVar, this.f44597h);
        }
    }

    @Override // d.a.i0.a.t1.c.d.b
    public d.a.i0.a.t1.c.b.a f(d.a.i0.a.t1.c.b.b bVar) {
        return null;
    }

    @Override // d.a.i0.a.t1.c.d.b
    public d.a.i0.a.u.h.b j(String str, d.a.i0.a.t1.c.b.b bVar) {
        return new d.a.i0.a.u.h.b(0);
    }

    @Override // d.a.i0.a.t1.c.d.b
    public boolean k() {
        return false;
    }

    @Override // d.a.i0.a.t1.c.d.b
    public d.a.i0.a.u.h.b m(d.a.i0.a.t1.c.b.b bVar, d.a.i0.a.h0.j.b<d.a.i0.a.t1.c.c.a> bVar2) {
        if (bVar == null || TextUtils.isEmpty(bVar.f44576a)) {
            return new d.a.i0.a.u.h.b(1001, "get fun page info, provider appKey is empty");
        }
        if (bVar2 == null) {
            return new d.a.i0.a.u.h.b(1001, "get fun page info, cb is null");
        }
        d.a.i0.a.a2.e r = d.a.i0.a.a2.d.g().r();
        SwanAppActivity x = r.x();
        if (x != null && !x.isFinishing()) {
            if (!r.j().e(r)) {
                r.j().f(x, null, new C0816a(bVar, bVar2));
                return new d.a.i0.a.u.h.b(1001, "not login");
            }
            o(bVar, bVar2);
            return new d.a.i0.a.u.h.b(0);
        }
        return new d.a.i0.a.u.h.b(1001, "get fun page info, master has dead");
    }

    public final void o(d.a.i0.a.t1.c.b.b bVar, d.a.i0.a.h0.j.b<d.a.i0.a.t1.c.c.a> bVar2) {
        d.a.i0.a.t1.d.a.a("start get open data");
        d.a.i0.a.a2.e r = d.a.i0.a.a2.d.g().r();
        SwanAppActivity x = r.x();
        d.a.i0.a.e2.d.a.C(x, g(), bVar.f44576a, true, h(), new b(r, x, bVar, bVar2));
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, d.a.i0.a.t1.c.b.b bVar, d.a.i0.a.e2.d.a aVar, d.a.i0.a.h0.j.b<d.a.i0.a.t1.c.c.a> bVar2);
}
