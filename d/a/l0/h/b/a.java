package d.a.l0.h.b;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.a.l0.h.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1008a implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f47121a;

        public C1008a(d dVar) {
            this.f47121a = dVar;
        }

        @Override // d.a.l0.h.b.a.d
        public void a(String str) {
            this.f47121a.a(str);
        }

        @Override // d.a.l0.h.b.a.d
        public void onSuccess() {
            this.f47121a.onSuccess();
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements d.a.l0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f47122e;

        public b(d dVar) {
            this.f47122e = dVar;
        }

        @Override // d.a.l0.a.m.a
        public void onResult(int i2) {
            if (i2 == 0) {
                this.f47122e.onSuccess();
            } else {
                this.f47122e.a("login error");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f47123a;

        /* renamed from: d.a.l0.h.b.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1009a implements d {
            public C1009a() {
            }

            @Override // d.a.l0.h.b.a.d
            public void a(String str) {
                c.this.f47123a.a(str);
            }

            @Override // d.a.l0.h.b.a.d
            public void onSuccess() {
                c.this.f47123a.onSuccess();
            }
        }

        public c(d dVar) {
            this.f47123a = dVar;
        }

        @Override // d.a.l0.h.b.a.d
        public void a(String str) {
            this.f47123a.a(str);
        }

        @Override // d.a.l0.h.b.a.d
        public void onSuccess() {
            a.b(new C1009a());
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(String str);

        void onSuccess();
    }

    public static void a(d.a.l0.a.a2.e eVar, d dVar) {
        if (eVar.j().e(eVar.x())) {
            dVar.onSuccess();
        } else {
            eVar.j().f(eVar.x(), null, new b(dVar));
        }
    }

    public static void b(d dVar) {
        d.a.l0.h.t.a.a().a(new C1008a(dVar));
    }

    public static void c(d dVar) {
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q != null && Q.x() != null) {
            a(Q, new c(dVar));
        } else {
            dVar.a("SwanApp is null or SwanActivity is null");
        }
    }
}
