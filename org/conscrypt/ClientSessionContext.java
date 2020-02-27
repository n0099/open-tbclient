package org.conscrypt;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public final class ClientSessionContext extends AbstractSessionContext {
    private SSLClientSessionCache persistentCache;
    private final Map<HostAndPort, NativeSslSession> sessionsByHostAndPort;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClientSessionContext() {
        super(10);
        this.sessionsByHostAndPort = new HashMap();
    }

    public void setPersistentCache(SSLClientSessionCache sSLClientSessionCache) {
        this.persistentCache = sSLClientSessionCache;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeSslSession getCachedSession(String str, int i, SSLParametersImpl sSLParametersImpl) {
        NativeSslSession session;
        boolean z;
        boolean z2 = true;
        if (str == null || (session = getSession(str, i)) == null) {
            return null;
        }
        String protocol = session.getProtocol();
        String[] strArr = sSLParametersImpl.enabledProtocols;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            } else if (protocol.equals(strArr[i2])) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            String cipherSuite = session.getCipherSuite();
            String[] strArr2 = sSLParametersImpl.enabledCipherSuites;
            int length2 = strArr2.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length2) {
                    z2 = false;
                    break;
                } else if (cipherSuite.equals(strArr2[i3])) {
                    break;
                } else {
                    i3++;
                }
            }
            if (z2) {
                return session;
            }
            return null;
        }
        return null;
    }

    int size() {
        return this.sessionsByHostAndPort.size();
    }

    private NativeSslSession getSession(String str, int i) {
        NativeSslSession nativeSslSession;
        byte[] sessionData;
        NativeSslSession newInstance;
        if (str == null) {
            return null;
        }
        HostAndPort hostAndPort = new HostAndPort(str, i);
        synchronized (this.sessionsByHostAndPort) {
            nativeSslSession = this.sessionsByHostAndPort.get(hostAndPort);
        }
        if (nativeSslSession == null || !nativeSslSession.isValid()) {
            if (this.persistentCache == null || (sessionData = this.persistentCache.getSessionData(str, i)) == null || (newInstance = NativeSslSession.newInstance(this, sessionData, str, i)) == null || !newInstance.isValid()) {
                return null;
            }
            synchronized (this.sessionsByHostAndPort) {
                this.sessionsByHostAndPort.put(hostAndPort, newInstance);
            }
            return newInstance;
        }
        return nativeSslSession;
    }

    @Override // org.conscrypt.AbstractSessionContext
    void onBeforeAddSession(NativeSslSession nativeSslSession) {
        byte[] bytes;
        String peerHost = nativeSslSession.getPeerHost();
        int peerPort = nativeSslSession.getPeerPort();
        if (peerHost != null) {
            HostAndPort hostAndPort = new HostAndPort(peerHost, peerPort);
            synchronized (this.sessionsByHostAndPort) {
                this.sessionsByHostAndPort.put(hostAndPort, nativeSslSession);
            }
            if (this.persistentCache != null && (bytes = nativeSslSession.toBytes()) != null) {
                this.persistentCache.putSessionData(nativeSslSession.toSSLSession(), bytes);
            }
        }
    }

    @Override // org.conscrypt.AbstractSessionContext
    void onBeforeRemoveSession(NativeSslSession nativeSslSession) {
        String peerHost = nativeSslSession.getPeerHost();
        if (peerHost != null) {
            HostAndPort hostAndPort = new HostAndPort(peerHost, nativeSslSession.getPeerPort());
            synchronized (this.sessionsByHostAndPort) {
                this.sessionsByHostAndPort.remove(hostAndPort);
            }
        }
    }

    @Override // org.conscrypt.AbstractSessionContext
    NativeSslSession getSessionFromPersistentCache(byte[] bArr) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class HostAndPort {
        final String host;
        final int port;

        HostAndPort(String str, int i) {
            this.host = str;
            this.port = i;
        }

        public int hashCode() {
            return (this.host.hashCode() * 31) + this.port;
        }

        public boolean equals(Object obj) {
            if (obj instanceof HostAndPort) {
                HostAndPort hostAndPort = (HostAndPort) obj;
                return this.host.equals(hostAndPort.host) && this.port == hostAndPort.port;
            }
            return false;
        }
    }
}
