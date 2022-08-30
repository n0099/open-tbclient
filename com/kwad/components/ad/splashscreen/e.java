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
/* loaded from: classes7.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public static int xX;
    public transient /* synthetic */ FieldHolder $fh;
    public String title;
    public String xY;
    public int xZ;

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
        this.xZ = 2;
    }

    private void W(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, this, i) == null) {
            this.xZ = i;
        }
    }

    private void W(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
            this.xY = str;
        }
    }

    public static e a(AdTemplate adTemplate, AdInfo adInfo, com.kwad.components.core.c.a.c cVar, int i) {
        InterceptResult invokeLLLI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65539, null, adTemplate, adInfo, cVar, i)) == null) {
            e eVar = new e();
            xX = i;
            if (adInfo != null && cVar != null) {
                if (i == 1) {
                    eVar.setTitle(com.kwad.sdk.core.response.a.b.bV(adInfo));
                } else if (i != 4) {
                    if (com.kwad.sdk.core.response.a.a.am(adInfo)) {
                        int mI = cVar.mI();
                        str = "或点击" + a(adTemplate, adInfo, mI);
                    } else {
                        String jR = com.kwad.components.ad.splashscreen.a.b.jR();
                        if (TextUtils.isEmpty(jR)) {
                            jR = "点击跳转详情页或第三方应用";
                        }
                        str = "或" + jR;
                    }
                    eVar.W(str);
                }
                str = a(adInfo, cVar);
                eVar.W(str);
            }
            eVar.W(com.kwad.sdk.core.response.a.b.ca(adInfo));
            return eVar;
        }
        return (e) invokeLLLI.objValue;
    }

    public static String a(AdInfo adInfo, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, adInfo, i)) == null) {
            AdMatrixInfo.DownloadTexts b = b(adInfo, xX);
            return i != 8 ? i != 12 ? b.adActionDescription : b.openAppLabel : b.installAppLabel;
        }
        return (String) invokeLI.objValue;
    }

    public static String a(AdInfo adInfo, com.kwad.components.core.c.a.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, adInfo, cVar)) == null) {
            if (!com.kwad.sdk.core.response.a.a.am(adInfo)) {
                String d = d(adInfo, xX);
                return TextUtils.isEmpty(d) ? "点击跳转详情页或第三方应用" : d;
            }
            int mI = cVar.mI();
            AdMatrixInfo.DownloadTexts b = b(adInfo, xX);
            return mI != 8 ? mI != 12 ? b.adActionDescription : b.openAppLabel : b.installAppLabel;
        }
        return (String) invokeLL.objValue;
    }

    public static String a(AdTemplate adTemplate, AdInfo adInfo, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65542, null, adTemplate, adInfo, i)) == null) {
            return i != 8 ? i != 12 ? com.kwad.sdk.core.response.a.a.al(adInfo) : com.kwad.sdk.core.response.a.a.P(adInfo) : com.kwad.sdk.core.response.a.a.aJ(adTemplate);
        }
        return (String) invokeLLI.objValue;
    }

    public static AdMatrixInfo.DownloadTexts b(AdInfo adInfo, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, adInfo, i)) == null) {
            if (i == 1) {
                return com.kwad.sdk.core.response.a.b.bT(adInfo) != null ? com.kwad.sdk.core.response.a.b.bT(adInfo) : new AdMatrixInfo.DownloadTexts();
            }
            if (i == 4 && com.kwad.sdk.core.response.a.b.bX(adInfo) != null) {
                return com.kwad.sdk.core.response.a.b.bX(adInfo);
            }
            return new AdMatrixInfo.DownloadTexts();
        }
        return (AdMatrixInfo.DownloadTexts) invokeLI.objValue;
    }

    public static String c(AdInfo adInfo, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, adInfo, i)) == null) {
            AdMatrixInfo.DownloadTexts bU = com.kwad.sdk.core.response.a.b.bU(adInfo) != null ? com.kwad.sdk.core.response.a.b.bU(adInfo) : new AdMatrixInfo.DownloadTexts();
            return i != 8 ? i != 12 ? bU.adActionDescription : bU.openAppLabel : bU.installAppLabel;
        }
        return (String) invokeLI.objValue;
    }

    public static String d(AdInfo adInfo, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, adInfo, i)) == null) ? i == 1 ? com.kwad.sdk.core.response.a.b.bW(adInfo) != null ? com.kwad.sdk.core.response.a.b.bW(adInfo) : "" : (i != 4 || com.kwad.sdk.core.response.a.b.bY(adInfo) == null) ? "" : com.kwad.sdk.core.response.a.b.bY(adInfo) : (String) invokeLI.objValue;
    }

    private void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, str) == null) {
            this.title = str;
        }
    }

    public final String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.title : (String) invokeV.objValue;
    }

    public final String jw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.xY : (String) invokeV.objValue;
    }

    public final int jx() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.xZ : invokeV.intValue;
    }
}
