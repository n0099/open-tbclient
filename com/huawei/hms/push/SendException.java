package com.huawei.hms.push;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class SendException extends BaseException {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERROR_INVALID_PARAMETERS = 907122042;
    public static final int ERROR_NO_NETWORK = 907122031;
    public static final int ERROR_NO_TOKEN = 907122030;
    public static final int ERROR_PUSH_SERVER = 907122047;
    public static final int ERROR_SERVICE_NOT_AVAILABLE = 907122046;
    public static final int ERROR_SIZE = 907122041;
    public static final int ERROR_TOKEN_INVALID = 907122032;
    public static final int ERROR_TOO_MANY_MESSAGES = 907122043;
    public static final int ERROR_TTL_EXCEEDED = 907122044;
    public static final int ERROR_UNKNOWN = 907122045;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendException(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
