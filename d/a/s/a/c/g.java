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
    public Socket f63930c;

    /* renamed from: d  reason: collision with root package name */
    public InputStream f63931d;

    /* renamed from: e  reason: collision with root package name */
    public OutputStream f63932e;

    /* renamed from: f  reason: collision with root package name */
    public String f63933f;

    public g(Context context, String str) {
        super(context);
        this.f63933f = str;
    }

    @Override // d.a.s.a.c.d
    public InputStream b() throws EOFException, IOException {
        return new DataInputStream(this.f63931d);
    }

    @Override // d.a.s.a.c.d
    public void c(e eVar) {
        this.f63889b = eVar;
        if (eVar != null) {
            this.f63931d = eVar.f63893d;
            this.f63932e = eVar.f63894e;
            return;
        }
        this.f63931d = null;
        this.f63932e = null;
    }

    @Override // d.a.s.a.c.d
    public boolean d() {
        return k(this.f63889b);
    }

    @Override // d.a.s.a.c.d
    public e e(String str, int i2) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        return g(str, i2);
    }

    @Override // d.a.s.a.c.d
    public void f(b bVar) throws IOException {
        OutputStream outputStream;
        if (this.f63930c == null || (outputStream = this.f63932e) == null) {
            return;
        }
        outputStream.write(bVar.f63879a);
        this.f63932e.flush();
    }

    public final e g(String str, int i2) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        d.a.s.a.g.d.d("TcpMessageHandler", "---------------ip:" + str + "  port:" + i2 + "-----------------");
        this.f63930c = h(str, i2);
        e eVar = new e();
        Socket socket = this.f63930c;
        if (socket == null) {
            return eVar;
        }
        eVar.f63892c = socket;
        eVar.f63893d = socket.getInputStream();
        eVar.f63894e = this.f63930c.getOutputStream();
        Boolean bool = Boolean.TRUE;
        eVar.f63890a = bool;
        eVar.f63891b = bool;
        return eVar;
    }

    public final Socket h(String str, int i2) throws UnknownHostException, IOException, KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        if (this.f63933f.equals("tcp")) {
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
        SSLSessionCache sSLSessionCache = new SSLSessionCache(this.f63888a);
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
        if (eVar != null && eVar.f63890a.booleanValue()) {
            try {
                if (eVar.f63892c != null) {
                    eVar.f63892c.close();
                    eVar.f63892c = null;
                }
                if (eVar.f63893d != null) {
                    eVar.f63893d.close();
                    eVar.f63893d = null;
                }
                if (eVar.f63894e != null) {
                    eVar.f63894e.close();
                    eVar.f63894e = null;
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
