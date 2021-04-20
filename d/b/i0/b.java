package d.b.i0;

import com.baidu.tbadk.core.TbadkCoreApplication;
import d.b.h0.s.c.h;
/* loaded from: classes4.dex */
public class b {
    public static void b(h hVar) {
        if (hVar == null) {
            return;
        }
        if (hVar.f51588b != 0) {
            d.b.h0.r.d0.b.j().x("app_entrance_nologin", hVar.f51588b + "");
        }
        if (hVar.f51587a == 0 || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        d.b.h0.r.d0.b.j().x("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), hVar.f51587a + "");
    }

    public int a() {
        String p;
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            p = d.b.h0.r.d0.b.j().p("app_entrance_nologin", "");
        } else {
            d.b.h0.r.d0.b j = d.b.h0.r.d0.b.j();
            p = j.p("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), "");
        }
        int d2 = d.b.c.e.m.b.d(p, 0);
        return (d2 != 1 && d2 == 2) ? 1 : 2;
    }
}
