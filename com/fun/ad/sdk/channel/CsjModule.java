package com.fun.ad.sdk.channel;

import android.content.SharedPreferences;
import android.os.Handler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.as9;
import com.baidu.tieba.bt9;
import com.baidu.tieba.qr9;
import com.baidu.tieba.rr9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.fun.ad.sdk.FunAdConfig;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.ModuleAdConfig;
import com.fun.ad.sdk.PersonalRecommendObserver;
import com.fun.ad.sdk.channel.ModuleConfigCsj;
import com.fun.ad.sdk.internal.api.Module;
import com.fun.ad.sdk.internal.api.PidLoaderCreator;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.Calendar;
/* loaded from: classes7.dex */
public class CsjModule implements Module {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements TTAdSdk.InitCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ModuleConfigCsj a;

        public a(CsjModule csjModule, ModuleConfigCsj moduleConfigCsj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {csjModule, moduleConfigCsj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = moduleConfigCsj;
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

    /* loaded from: classes7.dex */
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
                TTAdConfig.Builder builder = new TTAdConfig.Builder();
                builder.data(as9.b(z));
                TTAdSdk.updateAdConfig(builder.build());
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
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, funAdConfig, str)) == null) {
            Object obj = (ModuleAdConfig) funAdConfig.moduleConfigMap.get(FunAdSdk.PLATFORM_CSJ);
            if (obj == null) {
                obj = new ModuleConfigCsj.Builder().build();
            }
            if (obj instanceof ModuleConfigCsj) {
                ModuleConfigCsj moduleConfigCsj = (ModuleConfigCsj) obj;
                synchronized (rr9.class) {
                    Handler handler = rr9.a;
                    Calendar calendar = Calendar.getInstance();
                    int i = calendar.get(6);
                    int i2 = calendar.get(1);
                    SharedPreferences sharedPreferences = bt9.a;
                    calendar.setTimeInMillis(sharedPreferences.getLong("req_id_update_time", 0L));
                    int i3 = calendar.get(6);
                    if (i2 == calendar.get(1) && i == i3) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        sharedPreferences.edit().clear().apply();
                    }
                    sharedPreferences.edit().putLong("req_id_update_time", System.currentTimeMillis()).apply();
                    rr9.a.sendEmptyMessageDelayed(101, rr9.a());
                }
                TTAdSdk.init(funAdConfig.appContext, new TTAdConfig.Builder().appId(str).useTextureView(funAdConfig.isUseTextureView).appName(funAdConfig.appName).titleBarTheme(moduleConfigCsj.titleBarTheme).allowShowNotify(true).allowShowPageWhenScreenLock(true).debug(funAdConfig.logEnabled).directDownloadNetworkType(4, 1).customController(moduleConfigCsj.ttCustomCtr).supportMultiProcess(moduleConfigCsj.ttSupportMultiProcess).data(as9.b(funAdConfig.runtimeAdConfig.personalRecommendStatus)).build(), new a(this, moduleConfigCsj));
                funAdConfig.runtimeAdConfig.registerPersonalRecommendObserver(new b());
                return new qr9();
            }
            throw new RuntimeException("The csj config need ModuleConfigCsj!");
        }
        return (PidLoaderCreator) invokeLL.objValue;
    }
}
