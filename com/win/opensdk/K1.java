package com.win.opensdk;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public class K1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static J1 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (!RomUtils.MANUFACTURER_HUAWEI.equalsIgnoreCase(Build.MANUFACTURER) || Build.VERSION.SDK_INT < 23) {
                return null;
            }
            I1 i1 = new I1(context);
            try {
                try {
                    Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
                    intent.setPackage("com.huawei.hwid");
                    if (context.bindService(intent, i1, 1)) {
                        a aVar = (a) b.a(i1.a());
                        return new J1(aVar.a(), aVar.b());
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return null;
            } finally {
                context.unbindService(i1);
            }
        }
        return (J1) invokeL.objValue;
    }
}
