package com.kwad.components.core.c.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
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
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.az;
/* loaded from: classes5.dex */
public final class c extends com.kwad.sdk.core.download.kwai.b {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-190823441, "Lcom/kwad/components/core/c/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-190823441, "Lcom/kwad/components/core/c/a/c;");
        }
    }

    public static int a(a.C0507a c0507a, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, c0507a, i)) == null) {
            Context a2 = c0507a.a();
            AdTemplate b = c0507a.b();
            if (b == null || a2 == null) {
                return 0;
            }
            int a3 = com.kwad.sdk.core.download.kwai.b.a(a2, com.kwad.sdk.core.response.a.a.bc(com.kwad.sdk.core.response.a.d.i(b)));
            if (a3 == 1) {
                com.kwad.sdk.core.report.a.a(b, 1, c0507a.j());
                a(b, 1);
            } else if (a3 == -1) {
                com.kwad.sdk.core.report.a.d(b, 1);
            }
            return a3;
        }
        return invokeLI.intValue;
    }

    public static String a(Context context, AdInfo adInfo, SceneImpl sceneImpl) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, adInfo, sceneImpl)) == null) {
            if (sceneImpl != null) {
                int i = 0;
                if (!af.a(context, "com.smile.gifmaker") && af.a(context, "com.kuaishou.nebula")) {
                    i = 3;
                }
                String backUrl = sceneImpl.getBackUrl();
                return a(com.kwad.sdk.core.response.a.a.bc(adInfo), i, TextUtils.isEmpty(backUrl) ? "" : backUrl);
            }
            return "";
        }
        return (String) invokeLLL.objValue;
    }

    public static String a(String str, int i, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(65539, null, str, i, str2)) == null) ? TextUtils.isEmpty(str2) ? str : (i == 0 || i == 3) ? a(str, str2) : str : (String) invokeLIL.objValue;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            Uri.Builder appendQueryParameter = buildUpon.appendQueryParameter("returnBack", "liveunion_" + KsAdSDKImpl.get().getAppId());
            if (TextUtils.isEmpty(str2)) {
                str2 = "0";
            }
            return appendQueryParameter.appendQueryParameter("back_url", str2).toString();
        }
        return (String) invokeLL.objValue;
    }

    public static void a(AdTemplate adTemplate, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65541, null, adTemplate, i) == null) || a()) {
            return;
        }
        b(true);
        int A = com.kwad.sdk.core.config.d.A();
        com.kwad.sdk.core.config.d.B();
        int abs = Math.abs(A);
        if (abs > 0) {
            az.a(new Runnable(adTemplate, i) { // from class: com.kwad.components.core.c.a.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdTemplate a;
                public final /* synthetic */ int b;

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
                    this.a = adTemplate;
                    this.b = i;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        c.b(false);
                        com.kwad.sdk.core.lifecycle.a.c();
                        if (com.kwad.sdk.core.lifecycle.a.d()) {
                            return;
                        }
                        com.kwad.sdk.core.report.a.e(this.a, this.b);
                    }
                }
            }, null, abs * 1000);
        } else {
            b(false);
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? a : invokeV.booleanValue;
    }

    public static void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, null, z) == null) {
            a = z;
        }
    }
}
