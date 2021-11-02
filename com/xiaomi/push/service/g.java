package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ComponentName a(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, intent)) == null) {
            if (intent != null) {
                try {
                    ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
                    if (resolveActivity != null) {
                        return new ComponentName(resolveActivity.activityInfo.packageName, resolveActivity.activityInfo.name);
                    }
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (ComponentName) invokeLL.objValue;
    }

    public static boolean a(Context context, ComponentName componentName) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, componentName)) == null) {
            try {
                new Intent().setComponent(componentName);
                context.getPackageManager().getActivityInfo(componentName, 128);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            try {
                ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(str, 4).services;
                if (serviceInfoArr != null) {
                    for (ServiceInfo serviceInfo : serviceInfoArr) {
                        if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !context.getPackageName().equals(serviceInfo.packageName)) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            } catch (PackageManager.NameNotFoundException e2) {
                com.xiaomi.channel.commonutils.logger.b.m73a("checkService " + e2);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, str2)) == null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                Intent intent = new Intent(str2);
                intent.setPackage(str);
                List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 32);
                if (queryIntentServices != null) {
                    return !queryIntentServices.isEmpty();
                }
                return false;
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m73a("checkService action: " + str2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + e2);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static boolean b(Context context, String str) {
        InterceptResult invokeLL;
        PackageManager packageManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            boolean z = false;
            try {
                packageManager = context.getPackageManager();
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m73a("checkProvider " + e2);
            }
            if (Build.VERSION.SDK_INT >= 19) {
                List<ProviderInfo> queryContentProviders = packageManager.queryContentProviders(null, 0, 8);
                if (queryContentProviders != null && !queryContentProviders.isEmpty()) {
                    for (ProviderInfo providerInfo : queryContentProviders) {
                        if (providerInfo.enabled && providerInfo.exported && providerInfo.authority.equals(str)) {
                            z = true;
                        }
                    }
                }
                return z;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, context, str, str2)) == null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                Intent intent = new Intent(str2);
                intent.setPackage(str);
                return packageManager.resolveActivity(intent, 65536) != null;
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m73a("checkActivity action: " + str2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + e2);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }
}
