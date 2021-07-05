package com.yy.hiidostatis.inner.util.http;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class CacheIp {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long cacheTime;
    public String lastIP;
    public int lastIPTimes;

    public CacheIp() {
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
        this.lastIP = null;
        this.lastIPTimes = 0;
        this.cacheTime = 0L;
    }

    public String getIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.lastIP : (String) invokeV.objValue;
    }

    public void inc() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.lastIPTimes++;
        }
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.lastIP != null && this.lastIPTimes < 1000 && this.cacheTime != 0 && System.currentTimeMillis() - this.cacheTime < 21600000 : invokeV.booleanValue;
    }

    public void reset(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.lastIPTimes = 0;
            this.lastIP = str;
            this.cacheTime = 0L;
            if (str != null) {
                this.cacheTime = System.currentTimeMillis();
            }
        }
    }
}
