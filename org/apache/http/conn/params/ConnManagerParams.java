package org.apache.http.conn.params;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.http.params.HttpParams;
@Deprecated
/* loaded from: classes3.dex */
public final class ConnManagerParams implements ConnManagerPNames {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_MAX_TOTAL_CONNECTIONS = 20;
    public transient /* synthetic */ FieldHolder $fh;

    public ConnManagerParams() {
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

    public static ConnPerRoute getMaxConnectionsPerRoute(HttpParams httpParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, httpParams)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (ConnPerRoute) invokeL.objValue;
    }

    public static int getMaxTotalConnections(HttpParams httpParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, httpParams)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeL.intValue;
    }

    public static long getTimeout(HttpParams httpParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, httpParams)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeL.longValue;
    }

    public static void setMaxConnectionsPerRoute(HttpParams httpParams, ConnPerRoute connPerRoute) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, httpParams, connPerRoute) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public static void setMaxTotalConnections(HttpParams httpParams, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, httpParams, i2) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public static void setTimeout(HttpParams httpParams, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(AdIconUtil.BAIDU_LOGO_ID, null, httpParams, j) == null) {
            throw new RuntimeException("Stub!");
        }
    }
}
