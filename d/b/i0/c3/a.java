package d.b.i0.c3;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.b.c.e.p.k;
import d.b.h0.r.q.a2;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f53648a = Arrays.asList("a006", "a005", "a008", "a002");

    public static String a(String str) {
        return "enterfourm_att_" + str;
    }

    public static String b(String str) {
        return "enterfourm_rec_" + str;
    }

    public static String c(String str, String str2, String str3, BaijiahaoData baijiahaoData) {
        String str4 = "_tid_" + str;
        if (!TextUtils.isEmpty(str2)) {
            str4 = str4 + "_adid_" + str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            str4 = str4 + "_appid_" + str3;
        }
        if (baijiahaoData != null) {
            return str4 + "_nid_" + baijiahaoData.oriUgcNid;
        }
        return str4;
    }

    public static StatisticItem d(a2 a2Var, String str, String str2, int i, int i2, boolean z, String str3, String str4) {
        return q(true, a2Var, str, str2, i, i2, z, str3, str4, false, "", 0);
    }

    public static StatisticItem e(a2 a2Var, String str, String str2, int i, int i2, boolean z, String str3, String str4, int i3) {
        if (a2Var == null) {
            return null;
        }
        return q(true, a2Var, str, str2, i, i2, z, str3, str4, false, "", i3);
    }

    public static StatisticItem f(a2 a2Var, String str, String str2, int i, boolean z, String str3, String str4) {
        return q(false, a2Var, str, str2, -1, i, z, str3, str4, false, "", 0);
    }

    public static StatisticItem g(a2 a2Var, String str, String str2, int i, boolean z, String str3, String str4, int i2) {
        if (a2Var == null) {
            return null;
        }
        return q(false, a2Var, str, str2, -1, i, z, str3, str4, false, "", i2);
    }

    public static StatisticItem h(String str, String str2, boolean z, int i) {
        return i(str, str2, z, i, 0);
    }

    public static StatisticItem i(String str, String str2, boolean z, int i, int i2) {
        StatisticItem statisticItem = new StatisticItem(str2);
        statisticItem.param("page_type", str).param("ad_exp", z ? 1 : 0).param("ad_exp_cnt", i).param(TiebaStatic.Params.OBJ_FLOOR, 0).param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
        if (str != null && f53648a.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().r);
        }
        return statisticItem;
    }

    public static StatisticItem j(a2 a2Var, String str, String str2, int i, int i2, String str3) {
        if (a2Var == null) {
            return null;
        }
        return q(true, a2Var, str, str2, i, i2, false, "", null, true, str3, 0);
    }

    public static StatisticItem k(a2 a2Var, String str, String str2, int i, String str3) {
        if (a2Var == null) {
            return null;
        }
        return q(false, a2Var, str, str2, -1, i, false, "", null, true, str3, 0);
    }

    public static StatisticItem l(boolean z, String str, String str2, int i, int i2, boolean z2, String str3, String str4, int i3) {
        StatisticItem statisticItem = new StatisticItem(str2);
        StatisticItem param = statisticItem.param("page_type", str).param(TiebaStatic.Params.OBJ_FLOOR, i2).param(TiebaStatic.Params.OBJ_ISAD, z2 ? 1 : 0);
        if (!z2) {
            str3 = str4;
        }
        param.param("obj_id", str3).param(TiebaStatic.Params.OBJ_AD_LOCATE, i3);
        if (str != null && f53648a.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().r);
        }
        if (z) {
            statisticItem.param("obj_locate", i);
        }
        return statisticItem;
    }

    public static StatisticItem m(String str, a2 a2Var) {
        return o(str, a2Var, 0, 0);
    }

    public static StatisticItem n(String str, a2 a2Var, int i) {
        return o(str, a2Var, i, 0);
    }

    public static StatisticItem o(String str, a2 a2Var, int i, int i2) {
        if (a2Var == null) {
            return null;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("tid", a2Var.w1()).param("fid", a2Var.c0()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", a2Var.D2() ? 1 : 0);
        if (i != 0) {
            statisticItem.param("obj_locate", i);
        }
        if (i2 != 0) {
            statisticItem.param("obj_type", i2);
        }
        if (str == "c13696" && a2Var.T() != null) {
            statisticItem.param(TiebaStatic.Params.IS_FOLLOW, a2Var.T().getIsLike() ? 1 : 0);
        }
        if (BdLog.isDebugMode()) {
            Log.d("CardSimpleStatisticItem", statisticItem.toString());
        }
        return statisticItem;
    }

    public static String p(boolean z, String str, boolean z2, String str2, String str3, BaijiahaoData baijiahaoData) {
        return z ? str : z2 ? str2 : (baijiahaoData == null || TextUtils.isEmpty(baijiahaoData.oriUgcNid)) ? str3 : baijiahaoData.oriUgcNid;
    }

    public static StatisticItem q(boolean z, a2 a2Var, String str, String str2, int i, int i2, boolean z2, String str3, String str4, boolean z3, String str5, int i3) {
        StatisticItem statisticItem = new StatisticItem(str2);
        statisticItem.param("page_type", str).param(TiebaStatic.Params.OBJ_FLOOR, i2).param(TiebaStatic.Params.OBJ_ISAD, z2 ? 1 : 0).param("obj_id", p(z2, str3, z3, str5, a2Var.o0(), a2Var.V())).param("tid", a2Var.w1()).param("thread_type", z2 ? -1 : a2Var.s1()).param(TiebaStatic.Params.OBJ_AD_LOCATE, i3).param("nid", a2Var.L0());
        if (!k.isEmpty(a2Var.W0())) {
            statisticItem.param("list_strategy", a2Var.W0());
        }
        if (str != null && f53648a.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null && !StringUtils.isNull(TbadkCoreApplication.getInst().getAdAdSense().r)) {
            statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().r);
        } else if (!k.isEmpty(a2Var.T0)) {
            statisticItem.param("ab_tag", a2Var.T0);
        }
        if (z) {
            statisticItem.param("obj_locate", i);
        }
        if (a2Var.c0() > 0) {
            statisticItem.param("fid", a2Var.c0());
        }
        if (!StringUtils.isNull(a2Var.d0())) {
            statisticItem.param(TiebaStatic.Params.FIRST_DIR, a2Var.d0());
        }
        if (!StringUtils.isNull(a2Var.d1())) {
            statisticItem.param(TiebaStatic.Params.SECOND_DIR, a2Var.d1());
        }
        if (a2Var.V() != null) {
            statisticItem.param(TiebaStatic.Params.UGC_VID, a2Var.V().oriUgcVid);
            statisticItem.param(TiebaStatic.Params.UGC_NID, a2Var.V().oriUgcNid);
        }
        if (!StringUtils.isNull(str4)) {
            statisticItem.param("pid", str4);
        }
        statisticItem.param(TiebaStatic.Params.IS_ZP, a2Var.D2() ? 1 : 0);
        return statisticItem;
    }
}
