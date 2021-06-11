package d.a.l0.a.t1.c.d;

import android.text.TextUtils;
import d.a.l0.a.h0.m.o.a;
import d.a.l0.n.i.m.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class b {

    /* loaded from: classes3.dex */
    public class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.t1.c.b.b f48449a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.j.b f48450b;

        public a(d.a.l0.a.t1.c.b.b bVar, d.a.l0.a.h0.j.b bVar2) {
            this.f48449a = bVar;
            this.f48450b = bVar2;
        }

        @Override // d.a.l0.a.h0.m.o.a.b
        public void a() {
            d.a.l0.a.t1.d.a.a("payment fun page, your pkg is latest");
        }

        @Override // d.a.l0.a.h0.m.o.a.b
        public void b(d.a.l0.a.q2.a aVar) {
            b.this.d(this.f48449a, false, this.f48450b);
        }

        @Override // d.a.l0.a.h0.m.o.a.b
        public void onSuccess() {
            b.this.d(this.f48449a, true, this.f48450b);
        }
    }

    /* renamed from: d.a.l0.a.t1.c.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0884b implements d.a.l0.a.h0.m.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.t1.c.b.b f48452a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.j.b f48453b;

        public C0884b(d.a.l0.a.t1.c.b.b bVar, d.a.l0.a.h0.j.b bVar2) {
            this.f48452a = bVar;
            this.f48453b = bVar2;
        }

        @Override // d.a.l0.a.h0.m.b
        public void a() {
            b.this.d(this.f48452a, true, this.f48453b);
        }

        @Override // d.a.l0.a.h0.m.b
        public void b(int i2, d.a.l0.a.q2.a aVar) {
            b.this.d(this.f48452a, false, this.f48453b);
        }
    }

    public abstract d.a.l0.a.u.h.b b(JSONObject jSONObject);

    public final void c(d.a.l0.a.t1.c.b.b bVar, String str, d.a.l0.a.h0.j.b<d.a.l0.a.t1.c.c.a> bVar2) {
        d.a.l0.a.t1.d.a.a("local has not main pkg, download fun page main pkg");
        d.a.l0.n.i.m.c cVar = new d.a.l0.n.i.m.c(str, d.a.l0.a.a2.d.g().l());
        cVar.o(0L);
        cVar.r(bVar.f48428c);
        cVar.d("3");
        d.a.l0.n.b.b(cVar, new d.a.l0.a.h0.m.o.a(str, new a(bVar, bVar2)));
    }

    public final void d(d.a.l0.a.t1.c.b.b bVar, boolean z, d.a.l0.a.h0.j.b<d.a.l0.a.t1.c.c.a> bVar2) {
        if (z) {
            d.a.l0.a.t1.c.b.a f2 = f(bVar);
            if (f2 != null && f2.f48425f) {
                d.a.l0.a.t1.d.a.a("payment fun page, download success, ready to jump");
                j(f2.f48422c, bVar);
                return;
            }
            d.a.l0.a.t1.d.a.a("payment fun page, download success, but not exist");
            d.a.l0.a.t1.c.c.a aVar = new d.a.l0.a.t1.c.c.a(bVar.f48431f);
            aVar.f48435a = bVar.f48430e;
            bVar2.a(aVar);
            return;
        }
        d.a.l0.a.t1.d.a.a("payment fun page, download failed");
        d.a.l0.a.t1.c.c.a aVar2 = new d.a.l0.a.t1.c.c.a(bVar.f48431f);
        aVar2.f48435a = bVar.f48430e;
        bVar2.a(aVar2);
    }

    public final void e(d.a.l0.a.t1.c.b.b bVar, d.a.l0.a.t1.c.b.a aVar, d.a.l0.a.h0.j.b<d.a.l0.a.t1.c.c.a> bVar2) {
        d.a.l0.a.t1.d.a.a("main pkg is exist, download fun page sub pkg");
        String str = aVar.f48420a;
        int i2 = aVar.f48423d;
        d.a.l0.n.b.f(new f(str, i2, d.a.l0.a.t1.g.b.e(aVar.f48422c, aVar.f48421b), 0), new d.a.l0.a.h0.m.q.a(str, String.valueOf(i2), new C0884b(bVar, bVar2)));
    }

    public abstract d.a.l0.a.t1.c.b.a f(d.a.l0.a.t1.c.b.b bVar);

    public abstract String g();

    public abstract String h();

    public final boolean i(String str) {
        return TextUtils.equals(str, "develop");
    }

    public abstract d.a.l0.a.u.h.b j(String str, d.a.l0.a.t1.c.b.b bVar);

    public abstract boolean k();

    public final d.a.l0.a.u.h.b l(d.a.l0.a.t1.c.b.b bVar, d.a.l0.a.h0.j.b<d.a.l0.a.t1.c.c.a> bVar2) {
        d.a.l0.a.t1.d.a.a("open fun page start");
        if (bVar != null && bVar.a()) {
            d.a.l0.a.u.h.b b2 = b(bVar.f48432g);
            if (b2 != null) {
                d.a.l0.a.t1.d.a.a("fun page args params invalid");
                return b2;
            } else if (k()) {
                d.a.l0.a.t1.d.a.a("open payment fun page");
                d.a.l0.a.t1.c.b.a f2 = f(bVar);
                if (f2 == null) {
                    return new d.a.l0.a.u.h.b(1001, "fun page not exists");
                }
                if (!f2.f48425f) {
                    d.a.l0.a.t1.d.a.a("payment fun page, " + bVar.f48429d + " mode");
                    if (i(bVar.f48429d)) {
                        if (f2.f48424e) {
                            e(bVar, f2, bVar2);
                        } else {
                            return new d.a.l0.a.u.h.b(1001, "fun page not exists");
                        }
                    } else if (f2.f48424e) {
                        e(bVar, f2, bVar2);
                    } else {
                        c(bVar, f2.f48420a, bVar2);
                    }
                    d.a.l0.a.t1.d.a.a("open fun page end");
                    return new d.a.l0.a.u.h.b(0);
                }
                return j(f2.f48422c, bVar);
            } else {
                d.a.l0.a.t1.d.a.a("open user info or choose address fun page");
                return m(bVar, bVar2);
            }
        }
        d.a.l0.a.t1.d.a.a("params parse fail");
        return new d.a.l0.a.u.h.b(202, "params parse fail");
    }

    public abstract d.a.l0.a.u.h.b m(d.a.l0.a.t1.c.b.b bVar, d.a.l0.a.h0.j.b<d.a.l0.a.t1.c.c.a> bVar2);
}
