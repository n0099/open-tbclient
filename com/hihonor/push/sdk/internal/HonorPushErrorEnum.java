package com.hihonor.push.sdk.internal;

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
import com.hihonor.push.sdk.common.data.ApiException;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class HonorPushErrorEnum {
    public static /* synthetic */ Interceptable $ic;
    public static final SparseArray<HonorPushErrorEnum> ENUM_MAPPER;
    public static final HonorPushErrorEnum ERROR_ARGUMENTS_INVALID;
    public static final HonorPushErrorEnum ERROR_BIND_SERVICE;
    public static final HonorPushErrorEnum ERROR_CERT_FINGERPRINT_EMPTY;
    public static final HonorPushErrorEnum ERROR_HTTP_OPERATION_FREQUENTLY;
    public static final HonorPushErrorEnum ERROR_INTERNAL_ERROR;
    public static final HonorPushErrorEnum ERROR_MAIN_THREAD;
    public static final HonorPushErrorEnum ERROR_NETWORK_NONE;
    public static final HonorPushErrorEnum ERROR_NOT_INITIALIZED;
    public static final HonorPushErrorEnum ERROR_NOT_SUPPORT_PUSH;
    public static final HonorPushErrorEnum ERROR_NO_APPID;
    public static final HonorPushErrorEnum ERROR_NO_TOKEN;
    public static final HonorPushErrorEnum ERROR_OPERATION_FREQUENTLY;
    public static final HonorPushErrorEnum ERROR_PUSH_SERVER;
    public static final HonorPushErrorEnum ERROR_SERVICE_ARGUMENTS_INVALID;
    public static final HonorPushErrorEnum ERROR_SERVICE_DISABLED;
    public static final HonorPushErrorEnum ERROR_SERVICE_DISCONNECTED;
    public static final HonorPushErrorEnum ERROR_SERVICE_INVALID;
    public static final HonorPushErrorEnum ERROR_SERVICE_MISSING;
    public static final HonorPushErrorEnum ERROR_SERVICE_NULL_BINDING;
    public static final HonorPushErrorEnum ERROR_SERVICE_REQUEST_TIME_OUT;
    public static final HonorPushErrorEnum ERROR_SERVICE_TIME_OUT;
    public static final HonorPushErrorEnum ERROR_STATEMENT_AGREEMENT;
    public static final HonorPushErrorEnum ERROR_UNKNOWN;
    public static final HonorPushErrorEnum SUCCESS;
    public static final /* synthetic */ HonorPushErrorEnum[] a;
    public transient /* synthetic */ FieldHolder $fh;
    public String message;
    public int statusCode;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1340178642, "Lcom/hihonor/push/sdk/internal/HonorPushErrorEnum;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1340178642, "Lcom/hihonor/push/sdk/internal/HonorPushErrorEnum;");
                return;
            }
        }
        HonorPushErrorEnum honorPushErrorEnum = new HonorPushErrorEnum("SUCCESS", 0, 0, "success");
        SUCCESS = honorPushErrorEnum;
        HonorPushErrorEnum honorPushErrorEnum2 = new HonorPushErrorEnum("ERROR_NOT_SUPPORT_PUSH", 1, 8001000, "device is not support push.");
        ERROR_NOT_SUPPORT_PUSH = honorPushErrorEnum2;
        HonorPushErrorEnum honorPushErrorEnum3 = new HonorPushErrorEnum("ERROR_MAIN_THREAD", 2, 8001001, "operation in MAIN thread prohibited.");
        ERROR_MAIN_THREAD = honorPushErrorEnum3;
        HonorPushErrorEnum honorPushErrorEnum4 = new HonorPushErrorEnum("ERROR_NO_TOKEN", 3, 8001004, "token missing.");
        ERROR_NO_TOKEN = honorPushErrorEnum4;
        HonorPushErrorEnum honorPushErrorEnum5 = new HonorPushErrorEnum("ERROR_NO_APPID", 4, 8001002, "app id missing.");
        ERROR_NO_APPID = honorPushErrorEnum5;
        HonorPushErrorEnum honorPushErrorEnum6 = new HonorPushErrorEnum("ERROR_NOT_INITIALIZED", 5, 8001005, "SDK not initialized");
        ERROR_NOT_INITIALIZED = honorPushErrorEnum6;
        HonorPushErrorEnum honorPushErrorEnum7 = new HonorPushErrorEnum("ERROR_CERT_FINGERPRINT_EMPTY", 6, 8001003, "certificate fingerprint empty.");
        ERROR_CERT_FINGERPRINT_EMPTY = honorPushErrorEnum7;
        HonorPushErrorEnum honorPushErrorEnum8 = new HonorPushErrorEnum("ERROR_BIND_SERVICE", 7, 8002001, "bind service failed.");
        ERROR_BIND_SERVICE = honorPushErrorEnum8;
        HonorPushErrorEnum honorPushErrorEnum9 = new HonorPushErrorEnum("ERROR_SERVICE_DISCONNECTED", 8, 8002002, "service disconnected.");
        ERROR_SERVICE_DISCONNECTED = honorPushErrorEnum9;
        HonorPushErrorEnum honorPushErrorEnum10 = new HonorPushErrorEnum("ERROR_SERVICE_TIME_OUT", 9, 8002003, "service connect time out.");
        ERROR_SERVICE_TIME_OUT = honorPushErrorEnum10;
        HonorPushErrorEnum honorPushErrorEnum11 = new HonorPushErrorEnum("ERROR_SERVICE_ARGUMENTS_INVALID", 10, 8002004, "service arguments invalid.");
        ERROR_SERVICE_ARGUMENTS_INVALID = honorPushErrorEnum11;
        HonorPushErrorEnum honorPushErrorEnum12 = new HonorPushErrorEnum("ERROR_SERVICE_NULL_BINDING", 11, 8002005, "service being bound has return null.");
        ERROR_SERVICE_NULL_BINDING = honorPushErrorEnum12;
        HonorPushErrorEnum honorPushErrorEnum13 = new HonorPushErrorEnum("ERROR_SERVICE_INVALID", 12, 8002006, "service invalid.");
        ERROR_SERVICE_INVALID = honorPushErrorEnum13;
        HonorPushErrorEnum honorPushErrorEnum14 = new HonorPushErrorEnum("ERROR_SERVICE_DISABLED", 13, 8002007, "service disabled.");
        ERROR_SERVICE_DISABLED = honorPushErrorEnum14;
        HonorPushErrorEnum honorPushErrorEnum15 = new HonorPushErrorEnum("ERROR_SERVICE_MISSING", 14, 8002008, "service missing.");
        ERROR_SERVICE_MISSING = honorPushErrorEnum15;
        HonorPushErrorEnum honorPushErrorEnum16 = new HonorPushErrorEnum("ERROR_PUSH_SERVER", 15, 8003001, "push server error.");
        ERROR_PUSH_SERVER = honorPushErrorEnum16;
        HonorPushErrorEnum honorPushErrorEnum17 = new HonorPushErrorEnum("ERROR_UNKNOWN", 16, 8003002, "unknown error.");
        ERROR_UNKNOWN = honorPushErrorEnum17;
        HonorPushErrorEnum honorPushErrorEnum18 = new HonorPushErrorEnum("ERROR_INTERNAL_ERROR", 17, 8003003, "internal error.");
        ERROR_INTERNAL_ERROR = honorPushErrorEnum18;
        HonorPushErrorEnum honorPushErrorEnum19 = new HonorPushErrorEnum("ERROR_ARGUMENTS_INVALID", 18, 8003004, "arguments invalid.");
        ERROR_ARGUMENTS_INVALID = honorPushErrorEnum19;
        HonorPushErrorEnum honorPushErrorEnum20 = new HonorPushErrorEnum("ERROR_OPERATION_FREQUENTLY", 19, 8003005, "operation too frequently.");
        ERROR_OPERATION_FREQUENTLY = honorPushErrorEnum20;
        HonorPushErrorEnum honorPushErrorEnum21 = new HonorPushErrorEnum("ERROR_NETWORK_NONE", 20, 8003006, "no network.");
        ERROR_NETWORK_NONE = honorPushErrorEnum21;
        HonorPushErrorEnum honorPushErrorEnum22 = new HonorPushErrorEnum("ERROR_STATEMENT_AGREEMENT", 21, 8003007, "not statement agreement.");
        ERROR_STATEMENT_AGREEMENT = honorPushErrorEnum22;
        HonorPushErrorEnum honorPushErrorEnum23 = new HonorPushErrorEnum("ERROR_SERVICE_REQUEST_TIME_OUT", 22, 8003008, "service request time out.");
        ERROR_SERVICE_REQUEST_TIME_OUT = honorPushErrorEnum23;
        HonorPushErrorEnum honorPushErrorEnum24 = new HonorPushErrorEnum("ERROR_HTTP_OPERATION_FREQUENTLY", 23, 10214, "http operation too frequently.");
        ERROR_HTTP_OPERATION_FREQUENTLY = honorPushErrorEnum24;
        a = new HonorPushErrorEnum[]{honorPushErrorEnum, honorPushErrorEnum2, honorPushErrorEnum3, honorPushErrorEnum4, honorPushErrorEnum5, honorPushErrorEnum6, honorPushErrorEnum7, honorPushErrorEnum8, honorPushErrorEnum9, honorPushErrorEnum10, honorPushErrorEnum11, honorPushErrorEnum12, honorPushErrorEnum13, honorPushErrorEnum14, honorPushErrorEnum15, honorPushErrorEnum16, honorPushErrorEnum17, honorPushErrorEnum18, honorPushErrorEnum19, honorPushErrorEnum20, honorPushErrorEnum21, honorPushErrorEnum22, honorPushErrorEnum23, honorPushErrorEnum24};
        ENUM_MAPPER = new SparseArray<>();
        HonorPushErrorEnum[] values = values();
        for (int i = 0; i < 24; i++) {
            HonorPushErrorEnum honorPushErrorEnum25 = values[i];
            ENUM_MAPPER.put(honorPushErrorEnum25.statusCode, honorPushErrorEnum25);
        }
    }

    public HonorPushErrorEnum(String str, int i, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.statusCode = i2;
        this.message = str2;
    }

    public static HonorPushErrorEnum fromCode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            return ENUM_MAPPER.get(i, ERROR_UNKNOWN);
        }
        return (HonorPushErrorEnum) invokeI.objValue;
    }

    public static HonorPushErrorEnum valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return (HonorPushErrorEnum) Enum.valueOf(HonorPushErrorEnum.class, str);
        }
        return (HonorPushErrorEnum) invokeL.objValue;
    }

    public static HonorPushErrorEnum[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return (HonorPushErrorEnum[]) a.clone();
        }
        return (HonorPushErrorEnum[]) invokeV.objValue;
    }

    public int getErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.statusCode;
        }
        return invokeV.intValue;
    }

    public String getMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.message;
        }
        return (String) invokeV.objValue;
    }

    public ApiException toApiException() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new ApiException(getErrorCode(), getMessage());
        }
        return (ApiException) invokeV.objValue;
    }
}
