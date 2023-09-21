package com.huawei.hms.aaid.constant;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.push.SendException;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import com.huawei.hms.support.api.entity.core.CommonCode;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class ErrorEnum {
    public static final /* synthetic */ ErrorEnum[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final SparseArray<ErrorEnum> ENUM_MAPPER;
    public static final ErrorEnum ERROR_3RD_PARTY_INTERNAL_ERROR;
    public static final ErrorEnum ERROR_API_NOT_SPECIFIED;
    public static final ErrorEnum ERROR_APP_SERVER_NOT_ONLINE;
    public static final ErrorEnum ERROR_ARGUMENTS_INVALID;
    public static final ErrorEnum ERROR_AUTH_INFO_NOT_EXIST;
    public static final ErrorEnum ERROR_AUTO_INITIALIZING;
    public static final ErrorEnum ERROR_BIND_SERVICE_SELF_MAPPING;
    public static final ErrorEnum ERROR_BUILD_CONTENT_ERROR;
    public static final ErrorEnum ERROR_CACHE_SIZE_EXCEED;
    public static final ErrorEnum ERROR_CERT_FINGERPRINT_EMPTY;
    public static final ErrorEnum ERROR_CERT_FINGERPRINT_ERROR;
    public static final ErrorEnum ERROR_CLIENT_API_INVALID;
    public static final ErrorEnum ERROR_DELETE_3RD_PARTY_TOKEN_FAILED;
    public static final ErrorEnum ERROR_EXECUTE_TIMEOUT;
    public static final ErrorEnum ERROR_FETCH_DOMAIN_FAILED;
    public static final ErrorEnum ERROR_GET_3RD_PARTY_TOKEN_FAILED;
    public static final ErrorEnum ERROR_GET_SCOPE_ERROR;
    public static final ErrorEnum ERROR_HMS_CLIENT_API;
    public static final ErrorEnum ERROR_HMS_DEVICE_AUTH_FAILED_SELF_MAPPING;
    public static final ErrorEnum ERROR_HWID_NOT_LOGIN;
    public static final ErrorEnum ERROR_INTERNAL_ERROR;
    public static final ErrorEnum ERROR_INVALID_PARAMETERS;
    public static final ErrorEnum ERROR_LENGTH;
    public static final ErrorEnum ERROR_LENGTH_OLD;
    public static final ErrorEnum ERROR_MAIN_THREAD;
    public static final ErrorEnum ERROR_MISSING_PROJECT_ID;
    public static final ErrorEnum ERROR_MSG_CACHE;
    public static final ErrorEnum ERROR_MULTISENDER_NO_RIGHT;
    public static final ErrorEnum ERROR_NAMING_INVALID;
    public static final ErrorEnum ERROR_NOT_ALLOW_CROSS_APPLY;
    public static final ErrorEnum ERROR_NOT_IN_SERVICE;
    public static final ErrorEnum ERROR_NOT_SUPPORT_SUB_USER;
    public static final ErrorEnum ERROR_NO_CONNECTION_ID;
    public static final ErrorEnum ERROR_NO_CONNECTION_ID_OLD;
    public static final ErrorEnum ERROR_NO_DEVICE_ID_TYPE;
    public static final ErrorEnum ERROR_NO_DEVICE_ID_TYPE_OLD;
    public static final ErrorEnum ERROR_NO_NETWORK;
    public static final ErrorEnum ERROR_NO_NETWORK_OLD;
    public static final ErrorEnum ERROR_NO_RIGHT;
    public static final ErrorEnum ERROR_NO_RIGHT_SELF_MAPPING;
    public static final ErrorEnum ERROR_NO_TOKEN;
    public static final ErrorEnum ERROR_NO_TOKENSIGN;
    public static final ErrorEnum ERROR_NO_TOKEN_OLD;
    public static final ErrorEnum ERROR_OPERATION_NOT_SUPPORTED;
    public static final ErrorEnum ERROR_OPER_IN_CHILD_PROCESS;
    public static final ErrorEnum ERROR_OVER_FLOW_CONTROL_SIZE;
    public static final ErrorEnum ERROR_PARAM_INVALID;
    public static final ErrorEnum ERROR_PERMISSION_EXPIRED;
    public static final ErrorEnum ERROR_PERMISSION_LIST_EMPTY;
    public static final ErrorEnum ERROR_PERMISSION_NOT_AUTHORIZED;
    public static final ErrorEnum ERROR_PERMISSION_NOT_EXIST;
    public static final ErrorEnum ERROR_PROFILE_EXCEED;
    public static final ErrorEnum ERROR_PUSH_ARGUMENTS_INVALID;
    public static final ErrorEnum ERROR_PUSH_CLIENT_API_INVALID;
    public static final ErrorEnum ERROR_PUSH_EXECUTE_TIMEOUT;
    public static final ErrorEnum ERROR_PUSH_INTERNAL_ERROR;
    public static final ErrorEnum ERROR_PUSH_NAMING_INVALID;
    public static final ErrorEnum ERROR_PUSH_NOT_IN_SERVICE;
    public static final ErrorEnum ERROR_PUSH_SERVER;
    public static final ErrorEnum ERROR_PUSH_SERVER_OLD;
    public static final ErrorEnum ERROR_RESTRICT_GET_TOKEN;
    public static final ErrorEnum ERROR_RETRY_LATER_SELF_MAPPING;
    public static final ErrorEnum ERROR_SCOPE_LIST_EMPTY;
    public static final ErrorEnum ERROR_SEND_SELF_MAPPING;
    public static final ErrorEnum ERROR_SERVICE_NOT_AVAILABLE;
    public static final ErrorEnum ERROR_SESSION_INVALID;
    public static final ErrorEnum ERROR_SIZE;
    public static final ErrorEnum ERROR_SPUSH_ESSION_INVALID;
    public static final ErrorEnum ERROR_STORAGE_LOCATION_EMPTY;
    public static final ErrorEnum ERROR_TOKENSIGN_VALID;
    public static final ErrorEnum ERROR_TOKEN_DECRYPT;
    public static final ErrorEnum ERROR_TOKEN_URL_EMPTY;
    public static final ErrorEnum ERROR_TOO_MANY_MESSAGES;
    public static final ErrorEnum ERROR_TOPIC_EXCEED;
    public static final ErrorEnum ERROR_TOPIC_SEND;
    public static final ErrorEnum ERROR_TTL_EXCEEDED;
    public static final ErrorEnum ERROR_UNKNOWN;
    public static final ErrorEnum ERROR_UPSTREAM_DEVICE_NOT_IN_GROUP;
    public static final ErrorEnum ERROR_UPSTREAM_STORAGE_LOCATION_EMPTY;
    public static final ErrorEnum ERROR_UPSTREAM_TOKENSIGN_VALID;
    public static final ErrorEnum ERROR_UPSTREAM_TOKEN_DECRYPT;
    public static final ErrorEnum SUCCESS;
    public transient /* synthetic */ FieldHolder $fh;
    public int externalCode;
    public int internalCode;
    public String message;

    static {
        InterceptResult invokeClinit;
        ErrorEnum[] values;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(346424696, "Lcom/huawei/hms/aaid/constant/ErrorEnum;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(346424696, "Lcom/huawei/hms/aaid/constant/ErrorEnum;");
                return;
            }
        }
        SUCCESS = new ErrorEnum("SUCCESS", 0, 0, 0, "success");
        ERROR_NO_TOKEN = new ErrorEnum("ERROR_NO_TOKEN", 1, 800000000, SendException.ERROR_NO_TOKEN, "token missing");
        ERROR_NO_TOKENSIGN = new ErrorEnum("ERROR_NO_TOKENSIGN", 2, 800000001, SendException.ERROR_TOKEN_INVALID, "token invalid");
        ERROR_NO_NETWORK = new ErrorEnum("ERROR_NO_NETWORK", 3, 800000002, SendException.ERROR_NO_NETWORK, "no network");
        ERROR_SERVICE_NOT_AVAILABLE = new ErrorEnum("ERROR_SERVICE_NOT_AVAILABLE", 4, 800000003, SendException.ERROR_SERVICE_NOT_AVAILABLE, "service not available");
        ERROR_PUSH_SERVER = new ErrorEnum("ERROR_PUSH_SERVER", 5, 800000004, SendException.ERROR_PUSH_SERVER, "push server error");
        ERROR_UNKNOWN = new ErrorEnum("ERROR_UNKNOWN", 6, 800000005, SendException.ERROR_UNKNOWN, "unknown error");
        ERROR_NO_RIGHT = new ErrorEnum("ERROR_NO_RIGHT", 7, 800100000, 907122036, "no right");
        ERROR_NO_CONNECTION_ID = new ErrorEnum("ERROR_NO_CONNECTION_ID", 8, 800100001, 907122037, "get token error");
        ERROR_LENGTH = new ErrorEnum("ERROR_LENGTH", 9, 800100002, 907122037, "get token error");
        ERROR_NO_DEVICE_ID_TYPE = new ErrorEnum("ERROR_NO_DEVICE_ID_TYPE", 10, 800100003, 907122037, "get token error");
        ERROR_PARAM_INVALID = new ErrorEnum("ERROR_PARAM_INVALID", 11, 800100004, 907122037, "get token error");
        ERROR_TOKEN_URL_EMPTY = new ErrorEnum("ERROR_TOKEN_URL_EMPTY", 12, 800100005, 907122037, "get token error");
        ERROR_NOT_ALLOW_CROSS_APPLY = new ErrorEnum("ERROR_NOT_ALLOW_CROSS_APPLY", 13, 800100006, 907122053, "Failed to apply for the token. Cross-region application is not allowed.");
        ERROR_MULTISENDER_NO_RIGHT = new ErrorEnum("ERROR_MULTISENDER_NO_RIGHT", 14, 800100007, 907122039, "Failed to apply for the token. No multisender right.");
        ERROR_TOKEN_DECRYPT = new ErrorEnum("ERROR_TOKEN_DECRYPT", 15, 800200001, SendException.ERROR_TOKEN_INVALID, "token invalid");
        ERROR_TOKENSIGN_VALID = new ErrorEnum("ERROR_TOKENSIGN_VALID", 16, 800200002, SendException.ERROR_TOKEN_INVALID, "token invalid");
        ERROR_TOPIC_EXCEED = new ErrorEnum("ERROR_TOPIC_EXCEED", 17, 800200003, 907122034, "topic exceed");
        ERROR_TOPIC_SEND = new ErrorEnum("ERROR_TOPIC_SEND", 18, 800200004, 907122035, "topic send error");
        ERROR_STORAGE_LOCATION_EMPTY = new ErrorEnum("ERROR_STORAGE_LOCATION_EMPTY", 19, 800200005, 907122038, "storage location is empty or invalid");
        ERROR_SIZE = new ErrorEnum("ERROR_SIZE", 20, 800300000, SendException.ERROR_SIZE, "message size error");
        ERROR_INVALID_PARAMETERS = new ErrorEnum("ERROR_INVALID_PARAMETERS", 21, 800300001, SendException.ERROR_INVALID_PARAMETERS, "parameter invalid");
        ERROR_TOO_MANY_MESSAGES = new ErrorEnum("ERROR_TOO_MANY_MESSAGES", 22, 800300002, SendException.ERROR_TOO_MANY_MESSAGES, "too many messages");
        ERROR_TTL_EXCEEDED = new ErrorEnum("ERROR_TTL_EXCEEDED", 23, 800300003, SendException.ERROR_TTL_EXCEEDED, "ttl exceed");
        ERROR_UPSTREAM_TOKEN_DECRYPT = new ErrorEnum("ERROR_UPSTREAM_TOKEN_DECRYPT", 24, 800300004, SendException.ERROR_TOKEN_INVALID, "token invalid");
        ERROR_UPSTREAM_TOKENSIGN_VALID = new ErrorEnum("ERROR_UPSTREAM_TOKENSIGN_VALID", 25, 800300005, SendException.ERROR_TOKEN_INVALID, "token invalid");
        ERROR_UPSTREAM_DEVICE_NOT_IN_GROUP = new ErrorEnum("ERROR_UPSTREAM_DEVICE_NOT_IN_GROUP", 26, 800300006, 907122057, "device not in device group");
        ERROR_UPSTREAM_STORAGE_LOCATION_EMPTY = new ErrorEnum("ERROR_UPSTREAM_STORAGE_LOCATION_EMPTY", 27, 800300007, 907122038, "storage location is empty or invalid");
        ERROR_CACHE_SIZE_EXCEED = new ErrorEnum("ERROR_CACHE_SIZE_EXCEED", 28, 800300008, 907122058, "cache size exceeds threshold");
        ERROR_MSG_CACHE = new ErrorEnum("ERROR_MSG_CACHE", 29, 800300009, 907122059, "message is cached");
        ERROR_APP_SERVER_NOT_ONLINE = new ErrorEnum("ERROR_APP_SERVER_NOT_ONLINE", 30, 800300010, 907122060, "app server is not online.");
        ERROR_OVER_FLOW_CONTROL_SIZE = new ErrorEnum("ERROR_OVER_FLOW_CONTROL_SIZE", 31, 800300011, 907122061, "frequency of message is over flow control size.");
        ERROR_PUSH_ARGUMENTS_INVALID = new ErrorEnum("ERROR_PUSH_ARGUMENTS_INVALID", 32, 807135000, CommonCode.ErrorCode.ARGUMENTS_INVALID, "arguments invalid");
        ERROR_PUSH_INTERNAL_ERROR = new ErrorEnum("ERROR_PUSH_INTERNAL_ERROR", 33, 807135001, CommonCode.ErrorCode.INTERNAL_ERROR, "internal error");
        ERROR_PUSH_NAMING_INVALID = new ErrorEnum("ERROR_PUSH_NAMING_INVALID", 34, 807135002, CommonCode.ErrorCode.NAMING_INVALID, "naming invalid");
        ERROR_PUSH_CLIENT_API_INVALID = new ErrorEnum("ERROR_PUSH_CLIENT_API_INVALID", 35, 807135003, CommonCode.ErrorCode.CLIENT_API_INVALID, "client api invalid");
        ERROR_PUSH_EXECUTE_TIMEOUT = new ErrorEnum("ERROR_PUSH_EXECUTE_TIMEOUT", 36, 807135004, CommonCode.ErrorCode.EXECUTE_TIMEOUT, "execute timeout");
        ERROR_PUSH_NOT_IN_SERVICE = new ErrorEnum("ERROR_PUSH_NOT_IN_SERVICE", 37, 807135005, CommonCode.ErrorCode.NOT_IN_SERVICE, "not int service");
        ERROR_SPUSH_ESSION_INVALID = new ErrorEnum("ERROR_SPUSH_ESSION_INVALID", 38, 807135006, CommonCode.ErrorCode.SESSION_INVALID, "session invalid");
        ERROR_ARGUMENTS_INVALID = new ErrorEnum("ERROR_ARGUMENTS_INVALID", 39, CommonCode.ErrorCode.ARGUMENTS_INVALID, CommonCode.ErrorCode.ARGUMENTS_INVALID, "arguments invalid");
        ERROR_INTERNAL_ERROR = new ErrorEnum("ERROR_INTERNAL_ERROR", 40, CommonCode.ErrorCode.INTERNAL_ERROR, CommonCode.ErrorCode.INTERNAL_ERROR, "internal error");
        ERROR_NAMING_INVALID = new ErrorEnum("ERROR_NAMING_INVALID", 41, CommonCode.ErrorCode.NAMING_INVALID, CommonCode.ErrorCode.NAMING_INVALID, "naming invalid");
        ERROR_CLIENT_API_INVALID = new ErrorEnum("ERROR_CLIENT_API_INVALID", 42, CommonCode.ErrorCode.CLIENT_API_INVALID, CommonCode.ErrorCode.CLIENT_API_INVALID, "client api invalid");
        ERROR_EXECUTE_TIMEOUT = new ErrorEnum("ERROR_EXECUTE_TIMEOUT", 43, CommonCode.ErrorCode.EXECUTE_TIMEOUT, CommonCode.ErrorCode.EXECUTE_TIMEOUT, "execute timeout");
        ERROR_NOT_IN_SERVICE = new ErrorEnum("ERROR_NOT_IN_SERVICE", 44, CommonCode.ErrorCode.NOT_IN_SERVICE, CommonCode.ErrorCode.NOT_IN_SERVICE, "not int service");
        ERROR_SESSION_INVALID = new ErrorEnum("ERROR_SESSION_INVALID", 45, CommonCode.ErrorCode.SESSION_INVALID, CommonCode.ErrorCode.SESSION_INVALID, "session invalid");
        ERROR_API_NOT_SPECIFIED = new ErrorEnum("ERROR_API_NOT_SPECIFIED", 46, 1002, 1002, "API not specified");
        ERROR_GET_SCOPE_ERROR = new ErrorEnum("ERROR_GET_SCOPE_ERROR", 47, AuthCode.ErrorCode.GET_SCOPE_ERROR, AuthCode.ErrorCode.GET_SCOPE_ERROR, "get scope error");
        ERROR_SCOPE_LIST_EMPTY = new ErrorEnum("ERROR_SCOPE_LIST_EMPTY", 48, AuthCode.ErrorCode.SCOPE_LIST_EMPTY, AuthCode.ErrorCode.SCOPE_LIST_EMPTY, "scope list empty");
        ERROR_CERT_FINGERPRINT_EMPTY = new ErrorEnum("ERROR_CERT_FINGERPRINT_EMPTY", 49, AuthCode.ErrorCode.CERT_FINGERPRINT_EMPTY, AuthCode.ErrorCode.CERT_FINGERPRINT_EMPTY, "certificate fingerprint empty");
        ERROR_PERMISSION_LIST_EMPTY = new ErrorEnum("ERROR_PERMISSION_LIST_EMPTY", 50, AuthCode.ErrorCode.PERMISSION_LIST_EMPTY, AuthCode.ErrorCode.PERMISSION_LIST_EMPTY, "permission list empty");
        ERROR_AUTH_INFO_NOT_EXIST = new ErrorEnum("ERROR_AUTH_INFO_NOT_EXIST", 51, 6002, 6002, "auth info not exist");
        ERROR_CERT_FINGERPRINT_ERROR = new ErrorEnum("ERROR_CERT_FINGERPRINT_ERROR", 52, AuthCode.StatusCode.CERT_FINGERPRINT_ERROR, AuthCode.StatusCode.CERT_FINGERPRINT_ERROR, "certificate fingerprint error");
        ERROR_PERMISSION_NOT_EXIST = new ErrorEnum("ERROR_PERMISSION_NOT_EXIST", 53, AuthCode.StatusCode.PERMISSION_NOT_EXIST, AuthCode.StatusCode.PERMISSION_NOT_EXIST, "permission not exist");
        ERROR_PERMISSION_NOT_AUTHORIZED = new ErrorEnum("ERROR_PERMISSION_NOT_AUTHORIZED", 54, AuthCode.StatusCode.PERMISSION_NOT_AUTHORIZED, AuthCode.StatusCode.PERMISSION_NOT_AUTHORIZED, "permission not authorized");
        ERROR_PERMISSION_EXPIRED = new ErrorEnum("ERROR_PERMISSION_EXPIRED", 55, AuthCode.StatusCode.PERMISSION_EXPIRED, AuthCode.StatusCode.PERMISSION_EXPIRED, "permission expired");
        ERROR_NO_NETWORK_OLD = new ErrorEnum("ERROR_NO_NETWORK_OLD", 56, 907122005, SendException.ERROR_NO_NETWORK, "no network");
        ERROR_NO_RIGHT_SELF_MAPPING = new ErrorEnum("ERROR_NO_RIGHT_SELF_MAPPING", 57, 907122011, 907122036, "no right");
        ERROR_NO_CONNECTION_ID_OLD = new ErrorEnum("ERROR_NO_CONNECTION_ID_OLD", 58, 907122012, 907122037, "get token error");
        ERROR_LENGTH_OLD = new ErrorEnum("ERROR_LENGTH_OLD", 59, 907122013, 907122037, "get token error");
        ERROR_NO_DEVICE_ID_TYPE_OLD = new ErrorEnum("ERROR_NO_DEVICE_ID_TYPE_OLD", 60, 907122014, 907122037, "get token error");
        ERROR_PUSH_SERVER_OLD = new ErrorEnum("ERROR_PUSH_SERVER_OLD", 61, 907122017, SendException.ERROR_PUSH_SERVER, "push server error");
        ERROR_NO_TOKEN_OLD = new ErrorEnum("ERROR_NO_TOKEN_OLD", 62, 907122019, SendException.ERROR_NO_TOKEN, "token missing");
        ERROR_HMS_CLIENT_API = new ErrorEnum("ERROR_HMS_CLIENT_API", 63, 907122048, 907122048, "HMS client api invalid");
        ERROR_OPERATION_NOT_SUPPORTED = new ErrorEnum("ERROR_OPERATION_NOT_SUPPORTED", 64, 907122049, 907122049, "operation not supported");
        ERROR_MAIN_THREAD = new ErrorEnum("ERROR_MAIN_THREAD", 65, 907122050, 907122050, "operation in MAIN thread prohibited");
        ERROR_HMS_DEVICE_AUTH_FAILED_SELF_MAPPING = new ErrorEnum("ERROR_HMS_DEVICE_AUTH_FAILED_SELF_MAPPING", 66, 907122051, 907122051, "device certificate auth fail");
        ERROR_BIND_SERVICE_SELF_MAPPING = new ErrorEnum("ERROR_BIND_SERVICE_SELF_MAPPING", 67, 907122052, 907122052, "bind service failed.");
        ERROR_AUTO_INITIALIZING = new ErrorEnum("ERROR_AUTO_INITIALIZING", 68, 907122054, 907122054, "push kit initializing, try again later");
        ERROR_RETRY_LATER_SELF_MAPPING = new ErrorEnum("ERROR_RETRY_LATER_SELF_MAPPING", 69, 907122055, 907122055, "System busy, please retry later.");
        ERROR_SEND_SELF_MAPPING = new ErrorEnum("ERROR_SEND_SELF_MAPPING", 70, 907122056, 907122056, "send error.");
        ERROR_MISSING_PROJECT_ID = new ErrorEnum("ERROR_MISSING_PROJECT_ID", 71, 907122064, 907122064, "agc connect services config missing project id");
        ERROR_RESTRICT_GET_TOKEN = new ErrorEnum("ERROR_RESTRICT_GET_TOKEN", 72, 800100014, 907122065, "restrict get token");
        ERROR_GET_3RD_PARTY_TOKEN_FAILED = new ErrorEnum("ERROR_GET_3RD_PARTY_TOKEN_FAILED", 73, 907122101, 907122101, "get 3rd-party token failed.");
        ERROR_DELETE_3RD_PARTY_TOKEN_FAILED = new ErrorEnum("ERROR_DELETE_3RD_PARTY_TOKEN_FAILED", 74, 907122102, 907122102, "delete 3rd-party token failed.");
        ERROR_3RD_PARTY_INTERNAL_ERROR = new ErrorEnum("ERROR_3RD_PARTY_INTERNAL_ERROR", 75, 907122103, 907122103, "3rd-party internal error.");
        ERROR_FETCH_DOMAIN_FAILED = new ErrorEnum("ERROR_FETCH_DOMAIN_FAILED", 76, 907135104, 907135104, "fetch domain failed.");
        ERROR_BUILD_CONTENT_ERROR = new ErrorEnum("ERROR_BUILD_CONTENT_ERROR", 77, 907122105, 907122105, "build content error.");
        ERROR_HWID_NOT_LOGIN = new ErrorEnum("ERROR_HWID_NOT_LOGIN", 78, 907122066, 907122066, "account logout");
        ERROR_PROFILE_EXCEED = new ErrorEnum("ERROR_PROFILE_EXCEED", 79, 800400000, 907122067, "profile num over limit");
        ERROR_OPER_IN_CHILD_PROCESS = new ErrorEnum("ERROR_OPER_IN_CHILD_PROCESS", 80, 907122068, 907122068, "Operations in child processes are not supported.");
        ErrorEnum errorEnum = new ErrorEnum("ERROR_NOT_SUPPORT_SUB_USER", 81, 907122069, 907122069, "Operations on sub-users are not supported.");
        ERROR_NOT_SUPPORT_SUB_USER = errorEnum;
        $VALUES = new ErrorEnum[]{SUCCESS, ERROR_NO_TOKEN, ERROR_NO_TOKENSIGN, ERROR_NO_NETWORK, ERROR_SERVICE_NOT_AVAILABLE, ERROR_PUSH_SERVER, ERROR_UNKNOWN, ERROR_NO_RIGHT, ERROR_NO_CONNECTION_ID, ERROR_LENGTH, ERROR_NO_DEVICE_ID_TYPE, ERROR_PARAM_INVALID, ERROR_TOKEN_URL_EMPTY, ERROR_NOT_ALLOW_CROSS_APPLY, ERROR_MULTISENDER_NO_RIGHT, ERROR_TOKEN_DECRYPT, ERROR_TOKENSIGN_VALID, ERROR_TOPIC_EXCEED, ERROR_TOPIC_SEND, ERROR_STORAGE_LOCATION_EMPTY, ERROR_SIZE, ERROR_INVALID_PARAMETERS, ERROR_TOO_MANY_MESSAGES, ERROR_TTL_EXCEEDED, ERROR_UPSTREAM_TOKEN_DECRYPT, ERROR_UPSTREAM_TOKENSIGN_VALID, ERROR_UPSTREAM_DEVICE_NOT_IN_GROUP, ERROR_UPSTREAM_STORAGE_LOCATION_EMPTY, ERROR_CACHE_SIZE_EXCEED, ERROR_MSG_CACHE, ERROR_APP_SERVER_NOT_ONLINE, ERROR_OVER_FLOW_CONTROL_SIZE, ERROR_PUSH_ARGUMENTS_INVALID, ERROR_PUSH_INTERNAL_ERROR, ERROR_PUSH_NAMING_INVALID, ERROR_PUSH_CLIENT_API_INVALID, ERROR_PUSH_EXECUTE_TIMEOUT, ERROR_PUSH_NOT_IN_SERVICE, ERROR_SPUSH_ESSION_INVALID, ERROR_ARGUMENTS_INVALID, ERROR_INTERNAL_ERROR, ERROR_NAMING_INVALID, ERROR_CLIENT_API_INVALID, ERROR_EXECUTE_TIMEOUT, ERROR_NOT_IN_SERVICE, ERROR_SESSION_INVALID, ERROR_API_NOT_SPECIFIED, ERROR_GET_SCOPE_ERROR, ERROR_SCOPE_LIST_EMPTY, ERROR_CERT_FINGERPRINT_EMPTY, ERROR_PERMISSION_LIST_EMPTY, ERROR_AUTH_INFO_NOT_EXIST, ERROR_CERT_FINGERPRINT_ERROR, ERROR_PERMISSION_NOT_EXIST, ERROR_PERMISSION_NOT_AUTHORIZED, ERROR_PERMISSION_EXPIRED, ERROR_NO_NETWORK_OLD, ERROR_NO_RIGHT_SELF_MAPPING, ERROR_NO_CONNECTION_ID_OLD, ERROR_LENGTH_OLD, ERROR_NO_DEVICE_ID_TYPE_OLD, ERROR_PUSH_SERVER_OLD, ERROR_NO_TOKEN_OLD, ERROR_HMS_CLIENT_API, ERROR_OPERATION_NOT_SUPPORTED, ERROR_MAIN_THREAD, ERROR_HMS_DEVICE_AUTH_FAILED_SELF_MAPPING, ERROR_BIND_SERVICE_SELF_MAPPING, ERROR_AUTO_INITIALIZING, ERROR_RETRY_LATER_SELF_MAPPING, ERROR_SEND_SELF_MAPPING, ERROR_MISSING_PROJECT_ID, ERROR_RESTRICT_GET_TOKEN, ERROR_GET_3RD_PARTY_TOKEN_FAILED, ERROR_DELETE_3RD_PARTY_TOKEN_FAILED, ERROR_3RD_PARTY_INTERNAL_ERROR, ERROR_FETCH_DOMAIN_FAILED, ERROR_BUILD_CONTENT_ERROR, ERROR_HWID_NOT_LOGIN, ERROR_PROFILE_EXCEED, ERROR_OPER_IN_CHILD_PROCESS, errorEnum};
        ENUM_MAPPER = new SparseArray<>();
        for (ErrorEnum errorEnum2 : values()) {
            ENUM_MAPPER.put(errorEnum2.internalCode, errorEnum2);
            ENUM_MAPPER.put(errorEnum2.externalCode, errorEnum2);
        }
    }

    public ErrorEnum(String str, int i, int i2, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.internalCode = i2;
        this.externalCode = i3;
        this.message = str2;
    }

    public static ErrorEnum fromCode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            return ENUM_MAPPER.get(i, ERROR_UNKNOWN);
        }
        return (ErrorEnum) invokeI.objValue;
    }

    public static ErrorEnum valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return (ErrorEnum) Enum.valueOf(ErrorEnum.class, str);
        }
        return (ErrorEnum) invokeL.objValue;
    }

    public static ErrorEnum[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return (ErrorEnum[]) $VALUES.clone();
        }
        return (ErrorEnum[]) invokeV.objValue;
    }

    public int getExternalCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.externalCode;
        }
        return invokeV.intValue;
    }

    public int getInternalCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.internalCode;
        }
        return invokeV.intValue;
    }

    public String getMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.message;
        }
        return (String) invokeV.objValue;
    }

    public ApiException toApiException() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return new ApiException(new Status(getExternalCode(), getMessage()));
        }
        return (ApiException) invokeV.objValue;
    }
}
