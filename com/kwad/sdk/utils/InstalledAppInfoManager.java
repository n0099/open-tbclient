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
import com.kuaishou.weapon.adsdk.DeviceInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class InstalledAppInfoManager {

    /* loaded from: classes8.dex */
    public static class AppPackageInfo implements Serializable {
        public static final long serialVersionUID = -324393456884895874L;
        public String appName;
        public long firstInstallTime;
        public boolean isSystemApp;
        public long lastUpdateTime;
        public String packageName;
        public int reportMethod;
        public String versionName;
    }

    public static AppPackageInfo a(@NonNull PackageInfo packageInfo, @Nullable PackageManager packageManager) {
        ApplicationInfo applicationInfo;
        AppPackageInfo appPackageInfo = new AppPackageInfo();
        appPackageInfo.packageName = packageInfo.packageName;
        ApplicationInfo applicationInfo2 = packageInfo.applicationInfo;
        if (applicationInfo2 != null) {
            appPackageInfo.isSystemApp = a(applicationInfo2) || b(packageInfo.applicationInfo);
        }
        appPackageInfo.versionName = packageInfo.versionName;
        appPackageInfo.firstInstallTime = packageInfo.firstInstallTime;
        appPackageInfo.lastUpdateTime = packageInfo.lastUpdateTime;
        if (packageManager != null && (applicationInfo = packageInfo.applicationInfo) != null) {
            try {
                appPackageInfo.appName = packageManager.getApplicationLabel(applicationInfo).toString();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
            }
        }
        return appPackageInfo;
    }

    @NonNull
    public static JSONArray a(Context context) {
        return a(b(context));
    }

    @NonNull
    public static JSONArray a(@NonNull Map<String, AppPackageInfo> map) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (String str : map.keySet()) {
                AppPackageInfo appPackageInfo = map.get(str);
                if (appPackageInfo != null && !TextUtils.isEmpty(appPackageInfo.packageName)) {
                    t.a(jSONArray, a(appPackageInfo));
                }
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
        return jSONArray;
    }

    public static JSONObject a(AppPackageInfo appPackageInfo) {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "pkgName", appPackageInfo.packageName);
        t.a(jSONObject, "system_app", appPackageInfo.isSystemApp ? 1 : 0);
        t.a(jSONObject, "appVersion", appPackageInfo.versionName);
        t.a(jSONObject, "firstInstallTime", appPackageInfo.firstInstallTime);
        t.a(jSONObject, "lastUpdateTime", appPackageInfo.lastUpdateTime);
        t.a(jSONObject, "reportMethod", appPackageInfo.reportMethod);
        t.a(jSONObject, "appName", appPackageInfo.appName);
        return jSONObject;
    }

    public static boolean a(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 1) != 0;
    }

    @NonNull
    public static JSONArray[] a(Context context, List<String> list) {
        JSONArray[] jSONArrayArr = new JSONArray[2];
        if (context != null && list != null && !list.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList();
            if (ao.m()) {
                if (ao.n() != null) {
                    HashSet hashSet = new HashSet(list);
                    HashSet hashSet2 = new HashSet(ao.n());
                    HashSet hashSet3 = new HashSet(hashSet);
                    hashSet3.retainAll(hashSet2);
                    arrayList.addAll(hashSet3);
                }
            } else if (com.kwad.sdk.core.config.b.a(16L)) {
                return jSONArrayArr;
            } else {
                arrayList.addAll(list);
            }
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            for (String str : arrayList) {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                    if (packageInfo != null) {
                        AppPackageInfo a = a(packageInfo, packageManager);
                        hashMap.put(a.packageName, a);
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

    @NonNull
    public static Map<String, AppPackageInfo> b(Context context) {
        HashMap hashMap = new HashMap();
        if (context == null) {
            return hashMap;
        }
        PackageManager packageManager = context.getPackageManager();
        if (ao.m()) {
            if (ao.n() != null) {
                for (String str : ao.n()) {
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                        if (packageInfo != null) {
                            AppPackageInfo a = a(packageInfo, packageManager);
                            a.reportMethod = 3;
                            hashMap.put(a.packageName, a);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            return hashMap;
        } else if (com.kwad.sdk.core.config.b.a(16L)) {
            return hashMap;
        } else {
            try {
                List<String> b2 = h.b(context);
                if (com.kwad.sdk.b.a.booleanValue()) {
                    for (String str2 : DeviceInfo.queryInstalledAppList(context)) {
                        if (b2 != null && !b2.isEmpty()) {
                            b2.remove(str2);
                        }
                        PackageInfo packageInfo2 = packageManager.getPackageInfo(str2, 0);
                        if (packageInfo2 != null) {
                            AppPackageInfo a2 = a(packageInfo2, packageManager);
                            a2.reportMethod = 1;
                            hashMap.put(a2.packageName, a2);
                        }
                    }
                } else {
                    Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
                    intent.addCategory("android.intent.category.LAUNCHER");
                    for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 32)) {
                        if (resolveInfo != null && resolveInfo.activityInfo != null && !TextUtils.isEmpty(resolveInfo.activityInfo.packageName)) {
                            String str3 = resolveInfo.activityInfo.packageName;
                            if (b2 != null && !b2.isEmpty()) {
                                b2.remove(str3);
                            }
                            PackageInfo packageInfo3 = packageManager.getPackageInfo(str3, 0);
                            if (packageInfo3 != null) {
                                AppPackageInfo a3 = a(packageInfo3, packageManager);
                                a3.reportMethod = 1;
                                hashMap.put(a3.packageName, a3);
                            }
                        }
                    }
                }
                if (b2 != null && !b2.isEmpty()) {
                    for (String str4 : b2) {
                        try {
                            PackageInfo packageInfo4 = packageManager.getPackageInfo(str4, 0);
                            if (packageInfo4 != null) {
                                AppPackageInfo a4 = a(packageInfo4, packageManager);
                                a4.reportMethod = 2;
                                hashMap.put(a4.packageName, a4);
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                }
            } catch (Exception unused3) {
            }
            hashMap.putAll(b(context, com.kwad.sdk.core.config.b.f()));
            return hashMap;
        }
    }

    @NonNull
    public static Map<String, AppPackageInfo> b(Context context, List<String> list) {
        HashMap hashMap = new HashMap();
        if (context != null && list != null) {
            for (String str : list) {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                    if (packageInfo != null) {
                        AppPackageInfo a = a(packageInfo, packageManager);
                        hashMap.put(a.packageName, a);
                    }
                } catch (Exception unused) {
                }
            }
        }
        return hashMap;
    }

    public static boolean b(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 128) != 0;
    }
}
