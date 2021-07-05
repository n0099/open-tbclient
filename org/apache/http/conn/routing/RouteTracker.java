package org.apache.http.conn.routing;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.InetAddress;
import org.apache.http.HttpHost;
import org.apache.http.conn.routing.RouteInfo;
@Deprecated
/* loaded from: classes10.dex */
public final class RouteTracker implements RouteInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public RouteTracker(HttpHost httpHost, InetAddress inetAddress) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpHost, inetAddress};
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

    public Object clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.objValue;
    }

    public final void connectProxy(HttpHost httpHost, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpHost, z) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public final void connectTarget(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public final boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeL.booleanValue;
    }

    @Override // org.apache.http.conn.routing.RouteInfo
    public final int getHopCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.intValue;
    }

    @Override // org.apache.http.conn.routing.RouteInfo
    public final HttpHost getHopTarget(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (HttpHost) invokeI.objValue;
    }

    @Override // org.apache.http.conn.routing.RouteInfo
    public final RouteInfo.LayerType getLayerType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (RouteInfo.LayerType) invokeV.objValue;
    }

    @Override // org.apache.http.conn.routing.RouteInfo
    public final InetAddress getLocalAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (InetAddress) invokeV.objValue;
    }

    @Override // org.apache.http.conn.routing.RouteInfo
    public final HttpHost getProxyHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (HttpHost) invokeV.objValue;
    }

    @Override // org.apache.http.conn.routing.RouteInfo
    public final HttpHost getTargetHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (HttpHost) invokeV.objValue;
    }

    @Override // org.apache.http.conn.routing.RouteInfo
    public final RouteInfo.TunnelType getTunnelType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (RouteInfo.TunnelType) invokeV.objValue;
    }

    public final int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.intValue;
    }

    public final boolean isConnected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    @Override // org.apache.http.conn.routing.RouteInfo
    public final boolean isLayered() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    @Override // org.apache.http.conn.routing.RouteInfo
    public final boolean isSecure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    @Override // org.apache.http.conn.routing.RouteInfo
    public final boolean isTunnelled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    public final void layerProtocol(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public final HttpRoute toRoute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (HttpRoute) invokeV.objValue;
    }

    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (String) invokeV.objValue;
    }

    public final void tunnelProxy(HttpHost httpHost, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048595, this, httpHost, z) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public final void tunnelTarget(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public RouteTracker(HttpRoute httpRoute) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpRoute};
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
}
