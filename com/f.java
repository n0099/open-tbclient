package com;

import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;
/* loaded from: classes.dex */
class f extends SSLSocketFactory {
    private SSLContext a;

    public f(KeyStore keyStore) {
        super(keyStore);
        g gVar = new g(this);
        this.a = SSLContext.getInstance("TLS");
        this.a.init(null, new TrustManager[]{gVar}, null);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() {
        return this.a.getSocketFactory().createSocket();
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        return this.a.getSocketFactory().createSocket(socket, str, i, z);
    }
}
