package d.b.j0;

import com.baidu.tbadk.core.TbadkCoreApplication;
import d.b.i0.s.c.h;
/* loaded from: classes4.dex */
public class b {
    public static void b(h hVar) {
        if (hVar == null) {
            return;
        }
        if (hVar.f51924b != 0) {
            d.b.i0.r.d0.b.j().x("app_entrance_nologin", hVar.f51924b + "");
        }
        if (hVar.f51923a == 0 || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        d.b.i0.r.d0.b.j().x("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), hVar.f51923a + "");
    }

    public int a() {
        String p;
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            p = d.b.i0.r.d0.b.j().p("app_entrance_nologin", "");
        } else {
            d.b.i0.r.d0.b j = d.b.i0.r.d0.b.j();
            p = j.p("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), "");
        }
        int d2 = d.b.c.e.m.b.d(p, 0);
        return (d2 != 1 && d2 == 2) ? 1 : 2;
    }
}
