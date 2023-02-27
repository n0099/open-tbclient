package com.huawei.hms.push;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import com.sina.weibo.sdk.utils.ResourceManager;
/* loaded from: classes8.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            int i = context.getApplicationInfo().icon;
            if (i == 0) {
                int identifier = context.getResources().getIdentifier("btn_star_big_on", ResourceManager.DRAWABLE, "android");
                HMSLog.d("PushSelfShowLog", "icon is btn_star_big_on ");
                if (identifier == 0) {
                    HMSLog.d("PushSelfShowLog", "icon is sym_def_app_icon ");
                    return 17301651;
                }
                return identifier;
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static Bitmap a(Context context, k kVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, kVar)) == null) {
            if (context == null || kVar == null) {
                return null;
            }
            try {
                if (HwBuildEx.VERSION.EMUI_SDK_INT >= 11) {
                    HMSLog.i("PushSelfShowLog", "huawei phone, and emui5.0, need not show large icon.");
                    return null;
                } else if ("com.huawei.android.pushagent".equals(kVar.k())) {
                    return null;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("get left bitmap from ");
                    sb.append(kVar.k());
                    HMSLog.i("PushSelfShowLog", sb.toString());
                    return ((BitmapDrawable) context.getPackageManager().getApplicationIcon(kVar.k())).getBitmap();
                }
            } catch (PackageManager.NameNotFoundException unused) {
                HMSLog.e("PushSelfShowLog", "build left icon occur NameNotFoundException.");
                return null;
            } catch (Exception unused2) {
                HMSLog.e("PushSelfShowLog", "build left icon occur Exception.");
                return null;
            }
        }
        return (Bitmap) invokeLL.objValue;
    }

    @TargetApi(23)
    public static void a(Context context, Notification.Builder builder, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, context, builder, kVar) == null) {
            if (context != null && builder != null && kVar != null) {
                builder.setSmallIcon(b(context, kVar));
            } else {
                HMSLog.e("PushSelfShowLog", "msg is null");
            }
        }
    }

    public static int b(Context context, k kVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, kVar)) == null) {
            int i = 0;
            if (context != null && kVar != null) {
                if (!TextUtils.isEmpty(kVar.m())) {
                    String[] split = kVar.m().split("/");
                    if (split.length == 3) {
                        i = r.a(context, split[1], split[2]);
                    }
                }
                if (i == 0) {
                    i = r.a(context, "com.huawei.messaging.default_notification_icon");
                }
                if (i == 0) {
                    return a(context);
                }
                return i;
            }
            HMSLog.i("PushSelfShowLog", "enter getSmallIconId, context or msg is null");
            return 0;
        }
        return invokeLL.intValue;
    }
}
