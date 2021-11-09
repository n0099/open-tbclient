package com.sdk.base.module.config;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.framework.c.e;
import com.sdk.base.framework.f.c.a;
/* loaded from: classes2.dex */
public class BaseConfig implements e {
    public static /* synthetic */ Interceptable $ic = null;
    public static String apk = "com.cucc.sdk.api_key";

    /* renamed from: c  reason: collision with root package name */
    public static int f68262c = 36;
    public static String cm = "CUCC";
    public static String n = "SDKFactory";
    public static String v = "安卓3.9.1.3开放版K200113";
    public transient /* synthetic */ FieldHolder $fh;
    public long r;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-59415665, "Lcom/sdk/base/module/config/BaseConfig;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-59415665, "Lcom/sdk/base/module/config/BaseConfig;");
        }
    }

    public BaseConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.r = System.currentTimeMillis();
    }

    public String getApiKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? apk : (String) invokeV.objValue;
    }

    public String getCM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? cm : (String) invokeV.objValue;
    }

    public String toJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? a.a(this) : (String) invokeV.objValue;
    }
}
