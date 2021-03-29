package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import java.util.Map;
/* loaded from: classes6.dex */
public class l implements com.kwad.sdk.glide.load.c {

    /* renamed from: b  reason: collision with root package name */
    public final Object f35580b;

    /* renamed from: c  reason: collision with root package name */
    public final int f35581c;

    /* renamed from: d  reason: collision with root package name */
    public final int f35582d;

    /* renamed from: e  reason: collision with root package name */
    public final Class<?> f35583e;

    /* renamed from: f  reason: collision with root package name */
    public final Class<?> f35584f;

    /* renamed from: g  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.c f35585g;

    /* renamed from: h  reason: collision with root package name */
    public final Map<Class<?>, com.kwad.sdk.glide.load.h<?>> f35586h;
    public final com.kwad.sdk.glide.load.e i;
    public int j;

    public l(Object obj, com.kwad.sdk.glide.load.c cVar, int i, int i2, Map<Class<?>, com.kwad.sdk.glide.load.h<?>> map, Class<?> cls, Class<?> cls2, com.kwad.sdk.glide.load.e eVar) {
        this.f35580b = com.kwad.sdk.glide.g.j.a(obj);
        this.f35585g = (com.kwad.sdk.glide.load.c) com.kwad.sdk.glide.g.j.a(cVar, "Signature must not be null");
        this.f35581c = i;
        this.f35582d = i2;
        this.f35586h = (Map) com.kwad.sdk.glide.g.j.a(map);
        this.f35583e = (Class) com.kwad.sdk.glide.g.j.a(cls, "Resource class must not be null");
        this.f35584f = (Class) com.kwad.sdk.glide.g.j.a(cls2, "Transcode class must not be null");
        this.i = (com.kwad.sdk.glide.load.e) com.kwad.sdk.glide.g.j.a(eVar);
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof l) {
            l lVar = (l) obj;
            return this.f35580b.equals(lVar.f35580b) && this.f35585g.equals(lVar.f35585g) && this.f35582d == lVar.f35582d && this.f35581c == lVar.f35581c && this.f35586h.equals(lVar.f35586h) && this.f35583e.equals(lVar.f35583e) && this.f35584f.equals(lVar.f35584f) && this.i.equals(lVar.i);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        if (this.j == 0) {
            int hashCode = this.f35580b.hashCode();
            this.j = hashCode;
            int hashCode2 = (hashCode * 31) + this.f35585g.hashCode();
            this.j = hashCode2;
            int i = (hashCode2 * 31) + this.f35581c;
            this.j = i;
            int i2 = (i * 31) + this.f35582d;
            this.j = i2;
            int hashCode3 = (i2 * 31) + this.f35586h.hashCode();
            this.j = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.f35583e.hashCode();
            this.j = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.f35584f.hashCode();
            this.j = hashCode5;
            this.j = (hashCode5 * 31) + this.i.hashCode();
        }
        return this.j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f35580b + ", width=" + this.f35581c + ", height=" + this.f35582d + ", resourceClass=" + this.f35583e + ", transcodeClass=" + this.f35584f + ", signature=" + this.f35585g + ", hashCode=" + this.j + ", transformations=" + this.f35586h + ", options=" + this.i + '}';
    }
}
