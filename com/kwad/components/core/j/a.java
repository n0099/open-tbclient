package com.kwad.components.core.j;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.i.kwai.b;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.collector.f;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.utils.r;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static boolean HG;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.components.core.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0581a {
        public static /* synthetic */ Interceptable $ic;
        public static final a HH;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(9569983, "Lcom/kwad/components/core/j/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(9569983, "Lcom/kwad/components/core/j/a$a;");
                    return;
                }
            }
            HH = new a();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1273751580, "Lcom/kwad/components/core/j/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1273751580, "Lcom/kwad/components/core/j/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static m a(long j, AdTemplate adTemplate, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), adTemplate, str})) == null) ? new m(j, adTemplate, str) : (m) invokeCommon.objValue;
    }

    public static m b(long j, AdTemplate adTemplate) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, adTemplate)) == null) ? new m(j, adTemplate) : (m) invokeJL.objValue;
    }

    public static m o(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, null, j)) == null) ? new m(j) : (m) invokeJ.objValue;
    }

    public static a og() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? C0581a.HH : (a) invokeV.objValue;
    }

    public final void O(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adTemplate) == null) {
            e.a2(b(10007L, adTemplate));
        }
    }

    public final void P(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            e.a2(b(10208L, adTemplate));
        }
    }

    public final void Q(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adTemplate) == null) {
            e.a2(b(10209L, adTemplate));
        }
    }

    public final void a(int i, @NonNull AdTemplate adTemplate, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i, adTemplate, str) == null) {
            e.a2(a(i, adTemplate, str));
        }
    }

    public final void a(long j, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) && d.su()) {
            m o = o(20000L);
            o.timestamp = System.currentTimeMillis();
            o.abm = i;
            o.posId = j;
            o.abn = BuildConfig.VERSION_CODE;
            e.a2(o);
        }
    }

    public final void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            m o = o(10215L);
            o.Hx = bVar.Hx;
            o.HD = bVar.HD;
            o.HE = bVar.HE;
            o.HF = bVar.HF;
            e.a2(o);
        }
    }

    public final void a(KsScene ksScene, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{ksScene, Boolean.valueOf(z), str}) == null) {
            m o = o(10216L);
            o.aaN = z;
            o.aaO = str;
            if (ksScene instanceof SceneImpl) {
                o.HS = (SceneImpl) ksScene;
            }
            e.a2(o);
        }
    }

    public final void a(@NonNull AdTemplate adTemplate, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048583, this, adTemplate, i, i2) == null) {
            m b = b(12006L, adTemplate);
            b.Mo = i;
            b.aat = i2;
            e.a2(b);
        }
    }

    public final void a(@NonNull AdTemplate adTemplate, long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{adTemplate, Long.valueOf(j), Integer.valueOf(i)}) == null) {
            m b = b(104L, adTemplate);
            b.clickTime = k.ck(adTemplate);
            b.aaR = j;
            b.aaS = i;
            e.a2(b);
        }
    }

    public final void a(@NonNull AdTemplate adTemplate, long j, long j2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{adTemplate, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) {
            m b = b(10203L, adTemplate);
            b.aao = j;
            b.blockDuration = j2;
            b.aas = i;
            e.a2(b);
        }
    }

    public final void a(@NonNull AdTemplate adTemplate, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, adTemplate, str, str2) == null) {
            m b = b(10001L, adTemplate);
            b.failUrl = str;
            b.errorMsg = str2;
            e.a2(b);
        }
    }

    public final void a(boolean z, List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048587, this, z, list) == null) {
            m o = o(10204L);
            o.aaN = z;
            if (list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (Integer num : list) {
                    jSONArray.put(num);
                }
                o.aaM = jSONArray;
            }
            e.a2(o);
        }
    }

    public final void am(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            m o = o(10104L);
            o.aaD = i;
            e.a2(o);
        }
    }

    public final void an(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            m o = o(10107L);
            o.aaE = i;
            e.a2(o);
        }
    }

    public final void ap(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, context) == null) || HG) {
            return;
        }
        HG = true;
        m o = o(8L);
        o.abd = f.aL(context);
        e.a2(o);
    }

    public final void aq(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, context) == null) {
            m o = o(11L);
            JSONArray[] c = InstalledAppInfoManager.c(context, d.lD());
            o.aaw = c[0];
            o.aax = c[1];
            e.a2(o);
        }
    }

    public final void b(@NonNull AdTemplate adTemplate, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048592, this, adTemplate, i, i2) == null) {
            m b = b(10002L, adTemplate);
            b.uA();
            b.failUrl = com.kwad.sdk.core.response.a.d.bI(adTemplate) ? com.kwad.sdk.core.response.a.a.A(com.kwad.sdk.core.response.a.d.bQ(adTemplate)) : com.kwad.sdk.core.response.a.d.bS(adTemplate);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("what", i);
                jSONObject.put("extra", i2);
                b.errorMsg = jSONObject.toString();
            } catch (JSONException e) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            }
            e.a2(b);
        }
    }

    public final void b(AdTemplate adTemplate, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048593, this, adTemplate, i, str) == null) {
            m b = b(adTemplate.isPlayAgainData ? 12300 : com.tencent.connect.common.Constants.REQUEST_EDIT_EMOTION, adTemplate);
            b.aaE = 1;
            b.aaF = str;
            e.a2(b);
        }
    }

    public final void b(@NonNull AdTemplate adTemplate, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, adTemplate, str, str2) == null) {
            m b = b(10003L, adTemplate);
            b.failUrl = str;
            b.errorMsg = str2;
            e.a2(b);
        }
    }

    public final void c(@NonNull AdTemplate adTemplate, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048595, this, adTemplate, i, str) == null) {
            m b = b(107L, adTemplate);
            b.errorCode = i;
            b.errorMsg = str;
            e.a2(b);
        }
    }

    public final void c(@NonNull AdTemplate adTemplate, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048596, this, adTemplate, j) == null) {
            m b = b(10202L, adTemplate);
            b.aaL = j;
            e.a2(b);
        }
    }

    public final void c(@NonNull AdTemplate adTemplate, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048597, this, adTemplate, str, str2) == null) {
            m b = b(10005L, adTemplate);
            b.failUrl = com.kwad.sdk.core.response.a.d.bI(adTemplate) ? com.kwad.sdk.core.response.a.a.A(com.kwad.sdk.core.response.a.d.bQ(adTemplate)) : com.kwad.sdk.core.response.a.d.bS(adTemplate);
            b.failUrl = str;
            b.errorMsg = str2;
            e.a2(b);
        }
    }

    public final void c(@NonNull JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, jSONArray) == null) {
            m o = o(10200L);
            o.aaH = jSONArray;
            e.a2(o);
        }
    }

    public final void d(AdTemplate adTemplate, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048599, this, adTemplate, i) == null) {
            m b = b(10108L, adTemplate);
            b.aaE = i;
            e.a2(b);
        }
    }

    public final void d(AdTemplate adTemplate, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048600, this, adTemplate, j) == null) {
            m b = b(10206L, adTemplate);
            b.abb = j;
            e.a2(b);
        }
    }

    public final void e(@NonNull AdTemplate adTemplate, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048601, this, adTemplate, i) == null) && d.su()) {
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            m o = o(20000L);
            o.timestamp = System.currentTimeMillis();
            o.abm = i;
            o.trace = bQ.trace;
            o.abn = BuildConfig.VERSION_CODE;
            o.posId = com.kwad.sdk.core.response.a.d.bJ(adTemplate);
            e.a2(o);
        }
    }

    public final void e(AdTemplate adTemplate, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048602, this, adTemplate, j) == null) {
            m b = b(10207L, adTemplate);
            b.abc = j;
            e.a2(b);
        }
    }

    public final void e(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048603, this, str, str2, z) == null) {
            m o = o(12200L);
            o.abk = str;
            o.abl = str2;
            e.a(o, z);
        }
    }

    public final void e(@NonNull JSONObject jSONObject, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048604, this, jSONObject, i) == null) {
            m o = o(10201L);
            r.putValue(jSONObject, "appChangeType", i);
            o.aaG = jSONObject;
            e.a2(o);
        }
    }

    public final void oh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            e.a2(o(10101L));
        }
    }

    public final void oi() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            e.a2(o(10106L));
        }
    }
}
