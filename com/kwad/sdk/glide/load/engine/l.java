package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import java.util.Map;
/* loaded from: classes6.dex */
public class l implements com.kwad.sdk.glide.load.c {

    /* renamed from: b  reason: collision with root package name */
    public final Object f35579b;

    /* renamed from: c  reason: collision with root package name */
    public final int f35580c;

    /* renamed from: d  reason: collision with root package name */
    public final int f35581d;

    /* renamed from: e  reason: collision with root package name */
    public final Class<?> f35582e;

    /* renamed from: f  reason: collision with root package name */
    public final Class<?> f35583f;

    /* renamed from: g  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.c f35584g;

    /* renamed from: h  reason: collision with root package name */
    public final Map<Class<?>, com.kwad.sdk.glide.load.h<?>> f35585h;
    public final com.kwad.sdk.glide.load.e i;
    public int j;

    public l(Object obj, com.kwad.sdk.glide.load.c cVar, int i, int i2, Map<Class<?>, com.kwad.sdk.glide.load.h<?>> map, Class<?> cls, Class<?> cls2, com.kwad.sdk.glide.load.e eVar) {
        this.f35579b = com.kwad.sdk.glide.g.j.a(obj);
        this.f35584g = (com.kwad.sdk.glide.load.c) com.kwad.sdk.glide.g.j.a(cVar, "Signature must not be null");
        this.f35580c = i;
        this.f35581d = i2;
        this.f35585h = (Map) com.kwad.sdk.glide.g.j.a(map);
        this.f35582e = (Class) com.kwad.sdk.glide.g.j.a(cls, "Resource class must not be null");
        this.f35583f = (Class) com.kwad.sdk.glide.g.j.a(cls2, "Transcode class must not be null");
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
            return this.f35579b.equals(lVar.f35579b) && this.f35584g.equals(lVar.f35584g) && this.f35581d == lVar.f35581d && this.f35580c == lVar.f35580c && this.f35585h.equals(lVar.f35585h) && this.f35582e.equals(lVar.f35582e) && this.f35583f.equals(lVar.f35583f) && this.i.equals(lVar.i);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        if (this.j == 0) {
            int hashCode = this.f35579b.hashCode();
            this.j = hashCode;
            int hashCode2 = (hashCode * 31) + this.f35584g.hashCode();
            this.j = hashCode2;
            int i = (hashCode2 * 31) + this.f35580c;
            this.j = i;
            int i2 = (i * 31) + this.f35581d;
            this.j = i2;
            int hashCode3 = (i2 * 31) + this.f35585h.hashCode();
            this.j = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.f35582e.hashCode();
            this.j = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.f35583f.hashCode();
            this.j = hashCode5;
            this.j = (hashCode5 * 31) + this.i.hashCode();
        }
        return this.j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f35579b + ", width=" + this.f35580c + ", height=" + this.f35581d + ", resourceClass=" + this.f35582e + ", transcodeClass=" + this.f35583f + ", signature=" + this.f35584g + ", hashCode=" + this.j + ", transformations=" + this.f35585h + ", options=" + this.i + '}';
    }
}
