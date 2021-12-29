package com.tachikoma.core.manager;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.api.IHostEnvInner;
import com.tachikoma.core.api.IModuleInner;
import com.tachikoma.core.bridge.TKJSContext;
import com.tachikoma.core.log.Logger;
import com.tachikoma.core.module.TKBuilder;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class TKModuleManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<Class<?>, Object> handlerMap;

    /* loaded from: classes4.dex */
    public static class Holder {
        public static /* synthetic */ Interceptable $ic;
        public static final TKModuleManager INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2026003203, "Lcom/tachikoma/core/manager/TKModuleManager$Holder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2026003203, "Lcom/tachikoma/core/manager/TKModuleManager$Holder;");
                    return;
                }
            }
            INSTANCE = new TKModuleManager();
        }

        public Holder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public TKModuleManager() {
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
        this.handlerMap = new HashMap<>();
    }

    public static TKModuleManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? Holder.INSTANCE : (TKModuleManager) invokeV.objValue;
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.handlerMap.clear();
        }
    }

    public <T> T getHandler(TKJSContext tKJSContext, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tKJSContext, cls)) == null) {
            if (cls == null || tKJSContext == null) {
                return null;
            }
            return (T) getHandler(cls);
        }
        return (T) invokeLL.objValue;
    }

    public <T> T getHandler(Class<T> cls) {
        InterceptResult invokeL;
        HashMap<Class<?>, Object> hashMap;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cls)) == null) {
            if (cls == null || (hashMap = this.handlerMap) == null || (t = (T) hashMap.get(cls)) == null || !cls.isInstance(t)) {
                return null;
            }
            return t;
        }
        return (T) invokeL.objValue;
    }

    public void register(IModuleInner iModuleInner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iModuleInner) == null) {
            TKBuilder tKBuilder = new TKBuilder();
            iModuleInner.applyOptions(tKBuilder);
            this.handlerMap.clear();
            this.handlerMap.putAll(tKBuilder.build());
            IHostEnvInner iHostEnvInner = (IHostEnvInner) getHandler(IHostEnvInner.class);
            if (iHostEnvInner != null) {
                Logger.setShowLog(iHostEnvInner.isShowLog());
            }
        }
    }
}
