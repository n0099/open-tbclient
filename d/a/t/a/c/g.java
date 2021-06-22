package d.a.t.a.c;

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
    public Socket f68416c;

    /* renamed from: d  reason: collision with root package name */
    public InputStream f68417d;

    /* renamed from: e  reason: collision with root package name */
    public OutputStream f68418e;

    /* renamed from: f  reason: collision with root package name */
    public String f68419f;

    public g(Context context, String str) {
        super(context);
        this.f68419f = str;
    }

    @Override // d.a.t.a.c.d
    public InputStream b() throws EOFException, IOException {
        return new DataInputStream(this.f68417d);
    }

    @Override // d.a.t.a.c.d
    public void c(e eVar) {
        this.f68374b = eVar;
        if (eVar != null) {
            this.f68417d = eVar.f68378d;
            this.f68418e = eVar.f68379e;
            return;
        }
        this.f68417d = null;
        this.f68418e = null;
    }

    @Override // d.a.t.a.c.d
    public boolean d() {
        return k(this.f68374b);
    }

    @Override // d.a.t.a.c.d
    public e e(String str, int i2) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        return g(str, i2);
    }

    @Override // d.a.t.a.c.d
    public void f(b bVar) throws IOException {
        OutputStream outputStream;
        if (this.f68416c == null || (outputStream = this.f68418e) == null) {
            return;
        }
        outputStream.write(bVar.f68364a);
        this.f68418e.flush();
    }

    public final e g(String str, int i2) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        d.a.t.a.h.e.d("TcpMessageHandler", "---------------ip:" + str + "  port:" + i2 + "-----------------");
        this.f68416c = h(str, i2);
        e eVar = new e();
        Socket socket = this.f68416c;
        if (socket == null) {
            return eVar;
        }
        eVar.f68377c = socket;
        eVar.f68378d = socket.getInputStream();
        eVar.f68379e = this.f68416c.getOutputStream();
        Boolean bool = Boolean.TRUE;
        eVar.f68375a = bool;
        eVar.f68376b = bool;
        return eVar;
    }

    public final Socket h(String str, int i2) throws UnknownHostException, IOException, KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        if (this.f68419f.equals("tcp")) {
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
        SSLSessionCache sSLSessionCache = new SSLSessionCache(this.f68373a);
        if (str.contains("baidu.com")) {
            d.a.t.a.h.e.a("TcpMessageHandler", "localdns begin...,domain:" + str);
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
                d.a.t.a.h.e.c("TcpMessageHandler", "createSocketOnLine", e2);
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
        if (eVar != null && eVar.f68375a.booleanValue()) {
            try {
                if (eVar.f68377c != null) {
                    eVar.f68377c.close();
                    eVar.f68377c = null;
                }
                if (eVar.f68378d != null) {
                    eVar.f68378d.close();
                    eVar.f68378d = null;
                }
                if (eVar.f68379e != null) {
                    eVar.f68379e.close();
                    eVar.f68379e = null;
                    return true;
                }
                return true;
            } catch (IOException e2) {
                d.a.t.a.h.e.c("TcpMessageHandler", "destroy:", e2);
                return false;
            }
        }
        return true;
    }
}
