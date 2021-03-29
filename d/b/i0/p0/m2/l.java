package d.b.i0.p0.m2;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.y1;
import d.b.i0.c3.j0.a;
import d.b.i0.p0.n1.d.l0;
import d.b.i0.p0.r;
import d.b.i0.r2.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public class l {
    public static void a(d.b.i0.p0.j2.b bVar, String str) {
        if (TextUtils.isEmpty(str) || bVar == null || TextUtils.isEmpty(bVar.f57702c)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c11942");
        statisticItem.param("fid", bVar.f57702c);
        statisticItem.param("obj_name", str);
        TiebaStatic.log(statisticItem);
    }

    public static void b(r rVar, FrsViewData frsViewData, String str, boolean z, a2 a2Var) {
        d.b.h0.s.c.d adAdSense;
        if (rVar == null || frsViewData == null || TextUtils.isEmpty(str) || (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) == null || !adAdSense.h()) {
            return;
        }
        l0 U = rVar == null ? null : rVar.U();
        List<d.b.b.j.e.n> l = U != null ? U.l() : null;
        List<d.b.b.j.e.n> singletonList = a2Var != null ? Collections.singletonList(a2Var) : l;
        if (singletonList == null || l == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        if (z) {
            for (d.b.b.j.e.n nVar : l) {
                i++;
                for (d.b.b.j.e.n nVar2 : singletonList) {
                    if (nVar == nVar2 && (nVar2 instanceof a2)) {
                        a.c cVar = new a.c();
                        cVar.f53450a = ((a2) nVar2).w1();
                        cVar.f53452c = i;
                        arrayList.add(cVar);
                    }
                }
            }
        } else {
            for (d.b.b.j.e.n nVar3 : singletonList) {
                if (nVar3 instanceof a2) {
                    a2 a2Var2 = (a2) nVar3;
                    i++;
                    if (a2Var2.t0 == 1 && !TextUtils.isEmpty(a2Var2.w1())) {
                        a2Var2.t0 = 2;
                        a.c cVar2 = new a.c();
                        cVar2.f53450a = a2Var2.w1();
                        cVar2.f53452c = i;
                        arrayList.add(cVar2);
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            t.u(z, frsViewData.getForum().getFirst_class(), frsViewData.getForum().getSecond_class(), str, arrayList, adAdSense.j());
        }
    }

    public static void c(y1 y1Var) {
        if (y1Var == null) {
            return;
        }
        String d2 = y1Var.d();
        if (StringUtils.isNull(d2)) {
            d2 = y1Var.f();
        }
        String str = d2;
        String b2 = y1Var.b();
        String c2 = y1Var.c();
        String g2 = y1Var.g();
        d.b.i0.c3.j0.a.c("frs", "CLICK", b2, c2, g2, "tieba.baidu.com/p/" + y1Var.g(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, a2 a2Var) {
        if (a2Var == null || frsViewData == null) {
            return;
        }
        FrsModelController M = frsFragment.M();
        r x0 = frsFragment.x0();
        if (x0 == null || M == null) {
            return;
        }
        if (a2Var.T() != null && a2Var.T().getGodInfo() != null) {
            TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", a2Var.o0()));
        }
        if (frsViewData != null && frsViewData.getForum() != null) {
            d.b.i0.p0.j2.b bVar = new d.b.i0.p0.j2.b();
            bVar.f57700a = frsViewData.needLog == 1;
            bVar.f57702c = frsViewData.getForum().getId();
            bVar.f57701b = M.N();
            d.b.i0.p0.j2.b bVar2 = d.b.i0.p0.j2.d.J0;
            if (bVar2 != null) {
                bVar.f57703d = bVar2.f57703d;
                bVar.f57704e = bVar2.f57704e;
            }
            d.b.i0.p0.j2.c.j().g(bVar, a2Var, 1);
            d.b.i0.p0.j2.a.b(a2Var, 1, frsFragment.getUniqueId(), bVar, frsFragment.getTbPageTag());
        }
        b(x0, frsViewData, frsFragment.h(), true, a2Var);
    }

    public static void e(int i, int i2) {
        TiebaStatic.log(new StatisticItem("c10320").param("obj_locate", i).param("obj_type", i2).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1));
    }

    public static void f(FrsModelController frsModelController, long j) {
        if (frsModelController == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.b0() - j, frsModelController.d0(), frsModelController.c0(), currentTimeMillis - frsModelController.a0());
    }
}
