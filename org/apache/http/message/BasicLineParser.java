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
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.util.CharArrayBuffer;
@Deprecated
/* loaded from: classes3.dex */
public class BasicLineParser implements LineParser {
    public static /* synthetic */ Interceptable $ic;
    public static final BasicLineParser DEFAULT = null;
    public transient /* synthetic */ FieldHolder $fh;
    public final ProtocolVersion protocol;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1645511489, "Lorg/apache/http/message/BasicLineParser;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1645511489, "Lorg/apache/http/message/BasicLineParser;");
        }
    }

    public BasicLineParser(ProtocolVersion protocolVersion) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {protocolVersion};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        throw new RuntimeException("Stub!");
    }

    public static final Header parseHeader(String str, LineParser lineParser) throws ParseException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, lineParser)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (Header) invokeLL.objValue;
    }

    public static final ProtocolVersion parseProtocolVersion(String str, LineParser lineParser) throws ParseException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, lineParser)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (ProtocolVersion) invokeLL.objValue;
    }

    public static final RequestLine parseRequestLine(String str, LineParser lineParser) throws ParseException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, lineParser)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (RequestLine) invokeLL.objValue;
    }

    public static final StatusLine parseStatusLine(String str, LineParser lineParser) throws ParseException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, lineParser)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (StatusLine) invokeLL.objValue;
    }

    public ProtocolVersion createProtocolVersion(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (ProtocolVersion) invokeII.objValue;
    }

    public RequestLine createRequestLine(String str, String str2, ProtocolVersion protocolVersion) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, protocolVersion)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (RequestLine) invokeLLL.objValue;
    }

    public StatusLine createStatusLine(ProtocolVersion protocolVersion, int i2, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, protocolVersion, i2, str)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (StatusLine) invokeLIL.objValue;
    }

    @Override // org.apache.http.message.LineParser
    public boolean hasProtocolVersion(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, charArrayBuffer, parserCursor)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeLL.booleanValue;
    }

    public void skipWhitespace(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, charArrayBuffer, parserCursor) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public BasicLineParser() {
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

    @Override // org.apache.http.message.LineParser
    public Header parseHeader(CharArrayBuffer charArrayBuffer) throws ParseException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, charArrayBuffer)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (Header) invokeL.objValue;
    }

    @Override // org.apache.http.message.LineParser
    public ProtocolVersion parseProtocolVersion(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, charArrayBuffer, parserCursor)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (ProtocolVersion) invokeLL.objValue;
    }

    @Override // org.apache.http.message.LineParser
    public RequestLine parseRequestLine(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, charArrayBuffer, parserCursor)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (RequestLine) invokeLL.objValue;
    }

    @Override // org.apache.http.message.LineParser
    public StatusLine parseStatusLine(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, charArrayBuffer, parserCursor)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (StatusLine) invokeLL.objValue;
    }
}
