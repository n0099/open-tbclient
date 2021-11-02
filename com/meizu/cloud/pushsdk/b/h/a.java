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
/* loaded from: classes2.dex */
public class a extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    public String f67409a = "TlsSessionTicket";

    /* renamed from: b  reason: collision with root package name */
    public SSLSocketFactory f67410b;

    public a(Context context) {
        SSLSessionCache sSLSessionCache;
        try {
            SSLContext sSLContext = SSLContext.getDefault();
            try {
                sSLSessionCache = new SSLSessionCache(new File(Environment.getExternalStorageDirectory(), "sslCache"));
            } catch (IOException e2) {
                b.l.a.a.a.b(this.f67409a, e2.getMessage());
                sSLSessionCache = new SSLSessionCache(context);
            }
            d a2 = com.meizu.cloud.pushsdk.base.a.a.a(sSLSessionCache).a("install", SSLSessionCache.class, SSLContext.class).a(sSLSessionCache, sSLSessionCache, sSLContext);
            String str = this.f67409a;
            b.l.a.a.a.d(str, "install tls session cache " + a2.f67427a);
            this.f67410b = sSLContext.getSocketFactory();
        } catch (Exception e3) {
            b.l.a.a.a.b(this.f67409a, e3.getMessage());
            this.f67410b = (SSLSocketFactory) SSLSocketFactory.getDefault();
        }
    }

    private Socket a(Socket socket) {
        if (socket instanceof SSLSocket) {
            d a2 = com.meizu.cloud.pushsdk.base.a.a.a(socket).a("setUseSessionTickets", Boolean.TYPE).a(socket, Boolean.TRUE);
            String str = this.f67409a;
            b.l.a.a.a.d(str, "set ssl session ticket support " + a2.f67427a);
        }
        return socket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2) throws IOException {
        return a(this.f67410b.createSocket(str, i2));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException, UnknownHostException {
        return a(this.f67410b.createSocket(str, i2, inetAddress, i3));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return a(this.f67410b.createSocket(inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        return a(this.f67410b.createSocket(inetAddress, i2, inetAddress2, i3));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        return a(this.f67410b.createSocket(socket, str, i2, z));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.f67410b.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.f67410b.getSupportedCipherSuites();
    }
}
