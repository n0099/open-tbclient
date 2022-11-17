package com.kwad.sdk.collector.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.model.jni.AnalyseTaskNative;
import com.kwad.sdk.collector.model.jni.AppRunningInfoNative;
import com.kwad.sdk.collector.model.jni.RulesTargetNative;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class c {
    public static AppRunningInfoNative a(InstalledAppInfoManager.AppPackageInfo appPackageInfo, @Nullable AppStatusRules.Strategy strategy) {
        try {
            return new AppRunningInfoNative(strategy == null ? -1L : strategy.getHistoryGranularity(), appPackageInfo.appName, appPackageInfo.packageName);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
            return null;
        }
    }

    public static String a(b bVar) {
        if (bVar instanceof AppRunningInfoNative) {
            return AppStatusNative.appRunningInfoGetName((AppRunningInfoNative) bVar);
        }
        return null;
    }

    public static String a(d dVar) {
        if (dVar instanceof RulesTargetNative) {
            return AppStatusNative.rulesTargetGetPackageName((RulesTargetNative) dVar);
        }
        return null;
    }

    public static void a(@NonNull AppStatusRules.Strategy strategy, @NonNull Map<String, InstalledAppInfoManager.AppPackageInfo> map, @NonNull List<a> list) {
        InstalledAppInfoManager.AppPackageInfo appPackageInfo;
        ArrayList<d> target = strategy.getTarget();
        if (target == null || target.size() == 0) {
            return;
        }
        for (d dVar : target) {
            if (b(dVar) != null && b(dVar).size() != 0 && (appPackageInfo = map.get(a(dVar))) != null) {
                HashSet hashSet = new HashSet(b(dVar));
                long startTimeWithMS = strategy.getStartTimeWithMS();
                AppRunningInfoNative a = a(appPackageInfo, strategy);
                if (a != null) {
                    list.add(new AnalyseTaskNative(a, hashSet, startTimeWithMS));
                }
            }
        }
    }

    public static void a(b bVar, long j) {
        AppStatusNative.appRunningInfoSetLastRunningTime((AppRunningInfoNative) bVar, j);
    }

    public static String b(b bVar) {
        if (bVar instanceof AppRunningInfoNative) {
            return AppStatusNative.appRunningInfoGetPackageName((AppRunningInfoNative) bVar);
        }
        return null;
    }

    public static List<String> b(d dVar) {
        if (dVar instanceof RulesTargetNative) {
            return Arrays.asList(AppStatusNative.rulesTargetGetPaths((RulesTargetNative) dVar));
        }
        return null;
    }

    public static long c(b bVar) {
        if (bVar instanceof AppRunningInfoNative) {
            return AppStatusNative.appRunningInfoGetLastRunningTime((AppRunningInfoNative) bVar);
        }
        return 0L;
    }

    public static ArrayList<d> d(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        return e(jSONArray);
    }

    public static ArrayList<d> e(@NonNull JSONArray jSONArray) {
        ArrayList<d> arrayList = new ArrayList<>();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = null;
            try {
                jSONObject = jSONArray.getJSONObject(i);
            } catch (JSONException unused) {
            }
            if (jSONObject != null) {
                RulesTargetNative rulesTargetNative = new RulesTargetNative();
                rulesTargetNative.parseJson(jSONObject);
                arrayList.add(rulesTargetNative);
            }
        }
        return arrayList;
    }
}
