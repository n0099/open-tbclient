package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
/* loaded from: classes3.dex */
public class h implements m {
    public final com.kwad.sdk.core.videocache.c.b a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.a.b f56335b;

    /* renamed from: c  reason: collision with root package name */
    public n f56336c;

    /* renamed from: d  reason: collision with root package name */
    public HttpURLConnection f56337d;

    /* renamed from: e  reason: collision with root package name */
    public InputStream f56338e;

    public h(h hVar) {
        this.f56336c = hVar.f56336c;
        this.a = hVar.a;
        this.f56335b = hVar.f56335b;
    }

    public h(String str, com.kwad.sdk.core.videocache.c.b bVar, com.kwad.sdk.core.videocache.a.b bVar2) {
        this.a = (com.kwad.sdk.core.videocache.c.b) j.a(bVar);
        this.f56335b = (com.kwad.sdk.core.videocache.a.b) j.a(bVar2);
        n a = bVar.a(str);
        this.f56336c = a == null ? new n(str, -2147483648L, l.a(str)) : a;
    }

    private long a(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    private long a(HttpURLConnection httpURLConnection, long j2, int i2) {
        long a = a(httpURLConnection);
        return i2 == 200 ? a : i2 == 206 ? a + j2 : this.f56336c.f56352b;
    }

    private HttpURLConnection a(long j2, int i2) {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z;
        String str2 = this.f56336c.a;
        int i3 = 0;
        do {
            StringBuilder sb = new StringBuilder();
            sb.append("Open connection ");
            int i4 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i4 > 0) {
                str = " with offset " + j2;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" to ");
            sb.append(str2);
            com.kwad.sdk.core.d.a.a("HttpUrlSource", sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            com.kwad.sdk.core.network.m.a(httpURLConnection);
            a(httpURLConnection, str2);
            if (i4 > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j2 + "-");
            }
            if (i2 > 0) {
                httpURLConnection.setConnectTimeout(i2);
                httpURLConnection.setReadTimeout(i2);
            }
            httpURLConnection.setRequestProperty("User-Agent", com.kwad.sdk.core.network.k.c());
            httpURLConnection.setRequestProperty("BrowserUa", com.kwad.sdk.core.network.k.d());
            httpURLConnection.setRequestProperty("SystemUa", com.kwad.sdk.core.network.k.a());
            int responseCode = httpURLConnection.getResponseCode();
            z = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z) {
                str2 = httpURLConnection.getHeaderField("Location");
                i3++;
                httpURLConnection.disconnect();
            }
            if (i3 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i3);
            }
        } while (z);
        return httpURLConnection;
    }

    private void a(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.f56335b.a(str).entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void e() {
        HttpURLConnection httpURLConnection;
        com.kwad.sdk.core.d.a.a("HttpUrlSource", "Read content info from " + this.f56336c.a);
        InputStream inputStream = null;
        try {
            httpURLConnection = a(0L, 10000);
            try {
                try {
                    long a = a(httpURLConnection);
                    String contentType = httpURLConnection.getContentType();
                    inputStream = httpURLConnection.getInputStream();
                    n nVar = new n(this.f56336c.a, a, contentType);
                    this.f56336c = nVar;
                    this.a.a(nVar.a, nVar);
                    com.kwad.sdk.core.d.a.a("HttpUrlSource", "Source info fetched: " + this.f56336c);
                    l.a(inputStream);
                    if (httpURLConnection == null) {
                        return;
                    }
                } catch (IOException unused) {
                    com.kwad.sdk.core.d.a.e("HttpUrlSource", "Error fetching info from " + this.f56336c.a);
                    l.a(inputStream);
                    if (httpURLConnection == null) {
                        return;
                    }
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th) {
                th = th;
                l.a(inputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (IOException unused2) {
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
            l.a(inputStream);
            if (httpURLConnection != null) {
            }
            throw th;
        }
        httpURLConnection.disconnect();
    }

    @Override // com.kwad.sdk.core.videocache.m
    public int a(byte[] bArr) {
        InputStream inputStream = this.f56338e;
        if (inputStream == null) {
            throw new ProxyCacheException("Error reading data from " + this.f56336c.a + ": connection is absent!");
        }
        try {
            return inputStream.read(bArr, 0, bArr.length);
        } catch (InterruptedIOException e2) {
            throw new InterruptedProxyCacheException("Reading source " + this.f56336c.a + " is interrupted", e2);
        } catch (IOException e3) {
            throw new ProxyCacheException("Error reading data from " + this.f56336c.a, e3);
        }
    }

    @Override // com.kwad.sdk.core.videocache.m
    public synchronized long a() {
        if (this.f56336c.f56352b == -2147483648L) {
            e();
        }
        return this.f56336c.f56352b;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public void a(long j2) {
        try {
            HttpURLConnection a = a(j2, -1);
            this.f56337d = a;
            String contentType = a.getContentType();
            this.f56338e = new BufferedInputStream(this.f56337d.getInputStream(), 8192);
            n nVar = new n(this.f56336c.a, a(this.f56337d, j2, this.f56337d.getResponseCode()), contentType);
            this.f56336c = nVar;
            this.a.a(nVar.a, nVar);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error opening connection for " + this.f56336c.a + " with offset " + j2, e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.m
    public void b() {
        HttpURLConnection httpURLConnection = this.f56337d;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException unused) {
                com.kwad.sdk.core.d.a.e("HttpUrlSource", "Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue.");
            } catch (IllegalArgumentException e2) {
                e = e2;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (NullPointerException e3) {
                e = e3;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            }
        }
    }

    public synchronized String c() {
        if (TextUtils.isEmpty(this.f56336c.f56353c)) {
            e();
        }
        return this.f56336c.f56353c;
    }

    public String d() {
        return this.f56336c.a;
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.f56336c + "}";
    }
}
