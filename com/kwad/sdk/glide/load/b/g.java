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
    public final h f35595b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final URL f35596c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final String f35597d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public String f35598e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public URL f35599f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public volatile byte[] f35600g;

    /* renamed from: h  reason: collision with root package name */
    public int f35601h;

    public g(String str) {
        this(str, h.f35603b);
    }

    public g(String str, h hVar) {
        this.f35596c = null;
        this.f35597d = com.kwad.sdk.glide.g.j.a(str);
        this.f35595b = (h) com.kwad.sdk.glide.g.j.a(hVar);
    }

    public g(URL url) {
        this(url, h.f35603b);
    }

    public g(URL url, h hVar) {
        this.f35596c = (URL) com.kwad.sdk.glide.g.j.a(url);
        this.f35597d = null;
        this.f35595b = (h) com.kwad.sdk.glide.g.j.a(hVar);
    }

    private URL d() {
        if (this.f35599f == null) {
            this.f35599f = new URL(e());
        }
        return this.f35599f;
    }

    private String e() {
        if (TextUtils.isEmpty(this.f35598e)) {
            String str = this.f35597d;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) com.kwad.sdk.glide.g.j.a(this.f35596c)).toString();
            }
            this.f35598e = Uri.encode(str, GlideUrl.ALLOWED_URI_CHARS);
        }
        return this.f35598e;
    }

    private byte[] f() {
        if (this.f35600g == null) {
            this.f35600g = c().getBytes(com.kwad.sdk.glide.load.c.f35666a);
        }
        return this.f35600g;
    }

    public URL a() {
        return d();
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f());
    }

    public Map<String, String> b() {
        return this.f35595b.a();
    }

    public String c() {
        String str = this.f35597d;
        return str != null ? str : ((URL) com.kwad.sdk.glide.g.j.a(this.f35596c)).toString();
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            return c().equals(gVar.c()) && this.f35595b.equals(gVar.f35595b);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        if (this.f35601h == 0) {
            int hashCode = c().hashCode();
            this.f35601h = hashCode;
            this.f35601h = (hashCode * 31) + this.f35595b.hashCode();
        }
        return this.f35601h;
    }

    public String toString() {
        return c();
    }
}
