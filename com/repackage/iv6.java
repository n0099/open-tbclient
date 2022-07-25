package com.repackage;

import android.view.View;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class iv6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(View view2, Object obj, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65536, null, view2, obj, i, str) == null) {
            if (obj instanceof yv6) {
                yv6 yv6Var = (yv6) obj;
                if (yv6Var.e) {
                    StatisticItem statisticItem = new StatisticItem("c13736");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.eventStat();
                    return;
                }
                StatisticItem statisticItem2 = new StatisticItem("c13735");
                statisticItem2.param("obj_locate", str);
                statisticItem2.param("topic_id", yv6Var.a);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.eventStat();
            } else if (obj instanceof aw6) {
                ThreadData threadData = ((aw6) obj).f;
                StatisticItem statisticItem3 = new StatisticItem("c13738");
                statisticItem3.param("obj_type", str);
                statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                if (threadData != null) {
                    statisticItem3.param("tid", threadData.getTid());
                    statisticItem3.param("fid", threadData.getFid());
                }
                statisticItem3.eventStat();
            } else if (obj instanceof on4) {
                d(view2);
                if (c(view2)) {
                    ThreadData threadData2 = ((on4) obj).getThreadData();
                    StatisticItem statisticItem4 = new StatisticItem("c13738");
                    statisticItem4.param("obj_type", str);
                    statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (threadData2 != null) {
                        statisticItem4.param("tid", threadData2.getTid());
                        statisticItem4.param("fid", threadData2.getFid());
                    }
                    statisticItem4.eventStat();
                }
            }
        }
    }

    public static void b(View view2, Object obj, String str) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, view2, obj, str) == null) {
            StatisticItem statisticItem = new StatisticItem("c13825");
            statisticItem.param("obj_type", str);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            if (obj instanceof aw6) {
                threadData = ((aw6) obj).f;
            } else {
                threadData = obj instanceof on4 ? ((on4) obj).getThreadData() : null;
            }
            if (threadData != null) {
                statisticItem.param("tid", threadData.getTid());
                statisticItem.param("fid", threadData.getFid());
            }
            statisticItem.eventStat();
        }
    }

    public static boolean c(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            int id = view2.getId();
            return id == R.id.obfuscated_res_0x7f09202e || id == R.id.obfuscated_res_0x7f092042;
        }
        return invokeL.booleanValue;
    }

    public static void d(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, view2) == null) && (view2 instanceof TbImageView)) {
            new StatisticItem("c14675").addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam(TiebaStatic.Params.OBJ_TO, UbsABTestHelper.isImgClickToPb() ? 1 : 2).eventStat();
        }
    }
}
