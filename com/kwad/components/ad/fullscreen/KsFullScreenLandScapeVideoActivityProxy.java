package com.kwad.components.ad.fullscreen;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.KsFullScreenLandScapeVideoActivity;
@KsAdSdkDynamicImpl(KsFullScreenLandScapeVideoActivity.class)
/* loaded from: classes7.dex */
public class KsFullScreenLandScapeVideoActivityProxy extends KsFullScreenVideoActivityProxy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public KsFullScreenLandScapeVideoActivityProxy() {
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

    public static void register() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            KsAdSDKImpl.putComponentProxy(KsFullScreenLandScapeVideoActivity.class, KsFullScreenLandScapeVideoActivityProxy.class);
        }
    }
}
