package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.kwad.sdk.core.network.r;
import com.kwad.sdk.utils.ap;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
/* loaded from: classes10.dex */
public final class h extends p {
    public final com.kwad.sdk.core.videocache.d.c aAG;
    public final com.kwad.sdk.core.videocache.b.b aAH;
    public n aBe;
    public HttpURLConnection aBf;
    public InputStream aBg;

    public h(h hVar) {
        this.aBe = hVar.aBe;
        this.aAG = hVar.aAG;
        this.aAH = hVar.aAH;
    }

    public static long d(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    public h(String str, com.kwad.sdk.core.videocache.d.c cVar, com.kwad.sdk.core.videocache.b.b bVar) {
        this.aAG = (com.kwad.sdk.core.videocache.d.c) ap.checkNotNull(cVar);
        this.aAH = (com.kwad.sdk.core.videocache.b.b) ap.checkNotNull(bVar);
        n eo = cVar.eo(str);
        this.aBe = eo == null ? new n(str, -2147483648L, l.em(str)) : eo;
    }

    private long a(HttpURLConnection httpURLConnection, long j, int i) {
        long d = d(httpURLConnection);
        if (i == 200) {
            return d;
        }
        if (i == 206) {
            return d + j;
        }
        return this.aBe.aBu;
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
    private void Fo() {
        HttpURLConnection httpURLConnection;
        com.kwad.sdk.core.e.c.d("HttpUrlSource", "Read content info from " + this.aBe.url);
        ?? r0 = 10000;
        InputStream inputStream = null;
        try {
            try {
                httpURLConnection = c(0L, 10000);
                try {
                    long d = d(httpURLConnection);
                    String contentType = httpURLConnection.getContentType();
                    inputStream = httpURLConnection.getInputStream();
                    n nVar = new n(this.aBe.url, d, contentType);
                    this.aBe = nVar;
                    this.aAG.a(nVar.url, nVar);
                    com.kwad.sdk.core.e.c.d("HttpUrlSource", "Source info fetched: " + this.aBe);
                    r0 = httpURLConnection;
                } catch (IOException unused) {
                    com.kwad.sdk.core.e.c.e("HttpUrlSource", "Error fetching info from " + this.aBe.url);
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

    private void Fq() {
        n eo;
        com.kwad.sdk.core.videocache.d.c cVar = this.aAG;
        if (cVar != null && (cVar instanceof com.kwad.sdk.core.videocache.d.b) && (eo = cVar.eo(getUrl())) != null && !TextUtils.isEmpty(eo.aBv) && eo.aBu != -2147483648L) {
            this.aBe = eo;
        }
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final synchronized String Fp() {
        if (TextUtils.isEmpty(this.aBe.aBv)) {
            Fq();
        }
        if (TextUtils.isEmpty(this.aBe.aBv)) {
            Fo();
        }
        return this.aBe.aBv;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void close() {
        HttpURLConnection httpURLConnection = this.aBf;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException unused) {
                com.kwad.sdk.core.e.c.e("HttpUrlSource", "Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue.");
            } catch (IllegalArgumentException e) {
                e = e;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (NullPointerException e2) {
                e = e2;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            }
        }
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final String getUrl() {
        return this.aBe.url;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final synchronized long length() {
        if (this.aBe.aBu == -2147483648L) {
            Fq();
        }
        if (this.aBe.aBu == -2147483648L) {
            Fo();
        }
        return this.aBe.aBu;
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final String toString() {
        return "HttpUrlSource{sourceInfo='" + this.aBe + "}";
    }

    private void a(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.aAH.Fx().entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private HttpURLConnection c(long j, int i) {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z;
        String str2 = this.aBe.url;
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
            com.kwad.sdk.core.e.c.d("HttpUrlSource", sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            r.wrapHttpURLConnection(httpURLConnection);
            a(httpURLConnection, str2);
            if (i3 > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j + "-");
            }
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
            }
            com.kwad.sdk.core.network.p.b(httpURLConnection);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 301 && responseCode != 302 && responseCode != 303) {
                z = false;
            } else {
                z = true;
            }
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

    @Override // com.kwad.sdk.core.videocache.m
    public final void al(long j) {
        try {
            HttpURLConnection c = c(j, -1);
            this.aBf = c;
            String contentType = c.getContentType();
            this.aBg = new BufferedInputStream(this.aBf.getInputStream(), 1024);
            n nVar = new n(this.aBe.url, a(this.aBf, j, this.aBf.getResponseCode()), contentType);
            this.aBe = nVar;
            this.aAG.a(nVar.url, nVar);
        } catch (IOException e) {
            throw new ProxyCacheException("Error opening connection for " + this.aBe.url + " with offset " + j, e);
        }
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final int read(byte[] bArr) {
        InputStream inputStream = this.aBg;
        if (inputStream != null) {
            try {
                return inputStream.read(bArr, 0, 1024);
            } catch (InterruptedIOException e) {
                throw new InterruptedProxyCacheException("Reading source " + this.aBe.url + " is interrupted", e);
            } catch (IOException e2) {
                throw new ProxyCacheException("Error reading data from " + this.aBe.url, e2);
            }
        }
        throw new ProxyCacheException("Error reading data from " + this.aBe.url + ": connection is absent!");
    }
}
