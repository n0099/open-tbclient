package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.baidubce.http.Headers;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
/* loaded from: classes5.dex */
public class h implements m {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwad.sdk.core.videocache.d.b f9798a;

    /* renamed from: b  reason: collision with root package name */
    private final com.kwad.sdk.core.videocache.b.b f9799b;
    private n c;
    private HttpURLConnection d;
    private InputStream e;

    public h(h hVar) {
        this.c = hVar.c;
        this.f9798a = hVar.f9798a;
        this.f9799b = hVar.f9799b;
    }

    public h(String str, com.kwad.sdk.core.videocache.d.b bVar, com.kwad.sdk.core.videocache.b.b bVar2) {
        this.f9798a = (com.kwad.sdk.core.videocache.d.b) j.a(bVar);
        this.f9799b = (com.kwad.sdk.core.videocache.b.b) j.a(bVar2);
        n a2 = bVar.a(str);
        this.c = a2 == null ? new n(str, -2147483648L, l.a(str)) : a2;
    }

    private long a(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    private long a(HttpURLConnection httpURLConnection, long j, int i) {
        long a2 = a(httpURLConnection);
        return i == 200 ? a2 : i == 206 ? a2 + j : this.c.f9806b;
    }

    private HttpURLConnection a(long j, int i) {
        HttpURLConnection httpURLConnection;
        boolean z;
        String str = this.c.f9805a;
        int i2 = 0;
        do {
            com.kwad.sdk.core.d.a.a("HttpUrlSource", "Open connection " + (j > 0 ? " with offset " + j : "") + " to " + str);
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            a(httpURLConnection, str);
            if (j > 0) {
                httpURLConnection.setRequestProperty(Headers.RANGE, "bytes=" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            }
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
            }
            httpURLConnection.setRequestProperty("User-Agent", com.kwad.sdk.core.network.k.a());
            int responseCode = httpURLConnection.getResponseCode();
            z = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z) {
                str = httpURLConnection.getHeaderField(Headers.LOCATION);
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
        for (Map.Entry<String, String> entry : this.f9799b.a(str).entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x00b0 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.net.HttpURLConnection] */
    private void e() {
        Throwable th;
        Closeable closeable;
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        com.kwad.sdk.core.d.a.a("HttpUrlSource", "Read content info from " + this.c.f9805a);
        ?? r2 = 0;
        try {
            try {
                httpURLConnection = a(0L, 10000);
            } catch (Throwable th2) {
                th = th2;
                closeable = 10000;
            }
            try {
                long a2 = a(httpURLConnection);
                String contentType = httpURLConnection.getContentType();
                inputStream = httpURLConnection.getInputStream();
                try {
                    this.c = new n(this.c.f9805a, a2, contentType);
                    this.f9798a.a(this.c.f9805a, this.c);
                    com.kwad.sdk.core.d.a.a("HttpUrlSource", "Source info fetched: " + this.c);
                    l.a(inputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (IOException e) {
                    com.kwad.sdk.core.d.a.d("HttpUrlSource", "Error fetching info from " + this.c.f9805a);
                    l.a(inputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            } catch (IOException e2) {
                inputStream = null;
            } catch (Throwable th3) {
                th = th3;
                closeable = null;
                r2 = httpURLConnection;
                l.a(closeable);
                if (r2 != 0) {
                    r2.disconnect();
                }
                throw th;
            }
        } catch (IOException e3) {
            inputStream = null;
            httpURLConnection = null;
        } catch (Throwable th4) {
            th = th4;
            closeable = null;
            r2 = 0;
        }
    }

    @Override // com.kwad.sdk.core.videocache.m
    public int a(byte[] bArr) {
        if (this.e == null) {
            throw new ProxyCacheException("Error reading data from " + this.c.f9805a + ": connection is absent!");
        }
        try {
            return this.e.read(bArr, 0, bArr.length);
        } catch (InterruptedIOException e) {
            throw new InterruptedProxyCacheException("Reading source " + this.c.f9805a + " is interrupted", e);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error reading data from " + this.c.f9805a, e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.m
    public synchronized long a() {
        if (this.c.f9806b == -2147483648L) {
            e();
        }
        return this.c.f9806b;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public void a(long j) {
        try {
            this.d = a(j, -1);
            String contentType = this.d.getContentType();
            this.e = new BufferedInputStream(this.d.getInputStream(), 8192);
            this.c = new n(this.c.f9805a, a(this.d, j, this.d.getResponseCode()), contentType);
            this.f9798a.a(this.c.f9805a, this.c);
        } catch (IOException e) {
            throw new ProxyCacheException("Error opening connection for " + this.c.f9805a + " with offset " + j, e);
        }
    }

    @Override // com.kwad.sdk.core.videocache.m
    public void b() {
        if (this.d != null) {
            try {
                this.d.disconnect();
            } catch (ArrayIndexOutOfBoundsException e) {
                com.kwad.sdk.core.d.a.d("HttpUrlSource", "Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue.");
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
        if (TextUtils.isEmpty(this.c.c)) {
            e();
        }
        return this.c.c;
    }

    public String d() {
        return this.c.f9805a;
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.c + "}";
    }
}
