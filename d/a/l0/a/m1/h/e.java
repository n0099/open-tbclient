package d.a.l0.a.m1.h;
/* loaded from: classes3.dex */
public class e extends c {

    /* renamed from: e  reason: collision with root package name */
    public final boolean f47164e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.l0.a.p.e.e f47165f;

    public e(d.a.l0.a.p.e.e eVar, boolean z) {
        super(6);
        this.f47164e = z;
        this.f47165f = eVar;
    }

    @Override // d.a.l0.a.m1.h.c
    public String d() {
        d.a.l0.a.c2.f.r0.d params;
        d.a.l0.a.p.e.e eVar = this.f47165f;
        if (eVar == null || (params = eVar.getParams()) == null) {
            return null;
        }
        return params.f44522g;
    }

    public boolean e() {
        return this.f47164e;
    }
}
