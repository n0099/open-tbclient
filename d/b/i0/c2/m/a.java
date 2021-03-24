package d.b.i0.c2.m;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.b.i0.b3.c;
import d.b.i0.c2.h.e;
/* loaded from: classes5.dex */
public class a {
    public static void a(e eVar, PostData postData, int i, int i2) {
        c(eVar, postData, postData != null ? postData.D() : null, i, i2);
    }

    public static void b(e eVar, PostData postData, int i, int i2, int i3) {
        if (eVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        f(statisticItem, eVar, postData, i, i2, false, postData != null ? postData.D() : null);
        statisticItem.param("obj_locate", i3);
        TiebaStatic.log(statisticItem);
    }

    public static void c(e eVar, PostData postData, String str, int i, int i2) {
        if (eVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        f(statisticItem, eVar, postData, i, i2, false, str);
        TiebaStatic.log(statisticItem);
    }

    public static void d(BdUniqueId bdUniqueId, e eVar, PostData postData, int i, int i2) {
        String D = postData != null ? postData.D() : null;
        e(bdUniqueId, eVar, postData, D, D, i, i2);
    }

    public static void e(BdUniqueId bdUniqueId, e eVar, PostData postData, String str, String str2, int i, int i2) {
        if (bdUniqueId == null || eVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_exp");
        f(statisticItem, eVar, postData, i, i2, false, str);
        c.g().d(bdUniqueId, str2, statisticItem);
    }

    public static StatisticItem f(StatisticItem statisticItem, e eVar, PostData postData, int i, int i2, boolean z, String str) {
        if (eVar == null) {
            return statisticItem;
        }
        StatisticItem param = statisticItem.param("page_type", "a005").param(TiebaStatic.Params.OBJ_FLOOR, i).param(TiebaStatic.Params.OBJ_ISAD, z ? 1 : 0);
        StatisticItem param2 = param.param("fid", eVar.m() + "");
        StatisticItem param3 = param2.param("tid", eVar.N() + "");
        param3.param("obj_id", str + "").param(TiebaStatic.Params.POST_TYPE, i2);
        if (postData != null) {
            statisticItem.param("pid", postData.D() + "");
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
        int i3 = 2;
        if (eVar.L().a2()) {
            statisticItem.param(TiebaStatic.Params.GUA_TYPE, 1);
        } else if (postData.E() != null) {
            statisticItem.param(TiebaStatic.Params.GUA_TYPE, 2);
        } else {
            statisticItem.param(TiebaStatic.Params.GUA_TYPE, 0);
        }
        if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
            statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().r);
        }
        if (!eVar.Z()) {
            int i4 = eVar.f52425g;
            if (i4 == 2) {
                i3 = 1;
            } else if (i4 == 1) {
                i3 = 3;
            }
            statisticItem.param(TiebaStatic.Params.LIST_ORDER, i3);
        }
        if (eVar.L() != null) {
            statisticItem.param(TiebaStatic.Params.IS_ZP, eVar.L().C2() ? 1 : 0);
        }
        return statisticItem;
    }

    public static StatisticItem g(e eVar, PostData postData, int i, int i2, int i3) {
        if (eVar == null) {
            return null;
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        f(statisticItem, eVar, postData, i, i2, false, postData != null ? postData.D() : null);
        statisticItem.param("obj_locate", i3);
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

    public static void i(d.b.h0.r.q.a aVar, int i) {
        if (aVar == null || aVar.n() == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13992");
        if (aVar.n().h0() != null) {
            statisticItem.param("obj_type", h(aVar.n().h0().j));
        }
        statisticItem.param("obj_locate", aVar.n().B2);
        statisticItem.param("tid", aVar.n().w1());
        statisticItem.param("fid", aVar.n().c0());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_source", i);
        TiebaStatic.log(statisticItem);
    }

    public static void j(d.b.h0.r.q.a aVar) {
        if (aVar == null || aVar.n() == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c14020");
        if (aVar.n().h0() != null) {
            statisticItem.param("obj_type", h(aVar.n().h0().j));
        }
        statisticItem.param("tid", aVar.n().w1());
        statisticItem.param("fid", aVar.n().c0());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        TiebaStatic.log(statisticItem);
    }
}
