package d.a.o0.d3;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.c.e.p.k;
import d.a.n0.r.q.a2;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f56536a = Arrays.asList("a006", "a005", "a008", "a002");

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

    public static StatisticItem d(a2 a2Var, String str, String str2, int i2, int i3, boolean z, String str3, String str4) {
        return q(true, a2Var, str, str2, i2, i3, z, str3, str4, false, "", 0);
    }

    public static StatisticItem e(a2 a2Var, String str, String str2, int i2, int i3, boolean z, String str3, String str4, int i4) {
        if (a2Var == null) {
            return null;
        }
        return q(true, a2Var, str, str2, i2, i3, z, str3, str4, false, "", i4);
    }

    public static StatisticItem f(a2 a2Var, String str, String str2, int i2, boolean z, String str3, String str4) {
        return q(false, a2Var, str, str2, -1, i2, z, str3, str4, false, "", 0);
    }

    public static StatisticItem g(a2 a2Var, String str, String str2, int i2, boolean z, String str3, String str4, int i3) {
        if (a2Var == null) {
            return null;
        }
        return q(false, a2Var, str, str2, -1, i2, z, str3, str4, false, "", i3);
    }

    public static StatisticItem h(String str, String str2, boolean z, int i2) {
        return i(str, str2, z, i2, 0);
    }

    public static StatisticItem i(String str, String str2, boolean z, int i2, int i3) {
        StatisticItem statisticItem = new StatisticItem(str2);
        statisticItem.param("page_type", str).param("ad_exp", z ? 1 : 0).param("ad_exp_cnt", i2).param(TiebaStatic.Params.OBJ_FLOOR, 0).param(TiebaStatic.Params.OBJ_AD_LOCATE, i3);
        if (str != null && f56536a.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().r);
        }
        return statisticItem;
    }

    public static StatisticItem j(a2 a2Var, String str, String str2, int i2, int i3, String str3) {
        if (a2Var == null) {
            return null;
        }
        return q(true, a2Var, str, str2, i2, i3, false, "", null, true, str3, 0);
    }

    public static StatisticItem k(a2 a2Var, String str, String str2, int i2, String str3) {
        if (a2Var == null) {
            return null;
        }
        return q(false, a2Var, str, str2, -1, i2, false, "", null, true, str3, 0);
    }

    public static StatisticItem l(boolean z, String str, String str2, int i2, int i3, boolean z2, String str3, String str4, int i4) {
        StatisticItem statisticItem = new StatisticItem(str2);
        StatisticItem param = statisticItem.param("page_type", str).param(TiebaStatic.Params.OBJ_FLOOR, i3).param(TiebaStatic.Params.OBJ_ISAD, z2 ? 1 : 0);
        if (!z2) {
            str3 = str4;
        }
        param.param("obj_id", str3).param(TiebaStatic.Params.OBJ_AD_LOCATE, i4);
        if (str != null && f56536a.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
            statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().r);
        }
        if (z) {
            statisticItem.param("obj_locate", i2);
        }
        return statisticItem;
    }

    public static StatisticItem m(String str, a2 a2Var) {
        return o(str, a2Var, 0, 0);
    }

    public static StatisticItem n(String str, a2 a2Var, int i2) {
        return o(str, a2Var, i2, 0);
    }

    public static StatisticItem o(String str, a2 a2Var, int i2, int i3) {
        if (a2Var == null) {
            return null;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("tid", a2Var.z1()).param("fid", a2Var.c0()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", a2Var.H2() ? 1 : 0);
        if (i2 != 0) {
            statisticItem.param("obj_locate", i2);
        }
        if (i3 != 0) {
            statisticItem.param("obj_type", i3);
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

    public static StatisticItem q(boolean z, a2 a2Var, String str, String str2, int i2, int i3, boolean z2, String str3, String str4, boolean z3, String str5, int i4) {
        StatisticItem statisticItem = new StatisticItem(str2);
        statisticItem.param("page_type", str).param(TiebaStatic.Params.OBJ_FLOOR, i3).param(TiebaStatic.Params.OBJ_ISAD, z2 ? 1 : 0).param("obj_id", p(z2, str3, z3, str5, a2Var.o0(), a2Var.V())).param("tid", a2Var.z1()).param("thread_type", z2 ? -1 : a2Var.v1()).param(TiebaStatic.Params.OBJ_AD_LOCATE, i4).param("nid", a2Var.M0());
        if (!k.isEmpty(a2Var.Y0())) {
            statisticItem.param("list_strategy", a2Var.Y0());
        }
        if (str != null && f56536a.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null && !StringUtils.isNull(TbadkCoreApplication.getInst().getAdAdSense().r)) {
            statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().r);
        } else if (!k.isEmpty(a2Var.V0)) {
            statisticItem.param("ab_tag", a2Var.V0);
        }
        if (z) {
            statisticItem.param("obj_locate", i2);
        }
        if (a2Var.c0() > 0) {
            statisticItem.param("fid", a2Var.c0());
        }
        if (!StringUtils.isNull(a2Var.d0())) {
            statisticItem.param(TiebaStatic.Params.FIRST_DIR, a2Var.d0());
        }
        if (!StringUtils.isNull(a2Var.f1())) {
            statisticItem.param(TiebaStatic.Params.SECOND_DIR, a2Var.f1());
        }
        if (a2Var.V() != null) {
            statisticItem.param(TiebaStatic.Params.UGC_VID, a2Var.V().oriUgcVid);
            statisticItem.param(TiebaStatic.Params.UGC_NID, a2Var.V().oriUgcNid);
        }
        if (!StringUtils.isNull(str4)) {
            statisticItem.param("pid", str4);
        }
        statisticItem.param(TiebaStatic.Params.IS_ZP, a2Var.H2() ? 1 : 0);
        return statisticItem;
    }
}
