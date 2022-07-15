package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.http.Headers;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.HashMap;
import java.util.Map;
import kotlinx.coroutines.DebugKt;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes7.dex */
public class zr2 implements Interceptor {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755102473, "Lcom/repackage/zr2;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755102473, "Lcom/repackage/zr2;");
        }
    }

    public zr2() {
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

    public static Map<String, String> a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            HashMap hashMap = new HashMap();
            if (a) {
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                hashMap.put("___check_redirect___", DebugKt.DEBUG_PROPERTY_VALUE_ON);
                hashMap.put("___request_type___", str);
                hashMap.put("___plugin_id___", str2);
                return hashMap;
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public static HttpRequest e(HttpRequest httpRequest, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, httpRequest, str, str2)) == null) {
            if (a && httpRequest != null) {
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                return httpRequest.newBuilder().addHeader("___check_redirect___", DebugKt.DEBUG_PROPERTY_VALUE_ON).addHeader("___request_type___", str).addHeader("___plugin_id___", str2).build();
            }
            return httpRequest;
        }
        return (HttpRequest) invokeLLL.objValue;
    }

    public static Request f(Request request, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, request, str, str2)) == null) {
            if (a && request != null) {
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                return request.newBuilder().addHeader("___check_redirect___", DebugKt.DEBUG_PROPERTY_VALUE_ON).addHeader("___request_type___", str).addHeader("___plugin_id___", str2).build();
            }
            return request;
        }
        return (Request) invokeLLL.objValue;
    }

    public final boolean b(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, response)) == null) {
            if (response == null) {
                return false;
            }
            int code = response.code();
            if (TextUtils.isEmpty(response.header(Headers.LOCATION))) {
                return false;
            }
            return (307 <= code && code <= 308) || (300 <= code && code <= 303);
        }
        return invokeL.booleanValue;
    }

    public final boolean c(Request request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request)) == null) {
            if (request == null) {
                return false;
            }
            return TextUtils.equals(request.headers().get("___check_redirect___"), DebugKt.DEBUG_PROPERTY_VALUE_ON);
        }
        return invokeL.booleanValue;
    }

    public final Request d(Request request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, request)) == null) ? request == null ? request : request.newBuilder().removeHeader("___check_redirect___").removeHeader("___request_type___").removeHeader("___plugin_id___").build() : (Request) invokeL.objValue;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        InterceptResult invokeL;
        HttpUrl resolve;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, chain)) == null) {
            Request request = chain.request();
            if (!a) {
                return chain.proceed(request);
            }
            if (!c(request)) {
                return chain.proceed(request);
            }
            okhttp3.Headers headers = request.headers();
            String str = headers.get("___request_type___");
            String str2 = headers.get("___plugin_id___");
            Response proceed = chain.proceed(d(request));
            if (b(proceed)) {
                String header = proceed.header(Headers.LOCATION);
                if (TextUtils.isEmpty(header) || (resolve = proceed.request().url().resolve(header)) == null || y03.c(str, resolve.toString(), str2) == 0) {
                    return proceed;
                }
                String str3 = "redirect error:" + resolve.toString() + " scheme illegal or not in domain list";
                hx1.o("SafeRedirectCheck", str3);
                throw new InterruptedIOException(str3);
            }
            return proceed;
        }
        return (Response) invokeL.objValue;
    }
}
