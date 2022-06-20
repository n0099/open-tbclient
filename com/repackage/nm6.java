package com.repackage;

import android.content.Context;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class nm6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, zg8 zg8Var) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, zg8Var) == null) || zg8Var == null) {
            return;
        }
        TbPageContext<BaseFragmentActivity> tbPageContext = null;
        if (context instanceof BaseActivity) {
            tbPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            tbPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
        if (tbPageContext == null) {
            return;
        }
        ah8 ah8Var = zg8Var.f;
        if (ah8Var != null) {
            ml5.b(ah8Var.b, ah8Var.c, "1191003700000000", ah8Var.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(zg8Var.d)) {
                str = zg8Var.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = zg8Var.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        vo6.a(tbPageContext, zg8Var.e);
    }

    public static void c(zg8 zg8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, zg8Var) == null) || zg8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", zg8Var.g);
        statisticItem.param("obj_type", zg8Var.f == null ? 1 : 2);
        statisticItem.param("obj_locate", zg8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        ah8 ah8Var = zg8Var.f;
        String str = ah8Var != null ? ah8Var.c : zg8Var.d;
        ah8 ah8Var2 = zg8Var.f;
        if (ah8Var2 != null) {
            String str2 = ah8Var2.a;
        } else {
            String str3 = zg8Var.c;
        }
        statisticItem.param("obj_name", zg8Var.c);
        statisticItem.param("obj_param1", zg8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(zg8Var.i, 1));
    }

    public static void d(zg8 zg8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, zg8Var) == null) || zg8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", zg8Var.g);
        statisticItem.param("obj_type", zg8Var.f == null ? 1 : 2);
        statisticItem.param("obj_locate", zg8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        ah8 ah8Var = zg8Var.f;
        String str = ah8Var != null ? ah8Var.c : zg8Var.d;
        ah8 ah8Var2 = zg8Var.f;
        if (ah8Var2 != null) {
            String str2 = ah8Var2.a;
        } else {
            String str3 = zg8Var.c;
        }
        statisticItem.param("obj_name", zg8Var.c);
        statisticItem.param("obj_param1", zg8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(zg8Var.i, 0));
    }
}
