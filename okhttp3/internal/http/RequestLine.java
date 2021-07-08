package okhttp3.internal.http;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.Proxy;
import okhttp3.HttpUrl;
import okhttp3.Request;
/* loaded from: classes9.dex */
public final class RequestLine {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public RequestLine() {
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

    public static String get(Request request, Proxy.Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, request, type)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(request.method());
            sb.append(' ');
            if (includeAuthorityInRequestLine(request, type)) {
                sb.append(request.url());
            } else {
                sb.append(requestPath(request.url()));
            }
            sb.append(" HTTP/1.1");
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static boolean includeAuthorityInRequestLine(Request request, Proxy.Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, request, type)) == null) ? !request.isHttps() && type == Proxy.Type.HTTP : invokeLL.booleanValue;
    }

    public static String requestPath(HttpUrl httpUrl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, httpUrl)) == null) {
            String encodedPath = httpUrl.encodedPath();
            String encodedQuery = httpUrl.encodedQuery();
            if (encodedQuery != null) {
                return encodedPath + '?' + encodedQuery;
            }
            return encodedPath;
        }
        return (String) invokeL.objValue;
    }
}
