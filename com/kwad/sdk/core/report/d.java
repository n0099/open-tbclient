package com.kwad.sdk.core.report;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.q;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f35069a;
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
            reportAction.aF = i2;
            f.a(reportAction);
        }
    }

    public static void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            ReportAction reportAction = new ReportAction(j);
            if (j2 > 0) {
                reportAction.aL = j2;
            }
            f.a(reportAction);
        }
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) || f35069a) {
            return;
        }
        f35069a = true;
        ReportAction reportAction = new ReportAction(8L);
        reportAction.bp = com.kwad.sdk.collector.f.a(context);
        f.a(reportAction);
    }

    public static void a(KsScene ksScene, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{ksScene, Boolean.valueOf(z), str}) == null) {
            ReportAction reportAction = new ReportAction(10216L);
            reportAction.aT = z;
            reportAction.aU = str;
            if (ksScene instanceof SceneImpl) {
                reportAction.f35020b = (SceneImpl) ksScene;
            }
            f.a(reportAction);
        }
    }

    public static void a(com.kwad.sdk.c.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bVar) == null) {
            ReportAction reportAction = new ReportAction(10215L);
            reportAction.bi = bVar.f34175a;
            reportAction.bm = bVar.f34176b;
            reportAction.bj = bVar.f34177c;
            reportAction.bk = bVar.f34178d;
            f.a(reportAction);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, adTemplate) == null) {
            f.a(new ReportAction(LightappBusinessClient.SVC_ID_H5_CASHBACK, adTemplate));
        }
    }

    public static void a(AdTemplate adTemplate, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, null, adTemplate, i2) == null) {
            ReportAction reportAction = new ReportAction(10108L, adTemplate);
            reportAction.aG = i2;
            f.a(reportAction);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65545, null, adTemplate, i2, i3) == null) {
            ReportAction reportAction = new ReportAction(12006L, adTemplate);
            reportAction.ax = i2;
            reportAction.J = i3;
            f.a(reportAction);
        }
    }

    public static void a(AdTemplate adTemplate, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65546, null, adTemplate, i2, str) == null) {
            ReportAction reportAction = new ReportAction(10109L, adTemplate);
            reportAction.aG = i2;
            reportAction.aH = str;
            f.a(reportAction);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65547, null, adTemplate, j) == null) {
            ReportAction reportAction = new ReportAction(10202L, adTemplate);
            reportAction.aR = j;
            f.a(reportAction);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate, long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{adTemplate, Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            ReportAction reportAction = new ReportAction(104L, adTemplate);
            reportAction.aZ = com.kwad.sdk.utils.j.d(adTemplate);
            reportAction.ba = j;
            reportAction.bb = i2;
            f.a(reportAction);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate, long j, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{adTemplate, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            ReportAction reportAction = new ReportAction(10203L, adTemplate);
            reportAction.u = j;
            reportAction.y = j2;
            reportAction.C = i2;
            f.a(reportAction);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, adTemplate, str, str2) == null) {
            ReportAction reportAction = new ReportAction(LightappBusinessClient.SVC_ID_H5_HOMEPAGE, adTemplate);
            reportAction.az = str;
            reportAction.aA = str2;
            f.a(reportAction);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65551, null, adTemplate, str, str2, str3, str4) == null) {
            ReportAction reportAction = new ReportAction(LightappBusinessClient.SVC_ID_H5_CHARGE, adTemplate);
            reportAction.br = str;
            reportAction.bs = str2;
            reportAction.bt = str3;
            reportAction.bu = str4;
            AdStyleInfo adStyleInfo = com.kwad.sdk.core.response.b.c.i(adTemplate).adStyleInfo2;
            if (adStyleInfo != null) {
                reportAction.bv = adStyleInfo.toJson().toString();
            }
            f.a(reportAction);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate, List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65552, null, adTemplate, list) == null) || adTemplate.mTrackUrlReported || list == null || list.isEmpty()) {
            return;
        }
        adTemplate.mTrackUrlReported = true;
        ReportAction reportAction = new ReportAction(10217L, adTemplate);
        reportAction.bl = q.a(list);
        f.a(reportAction);
    }

    public static void a(SceneImpl sceneImpl, com.kwad.sdk.core.network.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, sceneImpl, aVar) == null) {
            ReportAction reportAction = new ReportAction(10214L);
            reportAction.f35020b = sceneImpl;
            reportAction.bc = aVar.f34851g;
            reportAction.bd = aVar.f34845a;
            reportAction.be = aVar.f34847c;
            reportAction.bf = aVar.f34848d;
            reportAction.bg = aVar.f34849e;
            reportAction.bh = aVar.f34850f;
            f.a(reportAction);
        }
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, str, str2) == null) {
            ReportAction reportAction = new ReportAction((long) LightappBusinessClient.SVC_ID_H5_SECURITCENTER);
            reportAction.az = str;
            reportAction.aA = str2;
            f.a(reportAction);
        }
    }

    public static void a(@NonNull JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, jSONArray) == null) {
            ReportAction reportAction = new ReportAction(10200L);
            reportAction.aK = jSONArray;
            f.a(reportAction);
        }
    }

    public static void a(@NonNull JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65556, null, jSONObject, i2) == null) {
            ReportAction reportAction = new ReportAction(10201L);
            q.a(jSONObject, "appChangeType", i2);
            reportAction.aJ = jSONObject;
            f.a(reportAction);
        }
    }

    public static void a(boolean z, List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65557, null, z, list) == null) {
            ReportAction reportAction = new ReportAction(10204L);
            reportAction.aT = z;
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (Integer num : list) {
                    jSONArray.put(num);
                }
                reportAction.aS = jSONArray;
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
            reportAction.aG = i2;
            f.a(reportAction);
        }
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, context) == null) {
            ReportAction reportAction = new ReportAction(11L);
            JSONArray[] a2 = InstalledAppInfoManager.a(context, com.kwad.sdk.core.config.c.i());
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
            reportAction.az = com.kwad.sdk.core.response.b.c.b(adTemplate) ? com.kwad.sdk.core.response.b.a.a(com.kwad.sdk.core.response.b.c.i(adTemplate)) : com.kwad.sdk.core.response.b.c.l(adTemplate);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("what", i2);
                jSONObject.put("extra", i3);
                reportAction.aA = jSONObject.toString();
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
            reportAction.aB = i2;
            reportAction.aA = str;
            f.a(reportAction);
        }
    }

    public static void b(AdTemplate adTemplate, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65564, null, adTemplate, j) == null) {
            ReportAction reportAction = new ReportAction(10206L, adTemplate);
            reportAction.bn = j;
            f.a(reportAction);
        }
    }

    public static void b(@NonNull AdTemplate adTemplate, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65565, null, adTemplate, str, str2) == null) {
            ReportAction reportAction = new ReportAction(LightappBusinessClient.SVC_ID_H5_TRANSERECORD, adTemplate);
            reportAction.az = str;
            reportAction.aA = str2;
            f.a(reportAction);
        }
    }

    public static void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65566, null, i2) == null) {
            ReportAction reportAction = new ReportAction(10212L);
            reportAction.aW = i2;
            f.a(reportAction);
        }
    }

    public static void c(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, null, adTemplate) == null) {
            f.a(new ReportAction(10209L, adTemplate));
        }
    }

    public static void c(AdTemplate adTemplate, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65568, null, adTemplate, j) == null) {
            ReportAction reportAction = new ReportAction(10207L, adTemplate);
            reportAction.bo = j;
            f.a(reportAction);
        }
    }

    public static void c(@NonNull AdTemplate adTemplate, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65569, null, adTemplate, str, str2) == null) {
            ReportAction reportAction = new ReportAction(LightappBusinessClient.SVC_ID_H5_MYBANKCARD, adTemplate);
            reportAction.az = com.kwad.sdk.core.response.b.c.b(adTemplate) ? com.kwad.sdk.core.response.b.a.a(com.kwad.sdk.core.response.b.c.i(adTemplate)) : com.kwad.sdk.core.response.b.c.l(adTemplate);
            reportAction.az = str;
            reportAction.aA = str2;
            f.a(reportAction);
        }
    }
}
