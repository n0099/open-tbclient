package com.heytap.mcssdk.mode;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PushStatus {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PUSH_STATUS_PAUSE = 1;
    public static final int PUSH_STATUS_START = 0;
    public static final int PUSH_STATUS_STOP = 2;
    public transient /* synthetic */ FieldHolder $fh;

    public PushStatus() {
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
}
