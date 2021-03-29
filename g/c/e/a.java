package g.c.e;

import com.baidu.android.imsdk.internal.Constants;
import g.c.c;
import g.c.i.d;
import g.c.i.f;
import g.c.i.h;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.NotYetConnectedException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public abstract class a extends g.c.a implements Runnable, WebSocket {
    public CountDownLatch closeLatch;
    public CountDownLatch connectLatch;
    public Thread connectReadThread;
    public int connectTimeout;
    public Draft draft;
    public c engine;
    public Map<String, String> headers;
    public OutputStream ostream;
    public Proxy proxy;
    public Socket socket;
    public URI uri;
    public Thread writeThread;

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread currentThread = Thread.currentThread();
            currentThread.setName("WebSocketWriteThread-" + Thread.currentThread().getId());
            while (true) {
                try {
                    try {
                        try {
                            if (Thread.interrupted()) {
                                break;
                            }
                            ByteBuffer take = a.this.engine.f67623e.take();
                            a.this.ostream.write(take.array(), 0, take.limit());
                            a.this.ostream.flush();
                        } catch (InterruptedException unused) {
                            for (ByteBuffer byteBuffer : a.this.engine.f67623e) {
                                a.this.ostream.write(byteBuffer.array(), 0, byteBuffer.limit());
                                a.this.ostream.flush();
                            }
                        }
                    } catch (IOException e2) {
                        a.this.handleIOException(e2);
                    }
                } finally {
                    a.this.closeSocket();
                    a.this.writeThread = null;
                }
            }
        }
    }

    public a(URI uri) {
        this(uri, new g.c.f.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeSocket() {
        try {
            if (this.socket != null) {
                this.socket.close();
            }
        } catch (IOException e2) {
            onWebsocketError(this, e2);
        }
    }

    private int getPort() {
        int port = this.uri.getPort();
        if (port == -1) {
            String scheme = this.uri.getScheme();
            if ("wss".equals(scheme)) {
                return Constants.SOCKET_PORT_SSL;
            }
            if ("ws".equals(scheme)) {
                return 80;
            }
            throw new IllegalArgumentException("unknown scheme: " + scheme);
        }
        return port;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleIOException(IOException iOException) {
        if (iOException instanceof SSLException) {
            onError(iOException);
        }
        this.engine.n();
    }

    private void reset() {
        Thread currentThread = Thread.currentThread();
        if (currentThread != this.writeThread && currentThread != this.connectReadThread) {
            try {
                closeBlocking();
                if (this.writeThread != null) {
                    this.writeThread.interrupt();
                    this.writeThread = null;
                }
                if (this.connectReadThread != null) {
                    this.connectReadThread.interrupt();
                    this.connectReadThread = null;
                }
                this.draft.s();
                if (this.socket != null) {
                    this.socket.close();
                    this.socket = null;
                }
                this.connectLatch = new CountDownLatch(1);
                this.closeLatch = new CountDownLatch(1);
                this.engine = new c(this, this.draft);
                return;
            } catch (Exception e2) {
                onError(e2);
                this.engine.f(1006, e2.getMessage());
                return;
            }
        }
        throw new IllegalStateException("You cannot initialize a reconnect out of the websocket thread. Use reconnect in another thread to insure a successful cleanup.");
    }

    private void sendHandshake() throws InvalidHandshakeException {
        String rawPath = this.uri.getRawPath();
        String rawQuery = this.uri.getRawQuery();
        rawPath = (rawPath == null || rawPath.length() == 0) ? "/" : "/";
        if (rawQuery != null) {
            rawPath = rawPath + '?' + rawQuery;
        }
        int port = getPort();
        StringBuilder sb = new StringBuilder();
        sb.append(this.uri.getHost());
        sb.append((port == 80 || port == 443) ? "" : ":" + port);
        String sb2 = sb.toString();
        d dVar = new d();
        dVar.g(rawPath);
        dVar.a("Host", sb2);
        Map<String, String> map = this.headers;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                dVar.a(entry.getKey(), entry.getValue());
            }
        }
        this.engine.M(dVar);
    }

    public void close() {
        if (this.writeThread != null) {
            this.engine.b(1000);
        }
    }

    public void closeBlocking() throws InterruptedException {
        close();
        this.closeLatch.await();
    }

    public void closeConnection(int i, String str) {
        this.engine.f(i, str);
    }

    public void connect() {
        if (this.connectReadThread == null) {
            Thread thread = new Thread(this);
            this.connectReadThread = thread;
            thread.setName("WebSocketConnectReadThread-" + this.connectReadThread.getId());
            this.connectReadThread.start();
            return;
        }
        throw new IllegalStateException("WebSocketClient objects are not reuseable");
    }

    public boolean connectBlocking() throws InterruptedException {
        connect();
        this.connectLatch.await();
        return this.engine.B();
    }

    public <T> T getAttachment() {
        return (T) this.engine.q();
    }

    public WebSocket getConnection() {
        return this.engine;
    }

    @Override // g.c.a
    public Collection<WebSocket> getConnections() {
        return Collections.singletonList(this.engine);
    }

    public Draft getDraft() {
        return this.draft;
    }

    @Override // g.c.d
    public InetSocketAddress getLocalSocketAddress(WebSocket webSocket) {
        Socket socket = this.socket;
        if (socket != null) {
            return (InetSocketAddress) socket.getLocalSocketAddress();
        }
        return null;
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.engine.t();
    }

    @Override // g.c.d
    public InetSocketAddress getRemoteSocketAddress(WebSocket webSocket) {
        Socket socket = this.socket;
        if (socket != null) {
            return (InetSocketAddress) socket.getRemoteSocketAddress();
        }
        return null;
    }

    public String getResourceDescriptor() {
        return this.uri.getPath();
    }

    public Socket getSocket() {
        return this.socket;
    }

    public URI getURI() {
        return this.uri;
    }

    public boolean hasBufferedData() {
        return this.engine.w();
    }

    public boolean isClosed() {
        return this.engine.x();
    }

    public boolean isClosing() {
        return this.engine.y();
    }

    @Deprecated
    public boolean isConnecting() {
        return this.engine.z();
    }

    public boolean isFlushAndClose() {
        return this.engine.A();
    }

    public boolean isOpen() {
        return this.engine.B();
    }

    public abstract void onClose(int i, String str, boolean z);

    public void onCloseInitiated(int i, String str) {
    }

    public void onClosing(int i, String str, boolean z) {
    }

    public abstract void onError(Exception exc);

    @Deprecated
    public void onFragment(Framedata framedata) {
    }

    public abstract void onMessage(String str);

    public void onMessage(ByteBuffer byteBuffer) {
    }

    public abstract void onOpen(h hVar);

    @Override // g.c.d
    public final void onWebsocketClose(WebSocket webSocket, int i, String str, boolean z) {
        stopConnectionLostTimer();
        Thread thread = this.writeThread;
        if (thread != null) {
            thread.interrupt();
        }
        onClose(i, str, z);
        this.connectLatch.countDown();
        this.closeLatch.countDown();
    }

    @Override // g.c.d
    public void onWebsocketCloseInitiated(WebSocket webSocket, int i, String str) {
        onCloseInitiated(i, str);
    }

    @Override // g.c.d
    public void onWebsocketClosing(WebSocket webSocket, int i, String str, boolean z) {
        onClosing(i, str, z);
    }

    @Override // g.c.d
    public final void onWebsocketError(WebSocket webSocket, Exception exc) {
        onError(exc);
    }

    @Override // g.c.d
    public final void onWebsocketMessage(WebSocket webSocket, String str) {
        onMessage(str);
    }

    @Override // g.c.b
    public void onWebsocketMessageFragment(WebSocket webSocket, Framedata framedata) {
        onFragment(framedata);
    }

    @Override // g.c.d
    public final void onWebsocketOpen(WebSocket webSocket, f fVar) {
        startConnectionLostTimer();
        onOpen((h) fVar);
        this.connectLatch.countDown();
    }

    @Override // g.c.d
    public final void onWriteDemand(WebSocket webSocket) {
    }

    public void reconnect() {
        reset();
        connect();
    }

    public boolean reconnectBlocking() throws InterruptedException {
        reset();
        return connectBlocking();
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        int read;
        try {
            if (this.socket == null) {
                this.socket = new Socket(this.proxy);
                z = true;
            } else if (this.socket.isClosed()) {
                throw new IOException();
            } else {
                z = false;
            }
            this.socket.setTcpNoDelay(isTcpNoDelay());
            this.socket.setReuseAddress(isReuseAddr());
            if (!this.socket.isBound()) {
                this.socket.connect(new InetSocketAddress(this.uri.getHost(), getPort()), this.connectTimeout);
            }
            if (z && "wss".equals(this.uri.getScheme())) {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, null);
                this.socket = sSLContext.getSocketFactory().createSocket(this.socket, this.uri.getHost(), getPort(), true);
            }
            InputStream inputStream = this.socket.getInputStream();
            this.ostream = this.socket.getOutputStream();
            sendHandshake();
            Thread thread = new Thread(new b());
            this.writeThread = thread;
            thread.start();
            byte[] bArr = new byte[c.x];
            while (!isClosing() && !isClosed() && (read = inputStream.read(bArr)) != -1) {
                try {
                    this.engine.k(ByteBuffer.wrap(bArr, 0, read));
                } catch (IOException e2) {
                    handleIOException(e2);
                } catch (RuntimeException e3) {
                    onError(e3);
                    this.engine.f(1006, e3.getMessage());
                }
            }
            this.engine.n();
            this.connectReadThread = null;
        } catch (Exception e4) {
            onWebsocketError(this.engine, e4);
            this.engine.f(-1, e4.getMessage());
        }
    }

    public void send(String str) throws NotYetConnectedException {
        this.engine.D(str);
    }

    public void sendFragmentedFrame(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        this.engine.H(opcode, byteBuffer, z);
    }

    @Override // org.java_websocket.WebSocket
    public void sendFrame(Framedata framedata) {
        this.engine.sendFrame(framedata);
    }

    public void sendPing() throws NotYetConnectedException {
        this.engine.J();
    }

    public <T> void setAttachment(T t) {
        this.engine.K(t);
    }

    public void setProxy(Proxy proxy) {
        if (proxy != null) {
            this.proxy = proxy;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void setSocket(Socket socket) {
        if (this.socket == null) {
            this.socket = socket;
            return;
        }
        throw new IllegalStateException("socket has already been set");
    }

    public a(URI uri, Draft draft) {
        this(uri, draft, null, 0);
    }

    @Override // g.c.d
    public final void onWebsocketMessage(WebSocket webSocket, ByteBuffer byteBuffer) {
        onMessage(byteBuffer);
    }

    public void send(byte[] bArr) throws NotYetConnectedException {
        this.engine.G(bArr);
    }

    public void sendFrame(Collection<Framedata> collection) {
        this.engine.I(collection);
    }

    public a(URI uri, Map<String, String> map) {
        this(uri, new g.c.f.a(), map);
    }

    public void close(int i) {
        this.engine.a();
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.engine.s();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.engine.u();
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, NotYetConnectedException {
        this.engine.E(byteBuffer);
    }

    public a(URI uri, Draft draft, Map<String, String> map) {
        this(uri, draft, map, 0);
    }

    public void close(int i, String str) {
        this.engine.c(i, str);
    }

    public boolean connectBlocking(long j, TimeUnit timeUnit) throws InterruptedException {
        connect();
        return this.connectLatch.await(j, timeUnit) && this.engine.B();
    }

    public a(URI uri, Draft draft, Map<String, String> map, int i) {
        this.uri = null;
        this.engine = null;
        this.socket = null;
        this.proxy = Proxy.NO_PROXY;
        this.connectLatch = new CountDownLatch(1);
        this.closeLatch = new CountDownLatch(1);
        this.connectTimeout = 0;
        if (uri == null) {
            throw new IllegalArgumentException();
        }
        if (draft != null) {
            this.uri = uri;
            this.draft = draft;
            this.headers = map;
            this.connectTimeout = i;
            setTcpNoDelay(false);
            setReuseAddr(false);
            this.engine = new c(this, draft);
            return;
        }
        throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
    }
}
