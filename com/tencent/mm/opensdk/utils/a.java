package com.tencent.mm.opensdk.utils;

import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(Bundle bundle, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, bundle, str)) == null) {
            if (bundle == null) {
                return -1;
            }
            try {
                return bundle.getInt(str, -1);
            } catch (Exception e2) {
                Log.e("MicroMsg.IntentUtil", "getIntExtra exception:" + e2.getMessage());
                return -1;
            }
        }
        return invokeLL.intValue;
    }

    public static String b(Bundle bundle, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bundle, str)) == null) {
            if (bundle == null) {
                return null;
            }
            try {
                return bundle.getString(str);
            } catch (Exception e2) {
                Log.e("MicroMsg.IntentUtil", "getStringExtra exception:" + e2.getMessage());
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }
}
