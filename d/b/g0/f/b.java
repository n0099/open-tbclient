package d.b.g0.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import d.b.g0.l.f;
import d.b.g0.l.g;
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
    public Context f43637a;

    /* renamed from: c  reason: collision with root package name */
    public HttpURLConnection f43639c;

    /* renamed from: d  reason: collision with root package name */
    public String f43640d;

    /* renamed from: e  reason: collision with root package name */
    public String f43641e;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f43638b = new byte[1024];

    /* renamed from: f  reason: collision with root package name */
    public int f43642f = 10000;

    /* renamed from: g  reason: collision with root package name */
    public int f43643g = 10000;

    /* renamed from: h  reason: collision with root package name */
    public boolean f43644h = false;
    public boolean i = false;

    public b(Context context, Handler handler) {
        this.f43637a = context;
    }

    public final InputStream a(byte[] bArr, Map<String, String> map, String str) {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                if (d.b.g0.l.c.k(this.f43637a) == 0) {
                    return null;
                }
                HttpURLConnection c2 = c(map);
                this.f43639c = c2;
                if (c2 == null) {
                    return null;
                }
                if (bArr == null) {
                    if (AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(c2.getContentEncoding())) {
                        this.f43644h = true;
                    } else {
                        this.f43644h = false;
                    }
                    this.f43639c.getResponseCode();
                    return this.f43639c.getInputStream();
                }
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(this.f43639c.getOutputStream());
                try {
                    bufferedOutputStream2.write(bArr);
                    bufferedOutputStream2.flush();
                    if (AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(this.f43639c.getContentEncoding())) {
                        this.f43644h = true;
                    } else {
                        this.f43644h = false;
                    }
                    this.f43639c.getResponseCode();
                    InputStream inputStream = this.f43639c.getInputStream();
                    try {
                        bufferedOutputStream2.close();
                    } catch (Throwable th) {
                        d.b.g0.l.c.d(th);
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
                            d.b.g0.l.c.d(th3);
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
                HttpURLConnection httpURLConnection = this.f43639c;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                    this.f43639c = null;
                }
                return null;
            }
            try {
                String f2 = f(inputStream);
                if (inputStream != null) {
                    inputStream.close();
                }
                HttpURLConnection httpURLConnection2 = this.f43639c;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                    this.f43639c = null;
                }
                return f2;
            } catch (Throwable th) {
                th = th;
                if (inputStream != null) {
                    inputStream.close();
                }
                HttpURLConnection httpURLConnection3 = this.f43639c;
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                    this.f43639c = null;
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
        if (this.i || TextUtils.isEmpty(this.f43640d) || TextUtils.isEmpty(this.f43641e)) {
            return null;
        }
        if (!this.f43640d.equals("POST") && !this.f43640d.equals("GET")) {
            this.f43640d = "POST";
        }
        URL url = new URL(this.f43641e);
        int i = 80;
        if (2 != d.b.g0.l.c.k(this.f43637a)) {
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
                str = Proxy.getHost(this.f43637a);
                i = Proxy.getPort(this.f43637a);
            }
        }
        if (str != null && i > 0) {
            httpURLConnection = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str, i)));
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        if (this.f43641e.startsWith("https")) {
            c.b((HttpsURLConnection) httpURLConnection);
        }
        httpURLConnection.setRequestMethod(this.f43640d);
        httpURLConnection.setDoInput(true);
        if ("POST".equals(this.f43640d)) {
            httpURLConnection.setDoOutput(true);
        }
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setConnectTimeout(this.f43642f);
        httpURLConnection.setReadTimeout(this.f43643g);
        httpURLConnection.setRequestProperty("x-device-id", g.b(d.b.g0.l.d.e(this.f43637a)));
        httpURLConnection.setRequestProperty("Pragma", "no-cache");
        String str2 = d.b.g0.a.f43498b;
        String h2 = d.b.g0.l.c.h(this.f43637a);
        httpURLConnection.setRequestProperty("User-Agent", "sso/" + str2 + "/" + h2 + "/1.0.5");
        httpURLConnection.setRequestProperty("Accept", "*/*");
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage());
        StringBuilder sb = new StringBuilder();
        sb.append("sso/");
        sb.append("1.0.5");
        httpURLConnection.setRequestProperty("x-sdk-ver", sb.toString());
        httpURLConnection.setRequestProperty("x-plu-ver", "sso/1.0.5");
        httpURLConnection.setRequestProperty("x-app-ver", this.f43637a.getPackageName() + "/" + d.b.g0.l.c.h(this.f43637a));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("android/");
        sb2.append(d.b.g0.l.c.g());
        httpURLConnection.setRequestProperty("x-sys-ver", sb2.toString());
        if (map != null) {
            for (String str3 : map.keySet()) {
                httpURLConnection.setRequestProperty(str3, map.get(str3));
            }
        }
        return httpURLConnection;
    }

    public final void d(String str, String str2) {
        this.f43640d = str;
        this.f43641e = str2;
    }

    public final byte[] e(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(this.f43638b);
            if (read != -1) {
                byteArrayOutputStream.write(this.f43638b, 0, read);
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
        if (this.f43644h) {
            e2 = f.d(e2);
        }
        return e2 == null ? "" : new String(e2);
    }
}
