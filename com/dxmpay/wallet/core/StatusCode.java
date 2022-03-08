package com.dxmpay.wallet.core;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class StatusCode {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int B_SAO_C_AUTH_SERVICE_TYPE = 1153;
    public static final int DOUDBLE_CHECK_CVV2 = 69249;
    public static final int ERROR_AUTH_H5 = 5177;
    public static final int ERROR_AUTH_INFO_NOT_MATCH = 65340;
    public static final int ERROR_AUTH_PAYORDER = 5170;
    public static final int ERROR_BANKCARDBALANCE_NOT_ENOUGH = 60500;
    public static final int ERROR_BANKS_NEED_TO_VERIFY_SMS = 5320;
    public static final int ERROR_CODE_LOCAL = -57353;
    public static final int ERROR_CODE_VERIFY_SMS = -12;
    public static final int ERROR_HTTP_CLIENT = -2;
    public static final int ERROR_HTTP_SERVER = -3;
    public static final int ERROR_INVALID_PARAM = -10;
    public static final int ERROR_INVALID_PARAMETER = 10001;
    public static final int ERROR_INVALID_TOKEN = -5;
    public static final int ERROR_INVLID_RESPONSE = -4;
    public static final int ERROR_NEED_PRE_PASS = 5140;
    public static final int ERROR_NEED_RNAUTH = 5139;
    public static final int ERROR_NOT_IMPLEMENTED = 10004;
    public static final int ERROR_NOT_LOGIN = 5003;
    public static final int ERROR_NOT_PASS_LOGIN = 5099;
    public static final int ERROR_NOT_SUPPORT = 10009;
    public static final int ERROR_NO_NETWORK = -8;
    public static final int ERROR_PASSWORD = -7;
    public static final int ERROR_PAY_NEED_VERIFY_CODE = 51010;
    public static final int ERROR_PAY_TO_RNAUTH = 1150;
    public static final int ERROR_PAY_TO_RNAUTH_FOR_FINANCE = 1171;
    public static final int ERROR_RESPONSE = 10011;
    public static final int ERROR_REST_FRAMEWORK_EXCEPTION = -15;
    public static final int ERROR_REST_FRAMEWORK_SSL = -16;
    public static final int ERROR_RISK_REFUSE = 51000;
    public static final int ERROR_THIRD_LOGIN_NEED_AUTH = 5095;
    public static final int ERROR_THIRD_LOGIN_NEED_BIND = 5096;
    public static final int ERROR_TURIST_LOGIN = 5097;
    public static final int ERROR_TURIST_LOGIN_NEED_AUTH = 5093;
    public static final int ERROR_TURIST_LOGIN_NEED_BIND = 5094;
    public static final int ERROR_UNKOWN = -11;
    public static final int ERROR_USER_BACK = -2;
    public static final int ERROR_USER_EXIT = -203;
    public static final int ERROR_WITHDRAW_OFFLINE = 6000;
    public static final int FINGERPRINT_AUTH_ERROR = 65312;
    public static final int PUBLIC_SECURITY_AGE_ERROR = 5133;
    public static final int PUBLIC_SECURITY_ALEARY_BOND_ERROR_1 = 5135;
    public static final int PUBLIC_SECURITY_ALEARY_BOND_ERROR_2 = 5137;
    public static final int PUBLIC_SECURITY_AUTH_ACCOUNT_MORE = 5125;
    public static final int PUBLIC_SECURITY_AUTH_DAYTIMES_ERROR = 2435;
    public static final int PUBLIC_SECURITY_AUTH_NORESPONSE_ERROR = 5132;
    public static final int PUBLIC_SECURITY_AUTH_NORESULT_ERROR = 5131;
    public static final int PUBLIC_SECURITY_AUTH_NOT_EXIST = 5126;
    public static final int PUBLIC_SECURITY_AUTH_SMS_ERROR = 2431;
    public static final int PUBLIC_SECURITY_NOT_THE_SAME_ERROR = 5136;
    public static final int RET_OK = 0;
    public static final int SERVICE_CODE1_CANNOT_DISCOUNT = 80320;
    public static final int SERVICE_CODE2_CANNOT_DISCOUNT = 80321;
    public static final int SERVICE_CODE3_CANNOT_DISCOUNT = 80326;
    public static final int SERVICE_CODE4_CANNOT_DISCOUNT = 80327;
    public static final int SERVICE_CODE_ACCOUNT_LOCKED = 100018;
    public static final int SERVICE_CODE_BALANCE_PAY_INFINITY = 5173;
    public static final int SERVICE_CODE_BALANCE_PAY_NEED_TO_PROMOTE = 5172;
    public static final int SERVICE_CODE_BALANCE_PAY_NO_AUTH = 5171;
    public static final int SERVICE_CODE_CARD_INFO_NEED_UPDATE = 15500;
    public static final int SERVICE_CODE_CARD_MAYBE_ERR_AND_NOT_SUPPORT = 100028;
    public static final int SERVICE_CODE_CARD_NUMBER_MAYBE_ERROR = 100027;
    public static final int SERVICE_CODE_ERROR_PWD_IN_RNAUTH = 16550;
    public static final int SERVICE_CODE_LOCK_PWD_IN_RNAUTH = 16545;
    public static final int SERVICE_CODE_NEED_CALL_H5_CASHIERDESK = 65015;
    public static final int SERVICE_CODE_NOT_IDENTIFY_CARD = 100010;
    public static final int SERVICE_CODE_NOT_LOGIN = 5003;
    public static final int SERVICE_CODE_NOT_SUPPORT_CARD = 100040;
    public static final int SERVICE_CODE_NOT_SUPPORT_EASYPAY = 100026;
    public static final int SERVICE_CODE_PASS_MOBILE = 100015;
    public static final int SERVICE_CODE_PASS_WRONG = 100048;
    public static final int SERVICE_CODE_SCANCODE_TIMEOUT = 65235;
    public static final int SERVICE_CODE_SEND_SMS = 38509;
    public static final int SERVICE_CODE_SEND_SMS2 = 38510;
    public static final int SERVICE_CODE_SEND_SMS3 = 38513;
    public static final int SERVICE_CODE_SEND_SMS4 = 38601;
    public static final int SERVICE_CODE_SEND_SMS5 = 68000;
    public static final int SERVICE_CODE_SESSION_OVERDUE = 100045;
    public static final int SERVICE_ERROR_PASS_INVALID = 100038;
    public static final int SERVICE_ERROR_PASS_WEEK_END = 16439;
    public static final int SERVICE_ERROR_PASS_WEEK_START = 16420;
    public static final int SERVICE_THIRD_HALF_USER = 100035;
    public static final int SERVICE_THIRD_USER = 100036;
    public static final int SESSION_TIME_OUT = 65025;
    public transient /* synthetic */ FieldHolder $fh;

    public StatusCode() {
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
