package com.repackage;

import android.content.Context;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.TiebaPlusInfo;
/* loaded from: classes6.dex */
public class ie5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, bg8 bg8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, bg8Var)) == null) {
            if (context == null || bg8Var == null || !bg8Var.b()) {
                return false;
            }
            TiePlusHelper tiePlusHelper = new TiePlusHelper(context);
            TiebaPlusInfo a = bg8Var.a();
            if (a == null) {
                return false;
            }
            tiePlusHelper.F(a.app_id);
            tiePlusHelper.G(a.title);
            tiePlusHelper.L(true);
            tiePlusHelper.K(a.download_url);
            tiePlusHelper.N(a.app_package);
            tiePlusHelper.O(a.app_power);
            tiePlusHelper.P(a.app_privacy);
            ze5 ze5Var = new ze5(context, tiePlusHelper, true);
            tiePlusHelper.J(ze5Var);
            ItemData itemData = new ItemData();
            itemData.parseProto(a);
            tiePlusHelper.M(itemData);
            ze5Var.f(a.app_company);
            ze5Var.g(a.app_icon);
            ze5Var.h(a.title);
            ze5Var.i(a.app_version);
            ze5Var.show();
            return true;
        }
        return invokeLL.booleanValue;
    }
}
