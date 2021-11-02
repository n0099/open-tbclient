package org.apache.http.impl.conn;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.Socket;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.impl.SocketHttpClientConnection;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.HttpParams;
@Deprecated
/* loaded from: classes3.dex */
public class DefaultClientConnection extends SocketHttpClientConnection implements OperatedClientConnection {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DefaultClientConnection() {
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

    @Override // org.apache.http.impl.SocketHttpClientConnection, org.apache.http.HttpConnection
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.http.impl.AbstractHttpClientConnection
    public HttpMessageParser createResponseParser(SessionInputBuffer sessionInputBuffer, HttpResponseFactory httpResponseFactory, HttpParams httpParams) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sessionInputBuffer, httpResponseFactory, httpParams)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (HttpMessageParser) invokeLLL.objValue;
    }

    @Override // org.apache.http.impl.SocketHttpClientConnection
    public SessionInputBuffer createSessionInputBuffer(Socket socket, int i2, HttpParams httpParams) throws IOException {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, socket, i2, httpParams)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (SessionInputBuffer) invokeLIL.objValue;
    }

    @Override // org.apache.http.impl.SocketHttpClientConnection
    public SessionOutputBuffer createSessionOutputBuffer(Socket socket, int i2, HttpParams httpParams) throws IOException {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048579, this, socket, i2, httpParams)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (SessionOutputBuffer) invokeLIL.objValue;
    }

    @Override // org.apache.http.impl.SocketHttpClientConnection, org.apache.http.conn.OperatedClientConnection
    public final Socket getSocket() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (Socket) invokeV.objValue;
    }

    @Override // org.apache.http.conn.OperatedClientConnection
    public final HttpHost getTargetHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (HttpHost) invokeV.objValue;
    }

    @Override // org.apache.http.conn.OperatedClientConnection
    public final boolean isSecure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    @Override // org.apache.http.conn.OperatedClientConnection
    public void openCompleted(boolean z, HttpParams httpParams) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048583, this, z, httpParams) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.http.conn.OperatedClientConnection
    public void opening(Socket socket, HttpHost httpHost) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, socket, httpHost) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.http.impl.AbstractHttpClientConnection, org.apache.http.HttpClientConnection
    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (HttpResponse) invokeV.objValue;
    }

    @Override // org.apache.http.impl.AbstractHttpClientConnection, org.apache.http.HttpClientConnection
    public void sendRequestHeader(HttpRequest httpRequest) throws HttpException, IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, httpRequest) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.http.impl.SocketHttpClientConnection, org.apache.http.HttpConnection
    public void shutdown() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.http.conn.OperatedClientConnection
    public void update(Socket socket, HttpHost httpHost, boolean z, HttpParams httpParams) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{socket, httpHost, Boolean.valueOf(z), httpParams}) == null) {
            throw new RuntimeException("Stub!");
        }
    }
}
