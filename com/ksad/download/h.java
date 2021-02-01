package com.ksad.download;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.kwad.sdk.collector.AppStatusRules;
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
/* loaded from: classes3.dex */
public class h implements com.kwai.filedownloader.a.b {

    /* renamed from: a  reason: collision with root package name */
    private final OkHttpClient f7921a;

    /* renamed from: b  reason: collision with root package name */
    private final Request.Builder f7922b;
    private Request c;
    private Response d;

    /* loaded from: classes3.dex */
    public static class a implements c.b {

        /* renamed from: a  reason: collision with root package name */
        private OkHttpClient f7923a;

        /* renamed from: b  reason: collision with root package name */
        private OkHttpClient.Builder f7924b;

        public a() {
        }

        public a(boolean z) {
            if (z) {
                this.f7924b = h.j();
            } else {
                this.f7924b = h.i();
            }
        }

        @Override // com.kwai.filedownloader.f.c.b
        public com.kwai.filedownloader.a.b a(String str) {
            if (this.f7923a == null) {
                synchronized (a.class) {
                    if (this.f7923a == null) {
                        this.f7923a = this.f7924b != null ? this.f7924b.build() : new OkHttpClient();
                        this.f7924b = null;
                    }
                }
            }
            return new h(str, this.f7923a);
        }
    }

    private h(String str, OkHttpClient okHttpClient) {
        this(new Request.Builder().url(str), okHttpClient);
    }

    private h(Request.Builder builder, OkHttpClient okHttpClient) {
        this.f7922b = builder;
        this.f7921a = okHttpClient;
    }

    private String b(String str) {
        String a2 = a("Content-Type");
        String b2 = com.ksad.download.d.a.b(str);
        if (TextUtils.isEmpty(a2) || !TextUtils.isEmpty(b2)) {
            return TextUtils.isEmpty(str) ? System.currentTimeMillis() + ".apk" : str;
        }
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(a2);
        return System.currentTimeMillis() + (TextUtils.isEmpty(extensionFromMimeType) ? ".apk" : "." + extensionFromMimeType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static OkHttpClient.Builder i() {
        return new OkHttpClient.Builder().connectTimeout(10000L, TimeUnit.MILLISECONDS).addInterceptor(new com.ksad.download.b.a()).readTimeout(0L, TimeUnit.MILLISECONDS).connectionPool(new ConnectionPool(6, AppStatusRules.DEFAULT_GRANULARITY, TimeUnit.MILLISECONDS)).retryOnConnectionFailure(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static OkHttpClient.Builder j() {
        return new OkHttpClient.Builder().connectTimeout(10000L, TimeUnit.MILLISECONDS).addInterceptor(new com.ksad.download.b.a()).protocols(Util.immutableList(Protocol.HTTP_1_1)).readTimeout(0L, TimeUnit.MILLISECONDS).connectionPool(new ConnectionPool(6, AppStatusRules.DEFAULT_GRANULARITY, TimeUnit.MILLISECONDS)).retryOnConnectionFailure(true);
    }

    @Override // com.kwai.filedownloader.a.b
    public InputStream a() {
        if (this.d == null) {
            throw new IllegalStateException("Please invoke #execute first!");
        }
        return com.kwad.sdk.core.h.b.a().b(this.d.body().byteStream());
    }

    @Override // com.kwai.filedownloader.a.b
    public String a(String str) {
        String str2;
        if (!"Content-Disposition".equals(str)) {
            if (this.d == null) {
                return null;
            }
            return this.d.header(str);
        }
        try {
        } catch (Exception e) {
            str2 = "";
        }
        if (TextUtils.isEmpty(com.kwai.filedownloader.f.f.g(this.d.header(str)))) {
            List<String> pathSegments = this.d.request().url().pathSegments();
            str2 = pathSegments.get(pathSegments.size() - 1);
            return "attachment; filename=\"" + b(str2) + "\"";
        }
        return this.d.header(str);
    }

    @Override // com.kwai.filedownloader.a.b
    public void a(String str, String str2) {
        this.f7922b.addHeader(str, str2);
    }

    @Override // com.kwai.filedownloader.a.b
    public boolean a(String str, long j) {
        return false;
    }

    @Override // com.kwai.filedownloader.a.b
    public Map<String, List<String>> b() {
        if (this.c == null) {
            this.c = this.f7922b.build();
        }
        return this.c.headers().toMultimap();
    }

    @Override // com.kwai.filedownloader.a.b
    public Map<String, List<String>> c() {
        if (this.d == null) {
            return null;
        }
        return this.d.headers().toMultimap();
    }

    @Override // com.kwai.filedownloader.a.b
    public void d() {
        if (this.c == null) {
            this.c = this.f7922b.build();
        }
        this.d = this.f7921a.newCall(this.c).execute();
    }

    @Override // com.kwai.filedownloader.a.b
    public int e() {
        if (this.d == null) {
            throw new IllegalStateException("Please invoke #execute first!");
        }
        return this.d.code();
    }

    @Override // com.kwai.filedownloader.a.b
    public void f() {
        this.c = null;
        if (this.d != null && this.d.body() != null) {
            this.d.body().close();
        }
        this.d = null;
    }
}
