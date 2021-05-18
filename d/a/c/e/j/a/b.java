package d.a.c.e.j.a;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.network.http.BdHttpCancelException;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import d.a.c.e.p.j;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* loaded from: classes.dex */
public class b {
    public static String p;

    /* renamed from: a  reason: collision with root package name */
    public e f38939a;

    /* renamed from: b  reason: collision with root package name */
    public HttpURLConnection f38940b;

    /* renamed from: c  reason: collision with root package name */
    public long f38941c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f38942d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f38943e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f38944f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f38945g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f38946h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f38947i = true;
    public boolean j = true;
    public boolean k = true;
    public int l = 0;
    public TimerTask m = new a();
    public TimerTask n = new C0501b();
    public Timer o = new Timer();

    /* loaded from: classes.dex */
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.b();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: d.a.c.e.j.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0501b extends TimerTask {
        public C0501b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                d.a.c.e.m.a.e(b.this.f38940b);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements HostnameVerifier {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HttpsURLConnection f38950a;

        public c(b bVar, HttpsURLConnection httpsURLConnection) {
            this.f38950a = httpsURLConnection;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            String requestProperty = this.f38950a.getRequestProperty("Host");
            if (requestProperty == null) {
                requestProperty = this.f38950a.getURL().getHost();
            }
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(requestProperty, sSLSession);
        }
    }

    static {
        Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
        p = "--------7da3d81520810*";
        System.setProperty("http.keepAlive", "false");
    }

    public b(e eVar) {
        if (eVar != null) {
            this.f38939a = eVar;
            return;
        }
        throw new NullPointerException("init HttpImpl's args context is null");
    }

    public void b() {
        this.f38939a.c().f38977a = true;
        d.a.c.e.m.a.e(this.f38940b);
    }

    public final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains(AsyncHttpClient.ENCODING_GZIP)) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            d.a.c.e.p.g.c(byteArrayInputStream, byteArrayOutputStream);
            this.f38945g = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        }
        if (this.f38945g == 0) {
            this.f38945g = System.currentTimeMillis();
        }
        return bArr;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:131:0x02fb */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r15v2, types: [java.io.OutputStream, java.io.FileOutputStream] */
    public boolean d(String str, h hVar, int i2, int i3, boolean z, d dVar, boolean z2) throws Exception {
        ?? r15;
        File i4;
        InputStream inputStream;
        boolean z3;
        URL url;
        String str2;
        String headerField;
        int indexOf;
        int i5;
        d dVar2 = dVar == null ? new d() : dVar;
        InputStream inputStream2 = null;
        try {
            String i6 = this.f38939a.b().i();
            dVar2.s = i6;
            URL n = n(i6, dVar2);
            this.f38940b = g(n, i3, i2);
            if (this.f38939a.c().f38977a) {
                this.f38944f = System.currentTimeMillis();
                d.a.c.e.m.a.c(null);
                d.a.c.e.m.a.e(this.f38940b);
                d.a.c.e.m.a.d(null);
                return false;
            }
            if (z2) {
                try {
                    d.a.c.e.p.f.k(str);
                } catch (Throwable th) {
                    th = th;
                    r15 = inputStream2;
                    this.f38944f = System.currentTimeMillis();
                    d.a.c.e.m.a.c(inputStream2);
                    d.a.c.e.m.a.e(this.f38940b);
                    d.a.c.e.m.a.d(r15);
                    throw th;
                }
            }
            if (z) {
                i4 = new File(str);
            } else {
                i4 = d.a.c.e.p.f.i(str);
            }
            if (i4 != null) {
                long length = i4.length();
                r15 = new FileOutputStream(i4, true);
                try {
                    try {
                        this.f38939a.b().t(this.f38940b);
                        this.f38940b.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                        this.f38940b.connect();
                        if (this.f38941c <= 0) {
                            try {
                                this.f38941c = System.currentTimeMillis();
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream2 = null;
                                this.f38944f = System.currentTimeMillis();
                                d.a.c.e.m.a.c(inputStream2);
                                d.a.c.e.m.a.e(this.f38940b);
                                d.a.c.e.m.a.d(r15);
                                throw th;
                            }
                        }
                        this.f38942d = System.currentTimeMillis();
                        int responseCode = this.f38940b.getResponseCode();
                        this.f38943e = System.currentTimeMillis();
                        if (responseCode == 302) {
                            url = this.f38940b.getURL();
                            if (url != null) {
                                dVar2.r = url.toString();
                            }
                            if (url != null) {
                                i5 = responseCode;
                                if (!TextUtils.equals(url.getProtocol(), n.getProtocol())) {
                                    d.a.c.e.m.a.e(this.f38940b);
                                    this.f38940b = g(new URL(url.toString()), i3, i2);
                                    this.f38939a.b().t(this.f38940b);
                                    this.f38940b.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                                    this.f38940b.connect();
                                    responseCode = this.f38940b.getResponseCode();
                                    z3 = true;
                                }
                            } else {
                                i5 = responseCode;
                            }
                            responseCode = i5;
                            z3 = false;
                        } else {
                            z3 = false;
                            url = null;
                        }
                        this.f38939a.c().f38978b = responseCode;
                        String headerField2 = this.f38940b.getHeaderField("Content-Range");
                        int d2 = (headerField2 == null || (indexOf = headerField2.indexOf("/")) == -1) ? 0 : d.a.c.e.m.b.d(headerField2.substring(indexOf + 1), 0);
                        if (d2 == 0 && this.f38939a.c().f38978b == 200 && (headerField = this.f38940b.getHeaderField("Content-Length")) != null) {
                            d2 = d.a.c.e.m.b.d(headerField, 0);
                        }
                        this.f38939a.c().f38982f = String.valueOf(d2);
                        if (!o()) {
                            str2 = "";
                            if (responseCode == 302) {
                                str2 = (z3 ? "isReConn " : "") + "url=" + n + "-newUrl=" + url;
                            } else if (responseCode == 416) {
                                if (d2 > 0 && d2 == length) {
                                    this.f38944f = System.currentTimeMillis();
                                    d.a.c.e.m.a.c(null);
                                    d.a.c.e.m.a.e(this.f38940b);
                                    d.a.c.e.m.a.d(r15);
                                    return false;
                                }
                                str2 = "fileLen=" + length + "-contentLen=" + d2;
                            }
                            throw new UnsupportedOperationException(str2);
                        } else if (this.f38940b.getContentType() != null && this.f38940b.getContentType().contains("text/vnd.wap.wml")) {
                            this.f38940b.disconnect();
                            this.f38939a.c().f38978b = 0;
                            boolean d3 = d(str, hVar, i2, i3, z, dVar2, z2);
                            this.f38944f = System.currentTimeMillis();
                            d.a.c.e.m.a.c(null);
                            d.a.c.e.m.a.e(this.f38940b);
                            d.a.c.e.m.a.d(r15);
                            return d3;
                        } else {
                            dVar2.f38957a = i6.getBytes().length;
                            long length2 = this.f38940b.getHeaderFields().toString().getBytes().length;
                            dVar2.f38958b = length2;
                            long j = d2;
                            dVar2.f38958b = length2 + j;
                            if (d2 != 0 && length >= j) {
                                this.f38944f = System.currentTimeMillis();
                                this.f38944f = System.currentTimeMillis();
                                d.a.c.e.m.a.c(null);
                                d.a.c.e.m.a.e(this.f38940b);
                                d.a.c.e.m.a.d(r15);
                                return true;
                            }
                            inputStream = null;
                            try {
                                inputStream2 = this.f38940b.getInputStream();
                                try {
                                    byte[] bArr = new byte[1024];
                                    int i7 = d2 > 0 ? d2 / 50 : 0;
                                    if (hVar != null && length > 0) {
                                        hVar.onProgress((int) length, d2);
                                    }
                                    int i8 = 0;
                                    loop0: while (true) {
                                        int i9 = 0;
                                        while (!this.f38939a.c().f38977a) {
                                            int read = inputStream2.read(bArr);
                                            if (read == -1) {
                                                break loop0;
                                            }
                                            try {
                                                r15.write(bArr, 0, read);
                                                i8 += read;
                                                i9 += read;
                                                if (hVar == null || (i9 <= i7 && i8 != d2)) {
                                                    i7 = i7;
                                                } else {
                                                    int i10 = i7;
                                                    hVar.onProgress((int) (i8 + length), d2);
                                                    i7 = i10;
                                                }
                                            } catch (Exception unused) {
                                                throw new FileNotFoundException();
                                            }
                                        }
                                        break loop0;
                                    }
                                    try {
                                        r15.flush();
                                        long j2 = i8;
                                        dVar2.w = j2;
                                        dVar2.x = length;
                                        dVar2.y = j;
                                        boolean z4 = j2 + length >= j;
                                        this.f38944f = System.currentTimeMillis();
                                        d.a.c.e.m.a.c(inputStream2);
                                        d.a.c.e.m.a.e(this.f38940b);
                                        d.a.c.e.m.a.d(r15);
                                        return z4;
                                    } catch (Exception unused2) {
                                        throw new FileNotFoundException();
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    this.f38944f = System.currentTimeMillis();
                                    d.a.c.e.m.a.c(inputStream2);
                                    d.a.c.e.m.a.e(this.f38940b);
                                    d.a.c.e.m.a.d(r15);
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                inputStream2 = inputStream;
                                this.f38944f = System.currentTimeMillis();
                                d.a.c.e.m.a.c(inputStream2);
                                d.a.c.e.m.a.e(this.f38940b);
                                d.a.c.e.m.a.d(r15);
                                throw th;
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream = null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } else {
                try {
                    throw new FileNotFoundException();
                } catch (Throwable th7) {
                    th = th7;
                    inputStream2 = null;
                    r15 = inputStream2;
                    this.f38944f = System.currentTimeMillis();
                    d.a.c.e.m.a.c(inputStream2);
                    d.a.c.e.m.a.e(this.f38940b);
                    d.a.c.e.m.a.d(r15);
                    throw th;
                }
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }

    public long e() {
        return this.f38945g;
    }

    public final HttpURLConnection f(URL url) {
        String c2;
        HttpURLConnection httpURLConnection;
        HttpsURLConnection httpsURLConnection = null;
        try {
            if (j.z()) {
                if (j.x() && (c2 = j.c()) != null && c2.length() > 0) {
                    if (j.F(c2) && j.D()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(c2);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.f38939a.b().a("X-Online-Host", url.getHost());
                        } catch (Exception e2) {
                            e = e2;
                            httpsURLConnection = httpURLConnection;
                            e.printStackTrace();
                            return httpsURLConnection;
                        }
                    } else {
                        httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(c2, j.d())));
                    }
                    httpsURLConnection = httpURLConnection;
                }
                if (httpsURLConnection == null) {
                    httpsURLConnection = (HttpURLConnection) url.openConnection();
                }
                if (this.f38946h && url.getProtocol().equals("https")) {
                    HttpsURLConnection httpsURLConnection2 = httpsURLConnection;
                    httpsURLConnection2.setSSLSocketFactory(new i(httpsURLConnection2));
                    httpsURLConnection2.setHostnameVerifier(new c(this, httpsURLConnection2));
                    return httpsURLConnection2;
                }
                return httpsURLConnection;
            }
            return null;
        } catch (Exception e3) {
            e = e3;
        }
    }

    public final HttpURLConnection g(URL url, int i2, int i3) throws SocketException {
        HttpURLConnection f2 = f(url);
        if (f2 != null) {
            f2.setConnectTimeout(i2);
            f2.setReadTimeout(i3);
            return f2;
        }
        throw new SocketException();
    }

    public long h() {
        return this.f38943e;
    }

    public long i() {
        return this.f38941c;
    }

    public long j() {
        return this.f38942d;
    }

    public void k(int i2, int i3, d dVar) throws Exception {
        HttpURLConnection httpURLConnection;
        URL url;
        Map<String, List<String>> map;
        List<String> list;
        dVar.j = -1;
        if (!this.f38939a.c().f38977a) {
            String f2 = this.f38939a.b().f(dVar);
            dVar.s = f2;
            URL n = n(f2, dVar);
            if (!this.f38939a.c().f38977a) {
                dVar.j = -2;
                this.f38940b = f(n);
                dVar.j = -3;
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    if (this.f38940b != null) {
                        this.f38940b.setRequestMethod("GET");
                        this.f38940b.setConnectTimeout(i3);
                        this.f38940b.setReadTimeout(i2);
                        this.f38939a.b().t(this.f38940b);
                        if (!this.f38939a.c().f38977a) {
                            dVar.f38963g = new Date().getTime() - currentTimeMillis;
                            dVar.j = -4;
                            this.f38940b.connect();
                            if (this.f38941c <= 0) {
                                this.f38941c = System.currentTimeMillis();
                            }
                            this.f38942d = System.currentTimeMillis();
                            dVar.j = -5;
                            dVar.f38959c = (new Date().getTime() - currentTimeMillis) - dVar.f38963g;
                            if (!this.f38939a.c().f38977a) {
                                if (this.f38939a.b().k() && this.o != null && this.l >= 0 && this.l < 3) {
                                    this.o.schedule(this.n, (this.l + 1) * 3000);
                                }
                                String contentType = this.f38940b.getContentType();
                                this.f38943e = System.currentTimeMillis();
                                if (d.a.c.e.j.b.b.c(contentType)) {
                                    this.f38940b.disconnect();
                                    this.f38940b.connect();
                                    if (this.f38939a.c().f38977a) {
                                        throw new BdHttpCancelException();
                                    }
                                }
                                dVar.j = -8;
                                this.f38939a.c().a(this.f38940b);
                                if (f2.contains("c.tieba.baidu.com") && (map = this.f38939a.c().f38983g) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                                    dVar.t = list.get(0);
                                    dVar.u = list.get(1);
                                }
                                if (this.f38939a.c().f38978b == 302 && (url = this.f38940b.getURL()) != null) {
                                    dVar.r = url.toString();
                                }
                                dVar.f38965i = this.f38939a.c().f38978b;
                                dVar.f38958b = this.f38940b.getHeaderFields().toString().getBytes().length;
                                if (this.o != null) {
                                    this.o.cancel();
                                }
                                byte[] m = m(this.f38940b);
                                if (m != null) {
                                    dVar.f38958b += m.length;
                                    this.f38939a.c().f38984h = c(this.f38939a.c().f38980d, m);
                                }
                                dVar.j = -9;
                                dVar.f38960d = new Date().getTime() - currentTimeMillis;
                                if (httpURLConnection != null) {
                                    return;
                                }
                                return;
                            }
                            throw new BdHttpCancelException();
                        }
                        throw new BdHttpCancelException();
                    }
                    throw new SocketException("network not available.");
                } finally {
                    Timer timer = this.o;
                    if (timer != null) {
                        timer.cancel();
                    }
                    httpURLConnection = this.f38940b;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            }
            throw new BdHttpCancelException();
        }
        throw new BdHttpCancelException();
    }

    public long l() {
        return this.f38944f;
    }

    public final byte[] m(HttpURLConnection httpURLConnection) throws Exception {
        InputStream inputStream;
        int read;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        byte[] bArr = null;
        if (httpURLConnection != null) {
            try {
                byte[] bArr2 = new byte[1024];
                InputStream inputStream2 = httpURLConnection.getInputStream();
                while (!this.f38939a.c().f38977a && (read = inputStream2.read(bArr2)) != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                if (!this.f38939a.c().f38977a) {
                    bArr = byteArrayOutputStream.toByteArray();
                    inputStream = inputStream2;
                } else {
                    throw new BdHttpCancelException();
                }
            } catch (Throwable th) {
                this.f38944f = System.currentTimeMillis();
                d.a.c.e.m.a.d(byteArrayOutputStream);
                d.a.c.e.m.a.c(null);
                throw th;
            }
        } else {
            inputStream = null;
        }
        this.f38944f = System.currentTimeMillis();
        d.a.c.e.m.a.d(byteArrayOutputStream);
        d.a.c.e.m.a.c(inputStream);
        return bArr;
    }

    public final URL n(String str, d dVar) throws Exception {
        d.a.c.e.j.a.a b2;
        String str2 = "hiphotos.baidu.com";
        URL url = new URL(str);
        if (!TextUtils.isEmpty(str) && this.j && this.k) {
            try {
                String host = url.getHost();
                if (!TextUtils.isEmpty(host)) {
                    if (!host.contains("hiphotos.baidu.com")) {
                        str2 = host;
                    }
                    BDHttpDnsResult r = BDHttpDns.j(BdBaseApplication.getInst().getApplicationContext()).r(str2, true);
                    if (r != null) {
                        dVar.m = r.d();
                        dVar.o = r.c();
                        ArrayList<String> a2 = r.a();
                        if (a2 != null && a2.size() > 0) {
                            dVar.p = a2.toString();
                            int size = this.l % a2.size();
                            String str3 = a2.get(size);
                            if (!TextUtils.isEmpty(str3) && (!str3.startsWith("10.") || !url.getProtocol().equals("https"))) {
                                this.f38939a.b().a("Host", str2);
                                URL url2 = new URL(str.replaceFirst("://(.*)" + str2, "://" + str3));
                                try {
                                    this.f38946h = true;
                                    dVar.q = size;
                                    dVar.l = str3;
                                    dVar.n = true;
                                    return url2;
                                } catch (Exception e2) {
                                    e = e2;
                                    url = url2;
                                    BdLog.e(e);
                                    return this.f38947i ? url : url;
                                }
                            }
                        }
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
        if (this.f38947i || !this.k || (b2 = d.a.c.e.j.a.a.b()) == null) {
            return url;
        }
        String a3 = b2.a(str);
        if (TextUtils.isEmpty(a3)) {
            return url;
        }
        this.f38939a.b().a("Host", url.getHost());
        URL url3 = new URL(str.replace("://" + url.getHost(), "://" + a3));
        this.f38946h = true;
        dVar.l = a3;
        return url3;
    }

    public final boolean o() {
        return this.f38939a.c().f38978b == 200 || this.f38939a.c().f38978b == 206;
    }

    public boolean p() {
        return this.f38946h;
    }

    public void q(int i2, int i3, d dVar) throws Exception {
        dVar.j = -1;
        try {
            String i4 = this.f38939a.b().i();
            dVar.s = i4;
            URL n = n(i4, dVar);
            if (!this.f38939a.c().f38977a) {
                dVar.j = -2;
                this.f38940b = f(n);
                dVar.j = -3;
                System.currentTimeMillis();
                if (this.f38940b != null) {
                    this.f38940b.setRequestMethod("POST");
                    this.f38940b.setDoOutput(true);
                    this.f38940b.setDoInput(true);
                    this.f38940b.setConnectTimeout(i3);
                    this.f38940b.setReadTimeout(i2);
                    this.f38940b.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + p);
                    if (!this.f38939a.c().f38977a) {
                        this.f38939a.b().t(this.f38940b);
                        if (!this.f38939a.c().f38977a) {
                            long time = new Date().getTime();
                            dVar.f38963g = new Date().getTime() - time;
                            dVar.j = -4;
                            this.f38940b.connect();
                            if (this.f38941c <= 0) {
                                this.f38941c = System.currentTimeMillis();
                            }
                            this.f38942d = System.currentTimeMillis();
                            dVar.j = -5;
                            dVar.f38959c = (new Date().getTime() - time) - dVar.f38963g;
                            if (!this.f38939a.c().f38977a) {
                                if (this.o != null) {
                                    this.o.schedule(this.m, 45000L);
                                }
                                dVar.j = -6;
                                this.f38939a.b().v(this.f38940b, p, dVar);
                                dVar.j = -7;
                                String contentType = this.f38940b.getContentType();
                                this.f38943e = System.currentTimeMillis();
                                if (d.a.c.e.j.b.b.c(contentType)) {
                                    this.f38940b.disconnect();
                                    this.f38940b.connect();
                                    if (this.f38939a.c().f38977a) {
                                        throw new BdHttpCancelException();
                                    }
                                }
                                if (!this.f38939a.c().f38977a) {
                                    dVar.j = -8;
                                    this.f38939a.c().a(this.f38940b);
                                    dVar.f38965i = this.f38939a.c().f38978b;
                                    dVar.f38958b = this.f38940b.getHeaderFields().toString().getBytes().length;
                                    byte[] m = m(this.f38940b);
                                    if (m != null) {
                                        dVar.f38958b += m.length;
                                        this.f38939a.c().f38985i = m.length;
                                        this.f38939a.c().f38984h = c(this.f38939a.c().f38980d, m);
                                    }
                                    dVar.f38960d = new Date().getTime() - time;
                                    dVar.j = -9;
                                    return;
                                }
                                throw new BdHttpCancelException();
                            }
                            throw new BdHttpCancelException();
                        }
                        throw new BdHttpCancelException();
                    }
                    throw new BdHttpCancelException();
                }
                throw new SocketException("network not available.");
            }
            throw new BdHttpCancelException();
        } finally {
            Timer timer = this.o;
            if (timer != null) {
                timer.cancel();
            }
            d.a.c.e.m.a.e(this.f38940b);
        }
    }

    public void r(int i2, int i3, d dVar) throws Exception {
        dVar.j = -1;
        try {
            String i4 = this.f38939a.b().i();
            dVar.s = i4;
            URL n = n(i4, dVar);
            if (!this.f38939a.c().f38977a) {
                dVar.j = -2;
                this.f38940b = f(n);
                dVar.j = -3;
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f38940b != null) {
                    this.f38940b.setRequestMethod("POST");
                    this.f38940b.setDoOutput(true);
                    this.f38940b.setDoInput(true);
                    this.f38940b.setConnectTimeout(i3);
                    this.f38940b.setReadTimeout(i2);
                    this.f38940b.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    if (!this.f38939a.c().f38977a) {
                        this.f38939a.b().t(this.f38940b);
                        if (!this.f38939a.c().f38977a) {
                            dVar.f38963g = System.currentTimeMillis() - currentTimeMillis;
                            dVar.j = -4;
                            this.f38940b.connect();
                            if (this.f38941c <= 0) {
                                this.f38941c = System.currentTimeMillis();
                            }
                            this.f38942d = System.currentTimeMillis();
                            dVar.j = -5;
                            dVar.f38959c = (System.currentTimeMillis() - currentTimeMillis) - dVar.f38963g;
                            if (!this.f38939a.c().f38977a) {
                                dVar.j = -6;
                                this.f38939a.b().u(this.f38940b, dVar);
                                dVar.j = -7;
                                if (!this.f38939a.c().f38977a) {
                                    String contentType = this.f38940b.getContentType();
                                    this.f38943e = System.currentTimeMillis();
                                    if (d.a.c.e.j.b.b.c(contentType)) {
                                        this.f38940b.disconnect();
                                        this.f38940b.connect();
                                        if (this.f38939a.c().f38977a) {
                                            throw new BdHttpCancelException();
                                        }
                                    }
                                    dVar.j = -8;
                                    this.f38939a.c().a(this.f38940b);
                                    dVar.f38965i = this.f38939a.c().f38978b;
                                    dVar.f38958b = this.f38940b.getHeaderFields().toString().getBytes().length;
                                    byte[] m = m(this.f38940b);
                                    if (m != null) {
                                        dVar.f38958b += m.length;
                                        this.f38939a.c().f38985i = m.length;
                                        this.f38939a.c().f38984h = c(this.f38939a.c().f38980d, m);
                                    }
                                    dVar.f38960d = new Date().getTime() - currentTimeMillis;
                                    dVar.j = -9;
                                    return;
                                }
                                throw new BdHttpCancelException();
                            }
                            throw new BdHttpCancelException();
                        }
                        throw new BdHttpCancelException();
                    }
                    throw new BdHttpCancelException();
                }
                throw new SocketException("network not available.");
            }
            throw new BdHttpCancelException();
        } finally {
            d.a.c.e.m.a.e(this.f38940b);
        }
    }

    public void s(int i2) {
        this.l = i2;
    }

    public void t(boolean z) {
        this.k = z;
    }

    public void u(boolean z) {
        this.j = z;
    }
}
