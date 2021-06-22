package d.a.m0.a.c2.f.g0;

import d.a.m0.a.a2.e;
import d.a.m0.a.a2.h;
import d.a.m0.a.a2.i;
import d.a.m0.a.a2.k;
/* loaded from: classes3.dex */
public class b extends a {

    /* renamed from: h  reason: collision with root package name */
    public String f44816h;

    public b(h hVar) {
        super(hVar);
    }

    @Override // d.a.m0.a.c2.f.g0.a
    public void e(String str) {
        String str2;
        if (i() && (str2 = this.f44816h) != null && str2.equals(str)) {
            d.a.m0.a.a2.d g2 = d.a.m0.a.a2.d.g();
            if (g2.C()) {
                if (g2.r().d0()) {
                    g2.o("flag_finish_activity", "flag_remove_task");
                    return;
                }
                d.a.m0.a.q2.a aVar = new d.a.m0.a.q2.a();
                aVar.j(10L);
                aVar.h(2107L);
                aVar.c("app forbidden");
                k.k0(d.a.m0.n.g.a.h().s(str), d.a.m0.a.c1.a.b(), g2.r().L(), false, null, aVar);
            }
        }
    }

    public boolean i() {
        return (e.Q() == null || this.f44814f == 0) ? false : true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.v2.e1.b
    /* renamed from: j */
    public void onCallback(i.a aVar) {
        if (d.a.m0.a.v1.b.c.f(aVar.C(), "swan_forbidden_kill_on_client")) {
            this.f44814f = aVar.j("ipc_forbidden_flag", 1);
            this.f44816h = aVar.o("mAppId", d.a.m0.a.a2.d.g().getAppId());
        }
        if (d.a.m0.a.v1.b.c.f(aVar.C(), "swan_kill_to_client")) {
            d.a.m0.a.a2.d.g().o("flag_finish_activity", "flag_remove_task");
        }
    }
}
