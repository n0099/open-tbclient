package d.b.f0.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import d.b.f0.l.f;
import d.b.f0.l.g;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
@SuppressLint({"TrulyRandom"})
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f42948a;

    /* renamed from: c  reason: collision with root package name */
    public HttpURLConnection f42950c;

    /* renamed from: d  reason: collision with root package name */
    public String f42951d;

    /* renamed from: e  reason: collision with root package name */
    public String f42952e;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f42949b = new byte[1024];

    /* renamed from: f  reason: collision with root package name */
    public int f42953f = 10000;

    /* renamed from: g  reason: collision with root package name */
    public int f42954g = 10000;

    /* renamed from: h  reason: collision with root package name */
    public boolean f42955h = false;
    public boolean i = false;

    public b(Context context, Handler handler) {
        this.f42948a = context;
    }

    public final InputStream a(byte[] bArr, Map<String, String> map, String str) {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                if (d.b.f0.l.c.k(this.f42948a) == 0) {
                    return null;
                }
                HttpURLConnection c2 = c(map);
                this.f42950c = c2;
                if (c2 == null) {
                    return null;
                }
                if (bArr == null) {
                    if (AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(c2.getContentEncoding())) {
                        this.f42955h = true;
                    } else {
                        this.f42955h = false;
                    }
                    this.f42950c.getResponseCode();
                    return this.f42950c.getInputStream();
                }
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(this.f42950c.getOutputStream());
                try {
                    bufferedOutputStream2.write(bArr);
                    bufferedOutputStream2.flush();
                    if (AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(this.f42950c.getContentEncoding())) {
                        this.f42955h = true;
                    } else {
                        this.f42955h = false;
                    }
                    this.f42950c.getResponseCode();
                    InputStream inputStream = this.f42950c.getInputStream();
                    try {
                        bufferedOutputStream2.close();
                    } catch (Throwable th) {
                        d.b.f0.l.c.d(th);
                    }
                    return inputStream;
                } catch (Exception e2) {
                    throw e2;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable th3) {
                            d.b.f0.l.c.d(th3);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    public String b(String str, byte[] bArr, Map<String, String> map) {
        InputStream inputStream;
        d("POST", str);
        try {
            inputStream = a(bArr, map, str);
            if (inputStream == null) {
                if (inputStream != null) {
                    inputStream.close();
                }
                HttpURLConnection httpURLConnection = this.f42950c;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                    this.f42950c = null;
                }
                return null;
            }
            try {
                String f2 = f(inputStream);
                if (inputStream != null) {
                    inputStream.close();
                }
                HttpURLConnection httpURLConnection2 = this.f42950c;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                    this.f42950c = null;
                }
                return f2;
            } catch (Throwable th) {
                th = th;
                if (inputStream != null) {
                    inputStream.close();
                }
                HttpURLConnection httpURLConnection3 = this.f42950c;
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                    this.f42950c = null;
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    public final HttpURLConnection c(Map<String, String> map) {
        HttpURLConnection httpURLConnection;
        String str = null;
        if (this.i || TextUtils.isEmpty(this.f42951d) || TextUtils.isEmpty(this.f42952e)) {
            return null;
        }
        if (!this.f42951d.equals("POST") && !this.f42951d.equals("GET")) {
            this.f42951d = "POST";
        }
        URL url = new URL(this.f42952e);
        int i = 80;
        if (2 != d.b.f0.l.c.k(this.f42948a)) {
            if (Build.VERSION.SDK_INT >= 13) {
                str = System.getProperties().getProperty("http.proxyHost");
                String property = System.getProperties().getProperty("http.proxyPort");
                if (!TextUtils.isEmpty(property)) {
                    try {
                        i = Integer.parseInt(property);
                    } catch (Throwable unused) {
                        i = -1;
                    }
                }
                i = -1;
            } else {
                str = Proxy.getHost(this.f42948a);
                i = Proxy.getPort(this.f42948a);
            }
        }
        if (str != null && i > 0) {
            httpURLConnection = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str, i)));
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        if (this.f42952e.startsWith("https")) {
            c.b((HttpsURLConnection) httpURLConnection);
        }
        httpURLConnection.setRequestMethod(this.f42951d);
        httpURLConnection.setDoInput(true);
        if ("POST".equals(this.f42951d)) {
            httpURLConnection.setDoOutput(true);
        }
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setConnectTimeout(this.f42953f);
        httpURLConnection.setReadTimeout(this.f42954g);
        httpURLConnection.setRequestProperty("x-device-id", g.b(d.b.f0.l.d.e(this.f42948a)));
        httpURLConnection.setRequestProperty("Pragma", "no-cache");
        String str2 = d.b.f0.a.f42809b;
        String h2 = d.b.f0.l.c.h(this.f42948a);
        httpURLConnection.setRequestProperty("User-Agent", "sso/" + str2 + "/" + h2 + "/1.0.5");
        httpURLConnection.setRequestProperty("Accept", "*/*");
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage());
        StringBuilder sb = new StringBuilder();
        sb.append("sso/");
        sb.append("1.0.5");
        httpURLConnection.setRequestProperty("x-sdk-ver", sb.toString());
        httpURLConnection.setRequestProperty("x-plu-ver", "sso/1.0.5");
        httpURLConnection.setRequestProperty("x-app-ver", this.f42948a.getPackageName() + "/" + d.b.f0.l.c.h(this.f42948a));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("android/");
        sb2.append(d.b.f0.l.c.g());
        httpURLConnection.setRequestProperty("x-sys-ver", sb2.toString());
        if (map != null) {
            for (String str3 : map.keySet()) {
                httpURLConnection.setRequestProperty(str3, map.get(str3));
            }
        }
        return httpURLConnection;
    }

    public final void d(String str, String str2) {
        this.f42951d = str;
        this.f42952e = str2;
    }

    public final byte[] e(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(this.f42949b);
            if (read != -1) {
                byteArrayOutputStream.write(this.f42949b, 0, read);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    public final String f(InputStream inputStream) {
        byte[] e2;
        if (inputStream == null || (e2 = e(inputStream)) == null) {
            return null;
        }
        if (this.f42955h) {
            e2 = f.d(e2);
        }
        return e2 == null ? "" : new String(e2);
    }
}
