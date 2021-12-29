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
/* loaded from: classes3.dex */
public class c {
    public static AppRunningInfoNative a(InstalledAppInfoManager.AppPackageInfo appPackageInfo, @Nullable AppStatusRules.Strategy strategy) {
        return new AppRunningInfoNative(strategy == null ? -1L : strategy.getHistoryGranularity(), appPackageInfo.appName, appPackageInfo.packageName);
    }

    public static String a(b bVar) {
        if (bVar instanceof AppRunningInfoNative) {
            return AppStatusNative.appRunningInfoGetName((AppRunningInfoNative) bVar);
        }
        if (bVar instanceof com.kwad.sdk.collector.model.kwai.b) {
            return ((com.kwad.sdk.collector.model.kwai.b) bVar).b();
        }
        return null;
    }

    public static String a(d dVar) {
        if (dVar instanceof RulesTargetNative) {
            return AppStatusNative.rulesTargetGetPackageName((RulesTargetNative) dVar);
        }
        if (dVar instanceof com.kwad.sdk.collector.model.kwai.c) {
            return ((com.kwad.sdk.collector.model.kwai.c) dVar).a();
        }
        return null;
    }

    public static ArrayList<d> a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        return com.kwad.sdk.core.config.b.ai() ? b(jSONArray) : c(jSONArray);
    }

    public static void a(@NonNull AppStatusRules.Strategy strategy, @NonNull Map<String, InstalledAppInfoManager.AppPackageInfo> map, @NonNull List<a> list) {
        InstalledAppInfoManager.AppPackageInfo appPackageInfo;
        boolean ai = com.kwad.sdk.core.config.b.ai();
        ArrayList<d> target = strategy.getTarget();
        if (target == null || target.size() == 0) {
            return;
        }
        for (d dVar : target) {
            if (b(dVar) != null && b(dVar).size() != 0 && (appPackageInfo = map.get(a(dVar))) != null) {
                HashSet hashSet = new HashSet(b(dVar));
                long startTimeWithMS = strategy.getStartTimeWithMS();
                list.add(ai ? new AnalyseTaskNative(a(appPackageInfo, strategy), hashSet, startTimeWithMS) : new com.kwad.sdk.collector.model.kwai.a(b(appPackageInfo, strategy), hashSet, startTimeWithMS));
            }
        }
    }

    public static void a(b bVar, long j2) {
        if (bVar instanceof AppRunningInfoNative) {
            AppStatusNative.appRunningInfoSetLastRunningTime((AppRunningInfoNative) bVar, j2);
        } else if (bVar instanceof com.kwad.sdk.collector.model.kwai.b) {
            ((com.kwad.sdk.collector.model.kwai.b) bVar).b(j2);
        }
    }

    public static com.kwad.sdk.collector.model.kwai.b b(InstalledAppInfoManager.AppPackageInfo appPackageInfo, @Nullable AppStatusRules.Strategy strategy) {
        return new com.kwad.sdk.collector.model.kwai.b(strategy == null ? -1L : strategy.getHistoryGranularity(), appPackageInfo.appName, appPackageInfo.packageName);
    }

    public static String b(b bVar) {
        if (bVar instanceof AppRunningInfoNative) {
            return AppStatusNative.appRunningInfoGetPackageName((AppRunningInfoNative) bVar);
        }
        if (bVar instanceof com.kwad.sdk.collector.model.kwai.b) {
            return ((com.kwad.sdk.collector.model.kwai.b) bVar).c();
        }
        return null;
    }

    public static ArrayList<d> b(@NonNull JSONArray jSONArray) {
        ArrayList<d> arrayList = new ArrayList<>();
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObject = null;
            try {
                jSONObject = jSONArray.getJSONObject(i2);
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

    public static List<String> b(d dVar) {
        if (dVar instanceof RulesTargetNative) {
            return Arrays.asList(AppStatusNative.rulesTargetGetPaths((RulesTargetNative) dVar));
        }
        if (dVar instanceof com.kwad.sdk.collector.model.kwai.c) {
            return ((com.kwad.sdk.collector.model.kwai.c) dVar).b();
        }
        return null;
    }

    public static long c(b bVar) {
        if (bVar instanceof AppRunningInfoNative) {
            return AppStatusNative.appRunningInfoGetLastRunningTime((AppRunningInfoNative) bVar);
        }
        if (bVar instanceof com.kwad.sdk.collector.model.kwai.b) {
            return ((com.kwad.sdk.collector.model.kwai.b) bVar).d();
        }
        return 0L;
    }

    public static ArrayList<d> c(@NonNull JSONArray jSONArray) {
        ArrayList<d> arrayList = new ArrayList<>();
        if (jSONArray == null) {
            return arrayList;
        }
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                com.kwad.sdk.collector.model.kwai.c cVar = new com.kwad.sdk.collector.model.kwai.c();
                cVar.parseJson(jSONObject);
                arrayList.add(cVar);
            } catch (JSONException unused) {
            }
        }
        return arrayList;
    }
}
