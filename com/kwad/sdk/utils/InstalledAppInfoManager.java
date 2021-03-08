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
import com.vivo.push.PushClientConstants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class InstalledAppInfoManager {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class AppPackageInfo implements Serializable {
        private static final long serialVersionUID = -324393456884895874L;
        public String appName;
        public long firstInstallTime;
        public boolean isSystemApp;
        public long lastUpdateTime;
        public String packageName;
        public int reportMethod;
        public String versionName;
    }

    public static AppPackageInfo a(@NonNull PackageInfo packageInfo, @Nullable PackageManager packageManager) {
        AppPackageInfo appPackageInfo = new AppPackageInfo();
        appPackageInfo.packageName = packageInfo.packageName;
        if (packageInfo.applicationInfo != null) {
            appPackageInfo.isSystemApp = a(packageInfo.applicationInfo) || b(packageInfo.applicationInfo);
        }
        appPackageInfo.versionName = packageInfo.versionName;
        appPackageInfo.firstInstallTime = packageInfo.firstInstallTime;
        appPackageInfo.lastUpdateTime = packageInfo.lastUpdateTime;
        if (packageManager != null && packageInfo.applicationInfo != null) {
            try {
                appPackageInfo.appName = packageManager.getApplicationLabel(packageInfo.applicationInfo).toString();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
            }
        }
        return appPackageInfo;
    }

    @NonNull
    public static JSONArray a(Context context) {
        Map<String, AppPackageInfo> b = b(context);
        b.putAll(b(context, com.kwad.sdk.core.config.c.n()));
        return a(b);
    }

    @NonNull
    private static JSONArray a(@NonNull Map<String, AppPackageInfo> map) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (String str : map.keySet()) {
                AppPackageInfo appPackageInfo = map.get(str);
                if (appPackageInfo != null && !TextUtils.isEmpty(appPackageInfo.packageName)) {
                    o.a(jSONArray, a(appPackageInfo));
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.b(e);
        }
        return jSONArray;
    }

    public static JSONObject a(AppPackageInfo appPackageInfo) {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, PushClientConstants.TAG_PKG_NAME, appPackageInfo.packageName);
        o.a(jSONObject, "system_app", appPackageInfo.isSystemApp ? 1 : 0);
        o.a(jSONObject, "appVersion", appPackageInfo.versionName);
        o.a(jSONObject, "firstInstallTime", appPackageInfo.firstInstallTime);
        o.a(jSONObject, "lastUpdateTime", appPackageInfo.lastUpdateTime);
        o.a(jSONObject, "reportMethod", appPackageInfo.reportMethod);
        o.a(jSONObject, "appName", appPackageInfo.appName);
        return jSONObject;
    }

    private static boolean a(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 1) != 0;
    }

    @NonNull
    public static JSONArray[] a(Context context, List<String> list) {
        JSONArray[] jSONArrayArr = new JSONArray[2];
        if (context == null || list == null || list.isEmpty()) {
            return jSONArrayArr;
        }
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
                    hashMap2.put(appPackageInfo.packageName, appPackageInfo);
                }
            } catch (Exception e) {
                AppPackageInfo appPackageInfo2 = new AppPackageInfo();
                appPackageInfo2.packageName = str;
                hashMap2.put(appPackageInfo2.packageName, appPackageInfo2);
            }
        }
        jSONArrayArr[0] = a(hashMap);
        jSONArrayArr[1] = a(hashMap2);
        return jSONArrayArr;
    }

    @NonNull
    public static Map<String, AppPackageInfo> b(Context context) {
        HashMap hashMap = new HashMap();
        if (context == null) {
            return hashMap;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 32);
            List<String> b = AppStatusHelper.b(context);
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                if (resolveInfo != null && resolveInfo.activityInfo != null && !TextUtils.isEmpty(resolveInfo.activityInfo.packageName)) {
                    String str = resolveInfo.activityInfo.packageName;
                    if (b != null && !b.isEmpty()) {
                        b.remove(str);
                    }
                    PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                    if (packageInfo != null) {
                        AppPackageInfo a2 = a(packageInfo, packageManager);
                        a2.reportMethod = 1;
                        hashMap.put(a2.packageName, a2);
                    }
                }
            }
            if (b != null && !b.isEmpty()) {
                for (String str2 : b) {
                    try {
                        PackageInfo packageInfo2 = packageManager.getPackageInfo(str2, 0);
                        if (packageInfo2 != null) {
                            AppPackageInfo a3 = a(packageInfo2, packageManager);
                            a3.reportMethod = 2;
                            hashMap.put(a3.packageName, a3);
                        }
                    } catch (Throwable th) {
                    }
                }
            }
        } catch (Exception e) {
        }
        return hashMap;
    }

    @NonNull
    private static Map<String, AppPackageInfo> b(Context context, List<String> list) {
        HashMap hashMap = new HashMap();
        if (context == null || list == null) {
            return hashMap;
        }
        for (String str : list) {
            try {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                if (packageInfo != null) {
                    AppPackageInfo a2 = a(packageInfo, packageManager);
                    hashMap.put(a2.packageName, a2);
                }
            } catch (Exception e) {
            }
        }
        return hashMap;
    }

    private static boolean b(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 128) != 0;
    }
}
