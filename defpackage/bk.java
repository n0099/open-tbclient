package defpackage;

import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;
/* renamed from: bk  reason: default package */
/* loaded from: classes.dex */
class bk extends SSLSocketFactory {
    private SSLContext a;

    public bk(KeyStore keyStore) {
        super(keyStore);
        bl blVar = new bl(this);
        this.a = SSLContext.getInstance("TLS");
        this.a.init(null, new TrustManager[]{blVar}, null);
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
