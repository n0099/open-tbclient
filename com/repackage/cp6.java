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

    public static void b(Context context, ik8 ik8Var) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, ik8Var) == null) || ik8Var == null) {
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
        jk8 jk8Var = ik8Var.f;
        if (jk8Var != null) {
            ho5.b(jk8Var.b, jk8Var.c, "1191003700000000", jk8Var.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(ik8Var.d)) {
                str = ik8Var.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = ik8Var.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        cr6.a(tbPageContext, ik8Var.e);
    }

    public static void c(ik8 ik8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, ik8Var) == null) || ik8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", ik8Var.g);
        statisticItem.param("obj_type", ik8Var.f == null ? 1 : 2);
        statisticItem.param("obj_locate", ik8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        jk8 jk8Var = ik8Var.f;
        String str = jk8Var != null ? jk8Var.c : ik8Var.d;
        jk8 jk8Var2 = ik8Var.f;
        if (jk8Var2 != null) {
            String str2 = jk8Var2.a;
        } else {
            String str3 = ik8Var.c;
        }
        statisticItem.param("obj_name", ik8Var.c);
        statisticItem.param("obj_param1", ik8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(ik8Var.i, 1));
    }

    public static void d(ik8 ik8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, ik8Var) == null) || ik8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", ik8Var.g);
        statisticItem.param("obj_type", ik8Var.f == null ? 1 : 2);
        statisticItem.param("obj_locate", ik8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        jk8 jk8Var = ik8Var.f;
        String str = jk8Var != null ? jk8Var.c : ik8Var.d;
        jk8 jk8Var2 = ik8Var.f;
        if (jk8Var2 != null) {
            String str2 = jk8Var2.a;
        } else {
            String str3 = ik8Var.c;
        }
        statisticItem.param("obj_name", ik8Var.c);
        statisticItem.param("obj_param1", ik8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(ik8Var.i, 0));
    }
}
