package d.b.g0.a.l1.c.d;

import android.text.TextUtils;
import d.b.g0.a.e0.p.o.a;
import d.b.g0.l.l.k.f;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class b {

    /* loaded from: classes2.dex */
    public class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.l1.c.b.b f45600a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.n.b f45601b;

        public a(d.b.g0.a.l1.c.b.b bVar, d.b.g0.a.e0.n.b bVar2) {
            this.f45600a = bVar;
            this.f45601b = bVar2;
        }

        @Override // d.b.g0.a.e0.p.o.a.b
        public void a() {
            d.b.g0.a.l1.d.a.a("payment fun page, your pkg is latest");
        }

        @Override // d.b.g0.a.e0.p.o.a.b
        public void onError() {
            b.this.d(this.f45600a, false, this.f45601b);
        }

        @Override // d.b.g0.a.e0.p.o.a.b
        public void onSuccess() {
            b.this.d(this.f45600a, true, this.f45601b);
        }
    }

    /* renamed from: d.b.g0.a.l1.c.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0743b implements d.b.g0.a.e0.p.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.l1.c.b.b f45603a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.n.b f45604b;

        public C0743b(d.b.g0.a.l1.c.b.b bVar, d.b.g0.a.e0.n.b bVar2) {
            this.f45603a = bVar;
            this.f45604b = bVar2;
        }

        @Override // d.b.g0.a.e0.p.b
        public void a(int i) {
            b.this.d(this.f45603a, false, this.f45604b);
        }

        @Override // d.b.g0.a.e0.p.b
        public void b() {
            b.this.d(this.f45603a, true, this.f45604b);
        }
    }

    public abstract d.b.g0.a.t.e.b b(JSONObject jSONObject);

    public final void c(d.b.g0.a.l1.c.b.b bVar, String str, d.b.g0.a.e0.n.b<d.b.g0.a.l1.c.c.a> bVar2) {
        d.b.g0.a.l1.d.a.a("local has not main pkg, download fun page main pkg");
        d.b.g0.l.l.k.c cVar = new d.b.g0.l.l.k.c(str, d.b.g0.a.r1.d.e().h());
        cVar.n(0);
        cVar.q(bVar.f45581c);
        cVar.d("3");
        d.b.g0.l.c.a(cVar, new d.b.g0.a.e0.p.o.a(str, new a(bVar, bVar2)));
    }

    public final void d(d.b.g0.a.l1.c.b.b bVar, boolean z, d.b.g0.a.e0.n.b<d.b.g0.a.l1.c.c.a> bVar2) {
        if (z) {
            d.b.g0.a.l1.c.b.a f2 = f(bVar);
            if (f2 != null && f2.f45578f) {
                d.b.g0.a.l1.d.a.a("payment fun page, download success, ready to jump");
                i(f2.f45575c, bVar);
                return;
            }
            d.b.g0.a.l1.d.a.a("payment fun page, download success, but not exist");
            d.b.g0.a.l1.c.c.a aVar = new d.b.g0.a.l1.c.c.a(bVar.f45584f);
            aVar.f45587a = bVar.f45583e;
            bVar2.a(aVar);
            return;
        }
        d.b.g0.a.l1.d.a.a("payment fun page, download failed");
        d.b.g0.a.l1.c.c.a aVar2 = new d.b.g0.a.l1.c.c.a(bVar.f45584f);
        aVar2.f45587a = bVar.f45583e;
        bVar2.a(aVar2);
    }

    public final void e(d.b.g0.a.l1.c.b.b bVar, d.b.g0.a.l1.c.b.a aVar, d.b.g0.a.e0.n.b<d.b.g0.a.l1.c.c.a> bVar2) {
        d.b.g0.a.l1.d.a.a("main pkg is exist, download fun page sub pkg");
        String str = aVar.f45573a;
        int i = aVar.f45576d;
        d.b.g0.l.c.d(new f(str, i, d.b.g0.a.l1.g.b.d(aVar.f45575c, aVar.f45574b), 0), new d.b.g0.a.e0.p.q.a(str, String.valueOf(i), new C0743b(bVar, bVar2)));
    }

    public abstract d.b.g0.a.l1.c.b.a f(d.b.g0.a.l1.c.b.b bVar);

    public abstract String g();

    public final boolean h(String str) {
        return TextUtils.equals(str, "develop");
    }

    public abstract d.b.g0.a.t.e.b i(String str, d.b.g0.a.l1.c.b.b bVar);

    public abstract boolean j();

    public final d.b.g0.a.t.e.b k(d.b.g0.a.l1.c.b.b bVar, d.b.g0.a.e0.n.b<d.b.g0.a.l1.c.c.a> bVar2) {
        d.b.g0.a.l1.d.a.a("open fun page start");
        if (bVar != null && bVar.a()) {
            d.b.g0.a.t.e.b b2 = b(bVar.f45585g);
            if (b2 != null) {
                d.b.g0.a.l1.d.a.a("fun page args params invalid");
                return b2;
            } else if (j()) {
                d.b.g0.a.l1.d.a.a("open payment fun page");
                d.b.g0.a.l1.c.b.a f2 = f(bVar);
                if (f2 == null) {
                    return new d.b.g0.a.t.e.b(1001, "fun page not exists");
                }
                if (!f2.f45578f) {
                    d.b.g0.a.l1.d.a.a("payment fun page, " + bVar.f45582d + " mode");
                    if (h(bVar.f45582d)) {
                        if (f2.f45577e) {
                            e(bVar, f2, bVar2);
                        } else {
                            return new d.b.g0.a.t.e.b(1001, "fun page not exists");
                        }
                    } else if (f2.f45577e) {
                        e(bVar, f2, bVar2);
                    } else {
                        c(bVar, f2.f45573a, bVar2);
                    }
                    d.b.g0.a.l1.d.a.a("open fun page end");
                    return new d.b.g0.a.t.e.b(0);
                }
                return i(f2.f45575c, bVar);
            } else {
                d.b.g0.a.l1.d.a.a("open user info or choose address fun page");
                return l(bVar, bVar2);
            }
        }
        d.b.g0.a.l1.d.a.a("params parse fail");
        return new d.b.g0.a.t.e.b(202, "params parse fail");
    }

    public abstract d.b.g0.a.t.e.b l(d.b.g0.a.l1.c.b.b bVar, d.b.g0.a.e0.n.b<d.b.g0.a.l1.c.c.a> bVar2);
}
