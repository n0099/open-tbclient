package com.meizu.cloud.pushsdk.b.h;

import android.content.Context;
import android.net.SSLSessionCache;
import android.os.Environment;
import com.meizu.cloud.pushsdk.base.a.d;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes6.dex */
public class a extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    public String f37616a = "TlsSessionTicket";

    /* renamed from: b  reason: collision with root package name */
    public SSLSocketFactory f37617b;

    public a(Context context) {
        SSLSessionCache sSLSessionCache;
        try {
            SSLContext sSLContext = SSLContext.getDefault();
            try {
                sSLSessionCache = new SSLSessionCache(new File(Environment.getExternalStorageDirectory(), "sslCache"));
            } catch (IOException e2) {
                d.j.a.a.a.b(this.f37616a, e2.getMessage());
                sSLSessionCache = new SSLSessionCache(context);
            }
            d a2 = com.meizu.cloud.pushsdk.base.a.a.a(sSLSessionCache).a("install", SSLSessionCache.class, SSLContext.class).a(sSLSessionCache, sSLSessionCache, sSLContext);
            String str = this.f37616a;
            d.j.a.a.a.d(str, "install tls session cache " + a2.f37634a);
            this.f37617b = sSLContext.getSocketFactory();
        } catch (Exception e3) {
            d.j.a.a.a.b(this.f37616a, e3.getMessage());
            this.f37617b = (SSLSocketFactory) SSLSocketFactory.getDefault();
        }
    }

    private Socket a(Socket socket) {
        if (socket instanceof SSLSocket) {
            d a2 = com.meizu.cloud.pushsdk.base.a.a.a(socket).a("setUseSessionTickets", Boolean.TYPE).a(socket, Boolean.TRUE);
            String str = this.f37616a;
            d.j.a.a.a.d(str, "set ssl session ticket support " + a2.f37634a);
        }
        return socket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        return a(this.f37617b.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        return a(this.f37617b.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return a(this.f37617b.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return a(this.f37617b.createSocket(inetAddress, i, inetAddress2, i2));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return a(this.f37617b.createSocket(socket, str, i, z));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.f37617b.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.f37617b.getSupportedCipherSuites();
    }
}
