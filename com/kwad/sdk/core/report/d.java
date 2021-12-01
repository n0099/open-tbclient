package com.kwad.sdk.core.report;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.t;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-615486403, "Lcom/kwad/sdk/core/report/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-615486403, "Lcom/kwad/sdk/core/report/d;");
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            f.a(new ReportAction(10101L));
        }
    }

    public static void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i2) == null) {
            ReportAction reportAction = new ReportAction(10104L);
            reportAction.aI = i2;
            f.a(reportAction);
        }
    }

    public static void a(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            ReportAction reportAction = new ReportAction(j2);
            if (j3 > 0) {
                reportAction.aO = j3;
            }
            f.a(reportAction);
        }
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) || a) {
            return;
        }
        a = true;
        ReportAction reportAction = new ReportAction(8L);
        reportAction.bs = com.kwad.sdk.collector.f.a(context);
        f.a(reportAction);
    }

    public static void a(KsScene ksScene, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{ksScene, Boolean.valueOf(z), str}) == null) {
            ReportAction reportAction = new ReportAction(10216L);
            reportAction.aW = z;
            reportAction.aX = str;
            if (ksScene instanceof SceneImpl) {
                reportAction.f57636b = (SceneImpl) ksScene;
            }
            f.a(reportAction);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, adTemplate) == null) {
            f.a(new ReportAction(LightappBusinessClient.SVC_ID_H5_CASHBACK, adTemplate));
        }
    }

    public static void a(AdTemplate adTemplate, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65543, null, adTemplate, i2) == null) {
            ReportAction reportAction = new ReportAction(10108L, adTemplate);
            reportAction.aJ = i2;
            f.a(reportAction);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65544, null, adTemplate, i2, i3) == null) {
            ReportAction reportAction = new ReportAction(12006L, adTemplate);
            reportAction.aA = i2;
            reportAction.J = i3;
            f.a(reportAction);
        }
    }

    public static void a(AdTemplate adTemplate, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, adTemplate, i2, str) == null) {
            ReportAction reportAction = new ReportAction(10109L, adTemplate);
            reportAction.aJ = i2;
            reportAction.aK = str;
            f.a(reportAction);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65546, null, adTemplate, j2) == null) {
            ReportAction reportAction = new ReportAction(10202L, adTemplate);
            reportAction.aU = j2;
            f.a(reportAction);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{adTemplate, Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            ReportAction reportAction = new ReportAction(104L, adTemplate);
            reportAction.bc = com.kwad.sdk.utils.m.d(adTemplate);
            reportAction.bd = j2;
            reportAction.be = i2;
            f.a(reportAction);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate, long j2, long j3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{adTemplate, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)}) == null) {
            ReportAction reportAction = new ReportAction(10203L, adTemplate);
            reportAction.u = j2;
            reportAction.y = j3;
            reportAction.C = i2;
            f.a(reportAction);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, adTemplate, str, str2) == null) {
            ReportAction reportAction = new ReportAction(LightappBusinessClient.SVC_ID_H5_HOMEPAGE, adTemplate);
            reportAction.aC = str;
            reportAction.aD = str2;
            f.a(reportAction);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate, List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65550, null, adTemplate, list) == null) || adTemplate.mTrackUrlReported || list == null || list.isEmpty()) {
            return;
        }
        adTemplate.mTrackUrlReported = true;
        ReportAction reportAction = new ReportAction(10217L, adTemplate);
        reportAction.bo = t.a(list);
        f.a(reportAction);
    }

    public static void a(com.kwad.sdk.h.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, bVar) == null) {
            ReportAction reportAction = new ReportAction(10215L);
            reportAction.bl = bVar.a;
            reportAction.bp = bVar.f58609b;
            reportAction.bm = bVar.f58610c;
            reportAction.bn = bVar.f58611d;
            f.a(reportAction);
        }
    }

    public static void a(SceneImpl sceneImpl, com.kwad.sdk.core.network.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, sceneImpl, aVar) == null) {
            ReportAction reportAction = new ReportAction(10214L);
            reportAction.f57636b = sceneImpl;
            reportAction.bf = aVar.f57498g;
            reportAction.bg = aVar.a;
            reportAction.bh = aVar.f57494c;
            reportAction.bi = aVar.f57495d;
            reportAction.bj = aVar.f57496e;
            reportAction.bk = aVar.f57497f;
            f.a(reportAction);
        }
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, str, str2) == null) {
            ReportAction reportAction = new ReportAction((long) LightappBusinessClient.SVC_ID_H5_SECURITCENTER);
            reportAction.aC = str;
            reportAction.aD = str2;
            f.a(reportAction);
        }
    }

    public static void a(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(65554, null, str, str2, z) == null) && com.kwad.sdk.core.config.b.aq()) {
            ReportAction reportAction = new ReportAction(12200L);
            reportAction.bL = str;
            reportAction.bM = str2;
            if (z) {
                f.b(reportAction);
            } else {
                f.a(reportAction);
            }
        }
    }

    public static void a(@NonNull JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, jSONArray) == null) {
            ReportAction reportAction = new ReportAction(10200L);
            reportAction.aN = jSONArray;
            f.a(reportAction);
        }
    }

    public static void a(@NonNull JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65556, null, jSONObject, i2) == null) {
            ReportAction reportAction = new ReportAction(10201L);
            t.a(jSONObject, "appChangeType", i2);
            reportAction.aM = jSONObject;
            f.a(reportAction);
        }
    }

    public static void a(boolean z, List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65557, null, z, list) == null) {
            ReportAction reportAction = new ReportAction(10204L);
            reportAction.aW = z;
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (Integer num : list) {
                    jSONArray.put(num);
                }
                reportAction.aV = jSONArray;
            }
            f.a(reportAction);
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, null) == null) {
            f.a(new ReportAction(10106L));
        }
    }

    public static void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65559, null, i2) == null) {
            ReportAction reportAction = new ReportAction(10107L);
            reportAction.aJ = i2;
            f.a(reportAction);
        }
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, context) == null) {
            ReportAction reportAction = new ReportAction(11L);
            JSONArray[] a2 = InstalledAppInfoManager.a(context, com.kwad.sdk.core.config.b.f());
            reportAction.X = a2[0];
            reportAction.Y = a2[1];
            f.a(reportAction);
        }
    }

    public static void b(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, adTemplate) == null) {
            f.a(new ReportAction(10208L, adTemplate));
        }
    }

    public static void b(@NonNull AdTemplate adTemplate, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65562, null, adTemplate, i2, i3) == null) {
            ReportAction reportAction = new ReportAction(LightappBusinessClient.SVC_ID_H5_BALANCE, adTemplate);
            reportAction.c();
            reportAction.aC = com.kwad.sdk.core.response.a.d.c(adTemplate) ? com.kwad.sdk.core.response.a.a.a(com.kwad.sdk.core.response.a.d.j(adTemplate)) : com.kwad.sdk.core.response.a.d.m(adTemplate);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("what", i2);
                jSONObject.put("extra", i3);
                reportAction.aD = jSONObject.toString();
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.b(e2);
            }
            f.a(reportAction);
        }
    }

    public static void b(@NonNull AdTemplate adTemplate, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65563, null, adTemplate, i2, str) == null) {
            ReportAction reportAction = new ReportAction(107L, adTemplate);
            reportAction.aE = i2;
            reportAction.aD = str;
            f.a(reportAction);
        }
    }

    public static void b(AdTemplate adTemplate, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65564, null, adTemplate, j2) == null) {
            ReportAction reportAction = new ReportAction(10206L, adTemplate);
            reportAction.bq = j2;
            f.a(reportAction);
        }
    }

    public static void b(@NonNull AdTemplate adTemplate, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65565, null, adTemplate, str, str2) == null) {
            ReportAction reportAction = new ReportAction(LightappBusinessClient.SVC_ID_H5_TRANSERECORD, adTemplate);
            reportAction.aC = str;
            reportAction.aD = str2;
            f.a(reportAction);
        }
    }

    public static void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65566, null, i2) == null) {
            ReportAction reportAction = new ReportAction(10212L);
            reportAction.aZ = i2;
            f.a(reportAction);
        }
    }

    public static void c(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, null, adTemplate) == null) {
            f.a(new ReportAction(10209L, adTemplate));
        }
    }

    public static void c(AdTemplate adTemplate, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65568, null, adTemplate, j2) == null) {
            ReportAction reportAction = new ReportAction(10207L, adTemplate);
            reportAction.br = j2;
            f.a(reportAction);
        }
    }

    public static void c(@NonNull AdTemplate adTemplate, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65569, null, adTemplate, str, str2) == null) {
            ReportAction reportAction = new ReportAction(LightappBusinessClient.SVC_ID_H5_MYBANKCARD, adTemplate);
            reportAction.aC = com.kwad.sdk.core.response.a.d.c(adTemplate) ? com.kwad.sdk.core.response.a.a.a(com.kwad.sdk.core.response.a.d.j(adTemplate)) : com.kwad.sdk.core.response.a.d.m(adTemplate);
            reportAction.aC = str;
            reportAction.aD = str2;
            f.a(reportAction);
        }
    }
}
