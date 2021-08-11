package org.apache.http.message;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpMessage;
import org.apache.http.params.HttpParams;
@Deprecated
/* loaded from: classes2.dex */
public abstract class AbstractHttpMessage implements HttpMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeaderGroup headergroup;
    public HttpParams params;

    public AbstractHttpMessage(HttpParams httpParams) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpParams};
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

    @Override // org.apache.http.HttpMessage
    public void addHeader(Header header) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, header) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.http.HttpMessage
    public boolean containsHeader(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeL.booleanValue;
    }

    @Override // org.apache.http.HttpMessage
    public Header[] getAllHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (Header[]) invokeV.objValue;
    }

    @Override // org.apache.http.HttpMessage
    public Header getFirstHeader(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (Header) invokeL.objValue;
    }

    @Override // org.apache.http.HttpMessage
    public Header[] getHeaders(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (Header[]) invokeL.objValue;
    }

    @Override // org.apache.http.HttpMessage
    public Header getLastHeader(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (Header) invokeL.objValue;
    }

    @Override // org.apache.http.HttpMessage
    public HttpParams getParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (HttpParams) invokeV.objValue;
    }

    @Override // org.apache.http.HttpMessage
    public HeaderIterator headerIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (HeaderIterator) invokeV.objValue;
    }

    @Override // org.apache.http.HttpMessage
    public void removeHeader(Header header) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, header) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.http.HttpMessage
    public void removeHeaders(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.http.HttpMessage
    public void setHeader(Header header) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, header) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.http.HttpMessage
    public void setHeaders(Header[] headerArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, headerArr) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.http.HttpMessage
    public void setParams(HttpParams httpParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, httpParams) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public AbstractHttpMessage() {
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

    @Override // org.apache.http.HttpMessage
    public void addHeader(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.http.HttpMessage
    public HeaderIterator headerIterator(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (HeaderIterator) invokeL.objValue;
    }

    @Override // org.apache.http.HttpMessage
    public void setHeader(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) {
            throw new RuntimeException("Stub!");
        }
    }
}
