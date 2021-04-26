package d.a.j0.s0;

import com.baidu.tbadk.core.TbadkCoreApplication;
import d.a.c.j.e.n;
import d.a.i0.r.q.a2;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f60016a;

    public static a a(boolean z) {
        if (z && d()) {
            return new a();
        }
        return null;
    }

    public static boolean d() {
        return d.a.i0.b.d.m();
    }

    public static boolean e(FrsTabInfo frsTabInfo, int i2) {
        if (TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1) {
            return false;
        }
        if (frsTabInfo != null && 505 == frsTabInfo.tab_id.intValue() && 91 == frsTabInfo.tab_type.intValue()) {
            return false;
        }
        return ((frsTabInfo != null && 502 == frsTabInfo.tab_id.intValue() && 91 == frsTabInfo.tab_type.intValue()) || i2 == 2) ? false : true;
    }

    public void b(List<n> list, boolean z, String str) {
        int i2;
        int d2 = d.a.j0.r0.a.h().d();
        if (z) {
            i2 = d.a.j0.r0.a.h().e() - 1;
            for (n nVar : list) {
                if (nVar instanceof a2) {
                    if (((a2) nVar).x0() != 1) {
                        break;
                    }
                    i2++;
                }
            }
        } else {
            i2 = this.f60016a;
        }
        this.f60016a = c(i2, d2, list, str);
    }

    public final int c(int i2, int i3, List<n> list, String str) {
        if (list == null || list.size() == 0 || i2 > list.size() - 1) {
            return 0;
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            a2 a2Var = new a2();
            d.a.j0.d3.h0.n nVar = new d.a.j0.d3.h0.n();
            nVar.k(true);
            a2Var.C2 = nVar;
            nVar.j(str);
            list.add(i2, a2Var);
            i2 = i2 + i3 + 1;
            if (i2 > list.size() - 1) {
                return (i2 - (list.size() - 1)) - 1;
            }
        }
        return 0;
    }
}
