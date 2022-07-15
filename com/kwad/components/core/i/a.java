package com.kwad.components.core.i;

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
import com.kwad.components.core.h.kwai.b;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.collector.f;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.utils.r;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.components.core.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0511a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-19059168, "Lcom/kwad/components/core/i/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-19059168, "Lcom/kwad/components/core/i/a$a;");
                    return;
                }
            }
            a = new a();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1273721789, "Lcom/kwad/components/core/i/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1273721789, "Lcom/kwad/components/core/i/a;");
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

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C0511a.a : (a) invokeV.objValue;
    }

    public static m a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j)) == null) ? new m(j) : (m) invokeJ.objValue;
    }

    public static m a(long j, AdTemplate adTemplate) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(InputDeviceCompat.SOURCE_TRACKBALL, null, j, adTemplate)) == null) ? new m(j, adTemplate) : (m) invokeJL.objValue;
    }

    public static m a(long j, AdTemplate adTemplate, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Long.valueOf(j), adTemplate, str})) == null) ? new m(j, adTemplate, str) : (m) invokeCommon.objValue;
    }

    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            m a2 = a(10104L);
            a2.U = i;
            e.a2(a2);
        }
    }

    public final void a(int i, @NonNull AdTemplate adTemplate, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, adTemplate, str) == null) {
            e.a2(a(i, adTemplate, str));
        }
    }

    public final void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            m a2 = a(j);
            if (j2 > 0) {
                a2.Z = j2;
            }
            e.a2(a2);
        }
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, context) == null) || a) {
            return;
        }
        a = true;
        m a2 = a(8L);
        a2.aA = f.a(context);
        e.a2(a2);
    }

    public final void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            m a2 = a(10215L);
            a2.at = bVar.a;
            a2.ax = bVar.b;
            a2.au = bVar.c;
            a2.av = bVar.d;
            e.a2(a2);
        }
    }

    public final void a(KsScene ksScene, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{ksScene, Boolean.valueOf(z), str}) == null) {
            m a2 = a(10216L);
            a2.ag = z;
            a2.ah = str;
            if (ksScene instanceof SceneImpl) {
                a2.b = (SceneImpl) ksScene;
            }
            e.a2(a2);
        }
    }

    public final void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, adTemplate) == null) {
            e.a2(a(10007L, adTemplate));
        }
    }

    public final void a(AdTemplate adTemplate, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, adTemplate, i) == null) {
            m a2 = a(10108L, adTemplate);
            a2.V = i;
            e.a2(a2);
        }
    }

    public final void a(@NonNull AdTemplate adTemplate, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, adTemplate, i, i2) == null) {
            m a2 = a(12006L, adTemplate);
            a2.O = i;
            a2.C = i2;
            e.a2(a2);
        }
    }

    public final void a(AdTemplate adTemplate, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048585, this, adTemplate, i, str) == null) {
            m a2 = a(adTemplate.isPlayAgainData ? 12300 : com.tencent.connect.common.Constants.REQUEST_EDIT_EMOTION, adTemplate);
            a2.V = 1;
            a2.W = str;
            e.a2(a2);
        }
    }

    public final void a(@NonNull AdTemplate adTemplate, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048586, this, adTemplate, j) == null) {
            m a2 = a(10202L, adTemplate);
            a2.ae = j;
            e.a2(a2);
        }
    }

    public final void a(@NonNull AdTemplate adTemplate, long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{adTemplate, Long.valueOf(j), Integer.valueOf(i)}) == null) {
            m a2 = a(104L, adTemplate);
            a2.ak = k.d(adTemplate);
            a2.al = j;
            a2.am = i;
            e.a2(a2);
        }
    }

    public final void a(@NonNull AdTemplate adTemplate, long j, long j2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{adTemplate, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) {
            m a2 = a(10203L, adTemplate);
            a2.v = j;
            a2.w = j2;
            a2.A = i;
            e.a2(a2);
        }
    }

    public final void a(@NonNull AdTemplate adTemplate, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, adTemplate, str, str2) == null) {
            m a2 = a(10001L, adTemplate);
            a2.Q = str;
            a2.R = str2;
            e.a2(a2);
        }
    }

    public final void a(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048590, this, str, str2, z) == null) {
            m a2 = a(12200L);
            a2.aH = str;
            a2.aI = str2;
            e.a(a2, z);
        }
    }

    public final void a(@NonNull JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONArray) == null) {
            m a2 = a(10200L);
            a2.Y = jSONArray;
            e.a2(a2);
        }
    }

    public final void a(@NonNull JSONObject jSONObject, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, jSONObject, i) == null) {
            m a2 = a(10201L);
            r.a(jSONObject, "appChangeType", i);
            a2.X = jSONObject;
            e.a2(a2);
        }
    }

    public final void a(boolean z, List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048593, this, z, list) == null) {
            m a2 = a(10204L);
            a2.ag = z;
            if (list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (Integer num : list) {
                    jSONArray.put(num);
                }
                a2.af = jSONArray;
            }
            e.a2(a2);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            e.a2(a(10101L));
        }
    }

    public final void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            m a2 = a(10107L);
            a2.V = i;
            e.a2(a2);
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, context) == null) {
            m a2 = a(11L);
            JSONArray[] a3 = InstalledAppInfoManager.a(context, d.c());
            a2.I = a3[0];
            a2.J = a3[1];
            e.a2(a2);
        }
    }

    public final void b(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, adTemplate) == null) {
            e.a2(a(10208L, adTemplate));
        }
    }

    public final void b(@NonNull AdTemplate adTemplate, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048598, this, adTemplate, i, i2) == null) {
            m a2 = a(10002L, adTemplate);
            a2.c();
            a2.Q = com.kwad.sdk.core.response.a.d.a(adTemplate) ? com.kwad.sdk.core.response.a.a.b(com.kwad.sdk.core.response.a.d.i(adTemplate)) : com.kwad.sdk.core.response.a.d.k(adTemplate);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("what", i);
                jSONObject.put("extra", i2);
                a2.R = jSONObject.toString();
            } catch (JSONException e) {
                com.kwad.sdk.core.d.b.b(e);
            }
            e.a2(a2);
        }
    }

    public final void b(@NonNull AdTemplate adTemplate, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048599, this, adTemplate, i, str) == null) {
            m a2 = a(107L, adTemplate);
            a2.S = i;
            a2.R = str;
            e.a2(a2);
        }
    }

    public final void b(AdTemplate adTemplate, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048600, this, adTemplate, j) == null) {
            m a2 = a(10206L, adTemplate);
            a2.ay = j;
            e.a2(a2);
        }
    }

    public final void b(@NonNull AdTemplate adTemplate, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048601, this, adTemplate, str, str2) == null) {
            m a2 = a(10003L, adTemplate);
            a2.Q = str;
            a2.R = str2;
            e.a2(a2);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            e.a2(a(10106L));
        }
    }

    public final void c(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, adTemplate) == null) {
            e.a2(a(10209L, adTemplate));
        }
    }

    public final void c(AdTemplate adTemplate, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048604, this, adTemplate, j) == null) {
            m a2 = a(10207L, adTemplate);
            a2.az = j;
            e.a2(a2);
        }
    }

    public final void c(@NonNull AdTemplate adTemplate, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048605, this, adTemplate, str, str2) == null) {
            m a2 = a(10005L, adTemplate);
            a2.Q = com.kwad.sdk.core.response.a.d.a(adTemplate) ? com.kwad.sdk.core.response.a.a.b(com.kwad.sdk.core.response.a.d.i(adTemplate)) : com.kwad.sdk.core.response.a.d.k(adTemplate);
            a2.Q = str;
            a2.R = str2;
            e.a2(a2);
        }
    }
}
