package org.conscrypt;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes12.dex */
final class OpenSSLSocketFactoryImpl extends SSLSocketFactory {
    private static boolean useEngineSocketByDefault = SSLUtils.USE_ENGINE_SOCKET_BY_DEFAULT;
    private final IOException instantiationException;
    private final SSLParametersImpl sslParameters;
    private boolean useEngineSocket;

    OpenSSLSocketFactoryImpl() {
        SSLParametersImpl sSLParametersImpl;
        IOException iOException = null;
        this.useEngineSocket = useEngineSocketByDefault;
        try {
            sSLParametersImpl = SSLParametersImpl.getDefault();
        } catch (KeyManagementException e) {
            sSLParametersImpl = null;
            iOException = new IOException("Delayed instantiation exception:", e);
        }
        this.sslParameters = sSLParametersImpl;
        this.instantiationException = iOException;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLSocketFactoryImpl(SSLParametersImpl sSLParametersImpl) {
        this.useEngineSocket = useEngineSocketByDefault;
        this.sslParameters = sSLParametersImpl;
        this.instantiationException = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setUseEngineSocketByDefault(boolean z) {
        useEngineSocketByDefault = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUseEngineSocket(boolean z) {
        this.useEngineSocket = z;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.sslParameters.getEnabledCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return NativeCrypto.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        if (this.instantiationException != null) {
            throw this.instantiationException;
        }
        return this.useEngineSocket ? Platform.createEngineSocket((SSLParametersImpl) this.sslParameters.clone()) : Platform.createFileDescriptorSocket((SSLParametersImpl) this.sslParameters.clone());
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        if (this.useEngineSocket) {
            return Platform.createEngineSocket(str, i, (SSLParametersImpl) this.sslParameters.clone());
        }
        return Platform.createFileDescriptorSocket(str, i, (SSLParametersImpl) this.sslParameters.clone());
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        if (this.useEngineSocket) {
            return Platform.createEngineSocket(str, i, inetAddress, i2, (SSLParametersImpl) this.sslParameters.clone());
        }
        return Platform.createFileDescriptorSocket(str, i, inetAddress, i2, (SSLParametersImpl) this.sslParameters.clone());
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        if (this.useEngineSocket) {
            return Platform.createEngineSocket(inetAddress, i, (SSLParametersImpl) this.sslParameters.clone());
        }
        return Platform.createFileDescriptorSocket(inetAddress, i, (SSLParametersImpl) this.sslParameters.clone());
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        if (this.useEngineSocket) {
            return Platform.createEngineSocket(inetAddress, i, inetAddress2, i2, (SSLParametersImpl) this.sslParameters.clone());
        }
        return Platform.createFileDescriptorSocket(inetAddress, i, inetAddress2, i2, (SSLParametersImpl) this.sslParameters.clone());
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        Preconditions.checkNotNull(socket, "socket");
        if (!socket.isConnected()) {
            throw new SocketException("Socket is not connected.");
        }
        if (!this.useEngineSocket && hasFileDescriptor(socket)) {
            return Platform.createFileDescriptorSocket(socket, str, i, z, (SSLParametersImpl) this.sslParameters.clone());
        }
        return Platform.createEngineSocket(socket, str, i, z, (SSLParametersImpl) this.sslParameters.clone());
    }

    private boolean hasFileDescriptor(Socket socket) {
        try {
            Platform.getFileDescriptor(socket);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }
}
