package com.repackage;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class tl9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ql9 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (!RomUtils.MANUFACTURER_HUAWEI.equalsIgnoreCase(Build.MANUFACTURER) || Build.VERSION.SDK_INT < 23) {
                return null;
            }
            nl9 nl9Var = new nl9(context);
            try {
                try {
                    Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
                    intent.setPackage("com.huawei.hwid");
                    if (context.bindService(intent, nl9Var, 1)) {
                        com.win.opensdk.a aVar = (com.win.opensdk.a) com.win.opensdk.b.a(nl9Var.a());
                        return new ql9(aVar.a(), aVar.b());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            } finally {
                context.unbindService(nl9Var);
            }
        }
        return (ql9) invokeL.objValue;
    }
}
