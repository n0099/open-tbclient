package d.a.d0.d.a;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.prologue.service.network.Request;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.cookie.SM;
/* loaded from: classes2.dex */
public class g extends b {

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f43480a = new ThreadPoolExecutor(0, 5, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Request f43481e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f43482f;

        public a(Request request, k kVar) {
            this.f43481e = request;
            this.f43482f = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            Request request = this.f43481e;
            gVar.h(0, request, request.f9432a, this.f43482f);
        }
    }

    public g(Context context) {
    }

    public static void d(HttpURLConnection httpURLConnection, Request request) throws UnsupportedEncodingException {
        e(httpURLConnection, request);
        Map<String, String> map = request.f9434c;
        if (map == null || map.size() == 0) {
            return;
        }
        for (Map.Entry<String, String> entry : request.f9434c.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public static void e(HttpURLConnection httpURLConnection, Request request) {
        boolean z;
        Map<String, String> map = request.f9434c;
        if (map != null && map.containsKey("Cookie")) {
            return;
        }
        try {
            CookieManager cookieManager = CookieManager.getInstance();
            if (cookieManager != null) {
                String cookie = cookieManager.getCookie(request.f9432a.toString());
                if (TextUtils.isEmpty(cookie)) {
                    return;
                }
                httpURLConnection.setRequestProperty("Cookie", cookie);
            }
        } finally {
            if (!z) {
            }
        }
    }

    public static String f(String str, String str2) throws UnsupportedEncodingException {
        return str == null ? "" : URLEncoder.encode(str, str2);
    }

    public static StringBuffer g(Map<String, String> map, String str) throws UnsupportedEncodingException {
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            stringBuffer.append(entry.getKey());
            stringBuffer.append("=");
            stringBuffer.append(f(entry.getValue(), str));
            stringBuffer.append("&");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer;
    }

    public static void j(HttpURLConnection httpURLConnection) {
        List<String> emptyList;
        boolean z;
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields != null) {
            emptyList = headerFields.get("Set-Cookie");
            List<String> list = headerFields.get(SM.SET_COOKIE2);
            if (list != null && emptyList != null) {
                emptyList.addAll(list);
            }
        } else {
            emptyList = Collections.emptyList();
        }
        try {
            CookieManager cookieManager = CookieManager.getInstance();
            if (emptyList == null || cookieManager == null) {
                return;
            }
            for (String str : emptyList) {
                cookieManager.setCookie(httpURLConnection.getURL().toString(), str);
            }
        } finally {
            if (!z) {
            }
        }
    }

    @Override // d.a.d0.d.a.e
    public void a(Request request, k kVar) {
        this.f43480a.execute(new a(request, kVar));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:(3:24|26|27)|31|32|33|26|27) */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ad, code lost:
        r8 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ba A[Catch: all -> 0x00b4, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00b4, blocks: (B:18:0x0053, B:20:0x0065, B:22:0x006a, B:23:0x006d, B:24:0x006e, B:29:0x0082, B:31:0x0086, B:32:0x009c, B:35:0x00a9, B:46:0x00ba, B:39:0x00b0, B:40:0x00b3), top: B:58:0x0051 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(int i2, Request request, URL url, k kVar) {
        BufferedInputStream bufferedInputStream;
        if (i2 >= 10) {
            kVar.a(new Throwable("Too many redirects"));
            return;
        }
        try {
            byte[] bytes = request.f() ? g(request.f9435d, "utf-8").toString().getBytes() : null;
            HttpURLConnection i3 = i(url, 30000, request.f(), request.f9433b, request.j);
            if (i3 == null) {
                kVar.a(new Exception("Unable to open connection"));
                return;
            }
            try {
                d(i3, request);
                i3.addRequestProperty("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
                boolean z = true;
                try {
                    if (bytes != null) {
                        try {
                            i3.setRequestProperty("Content-Length", String.valueOf(bytes.length));
                            OutputStream outputStream = i3.getOutputStream();
                            try {
                                outputStream.write(bytes, 0, bytes.length);
                                d.a.d0.a.c.k.a(outputStream);
                            } catch (Throwable th) {
                                d.a.d0.a.c.k.a(outputStream);
                                throw th;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            z = false;
                            if (!z) {
                                kVar.a(e);
                            }
                            return;
                        }
                    }
                    j(i3);
                    int responseCode = i3.getResponseCode();
                    int contentLength = i3.getContentLength();
                    try {
                        if (responseCode != 200 && responseCode != 206) {
                            switch (responseCode) {
                                case 300:
                                case 301:
                                case 302:
                                case 303:
                                    h(i2 + 1, request, new URL(url, URLDecoder.decode(i3.getHeaderField("Location"), "UTF-8")), kVar);
                                    break;
                            }
                            return;
                        }
                        kVar.b(contentLength, bufferedInputStream);
                        d.a.d0.a.c.k.a(bufferedInputStream);
                        return;
                    } catch (Throwable th2) {
                        d.a.d0.a.c.k.a(bufferedInputStream);
                        throw th2;
                    }
                    bufferedInputStream = new BufferedInputStream(k(i3));
                } finally {
                    i3.disconnect();
                }
            } catch (UnsupportedEncodingException e3) {
                kVar.a(e3);
            }
        } catch (UnsupportedEncodingException e4) {
            kVar.a(e4);
        }
    }

    public final HttpURLConnection i(URL url, int i2, boolean z, String str, boolean z2) {
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
            try {
                if (httpURLConnection2 instanceof HttpsURLConnection) {
                    ((HttpsURLConnection) httpURLConnection2).setSSLSocketFactory(j.b());
                    ((HttpsURLConnection) httpURLConnection2).setHostnameVerifier(j.a());
                }
                httpURLConnection2.setInstanceFollowRedirects(true);
                if (z2) {
                    httpURLConnection2.setConnectTimeout(d.f43476b);
                    httpURLConnection2.setReadTimeout(d.f43477c);
                } else {
                    httpURLConnection2.setConnectTimeout(i2);
                    httpURLConnection2.setReadTimeout(60000);
                }
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setDoOutput(z);
                httpURLConnection2.setRequestMethod(str);
                if ("POST".equals(str)) {
                    httpURLConnection2.setUseCaches(false);
                } else if ("GET".equals(str)) {
                    httpURLConnection2.setUseCaches(true);
                }
                httpURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                return httpURLConnection2;
            } catch (Throwable th) {
                th = th;
                httpURLConnection = httpURLConnection2;
                d.a.d0.a.c.g gVar = d.a.d0.a.c.g.f43388a;
                gVar.e("OriginHttp", "failed to connect to url " + url, th);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return httpURLConnection;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final InputStream k(HttpURLConnection httpURLConnection) throws IOException {
        String contentEncoding = httpURLConnection.getContentEncoding();
        InputStream inputStream = httpURLConnection.getInputStream();
        return AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(contentEncoding) ? new GZIPInputStream(inputStream) : inputStream;
    }
}
