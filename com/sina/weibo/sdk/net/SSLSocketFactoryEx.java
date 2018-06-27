package com.sina.weibo.sdk.net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;
/* loaded from: classes2.dex */
public class SSLSocketFactoryEx extends SSLSocketFactory {
    private static final String TAG = SSLSocketFactoryEx.class.getName();
    SSLContext sslContext;

    public SSLSocketFactoryEx(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
        this.sslContext = SSLContext.getInstance("TLS");
        this.sslContext.init(null, new TrustManager[]{new KeyStoresTrustManagerEX(keyStore)}, null);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException, UnknownHostException {
        return this.sslContext.getSocketFactory().createSocket(socket, str, i, z);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        return this.sslContext.getSocketFactory().createSocket();
    }

    /* loaded from: classes2.dex */
    public static class KeyStoresTrustManagerEX implements X509TrustManager {
        protected ArrayList<X509TrustManager> x509TrustManagers = new ArrayList<>();

        protected KeyStoresTrustManagerEX(KeyStore... keyStoreArr) {
            TrustManager[] trustManagers;
            ArrayList arrayList = new ArrayList();
            try {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init((KeyStore) null);
                arrayList.add(trustManagerFactory);
                for (KeyStore keyStore : keyStoreArr) {
                    TrustManagerFactory trustManagerFactory2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                    trustManagerFactory2.init(keyStore);
                    arrayList.add(trustManagerFactory2);
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    for (TrustManager trustManager : ((TrustManagerFactory) it.next()).getTrustManagers()) {
                        if (trustManager instanceof X509TrustManager) {
                            this.x509TrustManagers.add((X509TrustManager) trustManager);
                        }
                    }
                }
                if (this.x509TrustManagers.size() == 0) {
                    throw new RuntimeException("Couldn't find any X509TrustManagers");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            this.x509TrustManagers.get(0).checkClientTrusted(x509CertificateArr, str);
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            Iterator<X509TrustManager> it = this.x509TrustManagers.iterator();
            while (it.hasNext()) {
                try {
                    it.next().checkServerTrusted(x509CertificateArr, str);
                    return;
                } catch (CertificateException e) {
                }
            }
            throw new CertificateException();
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            ArrayList arrayList = new ArrayList();
            Iterator<X509TrustManager> it = this.x509TrustManagers.iterator();
            while (it.hasNext()) {
                arrayList.addAll(Arrays.asList(it.next().getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        }
    }
}
