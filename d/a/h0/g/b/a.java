package d.a.h0.g.b;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.a.h0.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0920a implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f46062a;

        public C0920a(d dVar) {
            this.f46062a = dVar;
        }

        @Override // d.a.h0.g.b.a.d
        public void onFail(String str) {
            this.f46062a.onFail(str);
        }

        @Override // d.a.h0.g.b.a.d
        public void onSuccess() {
            this.f46062a.onSuccess();
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements d.a.h0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f46063e;

        public b(d dVar) {
            this.f46063e = dVar;
        }

        @Override // d.a.h0.a.m.a
        public void onResult(int i2) {
            if (i2 == 0) {
                this.f46063e.onSuccess();
            } else {
                this.f46063e.onFail("login error");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f46064a;

        /* renamed from: d.a.h0.g.b.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0921a implements d {
            public C0921a() {
            }

            @Override // d.a.h0.g.b.a.d
            public void onFail(String str) {
                c.this.f46064a.onFail(str);
            }

            @Override // d.a.h0.g.b.a.d
            public void onSuccess() {
                c.this.f46064a.onSuccess();
            }
        }

        public c(d dVar) {
            this.f46064a = dVar;
        }

        @Override // d.a.h0.g.b.a.d
        public void onFail(String str) {
            this.f46064a.onFail(str);
        }

        @Override // d.a.h0.g.b.a.d
        public void onSuccess() {
            a.b(new C0921a());
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void onFail(String str);

        void onSuccess();
    }

    public static void a(d.a.h0.a.r1.e eVar, d dVar) {
        if (eVar.i().e(eVar.v())) {
            dVar.onSuccess();
        } else {
            eVar.i().f(eVar.v(), null, new b(dVar));
        }
    }

    public static void b(d dVar) {
        d.a.h0.g.r.a.a().a(new C0920a(dVar));
    }

    public static void c(d dVar) {
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        if (O != null && O.v() != null) {
            a(O, new c(dVar));
        } else {
            dVar.onFail("SwanApp is null or SwanActivity is null");
        }
    }
}
