package d.a.m0.a.c2.f.g0;

import d.a.m0.a.a2.h;
import d.a.m0.a.a2.i;
/* loaded from: classes3.dex */
public class c extends a {
    public c(h hVar) {
        super(hVar);
    }

    @Override // d.a.m0.a.c2.f.g0.a
    public void e(String str) {
        d.a.m0.a.v1.b.b v = d.a.m0.a.v1.b.c.E("swan_forbidden_kill_on_client").y("mAppId", str).v("ipc_forbidden_flag", this.f44814f);
        v.J(str);
        v.L();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.v2.e1.b
    /* renamed from: i */
    public void onCallback(i.a aVar) {
        if (d.a.m0.a.v1.b.c.f(aVar.C(), "swan_forbidden_kill_on_server")) {
            this.f44814f = aVar.j("ipc_forbidden_flag", 1);
            e(aVar.o("mAppId", d.a.m0.a.a2.d.g().getAppId()));
        }
    }
}
