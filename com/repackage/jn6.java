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
public class jn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, uh8 uh8Var) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, uh8Var) == null) || uh8Var == null) {
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
        vh8 vh8Var = uh8Var.f;
        if (vh8Var != null) {
            pm5.b(vh8Var.b, vh8Var.c, "1191003700000000", vh8Var.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(uh8Var.d)) {
                str = uh8Var.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = uh8Var.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        jp6.a(tbPageContext, uh8Var.e);
    }

    public static void c(uh8 uh8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, uh8Var) == null) || uh8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", uh8Var.g);
        statisticItem.param("obj_type", uh8Var.f == null ? 1 : 2);
        statisticItem.param("obj_locate", uh8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        vh8 vh8Var = uh8Var.f;
        String str = vh8Var != null ? vh8Var.c : uh8Var.d;
        vh8 vh8Var2 = uh8Var.f;
        if (vh8Var2 != null) {
            String str2 = vh8Var2.a;
        } else {
            String str3 = uh8Var.c;
        }
        statisticItem.param("obj_name", uh8Var.c);
        statisticItem.param("obj_param1", uh8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(uh8Var.i, 1));
    }

    public static void d(uh8 uh8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, uh8Var) == null) || uh8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", uh8Var.g);
        statisticItem.param("obj_type", uh8Var.f == null ? 1 : 2);
        statisticItem.param("obj_locate", uh8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        vh8 vh8Var = uh8Var.f;
        String str = vh8Var != null ? vh8Var.c : uh8Var.d;
        vh8 vh8Var2 = uh8Var.f;
        if (vh8Var2 != null) {
            String str2 = vh8Var2.a;
        } else {
            String str3 = uh8Var.c;
        }
        statisticItem.param("obj_name", uh8Var.c);
        statisticItem.param("obj_param1", uh8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(uh8Var.i, 0));
    }
}
