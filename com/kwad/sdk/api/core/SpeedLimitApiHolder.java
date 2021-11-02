package com.kwad.sdk.api.core;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.loader.Loader;
/* loaded from: classes2.dex */
public class SpeedLimitApiHolder {
    public static /* synthetic */ Interceptable $ic;
    public static volatile SpeedLimitApi instance;
    public transient /* synthetic */ FieldHolder $fh;

    public SpeedLimitApiHolder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Nullable
    public static SpeedLimitApi getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (instance == null) {
                synchronized (SpeedLimitApiHolder.class) {
                    if (instance == null) {
                        instance = (SpeedLimitApi) Loader.get().newInstance(SpeedLimitApi.class);
                    }
                }
            }
            return instance;
        }
        return (SpeedLimitApi) invokeV.objValue;
    }
}
