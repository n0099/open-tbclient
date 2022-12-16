package okhttp3.internal.http;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileNotFoundException;
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
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http2.ConnectionShutdownException;
/* loaded from: classes9.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.client = okHttpClient;
        this.forWebSocket = z;
    }

    private boolean isRecoverable(IOException iOException, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, this, iOException, z)) == null) {
            if (iOException instanceof ProtocolException) {
                return false;
            }
            if (iOException instanceof InterruptedIOException) {
                if (!(iOException instanceof SocketTimeoutException) || z) {
                    return false;
                }
                return true;
            } else if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
                return false;
            } else {
                return true;
            }
        }
        return invokeLZ.booleanValue;
    }

    private boolean sameConnection(Response response, HttpUrl httpUrl) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, response, httpUrl)) == null) {
            HttpUrl url = response.request().url();
            if (url.host().equals(httpUrl.host()) && url.port() == httpUrl.port() && url.scheme().equals(httpUrl.scheme())) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, response, route)) == null) {
            if (response != null) {
                int code = response.code();
                String method = response.request().method();
                RequestBody requestBody = null;
                if (code != 307 && code != 308) {
                    if (code != 401) {
                        if (code != 503) {
                            if (code != 407) {
                                if (code != 408) {
                                    switch (code) {
                                        case 300:
                                        case 301:
                                        case 302:
                                        case 303:
                                            break;
                                        default:
                                            return null;
                                    }
                                } else if (!this.client.retryOnConnectionFailure() || (response.request().body() instanceof UnrepeatableRequestBody)) {
                                    return null;
                                } else {
                                    if ((response.priorResponse() != null && response.priorResponse().code() == 408) || retryAfter(response, 0) > 0) {
                                        return null;
                                    }
                                    return response.request();
                                }
                            } else if (route.proxy().type() == Proxy.Type.HTTP) {
                                return this.client.proxyAuthenticator().authenticate(route, response);
                            } else {
                                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                            }
                        } else if ((response.priorResponse() != null && response.priorResponse().code() == 503) || retryAfter(response, Integer.MAX_VALUE) != 0) {
                            return null;
                        } else {
                            return response.request();
                        }
                    } else {
                        return this.client.authenticator().authenticate(route, response);
                    }
                } else if (!method.equals("GET") && !method.equals("HEAD")) {
                    return null;
                }
                if (!this.client.followRedirects() || (header = response.header("Location")) == null || (resolve = response.request().url().resolve(header)) == null) {
                    return null;
                }
                if (!resolve.scheme().equals(response.request().url().scheme()) && !this.client.followSslRedirects()) {
                    return null;
                }
                Request.Builder newBuilder = response.request().newBuilder();
                if (HttpMethod.permitsRequestBody(method)) {
                    boolean redirectsWithBody = HttpMethod.redirectsWithBody(method);
                    if (HttpMethod.redirectsToGet(method)) {
                        newBuilder.method("GET", null);
                    } else {
                        if (redirectsWithBody) {
                            requestBody = response.request().body();
                        }
                        newBuilder.method(method, requestBody);
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
            throw new IllegalStateException();
        }
        return (Request) invokeLL.objValue;
    }

    private boolean recover(IOException iOException, StreamAllocation streamAllocation, boolean z, Request request) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{iOException, streamAllocation, Boolean.valueOf(z), request})) == null) {
            streamAllocation.streamFailed(iOException);
            if (!this.client.retryOnConnectionFailure()) {
                return false;
            }
            if ((z && requestIsUnrepeatable(iOException, request)) || !isRecoverable(iOException, z) || !streamAllocation.hasMoreRoutes()) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    private boolean requestIsUnrepeatable(IOException iOException, Request request) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, iOException, request)) == null) {
            if (!(request.body() instanceof UnrepeatableRequestBody) && !(iOException instanceof FileNotFoundException)) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    private int retryAfter(Response response, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, this, response, i)) == null) {
            String header = response.header("Retry-After");
            if (header == null) {
                return i;
            }
            if (header.matches("\\d+")) {
                return Integer.valueOf(header).intValue();
            }
            return Integer.MAX_VALUE;
        }
        return invokeLI.intValue;
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

    public boolean isCanceled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.canceled;
        }
        return invokeV.booleanValue;
    }

    public StreamAllocation streamAllocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.streamAllocation;
        }
        return (StreamAllocation) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0122  */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Response intercept(Interceptor.Chain chain) throws IOException {
        InterceptResult invokeL;
        boolean z;
        Response proceed;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chain)) == null) {
            Request request = chain.request();
            RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
            Call call = realInterceptorChain.call();
            EventListener eventListener = realInterceptorChain.eventListener();
            StreamAllocation streamAllocation = new StreamAllocation(this.client.connectionPool(), createAddress(request.url()), call, eventListener, this.callStackTrace);
            this.streamAllocation = streamAllocation;
            boolean z2 = false;
            Response response = null;
            int i = 0;
            while (!this.canceled) {
                try {
                    try {
                        try {
                            proceed = realInterceptorChain.proceed(request, streamAllocation, null, null);
                            if (response != null) {
                                proceed = proceed.newBuilder().priorResponse(response.newBuilder().body(null).build()).build();
                            }
                        } catch (IOException e) {
                            if (!(e instanceof ConnectionShutdownException)) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (recover(e, streamAllocation, z, request)) {
                                try {
                                    streamAllocation.setIsRetryStream(true);
                                } catch (Throwable th) {
                                    th = th;
                                    if (z2) {
                                    }
                                    throw th;
                                }
                            } else {
                                throw e;
                            }
                        }
                    } catch (RouteException e2) {
                        if (recover(e2.getLastConnectException(), streamAllocation, false, request)) {
                            streamAllocation.setIsRetryStream(true);
                        } else {
                            throw e2.getFirstConnectException();
                        }
                    }
                    try {
                        Request followUpRequest = followUpRequest(proceed, streamAllocation.route());
                        if (followUpRequest == null) {
                            streamAllocation.release();
                            return proceed;
                        }
                        Util.closeQuietly(proceed.body());
                        int i2 = i + 1;
                        if (i2 <= 20) {
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
                                i = i2;
                            } else {
                                streamAllocation.release();
                                throw new HttpRetryException("Cannot retry streamed HTTP body", proceed.code());
                            }
                        } else {
                            streamAllocation.release();
                            throw new ProtocolException("Too many follow-up requests: " + i2);
                        }
                    } catch (IOException e3) {
                        streamAllocation.release();
                        throw e3;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    z2 = true;
                    if (z2) {
                        streamAllocation.streamFailed(null);
                        streamAllocation.release();
                    }
                    throw th;
                }
            }
            streamAllocation.release();
            throw new IOException("Canceled");
        }
        return (Response) invokeL.objValue;
    }

    public void setCallStackTrace(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
            this.callStackTrace = obj;
        }
    }
}
