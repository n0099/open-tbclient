package d.b.h0.a.l1.c.d;

import android.text.TextUtils;
import d.b.h0.a.e0.p.o.a;
import d.b.h0.l.l.k.f;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class b {

    /* loaded from: classes2.dex */
    public class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.l1.c.b.b f45929a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.e0.n.b f45930b;

        public a(d.b.h0.a.l1.c.b.b bVar, d.b.h0.a.e0.n.b bVar2) {
            this.f45929a = bVar;
            this.f45930b = bVar2;
        }

        @Override // d.b.h0.a.e0.p.o.a.b
        public void a() {
            d.b.h0.a.l1.d.a.a("payment fun page, your pkg is latest");
        }

        @Override // d.b.h0.a.e0.p.o.a.b
        public void onError() {
            b.this.d(this.f45929a, false, this.f45930b);
        }

        @Override // d.b.h0.a.e0.p.o.a.b
        public void onSuccess() {
            b.this.d(this.f45929a, true, this.f45930b);
        }
    }

    /* renamed from: d.b.h0.a.l1.c.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0763b implements d.b.h0.a.e0.p.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.l1.c.b.b f45932a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.e0.n.b f45933b;

        public C0763b(d.b.h0.a.l1.c.b.b bVar, d.b.h0.a.e0.n.b bVar2) {
            this.f45932a = bVar;
            this.f45933b = bVar2;
        }

        @Override // d.b.h0.a.e0.p.b
        public void a(int i) {
            b.this.d(this.f45932a, false, this.f45933b);
        }

        @Override // d.b.h0.a.e0.p.b
        public void b() {
            b.this.d(this.f45932a, true, this.f45933b);
        }
    }

    public abstract d.b.h0.a.t.e.b b(JSONObject jSONObject);

    public final void c(d.b.h0.a.l1.c.b.b bVar, String str, d.b.h0.a.e0.n.b<d.b.h0.a.l1.c.c.a> bVar2) {
        d.b.h0.a.l1.d.a.a("local has not main pkg, download fun page main pkg");
        d.b.h0.l.l.k.c cVar = new d.b.h0.l.l.k.c(str, d.b.h0.a.r1.d.e().h());
        cVar.n(0);
        cVar.q(bVar.f45910c);
        cVar.d("3");
        d.b.h0.l.c.a(cVar, new d.b.h0.a.e0.p.o.a(str, new a(bVar, bVar2)));
    }

    public final void d(d.b.h0.a.l1.c.b.b bVar, boolean z, d.b.h0.a.e0.n.b<d.b.h0.a.l1.c.c.a> bVar2) {
        if (z) {
            d.b.h0.a.l1.c.b.a f2 = f(bVar);
            if (f2 != null && f2.f45907f) {
                d.b.h0.a.l1.d.a.a("payment fun page, download success, ready to jump");
                i(f2.f45904c, bVar);
                return;
            }
            d.b.h0.a.l1.d.a.a("payment fun page, download success, but not exist");
            d.b.h0.a.l1.c.c.a aVar = new d.b.h0.a.l1.c.c.a(bVar.f45913f);
            aVar.f45916a = bVar.f45912e;
            bVar2.a(aVar);
            return;
        }
        d.b.h0.a.l1.d.a.a("payment fun page, download failed");
        d.b.h0.a.l1.c.c.a aVar2 = new d.b.h0.a.l1.c.c.a(bVar.f45913f);
        aVar2.f45916a = bVar.f45912e;
        bVar2.a(aVar2);
    }

    public final void e(d.b.h0.a.l1.c.b.b bVar, d.b.h0.a.l1.c.b.a aVar, d.b.h0.a.e0.n.b<d.b.h0.a.l1.c.c.a> bVar2) {
        d.b.h0.a.l1.d.a.a("main pkg is exist, download fun page sub pkg");
        String str = aVar.f45902a;
        int i = aVar.f45905d;
        d.b.h0.l.c.d(new f(str, i, d.b.h0.a.l1.g.b.d(aVar.f45904c, aVar.f45903b), 0), new d.b.h0.a.e0.p.q.a(str, String.valueOf(i), new C0763b(bVar, bVar2)));
    }

    public abstract d.b.h0.a.l1.c.b.a f(d.b.h0.a.l1.c.b.b bVar);

    public abstract String g();

    public final boolean h(String str) {
        return TextUtils.equals(str, "develop");
    }

    public abstract d.b.h0.a.t.e.b i(String str, d.b.h0.a.l1.c.b.b bVar);

    public abstract boolean j();

    public final d.b.h0.a.t.e.b k(d.b.h0.a.l1.c.b.b bVar, d.b.h0.a.e0.n.b<d.b.h0.a.l1.c.c.a> bVar2) {
        d.b.h0.a.l1.d.a.a("open fun page start");
        if (bVar != null && bVar.a()) {
            d.b.h0.a.t.e.b b2 = b(bVar.f45914g);
            if (b2 != null) {
                d.b.h0.a.l1.d.a.a("fun page args params invalid");
                return b2;
            } else if (j()) {
                d.b.h0.a.l1.d.a.a("open payment fun page");
                d.b.h0.a.l1.c.b.a f2 = f(bVar);
                if (f2 == null) {
                    return new d.b.h0.a.t.e.b(1001, "fun page not exists");
                }
                if (!f2.f45907f) {
                    d.b.h0.a.l1.d.a.a("payment fun page, " + bVar.f45911d + " mode");
                    if (h(bVar.f45911d)) {
                        if (f2.f45906e) {
                            e(bVar, f2, bVar2);
                        } else {
                            return new d.b.h0.a.t.e.b(1001, "fun page not exists");
                        }
                    } else if (f2.f45906e) {
                        e(bVar, f2, bVar2);
                    } else {
                        c(bVar, f2.f45902a, bVar2);
                    }
                    d.b.h0.a.l1.d.a.a("open fun page end");
                    return new d.b.h0.a.t.e.b(0);
                }
                return i(f2.f45904c, bVar);
            } else {
                d.b.h0.a.l1.d.a.a("open user info or choose address fun page");
                return l(bVar, bVar2);
            }
        }
        d.b.h0.a.l1.d.a.a("params parse fail");
        return new d.b.h0.a.t.e.b(202, "params parse fail");
    }

    public abstract d.b.h0.a.t.e.b l(d.b.h0.a.l1.c.b.b bVar, d.b.h0.a.e0.n.b<d.b.h0.a.l1.c.c.a> bVar2);
}
