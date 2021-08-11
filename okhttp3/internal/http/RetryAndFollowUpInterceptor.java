package okhttp3.internal.http;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.http.response.ResponseException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http2.ConnectionShutdownException;
/* loaded from: classes2.dex */
public final class RetryAndFollowUpInterceptor implements Interceptor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_FOLLOW_UPS = 20;
    public transient /* synthetic */ FieldHolder $fh;
    public Object callStackTrace;
    public volatile boolean canceled;
    public final OkHttpClient client;
    public final boolean forWebSocket;
    public volatile StreamAllocation streamAllocation;

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {okHttpClient, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.client = okHttpClient;
        this.forWebSocket = z;
    }

    private Address createAddress(HttpUrl httpUrl) {
        InterceptResult invokeL;
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, httpUrl)) == null) {
            if (httpUrl.isHttps()) {
                SSLSocketFactory sslSocketFactory = this.client.sslSocketFactory();
                hostnameVerifier = this.client.hostnameVerifier();
                sSLSocketFactory = sslSocketFactory;
                certificatePinner = this.client.certificatePinner();
            } else {
                sSLSocketFactory = null;
                hostnameVerifier = null;
                certificatePinner = null;
            }
            return new Address(httpUrl.host(), httpUrl.port(), this.client.dns(), this.client.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
        }
        return (Address) invokeL.objValue;
    }

    private Request followUpRequest(Response response, Route route) throws IOException {
        InterceptResult invokeLL;
        String header;
        HttpUrl resolve;
        Proxy proxy;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, response, route)) == null) {
            if (response != null) {
                int code = response.code();
                String method = response.request().method();
                if (code == 307 || code == 308) {
                    if (!method.equals("GET") && !method.equals("HEAD")) {
                        return null;
                    }
                } else if (code != 401) {
                    if (code == 503) {
                        if ((response.priorResponse() == null || response.priorResponse().code() != 503) && retryAfter(response, Integer.MAX_VALUE) == 0) {
                            return response.request();
                        }
                        return null;
                    } else if (code == 407) {
                        if (route != null) {
                            proxy = route.proxy();
                        } else {
                            proxy = this.client.proxy();
                        }
                        if (proxy.type() == Proxy.Type.HTTP) {
                            return this.client.proxyAuthenticator().authenticate(route, response);
                        }
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    } else if (code == 408) {
                        if (this.client.retryOnConnectionFailure() && !(response.request().body() instanceof UnrepeatableRequestBody)) {
                            if ((response.priorResponse() == null || response.priorResponse().code() != 408) && retryAfter(response, 0) <= 0) {
                                return response.request();
                            }
                            return null;
                        }
                        return null;
                    } else {
                        switch (code) {
                            case 300:
                            case 301:
                            case 302:
                            case 303:
                                break;
                            default:
                                return null;
                        }
                    }
                } else {
                    return this.client.authenticator().authenticate(route, response);
                }
                if (!this.client.followRedirects() || (header = response.header("Location")) == null || (resolve = response.request().url().resolve(header)) == null) {
                    return null;
                }
                if (resolve.scheme().equals(response.request().url().scheme()) || this.client.followSslRedirects()) {
                    Request.Builder newBuilder = response.request().newBuilder();
                    if (HttpMethod.permitsRequestBody(method)) {
                        boolean redirectsWithBody = HttpMethod.redirectsWithBody(method);
                        if (HttpMethod.redirectsToGet(method)) {
                            newBuilder.method("GET", null);
                        } else {
                            newBuilder.method(method, redirectsWithBody ? response.request().body() : null);
                        }
                        if (!redirectsWithBody) {
                            newBuilder.removeHeader("Transfer-Encoding");
                            newBuilder.removeHeader("Content-Length");
                            newBuilder.removeHeader("Content-Type");
                        }
                    }
                    if (!sameConnection(response, resolve)) {
                        newBuilder.removeHeader("Authorization");
                    }
                    return newBuilder.url(resolve).build();
                }
                return null;
            }
            throw new IllegalStateException();
        }
        return (Request) invokeLL.objValue;
    }

    private boolean isRecoverable(IOException iOException, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, this, iOException, z)) == null) {
            if (iOException instanceof ProtocolException) {
                return false;
            }
            return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
        }
        return invokeLZ.booleanValue;
    }

    private boolean recover(IOException iOException, StreamAllocation streamAllocation, boolean z, Request request) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{iOException, streamAllocation, Boolean.valueOf(z), request})) == null) {
            streamAllocation.streamFailed(iOException);
            if (this.client.retryOnConnectionFailure()) {
                return !(z && (request.body() instanceof UnrepeatableRequestBody)) && isRecoverable(iOException, z) && streamAllocation.hasMoreRoutes();
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    private int retryAfter(Response response, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, this, response, i2)) == null) {
            String header = response.header("Retry-After");
            if (header == null) {
                return i2;
            }
            if (header.matches("\\d+")) {
                return Integer.valueOf(header).intValue();
            }
            return Integer.MAX_VALUE;
        }
        return invokeLI.intValue;
    }

    private boolean sameConnection(Response response, HttpUrl httpUrl) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, response, httpUrl)) == null) {
            HttpUrl url = response.request().url();
            return url.host().equals(httpUrl.host()) && url.port() == httpUrl.port() && url.scheme().equals(httpUrl.scheme());
        }
        return invokeLL.booleanValue;
    }

    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.canceled = true;
            StreamAllocation streamAllocation = this.streamAllocation;
            if (streamAllocation != null) {
                streamAllocation.cancel();
            }
        }
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        InterceptResult invokeL;
        Response proceed;
        Request followUpRequest;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chain)) == null) {
            Request request = chain.request();
            RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
            Call call = realInterceptorChain.call();
            EventListener eventListener = realInterceptorChain.eventListener();
            StreamAllocation streamAllocation = new StreamAllocation(this.client.connectionPool(), createAddress(request.url()), call, eventListener, this.callStackTrace);
            this.streamAllocation = streamAllocation;
            Response response = null;
            int i2 = 0;
            while (!this.canceled) {
                try {
                    try {
                        proceed = realInterceptorChain.proceed(request, streamAllocation, null, null);
                        if (response != null) {
                            proceed = proceed.newBuilder().priorResponse(response.newBuilder().body(null).build()).build();
                        }
                        try {
                            followUpRequest = followUpRequest(proceed, streamAllocation.route());
                        } catch (IOException e2) {
                            streamAllocation.release();
                            throw e2;
                        }
                    } catch (Throwable th) {
                        streamAllocation.streamFailed(null);
                        streamAllocation.release();
                        throw th;
                    }
                } catch (IOException e3) {
                    if (!recover(e3, streamAllocation, !(e3 instanceof ConnectionShutdownException), request)) {
                        throw e3;
                    }
                } catch (RouteException e4) {
                    if (!recover(e4.getLastConnectException(), streamAllocation, false, request)) {
                        throw e4.getFirstConnectException();
                    }
                }
                if (followUpRequest == null) {
                    if (!this.forWebSocket) {
                        streamAllocation.release();
                    }
                    return proceed;
                }
                Util.closeQuietly(proceed.body());
                int i3 = i2 + 1;
                if (i3 <= 20) {
                    if (!(followUpRequest.body() instanceof UnrepeatableRequestBody)) {
                        if (!sameConnection(proceed, followUpRequest.url())) {
                            streamAllocation.release();
                            streamAllocation = new StreamAllocation(this.client.connectionPool(), createAddress(followUpRequest.url()), call, eventListener, this.callStackTrace);
                            this.streamAllocation = streamAllocation;
                        } else if (streamAllocation.codec() != null) {
                            throw new IllegalStateException("Closing the body of " + proceed + " didn't close its backing stream. Bad interceptor?");
                        }
                        response = proceed;
                        request = followUpRequest;
                        i2 = i3;
                    } else {
                        streamAllocation.release();
                        throw new HttpRetryException("Cannot retry streamed HTTP body", proceed.code());
                    }
                } else {
                    streamAllocation.release();
                    throw new ProtocolException("Too many follow-up requests: " + i3);
                }
            }
            streamAllocation.release();
            throw new IOException(ResponseException.CANCELED);
        }
        return (Response) invokeL.objValue;
    }

    public boolean isCanceled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.canceled : invokeV.booleanValue;
    }

    public void setCallStackTrace(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
            this.callStackTrace = obj;
        }
    }

    public StreamAllocation streamAllocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.streamAllocation : (StreamAllocation) invokeV.objValue;
    }
}
