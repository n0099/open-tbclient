package d.a.i0.j0;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.pageInfo.TbPageTag;
import d.a.c.a.g;
import d.a.c.a.j;
import d.a.c.e.p.k;
import d.a.i0.r.q.a2;
/* loaded from: classes3.dex */
public class c {
    public static StatisticItem a(StatisticItem statisticItem, TbPageTag tbPageTag) {
        if (tbPageTag == null || statisticItem == null) {
            return null;
        }
        if (!TextUtils.isEmpty(tbPageTag.locatePage)) {
            if (statisticItem.hasParam(TiebaStatic.Params.OBJ_TAB)) {
                statisticItem.delete(TiebaStatic.Params.OBJ_TAB);
            }
            statisticItem.param(TiebaStatic.Params.OBJ_TAB, tbPageTag.locatePage);
        }
        statisticItem.param("sort_tab", tbPageTag.sortType);
        return statisticItem;
    }

    public static StatisticItem b(Context context, StatisticItem statisticItem) {
        return (context == null || statisticItem == null) ? statisticItem : c(statisticItem, j(context));
    }

    public static StatisticItem c(StatisticItem statisticItem, b bVar) {
        return (bVar == null || statisticItem == null) ? statisticItem : d(statisticItem, bVar.b(), bVar.a());
    }

    public static StatisticItem d(StatisticItem statisticItem, TbPageTag tbPageTag, TbPageTag tbPageTag2) {
        if (statisticItem == null) {
            return null;
        }
        if (tbPageTag2 != null) {
            if (!TextUtils.isEmpty(tbPageTag2.locatePage)) {
                if (statisticItem.hasParam(TiebaStatic.Params.OBJ_TAB)) {
                    statisticItem.delete(TiebaStatic.Params.OBJ_TAB);
                }
                statisticItem.param(TiebaStatic.Params.OBJ_TAB, tbPageTag2.locatePage);
            }
            statisticItem.param("sort_tab", tbPageTag2.sortType);
        }
        if (tbPageTag != null && !TextUtils.isEmpty(tbPageTag.locatePage)) {
            statisticItem.param(GuildActivityConfig.FROM_PAGE, tbPageTag.locatePage);
        }
        return statisticItem;
    }

    public static StatisticItem e(Context context, StatisticItem statisticItem) {
        return (context == null || statisticItem == null) ? statisticItem : f(statisticItem, j(context));
    }

    public static StatisticItem f(StatisticItem statisticItem, b bVar) {
        return (bVar == null || statisticItem == null) ? statisticItem : g(statisticItem, bVar.b(), bVar.a());
    }

    public static StatisticItem g(StatisticItem statisticItem, TbPageTag tbPageTag, TbPageTag tbPageTag2) {
        if (statisticItem == null) {
            return null;
        }
        if (tbPageTag2 != null) {
            if (!TextUtils.isEmpty(tbPageTag2.locatePage)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PAGE, tbPageTag2.locatePage);
            }
            statisticItem.param("sort_tab", tbPageTag2.sortType);
        }
        if (tbPageTag != null && !TextUtils.isEmpty(tbPageTag.locatePage)) {
            if (statisticItem.hasParam(TiebaStatic.Params.OBJ_TAB)) {
                statisticItem.delete(TiebaStatic.Params.OBJ_TAB);
            }
            statisticItem.param(TiebaStatic.Params.OBJ_TAB, tbPageTag.locatePage);
        }
        return statisticItem;
    }

    public static StatisticItem h(Context context, StatisticItem statisticItem) {
        if (context == null || statisticItem == null) {
            return null;
        }
        TbPageTag l = l(context);
        if (l != null) {
            if (!TextUtils.isEmpty(l.locatePage)) {
                if (statisticItem.hasParam(TiebaStatic.Params.OBJ_TAB)) {
                    statisticItem.delete(TiebaStatic.Params.OBJ_TAB);
                }
                statisticItem.param(TiebaStatic.Params.OBJ_TAB, l.locatePage);
            }
            statisticItem.param("sort_tab", l.sortType);
        }
        return statisticItem;
    }

    public static StatisticItem i(Context context, a2 a2Var, String str) {
        if (context == null || a2Var == null || StringUtils.isNull(str)) {
            return null;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("tid", a2Var.o0()).param("fid", a2Var.c0()).param("card_type", a2Var.U0()).param("nid", a2Var.L0());
        if (a2Var.V() != null && !k.isEmpty(a2Var.V().oriUgcVid)) {
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, a2Var.V().oriUgcVid);
        }
        statisticItem.param("weight", a2Var.S0).param("ab_tag", a2Var.T0).param("extra", a2Var.U0).param("obj_type", a2Var.z2 ? "2" : "1").param("source", a2Var.R0);
        h(context, statisticItem);
        return statisticItem;
    }

    public static b j(Context context) {
        if (context != null) {
            g<?> b2 = j.b(context);
            if (b2 instanceof a) {
                return ((a) b2).getTbPageInfo();
            }
            return null;
        }
        return null;
    }

    public static TbPageTag k(Context context) {
        b j = j(context);
        if (j == null) {
            return null;
        }
        return j.a();
    }

    public static TbPageTag l(Context context) {
        g<?> b2;
        if (context == null || (b2 = j.b(context)) == null || b2.getPageContext() == null || b2.getPageContext().getPageActivity() == null) {
            return null;
        }
        return m(b2.getPageContext().getPageActivity().getIntent());
    }

    public static TbPageTag m(Intent intent) {
        if (intent != null) {
            return (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
        return null;
    }
}
