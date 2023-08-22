package com.fun.ad.sdk.channel;

import com.baidu.tieba.pnb;
import com.baidu.tieba.rnb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdConfig;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.MediaExtDataObserver;
import com.fun.ad.sdk.ModuleAdConfig;
import com.fun.ad.sdk.PersonalRecommendObserver;
import com.fun.ad.sdk.channel.ModuleConfigGdt;
import com.fun.ad.sdk.internal.api.Module;
import com.fun.ad.sdk.internal.api.PidLoaderCreator;
import com.fun.ad.sdk.internal.api.channel.GdtHelper;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class GdtModule implements Module {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a implements MediaExtDataObserver {
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

        @Override // com.fun.ad.sdk.MediaExtDataObserver
        public void updateRcUserId(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("user_id", str);
                GlobalSetting.setMediaExtData(hashMap, false);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b implements PersonalRecommendObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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
                GlobalSetting.setPersonalizedState(!z ? 1 : 0);
            }
        }
    }

    public GdtModule() {
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
            GDTAdSdk.init(funAdConfig.appContext, str);
            GlobalSetting.setChannel(3);
            GlobalSetting.setPersonalizedState(!funAdConfig.runtimeAdConfig.personalRecommendStatus ? 1 : 0);
            GdtHelper.sGdtNativeContainerCreator = pnb.b;
            funAdConfig.runtimeAdConfig.registerPersonalRecommendObserver(new b());
            funAdConfig.runtimeAdConfig.registerMediaExtDataObserver(new a());
            ModuleAdConfig moduleAdConfig = funAdConfig.moduleConfigMap.get(FunAdSdk.PLATFORM_GDT);
            ModuleConfigGdt moduleConfigGdt = moduleAdConfig;
            if (moduleAdConfig == null) {
                moduleConfigGdt = new ModuleConfigGdt.Builder().build();
            }
            if (moduleConfigGdt instanceof ModuleConfigGdt) {
                return new rnb((ModuleConfigGdt) moduleConfigGdt);
            }
            throw new RuntimeException("The gdt config need ModuleConfigGdt!");
        }
        return (PidLoaderCreator) invokeLL.objValue;
    }
}
