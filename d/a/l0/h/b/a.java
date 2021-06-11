package d.a.l0.h.b;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.a.l0.h.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1064a implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f50795a;

        public C1064a(d dVar) {
            this.f50795a = dVar;
        }

        @Override // d.a.l0.h.b.a.d
        public void onFail(String str) {
            this.f50795a.onFail(str);
        }

        @Override // d.a.l0.h.b.a.d
        public void onSuccess() {
            this.f50795a.onSuccess();
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements d.a.l0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f50796e;

        public b(d dVar) {
            this.f50796e = dVar;
        }

        @Override // d.a.l0.a.m.a
        public void onResult(int i2) {
            if (i2 == 0) {
                this.f50796e.onSuccess();
            } else {
                this.f50796e.onFail("login error");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f50797a;

        /* renamed from: d.a.l0.h.b.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1065a implements d {
            public C1065a() {
            }

            @Override // d.a.l0.h.b.a.d
            public void onFail(String str) {
                c.this.f50797a.onFail(str);
            }

            @Override // d.a.l0.h.b.a.d
            public void onSuccess() {
                c.this.f50797a.onSuccess();
            }
        }

        public c(d dVar) {
            this.f50797a = dVar;
        }

        @Override // d.a.l0.h.b.a.d
        public void onFail(String str) {
            this.f50797a.onFail(str);
        }

        @Override // d.a.l0.h.b.a.d
        public void onSuccess() {
            a.b(new C1065a());
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void onFail(String str);

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
        d.a.l0.h.t.a.a().a(new C1064a(dVar));
    }

    public static void c(d dVar) {
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q != null && Q.x() != null) {
            a(Q, new c(dVar));
        } else {
            dVar.onFail("SwanApp is null or SwanActivity is null");
        }
    }
}
