package com.kwad.sdk.core.report;

import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.v;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static ExecutorService f35032a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.sdk.core.report.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0423a extends com.kwad.sdk.core.response.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f35040a;

        /* renamed from: b  reason: collision with root package name */
        public String f35041b;

        public C0423a(int i2, String str) {
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
            this.f35040a = i2;
            this.f35041b = str;
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
        f35032a = com.kwad.sdk.core.i.b.g();
    }

    public static void a(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, adTemplate) == null) {
            f(adTemplate, 4);
        }
    }

    public static void a(@Nullable AdTemplate adTemplate, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, adTemplate, i2) == null) {
            n.a aVar = new n.a();
            aVar.f35092g = i2;
            a(adTemplate, (int) MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, aVar, (JSONObject) null);
        }
    }

    public static void a(AdTemplate adTemplate, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65539, null, adTemplate, i2, i3) == null) {
            n.a aVar = new n.a();
            aVar.f35089d = 69;
            aVar.p = i2;
            aVar.q = i3;
            a(adTemplate, 141, aVar, (JSONObject) null);
        }
    }

    public static void a(AdTemplate adTemplate, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(InputDeviceCompat.SOURCE_TRACKBALL, null, adTemplate, i2, i3, i4) == null) {
            n.a aVar = new n.a();
            aVar.f35089d = i2;
            aVar.p = i3;
            aVar.q = i4;
            a(adTemplate, 141, aVar, (JSONObject) null);
        }
    }

    public static void a(@Nullable AdTemplate adTemplate, int i2, @Nullable n.a aVar, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(AdIconUtil.AD_TEXT_ID, null, adTemplate, i2, aVar, jSONObject) == null) && adTemplate != null && com.kwad.sdk.core.response.b.c.b(adTemplate)) {
            if (aVar == null) {
                aVar = new n.a();
            }
            aVar.t = com.kwad.sdk.core.response.b.a.z(com.kwad.sdk.core.response.b.c.i(adTemplate));
            com.kwad.sdk.core.d.a.a("AdReportManager", i2 + "");
            new m(adTemplate, i2, aVar, jSONObject) { // from class: com.kwad.sdk.core.report.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdTemplate f35036a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f35037b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ n.a f35038c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ JSONObject f35039d;

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
                    this.f35036a = adTemplate;
                    this.f35037b = i2;
                    this.f35038c = aVar;
                    this.f35039d = jSONObject;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: a */
                public n b() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new n(this.f35036a, this.f35037b, this.f35038c, this.f35039d) : (n) invokeV.objValue;
                }
            }.d();
        }
    }

    public static void a(AdTemplate adTemplate, int i2, @Nullable v.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(AdIconUtil.BAIDU_LOGO_ID, null, adTemplate, i2, aVar) == null) {
            n.a aVar2 = new n.a();
            aVar2.f35087b = i2;
            if (aVar != null) {
                aVar2.f35090e = aVar;
            }
            a(adTemplate, 2, aVar2, (JSONObject) null);
        }
    }

    public static void a(AdTemplate adTemplate, int i2, v.a aVar, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65543, null, adTemplate, i2, aVar, jSONObject) == null) {
            n.a aVar2 = new n.a();
            aVar2.f35087b = i2;
            aVar2.f35090e = aVar;
            a(adTemplate, 2, aVar2, jSONObject);
        }
    }

    public static void a(AdTemplate adTemplate, int i2, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65544, null, adTemplate, i2, jSONObject) == null) {
            n.a aVar = new n.a();
            aVar.f35088c = i2;
            a(adTemplate, 3, aVar, jSONObject);
        }
    }

    public static void a(AdTemplate adTemplate, int i2, JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65545, null, adTemplate, i2, jSONObject, str) == null) {
            n.a aVar = new n.a();
            aVar.f35091f = str;
            a(adTemplate, i2, aVar, jSONObject);
        }
    }

    public static void a(AdTemplate adTemplate, C0423a c0423a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, adTemplate, c0423a) == null) {
            n.a aVar = new n.a();
            if (c0423a != null) {
                aVar.k = c0423a.toJson().toString();
            }
            a(adTemplate, 40, aVar, (JSONObject) null);
        }
    }

    public static void a(@Nullable AdTemplate adTemplate, n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, adTemplate, aVar) == null) {
            a(adTemplate, 50, aVar, (JSONObject) null);
        }
    }

    public static void a(AdTemplate adTemplate, v.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, adTemplate, aVar) == null) {
            n.a aVar2 = new n.a();
            aVar2.f35090e = aVar;
            a(adTemplate, 2, aVar2, (JSONObject) null);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, adTemplate, jSONObject) == null) {
            a(adTemplate, jSONObject, (n.a) null);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable n.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65550, null, adTemplate, jSONObject, aVar) == null) || adTemplate.mPvReported) {
            return;
        }
        adTemplate.mPvReported = true;
        a(adTemplate, 1, aVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable n.a aVar, v.a aVar2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65551, null, adTemplate, jSONObject, aVar, aVar2, str) == null) {
            if (aVar == null) {
                aVar = new n.a();
            }
            aVar.f35090e = aVar2;
            aVar.f35091f = str;
            a(adTemplate, 2, aVar, jSONObject);
        }
    }

    public static void a(AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable n.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65552, null, adTemplate, jSONObject, aVar, str) == null) {
            if (aVar == null) {
                aVar = new n.a();
            }
            aVar.f35091f = str;
            a(adTemplate, 2, aVar, jSONObject);
        }
    }

    public static void a(AdTemplate adTemplate, @Nullable JSONObject jSONObject, v.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65553, null, adTemplate, jSONObject, aVar, str) == null) {
            n.a aVar2 = new n.a();
            aVar2.f35090e = aVar;
            aVar2.f35091f = str;
            a(adTemplate, 2, aVar2, jSONObject);
        }
    }

    public static void b(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, adTemplate) == null) {
            n.a aVar = new n.a();
            aVar.f35093h = adTemplate.downloadSource;
            a(adTemplate, 30, aVar, (JSONObject) null);
        }
    }

    public static void b(@Nullable AdTemplate adTemplate, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65555, null, adTemplate, i2) == null) {
            n.a aVar = new n.a();
            aVar.f35092g = i2;
            a(adTemplate, 321, aVar, (JSONObject) null);
        }
    }

    public static void b(AdTemplate adTemplate, int i2, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65556, null, adTemplate, i2, jSONObject) == null) {
            n.a aVar = new n.a();
            aVar.f35086a = i2;
            a(adTemplate, 402, aVar, jSONObject);
        }
    }

    public static void b(@Nullable AdTemplate adTemplate, n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, null, adTemplate, aVar) == null) {
            a(adTemplate, 51, aVar, (JSONObject) null);
        }
    }

    public static void b(AdTemplate adTemplate, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, null, adTemplate, jSONObject) == null) {
            e(adTemplate, 601, jSONObject);
        }
    }

    public static void c(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, adTemplate) == null) {
            f35032a.submit(new Runnable(adTemplate) { // from class: com.kwad.sdk.core.report.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdTemplate f35035a;

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
                    this.f35035a = adTemplate;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        AdInfo i2 = com.kwad.sdk.core.response.b.c.i(this.f35035a);
                        int b2 = ac.b(i2.downloadId, com.kwad.sdk.core.response.b.a.q(i2));
                        n.a aVar = new n.a();
                        AdTemplate adTemplate2 = this.f35035a;
                        aVar.f35093h = adTemplate2.downloadSource;
                        aVar.f35094i = b2;
                        aVar.j = adTemplate2.installFrom;
                        a.a(adTemplate2, 32, aVar, (JSONObject) null);
                    }
                }
            });
        }
    }

    public static void c(AdTemplate adTemplate, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65560, null, adTemplate, i2) == null) {
            n.a aVar = new n.a();
            aVar.n = com.kwad.sdk.core.response.b.a.q(com.kwad.sdk.core.response.b.c.i(adTemplate));
            a(adTemplate, i2, aVar, new JSONObject());
        }
    }

    public static void c(AdTemplate adTemplate, int i2, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65561, null, adTemplate, i2, jSONObject) == null) {
            n.a aVar = new n.a();
            aVar.f35089d = i2;
            a(adTemplate, (int) PbFullScreenEditorActivity.REPLY_MAX_SIZE, aVar, jSONObject);
        }
    }

    public static void c(@Nullable AdTemplate adTemplate, n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65562, null, adTemplate, aVar) == null) {
            a(adTemplate, 52, aVar, (JSONObject) null);
        }
    }

    public static void c(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65563, null, adTemplate, jSONObject) == null) {
            n.a aVar = new n.a();
            aVar.f35093h = adTemplate.downloadSource;
            a(adTemplate, 33, aVar, jSONObject);
        }
    }

    public static void d(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, adTemplate) == null) {
            f(adTemplate, 36);
        }
    }

    public static void d(AdTemplate adTemplate, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65565, null, adTemplate, i2) == null) {
            a(adTemplate, i2, new n.a(), new JSONObject());
        }
    }

    public static void d(AdTemplate adTemplate, int i2, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65566, null, adTemplate, i2, jSONObject) == null) {
            n.a aVar = new n.a();
            aVar.n = com.kwad.sdk.core.response.b.a.q(com.kwad.sdk.core.response.b.c.i(adTemplate));
            aVar.f35089d = i2;
            a(adTemplate, (int) PbFullScreenEditorActivity.REPLY_MAX_SIZE, aVar, jSONObject);
        }
    }

    public static void d(@Nullable AdTemplate adTemplate, n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65567, null, adTemplate, aVar) == null) {
            a(adTemplate, 59, aVar, (JSONObject) null);
        }
    }

    public static void d(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65568, null, adTemplate, jSONObject) == null) {
            n.a aVar = new n.a();
            aVar.f35093h = adTemplate.downloadSource;
            a(adTemplate, 34, aVar, jSONObject);
        }
    }

    public static void e(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65569, null, adTemplate) == null) {
            f(adTemplate, 38);
        }
    }

    public static void e(AdTemplate adTemplate, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65570, null, adTemplate, i2) == null) {
            n.a aVar = new n.a();
            aVar.f35089d = i2;
            a(adTemplate, 141, aVar, (JSONObject) null);
        }
    }

    public static void e(AdTemplate adTemplate, int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65571, null, adTemplate, i2, jSONObject) == null) {
            a(adTemplate, i2, (n.a) null, jSONObject);
        }
    }

    public static void e(AdTemplate adTemplate, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65573, null, adTemplate, jSONObject) == null) {
            f35032a.submit(new Runnable(adTemplate, jSONObject) { // from class: com.kwad.sdk.core.report.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdTemplate f35033a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ JSONObject f35034b;

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
                    this.f35033a = adTemplate;
                    this.f35034b = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        n.a aVar = new n.a();
                        AdTemplate adTemplate2 = this.f35033a;
                        aVar.f35093h = adTemplate2.downloadSource;
                        a.f(adTemplate2, aVar);
                        a.a(this.f35033a, 31, aVar, this.f35034b);
                        AdInfo i2 = com.kwad.sdk.core.response.b.c.i(this.f35033a);
                        ac.a(i2.downloadFilePath, i2.downloadId);
                    }
                }
            });
        }
    }

    public static void f(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65574, null, adTemplate) == null) {
            f(adTemplate, 41);
        }
    }

    public static void f(AdTemplate adTemplate, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65575, null, adTemplate, i2) == null) {
            a(adTemplate, i2, (n.a) null, new JSONObject());
        }
    }

    public static void f(AdTemplate adTemplate, n.a aVar) {
        AdInfo i2;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65576, null, adTemplate, aVar) == null) || (str = (i2 = com.kwad.sdk.core.response.b.c.i(adTemplate)).downloadFilePath) == null) {
            return;
        }
        String q = com.kwad.sdk.core.response.b.a.q(i2);
        String a2 = ac.a(str);
        if (a2 == null || TextUtils.isEmpty(a2) || a2.equals(q)) {
            return;
        }
        aVar.o = a2;
        aVar.n = q;
        i2.adBaseInfo.appPackageName = a2;
    }

    public static void f(AdTemplate adTemplate, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65577, null, adTemplate, jSONObject) == null) {
            n.a aVar = new n.a();
            aVar.f35093h = adTemplate.downloadSource;
            a(adTemplate, 35, aVar, jSONObject);
        }
    }

    public static void g(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65578, null, adTemplate) == null) {
            n.a aVar = new n.a();
            aVar.n = com.kwad.sdk.core.response.b.a.q(com.kwad.sdk.core.response.b.c.i(adTemplate));
            a(adTemplate, 768, aVar, new JSONObject());
        }
    }

    public static void g(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65579, null, adTemplate, jSONObject) == null) {
            e(adTemplate, 399, jSONObject);
        }
    }

    public static void h(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65580, null, adTemplate) == null) {
            f(adTemplate, 37);
        }
    }

    public static void h(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65581, null, adTemplate, jSONObject) == null) {
            e(adTemplate, 400, jSONObject);
        }
    }

    public static void i(@Nullable AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65582, null, adTemplate) == null) {
            g(adTemplate, null);
        }
    }

    public static void i(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65583, null, adTemplate, jSONObject) == null) {
            e(adTemplate, 501, jSONObject);
        }
    }

    public static void j(@Nullable AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65584, null, adTemplate) == null) {
            h(adTemplate, null);
        }
    }

    public static void j(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65585, null, adTemplate, jSONObject) == null) {
            e(adTemplate, 450, jSONObject);
        }
    }

    public static void k(@Nullable AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65586, null, adTemplate) == null) {
            f(adTemplate, 323);
        }
    }

    public static void k(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65587, null, adTemplate, jSONObject) == null) {
            e(adTemplate, 451, jSONObject);
        }
    }

    public static void l(@Nullable AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65588, null, adTemplate) == null) {
            f(adTemplate, 58);
        }
    }

    public static void m(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65589, null, adTemplate) == null) {
            a(adTemplate, 600, (n.a) null, (JSONObject) null);
        }
    }

    public static void n(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65590, null, adTemplate) == null) {
            n.a aVar = new n.a();
            aVar.s = com.kwad.sdk.core.response.b.a.X(com.kwad.sdk.core.response.b.c.i(adTemplate));
            com.kwad.sdk.core.d.a.a("AdReportManager", "reportDownloadCardClose downloadStatus=" + aVar.s);
            a(adTemplate, (int) SDKLogTypeConstants.TYPE_JMY_DEEP_LINK, aVar, (JSONObject) null);
        }
    }

    public static void o(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65591, null, adTemplate) == null) {
            f(adTemplate, 722);
        }
    }

    public static void p(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65592, null, adTemplate) == null) {
            f(adTemplate, 721);
        }
    }
}
