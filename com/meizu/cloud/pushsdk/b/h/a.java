package com.meizu.cloud.pushsdk.b.h;

import android.content.Context;
import android.net.SSLSessionCache;
import android.os.Environment;
import com.baidu.mobstat.Config;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes20.dex */
public class a extends SSLSocketFactory {
    private String a = "TlsSessionTicket";
    private SSLSocketFactory b;

    public a(Context context) {
        SSLSessionCache sSLSessionCache;
        try {
            SSLContext sSLContext = SSLContext.getDefault();
            try {
                sSLSessionCache = new SSLSessionCache(new File(Environment.getExternalStorageDirectory(), "sslCache"));
            } catch (IOException e) {
                com.meizu.cloud.a.a.e(this.a, e.getMessage());
                sSLSessionCache = new SSLSessionCache(context);
            }
            com.meizu.cloud.a.a.i(this.a, "install tls session cache " + com.meizu.cloud.pushsdk.base.a.a.a(sSLSessionCache).a(Config.INPUT_INSTALLED_PKG, SSLSessionCache.class, SSLContext.class).a(sSLSessionCache, sSLSessionCache, sSLContext).a);
            this.b = sSLContext.getSocketFactory();
        } catch (Exception e2) {
            com.meizu.cloud.a.a.e(this.a, e2.getMessage());
            this.b = (SSLSocketFactory) SSLSocketFactory.getDefault();
        }
    }

    private Socket a(Socket socket) {
        if (socket instanceof SSLSocket) {
            com.meizu.cloud.a.a.i(this.a, "set ssl session ticket support " + com.meizu.cloud.pushsdk.base.a.a.a(socket).a("setUseSessionTickets", Boolean.TYPE).a(socket, true).a);
        }
        return socket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        return a(this.b.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        return a(this.b.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return a(this.b.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return a(this.b.createSocket(inetAddress, i, inetAddress2, i2));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return a(this.b.createSocket(socket, str, i, z));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.b.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.b.getSupportedCipherSuites();
    }
}
