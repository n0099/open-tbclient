package d.b.c.a.b.a.i;

import com.bytedance.sdk.a.b.w;
import d.b.c.a.b.a.k.f;
import d.b.c.a.b.y;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f69306a = a();

    /* renamed from: b  reason: collision with root package name */
    public static final Logger f69307b = Logger.getLogger(y.class.getName());

    public static e a() {
        e a2 = a.a();
        if (a2 != null) {
            return a2;
        }
        b o = b.o();
        if (o != null) {
            return o;
        }
        e a3 = c.a();
        return a3 != null ? a3 : new e();
    }

    public static List<String> e(List<w> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            w wVar = list.get(i2);
            if (wVar != w.HTTP_1_0) {
                arrayList.add(wVar.toString());
            }
        }
        return arrayList;
    }

    public static e j() {
        return f69306a;
    }

    public static byte[] n(List<w> list) {
        d.b.c.a.a.c cVar = new d.b.c.a.a.c();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            w wVar = list.get(i2);
            if (wVar != w.HTTP_1_0) {
                cVar.w(wVar.toString().length());
                cVar.p(wVar.toString());
            }
        }
        return cVar.K();
    }

    public d.b.c.a.b.a.k.c b(X509TrustManager x509TrustManager) {
        return new d.b.c.a.b.a.k.a(k(x509TrustManager));
    }

    public Object c(String str) {
        if (f69307b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public String d(SSLSocket sSLSocket) {
        return null;
    }

    public void f(int i2, String str, Throwable th) {
        f69307b.log(i2 == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void g(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        f(5, str, (Throwable) obj);
    }

    public void h(Socket socket, InetSocketAddress inetSocketAddress, int i2) throws IOException {
        socket.connect(inetSocketAddress, i2);
    }

    public void i(SSLSocket sSLSocket, String str, List<w> list) {
    }

    public f k(X509TrustManager x509TrustManager) {
        return new d.b.c.a.b.a.k.b(x509TrustManager.getAcceptedIssuers());
    }

    public void l(SSLSocket sSLSocket) {
    }

    public boolean m(String str) {
        return true;
    }
}
