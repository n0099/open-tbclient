package com.yy.mobile.framework.revenuesdk.baseapi;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000:\u0001\u0003B\u0007¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/baseapi/ServiceFailResult;", "<init>", "()V", "Code", "paybaseapi_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class ServiceFailResult {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b$\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b#\u0010$R\u001c\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\u0005R\u001c\u0010\b\u001a\u00020\u00018\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\u0005R\u001c\u0010\n\u001a\u00020\u00018\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\u0005R\u001c\u0010\f\u001a\u00020\u00018\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u0005R\u001c\u0010\u000e\u001a\u00020\u00018\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\u0005R\u001c\u0010\u0010\u001a\u00020\u00018\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u0005R\u0016\u0010\u0012\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0003R\u0016\u0010\u0013\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0003R\u0016\u0010\u0014\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0003R\u0016\u0010\u0015\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0003R\u0016\u0010\u0016\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0003R\u0016\u0010\u0017\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0003R\u0016\u0010\u0018\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0003R\u0016\u0010\u0019\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0003R\u0016\u0010\u001a\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0003R\u0016\u0010\u001b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0003R\u0016\u0010\u001c\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0003R\u0016\u0010\u001d\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0003R\u0016\u0010\u001e\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0003R\u0016\u0010\u001f\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0003R\u0016\u0010 \u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u0003R\u0016\u0010!\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b!\u0010\u0003R\u0016\u0010\"\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010\u0003¨\u0006%"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/baseapi/ServiceFailResult$Code;", "", "ARCH_PARSE_ERROR", "I", "getARCH_PARSE_ERROR", "()I", "BIND_LOAD_FULL", "getBIND_LOAD_FULL", "BIND_NOTREADY_TORETRY", "getBIND_NOTREADY_TORETRY", "BIND_OTP_FAIL", "getBIND_OTP_FAIL", "BIND_OTP_TIMEOUT", "getBIND_OTP_TIMEOUT", "BIND_RESOURCE_CONFLICT", "getBIND_RESOURCE_CONFLICT", "BIND_SUCCESS", "getBIND_SUCCESS", "SDK_NEED_BIND", "SDK_NO_CONNECTED", "SDK_TIMEOUT", "SDK_TIMEOUT_CONNECT_FAIL", "SDK_UNKNOW", "SUCCESS", "SVR_BADGATEWAY", "SVR_BADREQUEST", "SVR_FAIL", "SVR_GATEWAYTIMEOUT", "SVR_INTERNALSERVERERROR", "SVR_NOTFOUND", "SVR_PAYMENTREQUIRED", "SVR_SERVICEUNAVAILABLE", "SVR_SUCCESS", "SVR_TIMEOUT", "SVR_UNAUTHORIZED", "<init>", "()V", "paybaseapi_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes8.dex */
    public static final class Code {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ARCH_PARSE_ERROR;
        public static final int BIND_LOAD_FULL;
        public static final int BIND_NOTREADY_TORETRY;
        public static final int BIND_OTP_FAIL;
        public static final int BIND_OTP_TIMEOUT;
        public static final int BIND_RESOURCE_CONFLICT;
        public static final int BIND_SUCCESS;
        public static final Code INSTANCE;
        public static final int SDK_NEED_BIND = 110002;
        public static final int SDK_NO_CONNECTED = 110001;
        public static final int SDK_TIMEOUT = 110003;
        public static final int SDK_TIMEOUT_CONNECT_FAIL = 110004;
        public static final int SDK_UNKNOW = 110255;
        public static final int SUCCESS = 0;
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
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1880971980, "Lcom/yy/mobile/framework/revenuesdk/baseapi/ServiceFailResult$Code;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1880971980, "Lcom/yy/mobile/framework/revenuesdk/baseapi/ServiceFailResult$Code;");
                    return;
                }
            }
            INSTANCE = new Code();
            BIND_SUCCESS = 200200;
            BIND_NOTREADY_TORETRY = BIND_NOTREADY_TORETRY;
            BIND_OTP_FAIL = 200403;
            BIND_OTP_TIMEOUT = 200408;
            BIND_LOAD_FULL = BIND_LOAD_FULL;
            BIND_RESOURCE_CONFLICT = BIND_RESOURCE_CONFLICT;
            ARCH_PARSE_ERROR = ARCH_PARSE_ERROR;
        }

        public Code() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public final int getARCH_PARSE_ERROR() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return ARCH_PARSE_ERROR;
            }
            return invokeV.intValue;
        }

        public final int getBIND_LOAD_FULL() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return BIND_LOAD_FULL;
            }
            return invokeV.intValue;
        }

        public final int getBIND_NOTREADY_TORETRY() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return BIND_NOTREADY_TORETRY;
            }
            return invokeV.intValue;
        }

        public final int getBIND_OTP_FAIL() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return BIND_OTP_FAIL;
            }
            return invokeV.intValue;
        }

        public final int getBIND_OTP_TIMEOUT() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return BIND_OTP_TIMEOUT;
            }
            return invokeV.intValue;
        }

        public final int getBIND_RESOURCE_CONFLICT() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return BIND_RESOURCE_CONFLICT;
            }
            return invokeV.intValue;
        }

        public final int getBIND_SUCCESS() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return BIND_SUCCESS;
            }
            return invokeV.intValue;
        }
    }

    public ServiceFailResult() {
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
