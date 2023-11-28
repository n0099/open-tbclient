package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.kwad.sdk.utils.ap;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes10.dex */
public final class j extends p {
    public final com.kwad.sdk.core.videocache.d.c aAG;
    public final com.kwad.sdk.core.videocache.b.b aAH;
    public n aBe;
    public InputStream aBg;
    public OkHttpClient aBl = new OkHttpClient();

    public j(j jVar) {
        this.aBe = jVar.aBe;
        this.aAG = jVar.aAG;
        this.aAH = jVar.aAH;
    }

    public static long c(Response response) {
        String header = response.header("Content-Length");
        if (header == null) {
            return -1L;
        }
        return Long.parseLong(header);
    }

    public j(String str, com.kwad.sdk.core.videocache.d.c cVar, com.kwad.sdk.core.videocache.b.b bVar) {
        this.aAG = (com.kwad.sdk.core.videocache.d.c) ap.checkNotNull(cVar);
        this.aAH = (com.kwad.sdk.core.videocache.b.b) ap.checkNotNull(bVar);
        n eo = cVar.eo(str);
        this.aBe = eo == null ? new n(str, -2147483648L, l.em(str)) : eo;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, IF, INVOKE] complete} */
    private void Fo() {
        Response response = null;
        try {
            try {
                response = cX(10000);
            } catch (IOException unused) {
                com.kwad.sdk.core.e.c.e("HttpUrlSource", "Error fetching info from " + this.aBe.url);
                if (0 == 0 || response.body() == null) {
                    return;
                }
            }
            if (response != null && response.isSuccessful()) {
                n nVar = new n(this.aBe.url, c(response), response.header("Content-Type"));
                this.aBe = nVar;
                this.aAG.a(nVar.url, nVar);
                com.kwad.sdk.core.e.c.d("HttpUrlSource", "Source info fetched: " + this.aBe);
                if (response == null || response.body() == null) {
                    return;
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(response.body());
                return;
            }
            throw new ProxyCacheException("Fail to fetchContentInfo: " + getUrl());
        } catch (Throwable th) {
            if (0 != 0 && response.body() != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly(response.body());
            }
            throw th;
        }
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
        com.kwad.sdk.crash.utils.b.closeQuietly(this.aBg);
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

    private long a(Response response, long j) {
        int code = response.code();
        long contentLength = response.body().contentLength();
        if (code == 200) {
            return contentLength;
        }
        if (code == 206) {
            return contentLength + j;
        }
        return this.aBe.aBu;
    }

    private Response cX(int i) {
        Response execute;
        OkHttpClient.Builder newBuilder = new OkHttpClient().newBuilder();
        newBuilder.connectTimeout(10000L, TimeUnit.MILLISECONDS);
        newBuilder.readTimeout(10000L, TimeUnit.MILLISECONDS);
        newBuilder.writeTimeout(10000L, TimeUnit.MILLISECONDS);
        int i2 = 0;
        newBuilder.connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
        try {
            newBuilder.dns(new com.kwad.sdk.core.network.a.d());
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
        this.aBl = newBuilder.build();
        String url = getUrl();
        boolean z = false;
        do {
            Request.Builder builder = new Request.Builder();
            builder.head();
            builder.url(url);
            execute = this.aBl.newCall(builder.build()).execute();
            if (execute.isRedirect()) {
                url = execute.header("Location");
                z = execute.isRedirect();
                i2++;
            }
            if (i2 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i2);
            }
        } while (z);
        return execute;
    }

    private Response d(long j, int i) {
        Response execute;
        OkHttpClient.Builder newBuilder = this.aBl.newBuilder();
        int i2 = 0;
        newBuilder.connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
        try {
            newBuilder.dns(new com.kwad.sdk.core.network.a.d());
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
        this.aBl = newBuilder.build();
        String url = getUrl();
        boolean z = false;
        do {
            Request.Builder builder = new Request.Builder();
            builder.get();
            builder.url(url);
            if (j > 0) {
                builder.addHeader("Range", "bytes=" + j + "-");
            }
            execute = this.aBl.newCall(builder.build()).execute();
            if (execute.isRedirect()) {
                url = execute.header("Location");
                z = execute.isRedirect();
                i2++;
            }
            if (i2 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i2);
            }
        } while (z);
        return execute;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void al(long j) {
        try {
            Response d = d(j, -1);
            String mediaType = d.body().contentType().toString();
            long a = a(d, j);
            this.aBg = new BufferedInputStream(d.body().byteStream(), 1024);
            n nVar = new n(this.aBe.url, a, mediaType);
            this.aBe = nVar;
            this.aAG.a(nVar.url, nVar);
        } catch (IOException e) {
            throw new ProxyCacheException("Error opening connection for " + getUrl() + " with offset " + j, e);
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
