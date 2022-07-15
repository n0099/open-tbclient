package com.kwad.components.ad.splashscreen;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;
    public String b;
    public String c;
    public int d;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = 2;
    }

    public static e a(AdTemplate adTemplate, AdInfo adInfo, com.kwad.components.core.c.a.b bVar, int i) {
        InterceptResult invokeLLLI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65537, null, adTemplate, adInfo, bVar, i)) == null) {
            e eVar = new e();
            a = i;
            if (adInfo != null && bVar != null) {
                if (i == 1) {
                    eVar.b(com.kwad.sdk.core.response.a.b.c(adInfo));
                } else if (i != 4) {
                    if (com.kwad.sdk.core.response.a.a.I(adInfo)) {
                        int a2 = bVar.a();
                        str = "或点击" + a(adTemplate, adInfo, a2);
                    } else {
                        String i2 = com.kwad.components.ad.splashscreen.a.b.i();
                        if (TextUtils.isEmpty(i2)) {
                            i2 = "点击跳转详情页或第三方应用";
                        }
                        str = "或" + i2;
                    }
                    eVar.a(str);
                }
                str = a(adInfo, bVar);
                eVar.a(str);
            }
            eVar.a(com.kwad.sdk.core.response.a.b.h(adInfo));
            return eVar;
        }
        return (e) invokeLLLI.objValue;
    }

    public static String a(AdInfo adInfo, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, adInfo, i)) == null) {
            AdMatrixInfo.DownloadTexts c = c(adInfo, a);
            return i != 8 ? i != 12 ? c.adActionDescription : c.openAppLabel : c.installAppLabel;
        }
        return (String) invokeLI.objValue;
    }

    public static String a(AdInfo adInfo, com.kwad.components.core.c.a.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, adInfo, bVar)) == null) {
            if (!com.kwad.sdk.core.response.a.a.I(adInfo)) {
                String d = d(adInfo, a);
                return TextUtils.isEmpty(d) ? "点击跳转详情页或第三方应用" : d;
            }
            int a2 = bVar.a();
            AdMatrixInfo.DownloadTexts c = c(adInfo, a);
            return a2 != 8 ? a2 != 12 ? c.adActionDescription : c.openAppLabel : c.installAppLabel;
        }
        return (String) invokeLL.objValue;
    }

    public static String a(AdTemplate adTemplate, AdInfo adInfo, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, adTemplate, adInfo, i)) == null) {
            return i != 8 ? i != 12 ? com.kwad.sdk.core.response.a.a.H(adInfo) : com.kwad.sdk.core.response.a.a.n(adInfo) : com.kwad.sdk.core.response.a.a.a(adTemplate);
        }
        return (String) invokeLLI.objValue;
    }

    private void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65541, this, i) == null) {
            this.d = i;
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, str) == null) {
            this.c = str;
        }
    }

    public static String b(AdInfo adInfo, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, adInfo, i)) == null) {
            AdMatrixInfo.DownloadTexts b = com.kwad.sdk.core.response.a.b.b(adInfo) != null ? com.kwad.sdk.core.response.a.b.b(adInfo) : new AdMatrixInfo.DownloadTexts();
            return i != 8 ? i != 12 ? b.adActionDescription : b.openAppLabel : b.installAppLabel;
        }
        return (String) invokeLI.objValue;
    }

    private void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, str) == null) {
            this.b = str;
        }
    }

    public static AdMatrixInfo.DownloadTexts c(AdInfo adInfo, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, adInfo, i)) == null) {
            if (i == 1) {
                return com.kwad.sdk.core.response.a.b.a(adInfo) != null ? com.kwad.sdk.core.response.a.b.a(adInfo) : new AdMatrixInfo.DownloadTexts();
            }
            if (i == 4 && com.kwad.sdk.core.response.a.b.e(adInfo) != null) {
                return com.kwad.sdk.core.response.a.b.e(adInfo);
            }
            return new AdMatrixInfo.DownloadTexts();
        }
        return (AdMatrixInfo.DownloadTexts) invokeLI.objValue;
    }

    public static String d(AdInfo adInfo, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, adInfo, i)) == null) ? i == 1 ? com.kwad.sdk.core.response.a.b.d(adInfo) != null ? com.kwad.sdk.core.response.a.b.d(adInfo) : "" : (i != 4 || com.kwad.sdk.core.response.a.b.f(adInfo) == null) ? "" : com.kwad.sdk.core.response.a.b.f(adInfo) : (String) invokeLI.objValue;
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : invokeV.intValue;
    }
}
