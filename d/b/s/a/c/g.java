package d.b.s.a.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSocket;
/* loaded from: classes2.dex */
public class g extends d {

    /* renamed from: c  reason: collision with root package name */
    public Socket f65606c;

    /* renamed from: d  reason: collision with root package name */
    public InputStream f65607d;

    /* renamed from: e  reason: collision with root package name */
    public OutputStream f65608e;

    /* renamed from: f  reason: collision with root package name */
    public String f65609f;

    public g(Context context, String str) {
        super(context);
        this.f65609f = str;
    }

    @Override // d.b.s.a.c.d
    public InputStream b() throws EOFException, IOException {
        return new DataInputStream(this.f65607d);
    }

    @Override // d.b.s.a.c.d
    public void c(e eVar) {
        this.f65566b = eVar;
        if (eVar != null) {
            this.f65607d = eVar.f65570d;
            this.f65608e = eVar.f65571e;
            return;
        }
        this.f65607d = null;
        this.f65608e = null;
    }

    @Override // d.b.s.a.c.d
    public boolean d() {
        return k(this.f65566b);
    }

    @Override // d.b.s.a.c.d
    public e e(String str, int i) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        return g(str, i);
    }

    @Override // d.b.s.a.c.d
    public void f(b bVar) throws IOException {
        OutputStream outputStream;
        if (this.f65606c == null || (outputStream = this.f65608e) == null) {
            return;
        }
        outputStream.write(bVar.f65557a);
        this.f65608e.flush();
    }

    public final e g(String str, int i) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        d.b.s.a.g.d.d("TcpMessageHandler", "---------------ip:" + str + "  port:" + i + "-----------------");
        this.f65606c = h(str, i);
        e eVar = new e();
        Socket socket = this.f65606c;
        if (socket == null) {
            return eVar;
        }
        eVar.f65569c = socket;
        eVar.f65570d = socket.getInputStream();
        eVar.f65571e = this.f65606c.getOutputStream();
        Boolean bool = Boolean.TRUE;
        eVar.f65567a = bool;
        eVar.f65568b = bool;
        return eVar;
    }

    public final Socket h(String str, int i) throws UnknownHostException, IOException, KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        if (this.f65609f.equals("tcp")) {
            return j(str, i);
        }
        return i(str, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
        r9 = r6.getHostAddress();
     */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Socket i(String str, int i) throws UnknownHostException, IOException, CertificateException, KeyStoreException, NoSuchAlgorithmException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, KeyManagementException, TimeoutException, SSLHandshakeException, AssertionError {
        SSLCertificateSocketFactory sSLCertificateSocketFactory;
        SSLSessionCache sSLSessionCache = new SSLSessionCache(this.f65565a);
        if (str.contains("baidu.com")) {
            d.b.s.a.g.d.a("TcpMessageHandler", "localdns begin...,domain:" + str);
            try {
                InetAddress[] allByName = InetAddress.getAllByName(str);
                if (allByName != null && allByName.length > 0) {
                    int length = allByName.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        InetAddress inetAddress = allByName[i2];
                        if (inetAddress instanceof Inet4Address) {
                            break;
                        }
                        i2++;
                    }
                }
            } catch (Exception e2) {
                d.b.s.a.g.d.c("TcpMessageHandler", "createSocketOnLine", e2);
            }
        }
        if (str.contains("baidu.com")) {
            sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(10000, sSLSessionCache);
        } else {
            sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getInsecure(10000, sSLSessionCache);
        }
        if (sSLCertificateSocketFactory != null) {
            SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(str, i);
            sSLSocket.setEnabledCipherSuites(sSLSocket.getEnabledCipherSuites());
            sSLSocket.setEnabledProtocols(sSLSocket.getEnabledProtocols());
            sSLCertificateSocketFactory.setUseSessionTickets(sSLSocket, true);
            sSLSocket.startHandshake();
            return sSLSocket;
        }
        return null;
    }

    public final Socket j(String str, int i) throws UnknownHostException, IOException {
        return new Socket(str, i);
    }

    public boolean k(e eVar) {
        if (eVar != null && eVar.f65567a.booleanValue()) {
            try {
                if (eVar.f65569c != null) {
                    eVar.f65569c.close();
                    eVar.f65569c = null;
                }
                if (eVar.f65570d != null) {
                    eVar.f65570d.close();
                    eVar.f65570d = null;
                }
                if (eVar.f65571e != null) {
                    eVar.f65571e.close();
                    eVar.f65571e = null;
                    return true;
                }
                return true;
            } catch (IOException e2) {
                d.b.s.a.g.d.c("TcpMessageHandler", "destroy:", e2);
                return false;
            }
        }
        return true;
    }
}
