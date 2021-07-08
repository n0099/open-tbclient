package com.kwad.sdk.collector.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.AppStatusRules;
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
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static com.kwad.sdk.collector.model.jni.b a(InstalledAppInfoManager.AppPackageInfo appPackageInfo, @Nullable AppStatusRules.Strategy strategy) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, appPackageInfo, strategy)) == null) {
            return new com.kwad.sdk.collector.model.jni.b(strategy == null ? -1L : strategy.getHistoryGranularity(), appPackageInfo.appName, appPackageInfo.packageName);
        }
        return (com.kwad.sdk.collector.model.jni.b) invokeLL.objValue;
    }

    public static String a(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            if (bVar instanceof com.kwad.sdk.collector.model.jni.b) {
                return AppStatusNative.appRunningInfoGetName((com.kwad.sdk.collector.model.jni.b) bVar);
            }
            if (bVar instanceof com.kwad.sdk.collector.model.a.b) {
                return ((com.kwad.sdk.collector.model.a.b) bVar).b();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String a(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dVar)) == null) {
            if (dVar instanceof RulesTargetNative) {
                return AppStatusNative.rulesTargetGetPackageName((RulesTargetNative) dVar);
            }
            if (dVar instanceof com.kwad.sdk.collector.model.a.c) {
                return ((com.kwad.sdk.collector.model.a.c) dVar).a();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static ArrayList<d> a(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONArray)) == null) {
            if (jSONArray == null) {
                return null;
            }
            return com.kwad.sdk.core.config.c.ac() ? b(jSONArray) : c(jSONArray);
        }
        return (ArrayList) invokeL.objValue;
    }

    public static void a(@NonNull AppStatusRules.Strategy strategy, @NonNull Map<String, InstalledAppInfoManager.AppPackageInfo> map, @NonNull List<a> list) {
        InstalledAppInfoManager.AppPackageInfo appPackageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, strategy, map, list) == null) {
            boolean ac = com.kwad.sdk.core.config.c.ac();
            ArrayList<d> target = strategy.getTarget();
            if (target == null || target.size() == 0) {
                return;
            }
            for (d dVar : target) {
                if (b(dVar) != null && b(dVar).size() != 0 && (appPackageInfo = map.get(a(dVar))) != null) {
                    HashSet hashSet = new HashSet(b(dVar));
                    long startTimeWithMS = strategy.getStartTimeWithMS();
                    list.add(ac ? new com.kwad.sdk.collector.model.jni.a(a(appPackageInfo, strategy), hashSet, startTimeWithMS) : new com.kwad.sdk.collector.model.a.a(b(appPackageInfo, strategy), hashSet, startTimeWithMS));
                }
            }
        }
    }

    public static void a(b bVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(AdIconUtil.AD_TEXT_ID, null, bVar, j) == null) {
            if (bVar instanceof com.kwad.sdk.collector.model.jni.b) {
                AppStatusNative.appRunningInfoSetLastRunningTime((com.kwad.sdk.collector.model.jni.b) bVar, j);
            } else if (bVar instanceof com.kwad.sdk.collector.model.a.b) {
                ((com.kwad.sdk.collector.model.a.b) bVar).b(j);
            }
        }
    }

    public static com.kwad.sdk.collector.model.a.b b(InstalledAppInfoManager.AppPackageInfo appPackageInfo, @Nullable AppStatusRules.Strategy strategy) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, appPackageInfo, strategy)) == null) {
            return new com.kwad.sdk.collector.model.a.b(strategy == null ? -1L : strategy.getHistoryGranularity(), appPackageInfo.appName, appPackageInfo.packageName);
        }
        return (com.kwad.sdk.collector.model.a.b) invokeLL.objValue;
    }

    public static String b(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bVar)) == null) {
            if (bVar instanceof com.kwad.sdk.collector.model.jni.b) {
                return AppStatusNative.appRunningInfoGetPackageName((com.kwad.sdk.collector.model.jni.b) bVar);
            }
            if (bVar instanceof com.kwad.sdk.collector.model.a.b) {
                return ((com.kwad.sdk.collector.model.a.b) bVar).c();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static ArrayList<d> b(@NonNull JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, jSONArray)) == null) {
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
        return (ArrayList) invokeL.objValue;
    }

    public static List<String> b(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, dVar)) == null) {
            if (dVar instanceof RulesTargetNative) {
                return Arrays.asList(AppStatusNative.rulesTargetGetPaths((RulesTargetNative) dVar));
            }
            if (dVar instanceof com.kwad.sdk.collector.model.a.c) {
                return ((com.kwad.sdk.collector.model.a.c) dVar).b();
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static long c(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, bVar)) == null) {
            if (bVar instanceof com.kwad.sdk.collector.model.jni.b) {
                return AppStatusNative.appRunningInfoGetLastRunningTime((com.kwad.sdk.collector.model.jni.b) bVar);
            }
            if (bVar instanceof com.kwad.sdk.collector.model.a.b) {
                return ((com.kwad.sdk.collector.model.a.b) bVar).d();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static ArrayList<d> c(@NonNull JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, jSONArray)) == null) {
            ArrayList<d> arrayList = new ArrayList<>();
            if (jSONArray == null) {
                return arrayList;
            }
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    com.kwad.sdk.collector.model.a.c cVar = new com.kwad.sdk.collector.model.a.c();
                    cVar.parseJson(jSONObject);
                    arrayList.add(cVar);
                } catch (JSONException unused) {
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }
}
