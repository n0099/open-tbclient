package com.yy.mobile.framework.revenuesdk.baseapi;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ErrorCode {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ARGS_ERROR = -400;
    public static final int AUTH_FAIL = -401;
    public static final int BIND_LOAD_FULL = 200406;
    public static final int BIND_NOTREADY_TORETRY = 200300;
    public static final int BIND_OTP_FAIL = 200403;
    public static final int BIND_OTP_TIMEOUT = 200408;
    public static final int BIND_RESOURCE_CONFLICT = 200409;
    public static final int BIND_SUCCESS = 200200;
    public static final int CAN_NOT_USE = -5;
    public static final int CLIENT_CANCEL_REQUEST = -800;
    public static final int CONSUME_CONFIRM_NEED = -10;
    public static final int EXCEED_DAILY_LIMIT = -7;
    public static final int EXCEED_LIMIT = -8;
    public static final int FUNCTION_TEMP_FORBID = -501;
    public static final int GIFT_CALLBACK_TYPE_ERROR = -31;
    public static final int ILLEGAL_ACCOUNT = -1;
    public static final int NOT_ENOUGH_BALANCE = -3;
    public static final int NO_AUTH = -403;
    public static final int NO_EXIST_BUSINESS = -2;
    public static final int NO_EXIST_ITEM = -4;
    public static final int NO_OR_NOT_ENOUGH_AMOUNT = -6;
    public static final int PROPS_CHANNEL_LIMET = -11;
    public static final int RISK_ALREADY_CHALLENGED = -714;
    public static final int RISK_FAIL = -711;
    public static final int RISK_PARAMS_ERROR = -713;
    public static final int RISK_USER_CANCEL = -712;
    public static final int SDK_NEED_BIND = 110002;
    public static final int SDK_NO_CONNECTED = 110001;
    public static final int SDK_PARSE_ERROR = -30;
    public static final int SDK_TIMEOUT = 110003;
    public static final int SDK_TIMEOUT_CONNECT_FAIL = 110004;
    public static final int SDK_UNKNOW = 110255;
    public static final int SERVER_ERROR = -500;
    public static final int SUCCESS = 1;
    public static final int SVR_BADGATEWAY = 200502;
    public static final int SVR_BADREQUEST = 200400;
    public static final int SVR_FAIL = 200403;
    public static final int SVR_GATEWAYTIMEOUT = 200504;
    public static final int SVR_INTERNALSERVERERROR = 200500;
    public static final int SVR_NOTFOUND = 200404;
    public static final int SVR_PAYMENTREQUIRED = 200402;
    public static final int SVR_SERVICEUNAVAILABLE = 200503;
    public static final int SVR_SUCCESS = 200200;
    public static final int SVR_TIMEOUT = 200408;
    public static final int SVR_UNAUTHORIZED = 200401;
    public static final int UNKNOWN_CMD = -404;
    public static final int USE_Concurrent = -505;
    public static final int USE_FORBID = -12;
    public static final int YB_FROZEN = -9;
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
