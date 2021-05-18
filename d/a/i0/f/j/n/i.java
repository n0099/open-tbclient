package d.a.i0.f.j.n;

import com.alipay.sdk.util.l;
/* loaded from: classes3.dex */
public class i implements d.a.i0.f.j.p.a {

    /* renamed from: a  reason: collision with root package name */
    public f f46756a;

    public i(f fVar) {
        this.f46756a = fVar;
    }

    @Override // d.a.i0.f.j.p.a
    public void a(d.a.i0.f.j.q.a aVar) {
        b(aVar);
    }

    public final void b(d.a.i0.f.j.q.a aVar) {
        this.f46756a.f45096d.clear();
        if (aVar != null) {
            this.f46756a.f45096d.putString("functionType", aVar.a());
            this.f46756a.f45096d.putString("resultData", aVar.b());
            this.f46756a.f45096d.putInt(l.f1974a, aVar.c());
        }
        this.f46756a.c();
    }
}
