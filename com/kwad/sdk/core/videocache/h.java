package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.baidubce.http.Headers;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.utils.aj;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
/* loaded from: classes5.dex */
public final class h implements l {
    public final com.kwad.sdk.core.videocache.c.b a;
    public final com.kwad.sdk.core.videocache.a.b b;
    public m c;
    public HttpURLConnection d;
    public InputStream e;

    public h(h hVar) {
        this.c = hVar.c;
        this.a = hVar.a;
        this.b = hVar.b;
    }

    public h(String str, com.kwad.sdk.core.videocache.c.b bVar, com.kwad.sdk.core.videocache.a.b bVar2) {
        this.a = (com.kwad.sdk.core.videocache.c.b) aj.a(bVar);
        this.b = (com.kwad.sdk.core.videocache.a.b) aj.a(bVar2);
        m a = bVar.a(str);
        this.c = a == null ? new m(str, -2147483648L, k.a(str)) : a;
    }

    public static long a(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    private long a(HttpURLConnection httpURLConnection, long j, int i) {
        long a = a(httpURLConnection);
        return i == 200 ? a : i == 206 ? a + j : this.c.b;
    }

    private HttpURLConnection a(long j, int i) {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z;
        String str2 = this.c.a;
        int i2 = 0;
        do {
            StringBuilder sb = new StringBuilder("Open connection ");
            int i3 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i3 > 0) {
                str = " with offset " + j;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" to ");
            sb.append(str2);
            com.kwad.sdk.core.d.b.a("HttpUrlSource", sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            p.a(httpURLConnection);
            a(httpURLConnection, str2);
            if (i3 > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j + "-");
            }
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
            }
            httpURLConnection.setRequestProperty("User-Agent", com.kwad.sdk.core.network.n.c());
            httpURLConnection.setRequestProperty("BrowserUa", com.kwad.sdk.core.network.n.d());
            httpURLConnection.setRequestProperty("SystemUa", com.kwad.sdk.core.network.n.a());
            int responseCode = httpURLConnection.getResponseCode();
            z = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z) {
                str2 = httpURLConnection.getHeaderField(Headers.LOCATION);
                i2++;
                httpURLConnection.disconnect();
            }
            if (i2 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i2);
            }
        } while (z);
        return httpURLConnection;
    }

    private void a(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.b.a().entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x005e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x001c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:7:0x0058 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.net.URLConnection] */
    private void d() {
        HttpURLConnection httpURLConnection;
        com.kwad.sdk.core.d.b.a("HttpUrlSource", "Read content info from " + this.c.a);
        ?? r0 = 10000;
        InputStream inputStream = null;
        try {
            try {
                httpURLConnection = a(0L, 10000);
                try {
                    long a = a(httpURLConnection);
                    String contentType = httpURLConnection.getContentType();
                    inputStream = httpURLConnection.getInputStream();
                    m mVar = new m(this.c.a, a, contentType);
                    this.c = mVar;
                    this.a.a(mVar.a, mVar);
                    com.kwad.sdk.core.d.b.a("HttpUrlSource", "Source info fetched: " + this.c);
                    r0 = httpURLConnection;
                } catch (IOException unused) {
                    com.kwad.sdk.core.d.b.e("HttpUrlSource", "Error fetching info from " + this.c.a);
                    r0 = httpURLConnection;
                    com.kwad.sdk.crash.utils.b.a(inputStream);
                    com.kwad.sdk.crash.utils.b.a((URLConnection) r0);
                }
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.a(inputStream);
                com.kwad.sdk.crash.utils.b.a((URLConnection) r0);
                throw th;
            }
        } catch (IOException unused2) {
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            r0 = 0;
            com.kwad.sdk.crash.utils.b.a(inputStream);
            com.kwad.sdk.crash.utils.b.a((URLConnection) r0);
            throw th;
        }
        com.kwad.sdk.crash.utils.b.a(inputStream);
        com.kwad.sdk.crash.utils.b.a((URLConnection) r0);
    }

    @Override // com.kwad.sdk.core.videocache.l
    public final int a(byte[] bArr) {
        InputStream inputStream = this.e;
        if (inputStream == null) {
            throw new ProxyCacheException("Error reading data from " + this.c.a + ": connection is absent!");
        }
        try {
            return inputStream.read(bArr, 0, 8192);
        } catch (InterruptedIOException e) {
            throw new InterruptedProxyCacheException("Reading source " + this.c.a + " is interrupted", e);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error reading data from " + this.c.a, e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.l
    public final synchronized long a() {
        if (this.c.b == -2147483648L) {
            d();
        }
        return this.c.b;
    }

    @Override // com.kwad.sdk.core.videocache.l
    public final void a(long j) {
        try {
            HttpURLConnection a = a(j, -1);
            this.d = a;
            String contentType = a.getContentType();
            this.e = new BufferedInputStream(this.d.getInputStream(), 8192);
            m mVar = new m(this.c.a, a(this.d, j, this.d.getResponseCode()), contentType);
            this.c = mVar;
            this.a.a(mVar.a, mVar);
        } catch (IOException e) {
            throw new ProxyCacheException("Error opening connection for " + this.c.a + " with offset " + j, e);
        }
    }

    @Override // com.kwad.sdk.core.videocache.l
    public final void b() {
        HttpURLConnection httpURLConnection = this.d;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException unused) {
                com.kwad.sdk.core.d.b.e("HttpUrlSource", "Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue.");
            } catch (IllegalArgumentException e) {
                e = e;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (NullPointerException e2) {
                e = e2;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            }
        }
    }

    public final synchronized String c() {
        if (TextUtils.isEmpty(this.c.c)) {
            d();
        }
        return this.c.c;
    }

    public final String toString() {
        return "HttpUrlSource{sourceInfo='" + this.c + "}";
    }
}
