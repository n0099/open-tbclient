package com.ksad.download;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.kwai.filedownloader.f.c;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
/* loaded from: classes6.dex */
public class h implements com.kwai.filedownloader.a.b {

    /* renamed from: a  reason: collision with root package name */
    public final OkHttpClient f31786a;

    /* renamed from: b  reason: collision with root package name */
    public final Request.Builder f31787b;

    /* renamed from: c  reason: collision with root package name */
    public Request f31788c;

    /* renamed from: d  reason: collision with root package name */
    public Response f31789d;

    /* loaded from: classes6.dex */
    public static class a implements c.b {

        /* renamed from: a  reason: collision with root package name */
        public OkHttpClient f31790a;

        /* renamed from: b  reason: collision with root package name */
        public OkHttpClient.Builder f31791b;

        public a() {
        }

        public a(boolean z) {
            this.f31791b = z ? h.j() : h.i();
        }

        @Override // com.kwai.filedownloader.f.c.b
        public com.kwai.filedownloader.a.b a(String str) {
            if (this.f31790a == null) {
                synchronized (a.class) {
                    if (this.f31790a == null) {
                        this.f31790a = this.f31791b != null ? this.f31791b.build() : new OkHttpClient();
                        this.f31791b = null;
                    }
                }
            }
            return new h(str, this.f31790a);
        }
    }

    public h(String str, OkHttpClient okHttpClient) {
        this(new Request.Builder().url(str), okHttpClient);
    }

    public h(Request.Builder builder, OkHttpClient okHttpClient) {
        this.f31787b = builder;
        this.f31786a = okHttpClient;
    }

    private String b(String str) {
        String a2 = a("Content-Type");
        String b2 = com.ksad.download.d.a.b(str);
        String str2 = ".apk";
        if (TextUtils.isEmpty(a2) || !TextUtils.isEmpty(b2)) {
            if (TextUtils.isEmpty(str)) {
                return System.currentTimeMillis() + ".apk";
            }
            return str;
        }
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(a2);
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        if (!TextUtils.isEmpty(extensionFromMimeType)) {
            str2 = "." + extensionFromMimeType;
        }
        sb.append(str2);
        return sb.toString();
    }

    public static OkHttpClient.Builder i() {
        return new OkHttpClient.Builder().connectTimeout(10000L, TimeUnit.MILLISECONDS).addInterceptor(new com.ksad.download.b.a()).readTimeout(0L, TimeUnit.MILLISECONDS).connectionPool(new ConnectionPool(6, 60000L, TimeUnit.MILLISECONDS)).retryOnConnectionFailure(true);
    }

    public static OkHttpClient.Builder j() {
        return new OkHttpClient.Builder().connectTimeout(10000L, TimeUnit.MILLISECONDS).addInterceptor(new com.ksad.download.b.a()).protocols(Util.immutableList(Protocol.HTTP_1_1)).readTimeout(0L, TimeUnit.MILLISECONDS).connectionPool(new ConnectionPool(6, 60000L, TimeUnit.MILLISECONDS)).retryOnConnectionFailure(true);
    }

    @Override // com.kwai.filedownloader.a.b
    public InputStream a() {
        Response response = this.f31789d;
        if (response != null) {
            return com.kwad.sdk.core.h.b.a().b(response.body().byteStream());
        }
        throw new IllegalStateException("Please invoke #execute first!");
    }

    @Override // com.kwai.filedownloader.a.b
    public String a(String str) {
        String str2;
        if (!"Content-Disposition".equals(str)) {
            Response response = this.f31789d;
            if (response == null) {
                return null;
            }
            return response.header(str);
        }
        try {
        } catch (Exception unused) {
            str2 = "";
        }
        if (TextUtils.isEmpty(com.kwai.filedownloader.f.f.g(this.f31789d.header(str)))) {
            List<String> pathSegments = this.f31789d.request().url().pathSegments();
            str2 = pathSegments.get(pathSegments.size() - 1);
            return "attachment; filename=\"" + b(str2) + "\"";
        }
        return this.f31789d.header(str);
    }

    @Override // com.kwai.filedownloader.a.b
    public void a(String str, String str2) {
        this.f31787b.addHeader(str, str2);
    }

    @Override // com.kwai.filedownloader.a.b
    public boolean a(String str, long j) {
        return false;
    }

    @Override // com.kwai.filedownloader.a.b
    public Map<String, List<String>> b() {
        if (this.f31788c == null) {
            this.f31788c = this.f31787b.build();
        }
        return this.f31788c.headers().toMultimap();
    }

    @Override // com.kwai.filedownloader.a.b
    public Map<String, List<String>> c() {
        Response response = this.f31789d;
        if (response == null) {
            return null;
        }
        return response.headers().toMultimap();
    }

    @Override // com.kwai.filedownloader.a.b
    public void d() {
        if (this.f31788c == null) {
            this.f31788c = this.f31787b.build();
        }
        this.f31789d = this.f31786a.newCall(this.f31788c).execute();
    }

    @Override // com.kwai.filedownloader.a.b
    public int e() {
        Response response = this.f31789d;
        if (response != null) {
            return response.code();
        }
        throw new IllegalStateException("Please invoke #execute first!");
    }

    @Override // com.kwai.filedownloader.a.b
    public void f() {
        this.f31788c = null;
        Response response = this.f31789d;
        if (response != null && response.body() != null) {
            this.f31789d.body().close();
        }
        this.f31789d = null;
    }
}
