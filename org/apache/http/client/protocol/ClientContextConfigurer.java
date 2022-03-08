package org.apache.http.client.protocol;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.apache.http.auth.AuthSchemeRegistry;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.cookie.CookieSpecRegistry;
import org.apache.http.protocol.HttpContext;
@Deprecated
/* loaded from: classes9.dex */
public class ClientContextConfigurer implements ClientContext {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ClientContextConfigurer(HttpContext httpContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpContext};
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

    public void setAuthSchemePref(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void setAuthSchemeRegistry(AuthSchemeRegistry authSchemeRegistry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, authSchemeRegistry) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void setCookieSpecRegistry(CookieSpecRegistry cookieSpecRegistry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cookieSpecRegistry) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void setCookieStore(CookieStore cookieStore) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cookieStore) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void setCredentialsProvider(CredentialsProvider credentialsProvider) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, credentialsProvider) == null) {
            throw new RuntimeException("Stub!");
        }
    }
}
