package d.a.l0.a.h0.k;

import d.a.l0.a.l0.j;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public c f42214a = new c(d.a.l0.a.e0.f.d.b.d().getPath(), d.a.l0.a.e0.f.d.b.f41374b);

    /* loaded from: classes2.dex */
    public class a implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f42215a;

        public a(f fVar, j jVar) {
            this.f42215a = jVar;
        }

        @Override // d.a.l0.a.l0.j
        public void a(d.a.l0.a.l0.a aVar) {
            j jVar = this.f42215a;
            if (jVar != null) {
                jVar.a(aVar);
            }
        }
    }

    public d.a.l0.a.l0.a a() {
        c cVar = this.f42214a;
        if (cVar != null) {
            return cVar.d();
        }
        return null;
    }

    public void b() {
        c cVar = this.f42214a;
        if (cVar != null) {
            cVar.e();
            this.f42214a = null;
        }
    }

    public void c(j jVar) {
        c cVar = this.f42214a;
        if (cVar != null) {
            cVar.f(new a(this, jVar));
        }
    }
}
