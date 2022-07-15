package com.repackage;

import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class pa0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            String a = ia0.a();
            if (TextUtils.isEmpty(a)) {
                return false;
            }
            return a.equalsIgnoreCase(RomUtils.MANUFACTURER_XIAOMI);
        }
        return invokeV.booleanValue;
    }
}
