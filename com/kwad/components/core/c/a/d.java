package com.kwad.components.core.c.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.c.a.a;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bd;
/* loaded from: classes8.dex */
public final class d extends com.kwad.sdk.core.download.kwai.b {
    public static /* synthetic */ Interceptable $ic;
    public static boolean Ep;
    public static final b Eq;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-190823410, "Lcom/kwad/components/core/c/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-190823410, "Lcom/kwad/components/core/c/a/d;");
                return;
            }
        }
        Eq = new b() { // from class: com.kwad.components.core.c.a.d.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public long Es;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.onBackToBackground();
                    this.Es = System.currentTimeMillis();
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    super.onBackToForeground();
                    if (this.Es != 0) {
                        com.kwad.sdk.core.report.a.g(getAdTemplate(), System.currentTimeMillis() - this.Es);
                    }
                    com.kwad.sdk.core.c.b.tp();
                    com.kwad.sdk.core.c.b.b(d.Eq);
                    setAdTemplate(null);
                    this.Es = 0L;
                }
            }
        };
    }

    public static int a(a.C0594a c0594a, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, c0594a, i)) == null) {
            Context context = c0594a.getContext();
            AdTemplate adTemplate = c0594a.getAdTemplate();
            if (adTemplate == null || context == null) {
                return 0;
            }
            Eq.setAdTemplate(adTemplate);
            com.kwad.sdk.core.c.b.tp();
            com.kwad.sdk.core.c.b.a(Eq);
            int s = com.kwad.sdk.core.download.kwai.b.s(context, com.kwad.sdk.core.response.a.a.bM(com.kwad.sdk.core.response.a.d.bQ(adTemplate)));
            if (s == 1) {
                com.kwad.sdk.core.report.a.a(adTemplate, 1, c0594a.getClientParams());
                c(adTemplate, 1);
            } else if (s == -1) {
                com.kwad.sdk.core.report.a.k(adTemplate, 1);
            }
            return s;
        }
        return invokeLI.intValue;
    }

    public static String a(String str, int i, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, str, i, str2)) == null) ? TextUtils.isEmpty(str2) ? str : (i == 0 || i == 3) ? g(str, str2) : str : (String) invokeLIL.objValue;
    }

    public static void aq(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z) == null) {
            Ep = z;
        }
    }

    public static void c(AdTemplate adTemplate, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65541, null, adTemplate, i) == null) || mY()) {
            return;
        }
        aq(true);
        int rU = com.kwad.sdk.core.config.d.rU();
        com.kwad.sdk.core.config.d.rV();
        int abs = Math.abs(rU);
        if (abs > 0) {
            bd.a(new Runnable(adTemplate, i) { // from class: com.kwad.components.core.c.a.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdTemplate Er;
                public final /* synthetic */ int lI;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {adTemplate, Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Er = adTemplate;
                    this.lI = i;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        d.aq(false);
                        com.kwad.sdk.core.c.b.tp();
                        if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                            return;
                        }
                        com.kwad.sdk.core.report.a.l(this.Er, this.lI);
                    }
                }
            }, null, abs * 1000);
        } else {
            aq(false);
        }
    }

    public static String e(Context context, AdInfo adInfo, SceneImpl sceneImpl) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, context, adInfo, sceneImpl)) == null) {
            if (sceneImpl != null) {
                int i = 0;
                if (!ai.U(context, "com.smile.gifmaker") && ai.U(context, "com.kuaishou.nebula")) {
                    i = 3;
                }
                String backUrl = sceneImpl.getBackUrl();
                return a(com.kwad.sdk.core.response.a.a.bM(adInfo), i, TextUtils.isEmpty(backUrl) ? "" : backUrl);
            }
            return "";
        }
        return (String) invokeLLL.objValue;
    }

    public static String g(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            Uri.Builder appendQueryParameter = buildUpon.appendQueryParameter("returnBack", "liveunion_" + KsAdSDKImpl.get().getAppId());
            if (TextUtils.isEmpty(str2)) {
                str2 = "0";
            }
            return appendQueryParameter.appendQueryParameter("back_url", str2).toString();
        }
        return (String) invokeLL.objValue;
    }

    public static boolean mY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? Ep : invokeV.booleanValue;
    }
}
