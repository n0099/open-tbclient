package com.repackage;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class b17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, YyExtData yyExtData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, str, yyExtData) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            c(statisticItem, yyExtData);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void b(String str, YyExtData yyExtData, int i, long j, int i2, long j2, long j3, int i3, String str2, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{str, yyExtData, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), str2, Integer.valueOf(i4)}) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", i);
            statisticItem.param("tid", j);
            statisticItem.param("obj_type", i2);
            statisticItem.param(TiebaStatic.Params.STAR_ID, j2);
            statisticItem.param("liveid", j3);
            if (yyExtData != null) {
                c(statisticItem, yyExtData);
                i3 = yyExtData.isYyGame ? 3 : 2;
                str2 = TiebaStatic.YYValues.YY_LIVE;
            }
            statisticItem.param("obj_param1", i3);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str2);
            statisticItem.param("obj_locate", i4);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void c(StatisticItem statisticItem, YyExtData yyExtData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, statisticItem, yyExtData) == null) || yyExtData == null) {
            return;
        }
        statisticItem.param("hdid", TbadkCoreApplication.getInst().getHdid());
        statisticItem.param(TiebaStatic.YYParams.YYSID, yyExtData.mSid);
        statisticItem.param(TiebaStatic.YYParams.YYSID, yyExtData.mSid);
        statisticItem.param(TiebaStatic.YYParams.YYSSID, yyExtData.mSsid);
        statisticItem.param(TiebaStatic.YYParams.YYUID, yyExtData.mYyUid);
        statisticItem.param(TiebaStatic.YYParams.YYLIVEID, 1);
        statisticItem.param("template_id", yyExtData.mTemplateId);
    }
}
