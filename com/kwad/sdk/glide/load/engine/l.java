package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import java.util.Map;
/* loaded from: classes6.dex */
public class l implements com.kwad.sdk.glide.load.c {

    /* renamed from: b  reason: collision with root package name */
    public final Object f35869b;

    /* renamed from: c  reason: collision with root package name */
    public final int f35870c;

    /* renamed from: d  reason: collision with root package name */
    public final int f35871d;

    /* renamed from: e  reason: collision with root package name */
    public final Class<?> f35872e;

    /* renamed from: f  reason: collision with root package name */
    public final Class<?> f35873f;

    /* renamed from: g  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.c f35874g;

    /* renamed from: h  reason: collision with root package name */
    public final Map<Class<?>, com.kwad.sdk.glide.load.h<?>> f35875h;
    public final com.kwad.sdk.glide.load.e i;
    public int j;

    public l(Object obj, com.kwad.sdk.glide.load.c cVar, int i, int i2, Map<Class<?>, com.kwad.sdk.glide.load.h<?>> map, Class<?> cls, Class<?> cls2, com.kwad.sdk.glide.load.e eVar) {
        this.f35869b = com.kwad.sdk.glide.g.j.a(obj);
        this.f35874g = (com.kwad.sdk.glide.load.c) com.kwad.sdk.glide.g.j.a(cVar, "Signature must not be null");
        this.f35870c = i;
        this.f35871d = i2;
        this.f35875h = (Map) com.kwad.sdk.glide.g.j.a(map);
        this.f35872e = (Class) com.kwad.sdk.glide.g.j.a(cls, "Resource class must not be null");
        this.f35873f = (Class) com.kwad.sdk.glide.g.j.a(cls2, "Transcode class must not be null");
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
            return this.f35869b.equals(lVar.f35869b) && this.f35874g.equals(lVar.f35874g) && this.f35871d == lVar.f35871d && this.f35870c == lVar.f35870c && this.f35875h.equals(lVar.f35875h) && this.f35872e.equals(lVar.f35872e) && this.f35873f.equals(lVar.f35873f) && this.i.equals(lVar.i);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        if (this.j == 0) {
            int hashCode = this.f35869b.hashCode();
            this.j = hashCode;
            int hashCode2 = (hashCode * 31) + this.f35874g.hashCode();
            this.j = hashCode2;
            int i = (hashCode2 * 31) + this.f35870c;
            this.j = i;
            int i2 = (i * 31) + this.f35871d;
            this.j = i2;
            int hashCode3 = (i2 * 31) + this.f35875h.hashCode();
            this.j = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.f35872e.hashCode();
            this.j = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.f35873f.hashCode();
            this.j = hashCode5;
            this.j = (hashCode5 * 31) + this.i.hashCode();
        }
        return this.j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f35869b + ", width=" + this.f35870c + ", height=" + this.f35871d + ", resourceClass=" + this.f35872e + ", transcodeClass=" + this.f35873f + ", signature=" + this.f35874g + ", hashCode=" + this.j + ", transformations=" + this.f35875h + ", options=" + this.i + '}';
    }
}
