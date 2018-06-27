package com.sina.weibo.sdk.net;

import android.os.Build;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes2.dex */
public class SSLSocketFactoryCompat extends SSLSocketFactory {
    static String[] cipherSuites;
    static String[] protocols;
    private SSLSocketFactory defaultFactory;

    static {
        String[] supportedProtocols;
        protocols = null;
        cipherSuites = null;
        try {
            SSLSocket sSLSocket = (SSLSocket) SSLSocketFactory.getDefault().createSocket();
            if (sSLSocket != null) {
                LinkedList linkedList = new LinkedList();
                for (String str : sSLSocket.getSupportedProtocols()) {
                    if (!str.toUpperCase().contains("SSL")) {
                        linkedList.add(str);
                    }
                }
                protocols = (String[]) linkedList.toArray(new String[linkedList.size()]);
                if (Build.VERSION.SDK_INT < 21) {
                    List asList = Arrays.asList("TLS_RSA_WITH_AES_256_GCM_SHA384", "TLS_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_ECHDE_RSA_WITH_AES_128_GCM_SHA256", "TLS_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA");
                    List asList2 = Arrays.asList(sSLSocket.getSupportedCipherSuites());
                    HashSet hashSet = new HashSet(asList);
                    hashSet.retainAll(asList2);
                    hashSet.addAll(new HashSet(Arrays.asList(sSLSocket.getEnabledCipherSuites())));
                    cipherSuites = (String[]) hashSet.toArray(new String[hashSet.size()]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public SSLSocketFactoryCompat(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, x509TrustManager != null ? new X509TrustManager[]{x509TrustManager} : null, null);
            this.defaultFactory = sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw new AssertionError();
        }
    }

    private void upgradeTLS(SSLSocket sSLSocket) {
        if (protocols != null) {
            sSLSocket.setEnabledProtocols(protocols);
        }
        if (Build.VERSION.SDK_INT < 21 && cipherSuites != null) {
            sSLSocket.setEnabledCipherSuites(cipherSuites);
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return cipherSuites;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return cipherSuites;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        Socket createSocket = this.defaultFactory.createSocket(socket, str, i, z);
        if (createSocket instanceof SSLSocket) {
            upgradeTLS((SSLSocket) createSocket);
        }
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        Socket createSocket = this.defaultFactory.createSocket(str, i);
        if (createSocket instanceof SSLSocket) {
            upgradeTLS((SSLSocket) createSocket);
        }
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        Socket createSocket = this.defaultFactory.createSocket(str, i, inetAddress, i2);
        if (createSocket instanceof SSLSocket) {
            upgradeTLS((SSLSocket) createSocket);
        }
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        Socket createSocket = this.defaultFactory.createSocket(inetAddress, i);
        if (createSocket instanceof SSLSocket) {
            upgradeTLS((SSLSocket) createSocket);
        }
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        Socket createSocket = this.defaultFactory.createSocket(inetAddress, i, inetAddress2, i2);
        if (createSocket instanceof SSLSocket) {
            upgradeTLS((SSLSocket) createSocket);
        }
        return createSocket;
    }
}
