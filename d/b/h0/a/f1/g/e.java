package d.b.h0.a.f1.g;
/* loaded from: classes2.dex */
public class e extends c {

    /* renamed from: e  reason: collision with root package name */
    public final boolean f45166e;

    /* renamed from: f  reason: collision with root package name */
    public final d.b.h0.a.p.d.e f45167f;

    public e(d.b.h0.a.p.d.e eVar, boolean z) {
        super(6);
        this.f45166e = z;
        this.f45167f = eVar;
    }

    @Override // d.b.h0.a.f1.g.c
    public String d() {
        d.b.h0.a.t1.k.r0.d params;
        d.b.h0.a.p.d.e eVar = this.f45167f;
        if (eVar == null || (params = eVar.getParams()) == null) {
            return null;
        }
        return params.f43835g;
    }

    public boolean e() {
        return this.f45166e;
    }
}
