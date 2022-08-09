package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class i08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ft7 ft7Var, PostData postData, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65536, null, ft7Var, postData, i, i2) == null) {
            c(ft7Var, postData, postData != null ? postData.K() : null, i, i2);
        }
    }

    public static void b(ft7 ft7Var, PostData postData, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{ft7Var, postData, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || ft7Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        h(statisticItem, ft7Var, postData, i, i2, false, postData != null ? postData.K() : null);
        statisticItem.param("obj_locate", i3);
        TiebaStatic.log(statisticItem);
    }

    public static void c(ft7 ft7Var, PostData postData, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{ft7Var, postData, str, Integer.valueOf(i), Integer.valueOf(i2)}) == null) || ft7Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        h(statisticItem, ft7Var, postData, i, i2, false, str);
        TiebaStatic.log(statisticItem);
    }

    public static void d(BdUniqueId bdUniqueId, ft7 ft7Var, PostData postData, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{bdUniqueId, ft7Var, postData, Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            String K = postData != null ? postData.K() : null;
            f(bdUniqueId, ft7Var, postData, K, K, i, i2);
        }
    }

    public static void e(BdUniqueId bdUniqueId, ft7 ft7Var, PostData postData, int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{bdUniqueId, ft7Var, postData, Integer.valueOf(i), Integer.valueOf(i2), str}) == null) {
            String K = postData != null ? postData.K() : null;
            g(bdUniqueId, ft7Var, postData, K, K, i, i2, str);
        }
    }

    public static void f(BdUniqueId bdUniqueId, ft7 ft7Var, PostData postData, String str, String str2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{bdUniqueId, ft7Var, postData, str, str2, Integer.valueOf(i), Integer.valueOf(i2)}) == null) || bdUniqueId == null || ft7Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_exp");
        h(statisticItem, ft7Var, postData, i, i2, false, str);
        dj8.g().d(bdUniqueId, str2, statisticItem);
    }

    public static void g(BdUniqueId bdUniqueId, ft7 ft7Var, PostData postData, String str, String str2, int i, int i2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{bdUniqueId, ft7Var, postData, str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3}) == null) || bdUniqueId == null || ft7Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_exp");
        h(statisticItem, ft7Var, postData, i, i2, false, str);
        statisticItem.param("common_exp_source_pb_comment", str3);
        dj8.g().d(bdUniqueId, str2, statisticItem);
    }

    public static StatisticItem h(StatisticItem statisticItem, ft7 ft7Var, PostData postData, int i, int i2, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{statisticItem, ft7Var, postData, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), str})) == null) {
            if (ft7Var == null) {
                return statisticItem;
            }
            StatisticItem param = statisticItem.param("page_type", "a005").param(TiebaStatic.Params.OBJ_FLOOR, i).param(TiebaStatic.Params.OBJ_ISAD, z ? 1 : 0);
            StatisticItem param2 = param.param("fid", ft7Var.m() + "");
            StatisticItem param3 = param2.param("tid", ft7Var.Q() + "");
            param3.param("obj_id", str + "").param(TiebaStatic.Params.POST_TYPE, i2);
            if (postData != null) {
                statisticItem.param("pid", postData.K() + "");
            }
            if (ft7Var.O() != null) {
                statisticItem.param("thread_type", ft7Var.O().threadType);
                BaijiahaoData baijiahaoData = ft7Var.O().getBaijiahaoData();
                if (baijiahaoData != null) {
                    statisticItem.param(TiebaStatic.Params.UGC_NID, baijiahaoData.oriUgcNid);
                    statisticItem.param(TiebaStatic.Params.UGC_VID, baijiahaoData.oriUgcVid);
                    statisticItem.param(TiebaStatic.Params.UGC_TYPE, baijiahaoData.oriUgcType);
                }
            }
            statisticItem.param(TiebaStatic.Params.IS_UP, ft7Var.U() == null ? 0 : 1);
            if (ft7Var.O().isGoods()) {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 1);
            } else if (postData.O() != null) {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 2);
            } else if (fi5.u(postData)) {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 4);
            } else {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 0);
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().k);
            }
            if (!ft7Var.i0()) {
                int i3 = ft7Var.g;
                statisticItem.param(TiebaStatic.Params.LIST_ORDER, i3 != 2 ? i3 == 1 ? 3 : 2 : 1);
            }
            if (ft7Var.O() != null) {
                statisticItem.param(TiebaStatic.Params.IS_ZP, ft7Var.O().isWorksInfo() ? 1 : 0);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static StatisticItem i(ft7 ft7Var, PostData postData, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{ft7Var, postData, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (ft7Var == null) {
                return null;
            }
            StatisticItem statisticItem = new StatisticItem("common_click");
            h(statisticItem, ft7Var, postData, i, i2, false, postData != null ? postData.K() : null);
            statisticItem.param("obj_locate", i3);
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static int j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if ("游戏".equals(str)) {
                return 1;
            }
            if ("动漫".equals(str)) {
                return 2;
            }
            return "电脑数码".equals(str) ? 3 : 4;
        }
        return invokeL.intValue;
    }

    public static String k(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tbPageContext)) == null) ? (tbPageContext == null || tbPageContext.getPageActivity() == null || tbPageContext.getPageActivity().getIntent() == null) ? "" : tbPageContext.getPageActivity().getIntent().getStringExtra("thread_id") : (String) invokeL.objValue;
    }

    public static int l(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tbPageContext)) == null) {
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && (tbPageContext.getPageActivity() instanceof AbsPbActivity)) {
                AbsPbActivity absPbActivity = (AbsPbActivity) tbPageContext.getPageActivity();
                if (absPbActivity.b1() != null && absPbActivity.b1().Q1() != null) {
                    return absPbActivity.b1().Q1().H();
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void m(fo4 fo4Var, int i, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65548, null, fo4Var, i, tbPageContext) == null) || fo4Var == null || fo4Var.getThreadData() == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        if (fo4Var.getThreadData().getForumData() != null) {
            statisticItem.param("obj_type", j(fo4Var.getThreadData().getForumData().j));
        }
        statisticItem.param("obj_locate", fo4Var.getThreadData().floorNum);
        statisticItem.param("tid", fo4Var.getThreadData().getTid());
        statisticItem.param("fid", fo4Var.getThreadData().getFid());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_source", i);
        statisticItem.param("page_type", "a005");
        statisticItem.param(TiebaStatic.Params.IS_REC, "1");
        statisticItem.param(TiebaStatic.Params.FROM_SOURCE, k(tbPageContext));
        statisticItem.param(TiebaStatic.Params.REC_TYPE, l(tbPageContext));
        TiebaStatic.log(statisticItem);
    }

    public static void n(fo4 fo4Var, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65549, null, fo4Var, tbPageContext) == null) || fo4Var == null || fo4Var.getThreadData() == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_exp");
        if (fo4Var.getThreadData().getForumData() != null) {
            statisticItem.param("obj_type", j(fo4Var.getThreadData().getForumData().j));
        }
        statisticItem.param("tid", fo4Var.getThreadData().getTid());
        statisticItem.param("fid", fo4Var.getThreadData().getFid());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("page_type", "a005");
        statisticItem.param(TiebaStatic.Params.IS_REC, "1");
        statisticItem.param(TiebaStatic.Params.FROM_SOURCE, k(tbPageContext));
        statisticItem.param(TiebaStatic.Params.REC_TYPE, l(tbPageContext));
        statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, fo4Var.position + 1);
        TiebaStatic.log(statisticItem);
    }

    public static void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65550, null, i) == null) {
            StatisticItem statisticItem = new StatisticItem("c14888");
            statisticItem.addParam("obj_locate", i);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, str) == null) {
            TiebaStatic.log(new StatisticItem(str));
        }
    }
}
