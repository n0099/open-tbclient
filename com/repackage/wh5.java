package com.repackage;

import android.content.Context;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.TiebaPlusInfo;
/* loaded from: classes7.dex */
public class wh5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, ck8 ck8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, ck8Var)) == null) {
            if (context == null || ck8Var == null || !ck8Var.b()) {
                return false;
            }
            TiePlusHelper tiePlusHelper = new TiePlusHelper(context);
            TiebaPlusInfo a = ck8Var.a();
            if (a == null) {
                return false;
            }
            tiePlusHelper.E(a.app_id);
            tiePlusHelper.F(a.title);
            tiePlusHelper.L(true);
            tiePlusHelper.K(a.download_url);
            tiePlusHelper.N(a.app_package);
            tiePlusHelper.O(a.app_power);
            tiePlusHelper.P(a.app_privacy);
            ni5 ni5Var = new ni5(context, tiePlusHelper, true);
            tiePlusHelper.J(ni5Var);
            ItemData itemData = new ItemData();
            itemData.parseProto(a);
            tiePlusHelper.M(itemData);
            ni5Var.f(a.app_company);
            ni5Var.g(a.app_icon);
            ni5Var.h(a.title);
            ni5Var.i(a.app_version);
            ni5Var.show();
            return true;
        }
        return invokeLL.booleanValue;
    }
}
