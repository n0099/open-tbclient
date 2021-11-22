package com.kwad.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class InstalledAppInfoManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class AppPackageInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -324393456884895874L;
        public transient /* synthetic */ FieldHolder $fh;
        public String appName;
        public long firstInstallTime;
        public boolean isSystemApp;
        public long lastUpdateTime;
        public String packageName;
        public int reportMethod;
        public String versionName;

        public AppPackageInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.appName = "";
        }
    }

    public static AppPackageInfo a(@NonNull PackageInfo packageInfo, @Nullable PackageManager packageManager) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, packageInfo, packageManager)) == null) {
            AppPackageInfo appPackageInfo = new AppPackageInfo();
            appPackageInfo.packageName = packageInfo.packageName;
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo != null) {
                appPackageInfo.isSystemApp = a(applicationInfo) || b(packageInfo.applicationInfo);
            }
            appPackageInfo.versionName = packageInfo.versionName;
            appPackageInfo.firstInstallTime = packageInfo.firstInstallTime;
            appPackageInfo.lastUpdateTime = packageInfo.lastUpdateTime;
            return appPackageInfo;
        }
        return (AppPackageInfo) invokeLL.objValue;
    }

    @NonNull
    public static JSONArray a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (com.kwad.sdk.core.config.c.a(16L)) {
                return new JSONArray();
            }
            Map<String, AppPackageInfo> b2 = b(context);
            b2.putAll(b(context, com.kwad.sdk.core.config.c.i()));
            return a(b2);
        }
        return (JSONArray) invokeL.objValue;
    }

    @NonNull
    public static JSONArray a(@NonNull Map<String, AppPackageInfo> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, map)) == null) {
            JSONArray jSONArray = new JSONArray();
            try {
                for (String str : map.keySet()) {
                    AppPackageInfo appPackageInfo = map.get(str);
                    if (appPackageInfo != null && !TextUtils.isEmpty(appPackageInfo.packageName)) {
                        q.a(jSONArray, a(appPackageInfo));
                    }
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.b(e2);
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public static JSONObject a(AppPackageInfo appPackageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, appPackageInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            q.a(jSONObject, "pkgName", appPackageInfo.packageName);
            q.a(jSONObject, "system_app", appPackageInfo.isSystemApp ? 1 : 0);
            q.a(jSONObject, "appVersion", appPackageInfo.versionName);
            q.a(jSONObject, "firstInstallTime", appPackageInfo.firstInstallTime);
            q.a(jSONObject, "lastUpdateTime", appPackageInfo.lastUpdateTime);
            q.a(jSONObject, "reportMethod", appPackageInfo.reportMethod);
            q.a(jSONObject, "appName", appPackageInfo.appName);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static boolean a(ApplicationInfo applicationInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, applicationInfo)) == null) ? (applicationInfo.flags & 1) != 0 : invokeL.booleanValue;
    }

    @NonNull
    public static JSONArray[] a(Context context, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, list)) == null) {
            JSONArray[] jSONArrayArr = new JSONArray[2];
            if (context != null && list != null && !list.isEmpty()) {
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                for (String str : list) {
                    try {
                        PackageManager packageManager = context.getPackageManager();
                        PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                        if (packageInfo != null) {
                            AppPackageInfo a2 = a(packageInfo, packageManager);
                            hashMap.put(a2.packageName, a2);
                        } else {
                            AppPackageInfo appPackageInfo = new AppPackageInfo();
                            appPackageInfo.packageName = str;
                            hashMap2.put(str, appPackageInfo);
                        }
                    } catch (Exception unused) {
                        AppPackageInfo appPackageInfo2 = new AppPackageInfo();
                        appPackageInfo2.packageName = str;
                        hashMap2.put(str, appPackageInfo2);
                    }
                }
                jSONArrayArr[0] = a(hashMap);
                jSONArrayArr[1] = a(hashMap2);
            }
            return jSONArrayArr;
        }
        return (JSONArray[]) invokeLL.objValue;
    }

    @NonNull
    public static Map<String, AppPackageInfo> b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            HashMap hashMap = new HashMap();
            if (context == null) {
                return hashMap;
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
                intent.addCategory("android.intent.category.LAUNCHER");
                List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 32);
                List<String> b2 = f.b(context);
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    if (resolveInfo != null && resolveInfo.activityInfo != null && !TextUtils.isEmpty(resolveInfo.activityInfo.packageName)) {
                        String str = resolveInfo.activityInfo.packageName;
                        if (b2 != null && !b2.isEmpty()) {
                            b2.remove(str);
                        }
                        PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                        if (packageInfo != null) {
                            AppPackageInfo a2 = a(packageInfo, packageManager);
                            a2.reportMethod = 1;
                            hashMap.put(a2.packageName, a2);
                        }
                    }
                }
                if (b2 != null && !b2.isEmpty()) {
                    for (String str2 : b2) {
                        try {
                            PackageInfo packageInfo2 = packageManager.getPackageInfo(str2, 0);
                            if (packageInfo2 != null) {
                                AppPackageInfo a3 = a(packageInfo2, packageManager);
                                a3.reportMethod = 2;
                                hashMap.put(a3.packageName, a3);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            } catch (Exception unused2) {
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    @NonNull
    public static Map<String, AppPackageInfo> b(Context context, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, list)) == null) {
            HashMap hashMap = new HashMap();
            if (context != null && list != null) {
                for (String str : list) {
                    try {
                        PackageManager packageManager = context.getPackageManager();
                        PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                        if (packageInfo != null) {
                            AppPackageInfo a2 = a(packageInfo, packageManager);
                            hashMap.put(a2.packageName, a2);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public static boolean b(ApplicationInfo applicationInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, applicationInfo)) == null) ? (applicationInfo.flags & 128) != 0 : invokeL.booleanValue;
    }
}
