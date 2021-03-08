package com.kwad.sdk.glide.load.b;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;
/* loaded from: classes3.dex */
public class g implements com.kwad.sdk.glide.load.c {
    private final h b;
    @Nullable
    private final URL c;
    @Nullable
    private final String d;
    @Nullable
    private String e;
    @Nullable
    private URL f;
    @Nullable
    private volatile byte[] g;
    private int h;

    public g(String str) {
        this(str, h.b);
    }

    public g(String str, h hVar) {
        this.c = null;
        this.d = com.kwad.sdk.glide.g.j.a(str);
        this.b = (h) com.kwad.sdk.glide.g.j.a(hVar);
    }

    public g(URL url) {
        this(url, h.b);
    }

    public g(URL url, h hVar) {
        this.c = (URL) com.kwad.sdk.glide.g.j.a(url);
        this.d = null;
        this.b = (h) com.kwad.sdk.glide.g.j.a(hVar);
    }

    private URL d() {
        if (this.f == null) {
            this.f = new URL(e());
        }
        return this.f;
    }

    private String e() {
        if (TextUtils.isEmpty(this.e)) {
            String str = this.d;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) com.kwad.sdk.glide.g.j.a(this.c)).toString();
            }
            this.e = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.e;
    }

    private byte[] f() {
        if (this.g == null) {
            this.g = c().getBytes(f6709a);
        }
        return this.g;
    }

    public URL a() {
        return d();
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f());
    }

    public Map<String, String> b() {
        return this.b.a();
    }

    public String c() {
        return this.d != null ? this.d : ((URL) com.kwad.sdk.glide.g.j.a(this.c)).toString();
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            return c().equals(gVar.c()) && this.b.equals(gVar.b);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        if (this.h == 0) {
            this.h = c().hashCode();
            this.h = (this.h * 31) + this.b.hashCode();
        }
        return this.h;
    }

    public String toString() {
        return c();
    }
}
