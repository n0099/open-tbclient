package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.bk;
/* loaded from: classes8.dex */
public class n {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(78186177, "Lcom/xiaomi/mipush/sdk/n;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(78186177, "Lcom/xiaomi/mipush/sdk/n;");
        }
    }

    public static ag a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                return (context.getPackageManager().getServiceInfo(new ComponentName("com.huawei.hwid", "com.huawei.hms.core.service.HMSCoreService"), 128) == null || !a()) ? ag.f : ag.a;
            } catch (Exception unused) {
                return ag.f;
            }
        }
        return (ag) invokeL.objValue;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                String str = (String) bk.a("android.os.SystemProperties", "get", "ro.build.hw_emui_api_level", "");
                if (!TextUtils.isEmpty(str)) {
                    if (Integer.parseInt(str) >= 9) {
                        return true;
                    }
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m159a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            Object a2 = bk.a(bk.a("com.google.android.gms.common.GoogleApiAvailability", "getInstance", new Object[0]), "isGooglePlayServicesAvailable", context);
            Object a3 = bk.a("com.google.android.gms.common.ConnectionResult", "SUCCESS");
            if (a3 == null || !(a3 instanceof Integer)) {
                com.xiaomi.channel.commonutils.logger.b.c("google service is not avaliable");
                a = 0;
                return false;
            }
            int intValue = ((Integer) Integer.class.cast(a3)).intValue();
            if (a2 != null) {
                if (a2 instanceof Integer) {
                    a = ((Integer) Integer.class.cast(a2)).intValue() == intValue ? 1 : 0;
                } else {
                    a = 0;
                    com.xiaomi.channel.commonutils.logger.b.c("google service is not avaliable");
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("is google service can be used");
            sb.append(a > 0);
            com.xiaomi.channel.commonutils.logger.b.c(sb.toString());
            return a > 0;
        }
        return invokeL.booleanValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            boolean z = false;
            Object a2 = bk.a("com.xiaomi.assemble.control.COSPushManager", "isSupportPush", context);
            if (a2 != null && (a2 instanceof Boolean)) {
                z = ((Boolean) Boolean.class.cast(a2)).booleanValue();
            }
            com.xiaomi.channel.commonutils.logger.b.c("color os push  is avaliable ? :" + z);
            return z;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            boolean z = false;
            Object a2 = bk.a("com.xiaomi.assemble.control.FTOSPushManager", "isSupportPush", context);
            if (a2 != null && (a2 instanceof Boolean)) {
                z = ((Boolean) Boolean.class.cast(a2)).booleanValue();
            }
            com.xiaomi.channel.commonutils.logger.b.c("fun touch os push  is avaliable ? :" + z);
            return z;
        }
        return invokeL.booleanValue;
    }
}
