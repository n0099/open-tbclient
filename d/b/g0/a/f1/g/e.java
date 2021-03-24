package d.b.g0.a.f1.g;
/* loaded from: classes3.dex */
public class e extends c {

    /* renamed from: e  reason: collision with root package name */
    public final boolean f44444e;

    /* renamed from: f  reason: collision with root package name */
    public final d.b.g0.a.p.d.e f44445f;

    public e(d.b.g0.a.p.d.e eVar, boolean z) {
        super(6);
        this.f44444e = z;
        this.f44445f = eVar;
    }

    @Override // d.b.g0.a.f1.g.c
    public String d() {
        d.b.g0.a.t1.k.r0.d params;
        d.b.g0.a.p.d.e eVar = this.f44445f;
        if (eVar == null || (params = eVar.getParams()) == null) {
            return null;
        }
        return params.f43113g;
    }

    public boolean e() {
        return this.f44444e;
    }
}
