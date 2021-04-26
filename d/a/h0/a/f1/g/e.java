package d.a.h0.a.f1.g;
/* loaded from: classes3.dex */
public class e extends c {

    /* renamed from: e  reason: collision with root package name */
    public final boolean f42477e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.h0.a.p.d.e f42478f;

    public e(d.a.h0.a.p.d.e eVar, boolean z) {
        super(6);
        this.f42477e = z;
        this.f42478f = eVar;
    }

    @Override // d.a.h0.a.f1.g.c
    public String d() {
        d.a.h0.a.t1.k.r0.d params;
        d.a.h0.a.p.d.e eVar = this.f42478f;
        if (eVar == null || (params = eVar.getParams()) == null) {
            return null;
        }
        return params.f41093g;
    }

    public boolean e() {
        return this.f42477e;
    }
}
