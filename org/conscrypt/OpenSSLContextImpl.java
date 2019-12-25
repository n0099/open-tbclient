package org.conscrypt;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContextSpi;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
/* loaded from: classes4.dex */
public abstract class OpenSSLContextImpl extends SSLContextSpi {
    private static DefaultSSLContextImpl defaultSslContextImpl;
    private final String[] algorithms;
    private final ClientSessionContext clientSessionContext;
    private final ServerSessionContext serverSessionContext;
    SSLParametersImpl sslParameters;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OpenSSLContextImpl getPreferred() {
        return new TLSv12();
    }

    OpenSSLContextImpl(String[] strArr) {
        this.algorithms = strArr;
        this.clientSessionContext = new ClientSessionContext();
        this.serverSessionContext = new ServerSessionContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLContextImpl() throws GeneralSecurityException, IOException {
        synchronized (DefaultSSLContextImpl.class) {
            this.algorithms = null;
            if (defaultSslContextImpl == null) {
                this.clientSessionContext = new ClientSessionContext();
                this.serverSessionContext = new ServerSessionContext();
                defaultSslContextImpl = (DefaultSSLContextImpl) this;
            } else {
                this.clientSessionContext = defaultSslContextImpl.engineGetClientSessionContext();
                this.serverSessionContext = defaultSslContextImpl.engineGetServerSessionContext();
            }
            this.sslParameters = new SSLParametersImpl(defaultSslContextImpl.getKeyManagers(), defaultSslContextImpl.getTrustManagers(), null, this.clientSessionContext, this.serverSessionContext, this.algorithms);
        }
    }

    @Override // javax.net.ssl.SSLContextSpi
    public void engineInit(KeyManager[] keyManagerArr, TrustManager[] trustManagerArr, SecureRandom secureRandom) throws KeyManagementException {
        this.sslParameters = new SSLParametersImpl(keyManagerArr, trustManagerArr, secureRandom, this.clientSessionContext, this.serverSessionContext, this.algorithms);
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLSocketFactory engineGetSocketFactory() {
        if (this.sslParameters == null) {
            throw new IllegalStateException("SSLContext is not initialized.");
        }
        return Platform.wrapSocketFactoryIfNeeded(new OpenSSLSocketFactoryImpl(this.sslParameters));
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLServerSocketFactory engineGetServerSocketFactory() {
        if (this.sslParameters == null) {
            throw new IllegalStateException("SSLContext is not initialized.");
        }
        return new OpenSSLServerSocketFactoryImpl(this.sslParameters);
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLEngine engineCreateSSLEngine(String str, int i) {
        if (this.sslParameters == null) {
            throw new IllegalStateException("SSLContext is not initialized.");
        }
        SSLParametersImpl sSLParametersImpl = (SSLParametersImpl) this.sslParameters.clone();
        sSLParametersImpl.setUseClientMode(false);
        return Platform.wrapEngine(new ConscryptEngine(str, i, sSLParametersImpl));
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLEngine engineCreateSSLEngine() {
        if (this.sslParameters == null) {
            throw new IllegalStateException("SSLContext is not initialized.");
        }
        SSLParametersImpl sSLParametersImpl = (SSLParametersImpl) this.sslParameters.clone();
        sSLParametersImpl.setUseClientMode(false);
        return Platform.wrapEngine(new ConscryptEngine(sSLParametersImpl));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // javax.net.ssl.SSLContextSpi
    public ServerSessionContext engineGetServerSessionContext() {
        return this.serverSessionContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // javax.net.ssl.SSLContextSpi
    public ClientSessionContext engineGetClientSessionContext() {
        return this.clientSessionContext;
    }

    /* loaded from: classes4.dex */
    public static final class TLSv12 extends OpenSSLContextImpl {
        @Override // org.conscrypt.OpenSSLContextImpl, javax.net.ssl.SSLContextSpi
        public /* bridge */ /* synthetic */ SSLSessionContext engineGetClientSessionContext() {
            return super.engineGetClientSessionContext();
        }

        @Override // org.conscrypt.OpenSSLContextImpl, javax.net.ssl.SSLContextSpi
        public /* bridge */ /* synthetic */ SSLSessionContext engineGetServerSessionContext() {
            return super.engineGetServerSessionContext();
        }

        public TLSv12() {
            super(NativeCrypto.TLSV12_PROTOCOLS);
        }
    }

    /* loaded from: classes4.dex */
    public static final class TLSv11 extends OpenSSLContextImpl {
        @Override // org.conscrypt.OpenSSLContextImpl, javax.net.ssl.SSLContextSpi
        public /* bridge */ /* synthetic */ SSLSessionContext engineGetClientSessionContext() {
            return super.engineGetClientSessionContext();
        }

        @Override // org.conscrypt.OpenSSLContextImpl, javax.net.ssl.SSLContextSpi
        public /* bridge */ /* synthetic */ SSLSessionContext engineGetServerSessionContext() {
            return super.engineGetServerSessionContext();
        }

        public TLSv11() {
            super(NativeCrypto.TLSV11_PROTOCOLS);
        }
    }

    /* loaded from: classes4.dex */
    public static final class TLSv1 extends OpenSSLContextImpl {
        @Override // org.conscrypt.OpenSSLContextImpl, javax.net.ssl.SSLContextSpi
        public /* bridge */ /* synthetic */ SSLSessionContext engineGetClientSessionContext() {
            return super.engineGetClientSessionContext();
        }

        @Override // org.conscrypt.OpenSSLContextImpl, javax.net.ssl.SSLContextSpi
        public /* bridge */ /* synthetic */ SSLSessionContext engineGetServerSessionContext() {
            return super.engineGetServerSessionContext();
        }

        public TLSv1() {
            super(NativeCrypto.TLSV1_PROTOCOLS);
        }
    }
}
