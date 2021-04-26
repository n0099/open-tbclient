package d.a.h0.a.l1.c.d;

import android.text.TextUtils;
import d.a.h0.a.e0.p.o.a;
import d.a.h0.l.l.k.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class b {

    /* loaded from: classes3.dex */
    public class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.l1.c.b.b f43266a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e0.n.b f43267b;

        public a(d.a.h0.a.l1.c.b.b bVar, d.a.h0.a.e0.n.b bVar2) {
            this.f43266a = bVar;
            this.f43267b = bVar2;
        }

        @Override // d.a.h0.a.e0.p.o.a.b
        public void a() {
            d.a.h0.a.l1.d.a.a("payment fun page, your pkg is latest");
        }

        @Override // d.a.h0.a.e0.p.o.a.b
        public void onError() {
            b.this.d(this.f43266a, false, this.f43267b);
        }

        @Override // d.a.h0.a.e0.p.o.a.b
        public void onSuccess() {
            b.this.d(this.f43266a, true, this.f43267b);
        }
    }

    /* renamed from: d.a.h0.a.l1.c.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0702b implements d.a.h0.a.e0.p.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.l1.c.b.b f43269a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e0.n.b f43270b;

        public C0702b(d.a.h0.a.l1.c.b.b bVar, d.a.h0.a.e0.n.b bVar2) {
            this.f43269a = bVar;
            this.f43270b = bVar2;
        }

        @Override // d.a.h0.a.e0.p.b
        public void a(int i2) {
            b.this.d(this.f43269a, false, this.f43270b);
        }

        @Override // d.a.h0.a.e0.p.b
        public void b() {
            b.this.d(this.f43269a, true, this.f43270b);
        }
    }

    public abstract d.a.h0.a.t.e.b b(JSONObject jSONObject);

    public final void c(d.a.h0.a.l1.c.b.b bVar, String str, d.a.h0.a.e0.n.b<d.a.h0.a.l1.c.c.a> bVar2) {
        d.a.h0.a.l1.d.a.a("local has not main pkg, download fun page main pkg");
        d.a.h0.l.l.k.c cVar = new d.a.h0.l.l.k.c(str, d.a.h0.a.r1.d.e().j());
        cVar.n(0);
        cVar.q(bVar.f43245c);
        cVar.d("3");
        d.a.h0.l.c.a(cVar, new d.a.h0.a.e0.p.o.a(str, new a(bVar, bVar2)));
    }

    public final void d(d.a.h0.a.l1.c.b.b bVar, boolean z, d.a.h0.a.e0.n.b<d.a.h0.a.l1.c.c.a> bVar2) {
        if (z) {
            d.a.h0.a.l1.c.b.a f2 = f(bVar);
            if (f2 != null && f2.f43242f) {
                d.a.h0.a.l1.d.a.a("payment fun page, download success, ready to jump");
                i(f2.f43239c, bVar);
                return;
            }
            d.a.h0.a.l1.d.a.a("payment fun page, download success, but not exist");
            d.a.h0.a.l1.c.c.a aVar = new d.a.h0.a.l1.c.c.a(bVar.f43248f);
            aVar.f43252a = bVar.f43247e;
            bVar2.a(aVar);
            return;
        }
        d.a.h0.a.l1.d.a.a("payment fun page, download failed");
        d.a.h0.a.l1.c.c.a aVar2 = new d.a.h0.a.l1.c.c.a(bVar.f43248f);
        aVar2.f43252a = bVar.f43247e;
        bVar2.a(aVar2);
    }

    public final void e(d.a.h0.a.l1.c.b.b bVar, d.a.h0.a.l1.c.b.a aVar, d.a.h0.a.e0.n.b<d.a.h0.a.l1.c.c.a> bVar2) {
        d.a.h0.a.l1.d.a.a("main pkg is exist, download fun page sub pkg");
        String str = aVar.f43237a;
        int i2 = aVar.f43240d;
        d.a.h0.l.c.d(new f(str, i2, d.a.h0.a.l1.g.b.d(aVar.f43239c, aVar.f43238b), 0), new d.a.h0.a.e0.p.q.a(str, String.valueOf(i2), new C0702b(bVar, bVar2)));
    }

    public abstract d.a.h0.a.l1.c.b.a f(d.a.h0.a.l1.c.b.b bVar);

    public abstract String g();

    public final boolean h(String str) {
        return TextUtils.equals(str, "develop");
    }

    public abstract d.a.h0.a.t.e.b i(String str, d.a.h0.a.l1.c.b.b bVar);

    public abstract boolean j();

    public final d.a.h0.a.t.e.b k(d.a.h0.a.l1.c.b.b bVar, d.a.h0.a.e0.n.b<d.a.h0.a.l1.c.c.a> bVar2) {
        d.a.h0.a.l1.d.a.a("open fun page start");
        if (bVar != null && bVar.a()) {
            d.a.h0.a.t.e.b b2 = b(bVar.f43249g);
            if (b2 != null) {
                d.a.h0.a.l1.d.a.a("fun page args params invalid");
                return b2;
            } else if (j()) {
                d.a.h0.a.l1.d.a.a("open payment fun page");
                d.a.h0.a.l1.c.b.a f2 = f(bVar);
                if (f2 == null) {
                    return new d.a.h0.a.t.e.b(1001, "fun page not exists");
                }
                if (!f2.f43242f) {
                    d.a.h0.a.l1.d.a.a("payment fun page, " + bVar.f43246d + " mode");
                    if (h(bVar.f43246d)) {
                        if (f2.f43241e) {
                            e(bVar, f2, bVar2);
                        } else {
                            return new d.a.h0.a.t.e.b(1001, "fun page not exists");
                        }
                    } else if (f2.f43241e) {
                        e(bVar, f2, bVar2);
                    } else {
                        c(bVar, f2.f43237a, bVar2);
                    }
                    d.a.h0.a.l1.d.a.a("open fun page end");
                    return new d.a.h0.a.t.e.b(0);
                }
                return i(f2.f43239c, bVar);
            } else {
                d.a.h0.a.l1.d.a.a("open user info or choose address fun page");
                return l(bVar, bVar2);
            }
        }
        d.a.h0.a.l1.d.a.a("params parse fail");
        return new d.a.h0.a.t.e.b(202, "params parse fail");
    }

    public abstract d.a.h0.a.t.e.b l(d.a.h0.a.l1.c.b.b bVar, d.a.h0.a.e0.n.b<d.a.h0.a.l1.c.c.a> bVar2);
}
