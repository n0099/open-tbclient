package com.huawei.secure.android.common.webview;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public interface WebViewLoadCallBack {
    void a(String str, ErrorCode errorCode);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class ErrorCode {
        public static final /* synthetic */ ErrorCode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ErrorCode HTTP_URL;
        public static final ErrorCode OTHER;
        public static final ErrorCode URL_NOT_IN_WHITE_LIST;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1408602774, "Lcom/huawei/secure/android/common/webview/WebViewLoadCallBack$ErrorCode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1408602774, "Lcom/huawei/secure/android/common/webview/WebViewLoadCallBack$ErrorCode;");
                    return;
                }
            }
            HTTP_URL = new ErrorCode("HTTP_URL", 0);
            URL_NOT_IN_WHITE_LIST = new ErrorCode("URL_NOT_IN_WHITE_LIST", 1);
            ErrorCode errorCode = new ErrorCode("OTHER", 2);
            OTHER = errorCode;
            $VALUES = new ErrorCode[]{HTTP_URL, URL_NOT_IN_WHITE_LIST, errorCode};
        }

        public ErrorCode(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ErrorCode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (ErrorCode) Enum.valueOf(ErrorCode.class, str);
            }
            return (ErrorCode) invokeL.objValue;
        }

        public static ErrorCode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (ErrorCode[]) $VALUES.clone();
            }
            return (ErrorCode[]) invokeV.objValue;
        }
    }
}
