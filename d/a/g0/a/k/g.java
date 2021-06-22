package d.a.g0.a.k;

import com.baidu.browser.sailor.BdSailorConfig;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes2.dex */
public class g {

    /* loaded from: classes2.dex */
    public static class a implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements TrustManager, X509TrustManager {
        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    /* JADX DEBUG: Throwable added to exception handler: 'Exception', keep only Throwable */
    public static void a() {
        try {
            a aVar = new a();
            b();
            HttpsURLConnection.setDefaultHostnameVerifier(aVar);
        } catch (Throwable unused) {
        }
    }

    public static void b() throws Exception {
        TrustManager[] trustManagerArr = {new b()};
        SSLContext sSLContext = SSLContext.getInstance(BdSailorConfig.SAILOR_BASE_SSL);
        sSLContext.init(null, trustManagerArr, null);
        HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
    }
}
