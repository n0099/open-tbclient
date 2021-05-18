package d.a.i0.a.m1.h;
/* loaded from: classes3.dex */
public class e extends c {

    /* renamed from: e  reason: collision with root package name */
    public final boolean f43314e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.i0.a.p.e.e f43315f;

    public e(d.a.i0.a.p.e.e eVar, boolean z) {
        super(6);
        this.f43314e = z;
        this.f43315f = eVar;
    }

    @Override // d.a.i0.a.m1.h.c
    public String d() {
        d.a.i0.a.c2.f.r0.d params;
        d.a.i0.a.p.e.e eVar = this.f43315f;
        if (eVar == null || (params = eVar.getParams()) == null) {
            return null;
        }
        return params.f40672g;
    }

    public boolean e() {
        return this.f43314e;
    }
}
