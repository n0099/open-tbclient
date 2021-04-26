package d.a.s.a.e;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.IMHttpDnsUrlRequest;
import java.io.IOException;
import java.net.SocketException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static C1740c f63938a;

    /* loaded from: classes2.dex */
    public static class a implements Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f63939a;

        public a(d dVar) {
            this.f63939a = dVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(@NonNull Call call, @NonNull IOException iOException) {
            String str = "HttpRequest error :" + iOException.toString();
            if (iOException instanceof SocketException) {
                str = "HttpRequest SocketException :" + iOException.toString();
            }
            c.c(this.f63939a, 10003, str);
        }

        @Override // okhttp3.Callback
        public void onResponse(@NonNull Call call, @NonNull Response response) {
            try {
                if (response.code() != 200) {
                    c.c(this.f63939a, response.code(), response.message());
                } else if (response.body() == null) {
                    c.c(this.f63939a, 10004, "response body empty");
                } else {
                    byte[] bytes = response.body().bytes();
                    d.a.s.a.g.d.b("HttpExecutor", "onSuccess errorCode ：" + response.code() + ", errorMsg :" + new String(bytes));
                    this.f63939a.onSuccess(bytes);
                }
            } catch (IOException e2) {
                d dVar = this.f63939a;
                c.c(dVar, 10001, "parse response exception ：" + e2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        Map<String, String> getHeaders();

        String getHost();

        String getMediaType();

        String getMethod();

        byte[] getRequestParameter();
    }

    /* renamed from: d.a.s.a.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1740c implements X509TrustManager {
        public C1740c() {
        }

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

        public /* synthetic */ C1740c(a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void onFailure(int i2, String str);

        void onSuccess(byte[] bArr);
    }

    /* loaded from: classes2.dex */
    public static class e implements HostnameVerifier {
        public e() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    public static SSLSocketFactory b() {
        try {
            f63938a = new C1740c(null);
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{f63938a}, new SecureRandom());
            return sSLContext.getSocketFactory();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void c(@NonNull d dVar, int i2, String str) {
        dVar.onFailure(i2, str);
        d.a.s.a.g.d.b("HttpExecutor", "failedResponse errorCode ：" + i2 + ", errorMsg :" + str);
    }

    public static Headers d(Map<String, String> map) {
        try {
            Headers.Builder builder = new Headers.Builder();
            if (map != null && map.size() > 0) {
                for (String str : map.keySet()) {
                    String str2 = str.toString();
                    builder.add(str2, map.get(str2));
                }
            }
            return builder.build();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void e(@NonNull b bVar, @NonNull d dVar) {
        Request build;
        try {
            String host = bVar.getHost();
            byte[] requestParameter = bVar.getRequestParameter();
            if (requestParameter != null && requestParameter.length > 0) {
                OkHttpClient build2 = new OkHttpClient.Builder().connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).build();
                if (bVar.getMethod().equals("POST")) {
                    build = new Request.Builder().url(host).post(RequestBody.create(MediaType.parse(bVar.getMediaType()), requestParameter)).build();
                } else {
                    if (requestParameter != null && requestParameter.length > 0) {
                        host = host + "?" + new String(requestParameter);
                    }
                    build = new Request.Builder().url(host).build();
                }
                Map<String, String> headers = bVar.getHeaders();
                Headers d2 = d(headers);
                if (headers != null && d2 != null) {
                    build = build.newBuilder().headers(d2).build();
                    String str = headers.get("Host");
                    if (!TextUtils.isEmpty(str) && str.contains(IMHttpDnsUrlRequest.HTTP_DNS_HOST)) {
                        build2 = build2.newBuilder().sslSocketFactory(b(), f63938a).hostnameVerifier(new e(null)).build();
                    }
                }
                d.a.s.a.g.d.a("HttpExecutor", "request url :" + host + " , method :" + bVar.getMethod() + " , body :" + new String(bVar.getRequestParameter()));
                build2.newCall(build).enqueue(new a(dVar));
                return;
            }
            c(dVar, 10000, "request args exception");
        } catch (Exception e2) {
            c(dVar, 10004, "request exception :" + e2);
        }
    }
}
