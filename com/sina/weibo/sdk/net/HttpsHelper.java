package com.sina.weibo.sdk.net;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes2.dex */
class HttpsHelper {
    private static SSLSocketFactory sslSocketFactory;

    HttpsHelper() {
    }

    public static SSLSocketFactory getSSL(Context context) {
        if (sslSocketFactory != null) {
            return sslSocketFactory;
        }
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            keyStore.setCertificateEntry("get_global_ca", getCertificate("geo_global_ca.cer", context));
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{new KeyStoresTrustManagerEX(keyStore)}, null);
            sslSocketFactory = sSLContext.getSocketFactory();
        } catch (Exception e) {
        }
        return sslSocketFactory;
    }

    private static Certificate getCertificate(String str, Context context) throws CertificateException, IOException {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        InputStream open = context.getAssets().open(str);
        try {
            return certificateFactory.generateCertificate(open);
        } finally {
            if (open != null) {
                open.close();
            }
        }
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
