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
public class kl6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, gg8 gg8Var) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, gg8Var) == null) || gg8Var == null) {
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
        hg8 hg8Var = gg8Var.f;
        if (hg8Var != null) {
            pk5.b(hg8Var.b, hg8Var.c, "1191003700000000", hg8Var.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(gg8Var.d)) {
                str = gg8Var.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = gg8Var.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        sn6.a(tbPageContext, gg8Var.e);
    }

    public static void c(gg8 gg8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, gg8Var) == null) || gg8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", gg8Var.g);
        statisticItem.param("obj_type", gg8Var.f == null ? 1 : 2);
        statisticItem.param("obj_locate", gg8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        hg8 hg8Var = gg8Var.f;
        String str = hg8Var != null ? hg8Var.c : gg8Var.d;
        hg8 hg8Var2 = gg8Var.f;
        if (hg8Var2 != null) {
            String str2 = hg8Var2.a;
        } else {
            String str3 = gg8Var.c;
        }
        statisticItem.param("obj_name", gg8Var.c);
        statisticItem.param("obj_param1", gg8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(gg8Var.i, 1));
    }

    public static void d(gg8 gg8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, gg8Var) == null) || gg8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", gg8Var.g);
        statisticItem.param("obj_type", gg8Var.f == null ? 1 : 2);
        statisticItem.param("obj_locate", gg8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        hg8 hg8Var = gg8Var.f;
        String str = hg8Var != null ? hg8Var.c : gg8Var.d;
        hg8 hg8Var2 = gg8Var.f;
        if (hg8Var2 != null) {
            String str2 = hg8Var2.a;
        } else {
            String str3 = gg8Var.c;
        }
        statisticItem.param("obj_name", gg8Var.c);
        statisticItem.param("obj_param1", gg8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(gg8Var.i, 0));
    }
}
