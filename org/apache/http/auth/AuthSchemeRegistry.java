package org.apache.http.auth;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
import org.apache.http.params.HttpParams;
@Deprecated
/* loaded from: classes9.dex */
public final class AuthSchemeRegistry {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AuthSchemeRegistry() {
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

    public synchronized List<String> getSchemeNames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
        return (List) invokeV.objValue;
    }

    public synchronized AuthScheme getAuthScheme(String str, HttpParams httpParams) throws IllegalStateException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, httpParams)) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
        return (AuthScheme) invokeLL.objValue;
    }

    public synchronized void register(String str, AuthSchemeFactory authSchemeFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, authSchemeFactory) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
    }

    public synchronized void setItems(Map<String, AuthSchemeFactory> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, map) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
    }

    public synchronized void unregister(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
    }
}
