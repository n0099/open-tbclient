package com.xiaomi.mipush.sdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ErrorCode {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERROR_AUTHERICATION_ERROR = 70000002;
    public static final int ERROR_INTERNAL_ERROR = 70000004;
    public static final int ERROR_INVALID_PAYLOAD = 70000003;
    public static final int ERROR_SERVICE_UNAVAILABLE = 70000001;
    public static final int SUCCESS = 0;
    public transient /* synthetic */ FieldHolder $fh;

    public ErrorCode() {
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
}
