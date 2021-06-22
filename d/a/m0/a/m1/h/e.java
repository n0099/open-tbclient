package d.a.m0.a.m1.h;
/* loaded from: classes3.dex */
public class e extends c {

    /* renamed from: e  reason: collision with root package name */
    public final boolean f47272e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.m0.a.p.e.e f47273f;

    public e(d.a.m0.a.p.e.e eVar, boolean z) {
        super(6);
        this.f47272e = z;
        this.f47273f = eVar;
    }

    @Override // d.a.m0.a.m1.h.c
    public String d() {
        d.a.m0.a.c2.f.r0.d params;
        d.a.m0.a.p.e.e eVar = this.f47273f;
        if (eVar == null || (params = eVar.getParams()) == null) {
            return null;
        }
        return params.f44630g;
    }

    public boolean e() {
        return this.f47272e;
    }
}
