package com.repackage;

import android.content.Context;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.TiebaPlusInfo;
/* loaded from: classes6.dex */
public class of5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, aj8 aj8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, aj8Var)) == null) {
            if (context == null || aj8Var == null || !aj8Var.b()) {
                return false;
            }
            TiePlusHelper tiePlusHelper = new TiePlusHelper(context);
            TiebaPlusInfo a = aj8Var.a();
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
            fg5 fg5Var = new fg5(context, tiePlusHelper, true);
            tiePlusHelper.J(fg5Var);
            ItemData itemData = new ItemData();
            itemData.parseProto(a);
            tiePlusHelper.M(itemData);
            fg5Var.f(a.app_company);
            fg5Var.g(a.app_icon);
            fg5Var.h(a.title);
            fg5Var.i(a.app_version);
            fg5Var.show();
            return true;
        }
        return invokeLL.booleanValue;
    }
}
