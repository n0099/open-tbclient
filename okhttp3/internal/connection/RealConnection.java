package okhttp3.internal.connection;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http1.Http1Codec;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Codec;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import org.apache.http.protocol.HTTP;
/* loaded from: classes10.dex */
public final class RealConnection extends Http2Connection.Listener implements Connection {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_TUNNEL_ATTEMPTS = 21;
    public static final String NPE_THROW_WITH_NULL = "throw with null exception";
    public transient /* synthetic */ FieldHolder $fh;
    public int allocationLimit;
    public final List<Reference<StreamAllocation>> allocations;
    public final ConnectionPool connectionPool;
    public Handshake handshake;
    public Http2Connection http2Connection;
    public long idleAtNanos;
    public boolean noNewStreams;
    public Protocol protocol;
    public Socket rawSocket;
    public final Route route;
    public BufferedSink sink;
    public Socket socket;
    public BufferedSource source;
    public int successCount;

    public RealConnection(ConnectionPool connectionPool, Route route) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {connectionPool, route};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.allocationLimit = 1;
        this.allocations = new ArrayList();
        this.idleAtNanos = Long.MAX_VALUE;
        this.connectionPool = connectionPool;
        this.route = route;
    }

    private void connectSocket(int i2, int i3, Call call, EventListener eventListener) throws IOException {
        Socket createSocket;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), call, eventListener}) == null) {
            Proxy proxy = this.route.proxy();
            Address address = this.route.address();
            if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.HTTP) {
                createSocket = new Socket(proxy);
            } else {
                createSocket = address.socketFactory().createSocket();
            }
            this.rawSocket = createSocket;
            eventListener.connectStart(call, this.route.socketAddress(), proxy);
            this.rawSocket.setSoTimeout(i3);
            try {
                Platform.get().connectSocket(this.rawSocket, this.route.socketAddress(), i2);
                try {
                    this.source = Okio.buffer(Okio.source(this.rawSocket));
                    this.sink = Okio.buffer(Okio.sink(this.rawSocket));
                } catch (NullPointerException e2) {
                    if (NPE_THROW_WITH_NULL.equals(e2.getMessage())) {
                        throw new IOException(e2);
                    }
                }
            } catch (ConnectException e3) {
                ConnectException connectException = new ConnectException("Failed to connect to " + this.route.socketAddress());
                connectException.initCause(e3);
                throw connectException;
            }
        }
    }

    private void connectTls(ConnectionSpecSelector connectionSpecSelector) throws IOException {
        SSLSocket sSLSocket;
        Protocol protocol;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, connectionSpecSelector) == null) {
            Address address = this.route.address();
            SSLSocket sSLSocket2 = null;
            try {
                try {
                    sSLSocket = (SSLSocket) address.sslSocketFactory().createSocket(this.rawSocket, address.url().host(), address.url().port(), true);
                } catch (AssertionError e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                ConnectionSpec configureSecureSocket = connectionSpecSelector.configureSecureSocket(sSLSocket);
                if (configureSecureSocket.supportsTlsExtensions()) {
                    Platform.get().configureTlsExtensions(sSLSocket, address.url().host(), address.protocols());
                }
                sSLSocket.startHandshake();
                SSLSession session = sSLSocket.getSession();
                Handshake handshake = Handshake.get(session);
                if (address.hostnameVerifier().verify(address.url().host(), session)) {
                    address.certificatePinner().check(address.url().host(), handshake.peerCertificates());
                    String selectedProtocol = configureSecureSocket.supportsTlsExtensions() ? Platform.get().getSelectedProtocol(sSLSocket) : null;
                    this.socket = sSLSocket;
                    this.source = Okio.buffer(Okio.source(sSLSocket));
                    this.sink = Okio.buffer(Okio.sink(this.socket));
                    this.handshake = handshake;
                    if (selectedProtocol != null) {
                        protocol = Protocol.get(selectedProtocol);
                    } else {
                        protocol = Protocol.HTTP_1_1;
                    }
                    this.protocol = protocol;
                    if (sSLSocket != null) {
                        Platform.get().afterHandshake(sSLSocket);
                        return;
                    }
                    return;
                }
                X509Certificate x509Certificate = (X509Certificate) handshake.peerCertificates().get(0);
                throw new SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified:\n    certificate: " + CertificatePinner.pin(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + OkHostnameVerifier.allSubjectAltNames(x509Certificate));
            } catch (AssertionError e3) {
                e = e3;
                if (!Util.isAndroidGetsocknameError(e)) {
                    throw e;
                }
                throw new IOException(e);
            } catch (Throwable th2) {
                th = th2;
                sSLSocket2 = sSLSocket;
                if (sSLSocket2 != null) {
                    Platform.get().afterHandshake(sSLSocket2);
                }
                Util.closeQuietly((Socket) sSLSocket2);
                throw th;
            }
        }
    }

    private void connectTunnel(int i2, int i3, int i4, Call call, EventListener eventListener) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), call, eventListener}) == null) {
            Request createTunnelRequest = createTunnelRequest();
            HttpUrl url = createTunnelRequest.url();
            for (int i5 = 0; i5 < 21; i5++) {
                connectSocket(i2, i3, call, eventListener);
                createTunnelRequest = createTunnel(i3, i4, createTunnelRequest, url);
                if (createTunnelRequest == null) {
                    return;
                }
                Util.closeQuietly(this.rawSocket);
                this.rawSocket = null;
                this.sink = null;
                this.source = null;
                eventListener.connectEnd(call, this.route.socketAddress(), this.route.proxy(), null);
            }
        }
    }

    private Request createTunnel(int i2, int i3, Request request, HttpUrl httpUrl) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65540, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), request, httpUrl})) != null) {
            return (Request) invokeCommon.objValue;
        }
        String str = "CONNECT " + Util.hostHeader(httpUrl, true) + " HTTP/1.1";
        while (true) {
            Http1Codec http1Codec = new Http1Codec(null, null, this.source, this.sink);
            this.source.timeout().timeout(i2, TimeUnit.MILLISECONDS);
            this.sink.timeout().timeout(i3, TimeUnit.MILLISECONDS);
            http1Codec.writeRequest(request.headers(), str);
            http1Codec.finishRequest();
            Response build = http1Codec.readResponseHeaders(false).request(request).build();
            long contentLength = HttpHeaders.contentLength(build);
            if (contentLength == -1) {
                contentLength = 0;
            }
            Source newFixedLengthSource = http1Codec.newFixedLengthSource(contentLength);
            Util.skipAll(newFixedLengthSource, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            newFixedLengthSource.close();
            int code = build.code();
            if (code == 200) {
                if (this.source.buffer().exhausted() && this.sink.buffer().exhausted()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            } else if (code == 407) {
                Request authenticate = this.route.address().proxyAuthenticator().authenticate(this.route, build);
                if (authenticate != null) {
                    if (IntentConfig.CLOSE.equalsIgnoreCase(build.header(HTTP.CONN_DIRECTIVE))) {
                        return authenticate;
                    }
                    request = authenticate;
                } else {
                    throw new IOException("Failed to authenticate with proxy");
                }
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + build.code());
            }
        }
    }

    private Request createTunnelRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) ? new Request.Builder().url(this.route.address().url()).header("Host", Util.hostHeader(this.route.address().url(), true)).header("Proxy-Connection", HTTP.CONN_KEEP_ALIVE).header("User-Agent", Version.userAgent()).build() : (Request) invokeV.objValue;
    }

    private void establishProtocol(ConnectionSpecSelector connectionSpecSelector, int i2, Call call, EventListener eventListener) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(AdIconUtil.BAIDU_LOGO_ID, this, connectionSpecSelector, i2, call, eventListener) == null) {
            if (this.route.address().sslSocketFactory() == null) {
                if (this.route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
                    this.socket = this.rawSocket;
                    this.protocol = Protocol.H2_PRIOR_KNOWLEDGE;
                    startHttp2(i2);
                    return;
                }
                this.socket = this.rawSocket;
                this.protocol = Protocol.HTTP_1_1;
                return;
            }
            eventListener.secureConnectStart(call);
            connectTls(connectionSpecSelector);
            eventListener.secureConnectEnd(call, this.handshake);
            if (this.protocol == Protocol.HTTP_2) {
                startHttp2(i2);
            }
        }
    }

    private void startHttp2(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, this, i2) == null) {
            this.socket.setSoTimeout(0);
            Http2Connection build = new Http2Connection.Builder(true).socket(this.socket, this.route.address().url().host(), this.source, this.sink).listener(this).pingIntervalMillis(i2).build();
            this.http2Connection = build;
            build.start();
        }
    }

    public static RealConnection testConnection(ConnectionPool connectionPool, Route route, Socket socket, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{connectionPool, route, socket, Long.valueOf(j)})) == null) {
            RealConnection realConnection = new RealConnection(connectionPool, route);
            realConnection.socket = socket;
            realConnection.idleAtNanos = j;
            return realConnection;
        }
        return (RealConnection) invokeCommon.objValue;
    }

    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Util.closeQuietly(this.rawSocket);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0094 A[Catch: IOException -> 0x00fd, TRY_LEAVE, TryCatch #2 {IOException -> 0x00fd, blocks: (B:20:0x008c, B:22:0x0094), top: B:75:0x008c }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f8 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0146 A[EDGE_INSN: B:82:0x0146->B:63:0x0146 ?: BREAK  ] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void connect(int i2, int i3, int i4, int i5, boolean z, Call call, EventListener eventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), call, eventListener}) == null) {
            if (this.protocol == null) {
                List<ConnectionSpec> connectionSpecs = this.route.address().connectionSpecs();
                ConnectionSpecSelector connectionSpecSelector = new ConnectionSpecSelector(connectionSpecs);
                if (this.route.address().sslSocketFactory() == null) {
                    if (connectionSpecs.contains(ConnectionSpec.CLEARTEXT)) {
                        String host = this.route.address().url().host();
                        if (!Platform.get().isCleartextTrafficPermitted(host)) {
                            throw new RouteException(new UnknownServiceException("CLEARTEXT communication to " + host + " not permitted by network security policy"));
                        }
                    } else {
                        throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
                    }
                } else if (this.route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
                    throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
                }
                RouteException routeException = null;
                do {
                    try {
                        try {
                            if (this.route.requiresTunnel()) {
                                connectTunnel(i2, i3, i4, call, eventListener);
                                if (this.rawSocket == null) {
                                    if (!this.route.requiresTunnel() && this.rawSocket == null) {
                                        throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
                                    }
                                    if (this.http2Connection == null) {
                                        synchronized (this.connectionPool) {
                                            this.allocationLimit = this.http2Connection.maxConcurrentStreams();
                                        }
                                        return;
                                    }
                                    return;
                                }
                            } else {
                                try {
                                    connectSocket(i2, i3, call, eventListener);
                                } catch (IOException e2) {
                                    e = e2;
                                    Util.closeQuietly(this.socket);
                                    Util.closeQuietly(this.rawSocket);
                                    this.socket = null;
                                    this.rawSocket = null;
                                    this.source = null;
                                    this.sink = null;
                                    this.handshake = null;
                                    this.protocol = null;
                                    this.http2Connection = null;
                                    eventListener.connectFailed(call, this.route.socketAddress(), this.route.proxy(), null, e);
                                    if (routeException != null) {
                                    }
                                    if (!z || connectionSpecSelector.connectionFailed(e)) {
                                    }
                                    do {
                                        if (this.route.requiresTunnel()) {
                                        }
                                        establishProtocol(connectionSpecSelector, i5, call, eventListener);
                                        eventListener.connectEnd(call, this.route.socketAddress(), this.route.proxy(), this.protocol);
                                        if (!this.route.requiresTunnel()) {
                                        }
                                        if (this.http2Connection == null) {
                                        }
                                    } while (connectionSpecSelector.connectionFailed(e));
                                    throw routeException;
                                }
                            }
                            establishProtocol(connectionSpecSelector, i5, call, eventListener);
                            eventListener.connectEnd(call, this.route.socketAddress(), this.route.proxy(), this.protocol);
                            if (!this.route.requiresTunnel()) {
                            }
                            if (this.http2Connection == null) {
                            }
                        } catch (IOException e3) {
                            e = e3;
                            Util.closeQuietly(this.socket);
                            Util.closeQuietly(this.rawSocket);
                            this.socket = null;
                            this.rawSocket = null;
                            this.source = null;
                            this.sink = null;
                            this.handshake = null;
                            this.protocol = null;
                            this.http2Connection = null;
                            eventListener.connectFailed(call, this.route.socketAddress(), this.route.proxy(), null, e);
                            if (routeException != null) {
                                routeException = new RouteException(e);
                            } else {
                                routeException.addConnectException(e);
                            }
                            if (!z || connectionSpecSelector.connectionFailed(e)) {
                                throw routeException;
                            }
                            do {
                                if (this.route.requiresTunnel()) {
                                }
                                establishProtocol(connectionSpecSelector, i5, call, eventListener);
                                eventListener.connectEnd(call, this.route.socketAddress(), this.route.proxy(), this.protocol);
                                if (!this.route.requiresTunnel()) {
                                }
                                if (this.http2Connection == null) {
                                }
                            } while (connectionSpecSelector.connectionFailed(e));
                            throw routeException;
                        }
                    } catch (IOException e4) {
                        e = e4;
                    }
                } while (connectionSpecSelector.connectionFailed(e));
                throw routeException;
            }
            throw new IllegalStateException("already connected");
        }
    }

    @Override // okhttp3.Connection
    public Handshake handshake() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.handshake : (Handshake) invokeV.objValue;
    }

    public boolean isEligible(Address address, @Nullable Route route) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, address, route)) == null) {
            if (this.allocations.size() >= this.allocationLimit || this.noNewStreams || !Internal.instance.equalsNonHost(this.route.address(), address)) {
                return false;
            }
            if (address.url().host().equals(route().address().url().host())) {
                return true;
            }
            if (this.http2Connection != null && route != null && route.proxy().type() == Proxy.Type.DIRECT && this.route.proxy().type() == Proxy.Type.DIRECT && this.route.socketAddress().equals(route.socketAddress()) && route.address().hostnameVerifier() == OkHostnameVerifier.INSTANCE && supportsUrl(address.url())) {
                try {
                    address.certificatePinner().check(address.url().host(), handshake().peerCertificates());
                    return true;
                } catch (SSLPeerUnverifiedException unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean isHealthy(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            if (this.socket.isClosed() || this.socket.isInputShutdown() || this.socket.isOutputShutdown()) {
                return false;
            }
            Http2Connection http2Connection = this.http2Connection;
            if (http2Connection != null) {
                return !http2Connection.isShutdown();
            }
            if (z) {
                try {
                    int soTimeout = this.socket.getSoTimeout();
                    try {
                        this.socket.setSoTimeout(1);
                        return !this.source.exhausted();
                    } finally {
                        this.socket.setSoTimeout(soTimeout);
                    }
                } catch (SocketTimeoutException unused) {
                } catch (IOException unused2) {
                    return false;
                }
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public boolean isMultiplexed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.http2Connection != null : invokeV.booleanValue;
    }

    public HttpCodec newCodec(OkHttpClient okHttpClient, Interceptor.Chain chain, StreamAllocation streamAllocation) throws SocketException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, okHttpClient, chain, streamAllocation)) == null) {
            if (this.http2Connection != null) {
                return new Http2Codec(okHttpClient, chain, streamAllocation, this.http2Connection);
            }
            this.socket.setSoTimeout(chain.readTimeoutMillis());
            this.source.timeout().timeout(chain.readTimeoutMillis(), TimeUnit.MILLISECONDS);
            this.sink.timeout().timeout(chain.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
            return new Http1Codec(okHttpClient, streamAllocation, this.source, this.sink);
        }
        return (HttpCodec) invokeLLL.objValue;
    }

    public RealWebSocket.Streams newWebSocketStreams(StreamAllocation streamAllocation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, streamAllocation)) == null) ? new RealWebSocket.Streams(this, true, this.source, this.sink, streamAllocation) { // from class: okhttp3.internal.connection.RealConnection.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RealConnection this$0;
            public final /* synthetic */ StreamAllocation val$streamAllocation;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r10, r11, r12);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Boolean.valueOf(r10), r11, r12, streamAllocation};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super(((Boolean) objArr2[0]).booleanValue(), (BufferedSource) objArr2[1], (BufferedSink) objArr2[2]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$streamAllocation = streamAllocation;
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    StreamAllocation streamAllocation2 = this.val$streamAllocation;
                    streamAllocation2.streamFinished(true, streamAllocation2.codec(), -1L, null);
                }
            }
        } : (RealWebSocket.Streams) invokeL.objValue;
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onSettings(Http2Connection http2Connection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, http2Connection) == null) {
            synchronized (this.connectionPool) {
                this.allocationLimit = http2Connection.maxConcurrentStreams();
            }
        }
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onStream(Http2Stream http2Stream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, http2Stream) == null) {
            http2Stream.close(ErrorCode.REFUSED_STREAM);
        }
    }

    @Override // okhttp3.Connection
    public Protocol protocol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.protocol : (Protocol) invokeV.objValue;
    }

    @Override // okhttp3.Connection
    public Route route() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.route : (Route) invokeV.objValue;
    }

    @Override // okhttp3.Connection
    public Socket socket() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.socket : (Socket) invokeV.objValue;
    }

    public boolean supportsUrl(HttpUrl httpUrl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, httpUrl)) == null) {
            if (httpUrl.port() != this.route.address().url().port()) {
                return false;
            }
            if (httpUrl.host().equals(this.route.address().url().host())) {
                return true;
            }
            return this.handshake != null && OkHostnameVerifier.INSTANCE.verify(httpUrl.host(), (X509Certificate) this.handshake.peerCertificates().get(0));
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Connection{");
            sb.append(this.route.address().url().host());
            sb.append(":");
            sb.append(this.route.address().url().port());
            sb.append(", proxy=");
            sb.append(this.route.proxy());
            sb.append(" hostAddress=");
            sb.append(this.route.socketAddress());
            sb.append(" cipherSuite=");
            Handshake handshake = this.handshake;
            sb.append(handshake != null ? handshake.cipherSuite() : "none");
            sb.append(" protocol=");
            sb.append(this.protocol);
            sb.append('}');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
