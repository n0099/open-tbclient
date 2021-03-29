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
    public final h f35306b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final URL f35307c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final String f35308d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public String f35309e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public URL f35310f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public volatile byte[] f35311g;

    /* renamed from: h  reason: collision with root package name */
    public int f35312h;

    public g(String str) {
        this(str, h.f35314b);
    }

    public g(String str, h hVar) {
        this.f35307c = null;
        this.f35308d = com.kwad.sdk.glide.g.j.a(str);
        this.f35306b = (h) com.kwad.sdk.glide.g.j.a(hVar);
    }

    public g(URL url) {
        this(url, h.f35314b);
    }

    public g(URL url, h hVar) {
        this.f35307c = (URL) com.kwad.sdk.glide.g.j.a(url);
        this.f35308d = null;
        this.f35306b = (h) com.kwad.sdk.glide.g.j.a(hVar);
    }

    private URL d() {
        if (this.f35310f == null) {
            this.f35310f = new URL(e());
        }
        return this.f35310f;
    }

    private String e() {
        if (TextUtils.isEmpty(this.f35309e)) {
            String str = this.f35308d;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) com.kwad.sdk.glide.g.j.a(this.f35307c)).toString();
            }
            this.f35309e = Uri.encode(str, GlideUrl.ALLOWED_URI_CHARS);
        }
        return this.f35309e;
    }

    private byte[] f() {
        if (this.f35311g == null) {
            this.f35311g = c().getBytes(com.kwad.sdk.glide.load.c.f35377a);
        }
        return this.f35311g;
    }

    public URL a() {
        return d();
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f());
    }

    public Map<String, String> b() {
        return this.f35306b.a();
    }

    public String c() {
        String str = this.f35308d;
        return str != null ? str : ((URL) com.kwad.sdk.glide.g.j.a(this.f35307c)).toString();
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            return c().equals(gVar.c()) && this.f35306b.equals(gVar.f35306b);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        if (this.f35312h == 0) {
            int hashCode = c().hashCode();
            this.f35312h = hashCode;
            this.f35312h = (hashCode * 31) + this.f35306b.hashCode();
        }
        return this.f35312h;
    }

    public String toString() {
        return c();
    }
}
