package d.a.k0;

import com.baidu.tbadk.core.TbadkCoreApplication;
import d.a.j0.s.c.h;
/* loaded from: classes4.dex */
public class b {
    public static void b(h hVar) {
        if (hVar == null) {
            return;
        }
        if (hVar.f50396b != 0) {
            d.a.j0.r.d0.b.j().x("app_entrance_nologin", hVar.f50396b + "");
        }
        if (hVar.f50395a == 0 || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        d.a.j0.r.d0.b.j().x("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), hVar.f50395a + "");
    }

    public int a() {
        String p;
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            p = d.a.j0.r.d0.b.j().p("app_entrance_nologin", "");
        } else {
            d.a.j0.r.d0.b j = d.a.j0.r.d0.b.j();
            p = j.p("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), "");
        }
        int d2 = d.a.c.e.m.b.d(p, 0);
        return (d2 != 1 && d2 == 2) ? 1 : 2;
    }
}
