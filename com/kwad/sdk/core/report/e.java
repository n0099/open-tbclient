package com.kwad.sdk.core.report;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.TrendInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f36536a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-615486372, "Lcom/kwad/sdk/core/report/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-615486372, "Lcom/kwad/sdk/core/report/e;");
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || f36536a) {
            return;
        }
        f36536a = true;
        g.a(new a(8L));
    }

    public static void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i2) == null) {
            a aVar = new a(10104L);
            aVar.P = i2;
            g.a(aVar);
        }
    }

    public static void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            a aVar = new a(j);
            if (j2 > 0) {
                aVar.R = j2;
            }
            g.a(aVar);
        }
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, null, context) == null) {
            a aVar = new a(11L);
            JSONArray[] a2 = InstalledAppInfoManager.a(context, com.kwad.sdk.core.config.c.n());
            aVar.t = a2[0];
            aVar.u = a2[1];
            g.a(aVar);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, adTemplate) == null) || adTemplate.mContentPvReported) {
            return;
        }
        adTemplate.mContentPvReported = true;
        g.a(new a(20L, adTemplate));
    }

    public static void a(@NonNull AdTemplate adTemplate, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, adTemplate, i2) == null) {
            a aVar = new a(1L, adTemplate);
            aVar.o = i2;
            g.c(aVar);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65543, null, adTemplate, i2, i3) == null) {
            a aVar = new a(3L, adTemplate);
            aVar.q = i2;
            aVar.r = i3;
            g.a(aVar);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(65544, null, adTemplate, i2, i3, i4) == null) {
            a aVar = new a(30L, adTemplate);
            com.kwad.sdk.core.d.a.a("BatchReportManager", "reportProfileClick guideTimes=" + i4);
            aVar.o = i2;
            aVar.G = i3;
            aVar.T = i4;
            g.a(aVar);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, adTemplate, i2, str) == null) {
            a aVar = new a(21L, adTemplate);
            aVar.A = i2;
            aVar.N = str;
            g.a(aVar);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65546, null, adTemplate, i2, str, str2) == null) {
            a aVar = new a(21L, adTemplate);
            aVar.A = i2;
            aVar.N = str;
            aVar.O = str2;
            g.a(aVar);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65547, null, adTemplate, j) == null) {
            a aVar = new a(2L, adTemplate);
            aVar.f36493f = j;
            aVar.b();
            g.a(aVar);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{adTemplate, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            a aVar = new a(18L, adTemplate);
            com.kwad.sdk.core.d.a.a("BatchReportManager", "stayDuration=" + j2 + " seenCount=" + j);
            aVar.z = j;
            aVar.f36494g = j2;
            g.a(aVar);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate, long j, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{adTemplate, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            a aVar = new a(10203L, adTemplate);
            aVar.f36492e = j;
            aVar.f36496i = j2;
            aVar.j = i2;
            g.a(aVar);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, adTemplate, str) == null) {
            a aVar = new a(7L, adTemplate);
            aVar.v = str;
            g.a(aVar);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65551, null, adTemplate, str, i2) == null) {
            a aVar = new a(21L, adTemplate);
            aVar.w = str;
            aVar.A = i2;
            g.a(aVar);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, null, adTemplate, str, str2) == null) {
            a aVar = new a(34L, adTemplate);
            aVar.N = str;
            aVar.O = str2;
            g.a(aVar);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65553, null, adTemplate, z) == null) {
            a aVar = new a(10L, adTemplate);
            aVar.s = z ? 1 : 2;
            g.a(aVar);
        }
    }

    public static void a(@NonNull com.kwad.sdk.core.response.model.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, aVar) == null) {
            a aVar2 = new a(19L);
            aVar2.w = aVar.f36566e;
            List<AdTemplate> list = aVar.k;
            if (list != null && list.size() > 0) {
                aVar2.f36489b = aVar.k.get(0).mAdScene;
            }
            g.a(aVar2);
        }
    }

    public static void a(@NonNull SceneImpl sceneImpl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, sceneImpl) == null) {
            a aVar = new a(43L);
            aVar.f36489b = sceneImpl;
            g.a(aVar);
        }
    }

    public static void a(@NonNull SceneImpl sceneImpl, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65556, null, sceneImpl, i2) == null) {
            a aVar = new a(46L);
            aVar.f36489b = sceneImpl;
            aVar.F = i2;
            g.a(aVar);
        }
    }

    public static void a(@NonNull SceneImpl sceneImpl, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65557, null, sceneImpl, j) == null) {
            a aVar = new a(28L);
            aVar.f36489b = sceneImpl;
            aVar.f36495h = j;
            g.a(aVar);
        }
    }

    public static void a(@NonNull SceneImpl sceneImpl, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{sceneImpl, Long.valueOf(j), str}) == null) {
            a aVar = new a(41L);
            aVar.f36489b = sceneImpl;
            aVar.C = j;
            aVar.D = str;
            g.a(aVar);
        }
    }

    public static void a(SceneImpl sceneImpl, @NonNull AdTemplate adTemplate, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65559, null, new Object[]{sceneImpl, adTemplate, Long.valueOf(j)}) == null) {
            a aVar = new a(5L, adTemplate);
            aVar.b();
            aVar.f36489b = sceneImpl;
            aVar.f36491d = j;
            g.a(aVar);
        }
    }

    public static void a(SceneImpl sceneImpl, @NonNull AdTemplate adTemplate, long j, int i2, long j2, long j3, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{sceneImpl, adTemplate, Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3)}) == null) {
            a aVar = new a(4L, adTemplate);
            aVar.b();
            aVar.f36489b = sceneImpl;
            aVar.f36492e = j;
            aVar.p = i2;
            aVar.f36494g = j2;
            aVar.f36496i = j3;
            aVar.j = i3;
            g.c(aVar);
        }
    }

    public static void a(@NonNull SceneImpl sceneImpl, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65561, null, sceneImpl, str) == null) {
            a aVar = new a(36L);
            aVar.f36489b = sceneImpl;
            aVar.B = str;
            g.a(aVar);
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, null, str) == null) {
            a aVar = new a(26L);
            aVar.x = str;
            g.a(aVar);
        }
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65563, null, str, str2) == null) {
            a aVar = new a(LightappBusinessClient.SVC_ID_H5_SECURITCENTER);
            aVar.H = str;
            aVar.I = str2;
            g.a(aVar);
        }
    }

    public static void a(@NonNull List<AdTemplate> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, list) == null) {
            a aVar = new a(55L);
            aVar.J = b(list);
            g.a(aVar);
        }
    }

    public static void a(@NonNull JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, null, jSONArray) == null) {
            a aVar = new a(10200L);
            aVar.K = jSONArray;
            g.a(aVar);
        }
    }

    public static void a(@NonNull JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65566, null, jSONObject, i2) == null) {
            a aVar = new a(10201L);
            com.kwad.sdk.utils.o.a(jSONObject, "appChangeType", i2);
            aVar.L = jSONObject;
            g.a(aVar);
        }
    }

    public static JSONArray b(@NonNull List<AdTemplate> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, list)) == null) {
            JSONArray jSONArray = new JSONArray();
            for (AdTemplate adTemplate : list) {
                if (adTemplate != null) {
                    JSONObject jSONObject = new JSONObject();
                    com.kwad.sdk.utils.o.a(jSONObject, "photoId", com.kwad.sdk.core.response.b.c.z(adTemplate));
                    com.kwad.sdk.utils.o.a(jSONObject, "posId", adTemplate.posId);
                    com.kwad.sdk.utils.o.a(jSONArray, jSONObject);
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, null) == null) {
            g.a(new a(10101L));
        }
    }

    public static void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65569, null, i2) == null) {
            a aVar = new a(10107L);
            aVar.Q = i2;
            g.a(aVar);
        }
    }

    public static void b(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, null, adTemplate) == null) {
            a aVar = new a(6L, adTemplate);
            aVar.b();
            g.a(aVar);
        }
    }

    public static void b(@NonNull AdTemplate adTemplate, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65571, null, adTemplate, i2) == null) {
            a aVar = new a(21L, adTemplate);
            aVar.A = i2;
            g.a(aVar);
        }
    }

    public static void b(@NonNull AdTemplate adTemplate, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65572, null, adTemplate, i2, i3) == null) {
            a aVar = new a(LightappBusinessClient.SVC_ID_H5_BALANCE, adTemplate);
            aVar.b();
            aVar.H = com.kwad.sdk.core.response.b.c.c(adTemplate) ? com.kwad.sdk.core.response.b.a.a(com.kwad.sdk.core.response.b.c.j(adTemplate)) : com.kwad.sdk.core.response.b.c.l(adTemplate);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("what", i2);
                jSONObject.put("extra", i3);
                aVar.I = jSONObject.toString();
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.b(e2);
            }
            g.a(aVar);
        }
    }

    public static void b(AdTemplate adTemplate, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65573, null, adTemplate, i2, str) == null) {
            a aVar = new a(10109L);
            aVar.f36488a = adTemplate;
            aVar.Q = i2;
            aVar.S = str;
            g.a(aVar);
        }
    }

    public static void b(@NonNull AdTemplate adTemplate, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65574, null, adTemplate, j) == null) {
            a aVar = new a(14L, adTemplate);
            aVar.y = j;
            g.a(aVar);
        }
    }

    public static void b(@NonNull AdTemplate adTemplate, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65575, null, adTemplate, str) == null) || adTemplate.mContentPvReported) {
            return;
        }
        adTemplate.mContentPvReported = true;
        a aVar = new a(20L, adTemplate);
        aVar.w = str;
        g.a(aVar);
    }

    public static void b(@NonNull AdTemplate adTemplate, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65576, null, adTemplate, str, str2) == null) {
            a aVar = new a(33L, adTemplate);
            aVar.N = str;
            aVar.O = str2;
            g.a(aVar);
        }
    }

    public static void b(@NonNull SceneImpl sceneImpl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65577, null, sceneImpl) == null) {
            com.kwad.sdk.core.scene.a.a().a(sceneImpl);
            a aVar = new a(27L);
            aVar.f36489b = sceneImpl;
            g.a(aVar);
        }
    }

    public static void b(@NonNull SceneImpl sceneImpl, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65578, null, sceneImpl, i2) == null) {
            a aVar = new a(52L);
            aVar.f36489b = sceneImpl;
            aVar.M = i2;
            g.a(aVar);
        }
    }

    public static void b(@NonNull SceneImpl sceneImpl, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65579, null, new Object[]{sceneImpl, Long.valueOf(j), str}) == null) {
            a aVar = new a(42L);
            aVar.f36489b = sceneImpl;
            aVar.C = j;
            aVar.D = str;
            g.a(aVar);
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65580, null) == null) {
            g.a(new a(10106L));
        }
    }

    public static void c(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65581, null, adTemplate) == null) {
            g.a(new a(98L, adTemplate));
        }
    }

    public static void c(@NonNull AdTemplate adTemplate, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65582, null, adTemplate, i2) == null) {
            a aVar = new a(25L, adTemplate);
            TrendInfo trendInfo = adTemplate.photoInfo.trendInfo;
            aVar.D = trendInfo.name;
            aVar.C = trendInfo.trendId;
            aVar.E = i2;
            g.a(aVar);
        }
    }

    public static void c(@NonNull AdTemplate adTemplate, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65583, null, adTemplate, j) == null) {
            a aVar = new a(15L, adTemplate);
            aVar.y = j;
            g.a(aVar);
        }
    }

    public static void c(@NonNull AdTemplate adTemplate, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65584, null, adTemplate, str) == null) || adTemplate.mContentPvReported) {
            return;
        }
        adTemplate.mContentPvReported = true;
        a aVar = new a(20L, adTemplate);
        aVar.N = str;
        g.a(aVar);
    }

    public static void c(@NonNull AdTemplate adTemplate, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65585, null, adTemplate, str, str2) == null) {
            a aVar = new a(LightappBusinessClient.SVC_ID_H5_HOMEPAGE, adTemplate);
            aVar.H = str;
            aVar.I = str2;
            g.a(aVar);
        }
    }

    public static void c(@NonNull SceneImpl sceneImpl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65586, null, sceneImpl) == null) {
            com.kwad.sdk.core.scene.a.a().a(sceneImpl);
            a aVar = new a(29L);
            aVar.f36489b = sceneImpl;
            g.a(aVar);
        }
    }

    public static void c(@NonNull SceneImpl sceneImpl, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65587, null, new Object[]{sceneImpl, Long.valueOf(j), str}) == null) {
            a aVar = new a(44L);
            aVar.f36489b = sceneImpl;
            aVar.C = j;
            aVar.D = str;
            g.a(aVar);
        }
    }

    public static void d(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65588, null, adTemplate) == null) {
            g.a(new a(99L, adTemplate));
        }
    }

    public static void d(AdTemplate adTemplate, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65589, null, adTemplate, i2) == null) {
            a aVar = new a(10108L);
            aVar.Q = i2;
            aVar.f36488a = adTemplate;
            g.a(aVar);
        }
    }

    public static void d(@NonNull AdTemplate adTemplate, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65590, null, adTemplate, j) == null) {
            a aVar = new a(10202L, adTemplate);
            aVar.k = j;
            g.a(aVar);
        }
    }

    public static void d(@NonNull AdTemplate adTemplate, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65591, null, adTemplate, str, str2) == null) {
            a aVar = new a(LightappBusinessClient.SVC_ID_H5_TRANSERECORD, adTemplate);
            aVar.H = str;
            aVar.I = str2;
            g.a(aVar);
        }
    }

    public static void d(@NonNull SceneImpl sceneImpl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65592, null, sceneImpl) == null) {
            a aVar = new a(35L);
            aVar.f36489b = sceneImpl;
            g.a(aVar);
        }
    }

    public static void d(@NonNull SceneImpl sceneImpl, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65593, null, new Object[]{sceneImpl, Long.valueOf(j), str}) == null) {
            a aVar = new a(45L);
            aVar.f36489b = sceneImpl;
            aVar.C = j;
            aVar.D = str;
            g.a(aVar);
        }
    }

    public static void e(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65594, null, adTemplate) == null) {
            g.a(new a(9L, adTemplate));
        }
    }

    public static void e(@NonNull AdTemplate adTemplate, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65595, null, adTemplate, i2) == null) {
            com.kwad.sdk.core.d.a.a("BatchReportManager", "reportProfileGuideImpression guideTimes=" + i2);
            a aVar = new a(56L, adTemplate);
            aVar.T = i2;
            g.a(aVar);
        }
    }

    public static void e(@NonNull AdTemplate adTemplate, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65596, null, adTemplate, str, str2) == null) {
            a aVar = new a(LightappBusinessClient.SVC_ID_H5_MYBANKCARD, adTemplate);
            aVar.H = com.kwad.sdk.core.response.b.c.c(adTemplate) ? com.kwad.sdk.core.response.b.a.a(com.kwad.sdk.core.response.b.c.j(adTemplate)) : com.kwad.sdk.core.response.b.c.l(adTemplate);
            aVar.H = str;
            aVar.I = str2;
            g.a(aVar);
        }
    }

    public static void e(@NonNull SceneImpl sceneImpl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65597, null, sceneImpl) == null) {
            a aVar = new a(37L);
            aVar.f36489b = sceneImpl;
            g.a(aVar);
        }
    }

    public static void f(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65598, null, adTemplate) == null) {
            g.a(new a(12L, adTemplate));
        }
    }

    public static void f(@NonNull AdTemplate adTemplate, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65599, null, adTemplate, i2) == null) {
            com.kwad.sdk.core.d.a.a("BatchReportManager", "reportProfileGuideClick guideTimes=" + i2);
            a aVar = new a(57L, adTemplate);
            aVar.T = i2;
            g.a(aVar);
        }
    }

    public static void f(@NonNull SceneImpl sceneImpl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65600, null, sceneImpl) == null) {
            a aVar = new a(38L);
            aVar.f36489b = sceneImpl;
            g.a(aVar);
        }
    }

    public static void g(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65601, null, adTemplate) == null) {
            g.a(new a(13L, adTemplate));
        }
    }

    public static void h(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65602, null, adTemplate) == null) {
            g.a(new a(22L, adTemplate));
        }
    }

    public static void i(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65603, null, adTemplate) == null) {
            g.a(new a(23L, adTemplate));
        }
    }

    public static void j(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65604, null, adTemplate) == null) {
            a aVar = new a(24L, adTemplate);
            TrendInfo trendInfo = adTemplate.photoInfo.trendInfo;
            aVar.D = trendInfo.name;
            aVar.C = trendInfo.trendId;
            g.a(aVar);
        }
    }

    public static void k(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65605, null, adTemplate) == null) {
            g.a(new a(31L, adTemplate));
        }
    }

    public static void l(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65606, null, adTemplate) == null) {
            g.a(new a(32L, adTemplate));
        }
    }

    public static void m(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65607, null, adTemplate) == null) {
            g.a(new a(LightappBusinessClient.SVC_ID_H5_CASHBACK, adTemplate));
        }
    }

    public static void n(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65608, null, adTemplate) == null) {
            g.a(new a(49L, adTemplate));
        }
    }

    public static void o(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65609, null, adTemplate) == null) {
            g.a(new a(50L, adTemplate));
        }
    }

    public static void p(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65610, null, adTemplate) == null) {
            g.a(new a(53L, adTemplate));
        }
    }

    public static void q(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65611, null, adTemplate) == null) {
            g.a(new a(54L, adTemplate));
        }
    }

    public static void r(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65612, null, adTemplate) == null) {
            g.a(new a(72L, adTemplate));
        }
    }

    public static void s(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65613, null, adTemplate) == null) {
            g.a(new a(73L, adTemplate));
        }
    }
}
