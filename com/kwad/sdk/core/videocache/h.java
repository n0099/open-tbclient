package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.network.q;
import com.kwad.sdk.utils.am;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
/* loaded from: classes7.dex */
public final class h implements l {
    public m aeG;
    public HttpURLConnection aeH;
    public InputStream aeI;
    public final com.kwad.sdk.core.videocache.c.b aek;
    public final com.kwad.sdk.core.videocache.a.b ael;

    public h(h hVar) {
        this.aeG = hVar.aeG;
        this.aek = hVar.aek;
        this.ael = hVar.ael;
    }

    public h(String str, com.kwad.sdk.core.videocache.c.b bVar, com.kwad.sdk.core.videocache.a.b bVar2) {
        this.aek = (com.kwad.sdk.core.videocache.c.b) am.checkNotNull(bVar);
        this.ael = (com.kwad.sdk.core.videocache.a.b) am.checkNotNull(bVar2);
        m cJ = bVar.cJ(str);
        this.aeG = cJ == null ? new m(str, -2147483648L, k.cH(str)) : cJ;
    }

    private long a(HttpURLConnection httpURLConnection, long j, int i) {
        long b = b(httpURLConnection);
        return i == 200 ? b : i == 206 ? b + j : this.aeG.aeV;
    }

    private void a(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry entry : this.ael.vZ().entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
    }

    public static long b(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    private HttpURLConnection b(long j, int i) {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z;
        String str2 = this.aeG.url;
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
            com.kwad.sdk.core.e.b.d("HttpUrlSource", sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            q.wrapHttpURLConnection(httpURLConnection);
            a(httpURLConnection, str2);
            if (i3 > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j + "-");
            }
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
            }
            httpURLConnection.setRequestProperty("User-Agent", o.getUserAgent());
            httpURLConnection.setRequestProperty("BrowserUa", o.tD());
            httpURLConnection.setRequestProperty("SystemUa", o.tC());
            int responseCode = httpURLConnection.getResponseCode();
            z = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z) {
                str2 = httpURLConnection.getHeaderField("Location");
                i2++;
                httpURLConnection.disconnect();
            }
            if (i2 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i2);
            }
        } while (z);
        return httpURLConnection;
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
    private void vR() {
        HttpURLConnection httpURLConnection;
        com.kwad.sdk.core.e.b.d("HttpUrlSource", "Read content info from " + this.aeG.url);
        ?? r0 = 10000;
        InputStream inputStream = null;
        try {
            try {
                httpURLConnection = b(0L, 10000);
                try {
                    long b = b(httpURLConnection);
                    String contentType = httpURLConnection.getContentType();
                    inputStream = httpURLConnection.getInputStream();
                    m mVar = new m(this.aeG.url, b, contentType);
                    this.aeG = mVar;
                    this.aek.a(mVar.url, mVar);
                    com.kwad.sdk.core.e.b.d("HttpUrlSource", "Source info fetched: " + this.aeG);
                    r0 = httpURLConnection;
                } catch (IOException unused) {
                    com.kwad.sdk.core.e.b.e("HttpUrlSource", "Error fetching info from " + this.aeG.url);
                    r0 = httpURLConnection;
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                    com.kwad.sdk.crash.utils.b.a(r0);
                }
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                com.kwad.sdk.crash.utils.b.a(r0);
                throw th;
            }
        } catch (IOException unused2) {
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            r0 = 0;
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            com.kwad.sdk.crash.utils.b.a(r0);
            throw th;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
        com.kwad.sdk.crash.utils.b.a(r0);
    }

    @Override // com.kwad.sdk.core.videocache.l
    public final void I(long j) {
        try {
            HttpURLConnection b = b(j, -1);
            this.aeH = b;
            String contentType = b.getContentType();
            this.aeI = new BufferedInputStream(this.aeH.getInputStream(), 8192);
            m mVar = new m(this.aeG.url, a(this.aeH, j, this.aeH.getResponseCode()), contentType);
            this.aeG = mVar;
            this.aek.a(mVar.url, mVar);
        } catch (IOException e) {
            throw new ProxyCacheException("Error opening connection for " + this.aeG.url + " with offset " + j, e);
        }
    }

    @Override // com.kwad.sdk.core.videocache.l
    public final void close() {
        HttpURLConnection httpURLConnection = this.aeH;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException unused) {
                com.kwad.sdk.core.e.b.e("HttpUrlSource", "Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue.");
            } catch (IllegalArgumentException e) {
                e = e;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (NullPointerException e2) {
                e = e2;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            }
        }
    }

    @Override // com.kwad.sdk.core.videocache.l
    public final synchronized long length() {
        if (this.aeG.aeV == -2147483648L) {
            vR();
        }
        return this.aeG.aeV;
    }

    @Override // com.kwad.sdk.core.videocache.l
    public final int read(byte[] bArr) {
        InputStream inputStream = this.aeI;
        if (inputStream == null) {
            throw new ProxyCacheException("Error reading data from " + this.aeG.url + ": connection is absent!");
        }
        try {
            return inputStream.read(bArr, 0, 8192);
        } catch (InterruptedIOException e) {
            throw new InterruptedProxyCacheException("Reading source " + this.aeG.url + " is interrupted", e);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error reading data from " + this.aeG.url, e2);
        }
    }

    public final String toString() {
        return "HttpUrlSource{sourceInfo='" + this.aeG + "}";
    }

    public final synchronized String vS() {
        if (TextUtils.isEmpty(this.aeG.aeW)) {
            vR();
        }
        return this.aeG.aeW;
    }
}
