package org.conscrypt;

import java.io.FileDescriptor;
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.security.PrivateKey;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
/* loaded from: classes11.dex */
abstract class AbstractConscryptSocket extends SSLSocket {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte[] exportKeyingMaterial(String str, byte[] bArr, int i) throws SSLException;

    @Deprecated
    abstract byte[] getAlpnSelectedProtocol();

    @Override // javax.net.ssl.SSLSocket
    public abstract String getApplicationProtocol();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String[] getApplicationProtocols();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte[] getChannelId() throws SSLException;

    public abstract FileDescriptor getFileDescriptor$();

    @Override // javax.net.ssl.SSLSocket
    public abstract String getHandshakeApplicationProtocol();

    @Override // javax.net.ssl.SSLSocket
    public abstract SSLSession getHandshakeSession();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String getHostname();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String getHostnameOrIP();

    abstract int getSoWriteTimeout() throws SocketException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte[] getTlsUnique();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int getTokenBindingParams();

    abstract PeerInfoProvider peerInfoProvider();

    @Deprecated
    abstract void setAlpnProtocols(byte[] bArr);

    @Deprecated
    abstract void setAlpnProtocols(String[] strArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setApplicationProtocolSelector(ApplicationProtocolSelector applicationProtocolSelector);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setApplicationProtocols(String[] strArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setChannelIdEnabled(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setChannelIdPrivateKey(PrivateKey privateKey);

    abstract void setHandshakeTimeout(int i) throws SocketException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setHostname(String str);

    abstract void setSoWriteTimeout(int i) throws SocketException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setTokenBindingParams(int... iArr) throws SSLException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setUseSessionTickets(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractConscryptSocket() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractConscryptSocket(String str, int i) throws IOException {
        super(str, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractConscryptSocket(InetAddress inetAddress, int i) throws IOException {
        super(inetAddress, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractConscryptSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        super(str, i, inetAddress, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractConscryptSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        super(inetAddress, i, inetAddress2, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public byte[] getNpnSelectedProtocol() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public void setNpnProtocols(byte[] bArr) {
    }
}
