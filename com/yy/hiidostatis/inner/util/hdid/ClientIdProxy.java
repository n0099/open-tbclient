package com.yy.hiidostatis.inner.util.hdid;

import android.app.Application;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.log.L;
/* loaded from: classes10.dex */
public class ClientIdProxy {
    public static /* synthetic */ Interceptable $ic;
    public static volatile boolean isInit;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1660832118, "Lcom/yy/hiidostatis/inner/util/hdid/ClientIdProxy;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1660832118, "Lcom/yy/hiidostatis/inner/util/hdid/ClientIdProxy;");
        }
    }

    public ClientIdProxy() {
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

    public static String getClientId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            init(context);
            return ClientIdHelper.getInstance().getClientId();
        }
        return (String) invokeL.objValue;
    }

    public static void init(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, context) == null) || isInit) {
            return;
        }
        synchronized (ClientIdProxy.class) {
            if (!isInit) {
                ClientIdHelper.init(new IClientIdConfig(context) { // from class: com.yy.hiidostatis.inner.util.hdid.ClientIdProxy.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context val$c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$c = context;
                    }

                    @Override // com.yy.hiidostatis.inner.util.hdid.IClientIdConfig
                    public Application getAppContext() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            Context context2 = this.val$c;
                            if (!(context2 instanceof Application)) {
                                context2 = context2.getApplicationContext();
                            }
                            return (Application) context2;
                        }
                        return (Application) invokeV.objValue;
                    }

                    @Override // com.yy.hiidostatis.inner.util.hdid.IClientIdConfig
                    public boolean logEnable() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            return false;
                        }
                        return invokeV.booleanValue;
                    }

                    @Override // com.yy.hiidostatis.inner.util.hdid.IClientIdConfig
                    public boolean sdReadGranted() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                            return false;
                        }
                        return invokeV.booleanValue;
                    }

                    @Override // com.yy.hiidostatis.inner.util.hdid.IClientIdConfig
                    public boolean sdWriteGranted() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                            return false;
                        }
                        return invokeV.booleanValue;
                    }
                });
                isInit = true;
            }
        }
    }

    public static void test(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            L.debug("DeviceProxy", "ClientIdProxyTest:%d==>%s,%d", Long.valueOf(Thread.currentThread().getId()), getClientId(context), Long.valueOf(System.currentTimeMillis() - System.currentTimeMillis()));
        }
    }
}
