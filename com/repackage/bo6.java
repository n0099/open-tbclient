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
/* loaded from: classes5.dex */
public class bo6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, bk8 bk8Var) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, bk8Var) == null) || bk8Var == null) {
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
        ck8 ck8Var = bk8Var.f;
        if (ck8Var != null) {
            ul5.b(ck8Var.b, ck8Var.c, "1191003700000000", ck8Var.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(bk8Var.d)) {
                str = bk8Var.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = bk8Var.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        jq6.a(tbPageContext, bk8Var.e);
    }

    public static void c(bk8 bk8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, bk8Var) == null) || bk8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", bk8Var.g);
        statisticItem.param("obj_type", bk8Var.f == null ? 1 : 2);
        statisticItem.param("obj_locate", bk8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        ck8 ck8Var = bk8Var.f;
        String str = ck8Var != null ? ck8Var.c : bk8Var.d;
        ck8 ck8Var2 = bk8Var.f;
        if (ck8Var2 != null) {
            String str2 = ck8Var2.a;
        } else {
            String str3 = bk8Var.c;
        }
        statisticItem.param("obj_name", bk8Var.c);
        statisticItem.param("obj_param1", bk8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(bk8Var.i, 1));
    }

    public static void d(bk8 bk8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, bk8Var) == null) || bk8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", bk8Var.g);
        statisticItem.param("obj_type", bk8Var.f == null ? 1 : 2);
        statisticItem.param("obj_locate", bk8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        ck8 ck8Var = bk8Var.f;
        String str = ck8Var != null ? ck8Var.c : bk8Var.d;
        ck8 ck8Var2 = bk8Var.f;
        if (ck8Var2 != null) {
            String str2 = ck8Var2.a;
        } else {
            String str3 = bk8Var.c;
        }
        statisticItem.param("obj_name", bk8Var.c);
        statisticItem.param("obj_param1", bk8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(bk8Var.i, 0));
    }
}
