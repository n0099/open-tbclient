package d.a.m0.h.b;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.a.m0.h.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1067a implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f50903a;

        public C1067a(d dVar) {
            this.f50903a = dVar;
        }

        @Override // d.a.m0.h.b.a.d
        public void onFail(String str) {
            this.f50903a.onFail(str);
        }

        @Override // d.a.m0.h.b.a.d
        public void onSuccess() {
            this.f50903a.onSuccess();
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements d.a.m0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f50904e;

        public b(d dVar) {
            this.f50904e = dVar;
        }

        @Override // d.a.m0.a.m.a
        public void onResult(int i2) {
            if (i2 == 0) {
                this.f50904e.onSuccess();
            } else {
                this.f50904e.onFail("login error");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f50905a;

        /* renamed from: d.a.m0.h.b.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1068a implements d {
            public C1068a() {
            }

            @Override // d.a.m0.h.b.a.d
            public void onFail(String str) {
                c.this.f50905a.onFail(str);
            }

            @Override // d.a.m0.h.b.a.d
            public void onSuccess() {
                c.this.f50905a.onSuccess();
            }
        }

        public c(d dVar) {
            this.f50905a = dVar;
        }

        @Override // d.a.m0.h.b.a.d
        public void onFail(String str) {
            this.f50905a.onFail(str);
        }

        @Override // d.a.m0.h.b.a.d
        public void onSuccess() {
            a.b(new C1068a());
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void onFail(String str);

        void onSuccess();
    }

    public static void a(d.a.m0.a.a2.e eVar, d dVar) {
        if (eVar.j().e(eVar.x())) {
            dVar.onSuccess();
        } else {
            eVar.j().f(eVar.x(), null, new b(dVar));
        }
    }

    public static void b(d dVar) {
        d.a.m0.h.t.a.a().a(new C1067a(dVar));
    }

    public static void c(d dVar) {
        d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
        if (Q != null && Q.x() != null) {
            a(Q, new c(dVar));
        } else {
            dVar.onFail("SwanApp is null or SwanActivity is null");
        }
    }
}
