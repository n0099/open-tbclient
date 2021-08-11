package okhttp3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
/* loaded from: classes2.dex */
public class OkHttpClient implements Cloneable, Call.Factory, WebSocket.Factory {
    public static /* synthetic */ Interceptable $ic;
    public static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS;
    public static final List<Protocol> DEFAULT_PROTOCOLS;
    public transient /* synthetic */ FieldHolder $fh;
    public final Authenticator authenticator;
    @Nullable
    public final Cache cache;
    @Nullable
    public final CertificateChainCleaner certificateChainCleaner;
    public final CertificatePinner certificatePinner;
    public final int connectTimeout;
    public final ConnectionPool connectionPool;
    public final List<ConnectionSpec> connectionSpecs;
    public final CookieJar cookieJar;
    public final Dispatcher dispatcher;
    public final Dns dns;
    public final EventListener.Factory eventListenerFactory;
    public final boolean followRedirects;
    public final boolean followSslRedirects;
    public final HostnameVerifier hostnameVerifier;
    public final List<Interceptor> interceptors;
    @Nullable
    public final InternalCache internalCache;
    public final List<Interceptor> networkInterceptors;
    public final int pingInterval;
    public final List<Protocol> protocols;
    @Nullable
    public final Proxy proxy;
    public final Authenticator proxyAuthenticator;
    public final ProxySelector proxySelector;
    public final int readTimeout;
    public final boolean retryOnConnectionFailure;
    public final SocketFactory socketFactory;
    @Nullable
    public final SSLSocketFactory sslSocketFactory;
    public final int writeTimeout;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(210185728, "Lokhttp3/OkHttpClient;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(210185728, "Lokhttp3/OkHttpClient;");
                return;
            }
        }
        DEFAULT_PROTOCOLS = Util.immutableList(Protocol.HTTP_2, Protocol.HTTP_1_1);
        DEFAULT_CONNECTION_SPECS = Util.immutableList(ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT);
        Internal.instance = new Internal() { // from class: okhttp3.OkHttpClient.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // okhttp3.internal.Internal
            public void addLenient(Headers.Builder builder, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, builder, str) == null) {
                    builder.addLenient(str);
                }
            }

            @Override // okhttp3.internal.Internal
            public void apply(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, connectionSpec, sSLSocket, z) == null) {
                    connectionSpec.apply(sSLSocket, z);
                }
            }

            @Override // okhttp3.internal.Internal
            public int code(Response.Builder builder) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048579, this, builder)) == null) ? builder.code : invokeL.intValue;
            }

            @Override // okhttp3.internal.Internal
            public boolean connectionBecameIdle(ConnectionPool connectionPool, RealConnection realConnection) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048580, this, connectionPool, realConnection)) == null) ? connectionPool.connectionBecameIdle(realConnection) : invokeLL.booleanValue;
            }

            @Override // okhttp3.internal.Internal
            public Socket deduplicate(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
                InterceptResult invokeLLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048581, this, connectionPool, address, streamAllocation)) == null) ? connectionPool.deduplicate(address, streamAllocation) : (Socket) invokeLLL.objValue;
            }

            @Override // okhttp3.internal.Internal
            public boolean equalsNonHost(Address address, Address address2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048582, this, address, address2)) == null) ? address.equalsNonHost(address2) : invokeLL.booleanValue;
            }

            @Override // okhttp3.internal.Internal
            public RealConnection get(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route) {
                InterceptResult invokeLLLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLLLL = interceptable2.invokeLLLL(1048583, this, connectionPool, address, streamAllocation, route)) == null) ? connectionPool.get(address, streamAllocation, route) : (RealConnection) invokeLLLL.objValue;
            }

            @Override // okhttp3.internal.Internal
            public boolean isInvalidHttpUrlHost(IllegalArgumentException illegalArgumentException) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, illegalArgumentException)) == null) ? illegalArgumentException.getMessage().startsWith("Invalid URL host") : invokeL.booleanValue;
            }

            @Override // okhttp3.internal.Internal
            public Call newWebSocketCall(OkHttpClient okHttpClient, Request request) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048585, this, okHttpClient, request)) == null) ? RealCall.newRealCall(okHttpClient, request, true) : (Call) invokeLL.objValue;
            }

            @Override // okhttp3.internal.Internal
            public void put(ConnectionPool connectionPool, RealConnection realConnection) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048586, this, connectionPool, realConnection) == null) {
                    connectionPool.put(realConnection);
                }
            }

            @Override // okhttp3.internal.Internal
            public RouteDatabase routeDatabase(ConnectionPool connectionPool) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048587, this, connectionPool)) == null) ? connectionPool.routeDatabase : (RouteDatabase) invokeL.objValue;
            }

            @Override // okhttp3.internal.Internal
            public void setCache(Builder builder, InternalCache internalCache) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048588, this, builder, internalCache) == null) {
                    builder.setInternalCache(internalCache);
                }
            }

            @Override // okhttp3.internal.Internal
            public StreamAllocation streamAllocation(Call call) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048589, this, call)) == null) ? ((RealCall) call).streamAllocation() : (StreamAllocation) invokeL.objValue;
            }

            @Override // okhttp3.internal.Internal
            public void addLenient(Headers.Builder builder, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, builder, str, str2) == null) {
                    builder.addLenient(str, str2);
                }
            }
        };
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OkHttpClient() {
        this(new Builder());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((Builder) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static SSLSocketFactory newSslSocketFactory(X509TrustManager x509TrustManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, x509TrustManager)) == null) {
            try {
                SSLContext sSLContext = Platform.get().getSSLContext();
                sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
                return sSLContext.getSocketFactory();
            } catch (GeneralSecurityException e2) {
                throw Util.assertionError("No System TLS", e2);
            }
        }
        return (SSLSocketFactory) invokeL.objValue;
    }

    public Authenticator authenticator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.authenticator : (Authenticator) invokeV.objValue;
    }

    @Nullable
    public Cache cache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.cache : (Cache) invokeV.objValue;
    }

    public CertificatePinner certificatePinner() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.certificatePinner : (CertificatePinner) invokeV.objValue;
    }

    public int connectTimeoutMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.connectTimeout : invokeV.intValue;
    }

    public ConnectionPool connectionPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.connectionPool : (ConnectionPool) invokeV.objValue;
    }

    public List<ConnectionSpec> connectionSpecs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.connectionSpecs : (List) invokeV.objValue;
    }

    public CookieJar cookieJar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.cookieJar : (CookieJar) invokeV.objValue;
    }

    public Dispatcher dispatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.dispatcher : (Dispatcher) invokeV.objValue;
    }

    public Dns dns() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.dns : (Dns) invokeV.objValue;
    }

    public EventListener.Factory eventListenerFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.eventListenerFactory : (EventListener.Factory) invokeV.objValue;
    }

    public boolean followRedirects() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.followRedirects : invokeV.booleanValue;
    }

    public boolean followSslRedirects() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.followSslRedirects : invokeV.booleanValue;
    }

    public HostnameVerifier hostnameVerifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.hostnameVerifier : (HostnameVerifier) invokeV.objValue;
    }

    public List<Interceptor> interceptors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.interceptors : (List) invokeV.objValue;
    }

    public InternalCache internalCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            Cache cache = this.cache;
            return cache != null ? cache.internalCache : this.internalCache;
        }
        return (InternalCache) invokeV.objValue;
    }

    public List<Interceptor> networkInterceptors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.networkInterceptors : (List) invokeV.objValue;
    }

    public Builder newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? new Builder(this) : (Builder) invokeV.objValue;
    }

    @Override // okhttp3.Call.Factory
    public Call newCall(Request request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, request)) == null) ? RealCall.newRealCall(this, request, false) : (Call) invokeL.objValue;
    }

    @Override // okhttp3.WebSocket.Factory
    public WebSocket newWebSocket(Request request, WebSocketListener webSocketListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, request, webSocketListener)) == null) {
            RealWebSocket realWebSocket = new RealWebSocket(request, webSocketListener, new Random(), this.pingInterval);
            realWebSocket.connect(this);
            return realWebSocket;
        }
        return (WebSocket) invokeLL.objValue;
    }

    public int pingIntervalMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.pingInterval : invokeV.intValue;
    }

    public List<Protocol> protocols() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.protocols : (List) invokeV.objValue;
    }

    public Proxy proxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.proxy : (Proxy) invokeV.objValue;
    }

    public Authenticator proxyAuthenticator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.proxyAuthenticator : (Authenticator) invokeV.objValue;
    }

    public ProxySelector proxySelector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.proxySelector : (ProxySelector) invokeV.objValue;
    }

    public int readTimeoutMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.readTimeout : invokeV.intValue;
    }

    public boolean retryOnConnectionFailure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.retryOnConnectionFailure : invokeV.booleanValue;
    }

    public SocketFactory socketFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.socketFactory : (SocketFactory) invokeV.objValue;
    }

    public SSLSocketFactory sslSocketFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.sslSocketFactory : (SSLSocketFactory) invokeV.objValue;
    }

    public int writeTimeoutMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.writeTimeout : invokeV.intValue;
    }

    public OkHttpClient(Builder builder) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.dispatcher = builder.dispatcher;
        this.proxy = builder.proxy;
        this.protocols = builder.protocols;
        this.connectionSpecs = builder.connectionSpecs;
        this.interceptors = Util.immutableList(builder.interceptors);
        this.networkInterceptors = Util.immutableList(builder.networkInterceptors);
        this.eventListenerFactory = builder.eventListenerFactory;
        this.proxySelector = builder.proxySelector;
        this.cookieJar = builder.cookieJar;
        this.cache = builder.cache;
        this.internalCache = builder.internalCache;
        this.socketFactory = builder.socketFactory;
        loop0: while (true) {
            for (ConnectionSpec connectionSpec : this.connectionSpecs) {
                z = z || connectionSpec.isTls();
            }
        }
        if (builder.sslSocketFactory == null && z) {
            X509TrustManager platformTrustManager = Util.platformTrustManager();
            this.sslSocketFactory = newSslSocketFactory(platformTrustManager);
            this.certificateChainCleaner = CertificateChainCleaner.get(platformTrustManager);
        } else {
            this.sslSocketFactory = builder.sslSocketFactory;
            this.certificateChainCleaner = builder.certificateChainCleaner;
        }
        if (this.sslSocketFactory != null) {
            Platform.get().configureSslSocketFactory(this.sslSocketFactory);
        }
        this.hostnameVerifier = builder.hostnameVerifier;
        this.certificatePinner = builder.certificatePinner.withCertificateChainCleaner(this.certificateChainCleaner);
        this.proxyAuthenticator = builder.proxyAuthenticator;
        this.authenticator = builder.authenticator;
        this.connectionPool = builder.connectionPool;
        this.dns = builder.dns;
        this.followSslRedirects = builder.followSslRedirects;
        this.followRedirects = builder.followRedirects;
        this.retryOnConnectionFailure = builder.retryOnConnectionFailure;
        this.connectTimeout = builder.connectTimeout;
        this.readTimeout = builder.readTimeout;
        this.writeTimeout = builder.writeTimeout;
        this.pingInterval = builder.pingInterval;
        if (!this.interceptors.contains(null)) {
            if (this.networkInterceptors.contains(null)) {
                throw new IllegalStateException("Null network interceptor: " + this.networkInterceptors);
            }
            return;
        }
        throw new IllegalStateException("Null interceptor: " + this.interceptors);
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Authenticator authenticator;
        @Nullable
        public Cache cache;
        @Nullable
        public CertificateChainCleaner certificateChainCleaner;
        public CertificatePinner certificatePinner;
        public int connectTimeout;
        public ConnectionPool connectionPool;
        public List<ConnectionSpec> connectionSpecs;
        public CookieJar cookieJar;
        public Dispatcher dispatcher;
        public Dns dns;
        public EventListener.Factory eventListenerFactory;
        public boolean followRedirects;
        public boolean followSslRedirects;
        public HostnameVerifier hostnameVerifier;
        public final List<Interceptor> interceptors;
        @Nullable
        public InternalCache internalCache;
        public final List<Interceptor> networkInterceptors;
        public int pingInterval;
        public List<Protocol> protocols;
        @Nullable
        public Proxy proxy;
        public Authenticator proxyAuthenticator;
        public ProxySelector proxySelector;
        public int readTimeout;
        public boolean retryOnConnectionFailure;
        public SocketFactory socketFactory;
        @Nullable
        public SSLSocketFactory sslSocketFactory;
        public int writeTimeout;

        public Builder() {
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
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.dispatcher = new Dispatcher();
            this.protocols = OkHttpClient.DEFAULT_PROTOCOLS;
            this.connectionSpecs = OkHttpClient.DEFAULT_CONNECTION_SPECS;
            this.eventListenerFactory = EventListener.factory(EventListener.NONE);
            this.proxySelector = ProxySelector.getDefault();
            this.cookieJar = CookieJar.NO_COOKIES;
            this.socketFactory = SocketFactory.getDefault();
            this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
            this.certificatePinner = CertificatePinner.DEFAULT;
            Authenticator authenticator = Authenticator.NONE;
            this.proxyAuthenticator = authenticator;
            this.authenticator = authenticator;
            this.connectionPool = new ConnectionPool();
            this.dns = Dns.SYSTEM;
            this.followSslRedirects = true;
            this.followRedirects = true;
            this.retryOnConnectionFailure = true;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
            this.pingInterval = 0;
        }

        public Builder addInterceptor(Interceptor interceptor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, interceptor)) == null) {
                if (interceptor != null) {
                    this.interceptors.add(interceptor);
                    return this;
                }
                throw new IllegalArgumentException("interceptor == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder addNetworkInterceptor(Interceptor interceptor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interceptor)) == null) {
                if (interceptor != null) {
                    this.networkInterceptors.add(interceptor);
                    return this;
                }
                throw new IllegalArgumentException("interceptor == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder authenticator(Authenticator authenticator) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, authenticator)) == null) {
                if (authenticator != null) {
                    this.authenticator = authenticator;
                    return this;
                }
                throw new NullPointerException("authenticator == null");
            }
            return (Builder) invokeL.objValue;
        }

        public OkHttpClient build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new OkHttpClient(this) : (OkHttpClient) invokeV.objValue;
        }

        public Builder cache(@Nullable Cache cache) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cache)) == null) {
                this.cache = cache;
                this.internalCache = null;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder certificatePinner(CertificatePinner certificatePinner) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, certificatePinner)) == null) {
                if (certificatePinner != null) {
                    this.certificatePinner = certificatePinner;
                    return this;
                }
                throw new NullPointerException("certificatePinner == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder connectTimeout(long j2, TimeUnit timeUnit) {
            InterceptResult invokeJL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJL = interceptable.invokeJL(1048582, this, j2, timeUnit)) == null) {
                this.connectTimeout = Util.checkDuration("timeout", j2, timeUnit);
                return this;
            }
            return (Builder) invokeJL.objValue;
        }

        public Builder connectionPool(ConnectionPool connectionPool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, connectionPool)) == null) {
                if (connectionPool != null) {
                    this.connectionPool = connectionPool;
                    return this;
                }
                throw new NullPointerException("connectionPool == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder connectionSpecs(List<ConnectionSpec> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list)) == null) {
                this.connectionSpecs = Util.immutableList(list);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder cookieJar(CookieJar cookieJar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, cookieJar)) == null) {
                if (cookieJar != null) {
                    this.cookieJar = cookieJar;
                    return this;
                }
                throw new NullPointerException("cookieJar == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder dispatcher(Dispatcher dispatcher) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, dispatcher)) == null) {
                if (dispatcher != null) {
                    this.dispatcher = dispatcher;
                    return this;
                }
                throw new IllegalArgumentException("dispatcher == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder dns(Dns dns) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, dns)) == null) {
                if (dns != null) {
                    this.dns = dns;
                    return this;
                }
                throw new NullPointerException("dns == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder eventListener(EventListener eventListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, eventListener)) == null) {
                if (eventListener != null) {
                    this.eventListenerFactory = EventListener.factory(eventListener);
                    return this;
                }
                throw new NullPointerException("eventListener == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder eventListenerFactory(EventListener.Factory factory) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, factory)) == null) {
                if (factory != null) {
                    this.eventListenerFactory = factory;
                    return this;
                }
                throw new NullPointerException("eventListenerFactory == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder followRedirects(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
                this.followRedirects = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder followSslRedirects(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
                this.followSslRedirects = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder hostnameVerifier(HostnameVerifier hostnameVerifier) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, hostnameVerifier)) == null) {
                if (hostnameVerifier != null) {
                    this.hostnameVerifier = hostnameVerifier;
                    return this;
                }
                throw new NullPointerException("hostnameVerifier == null");
            }
            return (Builder) invokeL.objValue;
        }

        public List<Interceptor> interceptors() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.interceptors : (List) invokeV.objValue;
        }

        public List<Interceptor> networkInterceptors() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.networkInterceptors : (List) invokeV.objValue;
        }

        public Builder pingInterval(long j2, TimeUnit timeUnit) {
            InterceptResult invokeJL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJL = interceptable.invokeJL(1048595, this, j2, timeUnit)) == null) {
                this.pingInterval = Util.checkDuration("interval", j2, timeUnit);
                return this;
            }
            return (Builder) invokeJL.objValue;
        }

        public Builder protocols(List<Protocol> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, list)) == null) {
                ArrayList arrayList = new ArrayList(list);
                if (!arrayList.contains(Protocol.H2_PRIOR_KNOWLEDGE) && !arrayList.contains(Protocol.HTTP_1_1)) {
                    throw new IllegalArgumentException("protocols must contain h2_prior_knowledge or http/1.1: " + arrayList);
                } else if (arrayList.contains(Protocol.H2_PRIOR_KNOWLEDGE) && arrayList.size() > 1) {
                    throw new IllegalArgumentException("protocols containing h2_prior_knowledge cannot use other protocols: " + arrayList);
                } else if (!arrayList.contains(Protocol.HTTP_1_0)) {
                    if (!arrayList.contains(null)) {
                        arrayList.remove(Protocol.SPDY_3);
                        this.protocols = Collections.unmodifiableList(arrayList);
                        return this;
                    }
                    throw new IllegalArgumentException("protocols must not contain null");
                } else {
                    throw new IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
                }
            }
            return (Builder) invokeL.objValue;
        }

        public Builder proxy(@Nullable Proxy proxy) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, proxy)) == null) {
                this.proxy = proxy;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder proxyAuthenticator(Authenticator authenticator) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, authenticator)) == null) {
                if (authenticator != null) {
                    this.proxyAuthenticator = authenticator;
                    return this;
                }
                throw new NullPointerException("proxyAuthenticator == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder proxySelector(ProxySelector proxySelector) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, proxySelector)) == null) {
                this.proxySelector = proxySelector;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder readTimeout(long j2, TimeUnit timeUnit) {
            InterceptResult invokeJL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJL = interceptable.invokeJL(1048600, this, j2, timeUnit)) == null) {
                this.readTimeout = Util.checkDuration("timeout", j2, timeUnit);
                return this;
            }
            return (Builder) invokeJL.objValue;
        }

        public Builder retryOnConnectionFailure(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048601, this, z)) == null) {
                this.retryOnConnectionFailure = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public void setInternalCache(@Nullable InternalCache internalCache) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048602, this, internalCache) == null) {
                this.internalCache = internalCache;
                this.cache = null;
            }
        }

        public Builder socketFactory(SocketFactory socketFactory) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, socketFactory)) == null) {
                if (socketFactory != null) {
                    this.socketFactory = socketFactory;
                    return this;
                }
                throw new NullPointerException("socketFactory == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, sSLSocketFactory)) == null) {
                if (sSLSocketFactory != null) {
                    this.sslSocketFactory = sSLSocketFactory;
                    this.certificateChainCleaner = Platform.get().buildCertificateChainCleaner(sSLSocketFactory);
                    return this;
                }
                throw new NullPointerException("sslSocketFactory == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder writeTimeout(long j2, TimeUnit timeUnit) {
            InterceptResult invokeJL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJL = interceptable.invokeJL(1048606, this, j2, timeUnit)) == null) {
                this.writeTimeout = Util.checkDuration("timeout", j2, timeUnit);
                return this;
            }
            return (Builder) invokeJL.objValue;
        }

        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, sSLSocketFactory, x509TrustManager)) == null) {
                if (sSLSocketFactory != null) {
                    if (x509TrustManager != null) {
                        this.sslSocketFactory = sSLSocketFactory;
                        this.certificateChainCleaner = CertificateChainCleaner.get(x509TrustManager);
                        return this;
                    }
                    throw new NullPointerException("trustManager == null");
                }
                throw new NullPointerException("sslSocketFactory == null");
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder(OkHttpClient okHttpClient) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {okHttpClient};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.dispatcher = okHttpClient.dispatcher;
            this.proxy = okHttpClient.proxy;
            this.protocols = okHttpClient.protocols;
            this.connectionSpecs = okHttpClient.connectionSpecs;
            this.interceptors.addAll(okHttpClient.interceptors);
            this.networkInterceptors.addAll(okHttpClient.networkInterceptors);
            this.eventListenerFactory = okHttpClient.eventListenerFactory;
            this.proxySelector = okHttpClient.proxySelector;
            this.cookieJar = okHttpClient.cookieJar;
            this.internalCache = okHttpClient.internalCache;
            this.cache = okHttpClient.cache;
            this.socketFactory = okHttpClient.socketFactory;
            this.sslSocketFactory = okHttpClient.sslSocketFactory;
            this.certificateChainCleaner = okHttpClient.certificateChainCleaner;
            this.hostnameVerifier = okHttpClient.hostnameVerifier;
            this.certificatePinner = okHttpClient.certificatePinner;
            this.proxyAuthenticator = okHttpClient.proxyAuthenticator;
            this.authenticator = okHttpClient.authenticator;
            this.connectionPool = okHttpClient.connectionPool;
            this.dns = okHttpClient.dns;
            this.followSslRedirects = okHttpClient.followSslRedirects;
            this.followRedirects = okHttpClient.followRedirects;
            this.retryOnConnectionFailure = okHttpClient.retryOnConnectionFailure;
            this.connectTimeout = okHttpClient.connectTimeout;
            this.readTimeout = okHttpClient.readTimeout;
            this.writeTimeout = okHttpClient.writeTimeout;
            this.pingInterval = okHttpClient.pingInterval;
        }
    }
}
