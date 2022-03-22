package org.apache.http.impl.client;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.auth.AuthSchemeRegistry;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.RequestDirector;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.cookie.CookieSpecRegistry;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;
@Deprecated
/* loaded from: classes8.dex */
public abstract class AbstractHttpClient implements HttpClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AbstractHttpClient(ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {clientConnectionManager, httpParams};
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

    public synchronized void addRequestInterceptor(HttpRequestInterceptor httpRequestInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, httpRequestInterceptor) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
    }

    public synchronized void addResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, httpResponseInterceptor) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
    }

    public synchronized void clearRequestInterceptors() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
    }

    public synchronized void clearResponseInterceptors() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
    }

    public abstract AuthSchemeRegistry createAuthSchemeRegistry();

    public abstract ClientConnectionManager createClientConnectionManager();

    public RequestDirector createClientRequestDirector(HttpRequestExecutor httpRequestExecutor, ClientConnectionManager clientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, HttpRoutePlanner httpRoutePlanner, HttpProcessor httpProcessor, HttpRequestRetryHandler httpRequestRetryHandler, RedirectHandler redirectHandler, AuthenticationHandler authenticationHandler, AuthenticationHandler authenticationHandler2, UserTokenHandler userTokenHandler, HttpParams httpParams) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{httpRequestExecutor, clientConnectionManager, connectionReuseStrategy, connectionKeepAliveStrategy, httpRoutePlanner, httpProcessor, httpRequestRetryHandler, redirectHandler, authenticationHandler, authenticationHandler2, userTokenHandler, httpParams})) == null) {
            throw new RuntimeException("Stub!");
        }
        return (RequestDirector) invokeCommon.objValue;
    }

    public abstract ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy();

    public abstract ConnectionReuseStrategy createConnectionReuseStrategy();

    public abstract CookieSpecRegistry createCookieSpecRegistry();

    public abstract CookieStore createCookieStore();

    public abstract CredentialsProvider createCredentialsProvider();

    public abstract HttpContext createHttpContext();

    public abstract HttpParams createHttpParams();

    public abstract BasicHttpProcessor createHttpProcessor();

    public abstract HttpRequestRetryHandler createHttpRequestRetryHandler();

    public abstract HttpRoutePlanner createHttpRoutePlanner();

    public abstract AuthenticationHandler createProxyAuthenticationHandler();

    public abstract RedirectHandler createRedirectHandler();

    public abstract HttpRequestExecutor createRequestExecutor();

    public abstract AuthenticationHandler createTargetAuthenticationHandler();

    public abstract UserTokenHandler createUserTokenHandler();

    public HttpParams determineParams(HttpRequest httpRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, httpRequest)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (HttpParams) invokeL.objValue;
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpResponse execute(HttpUriRequest httpUriRequest) throws IOException, ClientProtocolException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, httpUriRequest)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (HttpResponse) invokeL.objValue;
    }

    public final synchronized AuthSchemeRegistry getAuthSchemes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
        return (AuthSchemeRegistry) invokeV.objValue;
    }

    public final synchronized ConnectionKeepAliveStrategy getConnectionKeepAliveStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
        return (ConnectionKeepAliveStrategy) invokeV.objValue;
    }

    @Override // org.apache.http.client.HttpClient
    public final synchronized ClientConnectionManager getConnectionManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
        return (ClientConnectionManager) invokeV.objValue;
    }

    public final synchronized ConnectionReuseStrategy getConnectionReuseStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
        return (ConnectionReuseStrategy) invokeV.objValue;
    }

    public final synchronized CookieSpecRegistry getCookieSpecs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
        return (CookieSpecRegistry) invokeV.objValue;
    }

    public final synchronized CookieStore getCookieStore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
        return (CookieStore) invokeV.objValue;
    }

    public final synchronized CredentialsProvider getCredentialsProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
        return (CredentialsProvider) invokeV.objValue;
    }

    public final synchronized BasicHttpProcessor getHttpProcessor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
        return (BasicHttpProcessor) invokeV.objValue;
    }

    public final synchronized HttpRequestRetryHandler getHttpRequestRetryHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
        return (HttpRequestRetryHandler) invokeV.objValue;
    }

    @Override // org.apache.http.client.HttpClient
    public final synchronized HttpParams getParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
        return (HttpParams) invokeV.objValue;
    }

    public final synchronized AuthenticationHandler getProxyAuthenticationHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
        return (AuthenticationHandler) invokeV.objValue;
    }

    public final synchronized RedirectHandler getRedirectHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
        return (RedirectHandler) invokeV.objValue;
    }

    public final synchronized HttpRequestExecutor getRequestExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
        return (HttpRequestExecutor) invokeV.objValue;
    }

    public synchronized HttpRequestInterceptor getRequestInterceptor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048622, this, i)) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
        return (HttpRequestInterceptor) invokeI.objValue;
    }

    public synchronized int getRequestInterceptorCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
        return invokeV.intValue;
    }

    public synchronized HttpResponseInterceptor getResponseInterceptor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048624, this, i)) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
        return (HttpResponseInterceptor) invokeI.objValue;
    }

    public synchronized int getResponseInterceptorCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
        return invokeV.intValue;
    }

    public final synchronized HttpRoutePlanner getRoutePlanner() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
        return (HttpRoutePlanner) invokeV.objValue;
    }

    public final synchronized AuthenticationHandler getTargetAuthenticationHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
        return (AuthenticationHandler) invokeV.objValue;
    }

    public final synchronized UserTokenHandler getUserTokenHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
        return (UserTokenHandler) invokeV.objValue;
    }

    public void removeRequestInterceptorByClass(Class<? extends HttpRequestInterceptor> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, cls) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void removeResponseInterceptorByClass(Class<? extends HttpResponseInterceptor> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, cls) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public synchronized void setAuthSchemes(AuthSchemeRegistry authSchemeRegistry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, authSchemeRegistry) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
    }

    public synchronized void setCookieSpecs(CookieSpecRegistry cookieSpecRegistry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, cookieSpecRegistry) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
    }

    public synchronized void setCookieStore(CookieStore cookieStore) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, cookieStore) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
    }

    public synchronized void setCredentialsProvider(CredentialsProvider credentialsProvider) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, credentialsProvider) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
    }

    public synchronized void setHttpRequestRetryHandler(HttpRequestRetryHandler httpRequestRetryHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, httpRequestRetryHandler) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
    }

    public synchronized void setKeepAliveStrategy(ConnectionKeepAliveStrategy connectionKeepAliveStrategy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, connectionKeepAliveStrategy) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
    }

    public synchronized void setParams(HttpParams httpParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, httpParams) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
    }

    public synchronized void setProxyAuthenticationHandler(AuthenticationHandler authenticationHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, authenticationHandler) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
    }

    public synchronized void setRedirectHandler(RedirectHandler redirectHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, redirectHandler) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
    }

    public synchronized void setReuseStrategy(ConnectionReuseStrategy connectionReuseStrategy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, connectionReuseStrategy) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
    }

    public synchronized void setRoutePlanner(HttpRoutePlanner httpRoutePlanner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, httpRoutePlanner) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
    }

    public synchronized void setTargetAuthenticationHandler(AuthenticationHandler authenticationHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, authenticationHandler) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
    }

    public synchronized void setUserTokenHandler(UserTokenHandler userTokenHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, userTokenHandler) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
    }

    public synchronized void addRequestInterceptor(HttpRequestInterceptor httpRequestInterceptor, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpRequestInterceptor, i) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
    }

    public synchronized void addResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, httpResponseInterceptor, i) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048608, this, httpUriRequest, httpContext)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (HttpResponse) invokeLL.objValue;
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) throws IOException, ClientProtocolException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, httpHost, httpRequest)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (HttpResponse) invokeLL.objValue;
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048606, this, httpHost, httpRequest, httpContext)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (HttpResponse) invokeLLL.objValue;
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, httpUriRequest, responseHandler)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (T) invokeLL.objValue;
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048604, this, httpUriRequest, responseHandler, httpContext)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (T) invokeLLL.objValue;
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048601, this, httpHost, httpRequest, responseHandler)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (T) invokeLLL.objValue;
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048602, this, httpHost, httpRequest, responseHandler, httpContext)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (T) invokeLLLL.objValue;
    }
}
