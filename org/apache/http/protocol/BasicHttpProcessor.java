package org.apache.http.protocol;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.List;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
@Deprecated
/* loaded from: classes10.dex */
public final class BasicHttpProcessor implements HttpProcessor, HttpRequestInterceptorList, HttpResponseInterceptorList {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List requestInterceptors;
    public List responseInterceptors;

    public BasicHttpProcessor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        throw new RuntimeException("Stub!");
    }

    public final void addInterceptor(HttpRequestInterceptor httpRequestInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, httpRequestInterceptor) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.http.protocol.HttpRequestInterceptorList
    public void addRequestInterceptor(HttpRequestInterceptor httpRequestInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, httpRequestInterceptor) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.http.protocol.HttpResponseInterceptorList
    public void addResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, httpResponseInterceptor, i2) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void clearInterceptors() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.http.protocol.HttpRequestInterceptorList
    public void clearRequestInterceptors() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.http.protocol.HttpResponseInterceptorList
    public void clearResponseInterceptors() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public Object clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.objValue;
    }

    public BasicHttpProcessor copy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (BasicHttpProcessor) invokeV.objValue;
    }

    public void copyInterceptors(BasicHttpProcessor basicHttpProcessor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, basicHttpProcessor) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.http.protocol.HttpRequestInterceptorList
    public HttpRequestInterceptor getRequestInterceptor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (HttpRequestInterceptor) invokeI.objValue;
    }

    @Override // org.apache.http.protocol.HttpRequestInterceptorList
    public int getRequestInterceptorCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.intValue;
    }

    @Override // org.apache.http.protocol.HttpResponseInterceptorList
    public HttpResponseInterceptor getResponseInterceptor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (HttpResponseInterceptor) invokeI.objValue;
    }

    @Override // org.apache.http.protocol.HttpResponseInterceptorList
    public int getResponseInterceptorCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.intValue;
    }

    @Override // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, HttpContext httpContext) throws IOException, HttpException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, httpRequest, httpContext) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.http.protocol.HttpRequestInterceptorList
    public void removeRequestInterceptorByClass(Class cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, cls) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.http.protocol.HttpResponseInterceptorList
    public void removeResponseInterceptorByClass(Class cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, cls) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.http.protocol.HttpRequestInterceptorList, org.apache.http.protocol.HttpResponseInterceptorList
    public void setInterceptors(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, list) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public final void addInterceptor(HttpRequestInterceptor httpRequestInterceptor, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpRequestInterceptor, i2) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.http.protocol.HttpRequestInterceptorList
    public void addRequestInterceptor(HttpRequestInterceptor httpRequestInterceptor, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, httpRequestInterceptor, i2) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.http.protocol.HttpResponseInterceptorList
    public void addResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, httpResponseInterceptor) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.http.HttpResponseInterceptor
    public void process(HttpResponse httpResponse, HttpContext httpContext) throws IOException, HttpException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, httpResponse, httpContext) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public final void addInterceptor(HttpResponseInterceptor httpResponseInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, httpResponseInterceptor) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public final void addInterceptor(HttpResponseInterceptor httpResponseInterceptor, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, httpResponseInterceptor, i2) == null) {
            throw new RuntimeException("Stub!");
        }
    }
}
