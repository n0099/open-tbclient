package com.kwad.sdk.splashscreen;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.splashscreen.a.i;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f59573b;

    /* renamed from: c  reason: collision with root package name */
    public int f59574c;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59574c = 2;
    }

    public static e a(AdTemplate adTemplate, AdInfo adInfo, com.kwad.sdk.core.download.a.b bVar) {
        InterceptResult invokeLLL;
        String str;
        int c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, adTemplate, adInfo, bVar)) == null) {
            e eVar = new e();
            if (adInfo == null || !com.kwad.sdk.core.response.a.a.B(adInfo) || bVar == null) {
                String aB = com.kwad.sdk.core.config.b.aB();
                if (TextUtils.isEmpty(aB)) {
                    aB = "点击跳过详情页或第三方应用";
                }
                str = "或" + aB;
            } else {
                com.kwad.sdk.core.d.a.c("SplashActionBarModel", "createModel localStatus: " + bVar.c());
                str = "或点击" + a(adTemplate, adInfo, c2);
            }
            eVar.a(str);
            eVar.a(com.kwad.sdk.core.response.a.b.a(adInfo));
            eVar.a(i.a(adInfo));
            return eVar;
        }
        return (e) invokeLLL.objValue;
    }

    public static String a(AdTemplate adTemplate, AdInfo adInfo, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, adTemplate, adInfo, i2)) == null) {
            return i2 != 8 ? i2 != 12 ? com.kwad.sdk.core.response.a.a.A(adInfo) : com.kwad.sdk.core.response.a.a.m(adInfo) : com.kwad.sdk.core.response.a.a.a(adTemplate);
        }
        return (String) invokeLLI.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f59574c = i2;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.a = str;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f59573b = z;
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f59574c : invokeV.intValue;
    }
}
