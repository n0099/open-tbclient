package com.fun.ad.sdk.channel;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.fun.ad.sdk.FunAdConfig;
import com.fun.ad.sdk.internal.api.Module;
import com.fun.ad.sdk.internal.api.PidLoaderCreator;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.repackage.hf9;
/* loaded from: classes4.dex */
public class CsjModule implements Module {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements TTAdSdk.InitCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FunAdConfig a;

        public a(CsjModule csjModule, FunAdConfig funAdConfig) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {csjModule, funAdConfig};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = funAdConfig;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void fail(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                LogPrinter.d("Csj Initialized failed with code:%d reason:%s", Integer.valueOf(i), str);
                TTAdSdk.InitCallback initCallback = this.a.ttInitCallback;
                if (initCallback != null) {
                    initCallback.fail(i, str);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void success() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                LogPrinter.d("Csj Initialized success", new Object[0]);
                TTAdSdk.InitCallback initCallback = this.a.ttInitCallback;
                if (initCallback != null) {
                    initCallback.success();
                }
            }
        }
    }

    public CsjModule() {
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
            TTAdSdk.init(funAdConfig.appContext, new TTAdConfig.Builder().appId(str).useTextureView(funAdConfig.isUseTextureView).appName(funAdConfig.appName).titleBarTheme(funAdConfig.titleBarTheme).allowShowNotify(funAdConfig.logEnabled).allowShowPageWhenScreenLock(true).debug(false).directDownloadNetworkType(4, 1).customController(funAdConfig.ttCustomCtr).supportMultiProcess(funAdConfig.ttSupportMultiProcess).build(), new a(this, funAdConfig));
            return new hf9();
        }
        return (PidLoaderCreator) invokeLL.objValue;
    }
}
