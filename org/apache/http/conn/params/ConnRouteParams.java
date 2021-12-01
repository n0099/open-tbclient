package org.apache.http.conn.params;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.InetAddress;
import org.apache.http.HttpHost;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.params.HttpParams;
@Deprecated
/* loaded from: classes3.dex */
public class ConnRouteParams implements ConnRoutePNames {
    public static /* synthetic */ Interceptable $ic;
    public static final HttpHost NO_HOST = null;
    public static final HttpRoute NO_ROUTE = null;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-646169957, "Lorg/apache/http/conn/params/ConnRouteParams;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-646169957, "Lorg/apache/http/conn/params/ConnRouteParams;");
        }
    }

    public ConnRouteParams() {
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

    public static HttpHost getDefaultProxy(HttpParams httpParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, httpParams)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (HttpHost) invokeL.objValue;
    }

    public static HttpRoute getForcedRoute(HttpParams httpParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, httpParams)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (HttpRoute) invokeL.objValue;
    }

    public static InetAddress getLocalAddress(HttpParams httpParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, httpParams)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (InetAddress) invokeL.objValue;
    }

    public static void setDefaultProxy(HttpParams httpParams, HttpHost httpHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, httpParams, httpHost) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public static void setForcedRoute(HttpParams httpParams, HttpRoute httpRoute) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, httpParams, httpRoute) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public static void setLocalAddress(HttpParams httpParams, InetAddress inetAddress) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, httpParams, inetAddress) == null) {
            throw new RuntimeException("Stub!");
        }
    }
}
