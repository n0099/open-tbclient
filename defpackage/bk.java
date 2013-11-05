package defpackage;

import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;
/* renamed from: bk  reason: default package */
/* loaded from: classes.dex */
class bk extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    private SSLContext f380a;

    public bk(KeyStore keyStore) {
        super(keyStore);
        bl blVar = new bl(this);
        this.f380a = SSLContext.getInstance("TLS");
        this.f380a.init(null, new TrustManager[]{blVar}, null);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() {
        return this.f380a.getSocketFactory().createSocket();
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        return this.f380a.getSocketFactory().createSocket(socket, str, i, z);
    }
}
