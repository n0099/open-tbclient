package org.apache.http.params;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Deprecated
/* loaded from: classes10.dex */
public final class HttpConnectionParams implements CoreConnectionPNames {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public HttpConnectionParams() {
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

    public static int getConnectionTimeout(HttpParams httpParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, httpParams)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeL.intValue;
    }

    public static int getLinger(HttpParams httpParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, httpParams)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeL.intValue;
    }

    public static int getSoTimeout(HttpParams httpParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, httpParams)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeL.intValue;
    }

    public static int getSocketBufferSize(HttpParams httpParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, httpParams)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeL.intValue;
    }

    public static boolean getTcpNoDelay(HttpParams httpParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, httpParams)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeL.booleanValue;
    }

    public static boolean isStaleCheckingEnabled(HttpParams httpParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, httpParams)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeL.booleanValue;
    }

    public static void setConnectionTimeout(HttpParams httpParams, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65543, null, httpParams, i2) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public static void setLinger(HttpParams httpParams, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, null, httpParams, i2) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public static void setSoTimeout(HttpParams httpParams, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65545, null, httpParams, i2) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public static void setSocketBufferSize(HttpParams httpParams, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65546, null, httpParams, i2) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public static void setStaleCheckingEnabled(HttpParams httpParams, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65547, null, httpParams, z) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public static void setTcpNoDelay(HttpParams httpParams, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65548, null, httpParams, z) == null) {
            throw new RuntimeException("Stub!");
        }
    }
}
