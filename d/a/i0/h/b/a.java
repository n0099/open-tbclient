package d.a.i0.h.b;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.a.i0.h.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0997a implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f46945a;

        public C0997a(d dVar) {
            this.f46945a = dVar;
        }

        @Override // d.a.i0.h.b.a.d
        public void a(String str) {
            this.f46945a.a(str);
        }

        @Override // d.a.i0.h.b.a.d
        public void onSuccess() {
            this.f46945a.onSuccess();
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements d.a.i0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f46946e;

        public b(d dVar) {
            this.f46946e = dVar;
        }

        @Override // d.a.i0.a.m.a
        public void onResult(int i2) {
            if (i2 == 0) {
                this.f46946e.onSuccess();
            } else {
                this.f46946e.a("login error");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f46947a;

        /* renamed from: d.a.i0.h.b.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0998a implements d {
            public C0998a() {
            }

            @Override // d.a.i0.h.b.a.d
            public void a(String str) {
                c.this.f46947a.a(str);
            }

            @Override // d.a.i0.h.b.a.d
            public void onSuccess() {
                c.this.f46947a.onSuccess();
            }
        }

        public c(d dVar) {
            this.f46947a = dVar;
        }

        @Override // d.a.i0.h.b.a.d
        public void a(String str) {
            this.f46947a.a(str);
        }

        @Override // d.a.i0.h.b.a.d
        public void onSuccess() {
            a.b(new C0998a());
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(String str);

        void onSuccess();
    }

    public static void a(d.a.i0.a.a2.e eVar, d dVar) {
        if (eVar.j().e(eVar.x())) {
            dVar.onSuccess();
        } else {
            eVar.j().f(eVar.x(), null, new b(dVar));
        }
    }

    public static void b(d dVar) {
        d.a.i0.h.t.a.a().a(new C0997a(dVar));
    }

    public static void c(d dVar) {
        d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
        if (Q != null && Q.x() != null) {
            a(Q, new c(dVar));
        } else {
            dVar.a("SwanApp is null or SwanActivity is null");
        }
    }
}
