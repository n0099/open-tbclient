package com.fun.ad.sdk.channel;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdConfig;
import com.fun.ad.sdk.internal.api.Module;
import com.fun.ad.sdk.internal.api.PidLoaderCreator;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.repackage.si9;
/* loaded from: classes4.dex */
public class KsModule implements Module {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public KsModule() {
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

    @Override // com.fun.ad.sdk.internal.api.Module
    public PidLoaderCreator init(FunAdConfig funAdConfig, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, funAdConfig, str)) == null) {
            KsAdSDK.init(funAdConfig.appContext, new SdkConfig.Builder().appId(str).appName(funAdConfig.appName).showNotification(true).debug(funAdConfig.logEnabled).canReadICCID(funAdConfig.ksCanReadICCID).canReadNearbyWifiList(funAdConfig.ksCanReadNearbyWifiList).canReadMacAddress(funAdConfig.ksCanReadMacAddress).customController(funAdConfig.ksCustomCtr).build());
            return new si9();
        }
        return (PidLoaderCreator) invokeLL.objValue;
    }
}
