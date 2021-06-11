package d.a.l0.a.c2.f.g0;

import d.a.l0.a.a2.e;
import d.a.l0.a.a2.h;
import d.a.l0.a.a2.i;
import d.a.l0.a.a2.k;
/* loaded from: classes3.dex */
public class b extends a {

    /* renamed from: h  reason: collision with root package name */
    public String f44708h;

    public b(h hVar) {
        super(hVar);
    }

    @Override // d.a.l0.a.c2.f.g0.a
    public void e(String str) {
        String str2;
        if (i() && (str2 = this.f44708h) != null && str2.equals(str)) {
            d.a.l0.a.a2.d g2 = d.a.l0.a.a2.d.g();
            if (g2.C()) {
                if (g2.r().d0()) {
                    g2.o("flag_finish_activity", "flag_remove_task");
                    return;
                }
                d.a.l0.a.q2.a aVar = new d.a.l0.a.q2.a();
                aVar.j(10L);
                aVar.h(2107L);
                aVar.c("app forbidden");
                k.k0(d.a.l0.n.g.a.h().s(str), d.a.l0.a.c1.a.b(), g2.r().L(), false, null, aVar);
            }
        }
    }

    public boolean i() {
        return (e.Q() == null || this.f44706f == 0) ? false : true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.v2.e1.b
    /* renamed from: j */
    public void onCallback(i.a aVar) {
        if (d.a.l0.a.v1.b.c.f(aVar.C(), "swan_forbidden_kill_on_client")) {
            this.f44706f = aVar.j("ipc_forbidden_flag", 1);
            this.f44708h = aVar.o("mAppId", d.a.l0.a.a2.d.g().getAppId());
        }
        if (d.a.l0.a.v1.b.c.f(aVar.C(), "swan_kill_to_client")) {
            d.a.l0.a.a2.d.g().o("flag_finish_activity", "flag_remove_task");
        }
    }
}
