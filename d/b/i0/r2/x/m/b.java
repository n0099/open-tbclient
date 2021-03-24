package d.b.i0.r2.x.m;

import android.text.TextUtils;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.tieba.recapp.download.http.BdHttpCancelException;
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
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class b {
    public static String i;

    /* renamed from: a  reason: collision with root package name */
    public int f59945a;

    /* renamed from: b  reason: collision with root package name */
    public g f59946b;

    /* renamed from: c  reason: collision with root package name */
    public HttpURLConnection f59947c;

    /* renamed from: d  reason: collision with root package name */
    public long f59948d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59949e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59950f = true;

    /* renamed from: g  reason: collision with root package name */
    public TimerTask f59951g = new a();

    /* renamed from: h  reason: collision with root package name */
    public Timer f59952h = new Timer();

    /* loaded from: classes5.dex */
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.a();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    static {
        Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
        i = "--------7da3d81520810*";
        System.setProperty("http.keepAlive", "false");
    }

    public b(g gVar) {
        if (gVar != null) {
            this.f59946b = gVar;
            return;
        }
        throw new NullPointerException("init HttpImpl's args context is null");
    }

    public void a() {
        this.f59946b.b().f59980a = true;
        d.b.b.e.m.a.e(this.f59947c);
    }

    public final byte[] b(String str, byte[] bArr) throws Exception {
        if (str == null || !str.toLowerCase().contains(AsyncHttpClient.ENCODING_GZIP)) {
            return bArr;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        d.b.b.e.p.g.c(byteArrayInputStream, byteArrayOutputStream);
        System.currentTimeMillis();
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:120:0x0289 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v36 */
    public boolean c(String str, j jVar, int i2, int i3, boolean z, e eVar, boolean z2) throws Exception {
        FileOutputStream fileOutputStream;
        String e2;
        File i4;
        InputStream inputStream;
        InputStream inputStream2;
        int read;
        String headerField;
        int indexOf;
        this.f59945a = 0;
        e eVar2 = eVar == null ? new e() : eVar;
        InputStream inputStream3 = null;
        try {
            e2 = this.f59946b.a().e();
            eVar2.j = e2;
            HttpURLConnection e3 = e(i(e2, eVar2), i3, i2);
            this.f59947c = e3;
            e3.setInstanceFollowRedirects(true);
            HttpURLConnection.setFollowRedirects(false);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        if (this.f59946b.b().f59980a) {
            System.currentTimeMillis();
            d.b.b.e.m.a.c(null);
            d.b.b.e.m.a.e(this.f59947c);
            d.b.b.e.m.a.d(null);
            return false;
        }
        if (z2) {
            d.b.b.e.p.f.k(str);
        }
        if (z) {
            i4 = new File(str);
        } else {
            i4 = d.b.b.e.p.f.i(str);
        }
        if (i4 != null) {
            long length = i4.length();
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(i4, true);
                try {
                    this.f59946b.a().j(this.f59947c);
                    this.f59947c.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                    this.f59947c.connect();
                    if (this.f59948d <= 0) {
                        try {
                            this.f59948d = System.currentTimeMillis();
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = fileOutputStream2;
                            inputStream3 = null;
                        }
                    }
                    System.currentTimeMillis();
                    int responseCode = this.f59947c.getResponseCode();
                    while (l(responseCode) && this.f59945a <= 5) {
                        this.f59947c = j(this.f59947c, i3, i2);
                        this.f59946b.a().j(this.f59947c);
                        this.f59947c.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                        this.f59947c.connect();
                        responseCode = this.f59947c.getResponseCode();
                    }
                    System.currentTimeMillis();
                    this.f59946b.b().f59981b = responseCode;
                    if (k()) {
                        if (this.f59947c.getContentType() != null && this.f59947c.getContentType().contains("text/vnd.wap.wml")) {
                            this.f59947c.disconnect();
                            this.f59946b.b().f59981b = 0;
                            boolean c2 = c(str, jVar, i2, i3, z, eVar2, z2);
                            System.currentTimeMillis();
                            d.b.b.e.m.a.c(null);
                            d.b.b.e.m.a.e(this.f59947c);
                            d.b.b.e.m.a.d(fileOutputStream2);
                            return c2;
                        }
                        String headerField2 = this.f59947c.getHeaderField("Content-Range");
                        int d2 = (headerField2 == null || (indexOf = headerField2.indexOf("/")) == -1) ? 0 : d.b.b.e.m.b.d(headerField2.substring(indexOf + 1), 0);
                        if (d2 == 0 && this.f59946b.b().f59981b == 200 && (headerField = this.f59947c.getHeaderField("Content-Length")) != null) {
                            d2 = d.b.b.e.m.b.d(headerField, 0);
                        }
                        this.f59946b.b().f59984e = String.valueOf(d2);
                        eVar2.f59965a = e2.getBytes().length;
                        long length2 = this.f59947c.getHeaderFields().toString().getBytes().length;
                        eVar2.f59966b = length2;
                        long j = d2;
                        eVar2.f59966b = length2 + j;
                        if (this.f59946b.b().f59981b != 416 && this.f59946b.b().f59981b != 204) {
                            if (d2 != 0 && length >= j) {
                                System.currentTimeMillis();
                                System.currentTimeMillis();
                                d.b.b.e.m.a.c(null);
                                d.b.b.e.m.a.e(this.f59947c);
                                d.b.b.e.m.a.d(fileOutputStream2);
                                return true;
                            }
                            InputStream inputStream4 = this.f59947c.getInputStream();
                            try {
                                byte[] bArr = new byte[1024];
                                int i5 = d2 > 0 ? d2 / 50 : 0;
                                if (jVar != null && length > 0) {
                                    jVar.onProgress((int) length, d2);
                                }
                                int i6 = 0;
                                loop1: while (true) {
                                    int i7 = 0;
                                    while (!this.f59946b.b().f59980a && (read = inputStream4.read(bArr)) != -1) {
                                        try {
                                            fileOutputStream2.write(bArr, 0, read);
                                            i6 += read;
                                            i7 += read;
                                            if (jVar != null && (i7 > i5 || i6 == d2)) {
                                                jVar.onProgress((int) (i6 + length), d2);
                                            }
                                        } catch (Exception unused) {
                                            throw new FileNotFoundException();
                                        }
                                    }
                                }
                                try {
                                    fileOutputStream2.flush();
                                    boolean z3 = ((long) i6) + length >= j;
                                    System.currentTimeMillis();
                                    d.b.b.e.m.a.c(inputStream4);
                                    d.b.b.e.m.a.e(this.f59947c);
                                    d.b.b.e.m.a.d(fileOutputStream2);
                                    return z3;
                                } catch (Exception unused2) {
                                    throw new FileNotFoundException();
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                fileOutputStream = fileOutputStream2;
                                inputStream3 = inputStream4;
                            }
                        }
                        System.currentTimeMillis();
                        d.b.b.e.m.a.c(null);
                        d.b.b.e.m.a.e(this.f59947c);
                        d.b.b.e.m.a.d(fileOutputStream2);
                        return true;
                    }
                    inputStream2 = null;
                    try {
                        throw new UnsupportedOperationException();
                    } catch (Throwable th4) {
                        th = th4;
                        inputStream3 = inputStream2;
                        fileOutputStream = fileOutputStream2;
                        System.currentTimeMillis();
                        d.b.b.e.m.a.c(inputStream3);
                        d.b.b.e.m.a.e(this.f59947c);
                        d.b.b.e.m.a.d(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    inputStream2 = null;
                }
            } catch (Throwable th6) {
                th = th6;
                inputStream = null;
            }
        } else {
            inputStream = null;
            try {
                throw new FileNotFoundException();
            } catch (Throwable th7) {
                th = th7;
            }
        }
        inputStream3 = inputStream;
        fileOutputStream = inputStream;
        System.currentTimeMillis();
        d.b.b.e.m.a.c(inputStream3);
        d.b.b.e.m.a.e(this.f59947c);
        d.b.b.e.m.a.d(fileOutputStream);
        throw th;
    }

    public final HttpURLConnection d(URL url) {
        String c2;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (d.b.b.e.p.j.z()) {
                if (d.b.b.e.p.j.x() && (c2 = d.b.b.e.p.j.c()) != null && c2.length() > 0) {
                    if (d.b.b.e.p.j.F(c2) && d.b.b.e.p.j.D()) {
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
                            this.f59946b.a().a("X-Online-Host", url.getHost());
                        } catch (Exception e2) {
                            e = e2;
                            httpURLConnection2 = httpURLConnection;
                            e.printStackTrace();
                            return httpURLConnection2;
                        }
                    } else {
                        httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(c2, d.b.b.e.p.j.d())));
                    }
                    httpURLConnection2 = httpURLConnection;
                }
                return httpURLConnection2 == null ? (HttpURLConnection) url.openConnection() : httpURLConnection2;
            }
            return null;
        } catch (Exception e3) {
            e = e3;
        }
    }

    public final HttpURLConnection e(URL url, int i2, int i3) throws SocketException {
        HttpURLConnection d2 = d(url);
        if (d2 != null) {
            d2.setConnectTimeout(i2);
            d2.setReadTimeout(i3);
            return d2;
        }
        throw new SocketException();
    }

    public long f() {
        return this.f59948d;
    }

    public void g(int i2, int i3, e eVar) throws Exception {
        HttpURLConnection httpURLConnection;
        Map<String, List<String>> map;
        List<String> list;
        eVar.f59972h = -1;
        if (!this.f59946b.b().f59980a) {
            String c2 = this.f59946b.a().c(eVar);
            eVar.j = c2;
            URL i4 = i(c2, eVar);
            if (!this.f59946b.b().f59980a) {
                eVar.f59972h = -2;
                this.f59947c = d(i4);
                eVar.f59972h = -3;
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    if (this.f59947c != null) {
                        this.f59947c.setRequestMethod("GET");
                        this.f59947c.setConnectTimeout(i3);
                        this.f59947c.setReadTimeout(i2);
                        this.f59946b.a().j(this.f59947c);
                        if (!this.f59946b.b().f59980a) {
                            eVar.f59969e = new Date().getTime() - currentTimeMillis;
                            eVar.f59972h = -4;
                            this.f59947c.connect();
                            if (this.f59948d <= 0) {
                                this.f59948d = System.currentTimeMillis();
                            }
                            System.currentTimeMillis();
                            eVar.f59972h = -5;
                            eVar.f59967c = (new Date().getTime() - currentTimeMillis) - eVar.f59969e;
                            if (!this.f59946b.b().f59980a) {
                                String contentType = this.f59947c.getContentType();
                                System.currentTimeMillis();
                                if (f.a(contentType)) {
                                    this.f59947c.disconnect();
                                    this.f59947c.connect();
                                    if (this.f59946b.b().f59980a) {
                                        throw new BdHttpCancelException();
                                    }
                                }
                                eVar.f59972h = -8;
                                this.f59946b.b().a(this.f59947c);
                                if (c2.contains("c.tieba.baidu.com") && (map = this.f59946b.b().f59985f) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                                    eVar.k = list.get(0);
                                    eVar.l = list.get(1);
                                }
                                eVar.f59971g = this.f59946b.b().f59981b;
                                eVar.f59966b = this.f59947c.getHeaderFields().toString().getBytes().length;
                                byte[] h2 = h(this.f59947c);
                                if (h2 != null) {
                                    eVar.f59966b += h2.length;
                                    this.f59946b.b().f59986g = b(this.f59946b.b().f59983d, h2);
                                }
                                eVar.f59972h = -9;
                                eVar.f59968d = new Date().getTime() - currentTimeMillis;
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
                    httpURLConnection = this.f59947c;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            }
            throw new BdHttpCancelException();
        }
        throw new BdHttpCancelException();
    }

    public final byte[] h(HttpURLConnection httpURLConnection) throws Exception {
        InputStream inputStream;
        int read;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        byte[] bArr = null;
        if (httpURLConnection != null) {
            try {
                byte[] bArr2 = new byte[1024];
                InputStream inputStream2 = httpURLConnection.getInputStream();
                while (!this.f59946b.b().f59980a && (read = inputStream2.read(bArr2)) != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                if (!this.f59946b.b().f59980a) {
                    bArr = byteArrayOutputStream.toByteArray();
                    inputStream = inputStream2;
                } else {
                    throw new BdHttpCancelException();
                }
            } catch (Throwable th) {
                System.currentTimeMillis();
                d.b.b.e.m.a.d(byteArrayOutputStream);
                d.b.b.e.m.a.c(null);
                throw th;
            }
        } else {
            inputStream = null;
        }
        System.currentTimeMillis();
        d.b.b.e.m.a.d(byteArrayOutputStream);
        d.b.b.e.m.a.c(inputStream);
        return bArr;
    }

    public final URL i(String str, e eVar) throws Exception {
        d.b.i0.r2.x.m.a b2;
        URL url = new URL(str);
        if (!this.f59950f || (b2 = d.b.i0.r2.x.m.a.b()) == null) {
            return url;
        }
        String a2 = b2.a(str);
        if (TextUtils.isEmpty(a2)) {
            return url;
        }
        this.f59946b.a().a("Host", url.getHost());
        URL url2 = new URL(str.replace("://" + url.getHost(), "://" + a2));
        this.f59949e = true;
        eVar.i = a2;
        return url2;
    }

    public final HttpURLConnection j(HttpURLConnection httpURLConnection, int i2, int i3) throws Exception {
        if (httpURLConnection == null) {
            return null;
        }
        URL url = httpURLConnection.getURL().toURI().resolve(httpURLConnection.getHeaderField("Location")).toURL();
        d.b.b.e.m.a.e(httpURLConnection);
        HttpURLConnection e2 = e(url, i2, i3);
        this.f59945a++;
        return e2;
    }

    public final boolean k() {
        return this.f59946b.b().f59981b == 200 || this.f59946b.b().f59981b == 206;
    }

    public final boolean l(int i2) {
        return i2 == 302 || i2 == 301 || i2 == 304 || i2 == 300 || i2 == 307 || i2 == 308 || i2 == 303;
    }

    public boolean m() {
        return this.f59949e;
    }

    public void n(int i2, int i3, e eVar) throws Exception {
        eVar.f59972h = -1;
        try {
            String e2 = this.f59946b.a().e();
            eVar.j = e2;
            URL i4 = i(e2, eVar);
            if (!this.f59946b.b().f59980a) {
                eVar.f59972h = -2;
                this.f59947c = d(i4);
                eVar.f59972h = -3;
                System.currentTimeMillis();
                if (this.f59947c != null) {
                    this.f59947c.setRequestMethod("POST");
                    this.f59947c.setDoOutput(true);
                    this.f59947c.setDoInput(true);
                    this.f59947c.setConnectTimeout(i3);
                    this.f59947c.setReadTimeout(i2);
                    this.f59947c.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + i);
                    if (!this.f59946b.b().f59980a) {
                        this.f59946b.a().j(this.f59947c);
                        if (!this.f59946b.b().f59980a) {
                            long time = new Date().getTime();
                            eVar.f59969e = new Date().getTime() - time;
                            eVar.f59972h = -4;
                            this.f59947c.connect();
                            if (this.f59948d <= 0) {
                                this.f59948d = System.currentTimeMillis();
                            }
                            System.currentTimeMillis();
                            eVar.f59972h = -5;
                            eVar.f59967c = (new Date().getTime() - time) - eVar.f59969e;
                            if (!this.f59946b.b().f59980a) {
                                if (this.f59952h != null) {
                                    this.f59952h.schedule(this.f59951g, 45000L);
                                }
                                eVar.f59972h = -6;
                                this.f59946b.a().l(this.f59947c, i, eVar);
                                eVar.f59972h = -7;
                                String contentType = this.f59947c.getContentType();
                                System.currentTimeMillis();
                                if (f.a(contentType)) {
                                    this.f59947c.disconnect();
                                    this.f59947c.connect();
                                    if (this.f59946b.b().f59980a) {
                                        throw new BdHttpCancelException();
                                    }
                                }
                                if (!this.f59946b.b().f59980a) {
                                    eVar.f59972h = -8;
                                    this.f59946b.b().a(this.f59947c);
                                    eVar.f59971g = this.f59946b.b().f59981b;
                                    eVar.f59966b = this.f59947c.getHeaderFields().toString().getBytes().length;
                                    byte[] h2 = h(this.f59947c);
                                    if (h2 != null) {
                                        eVar.f59966b += h2.length;
                                        this.f59946b.b().f59987h = h2.length;
                                        this.f59946b.b().f59986g = b(this.f59946b.b().f59983d, h2);
                                    }
                                    eVar.f59968d = new Date().getTime() - time;
                                    eVar.f59972h = -9;
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
            Timer timer = this.f59952h;
            if (timer != null) {
                timer.cancel();
            }
            d.b.b.e.m.a.e(this.f59947c);
        }
    }

    public void o(int i2, int i3, e eVar) throws Exception {
        eVar.f59972h = -1;
        try {
            String e2 = this.f59946b.a().e();
            eVar.j = e2;
            URL i4 = i(e2, eVar);
            if (!this.f59946b.b().f59980a) {
                eVar.f59972h = -2;
                this.f59947c = d(i4);
                eVar.f59972h = -3;
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f59947c != null) {
                    this.f59947c.setRequestMethod("POST");
                    this.f59947c.setDoOutput(true);
                    this.f59947c.setDoInput(true);
                    this.f59947c.setConnectTimeout(i3);
                    this.f59947c.setReadTimeout(i2);
                    this.f59947c.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    if (!this.f59946b.b().f59980a) {
                        this.f59946b.a().j(this.f59947c);
                        if (!this.f59946b.b().f59980a) {
                            eVar.f59969e = System.currentTimeMillis() - currentTimeMillis;
                            eVar.f59972h = -4;
                            this.f59947c.connect();
                            if (this.f59948d <= 0) {
                                this.f59948d = System.currentTimeMillis();
                            }
                            System.currentTimeMillis();
                            eVar.f59972h = -5;
                            eVar.f59967c = (System.currentTimeMillis() - currentTimeMillis) - eVar.f59969e;
                            if (!this.f59946b.b().f59980a) {
                                eVar.f59972h = -6;
                                this.f59946b.a().k(this.f59947c, eVar);
                                eVar.f59972h = -7;
                                if (!this.f59946b.b().f59980a) {
                                    String contentType = this.f59947c.getContentType();
                                    System.currentTimeMillis();
                                    if (f.a(contentType)) {
                                        this.f59947c.disconnect();
                                        this.f59947c.connect();
                                        if (this.f59946b.b().f59980a) {
                                            throw new BdHttpCancelException();
                                        }
                                    }
                                    this.f59946b.b().a(this.f59947c);
                                    eVar.f59972h = -8;
                                    eVar.f59971g = this.f59946b.b().f59981b;
                                    eVar.f59966b = this.f59947c.getHeaderFields().toString().getBytes().length;
                                    byte[] h2 = h(this.f59947c);
                                    if (h2 != null) {
                                        eVar.f59966b += h2.length;
                                        this.f59946b.b().f59987h = h2.length;
                                        this.f59946b.b().f59986g = b(this.f59946b.b().f59983d, h2);
                                    }
                                    eVar.f59968d = new Date().getTime() - currentTimeMillis;
                                    eVar.f59972h = -9;
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
            d.b.b.e.m.a.e(this.f59947c);
        }
    }
}
