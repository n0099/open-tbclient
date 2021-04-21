package d.b.h0.a.l1.c.d;

import android.text.TextUtils;
import com.baidu.swan.apps.SwanAppActivity;
/* loaded from: classes2.dex */
public abstract class a extends d.b.h0.a.l1.c.d.b {

    /* renamed from: d.b.h0.a.l1.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0762a implements d.b.h0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.l1.c.b.b f45922e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.e0.n.b f45923f;

        public C0762a(d.b.h0.a.l1.c.b.b bVar, d.b.h0.a.e0.n.b bVar2) {
            this.f45922e = bVar;
            this.f45923f = bVar2;
        }

        @Override // d.b.h0.a.m.a
        public void onResult(int i) {
            if (i != 0) {
                d.b.h0.a.l1.c.c.a aVar = new d.b.h0.a.l1.c.c.a(this.f45922e.f45913f);
                aVar.f45916a = this.f45922e.f45912e;
                this.f45923f.a(aVar);
                return;
            }
            a.this.n(this.f45922e, this.f45923f);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.h0.a.i2.u0.b<d.b.h0.a.v1.d.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f45925e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f45926f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.l1.c.b.b f45927g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.e0.n.b f45928h;

        public b(d.b.h0.a.r1.e eVar, SwanAppActivity swanAppActivity, d.b.h0.a.l1.c.b.b bVar, d.b.h0.a.e0.n.b bVar2) {
            this.f45925e = eVar;
            this.f45926f = swanAppActivity;
            this.f45927g = bVar;
            this.f45928h = bVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.h0.a.v1.d.a aVar) {
            a.this.o(this.f45926f, this.f45925e.B(), this.f45927g, aVar, this.f45928h);
        }
    }

    @Override // d.b.h0.a.l1.c.d.b
    public d.b.h0.a.l1.c.b.a f(d.b.h0.a.l1.c.b.b bVar) {
        return null;
    }

    @Override // d.b.h0.a.l1.c.d.b
    public d.b.h0.a.t.e.b i(String str, d.b.h0.a.l1.c.b.b bVar) {
        return new d.b.h0.a.t.e.b(0);
    }

    @Override // d.b.h0.a.l1.c.d.b
    public boolean j() {
        return false;
    }

    @Override // d.b.h0.a.l1.c.d.b
    public d.b.h0.a.t.e.b l(d.b.h0.a.l1.c.b.b bVar, d.b.h0.a.e0.n.b<d.b.h0.a.l1.c.c.a> bVar2) {
        if (bVar == null || TextUtils.isEmpty(bVar.f45908a)) {
            return new d.b.h0.a.t.e.b(1001, "get fun page info, provider appKey is empty");
        }
        if (bVar2 == null) {
            return new d.b.h0.a.t.e.b(1001, "get fun page info, cb is null");
        }
        d.b.h0.a.r1.e s = d.b.h0.a.r1.d.e().s();
        SwanAppActivity n = s.n();
        if (n != null && !n.isFinishing()) {
            if (!s.z().e(s)) {
                s.z().f(n, null, new C0762a(bVar, bVar2));
                return new d.b.h0.a.t.e.b(1001, "not login");
            }
            n(bVar, bVar2);
            return new d.b.h0.a.t.e.b(0);
        }
        return new d.b.h0.a.t.e.b(1001, "get fun page info, master has dead");
    }

    public final void n(d.b.h0.a.l1.c.b.b bVar, d.b.h0.a.e0.n.b<d.b.h0.a.l1.c.c.a> bVar2) {
        d.b.h0.a.l1.d.a.a("start get open data");
        d.b.h0.a.r1.e s = d.b.h0.a.r1.d.e().s();
        SwanAppActivity n = s.n();
        d.b.h0.a.v1.d.a.v(n, g(), bVar.f45908a, true, new b(s, n, bVar, bVar2));
    }

    public abstract void o(SwanAppActivity swanAppActivity, String str, d.b.h0.a.l1.c.b.b bVar, d.b.h0.a.v1.d.a aVar, d.b.h0.a.e0.n.b<d.b.h0.a.l1.c.c.a> bVar2);
}
