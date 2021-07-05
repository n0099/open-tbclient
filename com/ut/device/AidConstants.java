package com.ut.device;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class AidConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EVENT_NETWORK_ERROR = 1003;
    public static final int EVENT_REQUEST_FAILED = 1002;
    public static final int EVENT_REQUEST_STARTED = 1000;
    public static final int EVENT_REQUEST_SUCCESS = 1001;
    public transient /* synthetic */ FieldHolder $fh;

    public AidConstants() {
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
