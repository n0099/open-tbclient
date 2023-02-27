package com.huawei.hms.support.api.entity.core;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class JosStatusCodes {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int RNT_CODE_NETWORK_ERROR = 8300;
    public static final int RNT_CODE_NO_JOS_INFO = 8002;
    public static final int RNT_CODE_SERVER_ERROR = 8200;
    public static final int RTN_CODE_COMMON_ERROR = 8000;
    public static final int RTN_CODE_NO_SUPPORT_JOS = 8001;
    public static final int RTN_CODE_PARAMS_ERROR = 8100;
    public static final int SUCCESS = 0;
    public transient /* synthetic */ FieldHolder $fh;

    public JosStatusCodes() {
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
