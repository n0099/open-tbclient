package d.a.n0;

import com.baidu.tbadk.core.TbadkCoreApplication;
import d.a.m0.s.c.h;
/* loaded from: classes4.dex */
public class b {
    public static void b(h hVar) {
        if (hVar == null) {
            return;
        }
        if (hVar.f50462b != 0) {
            d.a.m0.r.d0.b.j().x("app_entrance_nologin", hVar.f50462b + "");
        }
        if (hVar.f50461a == 0 || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        d.a.m0.r.d0.b.j().x("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), hVar.f50461a + "");
    }

    public int a() {
        String p;
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            p = d.a.m0.r.d0.b.j().p("app_entrance_nologin", "");
        } else {
            d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
            p = j.p("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), "");
        }
        int d2 = d.a.c.e.m.b.d(p, 0);
        return (d2 != 1 && d2 == 2) ? 1 : 2;
    }
}
