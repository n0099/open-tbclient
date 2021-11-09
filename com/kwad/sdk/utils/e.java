package com.kwad.sdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.material.internal.ManufacturerUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, String> f66679a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1510835601, "Lcom/kwad/sdk/utils/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1510835601, "Lcom/kwad/sdk/utils/e;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        f66679a = hashMap;
        hashMap.put("HUAWEI", "com.huawei.appmarket");
        f66679a.put("OPPO", "com.oppo.market");
        f66679a.put(RomUtils.MANUFACTURER_VIVO, "com.bbk.appstore");
        f66679a.put(RomUtils.MANUFACTURER_XIAOMI, "com.xiaomi.market");
        f66679a.put("OnePlus", "com.oppo.market");
        f66679a.put("Meizu", "com.meizu.mstore");
        f66679a.put(ManufacturerUtils.SAMSUNG, "com.sec.android.app.samsungapps");
        f66679a.put("SMARTISAN", "com.smartisanos.appstore");
        f66679a.put("Realme", "com.oppo.market");
        f66679a.put("HONOR", "com.huawei.appmarket");
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, str, str2)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return false;
            }
            if (ManufacturerUtils.SAMSUNG.equals(Build.BRAND)) {
                str = "http://apps.samsung.com/appquery/appDetail.as?appId=" + str2;
            }
            try {
                String str3 = f66679a.get(Build.BRAND);
                Intent parseUri = Intent.parseUri(str, 1);
                parseUri.addFlags(268435456);
                for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(parseUri, 0)) {
                    if (!a(resolveInfo)) {
                        String str4 = resolveInfo.activityInfo.packageName;
                        if (str4.equals(str3) || a(str4)) {
                            parseUri.setComponent(new ComponentName(str4, resolveInfo.activityInfo.name));
                            context.startActivity(parseUri);
                            return true;
                        }
                    }
                }
                return a(context, str);
            } catch (Exception unused) {
                return a(context, str);
            }
        }
        return invokeLLL.booleanValue;
    }

    public static boolean a(ResolveInfo resolveInfo) {
        InterceptResult invokeL;
        ActivityInfo activityInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, resolveInfo)) == null) ? resolveInfo == null || (activityInfo = resolveInfo.activityInfo) == null || TextUtils.isEmpty(activityInfo.packageName) : invokeL.booleanValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? "OPPO".equals(Build.BRAND) && "com.heytap.market".equals(str) : invokeL.booleanValue;
    }
}
