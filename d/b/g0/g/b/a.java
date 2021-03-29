package d.b.g0.g.b;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.b.g0.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0949a implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f47879a;

        public C0949a(d dVar) {
            this.f47879a = dVar;
        }

        @Override // d.b.g0.g.b.a.d
        public void onFail(String str) {
            this.f47879a.onFail(str);
        }

        @Override // d.b.g0.g.b.a.d
        public void onSuccess() {
            this.f47879a.onSuccess();
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements d.b.g0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f47880e;

        public b(d dVar) {
            this.f47880e = dVar;
        }

        @Override // d.b.g0.a.m.a
        public void onResult(int i) {
            if (i == 0) {
                this.f47880e.onSuccess();
            } else {
                this.f47880e.onFail("login error");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f47881a;

        /* renamed from: d.b.g0.g.b.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0950a implements d {
            public C0950a() {
            }

            @Override // d.b.g0.g.b.a.d
            public void onFail(String str) {
                c.this.f47881a.onFail(str);
            }

            @Override // d.b.g0.g.b.a.d
            public void onSuccess() {
                c.this.f47881a.onSuccess();
            }
        }

        public c(d dVar) {
            this.f47881a = dVar;
        }

        @Override // d.b.g0.g.b.a.d
        public void onFail(String str) {
            this.f47881a.onFail(str);
        }

        @Override // d.b.g0.g.b.a.d
        public void onSuccess() {
            a.b(new C0950a());
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void onFail(String str);

        void onSuccess();
    }

    public static void a(d.b.g0.a.r1.e eVar, d dVar) {
        if (eVar.z().e(eVar.n())) {
            dVar.onSuccess();
        } else {
            eVar.z().f(eVar.n(), null, new b(dVar));
        }
    }

    public static void b(d dVar) {
        d.b.g0.g.r.a.a().a(new C0949a(dVar));
    }

    public static void c(d dVar) {
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        if (O != null && O.n() != null) {
            a(O, new c(dVar));
        } else {
            dVar.onFail("SwanApp is null or SwanActivity is null");
        }
    }
}
