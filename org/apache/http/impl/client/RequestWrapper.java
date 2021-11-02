package org.apache.http.impl.client;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URI;
import org.apache.http.HttpRequest;
import org.apache.http.ProtocolException;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.AbstractHttpMessage;
@Deprecated
/* loaded from: classes3.dex */
public class RequestWrapper extends AbstractHttpMessage implements HttpUriRequest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public RequestWrapper(HttpRequest httpRequest) throws ProtocolException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpRequest};
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

    @Override // org.apache.http.client.methods.HttpUriRequest, org.apache.http.client.methods.AbortableHttpRequest
    public void abort() throws UnsupportedOperationException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public int getExecCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.intValue;
    }

    @Override // org.apache.http.client.methods.HttpUriRequest
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (String) invokeV.objValue;
    }

    public HttpRequest getOriginal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (HttpRequest) invokeV.objValue;
    }

    @Override // org.apache.http.HttpMessage
    public ProtocolVersion getProtocolVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (ProtocolVersion) invokeV.objValue;
    }

    @Override // org.apache.http.HttpRequest
    public RequestLine getRequestLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (RequestLine) invokeV.objValue;
    }

    @Override // org.apache.http.client.methods.HttpUriRequest
    public URI getURI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (URI) invokeV.objValue;
    }

    public void incrementExecCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.http.client.methods.HttpUriRequest
    public boolean isAborted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    public boolean isRepeatable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    public void resetHeaders() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void setMethod(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void setProtocolVersion(ProtocolVersion protocolVersion) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, protocolVersion) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void setURI(URI uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, uri) == null) {
            throw new RuntimeException("Stub!");
        }
    }
}
