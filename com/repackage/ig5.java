package com.repackage;

import android.content.Context;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.TiebaPlusInfo;
/* loaded from: classes6.dex */
public class ig5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, ph8 ph8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, ph8Var)) == null) {
            if (context == null || ph8Var == null || !ph8Var.b()) {
                return false;
            }
            TiePlusHelper tiePlusHelper = new TiePlusHelper(context);
            TiebaPlusInfo a = ph8Var.a();
            if (a == null) {
                return false;
            }
            tiePlusHelper.E(a.app_id);
            tiePlusHelper.F(a.title);
            tiePlusHelper.L(true);
            tiePlusHelper.J(a.download_url);
            tiePlusHelper.N(a.app_package);
            tiePlusHelper.O(a.app_power);
            tiePlusHelper.P(a.app_privacy);
            zg5 zg5Var = new zg5(context, tiePlusHelper, true);
            tiePlusHelper.I(zg5Var);
            ItemData itemData = new ItemData();
            itemData.parseProto(a);
            tiePlusHelper.M(itemData);
            zg5Var.f(a.app_company);
            zg5Var.g(a.app_icon);
            zg5Var.h(a.title);
            zg5Var.i(a.app_version);
            zg5Var.show();
            return true;
        }
        return invokeLL.booleanValue;
    }
}
