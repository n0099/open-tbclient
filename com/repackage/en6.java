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
public class en6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, fj8 fj8Var) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, fj8Var) == null) || fj8Var == null) {
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
        gj8 gj8Var = fj8Var.f;
        if (gj8Var != null) {
            vl5.b(gj8Var.b, gj8Var.c, "1191003700000000", gj8Var.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(fj8Var.d)) {
                str = fj8Var.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = fj8Var.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        mp6.a(tbPageContext, fj8Var.e);
    }

    public static void c(fj8 fj8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, fj8Var) == null) || fj8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", fj8Var.g);
        statisticItem.param("obj_type", fj8Var.f == null ? 1 : 2);
        statisticItem.param("obj_locate", fj8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        gj8 gj8Var = fj8Var.f;
        String str = gj8Var != null ? gj8Var.c : fj8Var.d;
        gj8 gj8Var2 = fj8Var.f;
        if (gj8Var2 != null) {
            String str2 = gj8Var2.a;
        } else {
            String str3 = fj8Var.c;
        }
        statisticItem.param("obj_name", fj8Var.c);
        statisticItem.param("obj_param1", fj8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(fj8Var.i, 1));
    }

    public static void d(fj8 fj8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, fj8Var) == null) || fj8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", fj8Var.g);
        statisticItem.param("obj_type", fj8Var.f == null ? 1 : 2);
        statisticItem.param("obj_locate", fj8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        gj8 gj8Var = fj8Var.f;
        String str = gj8Var != null ? gj8Var.c : fj8Var.d;
        gj8 gj8Var2 = fj8Var.f;
        if (gj8Var2 != null) {
            String str2 = gj8Var2.a;
        } else {
            String str3 = fj8Var.c;
        }
        statisticItem.param("obj_name", fj8Var.c);
        statisticItem.param("obj_param1", fj8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(fj8Var.i, 0));
    }
}
