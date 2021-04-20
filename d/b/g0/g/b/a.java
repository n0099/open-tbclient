package d.b.g0.g.b;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.b.g0.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0961a implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f48271a;

        public C0961a(d dVar) {
            this.f48271a = dVar;
        }

        @Override // d.b.g0.g.b.a.d
        public void onFail(String str) {
            this.f48271a.onFail(str);
        }

        @Override // d.b.g0.g.b.a.d
        public void onSuccess() {
            this.f48271a.onSuccess();
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements d.b.g0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f48272e;

        public b(d dVar) {
            this.f48272e = dVar;
        }

        @Override // d.b.g0.a.m.a
        public void onResult(int i) {
            if (i == 0) {
                this.f48272e.onSuccess();
            } else {
                this.f48272e.onFail("login error");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f48273a;

        /* renamed from: d.b.g0.g.b.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0962a implements d {
            public C0962a() {
            }

            @Override // d.b.g0.g.b.a.d
            public void onFail(String str) {
                c.this.f48273a.onFail(str);
            }

            @Override // d.b.g0.g.b.a.d
            public void onSuccess() {
                c.this.f48273a.onSuccess();
            }
        }

        public c(d dVar) {
            this.f48273a = dVar;
        }

        @Override // d.b.g0.g.b.a.d
        public void onFail(String str) {
            this.f48273a.onFail(str);
        }

        @Override // d.b.g0.g.b.a.d
        public void onSuccess() {
            a.b(new C0962a());
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
        d.b.g0.g.r.a.a().a(new C0961a(dVar));
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
