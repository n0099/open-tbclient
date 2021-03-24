package d.c.c.a.b.a;

import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.searchbox.http.response.ResponseException;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.bytedance.sdk.a.b.s;
import d.c.c.a.b.a0;
import d.c.c.a.b.b0;
import d.c.c.a.b.c;
import d.c.c.a.b.p;
import d.c.c.a.b.q;
import d.c.c.a.b.t;
import d.c.c.a.b.v;
import d.c.c.a.b.w;
import d.c.c.a.b.x;
import d.c.c.a.b.y;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.net.InetAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import org.apache.commons.base.CharEncoding;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.cookie.DateUtils;
import org.apache.http.impl.cookie.NetscapeDraftSpec;
import org.apache.http.protocol.HTTP;
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f65217a;

    /* renamed from: c  reason: collision with root package name */
    public static final d.c.c.a.b.d f65219c;

    /* renamed from: d  reason: collision with root package name */
    public static final b0 f65220d;
    public static final Charset k;
    public static final Charset l;
    public static final Charset m;
    public static final Charset n;
    public static final TimeZone o;
    public static final Comparator<String> p;
    public static final Pattern q;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f65218b = new String[0];

    /* renamed from: e  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f65221e = com.bytedance.sdk.a.a.f.b("efbbbf");

    /* renamed from: f  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f65222f = com.bytedance.sdk.a.a.f.b("feff");

    /* renamed from: g  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f65223g = com.bytedance.sdk.a.a.f.b("fffe");

    /* renamed from: h  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f65224h = com.bytedance.sdk.a.a.f.b("0000ffff");
    public static final com.bytedance.sdk.a.a.f i = com.bytedance.sdk.a.a.f.b("ffff0000");
    public static final Charset j = Charset.forName("UTF-8");

    /* loaded from: classes5.dex */
    public static class a implements Comparator<String> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f65225e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f65226f;

        public b(String str, boolean z) {
            this.f65225e = str;
            this.f65226f = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "tt_pangle_thread_" + this.f65225e);
            thread.setDaemon(this.f65226f);
            return thread;
        }
    }

    /* loaded from: classes5.dex */
    public final class c implements w {

        /* renamed from: a  reason: collision with root package name */
        public final q f65227a;

        public c(q qVar) {
            this.f65227a = qVar;
        }

        @Override // d.c.c.a.b.w
        public d.c.c.a.b.c a(w.a aVar) throws IOException {
            a0 a2 = aVar.a();
            a0.a f2 = a2.f();
            b0 e2 = a2.e();
            if (e2 != null) {
                x a3 = e2.a();
                if (a3 != null) {
                    f2.g("Content-Type", a3.toString());
                }
                long f3 = e2.f();
                if (f3 != -1) {
                    f2.g("Content-Length", Long.toString(f3));
                    f2.k("Transfer-Encoding");
                } else {
                    f2.g("Transfer-Encoding", "chunked");
                    f2.k("Content-Length");
                }
            }
            boolean z = false;
            if (a2.b("Host") == null) {
                f2.g("Host", e.h(a2.a(), false));
            }
            if (a2.b(HTTP.CONN_DIRECTIVE) == null) {
                f2.g(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            }
            if (a2.b("Accept-Encoding") == null && a2.b("Range") == null) {
                z = true;
                f2.g("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
            }
            List<p> b2 = this.f65227a.b(a2.a());
            if (!b2.isEmpty()) {
                f2.g("Cookie", b(b2));
            }
            if (a2.b("User-Agent") == null) {
                f2.g("User-Agent", d.c.c.a.b.a.g.a());
            }
            d.c.c.a.b.c a4 = aVar.a(f2.p());
            g.f(this.f65227a, a2.a(), a4.w());
            c.a y = a4.y();
            y.h(a2);
            if (z && AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(a4.o("Content-Encoding")) && g.h(a4)) {
                d.c.c.a.a.i iVar = new d.c.c.a.a.i(a4.x().r());
                v.a h2 = a4.w().h();
                h2.d("Content-Encoding");
                h2.d("Content-Length");
                y.f(h2.c());
                y.d(new j(a4.o("Content-Type"), -1L, d.c.c.a.a.k.b(iVar)));
            }
            return y.k();
        }

        public final String b(List<p> list) {
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    sb.append("; ");
                }
                p pVar = list.get(i);
                sb.append(pVar.f());
                sb.append(com.alipay.sdk.encrypt.a.f1897h);
                sb.append(pVar.j());
            }
            return sb.toString();
        }
    }

    /* loaded from: classes5.dex */
    public final class d implements w {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f65228a;

        /* loaded from: classes5.dex */
        public static final class a extends d.c.c.a.a.f {

            /* renamed from: f  reason: collision with root package name */
            public long f65229f;

            public a(d.c.c.a.a.p pVar) {
                super(pVar);
            }

            @Override // d.c.c.a.a.f, d.c.c.a.a.p
            public void b(d.c.c.a.a.c cVar, long j) throws IOException {
                super.b(cVar, j);
                this.f65229f += j;
            }
        }

        public d(boolean z) {
            this.f65228a = z;
        }

        @Override // d.c.c.a.b.w
        public d.c.c.a.b.c a(w.a aVar) throws IOException {
            d.c.c.a.b.c k;
            i iVar = (i) aVar;
            InterfaceC1786e g2 = iVar.g();
            d.c.c.a.b.a.c.f f2 = iVar.f();
            d.c.c.a.b.a.c.c cVar = (d.c.c.a.b.a.c.c) iVar.e();
            a0 a2 = iVar.a();
            long currentTimeMillis = System.currentTimeMillis();
            iVar.i().q(iVar.h());
            g2.a(a2);
            iVar.i().g(iVar.h(), a2);
            c.a aVar2 = null;
            if (h.c(a2.c()) && a2.e() != null) {
                if (HTTP.EXPECT_CONTINUE.equalsIgnoreCase(a2.b(HTTP.EXPECT_DIRECTIVE))) {
                    g2.a();
                    iVar.i().s(iVar.h());
                    aVar2 = g2.a(true);
                }
                if (aVar2 == null) {
                    iVar.i().r(iVar.h());
                    a aVar3 = new a(g2.c(a2, a2.e().f()));
                    d.c.c.a.a.d a3 = d.c.c.a.a.k.a(aVar3);
                    a2.e().e(a3);
                    a3.close();
                    iVar.i().c(iVar.h(), aVar3.f65229f);
                } else if (!cVar.o()) {
                    f2.m();
                }
            }
            g2.b();
            if (aVar2 == null) {
                iVar.i().s(iVar.h());
                aVar2 = g2.a(false);
            }
            aVar2.h(a2);
            aVar2.e(f2.j().n());
            aVar2.b(currentTimeMillis);
            aVar2.m(System.currentTimeMillis());
            d.c.c.a.b.c k2 = aVar2.k();
            iVar.i().d(iVar.h(), k2);
            int r = k2.r();
            if (this.f65228a && r == 101) {
                c.a y = k2.y();
                y.d(e.f65219c);
                k = y.k();
            } else {
                c.a y2 = k2.y();
                y2.d(g2.b(k2));
                k = y2.k();
            }
            if (IntentConfig.CLOSE.equalsIgnoreCase(k.n().b(HTTP.CONN_DIRECTIVE)) || IntentConfig.CLOSE.equalsIgnoreCase(k.o(HTTP.CONN_DIRECTIVE))) {
                f2.m();
            }
            if ((r == 204 || r == 205) && k.x().o() > 0) {
                throw new ProtocolException("HTTP " + r + " had non-zero Content-Length: " + k.x().o());
            }
            return k;
        }
    }

    /* renamed from: d.c.c.a.b.a.e$e  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1786e {
        c.a a(boolean z) throws IOException;

        void a() throws IOException;

        void a(a0 a0Var) throws IOException;

        d.c.c.a.b.d b(d.c.c.a.b.c cVar) throws IOException;

        void b() throws IOException;

        d.c.c.a.a.p c(a0 a0Var, long j);
    }

    /* loaded from: classes5.dex */
    public final class f {

        /* renamed from: a  reason: collision with root package name */
        public static final ThreadLocal<DateFormat> f65230a = new a();

        /* renamed from: b  reason: collision with root package name */
        public static final String[] f65231b;

        /* renamed from: c  reason: collision with root package name */
        public static final DateFormat[] f65232c;

        /* loaded from: classes5.dex */
        public static class a extends ThreadLocal<DateFormat> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.lang.ThreadLocal
            /* renamed from: a */
            public DateFormat initialValue() {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
                simpleDateFormat.setLenient(false);
                simpleDateFormat.setTimeZone(e.o);
                return simpleDateFormat;
            }
        }

        static {
            String[] strArr = {"EEE, dd MMM yyyy HH:mm:ss zzz", DateUtils.PATTERN_RFC1036, DateUtils.PATTERN_ASCTIME, NetscapeDraftSpec.EXPIRES_PATTERN, "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
            f65231b = strArr;
            f65232c = new DateFormat[strArr.length];
        }

        public static String a(Date date) {
            return f65230a.get().format(date);
        }

        public static Date b(String str) {
            if (str.length() == 0) {
                return null;
            }
            ParsePosition parsePosition = new ParsePosition(0);
            Date parse = f65230a.get().parse(str, parsePosition);
            if (parsePosition.getIndex() == str.length()) {
                return parse;
            }
            synchronized (f65231b) {
                int length = f65231b.length;
                for (int i = 0; i < length; i++) {
                    DateFormat dateFormat = f65232c[i];
                    if (dateFormat == null) {
                        dateFormat = new SimpleDateFormat(f65231b[i], Locale.US);
                        dateFormat.setTimeZone(e.o);
                        f65232c[i] = dateFormat;
                    }
                    parsePosition.setIndex(0);
                    Date parse2 = dateFormat.parse(str, parsePosition);
                    if (parsePosition.getIndex() != 0) {
                        return parse2;
                    }
                }
                return null;
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class g {
        static {
            Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");
        }

        public static int a(String str, int i) {
            char charAt;
            while (i < str.length() && ((charAt = str.charAt(i)) == ' ' || charAt == '\t')) {
                i++;
            }
            return i;
        }

        public static int b(String str, int i, String str2) {
            while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
                i++;
            }
            return i;
        }

        public static long c(d.c.c.a.b.c cVar) {
            return d(cVar.w());
        }

        public static long d(v vVar) {
            return e(vVar.c("Content-Length"));
        }

        public static long e(String str) {
            if (str == null) {
                return -1L;
            }
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }

        public static void f(q qVar, s sVar, v vVar) {
            if (qVar == q.f65539a) {
                return;
            }
            List<p> h2 = p.h(sVar, vVar);
            if (h2.isEmpty()) {
                return;
            }
            qVar.a(sVar, h2);
        }

        public static int g(String str, int i) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                if (parseLong < 0) {
                    return 0;
                }
                return (int) parseLong;
            } catch (NumberFormatException unused) {
                return i;
            }
        }

        public static boolean h(d.c.c.a.b.c cVar) {
            if (cVar.n().c().equals("HEAD")) {
                return false;
            }
            int r = cVar.r();
            return (((r >= 100 && r < 200) || r == 204 || r == 304) && c(cVar) == -1 && !"chunked".equalsIgnoreCase(cVar.o("Transfer-Encoding"))) ? false : true;
        }
    }

    /* loaded from: classes5.dex */
    public final class h {
        public static boolean a(String str) {
            return str.equals("POST") || str.equals("PATCH") || str.equals(HttpPut.METHOD_NAME) || str.equals(HttpDelete.METHOD_NAME) || str.equals("MOVE");
        }

        public static boolean b(String str) {
            return str.equals("POST") || str.equals(HttpPut.METHOD_NAME) || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
        }

        public static boolean c(String str) {
            return b(str) || str.equals(HttpOptions.METHOD_NAME) || str.equals(HttpDelete.METHOD_NAME) || str.equals("PROPFIND") || str.equals("MKCOL") || str.equals("LOCK");
        }

        public static boolean d(String str) {
            return str.equals("PROPFIND");
        }

        public static boolean e(String str) {
            return !str.equals("PROPFIND");
        }
    }

    /* loaded from: classes5.dex */
    public final class i implements w.a {

        /* renamed from: a  reason: collision with root package name */
        public final List<w> f65233a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.c.a.b.a.c.f f65234b;

        /* renamed from: c  reason: collision with root package name */
        public final InterfaceC1786e f65235c;

        /* renamed from: d  reason: collision with root package name */
        public final d.c.c.a.b.a.c.c f65236d;

        /* renamed from: e  reason: collision with root package name */
        public final int f65237e;

        /* renamed from: f  reason: collision with root package name */
        public final a0 f65238f;

        /* renamed from: g  reason: collision with root package name */
        public final d.c.c.a.b.i f65239g;

        /* renamed from: h  reason: collision with root package name */
        public final t f65240h;
        public final int i;
        public final int j;
        public final int k;
        public int l;

        public i(List<w> list, d.c.c.a.b.a.c.f fVar, InterfaceC1786e interfaceC1786e, d.c.c.a.b.a.c.c cVar, int i, a0 a0Var, d.c.c.a.b.i iVar, t tVar, int i2, int i3, int i4) {
            this.f65233a = list;
            this.f65236d = cVar;
            this.f65234b = fVar;
            this.f65235c = interfaceC1786e;
            this.f65237e = i;
            this.f65238f = a0Var;
            this.f65239g = iVar;
            this.f65240h = tVar;
            this.i = i2;
            this.j = i3;
            this.k = i4;
        }

        @Override // d.c.c.a.b.w.a
        public a0 a() {
            return this.f65238f;
        }

        @Override // d.c.c.a.b.w.a
        public int b() {
            return this.i;
        }

        @Override // d.c.c.a.b.w.a
        public int c() {
            return this.j;
        }

        @Override // d.c.c.a.b.w.a
        public int d() {
            return this.k;
        }

        public d.c.c.a.b.m e() {
            return this.f65236d;
        }

        public d.c.c.a.b.a.c.f f() {
            return this.f65234b;
        }

        public InterfaceC1786e g() {
            return this.f65235c;
        }

        public d.c.c.a.b.i h() {
            return this.f65239g;
        }

        public t i() {
            return this.f65240h;
        }

        @Override // d.c.c.a.b.w.a
        public d.c.c.a.b.c a(a0 a0Var) throws IOException {
            return b(a0Var, this.f65234b, this.f65235c, this.f65236d);
        }

        public d.c.c.a.b.c b(a0 a0Var, d.c.c.a.b.a.c.f fVar, InterfaceC1786e interfaceC1786e, d.c.c.a.b.a.c.c cVar) throws IOException {
            if (this.f65237e < this.f65233a.size()) {
                this.l++;
                if (this.f65235c != null && !this.f65236d.k(a0Var.a())) {
                    throw new IllegalStateException("network interceptor " + this.f65233a.get(this.f65237e - 1) + " must retain the same host and port");
                } else if (this.f65235c != null && this.l > 1) {
                    throw new IllegalStateException("network interceptor " + this.f65233a.get(this.f65237e - 1) + " must call proceed() exactly once");
                } else {
                    i iVar = new i(this.f65233a, fVar, interfaceC1786e, cVar, this.f65237e + 1, a0Var, this.f65239g, this.f65240h, this.i, this.j, this.k);
                    w wVar = this.f65233a.get(this.f65237e);
                    d.c.c.a.b.c a2 = wVar.a(iVar);
                    if (interfaceC1786e != null && this.f65237e + 1 < this.f65233a.size() && iVar.l != 1) {
                        throw new IllegalStateException("network interceptor " + wVar + " must call proceed() exactly once");
                    } else if (a2 != null) {
                        if (a2.x() != null) {
                            return a2;
                        }
                        throw new IllegalStateException("interceptor " + wVar + " returned a response with no body");
                    } else {
                        throw new NullPointerException("interceptor " + wVar + " returned null");
                    }
                }
            }
            throw new AssertionError();
        }
    }

    /* loaded from: classes5.dex */
    public final class j extends d.c.c.a.b.d {

        /* renamed from: e  reason: collision with root package name */
        public final String f65241e;

        /* renamed from: f  reason: collision with root package name */
        public final long f65242f;

        /* renamed from: g  reason: collision with root package name */
        public final d.c.c.a.a.e f65243g;

        public j(String str, long j, d.c.c.a.a.e eVar) {
            this.f65241e = str;
            this.f65242f = j;
            this.f65243g = eVar;
        }

        @Override // d.c.c.a.b.d
        public x n() {
            String str = this.f65241e;
            if (str != null) {
                return x.a(str);
            }
            return null;
        }

        @Override // d.c.c.a.b.d
        public long o() {
            return this.f65242f;
        }

        @Override // d.c.c.a.b.d
        public d.c.c.a.a.e r() {
            return this.f65243g;
        }
    }

    /* loaded from: classes5.dex */
    public final class k {
        public static String a(s sVar) {
            String x = sVar.x();
            String z = sVar.z();
            if (z != null) {
                return x + '?' + z;
            }
            return x;
        }

        public static String b(a0 a0Var, Proxy.Type type) {
            StringBuilder sb = new StringBuilder();
            sb.append(a0Var.c());
            sb.append(' ');
            if (c(a0Var, type)) {
                sb.append(a0Var.a());
            } else {
                sb.append(a(a0Var.a()));
            }
            sb.append(" HTTP/1.1");
            return sb.toString();
        }

        public static boolean c(a0 a0Var, Proxy.Type type) {
            return !a0Var.h() && type == Proxy.Type.HTTP;
        }
    }

    /* loaded from: classes5.dex */
    public final class l implements w {

        /* renamed from: a  reason: collision with root package name */
        public final y f65244a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f65245b;

        /* renamed from: c  reason: collision with root package name */
        public d.c.c.a.b.a.c.f f65246c;

        /* renamed from: d  reason: collision with root package name */
        public Object f65247d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f65248e;

        public l(y yVar, boolean z) {
            this.f65244a = yVar;
            this.f65245b = z;
        }

        @Override // d.c.c.a.b.w
        public d.c.c.a.b.c a(w.a aVar) throws IOException {
            d.c.c.a.b.c b2;
            a0 c2;
            a0 a2 = aVar.a();
            i iVar = (i) aVar;
            d.c.c.a.b.i h2 = iVar.h();
            t i = iVar.i();
            this.f65246c = new d.c.c.a.b.a.c.f(this.f65244a.r(), b(a2.a()), h2, i, this.f65247d);
            d.c.c.a.b.c cVar = null;
            int i2 = 0;
            while (!this.f65248e) {
                try {
                    try {
                        b2 = iVar.b(a2, this.f65246c, null, null);
                        if (cVar != null) {
                            c.a y = b2.y();
                            c.a y2 = cVar.y();
                            y2.d(null);
                            y.o(y2.k());
                            b2 = y.k();
                        }
                        c2 = c(b2);
                    } catch (com.bytedance.sdk.a.b.a.b.e e2) {
                        if (!h(e2.a(), false, a2)) {
                            throw e2.a();
                        }
                    } catch (IOException e3) {
                        if (!h(e3, !(e3 instanceof com.bytedance.sdk.a.b.a.e.a), a2)) {
                            throw e3;
                        }
                    }
                    if (c2 == null) {
                        if (!this.f65245b) {
                            this.f65246c.l();
                        }
                        return b2;
                    }
                    e.q(b2.x());
                    int i3 = i2 + 1;
                    if (i3 <= 20) {
                        c2.e();
                        if (!f(b2, c2.a())) {
                            this.f65246c.l();
                            this.f65246c = new d.c.c.a.b.a.c.f(this.f65244a.r(), b(c2.a()), h2, i, this.f65247d);
                        } else if (this.f65246c.c() != null) {
                            throw new IllegalStateException("Closing the body of " + b2 + " didn't close its backing stream. Bad interceptor?");
                        }
                        cVar = b2;
                        a2 = c2;
                        i2 = i3;
                    } else {
                        this.f65246c.l();
                        throw new ProtocolException("Too many follow-up requests: " + i3);
                    }
                } catch (Throwable th) {
                    this.f65246c.h(null);
                    this.f65246c.l();
                    throw th;
                }
            }
            this.f65246c.l();
            throw new IOException(ResponseException.CANCELED);
        }

        public final d.c.c.a.b.b b(s sVar) {
            SSLSocketFactory sSLSocketFactory;
            HostnameVerifier hostnameVerifier;
            d.c.c.a.b.k kVar;
            if (sVar.q()) {
                SSLSocketFactory m = this.f65244a.m();
                hostnameVerifier = this.f65244a.n();
                sSLSocketFactory = m;
                kVar = this.f65244a.o();
            } else {
                sSLSocketFactory = null;
                hostnameVerifier = null;
                kVar = null;
            }
            return new d.c.c.a.b.b(sVar.v(), sVar.w(), this.f65244a.k(), this.f65244a.l(), sSLSocketFactory, hostnameVerifier, kVar, this.f65244a.q(), this.f65244a.g(), this.f65244a.w(), this.f65244a.x(), this.f65244a.h());
        }

        public final a0 c(d.c.c.a.b.c cVar) throws IOException {
            String o;
            s p;
            Proxy g2;
            if (cVar != null) {
                d.c.c.a.b.a.c.c j = this.f65246c.j();
                d.c.c.a.b.e a2 = j != null ? j.a() : null;
                int r = cVar.r();
                String c2 = cVar.n().c();
                if (r == 307 || r == 308) {
                    if (!c2.equals("GET") && !c2.equals("HEAD")) {
                        return null;
                    }
                } else if (r != 401) {
                    if (r == 407) {
                        if (a2 != null) {
                            g2 = a2.b();
                        } else {
                            g2 = this.f65244a.g();
                        }
                        if (g2.type() == Proxy.Type.HTTP) {
                            return this.f65244a.q().a(a2, cVar);
                        }
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    } else if (r == 408) {
                        if (this.f65244a.u()) {
                            cVar.n().e();
                            if (cVar.z() == null || cVar.z().r() != 408) {
                                return cVar.n();
                            }
                            return null;
                        }
                        return null;
                    } else {
                        switch (r) {
                            case 300:
                            case 301:
                            case 302:
                            case 303:
                                break;
                            default:
                                return null;
                        }
                    }
                } else {
                    return this.f65244a.p().a(a2, cVar);
                }
                if (!this.f65244a.t() || (o = cVar.o("Location")) == null || (p = cVar.n().a().p(o)) == null) {
                    return null;
                }
                if (p.m().equals(cVar.n().a().m()) || this.f65244a.s()) {
                    a0.a f2 = cVar.n().f();
                    if (h.c(c2)) {
                        boolean d2 = h.d(c2);
                        if (h.e(c2)) {
                            f2.f("GET", null);
                        } else {
                            f2.f(c2, d2 ? cVar.n().e() : null);
                        }
                        if (!d2) {
                            f2.k("Transfer-Encoding");
                            f2.k("Content-Length");
                            f2.k("Content-Type");
                        }
                    }
                    if (!f(cVar, p)) {
                        f2.k("Authorization");
                    }
                    f2.c(p);
                    return f2.p();
                }
                return null;
            }
            throw new IllegalStateException();
        }

        public void d(Object obj) {
            this.f65247d = obj;
        }

        public boolean e() {
            return this.f65248e;
        }

        public final boolean f(d.c.c.a.b.c cVar, s sVar) {
            s a2 = cVar.n().a();
            return a2.v().equals(sVar.v()) && a2.w() == sVar.w() && a2.m().equals(sVar.m());
        }

        public final boolean g(IOException iOException, boolean z) {
            if (iOException instanceof ProtocolException) {
                return false;
            }
            return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
        }

        public final boolean h(IOException iOException, boolean z, a0 a0Var) {
            this.f65246c.h(iOException);
            if (this.f65244a.u()) {
                if (z) {
                    a0Var.e();
                }
                return g(iOException, z) && this.f65246c.n();
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public final class m {

        /* renamed from: a  reason: collision with root package name */
        public final com.bytedance.sdk.a.b.w f65249a;

        /* renamed from: b  reason: collision with root package name */
        public final int f65250b;

        /* renamed from: c  reason: collision with root package name */
        public final String f65251c;

        public m(com.bytedance.sdk.a.b.w wVar, int i, String str) {
            this.f65249a = wVar;
            this.f65250b = i;
            this.f65251c = str;
        }

        public static m a(d.c.c.a.b.c cVar) {
            return new m(cVar.q(), cVar.r(), cVar.t());
        }

        public static m b(String str) throws IOException {
            com.bytedance.sdk.a.b.w wVar;
            String str2;
            int i = 9;
            if (str.startsWith("HTTP/1.")) {
                if (str.length() >= 9 && str.charAt(8) == ' ') {
                    int charAt = str.charAt(7) - '0';
                    if (charAt == 0) {
                        wVar = com.bytedance.sdk.a.b.w.HTTP_1_0;
                    } else if (charAt == 1) {
                        wVar = com.bytedance.sdk.a.b.w.HTTP_1_1;
                    } else {
                        throw new ProtocolException("Unexpected status line: " + str);
                    }
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
            } else if (str.startsWith("ICY ")) {
                wVar = com.bytedance.sdk.a.b.w.HTTP_1_0;
                i = 4;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int i2 = i + 3;
            if (str.length() >= i2) {
                try {
                    int parseInt = Integer.parseInt(str.substring(i, i2));
                    if (str.length() <= i2) {
                        str2 = "";
                    } else if (str.charAt(i2) == ' ') {
                        str2 = str.substring(i + 4);
                    } else {
                        throw new ProtocolException("Unexpected status line: " + str);
                    }
                    return new m(wVar, parseInt, str2);
                } catch (NumberFormatException unused) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
            }
            throw new ProtocolException("Unexpected status line: " + str);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f65249a == com.bytedance.sdk.a.b.w.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
            sb.append(' ');
            sb.append(this.f65250b);
            if (this.f65251c != null) {
                sb.append(' ');
                sb.append(this.f65251c);
            }
            return sb.toString();
        }
    }

    static {
        byte[] bArr = new byte[0];
        f65217a = bArr;
        f65219c = d.c.c.a.b.d.d(null, bArr);
        f65220d = b0.c(null, f65217a);
        Charset.forName("ISO-8859-1");
        k = Charset.forName(CharEncoding.UTF_16BE);
        l = Charset.forName(CharEncoding.UTF_16LE);
        m = Charset.forName("UTF-32BE");
        n = Charset.forName("UTF-32LE");
        o = TimeZone.getTimeZone("GMT");
        p = new a();
        q = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[CMP_L]}, finally: {[CMP_L, INVOKE, INVOKE, INVOKE, ARITH, INVOKE, IF] complete} */
    public static boolean A(d.c.c.a.a.q qVar, int i2, TimeUnit timeUnit) throws IOException {
        long nanoTime = System.nanoTime();
        long e2 = qVar.a().d() ? qVar.a().e() - nanoTime : Long.MAX_VALUE;
        qVar.a().a(Math.min(e2, timeUnit.toNanos(i2)) + nanoTime);
        try {
            d.c.c.a.a.c cVar = new d.c.c.a.a.c();
            while (qVar.a(cVar, 8192L) != -1) {
                cVar.L();
            }
            if (e2 == Long.MAX_VALUE) {
                qVar.a().g();
            } else {
                qVar.a().a(nanoTime + e2);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (e2 == Long.MAX_VALUE) {
                qVar.a().g();
            } else {
                qVar.a().a(nanoTime + e2);
            }
            return false;
        } catch (Throwable th) {
            if (e2 == Long.MAX_VALUE) {
                qVar.a().g();
            } else {
                qVar.a().a(nanoTime + e2);
            }
            throw th;
        }
    }

    public static boolean B(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static String C(String str, int i2, int i3) {
        int b2 = b(str, i2, i3);
        return str.substring(b2, z(str, b2, i3));
    }

    public static boolean D(String str) {
        return q.matcher(str).matches();
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0079, code lost:
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static InetAddress E(String str, int i2, int i3) {
        int i4;
        byte[] bArr = new byte[16];
        int i5 = 0;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i2 < i3) {
                if (i5 != 16) {
                    int i8 = i2 + 2;
                    if (i8 <= i3 && str.regionMatches(i2, "::", 0, 2)) {
                        if (i6 == -1) {
                            i5 += 2;
                            i6 = i5;
                            if (i8 != i3) {
                                i7 = i8;
                                i2 = i7;
                                int i9 = 0;
                                while (i2 < i3) {
                                }
                                i4 = i2 - i7;
                                if (i4 == 0) {
                                    break;
                                }
                                break;
                            }
                            break;
                        }
                        return null;
                    }
                    if (i5 != 0) {
                        if (str.regionMatches(i2, ":", 0, 1)) {
                            i2++;
                        } else if (!str.regionMatches(i2, ".", 0, 1) || !v(str, i7, i3, bArr, i5 - 2)) {
                            return null;
                        } else {
                            i5 += 2;
                        }
                    }
                    i7 = i2;
                    i2 = i7;
                    int i92 = 0;
                    while (i2 < i3) {
                        int a2 = a(str.charAt(i2));
                        if (a2 == -1) {
                            break;
                        }
                        i92 = (i92 << 4) + a2;
                        i2++;
                    }
                    i4 = i2 - i7;
                    if (i4 == 0 || i4 > 4) {
                        break;
                    }
                    int i10 = i5 + 1;
                    bArr[i5] = (byte) ((i92 >>> 8) & 255);
                    i5 = i10 + 1;
                    bArr[i10] = (byte) (i92 & 255);
                } else {
                    return null;
                }
            } else {
                break;
            }
        }
        if (i5 != 16) {
            if (i6 == -1) {
                return null;
            }
            int i11 = i5 - i6;
            System.arraycopy(bArr, i6, bArr, 16 - i11, i11);
            Arrays.fill(bArr, i6, (16 - i5) + i6, (byte) 0);
        }
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException unused) {
            throw new AssertionError();
        }
    }

    public static boolean F(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static int a(char c2) {
        if (c2 < '0' || c2 > '9') {
            char c3 = 'a';
            if (c2 < 'a' || c2 > 'f') {
                c3 = 'A';
                if (c2 < 'A' || c2 > 'F') {
                    return -1;
                }
            }
            return (c2 - c3) + 10;
        }
        return c2 - '0';
    }

    public static int b(String str, int i2, int i3) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int c(String str, int i2, int i3, char c2) {
        while (i2 < i3) {
            if (str.charAt(i2) == c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int d(String str, int i2, int i3, String str2) {
        while (i2 < i3) {
            if (str2.indexOf(str.charAt(i2)) != -1) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int e(String str, long j2, TimeUnit timeUnit) {
        if (j2 < 0) {
            throw new IllegalArgumentException(str + " < 0");
        } else if (timeUnit != null) {
            long millis = timeUnit.toMillis(j2);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(str + " too large.");
            } else if (millis != 0 || j2 <= 0) {
                return (int) millis;
            } else {
                throw new IllegalArgumentException(str + " too small.");
            }
        } else {
            throw new NullPointerException("unit == null");
        }
    }

    public static int f(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (comparator.compare(strArr[i2], str) == 0) {
                return i2;
            }
        }
        return -1;
    }

    public static AssertionError g(String str, Exception exc) {
        return (AssertionError) new AssertionError(str).initCause(exc);
    }

    public static String h(s sVar, boolean z) {
        String v;
        if (sVar.v().contains(":")) {
            v = "[" + sVar.v() + "]";
        } else {
            v = sVar.v();
        }
        if (z || sVar.w() != s.a(sVar.m())) {
            return v + ":" + sVar.w();
        }
        return v;
    }

    public static String i(String str) {
        InetAddress E;
        if (str.contains(":")) {
            if (str.startsWith("[") && str.endsWith("]")) {
                E = E(str, 1, str.length() - 1);
            } else {
                E = E(str, 0, str.length());
            }
            if (E == null) {
                return null;
            }
            byte[] address = E.getAddress();
            if (address.length == 16) {
                return k(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            if (F(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static String j(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static String k(byte[] bArr) {
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        int i5 = 0;
        while (i4 < bArr.length) {
            int i6 = i4;
            while (i6 < 16 && bArr[i6] == 0 && bArr[i6 + 1] == 0) {
                i6 += 2;
            }
            int i7 = i6 - i4;
            if (i7 > i5 && i7 >= 4) {
                i3 = i4;
                i5 = i7;
            }
            i4 = i6 + 2;
        }
        d.c.c.a.a.c cVar = new d.c.c.a.a.c();
        while (i2 < bArr.length) {
            if (i2 == i3) {
                cVar.w(58);
                i2 += i5;
                if (i2 == 16) {
                    cVar.w(58);
                }
            } else {
                if (i2 > 0) {
                    cVar.w(58);
                }
                cVar.H(((bArr[i2] & 255) << 8) | (bArr[i2 + 1] & 255));
                i2 += 2;
            }
        }
        return cVar.J();
    }

    public static Charset l(d.c.c.a.a.e eVar, Charset charset) throws IOException {
        if (eVar.j(0L, f65221e)) {
            eVar.g(f65221e.g());
            return j;
        } else if (eVar.j(0L, f65222f)) {
            eVar.g(f65222f.g());
            return k;
        } else if (eVar.j(0L, f65223g)) {
            eVar.g(f65223g.g());
            return l;
        } else if (eVar.j(0L, f65224h)) {
            eVar.g(f65224h.g());
            return m;
        } else if (eVar.j(0L, i)) {
            eVar.g(i.g());
            return n;
        } else {
            return charset;
        }
    }

    public static <T> List<T> m(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> n(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static ThreadFactory o(String str, boolean z) {
        return new b(str, z);
    }

    public static void p(long j2, long j3, long j4) {
        if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void q(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static void r(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e2) {
                if (!t(e2)) {
                    throw e2;
                }
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean s(d.c.c.a.a.q qVar, int i2, TimeUnit timeUnit) {
        try {
            return A(qVar, i2, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean t(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static boolean u(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean v(String str, int i2, int i3, byte[] bArr, int i4) {
        int i5 = i4;
        while (i2 < i3) {
            if (i5 == bArr.length) {
                return false;
            }
            if (i5 != i4) {
                if (str.charAt(i2) != '.') {
                    return false;
                }
                i2++;
            }
            int i6 = i2;
            int i7 = 0;
            while (i6 < i3) {
                char charAt = str.charAt(i6);
                if (charAt < '0' || charAt > '9') {
                    break;
                } else if ((i7 == 0 && i2 != i6) || (i7 = ((i7 * 10) + charAt) - 48) > 255) {
                    return false;
                } else {
                    i6++;
                }
            }
            if (i6 - i2 == 0) {
                return false;
            }
            bArr[i5] = (byte) i7;
            i5++;
            i2 = i6;
        }
        return i5 == i4 + 4;
    }

    public static String[] w(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i2]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i2++;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] x(String[] strArr, String str) {
        int length = strArr.length + 1;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length - 1] = str;
        return strArr2;
    }

    public static int y(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127) {
                return i2;
            }
        }
        return -1;
    }

    public static int z(String str, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            char charAt = str.charAt(i4);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i4 + 1;
            }
        }
        return i2;
    }
}
