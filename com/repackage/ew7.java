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
/* loaded from: classes5.dex */
public class ew7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(kp7 kp7Var, PostData postData, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65536, null, kp7Var, postData, i, i2) == null) {
            c(kp7Var, postData, postData != null ? postData.I() : null, i, i2);
        }
    }

    public static void b(kp7 kp7Var, PostData postData, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{kp7Var, postData, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || kp7Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        h(statisticItem, kp7Var, postData, i, i2, false, postData != null ? postData.I() : null);
        statisticItem.param("obj_locate", i3);
        TiebaStatic.log(statisticItem);
    }

    public static void c(kp7 kp7Var, PostData postData, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{kp7Var, postData, str, Integer.valueOf(i), Integer.valueOf(i2)}) == null) || kp7Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        h(statisticItem, kp7Var, postData, i, i2, false, str);
        TiebaStatic.log(statisticItem);
    }

    public static void d(BdUniqueId bdUniqueId, kp7 kp7Var, PostData postData, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{bdUniqueId, kp7Var, postData, Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            String I = postData != null ? postData.I() : null;
            f(bdUniqueId, kp7Var, postData, I, I, i, i2);
        }
    }

    public static void e(BdUniqueId bdUniqueId, kp7 kp7Var, PostData postData, int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{bdUniqueId, kp7Var, postData, Integer.valueOf(i), Integer.valueOf(i2), str}) == null) {
            String I = postData != null ? postData.I() : null;
            g(bdUniqueId, kp7Var, postData, I, I, i, i2, str);
        }
    }

    public static void f(BdUniqueId bdUniqueId, kp7 kp7Var, PostData postData, String str, String str2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{bdUniqueId, kp7Var, postData, str, str2, Integer.valueOf(i), Integer.valueOf(i2)}) == null) || bdUniqueId == null || kp7Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_exp");
        h(statisticItem, kp7Var, postData, i, i2, false, str);
        bf8.g().d(bdUniqueId, str2, statisticItem);
    }

    public static void g(BdUniqueId bdUniqueId, kp7 kp7Var, PostData postData, String str, String str2, int i, int i2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{bdUniqueId, kp7Var, postData, str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3}) == null) || bdUniqueId == null || kp7Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_exp");
        h(statisticItem, kp7Var, postData, i, i2, false, str);
        statisticItem.param("common_exp_source_pb_comment", str3);
        bf8.g().d(bdUniqueId, str2, statisticItem);
    }

    public static StatisticItem h(StatisticItem statisticItem, kp7 kp7Var, PostData postData, int i, int i2, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{statisticItem, kp7Var, postData, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), str})) == null) {
            if (kp7Var == null) {
                return statisticItem;
            }
            StatisticItem param = statisticItem.param("page_type", "a005").param(TiebaStatic.Params.OBJ_FLOOR, i).param(TiebaStatic.Params.OBJ_ISAD, z ? 1 : 0);
            StatisticItem param2 = param.param("fid", kp7Var.m() + "");
            StatisticItem param3 = param2.param("tid", kp7Var.Q() + "");
            param3.param("obj_id", str + "").param(TiebaStatic.Params.POST_TYPE, i2);
            if (postData != null) {
                statisticItem.param("pid", postData.I() + "");
            }
            if (kp7Var.O() != null) {
                statisticItem.param("thread_type", kp7Var.O().threadType);
                BaijiahaoData baijiahaoData = kp7Var.O().getBaijiahaoData();
                if (baijiahaoData != null) {
                    statisticItem.param(TiebaStatic.Params.UGC_NID, baijiahaoData.oriUgcNid);
                    statisticItem.param(TiebaStatic.Params.UGC_VID, baijiahaoData.oriUgcVid);
                    statisticItem.param(TiebaStatic.Params.UGC_TYPE, baijiahaoData.oriUgcType);
                }
            }
            int i3 = 2;
            if (kp7Var.O().isGoods()) {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 1);
            } else if (postData.J() != null) {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 2);
            } else if (re5.u(postData)) {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 4);
            } else {
                statisticItem.param(TiebaStatic.Params.GUA_TYPE, 0);
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().k);
            }
            if (!kp7Var.g0()) {
                int i4 = kp7Var.g;
                if (i4 == 2) {
                    i3 = 1;
                } else if (i4 == 1) {
                    i3 = 3;
                }
                statisticItem.param(TiebaStatic.Params.LIST_ORDER, i3);
            }
            if (kp7Var.O() != null) {
                statisticItem.param(TiebaStatic.Params.IS_ZP, kp7Var.O().isWorksInfo() ? 1 : 0);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static StatisticItem i(kp7 kp7Var, PostData postData, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{kp7Var, postData, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (kp7Var == null) {
                return null;
            }
            StatisticItem statisticItem = new StatisticItem("common_click");
            h(statisticItem, kp7Var, postData, i, i2, false, postData != null ? postData.I() : null);
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
                if (absPbActivity.getPbModel() != null && absPbActivity.getPbModel().P1() != null) {
                    return absPbActivity.getPbModel().P1().H();
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void m(om4 om4Var, int i, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65548, null, om4Var, i, tbPageContext) == null) || om4Var == null || om4Var.getThreadData() == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_click");
        if (om4Var.getThreadData().getForumData() != null) {
            statisticItem.param("obj_type", j(om4Var.getThreadData().getForumData().j));
        }
        statisticItem.param("obj_locate", om4Var.getThreadData().floorNum);
        statisticItem.param("tid", om4Var.getThreadData().getTid());
        statisticItem.param("fid", om4Var.getThreadData().getFid());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_source", i);
        statisticItem.param("page_type", "a005");
        statisticItem.param(TiebaStatic.Params.IS_REC, "1");
        statisticItem.param(TiebaStatic.Params.FROM_SOURCE, k(tbPageContext));
        statisticItem.param(TiebaStatic.Params.REC_TYPE, l(tbPageContext));
        TiebaStatic.log(statisticItem);
    }

    public static void n(om4 om4Var, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65549, null, om4Var, tbPageContext) == null) || om4Var == null || om4Var.getThreadData() == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("common_exp");
        if (om4Var.getThreadData().getForumData() != null) {
            statisticItem.param("obj_type", j(om4Var.getThreadData().getForumData().j));
        }
        statisticItem.param("tid", om4Var.getThreadData().getTid());
        statisticItem.param("fid", om4Var.getThreadData().getFid());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("page_type", "a005");
        statisticItem.param(TiebaStatic.Params.IS_REC, "1");
        statisticItem.param(TiebaStatic.Params.FROM_SOURCE, k(tbPageContext));
        statisticItem.param(TiebaStatic.Params.REC_TYPE, l(tbPageContext));
        statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, om4Var.position + 1);
        TiebaStatic.log(statisticItem);
    }
}
