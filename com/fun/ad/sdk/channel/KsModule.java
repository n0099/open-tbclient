package com.fun.ad.sdk.channel;

import com.baidu.tieba.xva;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdConfig;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.ModuleAdConfig;
import com.fun.ad.sdk.PersonalRecommendObserver;
import com.fun.ad.sdk.channel.ModuleConfigKs;
import com.fun.ad.sdk.internal.api.Module;
import com.fun.ad.sdk.internal.api.PidLoaderCreator;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
/* loaded from: classes9.dex */
public class KsModule implements Module {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a implements PersonalRecommendObserver {
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

        @Override // com.fun.ad.sdk.PersonalRecommendObserver
        public void notifyStatusChanged(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                KsAdSDK.setPersonalRecommend(z);
            }
        }
    }

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
            Object obj = (ModuleAdConfig) funAdConfig.moduleConfigMap.get(FunAdSdk.PLATFORM_KS);
            if (obj == null) {
                obj = new ModuleConfigKs.Builder().build();
            }
            if (obj instanceof ModuleConfigKs) {
                ModuleConfigKs moduleConfigKs = (ModuleConfigKs) obj;
                KsAdSDK.init(funAdConfig.appContext, new SdkConfig.Builder().appId(str).appName(funAdConfig.appName).showNotification(true).debug(funAdConfig.logEnabled).canReadICCID(moduleConfigKs.ksCanReadICCID).canReadNearbyWifiList(moduleConfigKs.ksCanReadNearbyWifiList).canReadMacAddress(moduleConfigKs.ksCanReadMacAddress).customController(moduleConfigKs.ksCustomCtr).build());
                KsAdSDK.setPersonalRecommend(funAdConfig.runtimeAdConfig.personalRecommendStatus);
                funAdConfig.runtimeAdConfig.registerPersonalRecommendObserver(new a());
                return new xva(moduleConfigKs);
            }
            throw new RuntimeException("The ks config need ModuleConfigKs!");
        }
        return (PidLoaderCreator) invokeLL.objValue;
    }
}
