package d.b.i0;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class b {
    public static void b(d.b.h0.s.c.f fVar) {
        if (fVar == null) {
            return;
        }
        if (fVar.f51161b != 0) {
            d.b.h0.r.d0.b.i().w("app_entrance_nologin", fVar.f51161b + "");
        }
        if (fVar.f51160a == 0 || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        d.b.h0.r.d0.b.i().w("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), fVar.f51160a + "");
    }

    public int a() {
        String o;
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            o = d.b.h0.r.d0.b.i().o("app_entrance_nologin", "");
        } else {
            d.b.h0.r.d0.b i = d.b.h0.r.d0.b.i();
            o = i.o("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), "");
        }
        int d2 = d.b.b.e.m.b.d(o, 0);
        return (d2 != 1 && d2 == 2) ? 1 : 2;
    }
}
