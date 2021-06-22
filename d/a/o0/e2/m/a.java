package d.a.o0.e2.m;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.a.o0.d3.c;
import d.a.o0.e2.h.e;
/* loaded from: classes5.dex */
public class a {
    public static void a(e eVar, PostData postData, int i2, int i3) {
        c(eVar, postData, postData != null ? postData.E() : null, i2, i3);
    }

    public static void b(e eVar, PostData postData, int i2, int i3, int i4) {
        if (eVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        f(statisticItem, eVar, postData, i2, i3, false, postData != null ? postData.E() : null);
        statisticItem.param("obj_locate", i4);
        TiebaStatic.log(statisticItem);
    }

    public static void c(e eVar, PostData postData, String str, int i2, int i3) {
        if (eVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        f(statisticItem, eVar, postData, i2, i3, false, str);
        TiebaStatic.log(statisticItem);
    }

    public static void d(BdUniqueId bdUniqueId, e eVar, PostData postData, int i2, int i3) {
        String E = postData != null ? postData.E() : null;
        e(bdUniqueId, eVar, postData, E, E, i2, i3);
    }

    public static void e(BdUniqueId bdUniqueId, e eVar, PostData postData, String str, String str2, int i2, int i3) {
        if (bdUniqueId == null || eVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_exp");
        f(statisticItem, eVar, postData, i2, i3, false, str);
        c.g().d(bdUniqueId, str2, statisticItem);
    }

    public static StatisticItem f(StatisticItem statisticItem, e eVar, PostData postData, int i2, int i3, boolean z, String str) {
        if (eVar == null) {
            return statisticItem;
        }
        StatisticItem param = statisticItem.param("page_type", "a005").param(TiebaStatic.Params.OBJ_FLOOR, i2).param(TiebaStatic.Params.OBJ_ISAD, z ? 1 : 0);
        StatisticItem param2 = param.param("fid", eVar.m() + "");
        StatisticItem param3 = param2.param("tid", eVar.N() + "");
        param3.param("obj_id", str + "").param(TiebaStatic.Params.POST_TYPE, i3);
        if (postData != null) {
            statisticItem.param("pid", postData.E() + "");
        }
        if (eVar.L() != null) {
            statisticItem.param("thread_type", eVar.L().Z);
            BaijiahaoData V = eVar.L().V();
            if (V != null) {
                statisticItem.param(TiebaStatic.Params.UGC_NID, V.oriUgcNid);
                statisticItem.param(TiebaStatic.Params.UGC_VID, V.oriUgcVid);
                statisticItem.param(TiebaStatic.Params.UGC_TYPE, V.oriUgcType);
            }
        }
        int i4 = 2;
        if (eVar.L().e2()) {
            statisticItem.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (postData.F() != null) {
            statisticItem.param(TiebaStatic.Params.GUA_TYPE, 2);
        } else {
            statisticItem.param(TiebaStatic.Params.GUA_TYPE, 0);
        }
        if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
            statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().r);
        }
        if (!eVar.a0()) {
            int i5 = eVar.f56739g;
            if (i5 == 2) {
                i4 = 1;
            } else if (i5 == 1) {
                i4 = 3;
            }
            statisticItem.param(TiebaStatic.Params.LIST_ORDER, i4);
        }
        if (eVar.L() != null) {
            statisticItem.param(TiebaStatic.Params.IS_ZP, eVar.L().H2() ? 1 : 0);
        }
        return statisticItem;
    }

    public static StatisticItem g(e eVar, PostData postData, int i2, int i3, int i4) {
        if (eVar == null) {
            return null;
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        f(statisticItem, eVar, postData, i2, i3, false, postData != null ? postData.E() : null);
        statisticItem.param("obj_locate", i4);
        return statisticItem;
    }

    public static int h(String str) {
        if ("游戏".equals(str)) {
            return 1;
        }
        if ("动漫".equals(str)) {
            return 2;
        }
        return "电脑数码".equals(str) ? 3 : 4;
    }

    public static void i(d.a.n0.r.q.a aVar, int i2) {
        if (aVar == null || aVar.i() == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13992");
        if (aVar.i().h0() != null) {
            statisticItem.param("obj_type", h(aVar.i().h0().j));
        }
        statisticItem.param("obj_locate", aVar.i().E2);
        statisticItem.param("tid", aVar.i().z1());
        statisticItem.param("fid", aVar.i().c0());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_source", i2);
        TiebaStatic.log(statisticItem);
    }

    public static void j(d.a.n0.r.q.a aVar) {
        if (aVar == null || aVar.i() == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c14020");
        if (aVar.i().h0() != null) {
            statisticItem.param("obj_type", h(aVar.i().h0().j));
        }
        statisticItem.param("tid", aVar.i().z1());
        statisticItem.param("fid", aVar.i().c0());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        TiebaStatic.log(statisticItem);
    }
}
