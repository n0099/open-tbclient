package d.a.k0.q0.n2;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.j0.a.w;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.y1;
import d.a.k0.d3.j0.a;
import d.a.k0.q0.n1.d.e0;
import d.a.k0.q0.r;
import d.a.k0.s2.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public class l {
    public static void a(d.a.k0.q0.j2.b bVar, String str) {
        if (TextUtils.isEmpty(str) || bVar == null || TextUtils.isEmpty(bVar.f58635c)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c11942");
        statisticItem.param("fid", bVar.f58635c);
        statisticItem.param("obj_name", str);
        TiebaStatic.log(statisticItem);
    }

    public static void b(r rVar, FrsViewData frsViewData, String str, boolean z, a2 a2Var) {
        d.a.j0.s.c.d adAdSense;
        if (rVar == null || frsViewData == null || TextUtils.isEmpty(str) || (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) == null || !adAdSense.h()) {
            return;
        }
        e0 U = rVar == null ? null : rVar.U();
        List<d.a.c.j.e.n> f2 = U != null ? U.f() : null;
        List<d.a.c.j.e.n> singletonList = a2Var != null ? Collections.singletonList(a2Var) : f2;
        if (singletonList == null || f2 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        if (z) {
            for (d.a.c.j.e.n nVar : f2) {
                i2++;
                for (d.a.c.j.e.n nVar2 : singletonList) {
                    if (nVar == nVar2 && (nVar2 instanceof a2)) {
                        a.c cVar = new a.c();
                        cVar.f53861a = ((a2) nVar2).x1();
                        cVar.f53863c = i2;
                        arrayList.add(cVar);
                    }
                }
            }
        } else {
            for (d.a.c.j.e.n nVar3 : singletonList) {
                if (nVar3 instanceof a2) {
                    a2 a2Var2 = (a2) nVar3;
                    i2++;
                    if (a2Var2.t0 == 1 && !TextUtils.isEmpty(a2Var2.x1())) {
                        a2Var2.t0 = 2;
                        a.c cVar2 = new a.c();
                        cVar2.f53861a = a2Var2.x1();
                        cVar2.f53863c = i2;
                        arrayList.add(cVar2);
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            y.u(z, frsViewData.getForum().getFirst_class(), frsViewData.getForum().getSecond_class(), str, arrayList, adAdSense.j());
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
        d.a.k0.d3.j0.a.c("frs", "CLICK", b2, c2, g2, "tieba.baidu.com/p/" + y1Var.g(), str);
    }

    public static void d(FrsFragment frsFragment, FrsViewData frsViewData, a2 a2Var) {
        if (a2Var == null || frsViewData == null) {
            return;
        }
        FrsModelController b0 = frsFragment.b0();
        r y0 = frsFragment.y0();
        if (y0 == null || b0 == null) {
            return;
        }
        if (a2Var.T() != null && a2Var.T().getGodInfo() != null) {
            TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", a2Var.o0()));
        }
        if (frsViewData != null && frsViewData.getForum() != null) {
            d.a.k0.q0.j2.b bVar = new d.a.k0.q0.j2.b();
            bVar.f58633a = frsViewData.needLog == 1;
            bVar.f58635c = frsViewData.getForum().getId();
            bVar.f58634b = b0.N();
            d.a.k0.q0.j2.b bVar2 = d.a.k0.q0.j2.d.J0;
            if (bVar2 != null) {
                bVar.f58636d = bVar2.f58636d;
                bVar.f58637e = bVar2.f58637e;
            }
            d.a.k0.q0.j2.c.j().g(bVar, a2Var, 1);
            d.a.k0.q0.j2.a.c(a2Var, 1, frsFragment.getUniqueId(), bVar, frsFragment.getTbPageTag());
        }
        b(y0, frsViewData, frsFragment.h(), true, a2Var);
    }

    public static void e(String str, int i2, int i3) {
        StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_locate", i2).param("obj_type", i3).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
        w.a(param, str);
        TiebaStatic.log(param);
    }

    public static void f(FrsModelController frsModelController, long j) {
        if (frsModelController == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        TiebaStatic.page(TiebaStatic.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.b0() - j, frsModelController.d0(), frsModelController.c0(), currentTimeMillis - frsModelController.a0());
    }
}
