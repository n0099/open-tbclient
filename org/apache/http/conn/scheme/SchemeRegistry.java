package org.apache.http.conn.scheme;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;
@Deprecated
/* loaded from: classes9.dex */
public final class SchemeRegistry {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SchemeRegistry() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        throw new RuntimeException("Stub!");
    }

    public final synchronized List<String> getSchemeNames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
        return (List) invokeV.objValue;
    }

    public final synchronized Scheme get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
        return (Scheme) invokeL.objValue;
    }

    public final synchronized Scheme getScheme(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
        return (Scheme) invokeL.objValue;
    }

    public final synchronized Scheme register(Scheme scheme) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, scheme)) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
        return (Scheme) invokeL.objValue;
    }

    public synchronized void setItems(Map<String, Scheme> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, map) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
    }

    public final synchronized Scheme unregister(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
        return (Scheme) invokeL.objValue;
    }

    public final synchronized Scheme getScheme(HttpHost httpHost) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, httpHost)) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
        return (Scheme) invokeL.objValue;
    }
}
