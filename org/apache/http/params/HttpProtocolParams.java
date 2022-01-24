package org.apache.http.params;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.http.ProtocolVersion;
@Deprecated
/* loaded from: classes5.dex */
public final class HttpProtocolParams implements CoreProtocolPNames {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public HttpProtocolParams() {
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

    public static String getContentCharset(HttpParams httpParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, httpParams)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (String) invokeL.objValue;
    }

    public static String getHttpElementCharset(HttpParams httpParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, httpParams)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (String) invokeL.objValue;
    }

    public static String getUserAgent(HttpParams httpParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, httpParams)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (String) invokeL.objValue;
    }

    public static ProtocolVersion getVersion(HttpParams httpParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, httpParams)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (ProtocolVersion) invokeL.objValue;
    }

    public static void setContentCharset(HttpParams httpParams, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, httpParams, str) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public static void setHttpElementCharset(HttpParams httpParams, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, httpParams, str) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public static void setUseExpectContinue(HttpParams httpParams, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65543, null, httpParams, z) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public static void setUserAgent(HttpParams httpParams, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, httpParams, str) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public static void setVersion(HttpParams httpParams, ProtocolVersion protocolVersion) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, httpParams, protocolVersion) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public static boolean useExpectContinue(HttpParams httpParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, httpParams)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeL.booleanValue;
    }
}
