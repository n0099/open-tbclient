package com.sdk.mobile.config;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.framework.c.e;
import com.sdk.base.framework.f.c.a;
import com.sdk.base.module.config.BaseConfig;
/* loaded from: classes7.dex */
public class MobileConfig implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String apk;

    /* renamed from: c  reason: collision with root package name */
    public int f41281c;
    public String cm;
    public String n;
    public long r;
    public String v;

    public MobileConfig() {
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
        this.apk = BaseConfig.apk;
        this.cm = BaseConfig.cm;
        this.f41281c = 1;
        this.v = "1.0";
        this.n = "ZzxOAuth";
        this.r = System.currentTimeMillis();
    }

    public String getApiKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.apk : (String) invokeV.objValue;
    }

    public String getCM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.cm : (String) invokeV.objValue;
    }

    public String toJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? a.a(this) : (String) invokeV.objValue;
    }
}
