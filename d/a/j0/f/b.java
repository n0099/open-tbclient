package d.a.j0.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import d.a.j0.l.f;
import d.a.j0.l.g;
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
    public Context f44073a;

    /* renamed from: c  reason: collision with root package name */
    public HttpURLConnection f44075c;

    /* renamed from: d  reason: collision with root package name */
    public String f44076d;

    /* renamed from: e  reason: collision with root package name */
    public String f44077e;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f44074b = new byte[1024];

    /* renamed from: f  reason: collision with root package name */
    public int f44078f = 10000;

    /* renamed from: g  reason: collision with root package name */
    public int f44079g = 10000;

    /* renamed from: h  reason: collision with root package name */
    public boolean f44080h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f44081i = false;

    public b(Context context, Handler handler) {
        this.f44073a = context;
    }

    public final InputStream a(byte[] bArr, Map<String, String> map, String str) {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                if (d.a.j0.l.c.k(this.f44073a) == 0) {
                    return null;
                }
                HttpURLConnection c2 = c(map);
                this.f44075c = c2;
                if (c2 == null) {
                    return null;
                }
                if (bArr == null) {
                    if (AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(c2.getContentEncoding())) {
                        this.f44080h = true;
                    } else {
                        this.f44080h = false;
                    }
                    this.f44075c.getResponseCode();
                    return this.f44075c.getInputStream();
                }
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(this.f44075c.getOutputStream());
                try {
                    bufferedOutputStream2.write(bArr);
                    bufferedOutputStream2.flush();
                    if (AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(this.f44075c.getContentEncoding())) {
                        this.f44080h = true;
                    } else {
                        this.f44080h = false;
                    }
                    this.f44075c.getResponseCode();
                    InputStream inputStream = this.f44075c.getInputStream();
                    try {
                        bufferedOutputStream2.close();
                    } catch (Throwable th) {
                        d.a.j0.l.c.d(th);
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
                            d.a.j0.l.c.d(th3);
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
                HttpURLConnection httpURLConnection = this.f44075c;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                    this.f44075c = null;
                }
                return null;
            }
            try {
                String f2 = f(inputStream);
                if (inputStream != null) {
                    inputStream.close();
                }
                HttpURLConnection httpURLConnection2 = this.f44075c;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                    this.f44075c = null;
                }
                return f2;
            } catch (Throwable th) {
                th = th;
                if (inputStream != null) {
                    inputStream.close();
                }
                HttpURLConnection httpURLConnection3 = this.f44075c;
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                    this.f44075c = null;
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
        if (this.f44081i || TextUtils.isEmpty(this.f44076d) || TextUtils.isEmpty(this.f44077e)) {
            return null;
        }
        if (!this.f44076d.equals("POST") && !this.f44076d.equals("GET")) {
            this.f44076d = "POST";
        }
        URL url = new URL(this.f44077e);
        int i2 = 80;
        if (2 != d.a.j0.l.c.k(this.f44073a)) {
            if (Build.VERSION.SDK_INT >= 13) {
                str = System.getProperties().getProperty("http.proxyHost");
                String property = System.getProperties().getProperty("http.proxyPort");
                if (!TextUtils.isEmpty(property)) {
                    try {
                        i2 = Integer.parseInt(property);
                    } catch (Throwable unused) {
                        i2 = -1;
                    }
                }
                i2 = -1;
            } else {
                str = Proxy.getHost(this.f44073a);
                i2 = Proxy.getPort(this.f44073a);
            }
        }
        if (str != null && i2 > 0) {
            httpURLConnection = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str, i2)));
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        if (this.f44077e.startsWith("https")) {
            c.b((HttpsURLConnection) httpURLConnection);
        }
        httpURLConnection.setRequestMethod(this.f44076d);
        httpURLConnection.setDoInput(true);
        if ("POST".equals(this.f44076d)) {
            httpURLConnection.setDoOutput(true);
        }
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setConnectTimeout(this.f44078f);
        httpURLConnection.setReadTimeout(this.f44079g);
        httpURLConnection.setRequestProperty("x-device-id", g.b(d.a.j0.l.d.f(this.f44073a)));
        httpURLConnection.setRequestProperty("Pragma", "no-cache");
        String str2 = d.a.j0.a.f43930b;
        String h2 = d.a.j0.l.c.h(this.f44073a);
        httpURLConnection.setRequestProperty("User-Agent", "sso/" + str2 + "/" + h2 + "/1.0.7");
        httpURLConnection.setRequestProperty("Accept", "*/*");
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage());
        StringBuilder sb = new StringBuilder();
        sb.append("sso/");
        sb.append("1.0.7");
        httpURLConnection.setRequestProperty("x-sdk-ver", sb.toString());
        httpURLConnection.setRequestProperty("x-plu-ver", "sso/1.0.7");
        httpURLConnection.setRequestProperty("x-app-ver", this.f44073a.getPackageName() + "/" + d.a.j0.l.c.h(this.f44073a));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("android/");
        sb2.append(d.a.j0.l.c.g());
        httpURLConnection.setRequestProperty("x-sys-ver", sb2.toString());
        if (map != null) {
            for (String str3 : map.keySet()) {
                httpURLConnection.setRequestProperty(str3, map.get(str3));
            }
        }
        return httpURLConnection;
    }

    public final void d(String str, String str2) {
        this.f44076d = str;
        this.f44077e = str2;
    }

    public final byte[] e(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(this.f44074b);
            if (read != -1) {
                byteArrayOutputStream.write(this.f44074b, 0, read);
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
        if (this.f44080h) {
            e2 = f.d(e2);
        }
        return e2 == null ? "" : new String(e2);
    }
}
