package org.conscrypt;

import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSessionBindingEvent;
import javax.net.ssl.SSLSessionBindingListener;
import javax.net.ssl.SSLSessionContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public final class ActiveSession implements ConscryptSession {
    private long creationTime;
    private byte[] id;
    private X509Certificate[] localCertificates;
    private volatile javax.security.cert.X509Certificate[] peerCertificateChain;
    private byte[] peerCertificateOcspData;
    private X509Certificate[] peerCertificates;
    private String peerHost;
    private byte[] peerTlsSctData;
    private String protocol;
    private AbstractSessionContext sessionContext;
    private final NativeSsl ssl;
    private int peerPort = -1;
    private long lastAccessedTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActiveSession(NativeSsl nativeSsl, AbstractSessionContext abstractSessionContext) {
        this.ssl = (NativeSsl) Preconditions.checkNotNull(nativeSsl, "ssl");
        this.sessionContext = (AbstractSessionContext) Preconditions.checkNotNull(abstractSessionContext, "sessionContext");
    }

    @Override // javax.net.ssl.SSLSession
    public byte[] getId() {
        if (this.id == null) {
            synchronized (this.ssl) {
                this.id = this.ssl.getSessionId();
            }
        }
        return this.id != null ? (byte[]) this.id.clone() : EmptyArray.BYTE;
    }

    void resetId() {
        this.id = null;
    }

    @Override // javax.net.ssl.SSLSession
    public SSLSessionContext getSessionContext() {
        if (isValid()) {
            return this.sessionContext;
        }
        return null;
    }

    @Override // javax.net.ssl.SSLSession
    public long getCreationTime() {
        if (this.creationTime == 0) {
            synchronized (this.ssl) {
                this.creationTime = this.ssl.getTime();
            }
        }
        return this.creationTime;
    }

    @Override // javax.net.ssl.SSLSession
    public long getLastAccessedTime() {
        return this.lastAccessedTime == 0 ? getCreationTime() : this.lastAccessedTime;
    }

    void setLastAccessedTime(long j) {
        this.lastAccessedTime = j;
    }

    @Override // org.conscrypt.ConscryptSession
    public List<byte[]> getStatusResponses() {
        return this.peerCertificateOcspData == null ? Collections.emptyList() : Collections.singletonList(this.peerCertificateOcspData.clone());
    }

    @Override // org.conscrypt.ConscryptSession
    public byte[] getPeerSignedCertificateTimestamp() {
        if (this.peerTlsSctData == null) {
            return null;
        }
        return (byte[]) this.peerTlsSctData.clone();
    }

    @Override // org.conscrypt.ConscryptSession
    public String getRequestedServerName() {
        String requestedServerName;
        synchronized (this.ssl) {
            requestedServerName = this.ssl.getRequestedServerName();
        }
        return requestedServerName;
    }

    @Override // javax.net.ssl.SSLSession
    public void invalidate() {
        synchronized (this.ssl) {
            this.ssl.setTimeout(0L);
        }
    }

    @Override // javax.net.ssl.SSLSession
    public boolean isValid() {
        boolean z;
        synchronized (this.ssl) {
            z = System.currentTimeMillis() - this.ssl.getTimeout() < this.ssl.getTime();
        }
        return z;
    }

    @Override // javax.net.ssl.SSLSession
    public void putValue(String str, Object obj) {
        throw new UnsupportedOperationException("All calls to this method should be intercepted by ProvidedSessionDecorator.");
    }

    @Override // javax.net.ssl.SSLSession
    public Object getValue(String str) {
        throw new UnsupportedOperationException("All calls to this method should be intercepted by ProvidedSessionDecorator.");
    }

    @Override // javax.net.ssl.SSLSession
    public void removeValue(String str) {
        throw new UnsupportedOperationException("All calls to this method should be intercepted by ProvidedSessionDecorator.");
    }

    @Override // javax.net.ssl.SSLSession
    public String[] getValueNames() {
        throw new UnsupportedOperationException("All calls to this method should be intercepted by ProvidedSessionDecorator.");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.conscrypt.ConscryptSession, javax.net.ssl.SSLSession
    public X509Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        checkPeerCertificatesPresent();
        return (X509Certificate[]) this.peerCertificates.clone();
    }

    @Override // javax.net.ssl.SSLSession
    public Certificate[] getLocalCertificates() {
        if (this.localCertificates == null) {
            return null;
        }
        return (X509Certificate[]) this.localCertificates.clone();
    }

    @Override // javax.net.ssl.SSLSession
    public javax.security.cert.X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
        checkPeerCertificatesPresent();
        javax.security.cert.X509Certificate[] x509CertificateArr = this.peerCertificateChain;
        if (x509CertificateArr == null) {
            javax.security.cert.X509Certificate[] certificateChain = SSLUtils.toCertificateChain(this.peerCertificates);
            this.peerCertificateChain = certificateChain;
            return certificateChain;
        }
        return x509CertificateArr;
    }

    @Override // javax.net.ssl.SSLSession
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        checkPeerCertificatesPresent();
        return this.peerCertificates[0].getSubjectX500Principal();
    }

    @Override // javax.net.ssl.SSLSession
    public Principal getLocalPrincipal() {
        if (this.localCertificates == null || this.localCertificates.length <= 0) {
            return null;
        }
        return this.localCertificates[0].getSubjectX500Principal();
    }

    @Override // javax.net.ssl.SSLSession
    public String getCipherSuite() {
        String cipherSuite;
        synchronized (this.ssl) {
            cipherSuite = this.ssl.getCipherSuite();
        }
        return cipherSuite == null ? "SSL_NULL_WITH_NULL_NULL" : cipherSuite;
    }

    @Override // javax.net.ssl.SSLSession
    public String getProtocol() {
        String str = this.protocol;
        if (str == null) {
            synchronized (this.ssl) {
                str = this.ssl.getVersion();
            }
            this.protocol = str;
        }
        return str;
    }

    @Override // javax.net.ssl.SSLSession
    public String getPeerHost() {
        return this.peerHost;
    }

    @Override // javax.net.ssl.SSLSession
    public int getPeerPort() {
        return this.peerPort;
    }

    @Override // javax.net.ssl.SSLSession
    public int getPacketBufferSize() {
        return 16709;
    }

    @Override // javax.net.ssl.SSLSession
    public int getApplicationBufferSize() {
        return 16384;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPeerCertificatesReceived(String str, int i, X509Certificate[] x509CertificateArr) {
        configurePeer(str, i, x509CertificateArr);
    }

    private void configurePeer(String str, int i, X509Certificate[] x509CertificateArr) {
        this.peerHost = str;
        this.peerPort = i;
        this.peerCertificates = x509CertificateArr;
        synchronized (this.ssl) {
            this.peerCertificateOcspData = this.ssl.getPeerCertificateOcspData();
            this.peerTlsSctData = this.ssl.getPeerTlsSctData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPeerCertificateAvailable(String str, int i) throws CertificateException {
        synchronized (this.ssl) {
            this.id = null;
            this.localCertificates = this.ssl.getLocalCertificates();
            if (this.peerCertificates == null) {
                configurePeer(str, i, this.ssl.getPeerCertificates());
            }
        }
    }

    private void checkPeerCertificatesPresent() throws SSLPeerUnverifiedException {
        if (this.peerCertificates == null || this.peerCertificates.length == 0) {
            throw new SSLPeerUnverifiedException("No peer certificates");
        }
    }

    private void notifyUnbound(Object obj, String str) {
        if (obj instanceof SSLSessionBindingListener) {
            ((SSLSessionBindingListener) obj).valueUnbound(new SSLSessionBindingEvent(this, str));
        }
    }
}
