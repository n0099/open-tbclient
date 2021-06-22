package d.b.c.b.d;

import android.text.TextUtils;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.err.VAdError;
import d.b.c.a.b.a.e;
import d.b.c.a.b.a0;
import d.b.c.a.b.b0;
import d.b.c.a.b.v;
import d.b.c.a.b.x;
import d.b.c.a.b.y;
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
/* loaded from: classes6.dex */
public class l implements d.b.c.b.f.a {

    /* renamed from: a  reason: collision with root package name */
    public final y f69633a;

    /* loaded from: classes6.dex */
    public static class a extends FilterInputStream {

        /* renamed from: e  reason: collision with root package name */
        public final d.b.c.a.b.d f69634e;

        public a(d.b.c.a.b.d dVar) {
            super(l.g(dVar));
            this.f69634e = dVar;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            try {
                this.f69634e.close();
            } catch (Throwable unused) {
            }
        }
    }

    public l() {
        y.b bVar = new y.b();
        bVar.a(10000L, TimeUnit.MILLISECONDS);
        bVar.d(10000L, TimeUnit.MILLISECONDS);
        bVar.f(10000L, TimeUnit.MILLISECONDS);
        this.f69633a = bVar.c();
    }

    public static List<d.b.c.b.d.a> c(v vVar) {
        if (vVar == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(vVar.a());
        int a2 = vVar.a();
        for (int i2 = 0; i2 < a2; i2++) {
            String b2 = vVar.b(i2);
            String e2 = vVar.e(i2);
            if (b2 != null) {
                arrayList.add(new d.b.c.b.d.a(b2, e2));
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

    public static boolean f(int i2, int i3) {
        return (i2 == 4 || (100 <= i3 && i3 < 200) || i3 == 204 || i3 == 304) ? false : true;
    }

    public static InputStream g(d.b.c.a.b.d dVar) {
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

    @Override // d.b.c.b.f.a
    public b a(Request<?> request, Map<String, String> map) throws IOException, VAdError {
        int timeoutMs = request.getTimeoutMs();
        y.b B = this.f69633a.B();
        long j = timeoutMs;
        B.a(j, TimeUnit.MILLISECONDS);
        B.d(j, TimeUnit.MILLISECONDS);
        B.f(j, TimeUnit.MILLISECONDS);
        boolean z = true;
        B.e(true);
        B.b(true);
        y c2 = B.c();
        a0.a i2 = i(request);
        if (i2 != null) {
            e(request);
            if (!TextUtils.isEmpty(request.getUserAgent())) {
                String userAgent = request.getUserAgent();
                i2.k("User-Agent");
                i2.l("User-Agent", userAgent);
            }
            Map<String, String> headers = request.getHeaders();
            if (headers != null) {
                for (String str : headers.keySet()) {
                    i2.l(str, headers.get(str));
                }
            }
            if (map != null) {
                for (String str2 : map.keySet()) {
                    i2.g(str2, map.get(str2));
                }
            }
            d(i2, request);
            d.b.c.a.b.c a2 = c2.c(i2.p()).a();
            e.m a3 = e.m.a(a2);
            d.b.c.a.b.d x = a2.x();
            try {
                int i3 = a3.f69124b;
                if (i3 != -1) {
                    if (!f(request.getMethod(), i3)) {
                        b bVar = new b(i3, c(a2.w()));
                        x.close();
                        return bVar;
                    }
                    try {
                        return new b(i3, c(a2.w()), (int) x.o(), new a(x));
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
        p pVar = d.b.c.b.a.f69478b;
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
