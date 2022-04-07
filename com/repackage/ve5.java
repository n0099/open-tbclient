package com.repackage;

import android.content.Context;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.TiebaPlusInfo;
/* loaded from: classes7.dex */
public class ve5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, wj8 wj8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, wj8Var)) == null) {
            if (context == null || wj8Var == null || !wj8Var.b()) {
                return false;
            }
            TiePlusHelper tiePlusHelper = new TiePlusHelper(context);
            TiebaPlusInfo a = wj8Var.a();
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
            mf5 mf5Var = new mf5(context, tiePlusHelper, true);
            tiePlusHelper.J(mf5Var);
            ItemData itemData = new ItemData();
            itemData.parseProto(a);
            tiePlusHelper.M(itemData);
            mf5Var.f(a.app_company);
            mf5Var.g(a.app_icon);
            mf5Var.h(a.title);
            mf5Var.i(a.app_version);
            mf5Var.show();
            return true;
        }
        return invokeLL.booleanValue;
    }
}
