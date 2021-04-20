package d.b.c.e.j.a;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.network.http.BdHttpCancelException;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import d.b.c.e.p.j;
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
    public e f42258a;

    /* renamed from: b  reason: collision with root package name */
    public HttpURLConnection f42259b;

    /* renamed from: c  reason: collision with root package name */
    public long f42260c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f42261d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f42262e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f42263f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f42264g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f42265h = false;
    public boolean i = true;
    public boolean j = true;
    public boolean k = true;
    public int l = 0;
    public TimerTask m = new a();
    public TimerTask n = new C0556b();
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

    /* renamed from: d.b.c.e.j.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0556b extends TimerTask {
        public C0556b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                d.b.c.e.m.a.e(b.this.f42259b);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements HostnameVerifier {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HttpsURLConnection f42268a;

        public c(b bVar, HttpsURLConnection httpsURLConnection) {
            this.f42268a = httpsURLConnection;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            String requestProperty = this.f42268a.getRequestProperty("Host");
            if (requestProperty == null) {
                requestProperty = this.f42268a.getURL().getHost();
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
            this.f42258a = eVar;
            return;
        }
        throw new NullPointerException("init HttpImpl's args context is null");
    }

    public void b() {
        this.f42258a.c().f42294a = true;
        d.b.c.e.m.a.e(this.f42259b);
    }

    public final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains(AsyncHttpClient.ENCODING_GZIP)) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            d.b.c.e.p.g.c(byteArrayInputStream, byteArrayOutputStream);
            this.f42264g = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        }
        if (this.f42264g == 0) {
            this.f42264g = System.currentTimeMillis();
        }
        return bArr;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:131:0x02fb */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r15v2, types: [java.io.OutputStream, java.io.FileOutputStream] */
    public boolean d(String str, h hVar, int i, int i2, boolean z, d dVar, boolean z2) throws Exception {
        ?? r15;
        File i3;
        InputStream inputStream;
        boolean z3;
        URL url;
        String str2;
        String headerField;
        int indexOf;
        int i4;
        d dVar2 = dVar == null ? new d() : dVar;
        InputStream inputStream2 = null;
        try {
            String i5 = this.f42258a.b().i();
            dVar2.s = i5;
            URL n = n(i5, dVar2);
            this.f42259b = g(n, i2, i);
            if (this.f42258a.c().f42294a) {
                this.f42263f = System.currentTimeMillis();
                d.b.c.e.m.a.c(null);
                d.b.c.e.m.a.e(this.f42259b);
                d.b.c.e.m.a.d(null);
                return false;
            }
            if (z2) {
                try {
                    d.b.c.e.p.f.k(str);
                } catch (Throwable th) {
                    th = th;
                    r15 = inputStream2;
                    this.f42263f = System.currentTimeMillis();
                    d.b.c.e.m.a.c(inputStream2);
                    d.b.c.e.m.a.e(this.f42259b);
                    d.b.c.e.m.a.d(r15);
                    throw th;
                }
            }
            if (z) {
                i3 = new File(str);
            } else {
                i3 = d.b.c.e.p.f.i(str);
            }
            if (i3 != null) {
                long length = i3.length();
                r15 = new FileOutputStream(i3, true);
                try {
                    try {
                        this.f42258a.b().t(this.f42259b);
                        this.f42259b.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                        this.f42259b.connect();
                        if (this.f42260c <= 0) {
                            try {
                                this.f42260c = System.currentTimeMillis();
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream2 = null;
                                this.f42263f = System.currentTimeMillis();
                                d.b.c.e.m.a.c(inputStream2);
                                d.b.c.e.m.a.e(this.f42259b);
                                d.b.c.e.m.a.d(r15);
                                throw th;
                            }
                        }
                        this.f42261d = System.currentTimeMillis();
                        int responseCode = this.f42259b.getResponseCode();
                        this.f42262e = System.currentTimeMillis();
                        if (responseCode == 302) {
                            url = this.f42259b.getURL();
                            if (url != null) {
                                dVar2.r = url.toString();
                            }
                            if (url != null) {
                                i4 = responseCode;
                                if (!TextUtils.equals(url.getProtocol(), n.getProtocol())) {
                                    d.b.c.e.m.a.e(this.f42259b);
                                    this.f42259b = g(new URL(url.toString()), i2, i);
                                    this.f42258a.b().t(this.f42259b);
                                    this.f42259b.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                                    this.f42259b.connect();
                                    responseCode = this.f42259b.getResponseCode();
                                    z3 = true;
                                }
                            } else {
                                i4 = responseCode;
                            }
                            responseCode = i4;
                            z3 = false;
                        } else {
                            z3 = false;
                            url = null;
                        }
                        this.f42258a.c().f42295b = responseCode;
                        String headerField2 = this.f42259b.getHeaderField("Content-Range");
                        int d2 = (headerField2 == null || (indexOf = headerField2.indexOf("/")) == -1) ? 0 : d.b.c.e.m.b.d(headerField2.substring(indexOf + 1), 0);
                        if (d2 == 0 && this.f42258a.c().f42295b == 200 && (headerField = this.f42259b.getHeaderField("Content-Length")) != null) {
                            d2 = d.b.c.e.m.b.d(headerField, 0);
                        }
                        this.f42258a.c().f42299f = String.valueOf(d2);
                        if (!o()) {
                            str2 = "";
                            if (responseCode == 302) {
                                str2 = (z3 ? "isReConn " : "") + "url=" + n + "-newUrl=" + url;
                            } else if (responseCode == 416) {
                                if (d2 > 0 && d2 == length) {
                                    this.f42263f = System.currentTimeMillis();
                                    d.b.c.e.m.a.c(null);
                                    d.b.c.e.m.a.e(this.f42259b);
                                    d.b.c.e.m.a.d(r15);
                                    return false;
                                }
                                str2 = "fileLen=" + length + "-contentLen=" + d2;
                            }
                            throw new UnsupportedOperationException(str2);
                        } else if (this.f42259b.getContentType() != null && this.f42259b.getContentType().contains("text/vnd.wap.wml")) {
                            this.f42259b.disconnect();
                            this.f42258a.c().f42295b = 0;
                            boolean d3 = d(str, hVar, i, i2, z, dVar2, z2);
                            this.f42263f = System.currentTimeMillis();
                            d.b.c.e.m.a.c(null);
                            d.b.c.e.m.a.e(this.f42259b);
                            d.b.c.e.m.a.d(r15);
                            return d3;
                        } else {
                            dVar2.f42275a = i5.getBytes().length;
                            long length2 = this.f42259b.getHeaderFields().toString().getBytes().length;
                            dVar2.f42276b = length2;
                            long j = d2;
                            dVar2.f42276b = length2 + j;
                            if (d2 != 0 && length >= j) {
                                this.f42263f = System.currentTimeMillis();
                                this.f42263f = System.currentTimeMillis();
                                d.b.c.e.m.a.c(null);
                                d.b.c.e.m.a.e(this.f42259b);
                                d.b.c.e.m.a.d(r15);
                                return true;
                            }
                            inputStream = null;
                            try {
                                inputStream2 = this.f42259b.getInputStream();
                                try {
                                    byte[] bArr = new byte[1024];
                                    int i6 = d2 > 0 ? d2 / 50 : 0;
                                    if (hVar != null && length > 0) {
                                        hVar.onProgress((int) length, d2);
                                    }
                                    int i7 = 0;
                                    loop0: while (true) {
                                        int i8 = 0;
                                        while (!this.f42258a.c().f42294a) {
                                            int read = inputStream2.read(bArr);
                                            if (read == -1) {
                                                break loop0;
                                            }
                                            try {
                                                r15.write(bArr, 0, read);
                                                i7 += read;
                                                i8 += read;
                                                if (hVar == null || (i8 <= i6 && i7 != d2)) {
                                                    i6 = i6;
                                                } else {
                                                    int i9 = i6;
                                                    hVar.onProgress((int) (i7 + length), d2);
                                                    i6 = i9;
                                                }
                                            } catch (Exception unused) {
                                                throw new FileNotFoundException();
                                            }
                                        }
                                        break loop0;
                                    }
                                    try {
                                        r15.flush();
                                        long j2 = i7;
                                        dVar2.w = j2;
                                        dVar2.x = length;
                                        dVar2.y = j;
                                        boolean z4 = j2 + length >= j;
                                        this.f42263f = System.currentTimeMillis();
                                        d.b.c.e.m.a.c(inputStream2);
                                        d.b.c.e.m.a.e(this.f42259b);
                                        d.b.c.e.m.a.d(r15);
                                        return z4;
                                    } catch (Exception unused2) {
                                        throw new FileNotFoundException();
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    this.f42263f = System.currentTimeMillis();
                                    d.b.c.e.m.a.c(inputStream2);
                                    d.b.c.e.m.a.e(this.f42259b);
                                    d.b.c.e.m.a.d(r15);
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                inputStream2 = inputStream;
                                this.f42263f = System.currentTimeMillis();
                                d.b.c.e.m.a.c(inputStream2);
                                d.b.c.e.m.a.e(this.f42259b);
                                d.b.c.e.m.a.d(r15);
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
                    this.f42263f = System.currentTimeMillis();
                    d.b.c.e.m.a.c(inputStream2);
                    d.b.c.e.m.a.e(this.f42259b);
                    d.b.c.e.m.a.d(r15);
                    throw th;
                }
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }

    public long e() {
        return this.f42264g;
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
                            this.f42258a.b().a("X-Online-Host", url.getHost());
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
                if (this.f42265h && url.getProtocol().equals("https")) {
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

    public final HttpURLConnection g(URL url, int i, int i2) throws SocketException {
        HttpURLConnection f2 = f(url);
        if (f2 != null) {
            f2.setConnectTimeout(i);
            f2.setReadTimeout(i2);
            return f2;
        }
        throw new SocketException();
    }

    public long h() {
        return this.f42262e;
    }

    public long i() {
        return this.f42260c;
    }

    public long j() {
        return this.f42261d;
    }

    public void k(int i, int i2, d dVar) throws Exception {
        HttpURLConnection httpURLConnection;
        URL url;
        Map<String, List<String>> map;
        List<String> list;
        dVar.j = -1;
        if (!this.f42258a.c().f42294a) {
            String f2 = this.f42258a.b().f(dVar);
            dVar.s = f2;
            URL n = n(f2, dVar);
            if (!this.f42258a.c().f42294a) {
                dVar.j = -2;
                this.f42259b = f(n);
                dVar.j = -3;
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    if (this.f42259b != null) {
                        this.f42259b.setRequestMethod("GET");
                        this.f42259b.setConnectTimeout(i2);
                        this.f42259b.setReadTimeout(i);
                        this.f42258a.b().t(this.f42259b);
                        if (!this.f42258a.c().f42294a) {
                            dVar.f42281g = new Date().getTime() - currentTimeMillis;
                            dVar.j = -4;
                            this.f42259b.connect();
                            if (this.f42260c <= 0) {
                                this.f42260c = System.currentTimeMillis();
                            }
                            this.f42261d = System.currentTimeMillis();
                            dVar.j = -5;
                            dVar.f42277c = (new Date().getTime() - currentTimeMillis) - dVar.f42281g;
                            if (!this.f42258a.c().f42294a) {
                                if (this.f42258a.b().k() && this.o != null && this.l >= 0 && this.l < 3) {
                                    this.o.schedule(this.n, (this.l + 1) * 3000);
                                }
                                String contentType = this.f42259b.getContentType();
                                this.f42262e = System.currentTimeMillis();
                                if (d.b.c.e.j.b.b.c(contentType)) {
                                    this.f42259b.disconnect();
                                    this.f42259b.connect();
                                    if (this.f42258a.c().f42294a) {
                                        throw new BdHttpCancelException();
                                    }
                                }
                                dVar.j = -8;
                                this.f42258a.c().a(this.f42259b);
                                if (f2.contains("c.tieba.baidu.com") && (map = this.f42258a.c().f42300g) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                                    dVar.t = list.get(0);
                                    dVar.u = list.get(1);
                                }
                                if (this.f42258a.c().f42295b == 302 && (url = this.f42259b.getURL()) != null) {
                                    dVar.r = url.toString();
                                }
                                dVar.i = this.f42258a.c().f42295b;
                                dVar.f42276b = this.f42259b.getHeaderFields().toString().getBytes().length;
                                if (this.o != null) {
                                    this.o.cancel();
                                }
                                byte[] m = m(this.f42259b);
                                if (m != null) {
                                    dVar.f42276b += m.length;
                                    this.f42258a.c().f42301h = c(this.f42258a.c().f42297d, m);
                                }
                                dVar.j = -9;
                                dVar.f42278d = new Date().getTime() - currentTimeMillis;
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
                    httpURLConnection = this.f42259b;
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
        return this.f42263f;
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
                while (!this.f42258a.c().f42294a && (read = inputStream2.read(bArr2)) != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                if (!this.f42258a.c().f42294a) {
                    bArr = byteArrayOutputStream.toByteArray();
                    inputStream = inputStream2;
                } else {
                    throw new BdHttpCancelException();
                }
            } catch (Throwable th) {
                this.f42263f = System.currentTimeMillis();
                d.b.c.e.m.a.d(byteArrayOutputStream);
                d.b.c.e.m.a.c(null);
                throw th;
            }
        } else {
            inputStream = null;
        }
        this.f42263f = System.currentTimeMillis();
        d.b.c.e.m.a.d(byteArrayOutputStream);
        d.b.c.e.m.a.c(inputStream);
        return bArr;
    }

    public final URL n(String str, d dVar) throws Exception {
        d.b.c.e.j.a.a b2;
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
                                this.f42258a.b().a("Host", str2);
                                URL url2 = new URL(str.replaceFirst("://(.*)" + str2, "://" + str3));
                                try {
                                    this.f42265h = true;
                                    dVar.q = size;
                                    dVar.l = str3;
                                    dVar.n = true;
                                    return url2;
                                } catch (Exception e2) {
                                    e = e2;
                                    url = url2;
                                    BdLog.e(e);
                                    return this.i ? url : url;
                                }
                            }
                        }
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
        if (this.i || !this.k || (b2 = d.b.c.e.j.a.a.b()) == null) {
            return url;
        }
        String a3 = b2.a(str);
        if (TextUtils.isEmpty(a3)) {
            return url;
        }
        this.f42258a.b().a("Host", url.getHost());
        URL url3 = new URL(str.replace("://" + url.getHost(), "://" + a3));
        this.f42265h = true;
        dVar.l = a3;
        return url3;
    }

    public final boolean o() {
        return this.f42258a.c().f42295b == 200 || this.f42258a.c().f42295b == 206;
    }

    public boolean p() {
        return this.f42265h;
    }

    public void q(int i, int i2, d dVar) throws Exception {
        dVar.j = -1;
        try {
            String i3 = this.f42258a.b().i();
            dVar.s = i3;
            URL n = n(i3, dVar);
            if (!this.f42258a.c().f42294a) {
                dVar.j = -2;
                this.f42259b = f(n);
                dVar.j = -3;
                System.currentTimeMillis();
                if (this.f42259b != null) {
                    this.f42259b.setRequestMethod("POST");
                    this.f42259b.setDoOutput(true);
                    this.f42259b.setDoInput(true);
                    this.f42259b.setConnectTimeout(i2);
                    this.f42259b.setReadTimeout(i);
                    this.f42259b.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + p);
                    if (!this.f42258a.c().f42294a) {
                        this.f42258a.b().t(this.f42259b);
                        if (!this.f42258a.c().f42294a) {
                            long time = new Date().getTime();
                            dVar.f42281g = new Date().getTime() - time;
                            dVar.j = -4;
                            this.f42259b.connect();
                            if (this.f42260c <= 0) {
                                this.f42260c = System.currentTimeMillis();
                            }
                            this.f42261d = System.currentTimeMillis();
                            dVar.j = -5;
                            dVar.f42277c = (new Date().getTime() - time) - dVar.f42281g;
                            if (!this.f42258a.c().f42294a) {
                                if (this.o != null) {
                                    this.o.schedule(this.m, 45000L);
                                }
                                dVar.j = -6;
                                this.f42258a.b().v(this.f42259b, p, dVar);
                                dVar.j = -7;
                                String contentType = this.f42259b.getContentType();
                                this.f42262e = System.currentTimeMillis();
                                if (d.b.c.e.j.b.b.c(contentType)) {
                                    this.f42259b.disconnect();
                                    this.f42259b.connect();
                                    if (this.f42258a.c().f42294a) {
                                        throw new BdHttpCancelException();
                                    }
                                }
                                if (!this.f42258a.c().f42294a) {
                                    dVar.j = -8;
                                    this.f42258a.c().a(this.f42259b);
                                    dVar.i = this.f42258a.c().f42295b;
                                    dVar.f42276b = this.f42259b.getHeaderFields().toString().getBytes().length;
                                    byte[] m = m(this.f42259b);
                                    if (m != null) {
                                        dVar.f42276b += m.length;
                                        this.f42258a.c().i = m.length;
                                        this.f42258a.c().f42301h = c(this.f42258a.c().f42297d, m);
                                    }
                                    dVar.f42278d = new Date().getTime() - time;
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
            d.b.c.e.m.a.e(this.f42259b);
        }
    }

    public void r(int i, int i2, d dVar) throws Exception {
        dVar.j = -1;
        try {
            String i3 = this.f42258a.b().i();
            dVar.s = i3;
            URL n = n(i3, dVar);
            if (!this.f42258a.c().f42294a) {
                dVar.j = -2;
                this.f42259b = f(n);
                dVar.j = -3;
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f42259b != null) {
                    this.f42259b.setRequestMethod("POST");
                    this.f42259b.setDoOutput(true);
                    this.f42259b.setDoInput(true);
                    this.f42259b.setConnectTimeout(i2);
                    this.f42259b.setReadTimeout(i);
                    this.f42259b.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    if (!this.f42258a.c().f42294a) {
                        this.f42258a.b().t(this.f42259b);
                        if (!this.f42258a.c().f42294a) {
                            dVar.f42281g = System.currentTimeMillis() - currentTimeMillis;
                            dVar.j = -4;
                            this.f42259b.connect();
                            if (this.f42260c <= 0) {
                                this.f42260c = System.currentTimeMillis();
                            }
                            this.f42261d = System.currentTimeMillis();
                            dVar.j = -5;
                            dVar.f42277c = (System.currentTimeMillis() - currentTimeMillis) - dVar.f42281g;
                            if (!this.f42258a.c().f42294a) {
                                dVar.j = -6;
                                this.f42258a.b().u(this.f42259b, dVar);
                                dVar.j = -7;
                                if (!this.f42258a.c().f42294a) {
                                    String contentType = this.f42259b.getContentType();
                                    this.f42262e = System.currentTimeMillis();
                                    if (d.b.c.e.j.b.b.c(contentType)) {
                                        this.f42259b.disconnect();
                                        this.f42259b.connect();
                                        if (this.f42258a.c().f42294a) {
                                            throw new BdHttpCancelException();
                                        }
                                    }
                                    dVar.j = -8;
                                    this.f42258a.c().a(this.f42259b);
                                    dVar.i = this.f42258a.c().f42295b;
                                    dVar.f42276b = this.f42259b.getHeaderFields().toString().getBytes().length;
                                    byte[] m = m(this.f42259b);
                                    if (m != null) {
                                        dVar.f42276b += m.length;
                                        this.f42258a.c().i = m.length;
                                        this.f42258a.c().f42301h = c(this.f42258a.c().f42297d, m);
                                    }
                                    dVar.f42278d = new Date().getTime() - currentTimeMillis;
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
            d.b.c.e.m.a.e(this.f42259b);
        }
    }

    public void s(int i) {
        this.l = i;
    }

    public void t(boolean z) {
        this.k = z;
    }

    public void u(boolean z) {
        this.j = z;
    }
}
