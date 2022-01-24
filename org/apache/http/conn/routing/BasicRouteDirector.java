package org.apache.http.conn.routing;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Deprecated
/* loaded from: classes5.dex */
public class BasicRouteDirector implements HttpRouteDirector {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BasicRouteDirector() {
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

    public int directStep(RouteInfo routeInfo, RouteInfo routeInfo2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, routeInfo, routeInfo2)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeLL.intValue;
    }

    public int firstStep(RouteInfo routeInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, routeInfo)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeL.intValue;
    }

    @Override // org.apache.http.conn.routing.HttpRouteDirector
    public int nextStep(RouteInfo routeInfo, RouteInfo routeInfo2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, routeInfo, routeInfo2)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeLL.intValue;
    }

    public int proxiedStep(RouteInfo routeInfo, RouteInfo routeInfo2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, routeInfo, routeInfo2)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeLL.intValue;
    }
}
