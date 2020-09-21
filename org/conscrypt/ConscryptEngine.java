package org.conscrypt;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECKey;
import java.security.spec.ECParameterSpec;
import javax.crypto.SecretKey;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;
import org.conscrypt.ExternalSession;
import org.conscrypt.NativeCrypto;
import org.conscrypt.NativeRef;
import org.conscrypt.NativeSsl;
import org.conscrypt.SSLParametersImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class ConscryptEngine extends AbstractConscryptEngine implements NativeCrypto.SSLHandshakeCallbacks, SSLParametersImpl.AliasChooser, SSLParametersImpl.PSKCallbacks {
    private final ActiveSession activeSession;
    private BufferAllocator bufferAllocator;
    private OpenSSLKey channelIdPrivateKey;
    private SessionSnapshot closedSession;
    private final SSLSession externalSession;
    private SSLException handshakeException;
    private boolean handshakeFinished;
    private HandshakeListener handshakeListener;
    private ByteBuffer lazyDirectBuffer;
    private int maxSealOverhead;
    private final NativeSsl.BioWrapper networkBio;
    private String peerHostname;
    private final PeerInfoProvider peerInfoProvider;
    private final ByteBuffer[] singleDstBuffer;
    private final ByteBuffer[] singleSrcBuffer;
    private final NativeSsl ssl;
    private final SSLParametersImpl sslParameters;
    private int state;
    private static final SSLEngineResult NEED_UNWRAP_OK = new SSLEngineResult(SSLEngineResult.Status.OK, SSLEngineResult.HandshakeStatus.NEED_UNWRAP, 0, 0);
    private static final SSLEngineResult NEED_UNWRAP_CLOSED = new SSLEngineResult(SSLEngineResult.Status.CLOSED, SSLEngineResult.HandshakeStatus.NEED_UNWRAP, 0, 0);
    private static final SSLEngineResult NEED_WRAP_OK = new SSLEngineResult(SSLEngineResult.Status.OK, SSLEngineResult.HandshakeStatus.NEED_WRAP, 0, 0);
    private static final SSLEngineResult NEED_WRAP_CLOSED = new SSLEngineResult(SSLEngineResult.Status.CLOSED, SSLEngineResult.HandshakeStatus.NEED_WRAP, 0, 0);
    private static final SSLEngineResult CLOSED_NOT_HANDSHAKING = new SSLEngineResult(SSLEngineResult.Status.CLOSED, SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, 0);
    private static BufferAllocator defaultBufferAllocator = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConscryptEngine(SSLParametersImpl sSLParametersImpl) {
        this.bufferAllocator = defaultBufferAllocator;
        this.state = 0;
        this.externalSession = Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() { // from class: org.conscrypt.ConscryptEngine.1
            @Override // org.conscrypt.ExternalSession.Provider
            public ConscryptSession provideSession() {
                return ConscryptEngine.this.provideSession();
            }
        }));
        this.singleSrcBuffer = new ByteBuffer[1];
        this.singleDstBuffer = new ByteBuffer[1];
        this.sslParameters = sSLParametersImpl;
        this.peerInfoProvider = PeerInfoProvider.nullProvider();
        this.ssl = newSsl(sSLParametersImpl, this);
        this.networkBio = this.ssl.newBio();
        this.activeSession = new ActiveSession(this.ssl, sSLParametersImpl.getSessionContext());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConscryptEngine(String str, int i, SSLParametersImpl sSLParametersImpl) {
        this.bufferAllocator = defaultBufferAllocator;
        this.state = 0;
        this.externalSession = Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() { // from class: org.conscrypt.ConscryptEngine.1
            @Override // org.conscrypt.ExternalSession.Provider
            public ConscryptSession provideSession() {
                return ConscryptEngine.this.provideSession();
            }
        }));
        this.singleSrcBuffer = new ByteBuffer[1];
        this.singleDstBuffer = new ByteBuffer[1];
        this.sslParameters = sSLParametersImpl;
        this.peerInfoProvider = PeerInfoProvider.forHostAndPort(str, i);
        this.ssl = newSsl(sSLParametersImpl, this);
        this.networkBio = this.ssl.newBio();
        this.activeSession = new ActiveSession(this.ssl, sSLParametersImpl.getSessionContext());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConscryptEngine(SSLParametersImpl sSLParametersImpl, PeerInfoProvider peerInfoProvider) {
        this.bufferAllocator = defaultBufferAllocator;
        this.state = 0;
        this.externalSession = Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() { // from class: org.conscrypt.ConscryptEngine.1
            @Override // org.conscrypt.ExternalSession.Provider
            public ConscryptSession provideSession() {
                return ConscryptEngine.this.provideSession();
            }
        }));
        this.singleSrcBuffer = new ByteBuffer[1];
        this.singleDstBuffer = new ByteBuffer[1];
        this.sslParameters = sSLParametersImpl;
        this.peerInfoProvider = (PeerInfoProvider) Preconditions.checkNotNull(peerInfoProvider, "peerInfoProvider");
        this.ssl = newSsl(sSLParametersImpl, this);
        this.networkBio = this.ssl.newBio();
        this.activeSession = new ActiveSession(this.ssl, sSLParametersImpl.getSessionContext());
    }

    private static NativeSsl newSsl(SSLParametersImpl sSLParametersImpl, ConscryptEngine conscryptEngine) {
        try {
            return NativeSsl.newInstance(sSLParametersImpl, conscryptEngine, conscryptEngine, conscryptEngine);
        } catch (SSLException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setDefaultBufferAllocator(BufferAllocator bufferAllocator) {
        defaultBufferAllocator = bufferAllocator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setBufferAllocator(BufferAllocator bufferAllocator) {
        synchronized (this.ssl) {
            if (isHandshakeStarted()) {
                throw new IllegalStateException("Could not set buffer allocator after the initial handshake has begun.");
            }
            this.bufferAllocator = bufferAllocator;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public int maxSealOverhead() {
        return this.maxSealOverhead;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setChannelIdEnabled(boolean z) {
        synchronized (this.ssl) {
            if (getUseClientMode()) {
                throw new IllegalStateException("Not allowed in client mode");
            }
            if (isHandshakeStarted()) {
                throw new IllegalStateException("Could not enable/disable Channel ID after the initial handshake has begun.");
            }
            this.sslParameters.channelIdEnabled = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public byte[] getChannelId() throws SSLException {
        byte[] tlsChannelId;
        synchronized (this.ssl) {
            if (getUseClientMode()) {
                throw new IllegalStateException("Not allowed in client mode");
            }
            if (isHandshakeStarted()) {
                throw new IllegalStateException("Channel ID is only available after handshake completes");
            }
            tlsChannelId = this.ssl.getTlsChannelId();
        }
        return tlsChannelId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setChannelIdPrivateKey(PrivateKey privateKey) {
        if (!getUseClientMode()) {
            throw new IllegalStateException("Not allowed in server mode");
        }
        synchronized (this.ssl) {
            if (isHandshakeStarted()) {
                throw new IllegalStateException("Could not change Channel ID private key after the initial handshake has begun.");
            }
            if (privateKey == null) {
                this.sslParameters.channelIdEnabled = false;
                this.channelIdPrivateKey = null;
                return;
            }
            this.sslParameters.channelIdEnabled = true;
            try {
                ECParameterSpec params = privateKey instanceof ECKey ? ((ECKey) privateKey).getParams() : null;
                if (params == null) {
                    params = OpenSSLECGroupContext.getCurveByName("prime256v1").getECParameterSpec();
                }
                this.channelIdPrivateKey = OpenSSLKey.fromECPrivateKeyForTLSStackOnly(privateKey, params);
            } catch (InvalidKeyException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setHandshakeListener(HandshakeListener handshakeListener) {
        synchronized (this.ssl) {
            if (isHandshakeStarted()) {
                throw new IllegalStateException("Handshake listener must be set before starting the handshake.");
            }
            this.handshakeListener = handshakeListener;
        }
    }

    private boolean isHandshakeStarted() {
        switch (this.state) {
            case 0:
            case 1:
                return false;
            default:
                return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setHostname(String str) {
        this.sslParameters.setUseSni(str != null);
        this.peerHostname = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public String getHostname() {
        return this.peerHostname != null ? this.peerHostname : this.peerInfoProvider.getHostname();
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public String getPeerHost() {
        return this.peerHostname != null ? this.peerHostname : this.peerInfoProvider.getHostnameOrIP();
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public int getPeerPort() {
        return this.peerInfoProvider.getPort();
    }

    @Override // javax.net.ssl.SSLEngine
    public void beginHandshake() throws SSLException {
        synchronized (this.ssl) {
            beginHandshakeInternal();
        }
    }

    private void beginHandshakeInternal() throws SSLException {
        NativeSslSession cachedSession;
        switch (this.state) {
            case 0:
                throw new IllegalStateException("Client/server mode must be set before handshake");
            case 1:
                transitionTo(2);
                try {
                    try {
                        this.ssl.initialize(getHostname(), this.channelIdPrivateKey);
                        if (getUseClientMode() && (cachedSession = clientSessionContext().getCachedSession(getHostname(), getPeerPort(), this.sslParameters)) != null) {
                            cachedSession.offerToResume(this.ssl);
                        }
                        this.maxSealOverhead = this.ssl.getMaxSealOverhead();
                        handshake();
                        return;
                    } catch (IOException e) {
                        if (e.getMessage().contains("unexpected CCS")) {
                            Platform.logEvent(String.format("ssl_unexpected_ccs: host=%s", getPeerHost()));
                        }
                        throw SSLUtils.toSSLHandshakeException(e);
                    }
                } catch (Throwable th) {
                    closeAndFreeResources();
                    throw th;
                }
            case 2:
            case 3:
            case 4:
            case 5:
            default:
                return;
            case 6:
            case 7:
            case 8:
                throw new IllegalStateException("Engine has already been closed");
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public void closeInbound() throws SSLException {
        synchronized (this.ssl) {
            if (this.state != 8 && this.state != 6) {
                if (isOutboundDone()) {
                    closeAndFreeResources();
                } else {
                    transitionTo(6);
                }
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public void closeOutbound() {
        synchronized (this.ssl) {
            if (this.state != 8 && this.state != 7) {
                if (isHandshakeStarted()) {
                    sendSSLShutdown();
                    if (isInboundDone()) {
                        closeAndFreeResources();
                    } else {
                        transitionTo(7);
                    }
                } else {
                    closeAndFreeResources();
                }
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public Runnable getDelegatedTask() {
        return null;
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getEnabledCipherSuites() {
        return this.sslParameters.getEnabledCipherSuites();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getEnabledProtocols() {
        return this.sslParameters.getEnabledProtocols();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getEnableSessionCreation() {
        return this.sslParameters.getEnableSessionCreation();
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLParameters getSSLParameters() {
        SSLParameters sSLParameters = super.getSSLParameters();
        Platform.getSSLParameters(sSLParameters, this.sslParameters, this);
        return sSLParameters;
    }

    @Override // javax.net.ssl.SSLEngine
    public void setSSLParameters(SSLParameters sSLParameters) {
        super.setSSLParameters(sSLParameters);
        Platform.setSSLParameters(sSLParameters, this.sslParameters, this);
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLEngineResult.HandshakeStatus getHandshakeStatus() {
        SSLEngineResult.HandshakeStatus handshakeStatusInternal;
        synchronized (this.ssl) {
            handshakeStatusInternal = getHandshakeStatusInternal();
        }
        return handshakeStatusInternal;
    }

    private SSLEngineResult.HandshakeStatus getHandshakeStatusInternal() {
        if (this.handshakeFinished) {
            return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
        }
        switch (this.state) {
            case 0:
            case 1:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
            case 2:
                return pendingStatus(pendingOutboundEncryptedBytes());
            case 3:
                return SSLEngineResult.HandshakeStatus.NEED_WRAP;
            default:
                throw new IllegalStateException("Unexpected engine state: " + this.state);
        }
    }

    private int pendingOutboundEncryptedBytes() {
        return this.networkBio.getPendingWrittenBytes();
    }

    private int pendingInboundCleartextBytes() {
        return this.ssl.getPendingReadableBytes();
    }

    private static SSLEngineResult.HandshakeStatus pendingStatus(int i) {
        return i > 0 ? SSLEngineResult.HandshakeStatus.NEED_WRAP : SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getNeedClientAuth() {
        return this.sslParameters.getNeedClientAuth();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public SSLSession handshakeSession() {
        SSLSession wrapSSLSession;
        synchronized (this.ssl) {
            wrapSSLSession = this.state == 2 ? Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() { // from class: org.conscrypt.ConscryptEngine.2
                @Override // org.conscrypt.ExternalSession.Provider
                public ConscryptSession provideSession() {
                    return ConscryptEngine.this.provideHandshakeSession();
                }
            })) : null;
        }
        return wrapSSLSession;
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLSession getSession() {
        return this.externalSession;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ConscryptSession provideSession() {
        ConscryptSession conscryptSession;
        synchronized (this.ssl) {
            if (this.state == 8) {
                conscryptSession = this.closedSession != null ? this.closedSession : SSLNullSession.getNullSession();
            } else if (this.state < 3) {
                conscryptSession = SSLNullSession.getNullSession();
            } else {
                conscryptSession = this.activeSession;
            }
        }
        return conscryptSession;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ConscryptSession provideHandshakeSession() {
        ConscryptSession nullSession;
        synchronized (this.ssl) {
            nullSession = this.state == 2 ? this.activeSession : SSLNullSession.getNullSession();
        }
        return nullSession;
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getSupportedCipherSuites() {
        return NativeCrypto.getSupportedCipherSuites();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getSupportedProtocols() {
        return NativeCrypto.getSupportedProtocols();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getUseClientMode() {
        return this.sslParameters.getUseClientMode();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getWantClientAuth() {
        return this.sslParameters.getWantClientAuth();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean isInboundDone() {
        boolean z;
        synchronized (this.ssl) {
            z = this.state == 8 || this.state == 6 || this.ssl.wasShutdownReceived();
        }
        return z;
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean isOutboundDone() {
        boolean z;
        synchronized (this.ssl) {
            z = this.state == 8 || this.state == 7 || this.ssl.wasShutdownSent();
        }
        return z;
    }

    @Override // javax.net.ssl.SSLEngine
    public void setEnabledCipherSuites(String[] strArr) {
        this.sslParameters.setEnabledCipherSuites(strArr);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setEnabledProtocols(String[] strArr) {
        this.sslParameters.setEnabledProtocols(strArr);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setEnableSessionCreation(boolean z) {
        this.sslParameters.setEnableSessionCreation(z);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setNeedClientAuth(boolean z) {
        this.sslParameters.setNeedClientAuth(z);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setUseClientMode(boolean z) {
        synchronized (this.ssl) {
            if (isHandshakeStarted()) {
                throw new IllegalArgumentException("Can not change mode after handshake: state == " + this.state);
            }
            transitionTo(1);
            this.sslParameters.setUseClientMode(z);
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public void setWantClientAuth(boolean z) {
        this.sslParameters.setWantClientAuth(z);
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        SSLEngineResult unwrap;
        synchronized (this.ssl) {
            unwrap = unwrap(singleSrcBuffer(byteBuffer), singleDstBuffer(byteBuffer2));
            resetSingleSrcBuffer();
            resetSingleDstBuffer();
        }
        return unwrap;
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) throws SSLException {
        SSLEngineResult unwrap;
        synchronized (this.ssl) {
            unwrap = unwrap(singleSrcBuffer(byteBuffer), byteBufferArr);
            resetSingleSrcBuffer();
        }
        return unwrap;
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr, int i, int i2) throws SSLException {
        SSLEngineResult unwrap;
        synchronized (this.ssl) {
            unwrap = unwrap(singleSrcBuffer(byteBuffer), 0, 1, byteBufferArr, i, i2);
            resetSingleSrcBuffer();
        }
        return unwrap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public SSLEngineResult unwrap(ByteBuffer[] byteBufferArr, ByteBuffer[] byteBufferArr2) throws SSLException {
        Preconditions.checkArgument(byteBufferArr != null, "srcs is null");
        Preconditions.checkArgument(byteBufferArr2 != null, "dsts is null");
        return unwrap(byteBufferArr, 0, byteBufferArr.length, byteBufferArr2, 0, byteBufferArr2.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // org.conscrypt.AbstractConscryptEngine
    public SSLEngineResult unwrap(ByteBuffer[] byteBufferArr, int i, int i2, ByteBuffer[] byteBufferArr2, int i3, int i4) throws SSLException {
        int i5;
        Preconditions.checkArgument(byteBufferArr != null, "srcs is null");
        Preconditions.checkArgument(byteBufferArr2 != null, "dsts is null");
        Preconditions.checkPositionIndexes(i, i + i2, byteBufferArr.length);
        Preconditions.checkPositionIndexes(i3, i3 + i4, byteBufferArr2.length);
        int calcDstsLength = calcDstsLength(byteBufferArr2, i3, i4);
        int i6 = i3 + i4;
        int i7 = i + i2;
        long calcSrcsLength = calcSrcsLength(byteBufferArr, i, i7);
        synchronized (this.ssl) {
            switch (this.state) {
                case 0:
                    throw new IllegalStateException("Client/server mode must be set before calling unwrap");
                case 1:
                    beginHandshakeInternal();
                    break;
                case 6:
                case 8:
                    return new SSLEngineResult(SSLEngineResult.Status.CLOSED, getHandshakeStatusInternal(), 0, 0);
            }
            SSLEngineResult.HandshakeStatus handshakeStatus = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
            if (!this.handshakeFinished) {
                handshakeStatus = handshake();
                if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_WRAP) {
                    return NEED_WRAP_OK;
                } else if (this.state == 8) {
                    return NEED_WRAP_CLOSED;
                }
            }
            boolean z = pendingInboundCleartextBytes() <= 0;
            int i8 = 0;
            if (calcSrcsLength > 0 && z) {
                if (calcSrcsLength < 5) {
                    return new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW, getHandshakeStatus(), 0, 0);
                }
                i8 = SSLUtils.getEncryptedPacketLength(byteBufferArr, i);
                if (i8 < 0) {
                    throw new SSLException("Unable to parse TLS packet header");
                }
                if (calcSrcsLength < i8) {
                    return new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW, getHandshakeStatus(), 0, 0);
                }
            } else if (z) {
                return new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW, getHandshakeStatus(), 0, 0);
            }
            int i9 = 0;
            if (i8 > 0 && i < i7) {
                while (true) {
                    ByteBuffer byteBuffer = byteBufferArr[i];
                    int remaining = byteBuffer.remaining();
                    if (remaining == 0) {
                        i5 = i + 1;
                    } else {
                        int writeEncryptedData = writeEncryptedData(byteBuffer, Math.min(i8, remaining));
                        if (writeEncryptedData > 0) {
                            i9 += writeEncryptedData;
                            i8 -= writeEncryptedData;
                            if (i8 != 0 && writeEncryptedData == remaining) {
                                i5 = i + 1;
                            }
                        } else {
                            NativeCrypto.SSL_clear_error();
                        }
                    }
                    if (i5 < i7) {
                        i = i5;
                    }
                }
            }
            int i10 = 0;
            try {
                try {
                    try {
                        if (calcDstsLength > 0) {
                            while (i3 < i6) {
                                ByteBuffer byteBuffer2 = byteBufferArr2[i3];
                                if (byteBuffer2.hasRemaining()) {
                                    int readPlaintextData = readPlaintextData(byteBuffer2);
                                    if (readPlaintextData > 0) {
                                        i10 += readPlaintextData;
                                        if (byteBuffer2.hasRemaining()) {
                                        }
                                    } else {
                                        switch (readPlaintextData) {
                                            case -6:
                                                closeInbound();
                                                sendSSLShutdown();
                                                return new SSLEngineResult(SSLEngineResult.Status.CLOSED, pendingOutboundEncryptedBytes() > 0 ? SSLEngineResult.HandshakeStatus.NEED_WRAP : SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, i9, i10);
                                            case -5:
                                            case -4:
                                            default:
                                                sendSSLShutdown();
                                                throw newSslExceptionWithMessage("SSL_read");
                                            case -3:
                                            case -2:
                                                return newResult(i9, i10, handshakeStatus);
                                        }
                                    }
                                }
                                i3++;
                            }
                        } else {
                            this.ssl.forceRead();
                        }
                        if ((this.handshakeFinished ? pendingInboundCleartextBytes() : 0) > 0) {
                            SSLEngineResult.Status status = SSLEngineResult.Status.BUFFER_OVERFLOW;
                            if (handshakeStatus != SSLEngineResult.HandshakeStatus.FINISHED) {
                                handshakeStatus = getHandshakeStatusInternal();
                            }
                            return new SSLEngineResult(status, mayFinishHandshake(handshakeStatus), i9, i10);
                        }
                        return newResult(i9, i10, handshakeStatus);
                    } catch (EOFException e) {
                        closeAll();
                        throw convertException(e);
                    }
                } catch (SSLException e2) {
                    if (pendingOutboundEncryptedBytes() > 0) {
                        if (!this.handshakeFinished && this.handshakeException == null) {
                            this.handshakeException = e2;
                        }
                        return new SSLEngineResult(SSLEngineResult.Status.OK, SSLEngineResult.HandshakeStatus.NEED_WRAP, i9, 0);
                    }
                    sendSSLShutdown();
                    throw convertException(e2);
                }
            } catch (InterruptedIOException e3) {
                return newResult(i9, 0, handshakeStatus);
            } catch (IOException e4) {
                sendSSLShutdown();
                throw convertException(e4);
            }
        }
    }

    private static int calcDstsLength(ByteBuffer[] byteBufferArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < byteBufferArr.length; i4++) {
            ByteBuffer byteBuffer = byteBufferArr[i4];
            Preconditions.checkArgument(byteBuffer != null, "dsts[%d] is null", Integer.valueOf(i4));
            if (byteBuffer.isReadOnly()) {
                throw new ReadOnlyBufferException();
            }
            if (i4 >= i && i4 < i + i2) {
                i3 += byteBuffer.remaining();
            }
        }
        return i3;
    }

    private static long calcSrcsLength(ByteBuffer[] byteBufferArr, int i, int i2) {
        long j = 0;
        while (i < i2) {
            ByteBuffer byteBuffer = byteBufferArr[i];
            if (byteBuffer == null) {
                throw new IllegalArgumentException("srcs[" + i + "] is null");
            }
            j += byteBuffer.remaining();
            i++;
        }
        return j;
    }

    private SSLEngineResult.HandshakeStatus handshake() throws SSLException {
        try {
            try {
                try {
                    if (this.handshakeException != null) {
                        if (pendingOutboundEncryptedBytes() > 0) {
                            return SSLEngineResult.HandshakeStatus.NEED_WRAP;
                        }
                        SSLException sSLException = this.handshakeException;
                        this.handshakeException = null;
                        throw sSLException;
                    }
                    switch (this.ssl.doHandshake()) {
                        case 2:
                            return pendingStatus(pendingOutboundEncryptedBytes());
                        case 3:
                            return SSLEngineResult.HandshakeStatus.NEED_WRAP;
                        default:
                            this.activeSession.onPeerCertificateAvailable(getPeerHost(), getPeerPort());
                            finishHandshake();
                            return SSLEngineResult.HandshakeStatus.FINISHED;
                    }
                } catch (IOException e) {
                    sendSSLShutdown();
                    throw e;
                }
            } catch (SSLException e2) {
                if (pendingOutboundEncryptedBytes() > 0) {
                    this.handshakeException = e2;
                    return SSLEngineResult.HandshakeStatus.NEED_WRAP;
                }
                sendSSLShutdown();
                throw e2;
            }
        } catch (Exception e3) {
            throw SSLUtils.toSSLHandshakeException(e3);
        }
    }

    private void finishHandshake() throws SSLException {
        this.handshakeFinished = true;
        if (this.handshakeListener != null) {
            this.handshakeListener.onHandshakeFinished();
        }
    }

    private int writePlaintextData(ByteBuffer byteBuffer, int i) throws SSLException {
        int writePlaintextDataHeap;
        try {
            int position = byteBuffer.position();
            if (byteBuffer.isDirect()) {
                writePlaintextDataHeap = writePlaintextDataDirect(byteBuffer, position, i);
            } else {
                writePlaintextDataHeap = writePlaintextDataHeap(byteBuffer, position, i);
            }
            if (writePlaintextDataHeap > 0) {
                byteBuffer.position(position + writePlaintextDataHeap);
            }
            return writePlaintextDataHeap;
        } catch (Exception e) {
            throw convertException(e);
        }
    }

    private int writePlaintextDataDirect(ByteBuffer byteBuffer, int i, int i2) throws IOException {
        return this.ssl.writeDirectByteBuffer(directByteBufferAddress(byteBuffer, i), i2);
    }

    private int writePlaintextDataHeap(ByteBuffer byteBuffer, int i, int i2) throws IOException {
        ByteBuffer orCreateLazyDirectBuffer;
        AllocatedBuffer allocatedBuffer = null;
        try {
            if (this.bufferAllocator != null) {
                allocatedBuffer = this.bufferAllocator.allocateDirectBuffer(i2);
                orCreateLazyDirectBuffer = allocatedBuffer.nioBuffer();
            } else {
                orCreateLazyDirectBuffer = getOrCreateLazyDirectBuffer();
            }
            int limit = byteBuffer.limit();
            int min = Math.min(i2, orCreateLazyDirectBuffer.remaining());
            byteBuffer.limit(i + min);
            orCreateLazyDirectBuffer.put(byteBuffer);
            orCreateLazyDirectBuffer.flip();
            byteBuffer.limit(limit);
            byteBuffer.position(i);
            return writePlaintextDataDirect(orCreateLazyDirectBuffer, 0, min);
        } finally {
            if (allocatedBuffer != null) {
                allocatedBuffer.release();
            }
        }
    }

    private int readPlaintextData(ByteBuffer byteBuffer) throws IOException {
        try {
            int position = byteBuffer.position();
            int min = Math.min(16709, byteBuffer.limit() - position);
            if (byteBuffer.isDirect()) {
                int readPlaintextDataDirect = readPlaintextDataDirect(byteBuffer, position, min);
                if (readPlaintextDataDirect > 0) {
                    byteBuffer.position(position + readPlaintextDataDirect);
                    return readPlaintextDataDirect;
                }
                return readPlaintextDataDirect;
            }
            return readPlaintextDataHeap(byteBuffer, min);
        } catch (CertificateException e) {
            throw convertException(e);
        }
    }

    private int readPlaintextDataDirect(ByteBuffer byteBuffer, int i, int i2) throws IOException, CertificateException {
        return this.ssl.readDirectByteBuffer(directByteBufferAddress(byteBuffer, i), i2);
    }

    private int readPlaintextDataHeap(ByteBuffer byteBuffer, int i) throws IOException, CertificateException {
        ByteBuffer orCreateLazyDirectBuffer;
        AllocatedBuffer allocatedBuffer = null;
        try {
            if (this.bufferAllocator != null) {
                allocatedBuffer = this.bufferAllocator.allocateDirectBuffer(i);
                orCreateLazyDirectBuffer = allocatedBuffer.nioBuffer();
            } else {
                orCreateLazyDirectBuffer = getOrCreateLazyDirectBuffer();
            }
            int readPlaintextDataDirect = readPlaintextDataDirect(orCreateLazyDirectBuffer, 0, Math.min(i, orCreateLazyDirectBuffer.remaining()));
            if (readPlaintextDataDirect > 0) {
                orCreateLazyDirectBuffer.position(readPlaintextDataDirect);
                orCreateLazyDirectBuffer.flip();
                byteBuffer.put(orCreateLazyDirectBuffer);
            }
            return readPlaintextDataDirect;
        } finally {
            if (allocatedBuffer != null) {
                allocatedBuffer.release();
            }
        }
    }

    private SSLException convertException(Throwable th) {
        return ((th instanceof SSLHandshakeException) || !this.handshakeFinished) ? SSLUtils.toSSLHandshakeException(th) : SSLUtils.toSSLException(th);
    }

    private int writeEncryptedData(ByteBuffer byteBuffer, int i) throws SSLException {
        int writeEncryptedDataHeap;
        try {
            int position = byteBuffer.position();
            if (byteBuffer.isDirect()) {
                writeEncryptedDataHeap = writeEncryptedDataDirect(byteBuffer, position, i);
            } else {
                writeEncryptedDataHeap = writeEncryptedDataHeap(byteBuffer, position, i);
            }
            if (writeEncryptedDataHeap > 0) {
                byteBuffer.position(position + writeEncryptedDataHeap);
            }
            return writeEncryptedDataHeap;
        } catch (IOException e) {
            throw new SSLException(e);
        }
    }

    private int writeEncryptedDataDirect(ByteBuffer byteBuffer, int i, int i2) throws IOException {
        return this.networkBio.writeDirectByteBuffer(directByteBufferAddress(byteBuffer, i), i2);
    }

    private int writeEncryptedDataHeap(ByteBuffer byteBuffer, int i, int i2) throws IOException {
        ByteBuffer orCreateLazyDirectBuffer;
        AllocatedBuffer allocatedBuffer = null;
        try {
            if (this.bufferAllocator != null) {
                allocatedBuffer = this.bufferAllocator.allocateDirectBuffer(i2);
                orCreateLazyDirectBuffer = allocatedBuffer.nioBuffer();
            } else {
                orCreateLazyDirectBuffer = getOrCreateLazyDirectBuffer();
            }
            int limit = byteBuffer.limit();
            int min = Math.min(Math.min(limit - i, i2), orCreateLazyDirectBuffer.remaining());
            byteBuffer.limit(i + min);
            orCreateLazyDirectBuffer.put(byteBuffer);
            byteBuffer.limit(limit);
            byteBuffer.position(i);
            int writeEncryptedDataDirect = writeEncryptedDataDirect(orCreateLazyDirectBuffer, 0, min);
            byteBuffer.position(i);
            return writeEncryptedDataDirect;
        } finally {
            if (allocatedBuffer != null) {
                allocatedBuffer.release();
            }
        }
    }

    private ByteBuffer getOrCreateLazyDirectBuffer() {
        if (this.lazyDirectBuffer == null) {
            this.lazyDirectBuffer = ByteBuffer.allocateDirect(Math.max(16384, 16709));
        }
        this.lazyDirectBuffer.clear();
        return this.lazyDirectBuffer;
    }

    private long directByteBufferAddress(ByteBuffer byteBuffer, int i) {
        return NativeCrypto.getDirectBufferAddress(byteBuffer) + i;
    }

    private SSLEngineResult readPendingBytesFromBIO(ByteBuffer byteBuffer, int i, int i2, SSLEngineResult.HandshakeStatus handshakeStatus) throws SSLException {
        try {
            int pendingOutboundEncryptedBytes = pendingOutboundEncryptedBytes();
            if (pendingOutboundEncryptedBytes > 0) {
                if (byteBuffer.remaining() < pendingOutboundEncryptedBytes) {
                    SSLEngineResult.Status status = SSLEngineResult.Status.BUFFER_OVERFLOW;
                    if (handshakeStatus != SSLEngineResult.HandshakeStatus.FINISHED) {
                        handshakeStatus = getHandshakeStatus(pendingOutboundEncryptedBytes);
                    }
                    return new SSLEngineResult(status, mayFinishHandshake(handshakeStatus), i, i2);
                }
                int readEncryptedData = readEncryptedData(byteBuffer, pendingOutboundEncryptedBytes);
                if (readEncryptedData <= 0) {
                    NativeCrypto.SSL_clear_error();
                } else {
                    i2 += readEncryptedData;
                    pendingOutboundEncryptedBytes -= readEncryptedData;
                }
                SSLEngineResult.Status engineStatus = getEngineStatus();
                if (handshakeStatus != SSLEngineResult.HandshakeStatus.FINISHED) {
                    handshakeStatus = getHandshakeStatus(pendingOutboundEncryptedBytes);
                }
                return new SSLEngineResult(engineStatus, mayFinishHandshake(handshakeStatus), i, i2);
            }
            return null;
        } catch (Exception e) {
            throw convertException(e);
        }
    }

    private int readEncryptedData(ByteBuffer byteBuffer, int i) throws SSLException {
        try {
            int position = byteBuffer.position();
            if (byteBuffer.remaining() < i) {
                return 0;
            }
            int min = Math.min(i, byteBuffer.limit() - position);
            if (byteBuffer.isDirect()) {
                int readEncryptedDataDirect = readEncryptedDataDirect(byteBuffer, position, min);
                if (readEncryptedDataDirect > 0) {
                    byteBuffer.position(position + readEncryptedDataDirect);
                    return readEncryptedDataDirect;
                }
                return readEncryptedDataDirect;
            }
            return readEncryptedDataHeap(byteBuffer, min);
        } catch (Exception e) {
            throw convertException(e);
        }
    }

    private int readEncryptedDataDirect(ByteBuffer byteBuffer, int i, int i2) throws IOException {
        return this.networkBio.readDirectByteBuffer(directByteBufferAddress(byteBuffer, i), i2);
    }

    private int readEncryptedDataHeap(ByteBuffer byteBuffer, int i) throws IOException {
        ByteBuffer orCreateLazyDirectBuffer;
        AllocatedBuffer allocatedBuffer = null;
        try {
            if (this.bufferAllocator != null) {
                allocatedBuffer = this.bufferAllocator.allocateDirectBuffer(i);
                orCreateLazyDirectBuffer = allocatedBuffer.nioBuffer();
            } else {
                orCreateLazyDirectBuffer = getOrCreateLazyDirectBuffer();
            }
            int readEncryptedDataDirect = readEncryptedDataDirect(orCreateLazyDirectBuffer, 0, Math.min(i, orCreateLazyDirectBuffer.remaining()));
            if (readEncryptedDataDirect > 0) {
                orCreateLazyDirectBuffer.position(readEncryptedDataDirect);
                orCreateLazyDirectBuffer.flip();
                byteBuffer.put(orCreateLazyDirectBuffer);
            }
            return readEncryptedDataDirect;
        } finally {
            if (allocatedBuffer != null) {
                allocatedBuffer.release();
            }
        }
    }

    private SSLEngineResult.HandshakeStatus mayFinishHandshake(SSLEngineResult.HandshakeStatus handshakeStatus) throws SSLException {
        if (!this.handshakeFinished && handshakeStatus == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
            return handshake();
        }
        return handshakeStatus;
    }

    private SSLEngineResult.HandshakeStatus getHandshakeStatus(int i) {
        return !this.handshakeFinished ? pendingStatus(i) : SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
    }

    private SSLEngineResult.Status getEngineStatus() {
        switch (this.state) {
            case 6:
            case 7:
            case 8:
                return SSLEngineResult.Status.CLOSED;
            default:
                return SSLEngineResult.Status.OK;
        }
    }

    private void closeAll() throws SSLException {
        closeOutbound();
        closeInbound();
    }

    private SSLException newSslExceptionWithMessage(String str) {
        return !this.handshakeFinished ? new SSLException(str) : new SSLHandshakeException(str);
    }

    private SSLEngineResult newResult(int i, int i2, SSLEngineResult.HandshakeStatus handshakeStatus) throws SSLException {
        SSLEngineResult.Status engineStatus = getEngineStatus();
        if (handshakeStatus != SSLEngineResult.HandshakeStatus.FINISHED) {
            handshakeStatus = getHandshakeStatusInternal();
        }
        return new SSLEngineResult(engineStatus, mayFinishHandshake(handshakeStatus), i, i2);
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        SSLEngineResult wrap;
        synchronized (this.ssl) {
            wrap = wrap(singleSrcBuffer(byteBuffer), byteBuffer2);
            resetSingleSrcBuffer();
        }
        return wrap;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0173, code lost:
        r0 = newResult(r2, r3, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:?, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:?, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0119, code lost:
        if (r2 != 0) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x011b, code lost:
        r1 = readPendingBytesFromBIO(r13, 0, r3, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0120, code lost:
        if (r1 == null) goto L79;
     */
    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SSLEngineResult wrap(ByteBuffer[] byteBufferArr, int i, int i2, ByteBuffer byteBuffer) throws SSLException {
        int i3;
        int i4;
        int i5;
        Preconditions.checkArgument(byteBufferArr != null, "srcs is null");
        Preconditions.checkArgument(byteBuffer != null, "dst is null");
        Preconditions.checkPositionIndexes(i, i + i2, byteBufferArr.length);
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        synchronized (this.ssl) {
            switch (this.state) {
                case 0:
                    throw new IllegalStateException("Client/server mode must be set before calling wrap");
                case 1:
                    beginHandshakeInternal();
                    break;
                case 7:
                case 8:
                    SSLEngineResult readPendingBytesFromBIO = readPendingBytesFromBIO(byteBuffer, 0, 0, SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING);
                    if (readPendingBytesFromBIO == null) {
                        return new SSLEngineResult(SSLEngineResult.Status.CLOSED, getHandshakeStatusInternal(), 0, 0);
                    }
                    return readPendingBytesFromBIO;
            }
            SSLEngineResult.HandshakeStatus handshakeStatus = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
            if (!this.handshakeFinished) {
                handshakeStatus = handshake();
                if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
                    return NEED_UNWRAP_OK;
                }
                if (this.state == 8) {
                    return NEED_UNWRAP_CLOSED;
                }
            }
            int i6 = 0;
            int i7 = i + i2;
            for (int i8 = i; i8 < i7; i8++) {
                ByteBuffer byteBuffer2 = byteBufferArr[i8];
                if (byteBuffer2 == null) {
                    throw new IllegalArgumentException("srcs[" + i8 + "] is null");
                }
                if (i6 != 16384 && ((i6 = i6 + byteBuffer2.remaining()) > 16384 || i6 < 0)) {
                    i6 = 16384;
                }
            }
            if (byteBuffer.remaining() < SSLUtils.calculateOutNetBufSize(i6)) {
                return new SSLEngineResult(SSLEngineResult.Status.BUFFER_OVERFLOW, getHandshakeStatusInternal(), 0, 0);
            }
            int i9 = 0;
            int i10 = 0;
            while (true) {
                if (i >= i7) {
                    i3 = i9;
                    i4 = i10;
                } else {
                    ByteBuffer byteBuffer3 = byteBufferArr[i];
                    Preconditions.checkArgument(byteBuffer3 != null, "srcs[%d] is null", Integer.valueOf(i));
                    int i11 = i9;
                    while (byteBuffer3.hasRemaining()) {
                        int writePlaintextData = writePlaintextData(byteBuffer3, Math.min(byteBuffer3.remaining(), 16384 - i10));
                        if (writePlaintextData > 0) {
                            i4 = writePlaintextData + i10;
                            SSLEngineResult readPendingBytesFromBIO2 = readPendingBytesFromBIO(byteBuffer, i4, i11, handshakeStatus);
                            if (readPendingBytesFromBIO2 == null) {
                                i5 = i11;
                            } else if (readPendingBytesFromBIO2.getStatus() != SSLEngineResult.Status.OK) {
                                return readPendingBytesFromBIO2;
                            } else {
                                i5 = readPendingBytesFromBIO2.bytesProduced();
                            }
                            if (i4 == 16384) {
                                i3 = i5;
                            } else {
                                i11 = i5;
                                i10 = i4;
                            }
                        } else {
                            switch (this.ssl.getError(writePlaintextData)) {
                                case 2:
                                    SSLEngineResult readPendingBytesFromBIO3 = readPendingBytesFromBIO(byteBuffer, i10, i11, handshakeStatus);
                                    if (readPendingBytesFromBIO3 == null) {
                                        readPendingBytesFromBIO3 = new SSLEngineResult(getEngineStatus(), SSLEngineResult.HandshakeStatus.NEED_UNWRAP, i10, i11);
                                    }
                                    return readPendingBytesFromBIO3;
                                case 3:
                                    SSLEngineResult readPendingBytesFromBIO4 = readPendingBytesFromBIO(byteBuffer, i10, i11, handshakeStatus);
                                    if (readPendingBytesFromBIO4 == null) {
                                        readPendingBytesFromBIO4 = NEED_WRAP_CLOSED;
                                    }
                                    return readPendingBytesFromBIO4;
                                case 4:
                                case 5:
                                default:
                                    sendSSLShutdown();
                                    throw newSslExceptionWithMessage("SSL_write");
                                case 6:
                                    closeAll();
                                    SSLEngineResult readPendingBytesFromBIO5 = readPendingBytesFromBIO(byteBuffer, i10, i11, handshakeStatus);
                                    if (readPendingBytesFromBIO5 == null) {
                                        readPendingBytesFromBIO5 = CLOSED_NOT_HANDSHAKING;
                                    }
                                    return readPendingBytesFromBIO5;
                            }
                        }
                    }
                    i++;
                    i9 = i11;
                }
            }
        }
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public int clientPSKKeyRequested(String str, byte[] bArr, byte[] bArr2) {
        return this.ssl.clientPSKKeyRequested(str, bArr, bArr2);
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public int serverPSKKeyRequested(String str, String str2, byte[] bArr) {
        return this.ssl.serverPSKKeyRequested(str, str2, bArr);
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void onSSLStateChange(int i, int i2) {
        synchronized (this.ssl) {
            switch (i) {
                case 16:
                    transitionTo(2);
                    break;
                case 32:
                    if (this.state != 2 && this.state != 4) {
                        throw new IllegalStateException("Completed handshake while in mode " + this.state);
                    }
                    transitionTo(3);
                    break;
                    break;
            }
        }
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void onNewSessionEstablished(long j) {
        try {
            NativeCrypto.SSL_SESSION_up_ref(j);
            sessionContext().cacheSession(NativeSslSession.newInstance(new NativeRef.SSL_SESSION(j), this.activeSession));
        } catch (Exception e) {
        }
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public long serverSessionRequested(byte[] bArr) {
        return 0L;
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void verifyCertificateChain(byte[][] bArr, String str) throws CertificateException {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    X509Certificate[] decodeX509CertificateChain = SSLUtils.decodeX509CertificateChain(bArr);
                    X509TrustManager x509TrustManager = this.sslParameters.getX509TrustManager();
                    if (x509TrustManager == null) {
                        throw new CertificateException("No X.509 TrustManager");
                    }
                    this.activeSession.onPeerCertificatesReceived(getPeerHost(), getPeerPort(), decodeX509CertificateChain);
                    if (getUseClientMode()) {
                        Platform.checkServerTrusted(x509TrustManager, decodeX509CertificateChain, str, this);
                        return;
                    } else {
                        Platform.checkClientTrusted(x509TrustManager, decodeX509CertificateChain, decodeX509CertificateChain[0].getPublicKey().getAlgorithm(), this);
                        return;
                    }
                }
            } catch (CertificateException e) {
                throw e;
            } catch (Exception e2) {
                throw new CertificateException(e2);
            }
        }
        throw new CertificateException("Peer sent no certificate");
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void clientCertificateRequested(byte[] bArr, byte[][] bArr2) throws CertificateEncodingException, SSLException {
        this.ssl.chooseClientCertificate(bArr, bArr2);
    }

    private void sendSSLShutdown() {
        try {
            this.ssl.shutdown();
        } catch (IOException e) {
        }
    }

    private void closeAndFreeResources() {
        transitionTo(8);
        if (!this.ssl.isClosed()) {
            this.ssl.close();
            this.networkBio.close();
        }
    }

    protected void finalize() throws Throwable {
        try {
            transitionTo(8);
        } finally {
            super.finalize();
        }
    }

    @Override // org.conscrypt.SSLParametersImpl.AliasChooser
    public String chooseServerAlias(X509KeyManager x509KeyManager, String str) {
        return x509KeyManager instanceof X509ExtendedKeyManager ? ((X509ExtendedKeyManager) x509KeyManager).chooseEngineServerAlias(str, null, this) : x509KeyManager.chooseServerAlias(str, null, null);
    }

    @Override // org.conscrypt.SSLParametersImpl.AliasChooser
    public String chooseClientAlias(X509KeyManager x509KeyManager, X500Principal[] x500PrincipalArr, String[] strArr) {
        return x509KeyManager instanceof X509ExtendedKeyManager ? ((X509ExtendedKeyManager) x509KeyManager).chooseEngineClientAlias(strArr, x500PrincipalArr, this) : x509KeyManager.chooseClientAlias(strArr, x500PrincipalArr, null);
    }

    @Override // org.conscrypt.SSLParametersImpl.PSKCallbacks
    public String chooseServerPSKIdentityHint(PSKKeyManager pSKKeyManager) {
        return pSKKeyManager.chooseServerKeyIdentityHint(this);
    }

    @Override // org.conscrypt.SSLParametersImpl.PSKCallbacks
    public String chooseClientPSKIdentity(PSKKeyManager pSKKeyManager, String str) {
        return pSKKeyManager.chooseClientKeyIdentity(str, this);
    }

    @Override // org.conscrypt.SSLParametersImpl.PSKCallbacks
    public SecretKey getPSKKey(PSKKeyManager pSKKeyManager, String str, String str2) {
        return pSKKeyManager.getKey(str, str2, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setUseSessionTickets(boolean z) {
        this.sslParameters.setUseSessionTickets(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public String[] getApplicationProtocols() {
        return this.sslParameters.getApplicationProtocols();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setApplicationProtocols(String[] strArr) {
        this.sslParameters.setApplicationProtocols(strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setApplicationProtocolSelector(ApplicationProtocolSelector applicationProtocolSelector) {
        setApplicationProtocolSelector(applicationProtocolSelector == null ? null : new ApplicationProtocolSelectorAdapter(this, applicationProtocolSelector));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public byte[] getTlsUnique() {
        return this.ssl.getTlsUnique();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setTokenBindingParams(int... iArr) throws SSLException {
        synchronized (this.ssl) {
            if (isHandshakeStarted()) {
                throw new IllegalStateException("Cannot set token binding params after handshake has started.");
            }
        }
        this.ssl.setTokenBindingParams(iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public int getTokenBindingParams() {
        return this.ssl.getTokenBindingParams();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public byte[] exportKeyingMaterial(String str, byte[] bArr, int i) throws SSLException {
        synchronized (this.ssl) {
            if (this.state < 3 || this.state == 8) {
                return null;
            }
            return this.ssl.exportKeyingMaterial(str, bArr, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setApplicationProtocolSelector(ApplicationProtocolSelectorAdapter applicationProtocolSelectorAdapter) {
        this.sslParameters.setApplicationProtocolSelector(applicationProtocolSelectorAdapter);
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public String getApplicationProtocol() {
        return SSLUtils.toProtocolString(this.ssl.getApplicationProtocol());
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public String getHandshakeApplicationProtocol() {
        String applicationProtocol;
        synchronized (this.ssl) {
            applicationProtocol = this.state == 2 ? getApplicationProtocol() : null;
        }
        return applicationProtocol;
    }

    private ByteBuffer[] singleSrcBuffer(ByteBuffer byteBuffer) {
        this.singleSrcBuffer[0] = byteBuffer;
        return this.singleSrcBuffer;
    }

    private void resetSingleSrcBuffer() {
        this.singleSrcBuffer[0] = null;
    }

    private ByteBuffer[] singleDstBuffer(ByteBuffer byteBuffer) {
        this.singleDstBuffer[0] = byteBuffer;
        return this.singleDstBuffer;
    }

    private void resetSingleDstBuffer() {
        this.singleDstBuffer[0] = null;
    }

    private ClientSessionContext clientSessionContext() {
        return this.sslParameters.getClientSessionContext();
    }

    private AbstractSessionContext sessionContext() {
        return this.sslParameters.getSessionContext();
    }

    private void transitionTo(int i) {
        switch (i) {
            case 2:
                this.handshakeFinished = false;
                break;
            case 8:
                if (!this.ssl.isClosed() && this.state >= 2 && this.state < 8) {
                    this.closedSession = new SessionSnapshot(this.activeSession);
                    break;
                }
                break;
        }
        this.state = i;
    }
}
