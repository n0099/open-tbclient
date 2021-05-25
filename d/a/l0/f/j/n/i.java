package d.a.l0.f.j.n;

import com.alipay.sdk.util.l;
/* loaded from: classes3.dex */
public class i implements d.a.l0.f.j.p.a {

    /* renamed from: a  reason: collision with root package name */
    public f f46932a;

    public i(f fVar) {
        this.f46932a = fVar;
    }

    @Override // d.a.l0.f.j.p.a
    public void a(d.a.l0.f.j.q.a aVar) {
        b(aVar);
    }

    public final void b(d.a.l0.f.j.q.a aVar) {
        this.f46932a.f45272d.clear();
        if (aVar != null) {
            this.f46932a.f45272d.putString("functionType", aVar.a());
            this.f46932a.f45272d.putString("resultData", aVar.b());
            this.f46932a.f45272d.putInt(l.f1974a, aVar.c());
        }
        this.f46932a.c();
    }
}
