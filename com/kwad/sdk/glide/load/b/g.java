package com.kwad.sdk.glide.load.b;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.model.GlideUrl;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;
/* loaded from: classes7.dex */
public class g implements com.kwad.sdk.glide.load.c {

    /* renamed from: b  reason: collision with root package name */
    public final h f36087b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final URL f36088c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final String f36089d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public String f36090e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public URL f36091f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public volatile byte[] f36092g;

    /* renamed from: h  reason: collision with root package name */
    public int f36093h;

    public g(String str) {
        this(str, h.f36095b);
    }

    public g(String str, h hVar) {
        this.f36088c = null;
        this.f36089d = com.kwad.sdk.glide.g.j.a(str);
        this.f36087b = (h) com.kwad.sdk.glide.g.j.a(hVar);
    }

    public g(URL url) {
        this(url, h.f36095b);
    }

    public g(URL url, h hVar) {
        this.f36088c = (URL) com.kwad.sdk.glide.g.j.a(url);
        this.f36089d = null;
        this.f36087b = (h) com.kwad.sdk.glide.g.j.a(hVar);
    }

    private URL d() {
        if (this.f36091f == null) {
            this.f36091f = new URL(e());
        }
        return this.f36091f;
    }

    private String e() {
        if (TextUtils.isEmpty(this.f36090e)) {
            String str = this.f36089d;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) com.kwad.sdk.glide.g.j.a(this.f36088c)).toString();
            }
            this.f36090e = Uri.encode(str, GlideUrl.ALLOWED_URI_CHARS);
        }
        return this.f36090e;
    }

    private byte[] f() {
        if (this.f36092g == null) {
            this.f36092g = c().getBytes(com.kwad.sdk.glide.load.c.f36158a);
        }
        return this.f36092g;
    }

    public URL a() {
        return d();
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f());
    }

    public Map<String, String> b() {
        return this.f36087b.a();
    }

    public String c() {
        String str = this.f36089d;
        return str != null ? str : ((URL) com.kwad.sdk.glide.g.j.a(this.f36088c)).toString();
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            return c().equals(gVar.c()) && this.f36087b.equals(gVar.f36087b);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        if (this.f36093h == 0) {
            int hashCode = c().hashCode();
            this.f36093h = hashCode;
            this.f36093h = (hashCode * 31) + this.f36087b.hashCode();
        }
        return this.f36093h;
    }

    public String toString() {
        return c();
    }
}
