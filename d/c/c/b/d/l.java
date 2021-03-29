package d.c.c.b.d;

import android.text.TextUtils;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.err.VAdError;
import d.c.c.a.b.a.e;
import d.c.c.a.b.a0;
import d.c.c.a.b.b0;
import d.c.c.a.b.v;
import d.c.c.a.b.x;
import d.c.c.a.b.y;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpTrace;
/* loaded from: classes5.dex */
public class l implements d.c.c.b.f.a {

    /* renamed from: a  reason: collision with root package name */
    public final y f65729a;

    /* loaded from: classes5.dex */
    public static class a extends FilterInputStream {

        /* renamed from: e  reason: collision with root package name */
        public final d.c.c.a.b.d f65730e;

        public a(d.c.c.a.b.d dVar) {
            super(l.g(dVar));
            this.f65730e = dVar;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            try {
                this.f65730e.close();
            } catch (Throwable unused) {
            }
        }
    }

    public l() {
        y.b bVar = new y.b();
        bVar.a(10000L, TimeUnit.MILLISECONDS);
        bVar.d(10000L, TimeUnit.MILLISECONDS);
        bVar.f(10000L, TimeUnit.MILLISECONDS);
        this.f65729a = bVar.c();
    }

    public static List<d.c.c.b.d.a> c(v vVar) {
        if (vVar == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(vVar.a());
        int a2 = vVar.a();
        for (int i = 0; i < a2; i++) {
            String b2 = vVar.b(i);
            String e2 = vVar.e(i);
            if (b2 != null) {
                arrayList.add(new d.c.c.b.d.a(b2, e2));
            }
        }
        return arrayList;
    }

    public static void d(a0.a aVar, Request<?> request) throws IOException, com.bytedance.sdk.adnet.err.a {
        switch (request.getMethod()) {
            case -1:
                byte[] postBody = request.getPostBody();
                if (postBody != null) {
                    aVar.d(b0.c(x.a(request.getBodyContentType()), postBody));
                    return;
                }
                return;
            case 0:
                aVar.a();
                return;
            case 1:
                aVar.d(j(request));
                return;
            case 2:
                aVar.n(j(request));
                return;
            case 3:
                aVar.m();
                return;
            case 4:
                aVar.i();
                return;
            case 5:
                aVar.f(HttpOptions.METHOD_NAME, null);
                return;
            case 6:
                aVar.f(HttpTrace.METHOD_NAME, null);
                return;
            case 7:
                aVar.o(j(request));
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    public static boolean f(int i, int i2) {
        return (i == 4 || (100 <= i2 && i2 < 200) || i2 == 204 || i2 == 304) ? false : true;
    }

    public static InputStream g(d.c.c.a.b.d dVar) {
        if (dVar == null) {
            return null;
        }
        return dVar.q();
    }

    public static b0 j(Request request) throws com.bytedance.sdk.adnet.err.a {
        byte[] body = request.getBody();
        if (body == null) {
            if (request.getMethod() != 1) {
                return null;
            }
            body = "".getBytes();
        }
        return b0.c(x.a(request.getBodyContentType()), body);
    }

    @Override // d.c.c.b.f.a
    public b a(Request<?> request, Map<String, String> map) throws IOException, VAdError {
        int timeoutMs = request.getTimeoutMs();
        y.b B = this.f65729a.B();
        long j = timeoutMs;
        B.a(j, TimeUnit.MILLISECONDS);
        B.d(j, TimeUnit.MILLISECONDS);
        B.f(j, TimeUnit.MILLISECONDS);
        boolean z = true;
        B.e(true);
        B.b(true);
        y c2 = B.c();
        a0.a i = i(request);
        if (i != null) {
            e(request);
            if (!TextUtils.isEmpty(request.getUserAgent())) {
                String userAgent = request.getUserAgent();
                i.k("User-Agent");
                i.l("User-Agent", userAgent);
            }
            Map<String, String> headers = request.getHeaders();
            if (headers != null) {
                for (String str : headers.keySet()) {
                    i.l(str, headers.get(str));
                }
            }
            if (map != null) {
                for (String str2 : map.keySet()) {
                    i.g(str2, map.get(str2));
                }
            }
            d(i, request);
            d.c.c.a.b.c a2 = c2.c(i.p()).a();
            e.m a3 = e.m.a(a2);
            d.c.c.a.b.d x = a2.x();
            try {
                int i2 = a3.f65251b;
                if (i2 != -1) {
                    if (!f(request.getMethod(), i2)) {
                        b bVar = new b(i2, c(a2.w()));
                        x.close();
                        return bVar;
                    }
                    try {
                        return new b(i2, c(a2.w()), (int) x.o(), new a(x));
                    } catch (Throwable th) {
                        th = th;
                        if (!z) {
                            x.close();
                        }
                        throw th;
                    }
                }
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            } catch (Throwable th2) {
                th = th2;
                z = false;
            }
        } else {
            throw new IllegalArgumentException("request params maybe null");
        }
    }

    public final void e(Request<?> request) {
        if (request != null) {
            request.setIpAddrStr(h(request));
        }
    }

    public final String h(Request<?> request) {
        if (request != null) {
            if (request.getUrl() != null) {
                try {
                } catch (Exception unused) {
                    return "";
                }
            }
            return InetAddress.getByName(new URL(request.getUrl()).getHost()).getHostAddress();
        }
        return "";
    }

    public final a0.a i(Request request) throws IOException {
        if (request == null || request.getUrl() == null) {
            return null;
        }
        a0.a aVar = new a0.a();
        URL url = new URL(request.getUrl());
        String host = url.getHost();
        p pVar = d.c.c.b.a.f65580b;
        String a2 = pVar != null ? pVar.a(host) : null;
        boolean z = false;
        if (!TextUtils.isEmpty(a2)) {
            try {
                aVar.h(new URL(url.toString().replaceFirst(host, a2)));
                aVar.l("Host", host);
                z = true;
            } catch (Exception unused) {
            }
        }
        if (!z) {
            aVar.h(url);
        }
        return aVar;
    }
}
