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
    public final h f35305b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final URL f35306c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final String f35307d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public String f35308e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public URL f35309f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public volatile byte[] f35310g;

    /* renamed from: h  reason: collision with root package name */
    public int f35311h;

    public g(String str) {
        this(str, h.f35313b);
    }

    public g(String str, h hVar) {
        this.f35306c = null;
        this.f35307d = com.kwad.sdk.glide.g.j.a(str);
        this.f35305b = (h) com.kwad.sdk.glide.g.j.a(hVar);
    }

    public g(URL url) {
        this(url, h.f35313b);
    }

    public g(URL url, h hVar) {
        this.f35306c = (URL) com.kwad.sdk.glide.g.j.a(url);
        this.f35307d = null;
        this.f35305b = (h) com.kwad.sdk.glide.g.j.a(hVar);
    }

    private URL d() {
        if (this.f35309f == null) {
            this.f35309f = new URL(e());
        }
        return this.f35309f;
    }

    private String e() {
        if (TextUtils.isEmpty(this.f35308e)) {
            String str = this.f35307d;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) com.kwad.sdk.glide.g.j.a(this.f35306c)).toString();
            }
            this.f35308e = Uri.encode(str, GlideUrl.ALLOWED_URI_CHARS);
        }
        return this.f35308e;
    }

    private byte[] f() {
        if (this.f35310g == null) {
            this.f35310g = c().getBytes(com.kwad.sdk.glide.load.c.f35376a);
        }
        return this.f35310g;
    }

    public URL a() {
        return d();
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f());
    }

    public Map<String, String> b() {
        return this.f35305b.a();
    }

    public String c() {
        String str = this.f35307d;
        return str != null ? str : ((URL) com.kwad.sdk.glide.g.j.a(this.f35306c)).toString();
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            return c().equals(gVar.c()) && this.f35305b.equals(gVar.f35305b);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        if (this.f35311h == 0) {
            int hashCode = c().hashCode();
            this.f35311h = hashCode;
            this.f35311h = (hashCode * 31) + this.f35305b.hashCode();
        }
        return this.f35311h;
    }

    public String toString() {
        return c();
    }
}
