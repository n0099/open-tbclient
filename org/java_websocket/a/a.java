package org.java_websocket.a;

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
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import org.java_websocket.WebSocket;
import org.java_websocket.c;
import org.java_websocket.c.b;
import org.java_websocket.c.d;
import org.java_websocket.c.f;
import org.java_websocket.c.h;
import org.java_websocket.drafts.Draft;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public abstract class a extends org.java_websocket.a implements Runnable, WebSocket {
    private CountDownLatch closeLatch;
    private CountDownLatch connectLatch;
    private int connectTimeout;
    private Draft draft;
    private c engine;
    private Map<String, String> headers;
    private OutputStream ostream;
    private Proxy proxy;
    private Socket socket;
    protected URI uri;
    private Thread writeThread;

    public abstract void onClose(int i, String str, boolean z);

    public abstract void onError(Exception exc);

    public abstract void onMessage(String str);

    public abstract void onOpen(h hVar);

    public a(URI uri) {
        this(uri, new org.java_websocket.drafts.a());
    }

    public a(URI uri, Draft draft) {
        this(uri, draft, null, 0);
    }

    public a(URI uri, Map<String, String> map) {
        this(uri, new org.java_websocket.drafts.a(), map);
    }

    public a(URI uri, Draft draft, Map<String, String> map) {
        this(uri, draft, map, 0);
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
        if (draft == null) {
            throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
        }
        this.uri = uri;
        this.draft = draft;
        this.headers = map;
        this.connectTimeout = i;
        setTcpNoDelay(false);
        setReuseAddr(false);
        this.engine = new c(this, draft);
    }

    public URI getURI() {
        return this.uri;
    }

    public Draft getDraft() {
        return this.draft;
    }

    public Socket getSocket() {
        return this.socket;
    }

    public void reconnect() {
        reset();
        connect();
    }

    public boolean reconnectBlocking() throws InterruptedException {
        reset();
        return connectBlocking();
    }

    private void reset() {
        try {
            closeBlocking();
            if (this.writeThread != null) {
                this.writeThread.interrupt();
                this.writeThread = null;
            }
            this.draft.reset();
            if (this.socket != null) {
                this.socket.close();
                this.socket = null;
            }
            this.connectLatch = new CountDownLatch(1);
            this.closeLatch = new CountDownLatch(1);
            this.engine = new c(this, this.draft);
        } catch (Exception e) {
            onError(e);
            this.engine.closeConnection(1006, e.getMessage());
        }
    }

    public void connect() {
        if (this.writeThread != null) {
            throw new IllegalStateException("WebSocketClient objects are not reuseable");
        }
        this.writeThread = new Thread(this);
        this.writeThread.setName("WebSocketConnectReadThread-" + this.writeThread.getId());
        this.writeThread.start();
    }

    public boolean connectBlocking() throws InterruptedException {
        connect();
        this.connectLatch.await();
        return this.engine.isOpen();
    }

    public void close() {
        if (this.writeThread != null) {
            this.engine.close(1000);
        }
    }

    public void closeBlocking() throws InterruptedException {
        close();
        this.closeLatch.await();
    }

    public void send(String str) throws NotYetConnectedException {
        this.engine.send(str);
    }

    public void send(byte[] bArr) throws NotYetConnectedException {
        this.engine.send(bArr);
    }

    public <T> T getAttachment() {
        return (T) this.engine.getAttachment();
    }

    public <T> void setAttachment(T t) {
        this.engine.setAttachment(t);
    }

    @Override // org.java_websocket.a
    protected Collection<WebSocket> getConnections() {
        return Collections.singletonList(this.engine);
    }

    public void sendPing() throws NotYetConnectedException {
        this.engine.sendPing();
    }

    @Override // java.lang.Runnable
    public void run() {
        int read;
        boolean z = true;
        try {
            if (this.socket == null) {
                this.socket = new Socket(this.proxy);
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
            this.writeThread = new Thread(new RunnableC0389a());
            this.writeThread.start();
            byte[] bArr = new byte[c.isx];
            while (!isClosing() && !isClosed() && (read = inputStream.read(bArr)) != -1) {
                try {
                    this.engine.k(ByteBuffer.wrap(bArr, 0, read));
                } catch (IOException e) {
                    handleIOException(e);
                    return;
                } catch (RuntimeException e2) {
                    onError(e2);
                    this.engine.closeConnection(1006, e2.getMessage());
                    return;
                }
            }
            this.engine.cad();
        } catch (Exception e3) {
            onWebsocketError(this.engine, e3);
            this.engine.closeConnection(-1, e3.getMessage());
        }
    }

    private int getPort() {
        int port = this.uri.getPort();
        if (port == -1) {
            String scheme = this.uri.getScheme();
            if ("wss".equals(scheme)) {
                return 443;
            }
            if ("ws".equals(scheme)) {
                return 80;
            }
            throw new IllegalArgumentException("unknown scheme: " + scheme);
        }
        return port;
    }

    private void sendHandshake() throws InvalidHandshakeException {
        int port;
        String rawPath = this.uri.getRawPath();
        String rawQuery = this.uri.getRawQuery();
        rawPath = (rawPath == null || rawPath.length() == 0) ? "/" : "/";
        if (rawQuery != null) {
            rawPath = rawPath + '?' + rawQuery;
        }
        d dVar = new d();
        dVar.zh(rawPath);
        dVar.put("Host", this.uri.getHost() + (getPort() != 80 ? ":" + port : ""));
        if (this.headers != null) {
            for (Map.Entry<String, String> entry : this.headers.entrySet()) {
                dVar.put(entry.getKey(), entry.getValue());
            }
        }
        this.engine.a((b) dVar);
    }

    public WebSocket.READYSTATE getReadyState() {
        return this.engine.getReadyState();
    }

    @Override // org.java_websocket.d
    public final void onWebsocketMessage(WebSocket webSocket, String str) {
        onMessage(str);
    }

    @Override // org.java_websocket.d
    public final void onWebsocketMessage(WebSocket webSocket, ByteBuffer byteBuffer) {
        onMessage(byteBuffer);
    }

    @Override // org.java_websocket.b
    public void onWebsocketMessageFragment(WebSocket webSocket, Framedata framedata) {
        onFragment(framedata);
    }

    @Override // org.java_websocket.d
    public final void onWebsocketOpen(WebSocket webSocket, f fVar) {
        startConnectionLostTimer();
        onOpen((h) fVar);
        this.connectLatch.countDown();
    }

    @Override // org.java_websocket.d
    public final void onWebsocketClose(WebSocket webSocket, int i, String str, boolean z) {
        stopConnectionLostTimer();
        if (this.writeThread != null) {
            this.writeThread.interrupt();
        }
        onClose(i, str, z);
        this.connectLatch.countDown();
        this.closeLatch.countDown();
    }

    @Override // org.java_websocket.d
    public final void onWebsocketError(WebSocket webSocket, Exception exc) {
        onError(exc);
    }

    @Override // org.java_websocket.d
    public final void onWriteDemand(WebSocket webSocket) {
    }

    @Override // org.java_websocket.d
    public void onWebsocketCloseInitiated(WebSocket webSocket, int i, String str) {
        onCloseInitiated(i, str);
    }

    @Override // org.java_websocket.d
    public void onWebsocketClosing(WebSocket webSocket, int i, String str, boolean z) {
        onClosing(i, str, z);
    }

    public void onCloseInitiated(int i, String str) {
    }

    public void onClosing(int i, String str, boolean z) {
    }

    public WebSocket getConnection() {
        return this.engine;
    }

    @Override // org.java_websocket.d
    public InetSocketAddress getLocalSocketAddress(WebSocket webSocket) {
        if (this.socket != null) {
            return (InetSocketAddress) this.socket.getLocalSocketAddress();
        }
        return null;
    }

    @Override // org.java_websocket.d
    public InetSocketAddress getRemoteSocketAddress(WebSocket webSocket) {
        if (this.socket != null) {
            return (InetSocketAddress) this.socket.getRemoteSocketAddress();
        }
        return null;
    }

    public void onMessage(ByteBuffer byteBuffer) {
    }

    @Deprecated
    public void onFragment(Framedata framedata) {
    }

    /* renamed from: org.java_websocket.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class RunnableC0389a implements Runnable {
        private RunnableC0389a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("WebSocketWriteThread-" + Thread.currentThread().getId());
            while (!Thread.interrupted()) {
                try {
                    try {
                        ByteBuffer take = a.this.engine.isy.take();
                        a.this.ostream.write(take.array(), 0, take.limit());
                        a.this.ostream.flush();
                    } catch (InterruptedException e) {
                        for (ByteBuffer byteBuffer : a.this.engine.isy) {
                            a.this.ostream.write(byteBuffer.array(), 0, byteBuffer.limit());
                            a.this.ostream.flush();
                        }
                    }
                } catch (IOException e2) {
                    a.this.handleIOException(e2);
                    return;
                } finally {
                    a.this.closeSocket();
                    a.this.writeThread = null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeSocket() {
        try {
            if (this.socket != null) {
                this.socket.close();
            }
        } catch (IOException e) {
            onWebsocketError(this, e);
        }
    }

    public void setProxy(Proxy proxy) {
        if (proxy == null) {
            throw new IllegalArgumentException();
        }
        this.proxy = proxy;
    }

    public void setSocket(Socket socket) {
        if (this.socket != null) {
            throw new IllegalStateException("socket has already been set");
        }
        this.socket = socket;
    }

    public void sendFragmentedFrame(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        this.engine.sendFragmentedFrame(opcode, byteBuffer, z);
    }

    public boolean isOpen() {
        return this.engine.isOpen();
    }

    public boolean isFlushAndClose() {
        return this.engine.isFlushAndClose();
    }

    public boolean isClosed() {
        return this.engine.isClosed();
    }

    public boolean isClosing() {
        return this.engine.isClosing();
    }

    public boolean isConnecting() {
        return this.engine.isConnecting();
    }

    public boolean hasBufferedData() {
        return this.engine.hasBufferedData();
    }

    public void close(int i) {
        this.engine.close();
    }

    public void close(int i, String str) {
        this.engine.close(i, str);
    }

    public void closeConnection(int i, String str) {
        this.engine.closeConnection(i, str);
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, NotYetConnectedException {
        this.engine.send(byteBuffer);
    }

    @Override // org.java_websocket.WebSocket
    public void sendFrame(Framedata framedata) {
        this.engine.sendFrame(framedata);
    }

    public void sendFrame(Collection<Framedata> collection) {
        this.engine.sendFrame(collection);
    }

    public InetSocketAddress getLocalSocketAddress() {
        return this.engine.getLocalSocketAddress();
    }

    public InetSocketAddress getRemoteSocketAddress() {
        return this.engine.getRemoteSocketAddress();
    }

    public String getResourceDescriptor() {
        return this.uri.getPath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleIOException(IOException iOException) {
        if (iOException instanceof SSLException) {
            onError(iOException);
        }
        this.engine.cad();
    }
}
