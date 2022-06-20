package com.repackage;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class am9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static xl9 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (!RomUtils.MANUFACTURER_HUAWEI.equalsIgnoreCase(Build.MANUFACTURER) || Build.VERSION.SDK_INT < 23) {
                return null;
            }
            ul9 ul9Var = new ul9(context);
            try {
                try {
                    Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
                    intent.setPackage("com.huawei.hwid");
                    if (context.bindService(intent, ul9Var, 1)) {
                        com.win.opensdk.a aVar = (com.win.opensdk.a) com.win.opensdk.b.a(ul9Var.a());
                        return new xl9(aVar.a(), aVar.b());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            } finally {
                context.unbindService(ul9Var);
            }
        }
        return (xl9) invokeL.objValue;
    }
}
