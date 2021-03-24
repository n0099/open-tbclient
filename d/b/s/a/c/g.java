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
    public Socket f64647c;

    /* renamed from: d  reason: collision with root package name */
    public InputStream f64648d;

    /* renamed from: e  reason: collision with root package name */
    public OutputStream f64649e;

    /* renamed from: f  reason: collision with root package name */
    public String f64650f;

    public g(Context context, String str) {
        super(context);
        this.f64650f = str;
    }

    @Override // d.b.s.a.c.d
    public InputStream b() throws EOFException, IOException {
        return new DataInputStream(this.f64648d);
    }

    @Override // d.b.s.a.c.d
    public void c(e eVar) {
        this.f64607b = eVar;
        if (eVar != null) {
            this.f64648d = eVar.f64611d;
            this.f64649e = eVar.f64612e;
            return;
        }
        this.f64648d = null;
        this.f64649e = null;
    }

    @Override // d.b.s.a.c.d
    public boolean d() {
        return k(this.f64607b);
    }

    @Override // d.b.s.a.c.d
    public e e(String str, int i) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        return g(str, i);
    }

    @Override // d.b.s.a.c.d
    public void f(b bVar) throws IOException {
        OutputStream outputStream;
        if (this.f64647c == null || (outputStream = this.f64649e) == null) {
            return;
        }
        outputStream.write(bVar.f64598a);
        this.f64649e.flush();
    }

    public final e g(String str, int i) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        d.b.s.a.g.d.d("TcpMessageHandler", "---------------ip:" + str + "  port:" + i + "-----------------");
        this.f64647c = h(str, i);
        e eVar = new e();
        Socket socket = this.f64647c;
        if (socket == null) {
            return eVar;
        }
        eVar.f64610c = socket;
        eVar.f64611d = socket.getInputStream();
        eVar.f64612e = this.f64647c.getOutputStream();
        Boolean bool = Boolean.TRUE;
        eVar.f64608a = bool;
        eVar.f64609b = bool;
        return eVar;
    }

    public final Socket h(String str, int i) throws UnknownHostException, IOException, KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        if (this.f64650f.equals("tcp")) {
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
        SSLSessionCache sSLSessionCache = new SSLSessionCache(this.f64606a);
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
        if (eVar != null && eVar.f64608a.booleanValue()) {
            try {
                if (eVar.f64610c != null) {
                    eVar.f64610c.close();
                    eVar.f64610c = null;
                }
                if (eVar.f64611d != null) {
                    eVar.f64611d.close();
                    eVar.f64611d = null;
                }
                if (eVar.f64612e != null) {
                    eVar.f64612e.close();
                    eVar.f64612e = null;
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
