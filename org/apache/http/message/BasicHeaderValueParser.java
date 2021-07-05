package org.apache.http.message;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.util.CharArrayBuffer;
@Deprecated
/* loaded from: classes10.dex */
public class BasicHeaderValueParser implements HeaderValueParser {
    public static /* synthetic */ Interceptable $ic;
    public static final BasicHeaderValueParser DEFAULT = null;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(458670401, "Lorg/apache/http/message/BasicHeaderValueParser;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(458670401, "Lorg/apache/http/message/BasicHeaderValueParser;");
        }
    }

    public BasicHeaderValueParser() {
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

    public static final HeaderElement[] parseElements(String str, HeaderValueParser headerValueParser) throws ParseException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, headerValueParser)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (HeaderElement[]) invokeLL.objValue;
    }

    public static final HeaderElement parseHeaderElement(String str, HeaderValueParser headerValueParser) throws ParseException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, headerValueParser)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (HeaderElement) invokeLL.objValue;
    }

    public static final NameValuePair parseNameValuePair(String str, HeaderValueParser headerValueParser) throws ParseException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, str, headerValueParser)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (NameValuePair) invokeLL.objValue;
    }

    public static final NameValuePair[] parseParameters(String str, HeaderValueParser headerValueParser) throws ParseException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, headerValueParser)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (NameValuePair[]) invokeLL.objValue;
    }

    public HeaderElement createHeaderElement(String str, String str2, NameValuePair[] nameValuePairArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, nameValuePairArr)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (HeaderElement) invokeLLL.objValue;
    }

    public NameValuePair createNameValuePair(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (NameValuePair) invokeLL.objValue;
    }

    @Override // org.apache.http.message.HeaderValueParser
    public HeaderElement[] parseElements(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, charArrayBuffer, parserCursor)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (HeaderElement[]) invokeLL.objValue;
    }

    @Override // org.apache.http.message.HeaderValueParser
    public HeaderElement parseHeaderElement(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, charArrayBuffer, parserCursor)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (HeaderElement) invokeLL.objValue;
    }

    @Override // org.apache.http.message.HeaderValueParser
    public NameValuePair parseNameValuePair(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, charArrayBuffer, parserCursor)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (NameValuePair) invokeLL.objValue;
    }

    @Override // org.apache.http.message.HeaderValueParser
    public NameValuePair[] parseParameters(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, charArrayBuffer, parserCursor)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (NameValuePair[]) invokeLL.objValue;
    }

    public NameValuePair parseNameValuePair(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, char[] cArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, charArrayBuffer, parserCursor, cArr)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (NameValuePair) invokeLLL.objValue;
    }
}
