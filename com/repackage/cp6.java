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
public class cp6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, hk8 hk8Var) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, hk8Var) == null) || hk8Var == null) {
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
        ik8 ik8Var = hk8Var.f;
        if (ik8Var != null) {
            ho5.b(ik8Var.b, ik8Var.c, "1191003700000000", ik8Var.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(hk8Var.d)) {
                str = hk8Var.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = hk8Var.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        br6.a(tbPageContext, hk8Var.e);
    }

    public static void c(hk8 hk8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, hk8Var) == null) || hk8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", hk8Var.g);
        statisticItem.param("obj_type", hk8Var.f == null ? 1 : 2);
        statisticItem.param("obj_locate", hk8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        ik8 ik8Var = hk8Var.f;
        String str = ik8Var != null ? ik8Var.c : hk8Var.d;
        ik8 ik8Var2 = hk8Var.f;
        if (ik8Var2 != null) {
            String str2 = ik8Var2.a;
        } else {
            String str3 = hk8Var.c;
        }
        statisticItem.param("obj_name", hk8Var.c);
        statisticItem.param("obj_param1", hk8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(hk8Var.i, 1));
    }

    public static void d(hk8 hk8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, hk8Var) == null) || hk8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", hk8Var.g);
        statisticItem.param("obj_type", hk8Var.f == null ? 1 : 2);
        statisticItem.param("obj_locate", hk8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        ik8 ik8Var = hk8Var.f;
        String str = ik8Var != null ? ik8Var.c : hk8Var.d;
        ik8 ik8Var2 = hk8Var.f;
        if (ik8Var2 != null) {
            String str2 = ik8Var2.a;
        } else {
            String str3 = hk8Var.c;
        }
        statisticItem.param("obj_name", hk8Var.c);
        statisticItem.param("obj_param1", hk8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(hk8Var.i, 0));
    }
}
