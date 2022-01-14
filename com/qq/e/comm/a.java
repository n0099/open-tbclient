package com.qq.e.comm;

import android.content.Context;
import android.content.Intent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kuaishou.weapon.un.s;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0096, code lost:
        com.qq.e.comm.util.GDTLogger.e(java.lang.String.format("Service[%s]需要在AndroidManifest.xml中声明", r4.getName()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00af, code lost:
        r8 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            try {
                String[] strArr = {s.a, "android.permission.ACCESS_NETWORK_STATE", s.f55243d};
                int i2 = 0;
                while (true) {
                    if (i2 >= 3) {
                        z = true;
                        break;
                    }
                    String str = strArr[i2];
                    if (context.checkCallingOrSelfPermission(str) == -1) {
                        GDTLogger.e(String.format("Permission[%s]需要在AndroidManifest.xml中声明", str));
                        z = false;
                        break;
                    }
                    i2++;
                }
                if (z && a(context, Class.forName(CustomPkgConstants.getADActivityName())) && a(context, Class.forName(CustomPkgConstants.getPortraitADActivityName())) && a(context, Class.forName(CustomPkgConstants.getLandscapeADActivityName()))) {
                    Class<?>[] clsArr = {Class.forName(CustomPkgConstants.getDownLoadServiceName())};
                    int i3 = 0;
                    while (true) {
                        if (i3 >= 1) {
                            z2 = true;
                            break;
                        }
                        Class<?> cls = clsArr[i3];
                        Intent intent = new Intent();
                        intent.setClass(context, cls);
                        if (context.getPackageManager().resolveService(intent, 65536) == null) {
                            break;
                        }
                        i3++;
                    }
                    return z2;
                }
                return false;
            } catch (Throwable th) {
                GDTLogger.e("检查AndroidManifest.xml时发生异常", th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean a(Context context, Class<?>... clsArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, clsArr)) == null) {
            for (int i2 = 0; i2 < clsArr.length; i2++) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(context, clsArr[i2]);
                    if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                        GDTLogger.e(String.format("Activity[%s]需要在AndroidManifest.xml中声明", clsArr[i2].getName()));
                        return false;
                    }
                } catch (Throwable th) {
                    GDTLogger.e("检查Activity时发生异常", th);
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
