package d.b.g0.a.l1.c.d;

import android.text.TextUtils;
import com.baidu.swan.apps.SwanAppActivity;
/* loaded from: classes3.dex */
public abstract class a extends d.b.g0.a.l1.c.d.b {

    /* renamed from: d.b.g0.a.l1.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0729a implements d.b.g0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.l1.c.b.b f45200e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.n.b f45201f;

        public C0729a(d.b.g0.a.l1.c.b.b bVar, d.b.g0.a.e0.n.b bVar2) {
            this.f45200e = bVar;
            this.f45201f = bVar2;
        }

        @Override // d.b.g0.a.m.a
        public void onResult(int i) {
            if (i != 0) {
                d.b.g0.a.l1.c.c.a aVar = new d.b.g0.a.l1.c.c.a(this.f45200e.f45191f);
                aVar.f45194a = this.f45200e.f45190e;
                this.f45201f.a(aVar);
                return;
            }
            a.this.n(this.f45200e, this.f45201f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.d.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f45203e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f45204f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.l1.c.b.b f45205g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.n.b f45206h;

        public b(d.b.g0.a.r1.e eVar, SwanAppActivity swanAppActivity, d.b.g0.a.l1.c.b.b bVar, d.b.g0.a.e0.n.b bVar2) {
            this.f45203e = eVar;
            this.f45204f = swanAppActivity;
            this.f45205g = bVar;
            this.f45206h = bVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.d.a aVar) {
            a.this.o(this.f45204f, this.f45203e.B(), this.f45205g, aVar, this.f45206h);
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
        if (bVar == null || TextUtils.isEmpty(bVar.f45186a)) {
            return new d.b.g0.a.t.e.b(1001, "get fun page info, provider appKey is empty");
        }
        if (bVar2 == null) {
            return new d.b.g0.a.t.e.b(1001, "get fun page info, cb is null");
        }
        d.b.g0.a.r1.e s = d.b.g0.a.r1.d.e().s();
        SwanAppActivity n = s.n();
        if (n != null && !n.isFinishing()) {
            if (!s.z().e(s)) {
                s.z().f(n, null, new C0729a(bVar, bVar2));
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
        d.b.g0.a.v1.d.a.v(n, g(), bVar.f45186a, true, new b(s, n, bVar, bVar2));
    }

    public abstract void o(SwanAppActivity swanAppActivity, String str, d.b.g0.a.l1.c.b.b bVar, d.b.g0.a.v1.d.a aVar, d.b.g0.a.e0.n.b<d.b.g0.a.l1.c.c.a> bVar2);
}
