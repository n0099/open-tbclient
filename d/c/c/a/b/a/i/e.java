package d.c.c.a.b.a.i;

import com.bytedance.sdk.a.b.w;
import d.c.c.a.b.a.k.f;
import d.c.c.a.b.y;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f66262a = a();

    /* renamed from: b  reason: collision with root package name */
    public static final Logger f66263b = Logger.getLogger(y.class.getName());

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
        for (int i = 0; i < size; i++) {
            w wVar = list.get(i);
            if (wVar != w.HTTP_1_0) {
                arrayList.add(wVar.toString());
            }
        }
        return arrayList;
    }

    public static e j() {
        return f66262a;
    }

    public static byte[] n(List<w> list) {
        d.c.c.a.a.c cVar = new d.c.c.a.a.c();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            w wVar = list.get(i);
            if (wVar != w.HTTP_1_0) {
                cVar.w(wVar.toString().length());
                cVar.p(wVar.toString());
            }
        }
        return cVar.K();
    }

    public d.c.c.a.b.a.k.c b(X509TrustManager x509TrustManager) {
        return new d.c.c.a.b.a.k.a(k(x509TrustManager));
    }

    public Object c(String str) {
        if (f66263b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public String d(SSLSocket sSLSocket) {
        return null;
    }

    public void f(int i, String str, Throwable th) {
        f66263b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void g(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        f(5, str, (Throwable) obj);
    }

    public void h(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public void i(SSLSocket sSLSocket, String str, List<w> list) {
    }

    public f k(X509TrustManager x509TrustManager) {
        return new d.c.c.a.b.a.k.b(x509TrustManager.getAcceptedIssuers());
    }

    public void l(SSLSocket sSLSocket) {
    }

    public boolean m(String str) {
        return true;
    }
}
