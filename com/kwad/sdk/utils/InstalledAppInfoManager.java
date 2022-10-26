package com.kwad.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class InstalledAppInfoManager {

    /* loaded from: classes8.dex */
    public class AppPackageInfo implements Serializable {
        public static final long serialVersionUID = -324393456884895874L;
        public String appName;
        public long firstInstallTime;
        public boolean isSystemApp;
        public long lastUpdateTime;
        public String packageName;
        public int reportMethod;
        public String versionName;
    }

    public static AppPackageInfo a(PackageInfo packageInfo, PackageManager packageManager) {
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
                appPackageInfo.appName = applicationInfo.loadLabel(packageManager).toString();
            } catch (Throwable th) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(th);
            }
        }
        return appPackageInfo;
    }

    public static JSONObject a(AppPackageInfo appPackageInfo) {
        JSONObject jSONObject = new JSONObject();
        r.putValue(jSONObject, "pkgName", appPackageInfo.packageName);
        r.putValue(jSONObject, "system_app", appPackageInfo.isSystemApp ? 1 : 0);
        r.putValue(jSONObject, "appVersion", appPackageInfo.versionName);
        r.putValue(jSONObject, "firstInstallTime", appPackageInfo.firstInstallTime);
        r.putValue(jSONObject, "lastUpdateTime", appPackageInfo.lastUpdateTime);
        r.putValue(jSONObject, "reportMethod", appPackageInfo.reportMethod);
        r.putValue(jSONObject, "appName", appPackageInfo.appName);
        return jSONObject;
    }

    public static boolean a(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 1) != 0;
    }

    public static boolean b(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 128) != 0;
    }

    public static JSONArray[] c(Context context, List list) {
        JSONArray[] jSONArrayArr = new JSONArray[2];
        com.kwad.sdk.service.kwai.f fVar = (com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class);
        if (context == null || list == null || list.isEmpty() || fVar == null || fVar.i(16L)) {
            return jSONArrayArr;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
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
        jSONArrayArr[0] = d(hashMap);
        jSONArrayArr[1] = d(hashMap2);
        return jSONArrayArr;
    }

    public static JSONArray ch(Context context) {
        return d(ci(context));
    }

    public static Map ci(Context context) {
        HashMap hashMap = new HashMap();
        if (context == null) {
            return hashMap;
        }
        PackageManager packageManager = context.getPackageManager();
        if (aq.Af()) {
            if (aq.Ag() != null) {
                for (String str : aq.Ag()) {
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
        }
        com.kwad.sdk.service.kwai.f fVar = (com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class);
        if (fVar != null && !fVar.i(16L)) {
            try {
                List<String> dx = az.dx(context);
                Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
                intent.addCategory("android.intent.category.LAUNCHER");
                for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 32)) {
                    if (resolveInfo != null && resolveInfo.activityInfo != null && !TextUtils.isEmpty(resolveInfo.activityInfo.packageName)) {
                        String str2 = resolveInfo.activityInfo.packageName;
                        if (dx != null && !dx.isEmpty()) {
                            dx.remove(str2);
                        }
                        PackageInfo packageInfo2 = packageManager.getPackageInfo(str2, 0);
                        if (packageInfo2 != null) {
                            AppPackageInfo a2 = a(packageInfo2, packageManager);
                            a2.reportMethod = 1;
                            hashMap.put(a2.packageName, a2);
                        }
                    }
                }
                if (dx != null && !dx.isEmpty()) {
                    for (String str3 : dx) {
                        try {
                            PackageInfo packageInfo3 = packageManager.getPackageInfo(str3, 0);
                            if (packageInfo3 != null) {
                                AppPackageInfo a3 = a(packageInfo3, packageManager);
                                a3.reportMethod = 2;
                                hashMap.put(a3.packageName, a3);
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                }
            } catch (Exception unused3) {
            }
            hashMap.putAll(d(context, fVar.lD()));
        }
        return hashMap;
    }

    public static Map d(Context context, List list) {
        HashMap hashMap = new HashMap();
        if (context != null && list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
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

    public static JSONArray d(Map map) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (String str : map.keySet()) {
                AppPackageInfo appPackageInfo = (AppPackageInfo) map.get(str);
                if (appPackageInfo != null && !TextUtils.isEmpty(appPackageInfo.packageName)) {
                    r.putValue(jSONArray, a(appPackageInfo));
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
        }
        return jSONArray;
    }
}
