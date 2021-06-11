package d.a.j0.f;

import android.annotation.SuppressLint;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f44082a;

    /* renamed from: b  reason: collision with root package name */
    public static SSLSocketFactory f44083b;

    /* loaded from: classes2.dex */
    public class a implements X509TrustManager {

        /* renamed from: a  reason: collision with root package name */
        public X509TrustManager f44084a;

        public a(c cVar, X509TrustManager x509TrustManager) {
            this.f44084a = null;
            this.f44084a = x509TrustManager;
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            this.f44084a.checkClientTrusted(x509CertificateArr, str);
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            try {
                this.f44084a.checkServerTrusted(x509CertificateArr, str);
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
                if ((th instanceof CertificateExpiredException) || (th instanceof CertificateNotYetValidException)) {
                    return;
                }
                if (th instanceof CertificateException) {
                    throw th;
                }
                throw new CertificateException();
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return this.f44084a.getAcceptedIssuers();
        }
    }

    public c() {
        a();
    }

    public static void b(HttpsURLConnection httpsURLConnection) {
        try {
            if (f44082a == null) {
                synchronized (c.class) {
                    f44082a = new c();
                }
            }
            f44082a.c(httpsURLConnection);
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
        }
    }

    @SuppressLint({"TrulyRandom"})
    public final void a() {
        try {
            if (f44083b != null) {
                return;
            }
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length >= 1 && (trustManagers[0] instanceof X509TrustManager)) {
                sSLContext.init(null, new TrustManager[]{new a(this, (X509TrustManager) trustManagers[0])}, new SecureRandom());
                f44083b = sSLContext.getSocketFactory();
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected default trust managers:");
            sb.append(Arrays.toString(trustManagers));
            throw new IllegalStateException(sb.toString());
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
        }
    }

    public final void c(HttpsURLConnection httpsURLConnection) {
        if (httpsURLConnection != null) {
            try {
                if (f44083b == null) {
                    return;
                }
                httpsURLConnection.setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                httpsURLConnection.setSSLSocketFactory(f44083b);
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
            }
        }
    }
}
