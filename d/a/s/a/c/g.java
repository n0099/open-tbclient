package d.a.s.a.c;

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
    public Socket f64617c;

    /* renamed from: d  reason: collision with root package name */
    public InputStream f64618d;

    /* renamed from: e  reason: collision with root package name */
    public OutputStream f64619e;

    /* renamed from: f  reason: collision with root package name */
    public String f64620f;

    public g(Context context, String str) {
        super(context);
        this.f64620f = str;
    }

    @Override // d.a.s.a.c.d
    public InputStream b() throws EOFException, IOException {
        return new DataInputStream(this.f64618d);
    }

    @Override // d.a.s.a.c.d
    public void c(e eVar) {
        this.f64576b = eVar;
        if (eVar != null) {
            this.f64618d = eVar.f64580d;
            this.f64619e = eVar.f64581e;
            return;
        }
        this.f64618d = null;
        this.f64619e = null;
    }

    @Override // d.a.s.a.c.d
    public boolean d() {
        return k(this.f64576b);
    }

    @Override // d.a.s.a.c.d
    public e e(String str, int i2) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        return g(str, i2);
    }

    @Override // d.a.s.a.c.d
    public void f(b bVar) throws IOException {
        OutputStream outputStream;
        if (this.f64617c == null || (outputStream = this.f64619e) == null) {
            return;
        }
        outputStream.write(bVar.f64566a);
        this.f64619e.flush();
    }

    public final e g(String str, int i2) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        d.a.s.a.g.d.d("TcpMessageHandler", "---------------ip:" + str + "  port:" + i2 + "-----------------");
        this.f64617c = h(str, i2);
        e eVar = new e();
        Socket socket = this.f64617c;
        if (socket == null) {
            return eVar;
        }
        eVar.f64579c = socket;
        eVar.f64580d = socket.getInputStream();
        eVar.f64581e = this.f64617c.getOutputStream();
        Boolean bool = Boolean.TRUE;
        eVar.f64577a = bool;
        eVar.f64578b = bool;
        return eVar;
    }

    public final Socket h(String str, int i2) throws UnknownHostException, IOException, KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        if (this.f64620f.equals("tcp")) {
            return j(str, i2);
        }
        return i(str, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
        r9 = r6.getHostAddress();
     */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Socket i(String str, int i2) throws UnknownHostException, IOException, CertificateException, KeyStoreException, NoSuchAlgorithmException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, KeyManagementException, TimeoutException, SSLHandshakeException, AssertionError {
        SSLCertificateSocketFactory sSLCertificateSocketFactory;
        SSLSessionCache sSLSessionCache = new SSLSessionCache(this.f64575a);
        if (str.contains("baidu.com")) {
            d.a.s.a.g.d.a("TcpMessageHandler", "localdns begin...,domain:" + str);
            try {
                InetAddress[] allByName = InetAddress.getAllByName(str);
                if (allByName != null && allByName.length > 0) {
                    int length = allByName.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        }
                        InetAddress inetAddress = allByName[i3];
                        if (inetAddress instanceof Inet4Address) {
                            break;
                        }
                        i3++;
                    }
                }
            } catch (Exception e2) {
                d.a.s.a.g.d.c("TcpMessageHandler", "createSocketOnLine", e2);
            }
        }
        if (str.contains("baidu.com")) {
            sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(10000, sSLSessionCache);
        } else {
            sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getInsecure(10000, sSLSessionCache);
        }
        if (sSLCertificateSocketFactory != null) {
            SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(str, i2);
            sSLSocket.setEnabledCipherSuites(sSLSocket.getEnabledCipherSuites());
            sSLSocket.setEnabledProtocols(sSLSocket.getEnabledProtocols());
            sSLCertificateSocketFactory.setUseSessionTickets(sSLSocket, true);
            sSLSocket.startHandshake();
            return sSLSocket;
        }
        return null;
    }

    public final Socket j(String str, int i2) throws UnknownHostException, IOException {
        return new Socket(str, i2);
    }

    public boolean k(e eVar) {
        if (eVar != null && eVar.f64577a.booleanValue()) {
            try {
                if (eVar.f64579c != null) {
                    eVar.f64579c.close();
                    eVar.f64579c = null;
                }
                if (eVar.f64580d != null) {
                    eVar.f64580d.close();
                    eVar.f64580d = null;
                }
                if (eVar.f64581e != null) {
                    eVar.f64581e.close();
                    eVar.f64581e = null;
                    return true;
                }
                return true;
            } catch (IOException e2) {
                d.a.s.a.g.d.c("TcpMessageHandler", "destroy:", e2);
                return false;
            }
        }
        return true;
    }
}
