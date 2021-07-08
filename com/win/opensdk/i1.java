package com.win.opensdk;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class i1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static h1 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (!RomUtils.MANUFACTURER_HUAWEI.equalsIgnoreCase(Build.MANUFACTURER) || Build.VERSION.SDK_INT < 23) {
                return null;
            }
            g1 g1Var = new g1(context);
            try {
                try {
                    Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
                    intent.setPackage("com.huawei.hwid");
                    if (context.bindService(intent, g1Var, 1)) {
                        a aVar = (a) b.a(g1Var.a());
                        return new h1(aVar.a(), aVar.b());
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return null;
            } finally {
                context.unbindService(g1Var);
            }
        }
        return (h1) invokeL.objValue;
    }
}
