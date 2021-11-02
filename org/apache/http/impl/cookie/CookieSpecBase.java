package org.apache.http.impl.cookie;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.apache.http.HeaderElement;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
@Deprecated
/* loaded from: classes3.dex */
public abstract class CookieSpecBase extends AbstractCookieSpec {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CookieSpecBase() {
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

    public static String getDefaultDomain(CookieOrigin cookieOrigin) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cookieOrigin)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (String) invokeL.objValue;
    }

    public static String getDefaultPath(CookieOrigin cookieOrigin) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cookieOrigin)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (String) invokeL.objValue;
    }

    @Override // org.apache.http.cookie.CookieSpec
    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cookie, cookieOrigin)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeLL.booleanValue;
    }

    public List<Cookie> parse(HeaderElement[] headerElementArr, CookieOrigin cookieOrigin) throws MalformedCookieException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, headerElementArr, cookieOrigin)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (List) invokeLL.objValue;
    }

    @Override // org.apache.http.cookie.CookieSpec
    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cookie, cookieOrigin) == null) {
            throw new RuntimeException("Stub!");
        }
    }
}
