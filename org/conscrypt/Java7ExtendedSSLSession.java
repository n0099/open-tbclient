package org.conscrypt;

import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.ExtendedSSLSession;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSessionContext;
/* loaded from: classes4.dex */
class Java7ExtendedSSLSession extends ExtendedSSLSession implements SessionDecorator {
    private static final String[] LOCAL_SUPPORTED_SIGNATURE_ALGORITHMS = {"SHA512withRSA", "SHA512withECDSA", "SHA384withRSA", "SHA384withECDSA", "SHA256withRSA", "SHA256withECDSA", "SHA224withRSA", "SHA224withECDSA", "SHA1withRSA", "SHA1withECDSA"};
    private static final String[] PEER_SUPPORTED_SIGNATURE_ALGORITHMS = {"SHA1withRSA", "SHA1withECDSA"};
    private final ConscryptSession delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Java7ExtendedSSLSession(ConscryptSession conscryptSession) {
        this.delegate = conscryptSession;
    }

    @Override // org.conscrypt.SessionDecorator
    public final ConscryptSession getDelegate() {
        return this.delegate;
    }

    @Override // javax.net.ssl.ExtendedSSLSession
    public final String[] getLocalSupportedSignatureAlgorithms() {
        return (String[]) LOCAL_SUPPORTED_SIGNATURE_ALGORITHMS.clone();
    }

    @Override // javax.net.ssl.ExtendedSSLSession
    public final String[] getPeerSupportedSignatureAlgorithms() {
        return (String[]) PEER_SUPPORTED_SIGNATURE_ALGORITHMS.clone();
    }

    @Override // org.conscrypt.ConscryptSession
    public final String getRequestedServerName() {
        return getDelegate().getRequestedServerName();
    }

    @Override // org.conscrypt.ConscryptSession
    public final List<byte[]> getStatusResponses() {
        return getDelegate().getStatusResponses();
    }

    @Override // org.conscrypt.ConscryptSession
    public final byte[] getPeerSignedCertificateTimestamp() {
        return getDelegate().getPeerSignedCertificateTimestamp();
    }

    @Override // javax.net.ssl.SSLSession
    public final byte[] getId() {
        return getDelegate().getId();
    }

    @Override // javax.net.ssl.SSLSession
    public final SSLSessionContext getSessionContext() {
        return getDelegate().getSessionContext();
    }

    @Override // javax.net.ssl.SSLSession
    public final long getCreationTime() {
        return getDelegate().getCreationTime();
    }

    @Override // javax.net.ssl.SSLSession
    public final long getLastAccessedTime() {
        return getDelegate().getLastAccessedTime();
    }

    @Override // javax.net.ssl.SSLSession
    public final void invalidate() {
        getDelegate().invalidate();
    }

    @Override // javax.net.ssl.SSLSession
    public final boolean isValid() {
        return getDelegate().isValid();
    }

    @Override // javax.net.ssl.SSLSession
    public final void putValue(String str, Object obj) {
        getDelegate().putValue(str, obj);
    }

    @Override // javax.net.ssl.SSLSession
    public final Object getValue(String str) {
        return getDelegate().getValue(str);
    }

    @Override // javax.net.ssl.SSLSession
    public final void removeValue(String str) {
        getDelegate().removeValue(str);
    }

    @Override // javax.net.ssl.SSLSession
    public final String[] getValueNames() {
        return getDelegate().getValueNames();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // javax.net.ssl.SSLSession, org.conscrypt.ConscryptSession
    public X509Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        return getDelegate().getPeerCertificates();
    }

    @Override // javax.net.ssl.SSLSession
    public final Certificate[] getLocalCertificates() {
        return getDelegate().getLocalCertificates();
    }

    @Override // javax.net.ssl.SSLSession
    public final javax.security.cert.X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
        return getDelegate().getPeerCertificateChain();
    }

    @Override // javax.net.ssl.SSLSession
    public final Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        return getDelegate().getPeerPrincipal();
    }

    @Override // javax.net.ssl.SSLSession
    public final Principal getLocalPrincipal() {
        return getDelegate().getLocalPrincipal();
    }

    @Override // javax.net.ssl.SSLSession
    public final String getCipherSuite() {
        return getDelegate().getCipherSuite();
    }

    @Override // javax.net.ssl.SSLSession
    public final String getProtocol() {
        return getDelegate().getProtocol();
    }

    @Override // javax.net.ssl.SSLSession
    public final String getPeerHost() {
        return getDelegate().getPeerHost();
    }

    @Override // javax.net.ssl.SSLSession
    public final int getPeerPort() {
        return getDelegate().getPeerPort();
    }

    @Override // javax.net.ssl.SSLSession
    public final int getPacketBufferSize() {
        return getDelegate().getPacketBufferSize();
    }

    @Override // javax.net.ssl.SSLSession
    public final int getApplicationBufferSize() {
        return getDelegate().getApplicationBufferSize();
    }
}
