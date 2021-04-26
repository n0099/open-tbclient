package d.r.b.a.a.m.c.b;

import com.baidu.browser.sailor.BdSailorConfig;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes7.dex */
public class d {

    /* loaded from: classes7.dex */
    public static class a implements X509TrustManager {
        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    public static HostnameVerifier a() {
        return new b();
    }

    public static SSLSocketFactory b() {
        try {
            SSLContext sSLContext = SSLContext.getInstance(BdSailorConfig.SAILOR_BASE_SSL);
            sSLContext.init(null, c(), new SecureRandom());
            return sSLContext.getSocketFactory();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static TrustManager[] c() {
        return new TrustManager[]{new a()};
    }
}
