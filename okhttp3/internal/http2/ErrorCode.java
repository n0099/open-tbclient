package okhttp3.internal.http2;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class ErrorCode {
    public static final /* synthetic */ ErrorCode[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ErrorCode CANCEL;
    public static final ErrorCode COMPRESSION_ERROR;
    public static final ErrorCode CONNECT_ERROR;
    public static final ErrorCode ENHANCE_YOUR_CALM;
    public static final ErrorCode FLOW_CONTROL_ERROR;
    public static final ErrorCode HTTP_1_1_REQUIRED;
    public static final ErrorCode INADEQUATE_SECURITY;
    public static final ErrorCode INTERNAL_ERROR;
    public static final ErrorCode NO_ERROR;
    public static final ErrorCode PROTOCOL_ERROR;
    public static final ErrorCode REFUSED_STREAM;
    public transient /* synthetic */ FieldHolder $fh;
    public final int httpCode;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-28745231, "Lokhttp3/internal/http2/ErrorCode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-28745231, "Lokhttp3/internal/http2/ErrorCode;");
                return;
            }
        }
        NO_ERROR = new ErrorCode("NO_ERROR", 0, 0);
        PROTOCOL_ERROR = new ErrorCode("PROTOCOL_ERROR", 1, 1);
        INTERNAL_ERROR = new ErrorCode("INTERNAL_ERROR", 2, 2);
        FLOW_CONTROL_ERROR = new ErrorCode("FLOW_CONTROL_ERROR", 3, 3);
        REFUSED_STREAM = new ErrorCode("REFUSED_STREAM", 4, 7);
        CANCEL = new ErrorCode("CANCEL", 5, 8);
        COMPRESSION_ERROR = new ErrorCode("COMPRESSION_ERROR", 6, 9);
        CONNECT_ERROR = new ErrorCode("CONNECT_ERROR", 7, 10);
        ENHANCE_YOUR_CALM = new ErrorCode("ENHANCE_YOUR_CALM", 8, 11);
        INADEQUATE_SECURITY = new ErrorCode("INADEQUATE_SECURITY", 9, 12);
        ErrorCode errorCode = new ErrorCode("HTTP_1_1_REQUIRED", 10, 13);
        HTTP_1_1_REQUIRED = errorCode;
        $VALUES = new ErrorCode[]{NO_ERROR, PROTOCOL_ERROR, INTERNAL_ERROR, FLOW_CONTROL_ERROR, REFUSED_STREAM, CANCEL, COMPRESSION_ERROR, CONNECT_ERROR, ENHANCE_YOUR_CALM, INADEQUATE_SECURITY, errorCode};
    }

    public ErrorCode(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.httpCode = i3;
    }

    public static ErrorCode fromHttp2(int i2) {
        InterceptResult invokeI;
        ErrorCode[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            for (ErrorCode errorCode : values()) {
                if (errorCode.httpCode == i2) {
                    return errorCode;
                }
            }
            return null;
        }
        return (ErrorCode) invokeI.objValue;
    }

    public static ErrorCode valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (ErrorCode) Enum.valueOf(ErrorCode.class, str) : (ErrorCode) invokeL.objValue;
    }

    public static ErrorCode[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (ErrorCode[]) $VALUES.clone() : (ErrorCode[]) invokeV.objValue;
    }
}
