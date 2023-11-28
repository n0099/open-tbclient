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
import com.kwad.sdk.service.ServiceProvider;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class InstalledAppInfoManager {

    /* loaded from: classes10.dex */
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
        boolean z;
        AppPackageInfo appPackageInfo = new AppPackageInfo();
        appPackageInfo.packageName = packageInfo.packageName;
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo != null) {
            if (!a(applicationInfo) && !b(packageInfo.applicationInfo)) {
                z = false;
            } else {
                z = true;
            }
            appPackageInfo.isSystemApp = z;
        }
        appPackageInfo.versionName = packageInfo.versionName;
        appPackageInfo.firstInstallTime = packageInfo.firstInstallTime;
        appPackageInfo.lastUpdateTime = packageInfo.lastUpdateTime;
        if (packageManager != null && packageInfo.applicationInfo != null && ak.an(ServiceProvider.getContext(), packageInfo.packageName)) {
            try {
                appPackageInfo.appName = packageInfo.applicationInfo.loadLabel(packageManager).toString();
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            }
        }
        return appPackageInfo;
    }

    public static JSONObject a(AppPackageInfo appPackageInfo) {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "pkgName", appPackageInfo.packageName);
        t.putValue(jSONObject, "system_app", appPackageInfo.isSystemApp ? 1 : 0);
        t.putValue(jSONObject, "appVersion", appPackageInfo.versionName);
        t.putValue(jSONObject, "firstInstallTime", appPackageInfo.firstInstallTime);
        t.putValue(jSONObject, "lastUpdateTime", appPackageInfo.lastUpdateTime);
        t.putValue(jSONObject, "reportMethod", appPackageInfo.reportMethod);
        t.putValue(jSONObject, "appName", appPackageInfo.appName);
        return jSONObject;
    }

    @NonNull
    public static JSONArray f(@NonNull Map<String, AppPackageInfo> map) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (String str : map.keySet()) {
                AppPackageInfo appPackageInfo = map.get(str);
                if (appPackageInfo != null && !TextUtils.isEmpty(appPackageInfo.packageName)) {
                    t.a(jSONArray, a(appPackageInfo));
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
        }
        return jSONArray;
    }

    public static void a(final Context context, final com.kwad.sdk.g.a<JSONArray> aVar) {
        g.execute(new ay() { // from class: com.kwad.sdk.utils.InstalledAppInfoManager.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                aVar.accept(InstalledAppInfoManager.f(InstalledAppInfoManager.bW(context)));
            }
        });
    }

    @NonNull
    public static Map<String, AppPackageInfo> d(Context context, List<String> list) {
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

    public static boolean a(ApplicationInfo applicationInfo) {
        if ((applicationInfo.flags & 1) != 0) {
            return true;
        }
        return false;
    }

    public static boolean b(ApplicationInfo applicationInfo) {
        if ((applicationInfo.flags & 128) != 0) {
            return true;
        }
        return false;
    }

    @NonNull
    public static Map<String, AppPackageInfo> bW(Context context) {
        HashMap hashMap = new HashMap();
        if (context == null) {
            return hashMap;
        }
        PackageManager packageManager = context.getPackageManager();
        if (au.KQ()) {
            try {
                List<String> KR = au.KR();
                if (KR != null && !KR.isEmpty()) {
                    for (String str : new ArrayList(KR)) {
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
            } catch (Exception unused2) {
            }
            return hashMap;
        }
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (hVar != null && o.JK()) {
            try {
                List<String> dh = bi.dh(context);
                Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
                intent.addCategory("android.intent.category.LAUNCHER");
                for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 32)) {
                    if (resolveInfo != null && resolveInfo.activityInfo != null && !TextUtils.isEmpty(resolveInfo.activityInfo.packageName)) {
                        String str2 = resolveInfo.activityInfo.packageName;
                        if (dh != null && !dh.isEmpty()) {
                            dh.remove(str2);
                        }
                        PackageInfo packageInfo2 = packageManager.getPackageInfo(str2, 0);
                        if (packageInfo2 != null) {
                            AppPackageInfo a2 = a(packageInfo2, packageManager);
                            a2.reportMethod = 1;
                            hashMap.put(a2.packageName, a2);
                        }
                    }
                }
                if (dh != null && !dh.isEmpty()) {
                    for (String str3 : dh) {
                        try {
                            PackageInfo packageInfo3 = packageManager.getPackageInfo(str3, 0);
                            if (packageInfo3 != null) {
                                AppPackageInfo a3 = a(packageInfo3, packageManager);
                                a3.reportMethod = 2;
                                hashMap.put(a3.packageName, a3);
                            }
                        } catch (Throwable unused3) {
                        }
                    }
                }
            } catch (Exception unused4) {
            }
            hashMap.putAll(d(context, hVar.yq()));
        }
        return hashMap;
    }

    @NonNull
    public static JSONArray[] c(Context context, List<String> list) {
        JSONArray[] jSONArrayArr = new JSONArray[2];
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (context != null && list != null && !list.isEmpty() && hVar != null) {
            if (!o.JK()) {
                return jSONArrayArr;
            }
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            for (String str : list) {
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
            jSONArrayArr[0] = f(hashMap);
            jSONArrayArr[1] = f(hashMap2);
        }
        return jSONArrayArr;
    }
}
