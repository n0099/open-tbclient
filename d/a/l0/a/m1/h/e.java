package d.a.l0.a.m1.h;
/* loaded from: classes3.dex */
public class e extends c {

    /* renamed from: e  reason: collision with root package name */
    public final boolean f43488e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.l0.a.p.e.e f43489f;

    public e(d.a.l0.a.p.e.e eVar, boolean z) {
        super(6);
        this.f43488e = z;
        this.f43489f = eVar;
    }

    @Override // d.a.l0.a.m1.h.c
    public String d() {
        d.a.l0.a.c2.f.r0.d params;
        d.a.l0.a.p.e.e eVar = this.f43489f;
        if (eVar == null || (params = eVar.getParams()) == null) {
            return null;
        }
        return params.f40846g;
    }

    public boolean e() {
        return this.f43488e;
    }
}
