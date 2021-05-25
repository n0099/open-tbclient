package d.a.j0.f;

import android.annotation.SuppressLint;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f40403a;

    /* renamed from: b  reason: collision with root package name */
    public static X509TrustManager f40404b;

    /* loaded from: classes2.dex */
    public class a implements X509TrustManager {

        /* renamed from: a  reason: collision with root package name */
        public X509TrustManager f40405a;

        public a(c cVar, X509TrustManager x509TrustManager) {
            this.f40405a = null;
            this.f40405a = x509TrustManager;
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            try {
                this.f40405a.checkClientTrusted(x509CertificateArr, str);
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
            }
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            try {
                this.f40405a.checkServerTrusted(x509CertificateArr, str);
            } catch (Throwable th) {
                try {
                    d.a.j0.l.c.d(th);
                    if (th instanceof CertificateException) {
                        throw th;
                    }
                    throw new CertificateException();
                } catch (Throwable th2) {
                    d.a.j0.l.c.d(th2);
                }
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return this.f40405a.getAcceptedIssuers();
        }
    }

    public c() {
        a();
    }

    public static void b(HttpsURLConnection httpsURLConnection) {
        try {
            if (f40403a == null) {
                synchronized (c.class) {
                    f40403a = new c();
                }
            }
            f40403a.c(httpsURLConnection);
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0076 A[ORIG_RETURN, RETURN] */
    @SuppressLint({"TrulyRandom"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        KeyStore keyStore;
        try {
            keyStore = KeyStore.getInstance("AndroidCAStore");
            try {
                keyStore.load(null, null);
            } catch (Throwable unused) {
                try {
                    String property = System.getProperty("javax.net.ssl.trustStore");
                    String property2 = System.getProperty("javax.net.ssl.trustStorePassword");
                    char[] charArray = property2 == null ? null : property2.toCharArray();
                    keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(property));
                    keyStore.load(bufferedInputStream, charArray);
                    bufferedInputStream.close();
                    if (keyStore == null) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        if (keyStore == null) {
            Class<?> cls = Class.forName("com.android.org.conscrypt.TrustManagerImpl");
            if (cls == null) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.TrustManagerImpl");
            }
            if (cls != null) {
                f40404b = (X509TrustManager) cls.getDeclaredConstructor(KeyStore.class).newInstance(keyStore);
            }
        }
    }

    public final void c(HttpsURLConnection httpsURLConnection) {
        if (httpsURLConnection != null) {
            try {
                if (f40404b == null) {
                    return;
                }
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, new TrustManager[]{new a(this, f40404b)}, new SecureRandom());
                httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
            }
        }
    }
}
