package d.r.b.a.a.m.c.b;

import android.os.Build;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.http.StatisticsAppInfo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f68130a = "c";

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f68131b = Pattern.compile("\\d+\\.\\d+\\.\\d+\\.\\d+");

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f68132a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f68133b = -1;

        /* renamed from: c  reason: collision with root package name */
        public String f68134c = null;

        /* renamed from: d  reason: collision with root package name */
        public String f68135d = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00c8 A[Catch: all -> 0x00cc, TRY_ENTER, TryCatch #3 {all -> 0x00cc, blocks: (B:22:0x00b1, B:24:0x00b6, B:32:0x00c8, B:36:0x00d0), top: B:55:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d0 A[Catch: all -> 0x00cc, TRY_LEAVE, TryCatch #3 {all -> 0x00cc, blocks: (B:22:0x00b1, B:24:0x00b6, B:32:0x00c8, B:36:0x00d0), top: B:55:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a a(String str, String str2) throws IOException {
        InputStream inputStream;
        a aVar = new a();
        HttpURLConnection httpURLConnection = null;
        InputStream inputStream2 = null;
        try {
            if (str2 != null) {
                try {
                    if (str2.length() > 0) {
                        str = String.format("%s?%s", str, str2);
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream = null;
                    try {
                        d.r.b.a.a.m.c.d.d.b(f68130a, "getByUrlConn", th);
                        if (httpURLConnection != null) {
                        }
                        if (inputStream != null) {
                        }
                        return aVar;
                    } catch (Throwable th2) {
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable th3) {
                                d.r.b.a.a.m.c.d.d.b(f68130a, "getByUrlConn", th3);
                                throw th2;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        throw th2;
                    }
                }
            }
            HttpURLConnection c2 = c(str);
            try {
                c2.setConnectTimeout(30000);
                c2.setReadTimeout(60000);
                c2.setUseCaches(false);
                c2.setRequestMethod("GET");
                c2.setInstanceFollowRedirects(true);
                c2.connect();
                aVar.f68132a = c2.getResponseCode() == 200;
                aVar.f68133b = c2.getResponseCode();
                aVar.f68134c = c2.getResponseMessage();
                if (c2.getResponseCode() == 200) {
                    d.r.b.a.a.m.c.d.d.e(f68130a, "get url=[%s] is ok", str);
                    inputStream2 = c2.getInputStream();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    String str3 = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    aVar.f68135d = str3;
                    d.r.b.a.a.m.c.d.d.e(f68130a, "the result is %s", str3);
                    byteArrayOutputStream.close();
                } else {
                    d.r.b.a.a.m.c.d.d.h(f68130a, "http get [%s] error! status:%d", str, Integer.valueOf(c2.getResponseCode()));
                }
                if (c2 != null) {
                    c2.disconnect();
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection = c2;
                inputStream = null;
                d.r.b.a.a.m.c.d.d.b(f68130a, "getByUrlConn", th);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return aVar;
            }
        } catch (Throwable th5) {
            d.r.b.a.a.m.c.d.d.b(f68130a, "getByUrlConn", th5);
        }
        return aVar;
    }

    public static boolean b(String str) {
        return f68131b.matcher(str).matches();
    }

    public static HttpURLConnection c(String str) throws IOException {
        int i2;
        URL url = new URL(str);
        if (Build.VERSION.SDK_INT > 27 && ((i2 = StatisticsAppInfo.INSTANCE.targetSdkVersion) > 27 || i2 == 0)) {
            if (!url.getProtocol().equalsIgnoreCase("https")) {
                url = new URL("https" + str.substring(url.getProtocol().length()));
            }
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            if (b(url.getHost())) {
                httpsURLConnection.setSSLSocketFactory(d.b());
                httpsURLConnection.setHostnameVerifier(d.a());
            }
            return httpsURLConnection;
        }
        return (HttpURLConnection) url.openConnection();
    }
}
