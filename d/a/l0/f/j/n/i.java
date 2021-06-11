package d.a.l0.f.j.n;

import com.alipay.sdk.util.l;
/* loaded from: classes3.dex */
public class i implements d.a.l0.f.j.p.a {

    /* renamed from: a  reason: collision with root package name */
    public f f50606a;

    public i(f fVar) {
        this.f50606a = fVar;
    }

    @Override // d.a.l0.f.j.p.a
    public void a(d.a.l0.f.j.q.a aVar) {
        b(aVar);
    }

    public final void b(d.a.l0.f.j.q.a aVar) {
        this.f50606a.f48946d.clear();
        if (aVar != null) {
            this.f50606a.f48946d.putString("functionType", aVar.a());
            this.f50606a.f48946d.putString("resultData", aVar.b());
            this.f50606a.f48946d.putInt(l.f1987a, aVar.c());
        }
        this.f50606a.c();
    }
}
