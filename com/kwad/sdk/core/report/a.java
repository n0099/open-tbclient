package com.kwad.sdk.core.report;

import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.z;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static ExecutorService a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.sdk.core.report.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2086a extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f58233b;

        public C2086a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i2;
            this.f58233b = str;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-615486496, "Lcom/kwad/sdk/core/report/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-615486496, "Lcom/kwad/sdk/core/report/a;");
                return;
            }
        }
        a = com.kwad.sdk.core.i.b.g();
    }

    public static void a(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, adTemplate) == null) {
            g(adTemplate, 4);
        }
    }

    public static void a(@Nullable AdTemplate adTemplate, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, adTemplate, i2) == null) {
            p.a aVar = new p.a();
            aVar.f58269i = i2;
            a(adTemplate, (int) MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, aVar, (JSONObject) null);
        }
    }

    public static void a(AdTemplate adTemplate, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65539, null, adTemplate, i2, i3) == null) {
            p.a aVar = new p.a();
            aVar.f58264d = 69;
            aVar.r = i2;
            aVar.s = i3;
            a(adTemplate, 501, aVar, (JSONObject) null);
        }
    }

    public static void a(AdTemplate adTemplate, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(InputDeviceCompat.SOURCE_TRACKBALL, null, adTemplate, i2, i3, i4) == null) {
            p.a aVar = new p.a();
            aVar.f58264d = i2;
            aVar.r = i3;
            aVar.s = i4;
            a(adTemplate, 141, aVar, (JSONObject) null);
        }
    }

    public static void a(AdTemplate adTemplate, int i2, long j2, int i3, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{adTemplate, Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), jSONObject}) == null) {
            p.a aVar = new p.a();
            aVar.x = j2;
            aVar.y = i3;
            aVar.f58263c = i2;
            a(adTemplate, 3, aVar, jSONObject);
        }
    }

    public static void a(AdTemplate adTemplate, int i2, AdExposureFailedReason adExposureFailedReason) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65542, null, adTemplate, i2, adExposureFailedReason) == null) {
            if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) {
                p.a aVar = new p.a();
                aVar.f58265e = i2;
                if (adExposureFailedReason != null) {
                    aVar.f58266f = adExposureFailedReason.winEcpm;
                }
                a(adTemplate, 809, aVar, (JSONObject) null);
            }
        }
    }

    public static void a(@Nullable AdTemplate adTemplate, int i2, @Nullable p.a aVar, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(65543, null, adTemplate, i2, aVar, jSONObject) == null) && adTemplate != null && q(adTemplate)) {
            if (aVar == null) {
                aVar = new p.a();
            }
            aVar.v = com.kwad.sdk.core.response.a.a.H(com.kwad.sdk.core.response.a.d.j(adTemplate));
            com.kwad.sdk.core.d.a.a("AdReportManager", i2 + "");
            new o(adTemplate, i2, aVar, jSONObject) { // from class: com.kwad.sdk.core.report.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdTemplate a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f58230b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ p.a f58231c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ JSONObject f58232d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {adTemplate, Integer.valueOf(i2), aVar, jSONObject};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = adTemplate;
                    this.f58230b = i2;
                    this.f58231c = aVar;
                    this.f58232d = jSONObject;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: a */
                public p b() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new p(this.a, this.f58230b, this.f58231c, this.f58232d) : (p) invokeV.objValue;
                }
            }.d();
        }
    }

    public static void a(AdTemplate adTemplate, int i2, @Nullable z.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65544, null, adTemplate, i2, aVar) == null) {
            p.a aVar2 = new p.a();
            aVar2.f58262b = i2;
            if (aVar != null) {
                aVar2.f58267g = aVar;
            }
            a(adTemplate, 2, aVar2, (JSONObject) null);
        }
    }

    public static void a(AdTemplate adTemplate, int i2, z.a aVar, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65545, null, adTemplate, i2, aVar, jSONObject) == null) {
            p.a aVar2 = new p.a();
            aVar2.f58262b = i2;
            aVar2.f58267g = aVar;
            a(adTemplate, 2, aVar2, jSONObject);
        }
    }

    public static void a(AdTemplate adTemplate, int i2, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65546, null, adTemplate, i2, jSONObject) == null) {
            p.a aVar = new p.a();
            aVar.f58263c = i2;
            a(adTemplate, 3, aVar, jSONObject);
        }
    }

    public static void a(AdTemplate adTemplate, int i2, JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65547, null, adTemplate, i2, jSONObject, str) == null) {
            p.a aVar = new p.a();
            aVar.f58268h = str;
            a(adTemplate, i2, aVar, jSONObject);
        }
    }

    public static void a(AdTemplate adTemplate, C2086a c2086a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, adTemplate, c2086a) == null) {
            p.a aVar = new p.a();
            if (c2086a != null) {
                aVar.m = c2086a.toJson().toString();
            }
            a(adTemplate, 40, aVar, (JSONObject) null);
        }
    }

    public static void a(@Nullable AdTemplate adTemplate, p.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, adTemplate, aVar) == null) {
            a(adTemplate, 50, aVar, (JSONObject) null);
        }
    }

    public static void a(AdTemplate adTemplate, p.a aVar, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, adTemplate, aVar, jSONObject) == null) {
            a(adTemplate, 2, aVar, jSONObject);
        }
    }

    public static void a(AdTemplate adTemplate, z.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, adTemplate, aVar) == null) {
            p.a aVar2 = new p.a();
            aVar2.f58267g = aVar;
            a(adTemplate, 2, aVar2, (JSONObject) null);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, adTemplate, jSONObject) == null) {
            a(adTemplate, jSONObject, (p.a) null);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable p.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65553, null, adTemplate, jSONObject, aVar) == null) || adTemplate.mPvReported) {
            return;
        }
        adTemplate.mPvReported = true;
        a(adTemplate, 1, aVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable p.a aVar, z.a aVar2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65554, null, adTemplate, jSONObject, aVar, aVar2, str) == null) {
            if (aVar == null) {
                aVar = new p.a();
            }
            aVar.f58267g = aVar2;
            aVar.f58268h = str;
            a(adTemplate, 2, aVar, jSONObject);
        }
    }

    public static void a(AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable p.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65555, null, adTemplate, jSONObject, aVar, str) == null) {
            if (aVar == null) {
                aVar = new p.a();
            }
            aVar.f58268h = str;
            a(adTemplate, 2, aVar, jSONObject);
        }
    }

    public static void b(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, adTemplate) == null) {
            p.a aVar = new p.a();
            aVar.f58270j = adTemplate.downloadSource;
            a(adTemplate, 30, aVar, (JSONObject) null);
        }
    }

    public static void b(@Nullable AdTemplate adTemplate, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65557, null, adTemplate, i2) == null) {
            p.a aVar = new p.a();
            aVar.f58269i = i2;
            a(adTemplate, 321, aVar, (JSONObject) null);
        }
    }

    public static void b(AdTemplate adTemplate, int i2, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65558, null, adTemplate, i2, jSONObject) == null) {
            p.a aVar = new p.a();
            aVar.a = i2;
            a(adTemplate, 402, aVar, jSONObject);
        }
    }

    public static void b(@Nullable AdTemplate adTemplate, p.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, null, adTemplate, aVar) == null) {
            a(adTemplate, 51, aVar, (JSONObject) null);
        }
    }

    public static void b(AdTemplate adTemplate, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65560, null, adTemplate, jSONObject) == null) {
            e(adTemplate, 601, jSONObject);
        }
    }

    public static void c(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, adTemplate) == null) {
            a.submit(new Runnable(adTemplate) { // from class: com.kwad.sdk.core.report.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdTemplate a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {adTemplate};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = adTemplate;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.a);
                        int b2 = ag.b(j2.downloadId, com.kwad.sdk.core.response.a.a.v(j2));
                        p.a aVar = new p.a();
                        AdTemplate adTemplate2 = this.a;
                        aVar.f58270j = adTemplate2.downloadSource;
                        aVar.f58271k = b2;
                        aVar.l = adTemplate2.installFrom;
                        a.a(adTemplate2, 32, aVar, (JSONObject) null);
                    }
                }
            });
        }
    }

    public static void c(@Nullable AdTemplate adTemplate, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65562, null, adTemplate, i2) == null) {
            p.a aVar = new p.a();
            aVar.f58269i = i2;
            a(adTemplate, 803, aVar, (JSONObject) null);
        }
    }

    public static void c(AdTemplate adTemplate, int i2, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65563, null, adTemplate, i2, jSONObject) == null) {
            p.a aVar = new p.a();
            aVar.f58264d = i2;
            a(adTemplate, (int) PbFullScreenEditorActivity.REPLY_MAX_SIZE, aVar, jSONObject);
        }
    }

    public static void c(@Nullable AdTemplate adTemplate, p.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65564, null, adTemplate, aVar) == null) {
            a(adTemplate, 52, aVar, (JSONObject) null);
        }
    }

    public static void c(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65565, null, adTemplate, jSONObject) == null) {
            p.a aVar = new p.a();
            aVar.f58270j = adTemplate.downloadSource;
            a(adTemplate, 33, aVar, jSONObject);
        }
    }

    public static void d(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, null, adTemplate) == null) {
            g(adTemplate, 36);
        }
    }

    public static void d(AdTemplate adTemplate, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65567, null, adTemplate, i2) == null) || adTemplate == null) {
            return;
        }
        p.a aVar = new p.a();
        aVar.p = com.kwad.sdk.core.response.a.a.v(com.kwad.sdk.core.response.a.d.j(adTemplate));
        a(adTemplate, i2, aVar, new JSONObject());
    }

    public static void d(AdTemplate adTemplate, int i2, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65568, null, adTemplate, i2, jSONObject) == null) {
            p.a aVar = new p.a();
            aVar.p = com.kwad.sdk.core.response.a.a.v(com.kwad.sdk.core.response.a.d.j(adTemplate));
            aVar.f58264d = i2;
            a(adTemplate, (int) PbFullScreenEditorActivity.REPLY_MAX_SIZE, aVar, jSONObject);
        }
    }

    public static void d(@Nullable AdTemplate adTemplate, p.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65569, null, adTemplate, aVar) == null) {
            a(adTemplate, 59, aVar, (JSONObject) null);
        }
    }

    public static void d(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65570, null, adTemplate, jSONObject) == null) {
            p.a aVar = new p.a();
            aVar.f58270j = adTemplate.downloadSource;
            a(adTemplate, 34, aVar, jSONObject);
        }
    }

    public static void e(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, null, adTemplate) == null) {
            g(adTemplate, 38);
        }
    }

    public static void e(AdTemplate adTemplate, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65572, null, adTemplate, i2) == null) {
            a(adTemplate, i2, new p.a(), new JSONObject());
        }
    }

    public static void e(AdTemplate adTemplate, int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65573, null, adTemplate, i2, jSONObject) == null) {
            a(adTemplate, i2, (p.a) null, jSONObject);
        }
    }

    public static void e(AdTemplate adTemplate, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65575, null, adTemplate, jSONObject) == null) {
            a.submit(new Runnable(adTemplate, jSONObject) { // from class: com.kwad.sdk.core.report.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdTemplate a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ JSONObject f58229b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {adTemplate, jSONObject};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = adTemplate;
                    this.f58229b = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        p.a aVar = new p.a();
                        AdTemplate adTemplate2 = this.a;
                        aVar.f58270j = adTemplate2.downloadSource;
                        a.f(adTemplate2, aVar);
                        a.a(this.a, 31, aVar, this.f58229b);
                        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.a);
                        ag.a(j2.downloadFilePath, j2.downloadId);
                    }
                }
            });
        }
    }

    public static void f(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65576, null, adTemplate) == null) {
            g(adTemplate, 41);
        }
    }

    public static void f(AdTemplate adTemplate, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65577, null, adTemplate, i2) == null) {
            p.a aVar = new p.a();
            aVar.f58264d = i2;
            a(adTemplate, 141, aVar, (JSONObject) null);
        }
    }

    public static void f(AdTemplate adTemplate, p.a aVar) {
        AdInfo j2;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65578, null, adTemplate, aVar) == null) || (str = (j2 = com.kwad.sdk.core.response.a.d.j(adTemplate)).downloadFilePath) == null) {
            return;
        }
        String v = com.kwad.sdk.core.response.a.a.v(j2);
        String a2 = ag.a(str);
        if (a2 == null || TextUtils.isEmpty(a2) || a2.equals(v)) {
            return;
        }
        aVar.q = a2;
        aVar.p = v;
        j2.adBaseInfo.appPackageName = a2;
    }

    public static void f(AdTemplate adTemplate, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65579, null, adTemplate, jSONObject) == null) {
            p.a aVar = new p.a();
            aVar.f58270j = adTemplate.downloadSource;
            a(adTemplate, 35, aVar, jSONObject);
        }
    }

    public static void g(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65580, null, adTemplate) == null) {
            p.a aVar = new p.a();
            aVar.p = com.kwad.sdk.core.response.a.a.v(com.kwad.sdk.core.response.a.d.j(adTemplate));
            a(adTemplate, 768, aVar, new JSONObject());
        }
    }

    public static void g(AdTemplate adTemplate, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65581, null, adTemplate, i2) == null) {
            a(adTemplate, i2, (p.a) null, new JSONObject());
        }
    }

    public static void g(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65582, null, adTemplate, jSONObject) == null) {
            e(adTemplate, 399, jSONObject);
        }
    }

    public static void h(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65583, null, adTemplate) == null) {
            g(adTemplate, 37);
        }
    }

    public static void h(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65584, null, adTemplate, jSONObject) == null) {
            e(adTemplate, 400, jSONObject);
        }
    }

    public static void i(@Nullable AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65585, null, adTemplate) == null) {
            g(adTemplate, (JSONObject) null);
        }
    }

    public static void i(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65586, null, adTemplate, jSONObject) == null) {
            e(adTemplate, 501, jSONObject);
        }
    }

    public static void j(@Nullable AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65587, null, adTemplate) == null) {
            h(adTemplate, null);
        }
    }

    public static void j(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65588, null, adTemplate, jSONObject) == null) {
            e(adTemplate, 450, jSONObject);
        }
    }

    public static void k(@Nullable AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65589, null, adTemplate) == null) {
            g(adTemplate, 323);
        }
    }

    public static void k(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65590, null, adTemplate, jSONObject) == null) {
            e(adTemplate, 451, jSONObject);
        }
    }

    public static void l(@Nullable AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65591, null, adTemplate) == null) {
            g(adTemplate, 58);
        }
    }

    public static void m(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65592, null, adTemplate) == null) {
            a(adTemplate, 600, (p.a) null, (JSONObject) null);
        }
    }

    public static void n(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65593, null, adTemplate) == null) {
            p.a aVar = new p.a();
            aVar.u = com.kwad.sdk.core.response.a.a.ag(com.kwad.sdk.core.response.a.d.j(adTemplate));
            com.kwad.sdk.core.d.a.a("AdReportManager", "reportDownloadCardClose downloadStatus=" + aVar.u);
            a(adTemplate, 713, aVar, (JSONObject) null);
        }
    }

    public static void o(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65594, null, adTemplate) == null) {
            g(adTemplate, 722);
        }
    }

    public static void p(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65595, null, adTemplate) == null) {
            g(adTemplate, 721);
        }
    }

    public static boolean q(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65596, null, adTemplate)) == null) ? com.kwad.sdk.core.response.a.d.c(adTemplate) || com.kwad.sdk.core.response.a.d.a(adTemplate) : invokeL.booleanValue;
    }
}
