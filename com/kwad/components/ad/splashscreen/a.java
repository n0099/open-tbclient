package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.SdkConfig;
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.components.d implements com.kwad.components.ad.a.h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.kwad.components.ad.a.h
    public final void a(Context context, String str, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, str, Boolean.valueOf(z), rect}) == null) {
            new c(context, str, false, null).a(rect);
        }
    }

    @Override // com.kwad.components.ad.a.h
    public final void a(@NonNull KsScene ksScene, @NonNull KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ksScene, splashScreenAdListener) == null) {
            b.a(ksScene, splashScreenAdListener);
        }
    }

    @Override // com.kwad.sdk.components.a
    public Class getComponentsType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.kwad.components.ad.a.h.class : (Class) invokeV.objValue;
    }

    @Override // com.kwad.sdk.components.a
    public void init(Context context, SdkConfig sdkConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, sdkConfig) == null) {
        }
    }
}
