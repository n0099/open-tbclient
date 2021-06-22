package d.a.m0.f.j.n;

import com.alipay.sdk.util.l;
/* loaded from: classes3.dex */
public class i implements d.a.m0.f.j.p.a {

    /* renamed from: a  reason: collision with root package name */
    public f f50714a;

    public i(f fVar) {
        this.f50714a = fVar;
    }

    @Override // d.a.m0.f.j.p.a
    public void a(d.a.m0.f.j.q.a aVar) {
        b(aVar);
    }

    public final void b(d.a.m0.f.j.q.a aVar) {
        this.f50714a.f49054d.clear();
        if (aVar != null) {
            this.f50714a.f49054d.putString("functionType", aVar.a());
            this.f50714a.f49054d.putString("resultData", aVar.b());
            this.f50714a.f49054d.putInt(l.f1987a, aVar.c());
        }
        this.f50714a.c();
    }
}
