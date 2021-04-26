package d.a.k0.b.e;

import android.text.TextUtils;
import android.util.Pair;
import com.baidu.turbonet.net.TurbonetEngine;
import com.baidu.turbonet.net.UrlRequest;
import com.baidu.turbonet.net.UrlRequestException;
import com.baidu.turbonet.net.UrlResponseInfo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes5.dex */
public class d extends HttpURLConnection {

    /* renamed from: a  reason: collision with root package name */
    public final TurbonetEngine f63108a;

    /* renamed from: b  reason: collision with root package name */
    public final g f63109b;

    /* renamed from: c  reason: collision with root package name */
    public UrlRequest f63110c;

    /* renamed from: d  reason: collision with root package name */
    public final List<Pair<String, String>> f63111d;

    /* renamed from: e  reason: collision with root package name */
    public e f63112e;

    /* renamed from: f  reason: collision with root package name */
    public f f63113f;

    /* renamed from: g  reason: collision with root package name */
    public UrlResponseInfo f63114g;

    /* renamed from: h  reason: collision with root package name */
    public UrlRequestException f63115h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f63116i;
    public boolean j;
    public List<Map.Entry<String, String>> k;
    public Map<String, List<String>> l;
    public boolean m;
    public boolean n;
    public boolean o;
    public String p;
    public String q;
    public int r;
    public boolean s;
    public boolean t;

    /* loaded from: classes5.dex */
    public class a extends UrlRequest.Callback {
        public a() {
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void a(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.f63114g = urlResponseInfo;
            g(new IOException("stream closed"));
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void b(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, UrlRequestException urlRequestException) {
            if (urlRequestException != null) {
                d.a.k0.a.a.c("cr_CronetHttpURLConn", "****** onFailed, url is: %s, error is: %s", d.this.getURL().toString(), urlRequestException);
                d.this.f63114g = urlResponseInfo;
                d.this.f63115h = urlRequestException;
                g(d.this.f63115h);
                return;
            }
            throw new IllegalStateException("Exception cannot be null in onFailed.");
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void c(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            d.this.f63114g = urlResponseInfo;
            d.this.f63109b.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void d(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            d.this.f63116i = true;
            try {
                URL url = new URL(str);
                boolean equals = url.getProtocol().equals(((HttpURLConnection) d.this).url.getProtocol());
                if (((HttpURLConnection) d.this).instanceFollowRedirects) {
                    ((HttpURLConnection) d.this).url = url;
                }
                if (((HttpURLConnection) d.this).instanceFollowRedirects && (equals || d.this.o)) {
                    d.this.f63110c.d();
                    return;
                }
            } catch (MalformedURLException unused) {
            }
            d.this.f63114g = urlResponseInfo;
            d.this.f63110c.cancel();
            g(null);
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void e(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.this.f63114g = urlResponseInfo;
            d.this.f63109b.quit();
        }

        @Override // com.baidu.turbonet.net.UrlRequest.Callback
        public void f(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            d.a.k0.a.a.h("cr_CronetHttpURLConn", "****** Request Completed, url is %s, status code is %d, total received bytes is %d", urlResponseInfo.h(), Integer.valueOf(urlResponseInfo.c()), Long.valueOf(urlResponseInfo.g()));
            d.this.f63114g = urlResponseInfo;
            g(null);
        }

        public final void g(IOException iOException) {
            if (d.this.f63112e != null) {
                d.this.f63112e.p(iOException);
            }
            if (d.this.f63113f != null) {
                d.this.f63113f.t(iOException);
            }
            d.this.j = true;
            d.this.f63109b.quit();
        }
    }

    public d(URL url, TurbonetEngine turbonetEngine) {
        super(url);
        this.f63116i = false;
        this.j = false;
        this.o = false;
        this.r = 0;
        this.s = false;
        this.t = false;
        this.f63108a = turbonetEngine;
        this.f63109b = new g(getURL().toString());
        this.f63112e = new e(this);
        this.f63111d = new ArrayList();
    }

    public final void A(String str, String str2, boolean z) {
        if (!((HttpURLConnection) this).connected) {
            int q = q(str);
            if (q >= 0) {
                if (z) {
                    this.f63111d.remove(q);
                } else {
                    throw new UnsupportedOperationException("Cannot add multiple headers of the same key, " + str + ". crbug.com/432719.");
                }
            }
            this.f63111d.add(Pair.create(str, str2));
            return;
        }
        throw new IllegalStateException("Cannot modify request property after connection is made.");
    }

    public final void B() throws IOException {
        if (((HttpURLConnection) this).connected) {
            return;
        }
        UrlRequest.Builder builder = new UrlRequest.Builder(getURL().toString(), new a(), this.f63109b, this.f63108a);
        if (((HttpURLConnection) this).doOutput) {
            if (((HttpURLConnection) this).method.equals("GET")) {
                ((HttpURLConnection) this).method = "POST";
            }
            f fVar = this.f63113f;
            if (fVar != null) {
                builder.k(fVar.r(), this.f63109b);
                if (getRequestProperty("Content-Length") == null && !z()) {
                    addRequestProperty("Content-Length", Long.toString(this.f63113f.r().n()));
                }
                this.f63113f.s();
            } else if (getRequestProperty("Content-Length") == null) {
                addRequestProperty("Content-Length", "0");
            }
            if (getRequestProperty("Content-Type") == null) {
                addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            }
        }
        for (Pair<String, String> pair : this.f63111d) {
            builder.a((String) pair.first, (String) pair.second);
        }
        if (!getUseCaches()) {
            builder.c();
        }
        builder.f(((HttpURLConnection) this).method);
        if (this.m) {
            builder.d();
        }
        if (this.n) {
            builder.l();
        }
        if (!TextUtils.isEmpty(this.p)) {
            builder.e(this.p);
        }
        if (!TextUtils.isEmpty(this.q)) {
            builder.g(this.q);
        }
        builder.i(getConnectTimeout());
        builder.h(getReadTimeout());
        builder.j(v());
        ((HttpURLConnection) this).connected = true;
        UrlRequest b2 = builder.b();
        this.f63110c = b2;
        b2.start();
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        A(str, str2, false);
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        getOutputStream();
        B();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (((HttpURLConnection) this).connected) {
            this.f63110c.cancel();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        try {
            w();
            if (this.f63114g.c() >= 400) {
                return this.f63112e;
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        try {
            w();
            Map<String, List<String>> r = r();
            if (r.containsKey(str)) {
                List<String> list = r.get(str);
                return list.get(list.size() - 1);
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i2) {
        Map.Entry<String, String> t = t(i2);
        if (t == null) {
            return null;
        }
        return t.getKey();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        try {
            w();
            return r();
        } catch (IOException unused) {
            return Collections.emptyMap();
        }
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        w();
        if (!((HttpURLConnection) this).instanceFollowRedirects && this.f63116i) {
            throw new IOException("Cannot read response body of a redirect.");
        }
        if (this.f63114g.c() < 400) {
            return this.f63112e;
        }
        throw new FileNotFoundException(((HttpURLConnection) this).url.toString());
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (this.f63113f == null && ((HttpURLConnection) this).doOutput) {
            if (!((HttpURLConnection) this).connected) {
                if (z()) {
                    this.f63113f = new b(this, ((HttpURLConnection) this).chunkLength, this.f63109b, this.s, this.t);
                    B();
                } else {
                    long x = x();
                    if (x != -1) {
                        this.f63113f = new c(this, x, this.f63109b);
                        B();
                    } else {
                        d.a.k0.a.a.a("cr_CronetHttpURLConn", "Outputstream is being buffered in memory.");
                        String requestProperty = getRequestProperty("Content-Length");
                        if (requestProperty == null) {
                            this.f63113f = new d.a.k0.b.e.a(this);
                        } else {
                            try {
                                this.f63113f = new d.a.k0.b.e.a(this, Long.parseLong(requestProperty));
                            } catch (NumberFormatException unused) {
                                d.a.k0.a.a.c("cr_CronetHttpURLConn", "CONTENT_LENGTH has wrong format.", new Object[0]);
                                this.f63113f = new d.a.k0.b.e.a(this);
                            }
                        }
                    }
                }
            } else {
                throw new ProtocolException("Cannot write to OutputStream after receiving response.");
            }
        }
        return this.f63113f;
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        if (!((HttpURLConnection) this).connected) {
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (Pair<String, String> pair : this.f63111d) {
                if (!treeMap.containsKey(pair.first)) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(pair.second);
                    treeMap.put(pair.first, Collections.unmodifiableList(arrayList));
                } else {
                    throw new IllegalStateException("Should not have multiple values.");
                }
            }
            return Collections.unmodifiableMap(treeMap);
        }
        throw new IllegalStateException("Cannot access request headers after connection is set.");
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        int q = q(str);
        if (q >= 0) {
            return (String) this.f63111d.get(q).second;
        }
        return null;
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        w();
        return this.f63114g.c();
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        w();
        return this.f63114g.d();
    }

    public final void o() throws IOException {
        if (this.j) {
            UrlRequestException urlRequestException = this.f63115h;
            if (urlRequestException == null) {
                if (this.f63114g == null) {
                    throw new NullPointerException("Response info is null when there is no exception.");
                }
                return;
            }
            throw urlRequestException;
        }
        throw new IllegalStateException("No response.");
    }

    public void p() {
        this.o = true;
    }

    public final int q(String str) {
        for (int i2 = 0; i2 < this.f63111d.size(); i2++) {
            if (((String) this.f63111d.get(i2).first).equalsIgnoreCase(str)) {
                return i2;
            }
        }
        return -1;
    }

    public final Map<String, List<String>> r() {
        Map<String, List<String>> map = this.l;
        if (map != null) {
            return map;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, String> entry : s()) {
            ArrayList arrayList = new ArrayList();
            if (treeMap.containsKey(entry.getKey())) {
                arrayList.addAll((Collection) treeMap.get(entry.getKey()));
            }
            arrayList.add(entry.getValue());
            treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
        }
        Map<String, List<String>> unmodifiableMap = Collections.unmodifiableMap(treeMap);
        this.l = unmodifiableMap;
        return unmodifiableMap;
    }

    public final List<Map.Entry<String, String>> s() {
        List<Map.Entry<String, String>> list = this.k;
        if (list != null) {
            return list;
        }
        this.k = new ArrayList();
        for (Map.Entry<String, String> entry : this.f63114g.b()) {
            if (!entry.getKey().equalsIgnoreCase("Content-Encoding")) {
                this.k.add(new AbstractMap.SimpleImmutableEntry(entry));
            }
        }
        List<Map.Entry<String, String>> unmodifiableList = Collections.unmodifiableList(this.k);
        this.k = unmodifiableList;
        return unmodifiableList;
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        A(str, str2, true);
    }

    public final Map.Entry<String, String> t(int i2) {
        try {
            w();
            List<Map.Entry<String, String>> s = s();
            if (i2 >= s.size()) {
                return null;
            }
            return s.get(i2);
        } catch (IOException unused) {
            return null;
        }
    }

    public void u(ByteBuffer byteBuffer) throws IOException {
        this.f63110c.read(byteBuffer);
        this.f63109b.b(getReadTimeout());
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    public int v() {
        return this.r;
    }

    public final void w() throws IOException {
        f fVar = this.f63113f;
        if (fVar != null) {
            fVar.q();
            if (z()) {
                this.f63113f.close();
            }
        }
        if (!this.j) {
            B();
            this.f63109b.b(getReadTimeout());
            this.j = true;
        }
        o();
    }

    public final long x() {
        long j = ((HttpURLConnection) this).fixedContentLength;
        try {
            long j2 = getClass().getField("fixedContentLengthLong").getLong(this);
            return j2 != -1 ? j2 : j;
        } catch (Exception unused) {
            return j;
        }
    }

    public UrlResponseInfo y() {
        return this.f63114g;
    }

    public final boolean z() {
        return ((HttpURLConnection) this).chunkLength > 0;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i2) {
        Map.Entry<String, String> t = t(i2);
        if (t == null) {
            return null;
        }
        return t.getValue();
    }
}
