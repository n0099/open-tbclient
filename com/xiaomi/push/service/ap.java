package com.xiaomi.push.service;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class ap {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f43581a;

    /* renamed from: a  reason: collision with other field name */
    public static final String[] f897a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1071162519, "Lcom/xiaomi/push/service/ap;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1071162519, "Lcom/xiaomi/push/service/ap;");
                return;
            }
        }
        f897a = new String[]{"com.mi.globalbrowser", "com.android.browser"};
    }

    public static int a(ContentResolver contentResolver) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, contentResolver)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                try {
                    return Settings.Global.getInt(contentResolver, "user_aggregate", 0);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m70a("get user aggregate failed, " + e2);
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) ? com.xiaomi.push.g.b(context, str) : invokeLL.intValue;
    }

    public static String a(Notification notification) {
        InterceptResult invokeL;
        Object a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, notification)) == null) {
            String str = null;
            try {
                if (Build.VERSION.SDK_INT >= 19 && notification.extras != null) {
                    str = notification.extras.getString("target_package");
                }
                return (!TextUtils.isEmpty(str) || (a2 = com.xiaomi.push.bh.a(notification, "extraNotification")) == null) ? str : (String) com.xiaomi.push.bh.a(a2, "getTargetPkg", new Object[0]);
            } catch (Exception unused) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static void a(Notification notification, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65540, null, notification, str) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 19 && notification.extras != null) {
                    notification.extras.putString("target_package", str);
                }
                Object a2 = com.xiaomi.push.bh.a(notification, "extraNotification");
                if (a2 != null) {
                    com.xiaomi.push.bh.a(a2, "setTargetPkg", str);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Context context, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, intent) == null) {
            int i2 = -1;
            while (true) {
                str = i2 < 0 ? f43581a : f897a[i2];
                if (!TextUtils.isEmpty(str)) {
                    intent.setPackage(str);
                    try {
                        if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
                            break;
                        }
                    } catch (Exception e2) {
                        com.xiaomi.channel.commonutils.logger.b.m70a("not found xm browser:" + e2);
                    }
                }
                i2++;
                if (i2 >= f897a.length) {
                    str = null;
                    break;
                }
            }
            intent.setPackage(str);
            f43581a = str;
        }
    }

    public static boolean a(Notification.Builder builder, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(AdIconUtil.BAIDU_LOGO_ID, null, builder, z)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                builder.setGroupAlertBehavior(z ? 2 : 1);
                return true;
            }
            com.xiaomi.channel.commonutils.logger.b.b("not support setGroupAlertBehavior");
            return false;
        }
        return invokeLZ.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m598a(ContentResolver contentResolver) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, contentResolver)) == null) {
            int a2 = a(contentResolver);
            return a2 == 1 || a2 == 2;
        }
        return invokeL.booleanValue;
    }
}
