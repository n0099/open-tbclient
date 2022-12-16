package okhttp3.internal.connection;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
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
import org.apache.http.auth.AUTH;
import org.apache.http.protocol.HTTP;
/* loaded from: classes9.dex */
public final class RealConnection extends Http2Connection.Listener implements Connection {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CONNECT_STATE_FAIL = 1;
    public static final int CONNECT_STATE_PENDING = 2;
    public static final int CONNECT_STATE_SUCCESS = 0;
    public static final int MAX_TUNNEL_ATTEMPTS = 21;
    public static final String NPE_THROW_WITH_NULL = "throw with null exception";
    public transient /* synthetic */ FieldHolder $fh;
    public int addressIndex;
    public int allocationLimit;
    public final List<Reference<StreamAllocation>> allocations;
    public ConnectComplete connectCompleteCallback;
    public final ConnectionPool connectionPool;
    public Handshake handshake;
    public Http2Connection http2Connection;
    public long idleAtNanos;
    public boolean isFallbackConn;
    public boolean isMultiConnectTriggered;
    public boolean noNewStreams;
    public Protocol protocol;
    public Socket rawSocket;
    public final Route route;
    public List<Route> routeList;
    public BufferedSink sink;
    public Socket socket;
    public BufferedSource source;
    public int successCount;

    /* loaded from: classes9.dex */
    public interface ConnectComplete {
        void receiveConnectState(int i);
    }

    public RealConnection(ConnectionPool connectionPool, Route route) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {connectionPool, route};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.allocationLimit = 1;
        this.allocations = new ArrayList();
        this.idleAtNanos = Long.MAX_VALUE;
        this.isFallbackConn = false;
        this.addressIndex = -1;
        this.isMultiConnectTriggered = false;
        this.connectionPool = connectionPool;
        this.route = route;
    }

    private void connectSocket(int i, int i2, Call call, EventListener eventListener) throws IOException {
        Socket createSocket;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), call, eventListener}) == null) {
            Proxy proxy = this.route.proxy();
            Address address = this.route.address();
            if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.HTTP) {
                createSocket = new Socket(proxy);
            } else {
                createSocket = address.socketFactory().createSocket();
            }
            this.rawSocket = createSocket;
            eventListener.connectStart(call, this.route.socketAddress(), proxy);
            ConnectComplete connectComplete = this.connectCompleteCallback;
            if (connectComplete != null) {
                connectComplete.receiveConnectState(2);
            }
            this.rawSocket.setSoTimeout(i2);
            try {
                Platform.get().connectSocket(this.rawSocket, this.route.socketAddress(), i);
                try {
                    this.source = Okio.buffer(Okio.source(this.rawSocket));
                    this.sink = Okio.buffer(Okio.sink(this.rawSocket));
                } catch (NullPointerException e) {
                    if (!NPE_THROW_WITH_NULL.equals(e.getMessage())) {
                        return;
                    }
                    throw new IOException(e);
                }
            } catch (ConnectException e2) {
                ConnectException connectException = new ConnectException("Failed to connect to " + this.route.socketAddress());
                connectException.initCause(e2);
                throw connectException;
            }
        }
    }

    private Request createTunnel(int i, int i2, Request request, HttpUrl httpUrl) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), request, httpUrl})) == null) {
            String str = "CONNECT " + Util.hostHeader(httpUrl, true) + " HTTP/1.1";
            while (true) {
                Http1Codec http1Codec = new Http1Codec(null, null, this.source, this.sink);
                this.source.timeout().timeout(i, TimeUnit.MILLISECONDS);
                this.sink.timeout().timeout(i2, TimeUnit.MILLISECONDS);
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
                if (code != 200) {
                    if (code == 407) {
                        Request authenticate = this.route.address().proxyAuthenticator().authenticate(this.route, build);
                        if (authenticate != null) {
                            if ("close".equalsIgnoreCase(build.header(HTTP.CONN_DIRECTIVE))) {
                                return authenticate;
                            }
                            request = authenticate;
                        } else {
                            throw new IOException("Failed to authenticate with proxy");
                        }
                    } else {
                        throw new IOException("Unexpected response code for CONNECT: " + build.code());
                    }
                } else if (this.source.buffer().exhausted() && this.sink.buffer().exhausted()) {
                    return null;
                } else {
                    throw new IOException("TLS tunnel buffered too many bytes!");
                }
            }
        } else {
            return (Request) invokeCommon.objValue;
        }
    }

    private void connectTls(ConnectionSpecSelector connectionSpecSelector) throws IOException {
        SSLSocket sSLSocket;
        Protocol protocol;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, connectionSpecSelector) == null) {
            Address address = this.route.address();
            SSLSocket sSLSocket2 = null;
            String str = null;
            try {
                try {
                    sSLSocket = (SSLSocket) address.sslSocketFactory().createSocket(this.rawSocket, address.url().host(), address.url().port(), true);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (AssertionError e) {
                e = e;
            }
            try {
                ConnectionSpec configureSecureSocket = connectionSpecSelector.configureSecureSocket(sSLSocket);
                if (configureSecureSocket.supportsTlsExtensions()) {
                    Platform.get().configureTlsExtensions(sSLSocket, address.url().host(), address.protocols());
                }
                sSLSocket.startHandshake();
                SSLSession session = sSLSocket.getSession();
                if (isValid(session)) {
                    Handshake handshake = Handshake.get(session);
                    if (!address.hostnameVerifier().verify(address.url().host(), session)) {
                        List<Certificate> peerCertificates = handshake.peerCertificates();
                        if (!peerCertificates.isEmpty()) {
                            X509Certificate x509Certificate = (X509Certificate) peerCertificates.get(0);
                            throw new SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified:\n    certificate: " + CertificatePinner.pin(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + OkHostnameVerifier.allSubjectAltNames(x509Certificate));
                        }
                        throw new SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified, no certificates provided");
                    }
                    address.certificatePinner().check(address.url().host(), handshake.peerCertificates());
                    if (configureSecureSocket.supportsTlsExtensions()) {
                        str = Platform.get().getSelectedProtocol(sSLSocket);
                    }
                    this.socket = sSLSocket;
                    this.source = Okio.buffer(Okio.source(sSLSocket));
                    this.sink = Okio.buffer(Okio.sink(this.socket));
                    this.handshake = handshake;
                    if (str != null) {
                        protocol = Protocol.get(str);
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
                throw new IOException("a valid ssl session was not established");
            } catch (AssertionError e2) {
                e = e2;
                if (Util.isAndroidGetsocknameError(e)) {
                    throw new IOException(e);
                }
                throw e;
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

    private void connectTunnel(int i, int i2, int i3, Call call, EventListener eventListener) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), call, eventListener}) == null) {
            Request createTunnelRequest = createTunnelRequest();
            HttpUrl url = createTunnelRequest.url();
            for (int i4 = 0; i4 < 21; i4++) {
                connectSocket(i, i2, call, eventListener);
                createTunnelRequest = createTunnel(i2, i3, createTunnelRequest, url);
                if (createTunnelRequest != null) {
                    Util.closeQuietly(this.rawSocket);
                    this.rawSocket = null;
                    this.sink = null;
                    this.source = null;
                    eventListener.connectEnd(call, this.route.socketAddress(), this.route.proxy(), null);
                } else {
                    return;
                }
            }
        }
    }

    private Request createTunnelRequest() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            Request build = new Request.Builder().url(this.route.address().url()).method("CONNECT", null).header("Host", Util.hostHeader(this.route.address().url(), true)).header("Proxy-Connection", HTTP.CONN_KEEP_ALIVE).header("User-Agent", Version.userAgent()).build();
            Request authenticate = this.route.address().proxyAuthenticator().authenticate(this.route, new Response.Builder().request(build).protocol(Protocol.HTTP_1_1).code(407).message("Preemptive Authenticate").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(-1L).header(AUTH.PROXY_AUTH, "OkHttp-Preemptive").build());
            if (authenticate != null) {
                return authenticate;
            }
            return build;
        }
        return (Request) invokeV.objValue;
    }

    private void establishProtocol(ConnectionSpecSelector connectionSpecSelector, int i, Call call, EventListener eventListener) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65542, this, connectionSpecSelector, i, call, eventListener) == null) {
            if (this.route.address().sslSocketFactory() == null) {
                if (this.route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
                    this.socket = this.rawSocket;
                    this.protocol = Protocol.H2_PRIOR_KNOWLEDGE;
                    startHttp2(i);
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
                startHttp2(i);
            }
        }
    }

    private boolean isValid(SSLSession sSLSession) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, sSLSession)) == null) {
            if (!HlsPlaylistParser.METHOD_NONE.equals(sSLSession.getProtocol()) && !"SSL_NULL_WITH_NULL_NULL".equals(sSLSession.getCipherSuite())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public RealWebSocket.Streams newWebSocketStreams(StreamAllocation streamAllocation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, streamAllocation)) == null) {
            return new RealWebSocket.Streams(this, true, this.source, this.sink, streamAllocation) { // from class: okhttp3.internal.connection.RealConnection.1
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
            };
        }
        return (RealWebSocket.Streams) invokeL.objValue;
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

    public void setConnectCompleteCallback(ConnectComplete connectComplete) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, connectComplete) == null) {
            this.connectCompleteCallback = connectComplete;
        }
    }

    private void startHttp2(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i) == null) {
            this.socket.setSoTimeout(0);
            Http2Connection build = new Http2Connection.Builder(true).socket(this.socket, this.route.address().url().host(), this.source, this.sink).listener(this).pingIntervalMillis(i).build();
            this.http2Connection = build;
            build.start();
        }
    }

    public static RealConnection testConnection(ConnectionPool connectionPool, Route route, Socket socket, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{connectionPool, route, socket, Long.valueOf(j)})) == null) {
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

    @Override // okhttp3.Connection
    public Handshake handshake() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.handshake;
        }
        return (Handshake) invokeV.objValue;
    }

    public boolean isMultiplexed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.http2Connection != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // okhttp3.Connection
    public Protocol protocol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.protocol;
        }
        return (Protocol) invokeV.objValue;
    }

    @Override // okhttp3.Connection
    public Route route() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.route;
        }
        return (Route) invokeV.objValue;
    }

    @Override // okhttp3.Connection
    public Socket socket() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.socket;
        }
        return (Socket) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0094 A[Catch: IOException -> 0x0107, TRY_LEAVE, TryCatch #0 {IOException -> 0x0107, blocks: (B:20:0x008c, B:22:0x0094), top: B:75:0x008c }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ce A[Catch: IOException -> 0x0103, TRY_LEAVE, TryCatch #2 {IOException -> 0x0103, blocks: (B:29:0x00b6, B:31:0x00ce), top: B:79:0x00b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0102 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0158 A[EDGE_INSN: B:84:0x0158->B:67:0x0158 ?: BREAK  ] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00d4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void connect(int i, int i2, int i3, int i4, boolean z, Call call, EventListener eventListener) {
        ConnectComplete connectComplete;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), call, eventListener}) == null) {
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
                    } catch (IOException e) {
                        e = e;
                    }
                    try {
                        if (this.route.requiresTunnel()) {
                            connectTunnel(i, i2, i3, call, eventListener);
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
                                connectSocket(i, i2, call, eventListener);
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
                                connectComplete = this.connectCompleteCallback;
                                if (connectComplete != null) {
                                    connectComplete.receiveConnectState(1);
                                }
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
                                    establishProtocol(connectionSpecSelector, i4, call, eventListener);
                                    eventListener.connectEnd(call, this.route.socketAddress(), this.route.proxy(), this.protocol);
                                    if (this.connectCompleteCallback != null) {
                                    }
                                    if (!this.route.requiresTunnel()) {
                                    }
                                    if (this.http2Connection == null) {
                                    }
                                } while (connectionSpecSelector.connectionFailed(e));
                                throw routeException;
                            }
                        }
                        establishProtocol(connectionSpecSelector, i4, call, eventListener);
                        eventListener.connectEnd(call, this.route.socketAddress(), this.route.proxy(), this.protocol);
                        if (this.connectCompleteCallback != null) {
                            this.connectCompleteCallback.receiveConnectState(0);
                        }
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
                        connectComplete = this.connectCompleteCallback;
                        if (connectComplete != null) {
                        }
                        if (routeException != null) {
                        }
                        if (!z || connectionSpecSelector.connectionFailed(e)) {
                        }
                        do {
                            if (this.route.requiresTunnel()) {
                            }
                            establishProtocol(connectionSpecSelector, i4, call, eventListener);
                            eventListener.connectEnd(call, this.route.socketAddress(), this.route.proxy(), this.protocol);
                            if (this.connectCompleteCallback != null) {
                            }
                            if (!this.route.requiresTunnel()) {
                            }
                            if (this.http2Connection == null) {
                            }
                        } while (connectionSpecSelector.connectionFailed(e));
                        throw routeException;
                    }
                } while (connectionSpecSelector.connectionFailed(e));
                throw routeException;
            }
            throw new IllegalStateException("already connected");
        }
    }

    public boolean isEligible(Address address, @Nullable Route route, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048579, this, address, route, i)) == null) {
            if (this.allocations.size() >= this.allocationLimit || this.noNewStreams || !Internal.instance.equalsNonHost(this.route.address(), address)) {
                return false;
            }
            if (address.url().host().equals(route().address().url().host()) && (i < 1 || isMultiplexed() || this.connectionPool.connectionsCount(address.url().host(), false) >= i)) {
                return true;
            }
            if (this.http2Connection == null || route == null || route.proxy().type() != Proxy.Type.DIRECT || this.route.proxy().type() != Proxy.Type.DIRECT || !this.route.socketAddress().equals(route.socketAddress()) || route.address().hostnameVerifier() != OkHostnameVerifier.INSTANCE || !supportsUrl(address.url())) {
                return false;
            }
            try {
                address.certificatePinner().check(address.url().host(), handshake().peerCertificates());
                return true;
            } catch (SSLPeerUnverifiedException unused) {
                return false;
            }
        }
        return invokeLLI.booleanValue;
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
                return http2Connection.isHealthy(System.nanoTime());
            }
            if (z) {
                try {
                    int soTimeout = this.socket.getSoTimeout();
                    this.socket.setSoTimeout(1);
                    if (this.source.exhausted()) {
                        this.socket.setSoTimeout(soTimeout);
                        return false;
                    }
                    this.socket.setSoTimeout(soTimeout);
                    return true;
                } catch (SocketTimeoutException unused) {
                } catch (IOException unused2) {
                    return false;
                }
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public boolean supportsUrl(HttpUrl httpUrl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, httpUrl)) == null) {
            if (httpUrl.port() != this.route.address().url().port()) {
                return false;
            }
            if (httpUrl.host().equals(this.route.address().url().host())) {
                return true;
            }
            if (this.handshake == null || !OkHostnameVerifier.INSTANCE.verify(httpUrl.host(), (X509Certificate) this.handshake.peerCertificates().get(0))) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
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

    public String toString() {
        InterceptResult invokeV;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
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
            if (handshake != null) {
                obj = handshake.cipherSuite();
            } else {
                obj = "none";
            }
            sb.append(obj);
            sb.append(" protocol=");
            sb.append(this.protocol);
            sb.append('}');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
