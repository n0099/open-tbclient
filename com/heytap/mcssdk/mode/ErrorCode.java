package com.heytap.mcssdk.mode;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ErrorCode {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int APP_CALL_LIMITED = 13;
    public static final int ERROR = -2;
    public static final int HTTP_ACTION_NOT_ALLOWED = 12;
    public static final int INSUFFICIENT_ISV_PERMISSIONS = 11;
    public static final int INVALID_APP_KEY = 14;
    public static final int INVALID_ARGUMENTS = 41;
    public static final int INVALID_ENCODING = 25;
    public static final int INVALID_METHOD = 20;
    public static final int INVALID_SIGNATURE_SIGN = 16;
    public static final int INVALID_TIMESTAMP = 19;
    public static final int INVALID_VERSION = 23;
    public static final int IP_BLACK_LIST = 26;
    public static final int MISSING_APP_KEY = 15;
    public static final int MISSING_METHOD = 21;
    public static final int MISSING_REQUIRED_ARGUMENTS = 40;
    public static final int MISSING_SIGNATURE = 17;
    public static final int MISSING_TIMESTAMP = 18;
    public static final int MISSING_VERSION = 22;
    public static final int SERVICE_CURRENTLY_UNAVAILABLE = -1;
    public static final int SUCCESS = 0;
    public static final int UNSUPPORTED_VERSION = 24;
    public transient /* synthetic */ FieldHolder $fh;

    public ErrorCode() {
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
