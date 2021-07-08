package d.a.p0.g3;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.c.e.p.k;
import d.a.o0.r.q.b2;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f56565a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1571718669, "Ld/a/p0/g3/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1571718669, "Ld/a/p0/g3/a;");
                return;
            }
        }
        f56565a = Arrays.asList("a006", "a005", "a008", "a002");
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return "enterfourm_att_" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return "enterfourm_rec_" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str, String str2, String str3, BaijiahaoData baijiahaoData) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, str, str2, str3, baijiahaoData)) == null) {
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
        return (String) invokeLLLL.objValue;
    }

    public static StatisticItem d(b2 b2Var, String str, String str2, int i2, int i3, boolean z, String str3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{b2Var, str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), str3, str4})) == null) ? q(true, b2Var, str, str2, i2, i3, z, str3, str4, false, "", 0) : (StatisticItem) invokeCommon.objValue;
    }

    public static StatisticItem e(b2 b2Var, String str, String str2, int i2, int i3, boolean z, String str3, String str4, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{b2Var, str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), str3, str4, Integer.valueOf(i4)})) == null) {
            if (b2Var == null) {
                return null;
            }
            return q(true, b2Var, str, str2, i2, i3, z, str3, str4, false, "", i4);
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static StatisticItem f(b2 b2Var, String str, String str2, int i2, boolean z, String str3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{b2Var, str, str2, Integer.valueOf(i2), Boolean.valueOf(z), str3, str4})) == null) ? q(false, b2Var, str, str2, -1, i2, z, str3, str4, false, "", 0) : (StatisticItem) invokeCommon.objValue;
    }

    public static StatisticItem g(b2 b2Var, String str, String str2, int i2, boolean z, String str3, String str4, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{b2Var, str, str2, Integer.valueOf(i2), Boolean.valueOf(z), str3, str4, Integer.valueOf(i3)})) == null) {
            if (b2Var == null) {
                return null;
            }
            return q(false, b2Var, str, str2, -1, i2, z, str3, str4, false, "", i3);
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static StatisticItem h(String str, String str2, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) ? i(str, str2, z, i2, 0) : (StatisticItem) invokeCommon.objValue;
    }

    public static StatisticItem i(String str, String str2, boolean z, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            StatisticItem statisticItem = new StatisticItem(str2);
            statisticItem.param("page_type", str).param("ad_exp", z ? 1 : 0).param("ad_exp_cnt", i2).param(TiebaStatic.Params.OBJ_FLOOR, 0).param(TiebaStatic.Params.OBJ_AD_LOCATE, i3);
            if (str != null && f56565a.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
                statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().r);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static StatisticItem j(b2 b2Var, String str, String str2, int i2, int i3, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{b2Var, str, str2, Integer.valueOf(i2), Integer.valueOf(i3), str3})) == null) {
            if (b2Var == null) {
                return null;
            }
            return q(true, b2Var, str, str2, i2, i3, false, "", null, true, str3, 0);
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static StatisticItem k(b2 b2Var, String str, String str2, int i2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{b2Var, str, str2, Integer.valueOf(i2), str3})) == null) {
            if (b2Var == null) {
                return null;
            }
            return q(false, b2Var, str, str2, -1, i2, false, "", null, true, str3, 0);
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static StatisticItem l(boolean z, String str, String str2, int i2, int i3, boolean z2, String str3, String str4, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Boolean.valueOf(z), str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), str3, str4, Integer.valueOf(i4)})) == null) {
            StatisticItem statisticItem = new StatisticItem(str2);
            StatisticItem param = statisticItem.param("page_type", str).param(TiebaStatic.Params.OBJ_FLOOR, i3).param(TiebaStatic.Params.OBJ_ISAD, z2 ? 1 : 0);
            if (!z2) {
                str3 = str4;
            }
            param.param("obj_id", str3).param(TiebaStatic.Params.OBJ_AD_LOCATE, i4);
            if (str != null && f56565a.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
                statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().r);
            }
            if (z) {
                statisticItem.param("obj_locate", i2);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static StatisticItem m(String str, b2 b2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, str, b2Var)) == null) ? o(str, b2Var, 0, 0) : (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem n(String str, b2 b2Var, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65550, null, str, b2Var, i2)) == null) ? o(str, b2Var, i2, 0) : (StatisticItem) invokeLLI.objValue;
    }

    public static StatisticItem o(String str, b2 b2Var, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65551, null, str, b2Var, i2, i3)) == null) {
            if (b2Var == null) {
                return null;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("tid", b2Var.n1()).param("fid", b2Var.Q()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", b2Var.u2() ? 1 : 0);
            if (i2 != 0) {
                statisticItem.param("obj_locate", i2);
            }
            if (i3 != 0) {
                statisticItem.param("obj_type", i3);
            }
            if (str == "c13696" && b2Var.H() != null) {
                statisticItem.param(TiebaStatic.Params.IS_FOLLOW, b2Var.H().getIsLike() ? 1 : 0);
            }
            if (BdLog.isDebugMode()) {
                Log.d("CardSimpleStatisticItem", statisticItem.toString());
            }
            return statisticItem;
        }
        return (StatisticItem) invokeLLII.objValue;
    }

    public static String p(boolean z, String str, boolean z2, String str2, String str3, BaijiahaoData baijiahaoData) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2), str2, str3, baijiahaoData})) == null) ? z ? str : z2 ? str2 : (baijiahaoData == null || TextUtils.isEmpty(baijiahaoData.oriUgcNid)) ? str3 : baijiahaoData.oriUgcNid : (String) invokeCommon.objValue;
    }

    public static StatisticItem q(boolean z, b2 b2Var, String str, String str2, int i2, int i3, boolean z2, String str3, String str4, boolean z3, String str5, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{Boolean.valueOf(z), b2Var, str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), str3, str4, Boolean.valueOf(z3), str5, Integer.valueOf(i4)})) == null) {
            StatisticItem statisticItem = new StatisticItem(str2);
            statisticItem.param("page_type", str).param(TiebaStatic.Params.OBJ_FLOOR, i3).param(TiebaStatic.Params.OBJ_ISAD, z2 ? 1 : 0).param("obj_id", p(z2, str3, z3, str5, b2Var.c0(), b2Var.J())).param("tid", b2Var.n1()).param("thread_type", z2 ? -1 : b2Var.j1()).param(TiebaStatic.Params.OBJ_AD_LOCATE, i4).param("nid", b2Var.A0());
            if (!k.isEmpty(b2Var.M0())) {
                statisticItem.param("list_strategy", b2Var.M0());
            }
            if (str != null && f56565a.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null && !StringUtils.isNull(TbadkCoreApplication.getInst().getAdAdSense().r)) {
                statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().r);
            } else if (!k.isEmpty(b2Var.V0)) {
                statisticItem.param("ab_tag", b2Var.V0);
            }
            if (z) {
                statisticItem.param("obj_locate", i2);
            }
            if (b2Var.Q() > 0) {
                statisticItem.param("fid", b2Var.Q());
            }
            if (!StringUtils.isNull(b2Var.R())) {
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, b2Var.R());
            }
            if (!StringUtils.isNull(b2Var.T0())) {
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, b2Var.T0());
            }
            if (b2Var.J() != null) {
                statisticItem.param(TiebaStatic.Params.UGC_VID, b2Var.J().oriUgcVid);
                statisticItem.param(TiebaStatic.Params.UGC_NID, b2Var.J().oriUgcNid);
            }
            if (!StringUtils.isNull(str4)) {
                statisticItem.param("pid", str4);
            }
            statisticItem.param(TiebaStatic.Params.IS_ZP, b2Var.u2() ? 1 : 0);
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }
}
