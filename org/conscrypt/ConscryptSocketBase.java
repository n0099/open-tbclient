package org.conscrypt;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
/* loaded from: classes7.dex */
abstract class ConscryptSocketBase extends AbstractConscryptSocket {
    private final boolean autoClose;
    private final List<HandshakeCompletedListener> listeners;
    private String peerHostname;
    private final PeerInfoProvider peerInfoProvider;
    private final int peerPort;
    private int readTimeoutMilliseconds;
    final Socket socket;

    abstract SSLSession getActiveSession();

    abstract void setApplicationProtocolSelector(ApplicationProtocolSelectorAdapter applicationProtocolSelectorAdapter);

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConscryptSocketBase() throws IOException {
        this.peerInfoProvider = new PeerInfoProvider() { // from class: org.conscrypt.ConscryptSocketBase.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostname() {
                return ConscryptSocketBase.this.getHostname();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostnameOrIP() {
                return ConscryptSocketBase.this.getHostnameOrIP();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public int getPort() {
                return ConscryptSocketBase.this.getPort();
            }
        };
        this.listeners = new ArrayList(2);
        this.socket = this;
        this.peerHostname = null;
        this.peerPort = -1;
        this.autoClose = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConscryptSocketBase(String str, int i) throws IOException {
        super(str, i);
        this.peerInfoProvider = new PeerInfoProvider() { // from class: org.conscrypt.ConscryptSocketBase.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostname() {
                return ConscryptSocketBase.this.getHostname();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostnameOrIP() {
                return ConscryptSocketBase.this.getHostnameOrIP();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public int getPort() {
                return ConscryptSocketBase.this.getPort();
            }
        };
        this.listeners = new ArrayList(2);
        this.socket = this;
        this.peerHostname = str;
        this.peerPort = i;
        this.autoClose = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConscryptSocketBase(InetAddress inetAddress, int i) throws IOException {
        super(inetAddress, i);
        this.peerInfoProvider = new PeerInfoProvider() { // from class: org.conscrypt.ConscryptSocketBase.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostname() {
                return ConscryptSocketBase.this.getHostname();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostnameOrIP() {
                return ConscryptSocketBase.this.getHostnameOrIP();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public int getPort() {
                return ConscryptSocketBase.this.getPort();
            }
        };
        this.listeners = new ArrayList(2);
        this.socket = this;
        this.peerHostname = null;
        this.peerPort = -1;
        this.autoClose = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConscryptSocketBase(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        super(str, i, inetAddress, i2);
        this.peerInfoProvider = new PeerInfoProvider() { // from class: org.conscrypt.ConscryptSocketBase.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostname() {
                return ConscryptSocketBase.this.getHostname();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostnameOrIP() {
                return ConscryptSocketBase.this.getHostnameOrIP();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public int getPort() {
                return ConscryptSocketBase.this.getPort();
            }
        };
        this.listeners = new ArrayList(2);
        this.socket = this;
        this.peerHostname = str;
        this.peerPort = i;
        this.autoClose = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConscryptSocketBase(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        super(inetAddress, i, inetAddress2, i2);
        this.peerInfoProvider = new PeerInfoProvider() { // from class: org.conscrypt.ConscryptSocketBase.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostname() {
                return ConscryptSocketBase.this.getHostname();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostnameOrIP() {
                return ConscryptSocketBase.this.getHostnameOrIP();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public int getPort() {
                return ConscryptSocketBase.this.getPort();
            }
        };
        this.listeners = new ArrayList(2);
        this.socket = this;
        this.peerHostname = null;
        this.peerPort = -1;
        this.autoClose = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConscryptSocketBase(Socket socket, String str, int i, boolean z) throws IOException {
        this.peerInfoProvider = new PeerInfoProvider() { // from class: org.conscrypt.ConscryptSocketBase.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostname() {
                return ConscryptSocketBase.this.getHostname();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostnameOrIP() {
                return ConscryptSocketBase.this.getHostnameOrIP();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public int getPort() {
                return ConscryptSocketBase.this.getPort();
            }
        };
        this.listeners = new ArrayList(2);
        this.socket = (Socket) Preconditions.checkNotNull(socket, "socket");
        this.peerHostname = str;
        this.peerPort = i;
        this.autoClose = z;
    }

    @Override // java.net.Socket
    public final void connect(SocketAddress socketAddress) throws IOException {
        connect(socketAddress, 0);
    }

    @Override // java.net.Socket
    public final void connect(SocketAddress socketAddress, int i) throws IOException {
        if (this.peerHostname == null && (socketAddress instanceof InetSocketAddress)) {
            this.peerHostname = Platform.getHostStringFromInetSocketAddress((InetSocketAddress) socketAddress);
        }
        if (isDelegating()) {
            this.socket.connect(socketAddress, i);
        } else {
            super.connect(socketAddress, i);
        }
    }

    @Override // java.net.Socket
    public void bind(SocketAddress socketAddress) throws IOException {
        if (isDelegating()) {
            this.socket.bind(socketAddress);
        } else {
            super.bind(socketAddress);
        }
    }

    @Override // java.net.Socket, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (isDelegating()) {
            if (this.autoClose && !this.socket.isClosed()) {
                this.socket.close();
            }
        } else if (!super.isClosed()) {
            super.close();
        }
    }

    @Override // java.net.Socket
    public InetAddress getInetAddress() {
        return isDelegating() ? this.socket.getInetAddress() : super.getInetAddress();
    }

    @Override // java.net.Socket
    public InetAddress getLocalAddress() {
        return isDelegating() ? this.socket.getLocalAddress() : super.getLocalAddress();
    }

    @Override // java.net.Socket
    public int getLocalPort() {
        return isDelegating() ? this.socket.getLocalPort() : super.getLocalPort();
    }

    @Override // java.net.Socket
    public SocketAddress getRemoteSocketAddress() {
        return isDelegating() ? this.socket.getRemoteSocketAddress() : super.getRemoteSocketAddress();
    }

    @Override // java.net.Socket
    public SocketAddress getLocalSocketAddress() {
        return isDelegating() ? this.socket.getLocalSocketAddress() : super.getLocalSocketAddress();
    }

    @Override // java.net.Socket
    public final int getPort() {
        if (isDelegating()) {
            return this.socket.getPort();
        }
        if (this.peerPort != -1) {
            return this.peerPort;
        }
        return super.getPort();
    }

    @Override // javax.net.ssl.SSLSocket
    public void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        Preconditions.checkArgument(handshakeCompletedListener != null, "Provided listener is null");
        this.listeners.add(handshakeCompletedListener);
    }

    @Override // javax.net.ssl.SSLSocket
    public void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        Preconditions.checkArgument(handshakeCompletedListener != null, "Provided listener is null");
        if (!this.listeners.remove(handshakeCompletedListener)) {
            throw new IllegalArgumentException("Provided listener is not registered");
        }
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public FileDescriptor getFileDescriptor$() {
        return isDelegating() ? Platform.getFileDescriptor(this.socket) : Platform.getFileDescriptorFromSSLSocket(this);
    }

    @Override // java.net.Socket
    public final void setSoTimeout(int i) throws SocketException {
        if (isDelegating()) {
            this.socket.setSoTimeout(i);
            return;
        }
        super.setSoTimeout(i);
        this.readTimeoutMilliseconds = i;
    }

    @Override // java.net.Socket
    public final int getSoTimeout() throws SocketException {
        return isDelegating() ? this.socket.getSoTimeout() : this.readTimeoutMilliseconds;
    }

    @Override // java.net.Socket
    public final void sendUrgentData(int i) throws IOException {
        throw new SocketException("Method sendUrgentData() is not supported.");
    }

    @Override // java.net.Socket
    public final void setOOBInline(boolean z) throws SocketException {
        throw new SocketException("Method setOOBInline() is not supported.");
    }

    @Override // java.net.Socket
    public boolean getOOBInline() throws SocketException {
        return false;
    }

    @Override // java.net.Socket
    public SocketChannel getChannel() {
        return null;
    }

    @Override // java.net.Socket
    public InputStream getInputStream() throws IOException {
        return isDelegating() ? this.socket.getInputStream() : super.getInputStream();
    }

    @Override // java.net.Socket
    public OutputStream getOutputStream() throws IOException {
        return isDelegating() ? this.socket.getOutputStream() : super.getOutputStream();
    }

    @Override // java.net.Socket
    public void setTcpNoDelay(boolean z) throws SocketException {
        if (isDelegating()) {
            this.socket.setTcpNoDelay(z);
        } else {
            super.setTcpNoDelay(z);
        }
    }

    @Override // java.net.Socket
    public boolean getTcpNoDelay() throws SocketException {
        return isDelegating() ? this.socket.getTcpNoDelay() : super.getTcpNoDelay();
    }

    @Override // java.net.Socket
    public void setSoLinger(boolean z, int i) throws SocketException {
        if (isDelegating()) {
            this.socket.setSoLinger(z, i);
        } else {
            super.setSoLinger(z, i);
        }
    }

    @Override // java.net.Socket
    public int getSoLinger() throws SocketException {
        return isDelegating() ? this.socket.getSoLinger() : super.getSoLinger();
    }

    @Override // java.net.Socket
    public void setSendBufferSize(int i) throws SocketException {
        if (isDelegating()) {
            this.socket.setSendBufferSize(i);
        } else {
            super.setSendBufferSize(i);
        }
    }

    @Override // java.net.Socket
    public int getSendBufferSize() throws SocketException {
        return isDelegating() ? this.socket.getSendBufferSize() : super.getSendBufferSize();
    }

    @Override // java.net.Socket
    public void setReceiveBufferSize(int i) throws SocketException {
        if (isDelegating()) {
            this.socket.setReceiveBufferSize(i);
        } else {
            super.setReceiveBufferSize(i);
        }
    }

    @Override // java.net.Socket
    public int getReceiveBufferSize() throws SocketException {
        return isDelegating() ? this.socket.getReceiveBufferSize() : super.getReceiveBufferSize();
    }

    @Override // java.net.Socket
    public void setKeepAlive(boolean z) throws SocketException {
        if (isDelegating()) {
            this.socket.setKeepAlive(z);
        } else {
            super.setKeepAlive(z);
        }
    }

    @Override // java.net.Socket
    public boolean getKeepAlive() throws SocketException {
        return isDelegating() ? this.socket.getKeepAlive() : super.getKeepAlive();
    }

    @Override // java.net.Socket
    public void setTrafficClass(int i) throws SocketException {
        if (isDelegating()) {
            this.socket.setTrafficClass(i);
        } else {
            super.setTrafficClass(i);
        }
    }

    @Override // java.net.Socket
    public int getTrafficClass() throws SocketException {
        return isDelegating() ? this.socket.getTrafficClass() : super.getTrafficClass();
    }

    @Override // java.net.Socket
    public void setReuseAddress(boolean z) throws SocketException {
        if (isDelegating()) {
            this.socket.setReuseAddress(z);
        } else {
            super.setReuseAddress(z);
        }
    }

    @Override // java.net.Socket
    public boolean getReuseAddress() throws SocketException {
        return isDelegating() ? this.socket.getReuseAddress() : super.getReuseAddress();
    }

    @Override // java.net.Socket
    public void shutdownInput() throws IOException {
        if (isDelegating()) {
            this.socket.shutdownInput();
        } else {
            super.shutdownInput();
        }
    }

    @Override // java.net.Socket
    public void shutdownOutput() throws IOException {
        if (isDelegating()) {
            this.socket.shutdownOutput();
        } else {
            super.shutdownOutput();
        }
    }

    @Override // java.net.Socket
    public boolean isConnected() {
        return isDelegating() ? this.socket.isConnected() : super.isConnected();
    }

    @Override // java.net.Socket
    public boolean isBound() {
        return isDelegating() ? this.socket.isBound() : super.isBound();
    }

    @Override // java.net.Socket
    public boolean isClosed() {
        return isDelegating() ? this.socket.isClosed() : super.isClosed();
    }

    @Override // java.net.Socket
    public boolean isInputShutdown() {
        return isDelegating() ? this.socket.isInputShutdown() : super.isInputShutdown();
    }

    @Override // java.net.Socket
    public boolean isOutputShutdown() {
        return isDelegating() ? this.socket.isOutputShutdown() : super.isOutputShutdown();
    }

    @Override // java.net.Socket
    public void setPerformancePreferences(int i, int i2, int i3) {
        if (isDelegating()) {
            this.socket.setPerformancePreferences(i, i2, i3);
        } else {
            super.setPerformancePreferences(i, i2, i3);
        }
    }

    @Override // javax.net.ssl.SSLSocket, java.net.Socket
    public String toString() {
        StringBuilder sb = new StringBuilder("SSL socket over ");
        if (isDelegating()) {
            sb.append(this.socket.toString());
        } else {
            sb.append(super.toString());
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptSocket
    public String getHostname() {
        return this.peerHostname;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptSocket
    public void setHostname(String str) {
        this.peerHostname = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptSocket
    public String getHostnameOrIP() {
        if (this.peerHostname != null) {
            return this.peerHostname;
        }
        InetAddress inetAddress = getInetAddress();
        if (inetAddress != null) {
            return Platform.getOriginalHostNameFromInetAddress(inetAddress);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptSocket
    public void setSoWriteTimeout(int i) throws SocketException {
        throw new SocketException("Method setSoWriteTimeout() is not supported.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptSocket
    public int getSoWriteTimeout() throws SocketException {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptSocket
    public void setHandshakeTimeout(int i) throws SocketException {
        throw new SocketException("Method setHandshakeTimeout() is not supported.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void checkOpen() throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptSocket
    public final PeerInfoProvider peerInfoProvider() {
        return this.peerInfoProvider;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void notifyHandshakeCompletedListeners() {
        if (this.listeners != null && !this.listeners.isEmpty()) {
            HandshakeCompletedEvent handshakeCompletedEvent = new HandshakeCompletedEvent(this, getActiveSession());
            for (HandshakeCompletedListener handshakeCompletedListener : this.listeners) {
                try {
                    handshakeCompletedListener.handshakeCompleted(handshakeCompletedEvent);
                } catch (RuntimeException e) {
                    Thread currentThread = Thread.currentThread();
                    currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, e);
                }
            }
        }
    }

    private boolean isDelegating() {
        return (this.socket == null || this.socket == this) ? false : true;
    }
}
