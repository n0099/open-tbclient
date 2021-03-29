package com.kwad.sdk.glide.load.a;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.data.HttpUrlFetcher;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.HttpException;
import com.kwad.sdk.glide.load.a.d;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
/* loaded from: classes6.dex */
public class j implements d<InputStream> {
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    public static final b f35261a = new a();

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.b.g f35262b;

    /* renamed from: c  reason: collision with root package name */
    public final int f35263c;

    /* renamed from: d  reason: collision with root package name */
    public final b f35264d;

    /* renamed from: e  reason: collision with root package name */
    public HttpURLConnection f35265e;

    /* renamed from: f  reason: collision with root package name */
    public InputStream f35266f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f35267g;

    /* loaded from: classes6.dex */
    public static class a implements b {
        @Override // com.kwad.sdk.glide.load.a.j.b
        public HttpURLConnection a(URL url) {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        HttpURLConnection a(URL url);
    }

    public j(com.kwad.sdk.glide.load.b.g gVar, int i) {
        this(gVar, i, f35261a);
    }

    @VisibleForTesting
    public j(com.kwad.sdk.glide.load.b.g gVar, int i, b bVar) {
        this.f35262b = gVar;
        this.f35263c = i;
        this.f35264d = bVar;
    }

    private InputStream a(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            inputStream = com.kwad.sdk.glide.g.c.a(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable(HttpUrlFetcher.TAG, 3)) {
                Log.d(HttpUrlFetcher.TAG, "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            inputStream = httpURLConnection.getInputStream();
        }
        this.f35266f = inputStream;
        return this.f35266f;
    }

    private InputStream a(URL url, int i, URL url2, Map<String, String> map) {
        if (i < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.f35265e = this.f35264d.a(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f35265e.addRequestProperty(entry.getKey(), entry.getValue());
            }
            this.f35265e.setConnectTimeout(this.f35263c);
            this.f35265e.setReadTimeout(this.f35263c);
            this.f35265e.setUseCaches(false);
            this.f35265e.setDoInput(true);
            this.f35265e.setInstanceFollowRedirects(false);
            this.f35265e.connect();
            this.f35266f = this.f35265e.getInputStream();
            if (this.f35267g) {
                return null;
            }
            int responseCode = this.f35265e.getResponseCode();
            if (a(responseCode)) {
                return a(this.f35265e);
            }
            if (!b(responseCode)) {
                if (responseCode == -1) {
                    throw new HttpException(responseCode);
                }
                throw new HttpException(this.f35265e.getResponseMessage(), responseCode);
            }
            String headerField = this.f35265e.getHeaderField("Location");
            if (TextUtils.isEmpty(headerField)) {
                throw new HttpException("Received empty or null redirect url");
            }
            URL url3 = new URL(url, headerField);
            b();
            return a(url3, i + 1, url, map);
        }
        throw new HttpException("Too many (> 5) redirects!");
    }

    public static boolean a(int i) {
        return i / 100 == 2;
    }

    public static boolean b(int i) {
        return i / 100 == 3;
    }

    @Override // com.kwad.sdk.glide.load.a.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public void a(@NonNull Priority priority, @NonNull d.a<? super InputStream> aVar) {
        StringBuilder sb;
        long a2 = com.kwad.sdk.glide.g.f.a();
        try {
            try {
                aVar.a((d.a<? super InputStream>) a(this.f35262b.a(), 0, null, this.f35262b.b()));
            } catch (IOException e2) {
                if (Log.isLoggable(HttpUrlFetcher.TAG, 3)) {
                    Log.d(HttpUrlFetcher.TAG, "Failed to load data for url", e2);
                }
                aVar.a((Exception) e2);
                if (!Log.isLoggable(HttpUrlFetcher.TAG, 2)) {
                    return;
                }
                sb = new StringBuilder();
            }
            if (Log.isLoggable(HttpUrlFetcher.TAG, 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(com.kwad.sdk.glide.g.f.a(a2));
                Log.v(HttpUrlFetcher.TAG, sb.toString());
            }
        } catch (Throwable th) {
            if (Log.isLoggable(HttpUrlFetcher.TAG, 2)) {
                Log.v(HttpUrlFetcher.TAG, "Finished http url fetcher fetch in " + com.kwad.sdk.glide.g.f.a(a2));
            }
            throw th;
        }
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public void b() {
        InputStream inputStream = this.f35266f;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f35265e;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f35265e = null;
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public void c() {
        this.f35267g = true;
    }

    @Override // com.kwad.sdk.glide.load.a.d
    @NonNull
    public DataSource d() {
        return DataSource.REMOTE;
    }
}
