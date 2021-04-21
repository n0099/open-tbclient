package d.b.j0.s0;

import com.baidu.tbadk.core.TbadkCoreApplication;
import d.b.c.j.e.n;
import d.b.i0.r.q.a2;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f61855a;

    public static a a(boolean z) {
        if (z && d()) {
            return new a();
        }
        return null;
    }

    public static boolean d() {
        return d.b.i0.b.d.m();
    }

    public static boolean e(FrsTabInfo frsTabInfo, int i) {
        if (TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1) {
            return false;
        }
        if (frsTabInfo != null && 505 == frsTabInfo.tab_id.intValue() && 91 == frsTabInfo.tab_type.intValue()) {
            return false;
        }
        return ((frsTabInfo != null && 502 == frsTabInfo.tab_id.intValue() && 91 == frsTabInfo.tab_type.intValue()) || i == 2) ? false : true;
    }

    public void b(List<n> list, boolean z, String str) {
        int i;
        int d2 = d.b.j0.r0.a.h().d();
        if (z) {
            i = d.b.j0.r0.a.h().e() - 1;
            for (n nVar : list) {
                if (nVar instanceof a2) {
                    if (((a2) nVar).x0() != 1) {
                        break;
                    }
                    i++;
                }
            }
        } else {
            i = this.f61855a;
        }
        this.f61855a = c(i, d2, list, str);
    }

    public final int c(int i, int i2, List<n> list, String str) {
        if (list == null || list.size() == 0 || i > list.size() - 1) {
            return 0;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            a2 a2Var = new a2();
            d.b.j0.d3.h0.n nVar = new d.b.j0.d3.h0.n();
            nVar.k(true);
            a2Var.C2 = nVar;
            nVar.j(str);
            list.add(i, a2Var);
            i = i + i2 + 1;
            if (i > list.size() - 1) {
                return (i - (list.size() - 1)) - 1;
            }
        }
        return 0;
    }
}
