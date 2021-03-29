package d.b.g0.a.f1.g;
/* loaded from: classes2.dex */
public class e extends c {

    /* renamed from: e  reason: collision with root package name */
    public final boolean f44445e;

    /* renamed from: f  reason: collision with root package name */
    public final d.b.g0.a.p.d.e f44446f;

    public e(d.b.g0.a.p.d.e eVar, boolean z) {
        super(6);
        this.f44445e = z;
        this.f44446f = eVar;
    }

    @Override // d.b.g0.a.f1.g.c
    public String d() {
        d.b.g0.a.t1.k.r0.d params;
        d.b.g0.a.p.d.e eVar = this.f44446f;
        if (eVar == null || (params = eVar.getParams()) == null) {
            return null;
        }
        return params.f43114g;
    }

    public boolean e() {
        return this.f44445e;
    }
}
