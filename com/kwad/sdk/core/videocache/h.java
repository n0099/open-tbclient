package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
/* loaded from: classes6.dex */
public class h implements m {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.d.b f34586a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.b.b f34587b;

    /* renamed from: c  reason: collision with root package name */
    public n f34588c;

    /* renamed from: d  reason: collision with root package name */
    public HttpURLConnection f34589d;

    /* renamed from: e  reason: collision with root package name */
    public InputStream f34590e;

    public h(h hVar) {
        this.f34588c = hVar.f34588c;
        this.f34586a = hVar.f34586a;
        this.f34587b = hVar.f34587b;
    }

    public h(String str, com.kwad.sdk.core.videocache.d.b bVar, com.kwad.sdk.core.videocache.b.b bVar2) {
        this.f34586a = (com.kwad.sdk.core.videocache.d.b) j.a(bVar);
        this.f34587b = (com.kwad.sdk.core.videocache.b.b) j.a(bVar2);
        n a2 = bVar.a(str);
        this.f34588c = a2 == null ? new n(str, -2147483648L, l.a(str)) : a2;
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
        return i == 200 ? a2 : i == 206 ? a2 + j : this.f34588c.f34605b;
    }

    private HttpURLConnection a(long j, int i) {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z;
        String str2 = this.f34588c.f34604a;
        int i2 = 0;
        do {
            StringBuilder sb = new StringBuilder();
            sb.append("Open connection ");
            int i3 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i3 > 0) {
                str = " with offset " + j;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" to ");
            sb.append(str2);
            com.kwad.sdk.core.d.a.a("HttpUrlSource", sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            a(httpURLConnection, str2);
            if (i3 > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j + "-");
            }
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
            }
            httpURLConnection.setRequestProperty("User-Agent", com.kwad.sdk.core.network.k.a());
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

    private void a(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.f34587b.a(str).entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void e() {
        HttpURLConnection httpURLConnection;
        com.kwad.sdk.core.d.a.a("HttpUrlSource", "Read content info from " + this.f34588c.f34604a);
        InputStream inputStream = null;
        try {
            httpURLConnection = a(0L, 10000);
            try {
                try {
                    long a2 = a(httpURLConnection);
                    String contentType = httpURLConnection.getContentType();
                    inputStream = httpURLConnection.getInputStream();
                    n nVar = new n(this.f34588c.f34604a, a2, contentType);
                    this.f34588c = nVar;
                    this.f34586a.a(nVar.f34604a, nVar);
                    com.kwad.sdk.core.d.a.a("HttpUrlSource", "Source info fetched: " + this.f34588c);
                    l.a(inputStream);
                    if (httpURLConnection == null) {
                        return;
                    }
                } catch (IOException unused) {
                    com.kwad.sdk.core.d.a.d("HttpUrlSource", "Error fetching info from " + this.f34588c.f34604a);
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
        InputStream inputStream = this.f34590e;
        if (inputStream == null) {
            throw new ProxyCacheException("Error reading data from " + this.f34588c.f34604a + ": connection is absent!");
        }
        try {
            return inputStream.read(bArr, 0, bArr.length);
        } catch (InterruptedIOException e2) {
            throw new InterruptedProxyCacheException("Reading source " + this.f34588c.f34604a + " is interrupted", e2);
        } catch (IOException e3) {
            throw new ProxyCacheException("Error reading data from " + this.f34588c.f34604a, e3);
        }
    }

    @Override // com.kwad.sdk.core.videocache.m
    public synchronized long a() {
        if (this.f34588c.f34605b == -2147483648L) {
            e();
        }
        return this.f34588c.f34605b;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public void a(long j) {
        try {
            HttpURLConnection a2 = a(j, -1);
            this.f34589d = a2;
            String contentType = a2.getContentType();
            this.f34590e = new BufferedInputStream(this.f34589d.getInputStream(), 8192);
            n nVar = new n(this.f34588c.f34604a, a(this.f34589d, j, this.f34589d.getResponseCode()), contentType);
            this.f34588c = nVar;
            this.f34586a.a(nVar.f34604a, nVar);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error opening connection for " + this.f34588c.f34604a + " with offset " + j, e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.m
    public void b() {
        HttpURLConnection httpURLConnection = this.f34589d;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException unused) {
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
        if (TextUtils.isEmpty(this.f34588c.f34606c)) {
            e();
        }
        return this.f34588c.f34606c;
    }

    public String d() {
        return this.f34588c.f34604a;
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.f34588c + "}";
    }
}
