package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tbclient.FrsPage.CoverImageColor;
import tbclient.FrsPage.VideoImageColor;
/* loaded from: classes6.dex */
public class hq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, fj8 fj8Var, ForumData forumData, int i, String str2) {
        StatisticItem i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, fj8Var, forumData, Integer.valueOf(i), str2}) == null) || (i2 = i(str, fj8Var, forumData, i, str2)) == null) {
            return;
        }
        i2.param("obj_locate", 3);
        TiebaStatic.log(i2);
        if (fj8Var != null) {
            ThirdStatisticHelper.sendReq((String) ListUtils.getItem(fj8Var.k(), 1));
        }
    }

    public static String b(so4 so4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, so4Var, i)) == null) {
            if (so4Var == null) {
                return null;
            }
            List<VideoImageColor> o = so4Var.o();
            if (ListUtils.isEmpty(o)) {
                return null;
            }
            for (int i2 = 0; i2 < o.size(); i2++) {
                if (o.get(i2) != null && i * 10 < o.get(i2).time.intValue()) {
                    int i3 = i2 - 1;
                    int i4 = i3 >= 0 ? i3 : 0;
                    if (o.get(i4) != null) {
                        return o.get(i4).color;
                    }
                    return null;
                }
            }
            if (o.get(o.size() - 1) != null) {
                return o.get(o.size() - 1).color;
            }
            return null;
        }
        return (String) invokeLI.objValue;
    }

    public static String c(FrsViewData frsViewData) {
        InterceptResult invokeL;
        CoverImageColor d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, frsViewData)) == null) {
            if (frsViewData == null || frsViewData.getActivityHeadData() == null) {
                return null;
            }
            ArrayList<so4> b = frsViewData.getActivityHeadData().b();
            so4 so4Var = !ListUtils.isEmpty(b) ? b.get(0) : null;
            if (so4Var == null || (d = so4Var.d()) == null) {
                return null;
            }
            return d.value;
        }
        return (String) invokeL.objValue;
    }

    public static void d(FrsViewData frsViewData, int i, BdUniqueId bdUniqueId) {
        StatisticItem h;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65539, null, frsViewData, i, bdUniqueId) == null) || (h = h("common_click", frsViewData, i)) == null) {
            return;
        }
        wi8.g().c(bdUniqueId, h);
    }

    public static void e(FrsViewData frsViewData, int i, BdUniqueId bdUniqueId) {
        StatisticItem h;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, frsViewData, i, bdUniqueId) == null) || (h = h("common_exp", frsViewData, i)) == null || frsViewData == null || frsViewData.getActivityHeadData() == null || frsViewData.getActivityHeadData().c() == null) {
            return;
        }
        wi8.g().d(bdUniqueId, ui8.c("", frsViewData.getActivityHeadData().c(), "", null), h);
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            int autoPlaySwitch = TbadkCoreApplication.getInst().getAutoPlaySwitch();
            return (autoPlaySwitch != 3 && mi.H()) || (autoPlaySwitch == 2 && mi.x());
        }
        return invokeV.booleanValue;
    }

    public static void g(String str, fj8 fj8Var, ForumData forumData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, null, str, fj8Var, forumData) == null) || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        if (fj8Var != null) {
            int i = 11;
            if (fj8Var.getType() != 1) {
                if (fj8Var.getType() == 2) {
                    i = 12;
                } else if (fj8Var.getType() == 3) {
                    i = 13;
                } else if (fj8Var.getType() == 4) {
                    i = 22;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i);
            statisticItem.param("obj_id", fj8Var.c());
        }
        if (forumData != null) {
            statisticItem.param("fid", forumData.getId()).param("fname", forumData.getName());
        }
        TiebaStatic.log(statisticItem);
    }

    public static StatisticItem h(String str, FrsViewData frsViewData, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65543, null, str, frsViewData, i)) == null) {
            if (frsViewData == null || frsViewData.getForum() == null || TextUtils.isEmpty(frsViewData.getForum().getId()) || frsViewData.getActivityHeadData() == null || TextUtils.isEmpty(frsViewData.getActivityHeadData().c())) {
                return null;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("page_type", "a006").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param("fid", frsViewData.getForum().getId()).param("obj_id", frsViewData.getActivityHeadData().c()).param(TiebaStatic.Params.OBJ_AD_LOCATE, 1).param(TiebaStatic.Params.FIRST_DIR, frsViewData.getForum().getFirst_class()).param(TiebaStatic.Params.SECOND_DIR, frsViewData.getForum().getSecond_class()).param("obj_type", i);
            return statisticItem;
        }
        return (StatisticItem) invokeLLI.objValue;
    }

    public static StatisticItem i(String str, fj8 fj8Var, ForumData forumData, int i, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{str, fj8Var, forumData, Integer.valueOf(i), str2})) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            if (fj8Var != null) {
                int i2 = 11;
                if (fj8Var.getType() != 1) {
                    if (fj8Var.getType() == 2) {
                        i2 = 12;
                    } else if (fj8Var.getType() == 3) {
                        i2 = 13;
                    } else if (fj8Var.getType() == 4) {
                        i2 = 22;
                    }
                }
                statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
                statisticItem.param("obj_id", fj8Var.c());
                if (fj8Var.getType() == 1) {
                    statisticItem.param("tid", fj8Var.l());
                    statisticItem.param("thread_type", fj8Var.m());
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            if (forumData != null) {
                statisticItem.param("fid", forumData.getId());
                statisticItem.param("fname", forumData.getName());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, forumData.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, forumData.getSecond_class());
            }
            statisticItem.param("obj_type", i);
            if (i == 2 && !StringUtils.isNull(str2)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str2);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static boolean j(fj8 fj8Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, fj8Var, str)) == null) {
            if (fj8Var == null || StringUtils.isNull(fj8Var.p())) {
                return false;
            }
            wt4 k = wt4.k();
            long m = k.m("key_frs_video_ad_last_show_time" + str, 0L);
            if (m >= 0) {
                return !TimeHelper.isSameDay(new Date(m), new Date(System.currentTimeMillis()));
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void k(String str, fj8 fj8Var, ForumData forumData, int i, String str2) {
        StatisticItem i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, fj8Var, forumData, Integer.valueOf(i), str2}) == null) || (i2 = i(str, fj8Var, forumData, i, str2)) == null) {
            return;
        }
        TiebaStatic.log(i2);
        if (fj8Var != null) {
            ThirdStatisticHelper.sendReq((String) ListUtils.getItem(fj8Var.k(), 0));
        }
    }

    public static void l(String str, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, frsViewData) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.OBJ_AD_LOCATE, 1);
            if (frsViewData != null) {
                if (frsViewData.getForum() != null) {
                    statisticItem.param("fid", frsViewData.getForum().getId()).param("fname", frsViewData.getForum().getName());
                }
                if (frsViewData.getActivityHeadData() != null) {
                    statisticItem.param("obj_id", frsViewData.getActivityHeadData().c());
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }
}
