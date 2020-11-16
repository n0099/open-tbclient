package org.conscrypt;

import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSessionBindingEvent;
import javax.net.ssl.SSLSessionBindingListener;
import javax.net.ssl.SSLSessionContext;
/* loaded from: classes11.dex */
final class ExternalSession implements SessionDecorator {
    private final Provider provider;
    private final HashMap<String, Object> values = new HashMap<>(2);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public interface Provider {
        ConscryptSession provideSession();
    }

    public ExternalSession(Provider provider) {
        this.provider = provider;
    }

    @Override // org.conscrypt.SessionDecorator
    public ConscryptSession getDelegate() {
        return this.provider.provideSession();
    }

    @Override // org.conscrypt.ConscryptSession
    public String getRequestedServerName() {
        return getDelegate().getRequestedServerName();
    }

    @Override // org.conscrypt.ConscryptSession
    public List<byte[]> getStatusResponses() {
        return getDelegate().getStatusResponses();
    }

    @Override // org.conscrypt.ConscryptSession
    public byte[] getPeerSignedCertificateTimestamp() {
        return getDelegate().getPeerSignedCertificateTimestamp();
    }

    @Override // javax.net.ssl.SSLSession
    public byte[] getId() {
        return getDelegate().getId();
    }

    @Override // javax.net.ssl.SSLSession
    public SSLSessionContext getSessionContext() {
        return getDelegate().getSessionContext();
    }

    @Override // javax.net.ssl.SSLSession
    public long getCreationTime() {
        return getDelegate().getCreationTime();
    }

    @Override // javax.net.ssl.SSLSession
    public long getLastAccessedTime() {
        return getDelegate().getLastAccessedTime();
    }

    @Override // javax.net.ssl.SSLSession
    public void invalidate() {
        getDelegate().invalidate();
    }

    @Override // javax.net.ssl.SSLSession
    public boolean isValid() {
        return getDelegate().isValid();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.conscrypt.ConscryptSession, javax.net.ssl.SSLSession
    public X509Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        return getDelegate().getPeerCertificates();
    }

    @Override // javax.net.ssl.SSLSession
    public Certificate[] getLocalCertificates() {
        return getDelegate().getLocalCertificates();
    }

    @Override // javax.net.ssl.SSLSession
    public javax.security.cert.X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
        return getDelegate().getPeerCertificateChain();
    }

    @Override // javax.net.ssl.SSLSession
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        return getDelegate().getPeerPrincipal();
    }

    @Override // javax.net.ssl.SSLSession
    public Principal getLocalPrincipal() {
        return getDelegate().getLocalPrincipal();
    }

    @Override // javax.net.ssl.SSLSession
    public String getCipherSuite() {
        return getDelegate().getCipherSuite();
    }

    @Override // javax.net.ssl.SSLSession
    public String getProtocol() {
        return getDelegate().getProtocol();
    }

    @Override // javax.net.ssl.SSLSession
    public String getPeerHost() {
        return getDelegate().getPeerHost();
    }

    @Override // javax.net.ssl.SSLSession
    public int getPeerPort() {
        return getDelegate().getPeerPort();
    }

    @Override // javax.net.ssl.SSLSession
    public int getPacketBufferSize() {
        return getDelegate().getPacketBufferSize();
    }

    @Override // javax.net.ssl.SSLSession
    public int getApplicationBufferSize() {
        return getDelegate().getApplicationBufferSize();
    }

    @Override // javax.net.ssl.SSLSession
    public Object getValue(String str) {
        if (str == null) {
            throw new IllegalArgumentException("name == null");
        }
        return this.values.get(str);
    }

    @Override // javax.net.ssl.SSLSession
    public String[] getValueNames() {
        return (String[]) this.values.keySet().toArray(new String[this.values.size()]);
    }

    @Override // javax.net.ssl.SSLSession
    public void putValue(String str, Object obj) {
        if (str == null || obj == null) {
            throw new IllegalArgumentException("name == null || value == null");
        }
        Object put = this.values.put(str, obj);
        if (obj instanceof SSLSessionBindingListener) {
            ((SSLSessionBindingListener) obj).valueBound(new SSLSessionBindingEvent(this, str));
        }
        if (put instanceof SSLSessionBindingListener) {
            ((SSLSessionBindingListener) put).valueUnbound(new SSLSessionBindingEvent(this, str));
        }
    }

    @Override // javax.net.ssl.SSLSession
    public void removeValue(String str) {
        if (str == null) {
            throw new IllegalArgumentException("name == null");
        }
        Object remove = this.values.remove(str);
        if (remove instanceof SSLSessionBindingListener) {
            ((SSLSessionBindingListener) remove).valueUnbound(new SSLSessionBindingEvent(this, str));
        }
    }
}
