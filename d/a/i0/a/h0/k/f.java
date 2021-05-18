package d.a.i0.a.h0.k;

import d.a.i0.a.l0.j;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public c f42040a = new c(d.a.i0.a.e0.f.d.b.d().getPath(), d.a.i0.a.e0.f.d.b.f41200b);

    /* loaded from: classes2.dex */
    public class a implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f42041a;

        public a(f fVar, j jVar) {
            this.f42041a = jVar;
        }

        @Override // d.a.i0.a.l0.j
        public void a(d.a.i0.a.l0.a aVar) {
            j jVar = this.f42041a;
            if (jVar != null) {
                jVar.a(aVar);
            }
        }
    }

    public d.a.i0.a.l0.a a() {
        c cVar = this.f42040a;
        if (cVar != null) {
            return cVar.d();
        }
        return null;
    }

    public void b() {
        c cVar = this.f42040a;
        if (cVar != null) {
            cVar.e();
            this.f42040a = null;
        }
    }

    public void c(j jVar) {
        c cVar = this.f42040a;
        if (cVar != null) {
            cVar.f(new a(this, jVar));
        }
    }
}
