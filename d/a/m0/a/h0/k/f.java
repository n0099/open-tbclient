package d.a.m0.a.h0.k;

import d.a.m0.a.l0.j;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public c f45998a = new c(d.a.m0.a.e0.f.d.b.d().getPath(), d.a.m0.a.e0.f.d.b.f45158b);

    /* loaded from: classes3.dex */
    public class a implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f45999a;

        public a(f fVar, j jVar) {
            this.f45999a = jVar;
        }

        @Override // d.a.m0.a.l0.j
        public void a(d.a.m0.a.l0.a aVar) {
            j jVar = this.f45999a;
            if (jVar != null) {
                jVar.a(aVar);
            }
        }
    }

    public d.a.m0.a.l0.a a() {
        c cVar = this.f45998a;
        if (cVar != null) {
            return cVar.d();
        }
        return null;
    }

    public void b() {
        c cVar = this.f45998a;
        if (cVar != null) {
            cVar.e();
            this.f45998a = null;
        }
    }

    public void c(j jVar) {
        c cVar = this.f45998a;
        if (cVar != null) {
            cVar.f(new a(this, jVar));
        }
    }
}
