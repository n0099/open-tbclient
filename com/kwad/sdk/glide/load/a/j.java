package com.kwad.sdk.glide.load.a;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.baidubce.http.Headers;
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
/* loaded from: classes5.dex */
public class j implements d<InputStream> {
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    static final b f10349a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final com.kwad.sdk.glide.load.b.g f10350b;
    private final int c;
    private final b d;
    private HttpURLConnection e;
    private InputStream f;
    private volatile boolean g;

    /* loaded from: classes5.dex */
    private static class a implements b {
        a() {
        }

        @Override // com.kwad.sdk.glide.load.a.j.b
        public HttpURLConnection a(URL url) {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface b {
        HttpURLConnection a(URL url);
    }

    public j(com.kwad.sdk.glide.load.b.g gVar, int i) {
        this(gVar, i, f10349a);
    }

    @VisibleForTesting
    j(com.kwad.sdk.glide.load.b.g gVar, int i, b bVar) {
        this.f10350b = gVar;
        this.c = i;
        this.d = bVar;
    }

    private InputStream a(HttpURLConnection httpURLConnection) {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f = com.kwad.sdk.glide.g.c.a(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.f = httpURLConnection.getInputStream();
        }
        return this.f;
    }

    private InputStream a(URL url, int i, URL url2, Map<String, String> map) {
        if (i >= 5) {
            throw new HttpException("Too many (> 5) redirects!");
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new HttpException("In re-direct loop");
                }
            } catch (URISyntaxException e) {
            }
        }
        this.e = this.d.a(url);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.e.addRequestProperty(entry.getKey(), entry.getValue());
        }
        this.e.setConnectTimeout(this.c);
        this.e.setReadTimeout(this.c);
        this.e.setUseCaches(false);
        this.e.setDoInput(true);
        this.e.setInstanceFollowRedirects(false);
        this.e.connect();
        this.f = this.e.getInputStream();
        if (this.g) {
            return null;
        }
        int responseCode = this.e.getResponseCode();
        if (a(responseCode)) {
            return a(this.e);
        }
        if (!b(responseCode)) {
            if (responseCode == -1) {
                throw new HttpException(responseCode);
            }
            throw new HttpException(this.e.getResponseMessage(), responseCode);
        }
        String headerField = this.e.getHeaderField(Headers.LOCATION);
        if (TextUtils.isEmpty(headerField)) {
            throw new HttpException("Received empty or null redirect url");
        }
        URL url3 = new URL(url, headerField);
        b();
        return a(url3, i + 1, url, map);
    }

    private static boolean a(int i) {
        return i / 100 == 2;
    }

    private static boolean b(int i) {
        return i / 100 == 3;
    }

    @Override // com.kwad.sdk.glide.load.a.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[CONST_STR, INVOKE]}, finally: {[CONST_STR, INVOKE, CONST_STR, CONSTRUCTOR, CONST_STR, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, IF] complete} */
    @Override // com.kwad.sdk.glide.load.a.d
    public void a(@NonNull Priority priority, @NonNull d.a<? super InputStream> aVar) {
        long a2 = com.kwad.sdk.glide.g.f.a();
        try {
            try {
                aVar.a((d.a<? super InputStream>) a(this.f10350b.a(), 0, null, this.f10350b.b()));
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + com.kwad.sdk.glide.g.f.a(a2));
                }
            } catch (IOException e) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e);
                }
                aVar.a((Exception) e);
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + com.kwad.sdk.glide.g.f.a(a2));
                }
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + com.kwad.sdk.glide.g.f.a(a2));
            }
            throw th;
        }
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public void b() {
        if (this.f != null) {
            try {
                this.f.close();
            } catch (IOException e) {
            }
        }
        if (this.e != null) {
            this.e.disconnect();
        }
        this.e = null;
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public void c() {
        this.g = true;
    }

    @Override // com.kwad.sdk.glide.load.a.d
    @NonNull
    public DataSource d() {
        return DataSource.REMOTE;
    }
}
