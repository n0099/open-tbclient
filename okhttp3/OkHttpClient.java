package okhttp3;

import com.alipay.sdk.data.a;
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
import okhttp3.HttpUrl;
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
/* loaded from: classes.dex */
public class OkHttpClient implements Cloneable, Call.Factory, WebSocket.Factory {
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
    public static final List<Protocol> DEFAULT_PROTOCOLS = Util.immutableList(Protocol.HTTP_2, Protocol.HTTP_1_1);
    public static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS = Util.immutableList(ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT);

    static {
        Internal.instance = new Internal() { // from class: okhttp3.OkHttpClient.1
            @Override // okhttp3.internal.Internal
            public void addLenient(Headers.Builder builder, String str) {
                builder.addLenient(str);
            }

            @Override // okhttp3.internal.Internal
            public void apply(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z) {
                connectionSpec.apply(sSLSocket, z);
            }

            @Override // okhttp3.internal.Internal
            public int code(Response.Builder builder) {
                return builder.code;
            }

            @Override // okhttp3.internal.Internal
            public boolean connectionBecameIdle(ConnectionPool connectionPool, RealConnection realConnection) {
                return connectionPool.connectionBecameIdle(realConnection);
            }

            @Override // okhttp3.internal.Internal
            public Socket deduplicate(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
                return connectionPool.deduplicate(address, streamAllocation);
            }

            @Override // okhttp3.internal.Internal
            public boolean equalsNonHost(Address address, Address address2) {
                return address.equalsNonHost(address2);
            }

            @Override // okhttp3.internal.Internal
            public RealConnection get(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route) {
                return connectionPool.get(address, streamAllocation, route);
            }

            @Override // okhttp3.internal.Internal
            public boolean isInvalidHttpUrlHost(IllegalArgumentException illegalArgumentException) {
                return illegalArgumentException.getMessage().startsWith(HttpUrl.Builder.INVALID_HOST);
            }

            @Override // okhttp3.internal.Internal
            public Call newWebSocketCall(OkHttpClient okHttpClient, Request request) {
                return RealCall.newRealCall(okHttpClient, request, true);
            }

            @Override // okhttp3.internal.Internal
            public void put(ConnectionPool connectionPool, RealConnection realConnection) {
                connectionPool.put(realConnection);
            }

            @Override // okhttp3.internal.Internal
            public RouteDatabase routeDatabase(ConnectionPool connectionPool) {
                return connectionPool.routeDatabase;
            }

            @Override // okhttp3.internal.Internal
            public void setCache(Builder builder, InternalCache internalCache) {
                builder.setInternalCache(internalCache);
            }

            @Override // okhttp3.internal.Internal
            public StreamAllocation streamAllocation(Call call) {
                return ((RealCall) call).streamAllocation();
            }

            @Override // okhttp3.internal.Internal
            public void addLenient(Headers.Builder builder, String str, String str2) {
                builder.addLenient(str, str2);
            }
        };
    }

    public OkHttpClient() {
        this(new Builder());
    }

    public static SSLSocketFactory newSslSocketFactory(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = Platform.get().getSSLContext();
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e2) {
            throw Util.assertionError("No System TLS", e2);
        }
    }

    public Authenticator authenticator() {
        return this.authenticator;
    }

    @Nullable
    public Cache cache() {
        return this.cache;
    }

    public CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    public int connectTimeoutMillis() {
        return this.connectTimeout;
    }

    public ConnectionPool connectionPool() {
        return this.connectionPool;
    }

    public List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    public CookieJar cookieJar() {
        return this.cookieJar;
    }

    public Dispatcher dispatcher() {
        return this.dispatcher;
    }

    public Dns dns() {
        return this.dns;
    }

    public EventListener.Factory eventListenerFactory() {
        return this.eventListenerFactory;
    }

    public boolean followRedirects() {
        return this.followRedirects;
    }

    public boolean followSslRedirects() {
        return this.followSslRedirects;
    }

    public HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public List<Interceptor> interceptors() {
        return this.interceptors;
    }

    public InternalCache internalCache() {
        Cache cache = this.cache;
        return cache != null ? cache.internalCache : this.internalCache;
    }

    public List<Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    @Override // okhttp3.Call.Factory
    public Call newCall(Request request) {
        return RealCall.newRealCall(this, request, false);
    }

    @Override // okhttp3.WebSocket.Factory
    public WebSocket newWebSocket(Request request, WebSocketListener webSocketListener) {
        RealWebSocket realWebSocket = new RealWebSocket(request, webSocketListener, new Random(), this.pingInterval);
        realWebSocket.connect(this);
        return realWebSocket;
    }

    public int pingIntervalMillis() {
        return this.pingInterval;
    }

    public List<Protocol> protocols() {
        return this.protocols;
    }

    public Proxy proxy() {
        return this.proxy;
    }

    public Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public int readTimeoutMillis() {
        return this.readTimeout;
    }

    public boolean retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    public SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    public int writeTimeoutMillis() {
        return this.writeTimeout;
    }

    public OkHttpClient(Builder builder) {
        boolean z;
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

    /* loaded from: classes.dex */
    public static final class Builder {
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
            if (interceptor != null) {
                this.interceptors.add(interceptor);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public Builder addNetworkInterceptor(Interceptor interceptor) {
            if (interceptor != null) {
                this.networkInterceptors.add(interceptor);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public Builder authenticator(Authenticator authenticator) {
            if (authenticator != null) {
                this.authenticator = authenticator;
                return this;
            }
            throw new NullPointerException("authenticator == null");
        }

        public OkHttpClient build() {
            return new OkHttpClient(this);
        }

        public Builder cache(@Nullable Cache cache) {
            this.cache = cache;
            this.internalCache = null;
            return this;
        }

        public Builder certificatePinner(CertificatePinner certificatePinner) {
            if (certificatePinner != null) {
                this.certificatePinner = certificatePinner;
                return this;
            }
            throw new NullPointerException("certificatePinner == null");
        }

        public Builder connectTimeout(long j, TimeUnit timeUnit) {
            this.connectTimeout = Util.checkDuration(a.i, j, timeUnit);
            return this;
        }

        public Builder connectionPool(ConnectionPool connectionPool) {
            if (connectionPool != null) {
                this.connectionPool = connectionPool;
                return this;
            }
            throw new NullPointerException("connectionPool == null");
        }

        public Builder connectionSpecs(List<ConnectionSpec> list) {
            this.connectionSpecs = Util.immutableList(list);
            return this;
        }

        public Builder cookieJar(CookieJar cookieJar) {
            if (cookieJar != null) {
                this.cookieJar = cookieJar;
                return this;
            }
            throw new NullPointerException("cookieJar == null");
        }

        public Builder dispatcher(Dispatcher dispatcher) {
            if (dispatcher != null) {
                this.dispatcher = dispatcher;
                return this;
            }
            throw new IllegalArgumentException("dispatcher == null");
        }

        public Builder dns(Dns dns) {
            if (dns != null) {
                this.dns = dns;
                return this;
            }
            throw new NullPointerException("dns == null");
        }

        public Builder eventListener(EventListener eventListener) {
            if (eventListener != null) {
                this.eventListenerFactory = EventListener.factory(eventListener);
                return this;
            }
            throw new NullPointerException("eventListener == null");
        }

        public Builder eventListenerFactory(EventListener.Factory factory) {
            if (factory != null) {
                this.eventListenerFactory = factory;
                return this;
            }
            throw new NullPointerException("eventListenerFactory == null");
        }

        public Builder followRedirects(boolean z) {
            this.followRedirects = z;
            return this;
        }

        public Builder followSslRedirects(boolean z) {
            this.followSslRedirects = z;
            return this;
        }

        public Builder hostnameVerifier(HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier != null) {
                this.hostnameVerifier = hostnameVerifier;
                return this;
            }
            throw new NullPointerException("hostnameVerifier == null");
        }

        public List<Interceptor> interceptors() {
            return this.interceptors;
        }

        public List<Interceptor> networkInterceptors() {
            return this.networkInterceptors;
        }

        public Builder pingInterval(long j, TimeUnit timeUnit) {
            this.pingInterval = Util.checkDuration("interval", j, timeUnit);
            return this;
        }

        public Builder protocols(List<Protocol> list) {
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

        public Builder proxy(@Nullable Proxy proxy) {
            this.proxy = proxy;
            return this;
        }

        public Builder proxyAuthenticator(Authenticator authenticator) {
            if (authenticator != null) {
                this.proxyAuthenticator = authenticator;
                return this;
            }
            throw new NullPointerException("proxyAuthenticator == null");
        }

        public Builder proxySelector(ProxySelector proxySelector) {
            this.proxySelector = proxySelector;
            return this;
        }

        public Builder readTimeout(long j, TimeUnit timeUnit) {
            this.readTimeout = Util.checkDuration(a.i, j, timeUnit);
            return this;
        }

        public Builder retryOnConnectionFailure(boolean z) {
            this.retryOnConnectionFailure = z;
            return this;
        }

        public void setInternalCache(@Nullable InternalCache internalCache) {
            this.internalCache = internalCache;
            this.cache = null;
        }

        public Builder socketFactory(SocketFactory socketFactory) {
            if (socketFactory != null) {
                this.socketFactory = socketFactory;
                return this;
            }
            throw new NullPointerException("socketFactory == null");
        }

        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            if (sSLSocketFactory != null) {
                this.sslSocketFactory = sSLSocketFactory;
                this.certificateChainCleaner = Platform.get().buildCertificateChainCleaner(sSLSocketFactory);
                return this;
            }
            throw new NullPointerException("sslSocketFactory == null");
        }

        public Builder writeTimeout(long j, TimeUnit timeUnit) {
            this.writeTimeout = Util.checkDuration(a.i, j, timeUnit);
            return this;
        }

        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
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

        public Builder(OkHttpClient okHttpClient) {
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
