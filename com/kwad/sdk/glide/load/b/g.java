package com.kwad.sdk.glide.load.b;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.model.GlideUrl;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;
/* loaded from: classes6.dex */
public class g implements com.kwad.sdk.glide.load.c {

    /* renamed from: b  reason: collision with root package name */
    public final h f35690b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final URL f35691c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final String f35692d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public String f35693e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public URL f35694f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public volatile byte[] f35695g;

    /* renamed from: h  reason: collision with root package name */
    public int f35696h;

    public g(String str) {
        this(str, h.f35698b);
    }

    public g(String str, h hVar) {
        this.f35691c = null;
        this.f35692d = com.kwad.sdk.glide.g.j.a(str);
        this.f35690b = (h) com.kwad.sdk.glide.g.j.a(hVar);
    }

    public g(URL url) {
        this(url, h.f35698b);
    }

    public g(URL url, h hVar) {
        this.f35691c = (URL) com.kwad.sdk.glide.g.j.a(url);
        this.f35692d = null;
        this.f35690b = (h) com.kwad.sdk.glide.g.j.a(hVar);
    }

    private URL d() {
        if (this.f35694f == null) {
            this.f35694f = new URL(e());
        }
        return this.f35694f;
    }

    private String e() {
        if (TextUtils.isEmpty(this.f35693e)) {
            String str = this.f35692d;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) com.kwad.sdk.glide.g.j.a(this.f35691c)).toString();
            }
            this.f35693e = Uri.encode(str, GlideUrl.ALLOWED_URI_CHARS);
        }
        return this.f35693e;
    }

    private byte[] f() {
        if (this.f35695g == null) {
            this.f35695g = c().getBytes(com.kwad.sdk.glide.load.c.f35761a);
        }
        return this.f35695g;
    }

    public URL a() {
        return d();
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f());
    }

    public Map<String, String> b() {
        return this.f35690b.a();
    }

    public String c() {
        String str = this.f35692d;
        return str != null ? str : ((URL) com.kwad.sdk.glide.g.j.a(this.f35691c)).toString();
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            return c().equals(gVar.c()) && this.f35690b.equals(gVar.f35690b);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        if (this.f35696h == 0) {
            int hashCode = c().hashCode();
            this.f35696h = hashCode;
            this.f35696h = (hashCode * 31) + this.f35690b.hashCode();
        }
        return this.f35696h;
    }

    public String toString() {
        return c();
    }
}
