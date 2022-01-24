package org.apache.http.message;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.http.Header;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.util.CharArrayBuffer;
@Deprecated
/* loaded from: classes5.dex */
public class BasicLineFormatter implements LineFormatter {
    public static /* synthetic */ Interceptable $ic;
    public static final BasicLineFormatter DEFAULT = null;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1681368818, "Lorg/apache/http/message/BasicLineFormatter;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1681368818, "Lorg/apache/http/message/BasicLineFormatter;");
        }
    }

    public BasicLineFormatter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        throw new RuntimeException("Stub!");
    }

    public static final String formatHeader(Header header, LineFormatter lineFormatter) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, header, lineFormatter)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (String) invokeLL.objValue;
    }

    public static final String formatProtocolVersion(ProtocolVersion protocolVersion, LineFormatter lineFormatter) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, protocolVersion, lineFormatter)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (String) invokeLL.objValue;
    }

    public static final String formatRequestLine(RequestLine requestLine, LineFormatter lineFormatter) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, requestLine, lineFormatter)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (String) invokeLL.objValue;
    }

    public static final String formatStatusLine(StatusLine statusLine, LineFormatter lineFormatter) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, statusLine, lineFormatter)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (String) invokeLL.objValue;
    }

    @Override // org.apache.http.message.LineFormatter
    public CharArrayBuffer appendProtocolVersion(CharArrayBuffer charArrayBuffer, ProtocolVersion protocolVersion) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, charArrayBuffer, protocolVersion)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (CharArrayBuffer) invokeLL.objValue;
    }

    public void doFormatHeader(CharArrayBuffer charArrayBuffer, Header header) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charArrayBuffer, header) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void doFormatRequestLine(CharArrayBuffer charArrayBuffer, RequestLine requestLine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, charArrayBuffer, requestLine) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void doFormatStatusLine(CharArrayBuffer charArrayBuffer, StatusLine statusLine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, charArrayBuffer, statusLine) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public int estimateProtocolVersionLen(ProtocolVersion protocolVersion) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, protocolVersion)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeL.intValue;
    }

    public CharArrayBuffer initBuffer(CharArrayBuffer charArrayBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, charArrayBuffer)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (CharArrayBuffer) invokeL.objValue;
    }

    @Override // org.apache.http.message.LineFormatter
    public CharArrayBuffer formatHeader(CharArrayBuffer charArrayBuffer, Header header) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, charArrayBuffer, header)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (CharArrayBuffer) invokeLL.objValue;
    }

    @Override // org.apache.http.message.LineFormatter
    public CharArrayBuffer formatRequestLine(CharArrayBuffer charArrayBuffer, RequestLine requestLine) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, charArrayBuffer, requestLine)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (CharArrayBuffer) invokeLL.objValue;
    }

    @Override // org.apache.http.message.LineFormatter
    public CharArrayBuffer formatStatusLine(CharArrayBuffer charArrayBuffer, StatusLine statusLine) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, charArrayBuffer, statusLine)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (CharArrayBuffer) invokeLL.objValue;
    }
}
