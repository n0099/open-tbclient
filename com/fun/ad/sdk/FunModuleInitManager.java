package com.fun.ad.sdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class FunModuleInitManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FunAdSdk.SdkInitializeCallback a;
    public final List<String> b;
    public final AtomicBoolean c;

    public FunModuleInitManager() {
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
        this.b = new ArrayList();
        this.c = new AtomicBoolean(false);
    }

    public void notifyModuleInitResult(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            synchronized (this.b) {
                this.b.remove(str);
                tryCallbackComplete();
            }
        }
    }

    public void registModules(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || this.a == null) {
            return;
        }
        synchronized (this.b) {
            this.b.add(str);
        }
    }

    public void setCallBack(FunAdSdk.SdkInitializeCallback sdkInitializeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sdkInitializeCallback) == null) {
            this.a = sdkInitializeCallback;
        }
    }

    public void tryCallbackComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this.b) {
                FunAdSdk.SdkInitializeCallback sdkInitializeCallback = this.a;
                if (sdkInitializeCallback == null) {
                    return;
                }
                if (this.c.get()) {
                    return;
                }
                if (this.b.isEmpty()) {
                    sdkInitializeCallback.onModulesInitComplete();
                    this.c.set(true);
                }
            }
        }
    }
}
