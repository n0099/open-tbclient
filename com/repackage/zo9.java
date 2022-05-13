package com.repackage;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class zo9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static wo9 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (!RomUtils.MANUFACTURER_HUAWEI.equalsIgnoreCase(Build.MANUFACTURER) || Build.VERSION.SDK_INT < 23) {
                return null;
            }
            to9 to9Var = new to9(context);
            try {
                try {
                    Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
                    intent.setPackage("com.huawei.hwid");
                    if (context.bindService(intent, to9Var, 1)) {
                        com.win.opensdk.a aVar = (com.win.opensdk.a) com.win.opensdk.b.a(to9Var.a());
                        return new wo9(aVar.a(), aVar.b());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            } finally {
                context.unbindService(to9Var);
            }
        }
        return (wo9) invokeL.objValue;
    }
}
