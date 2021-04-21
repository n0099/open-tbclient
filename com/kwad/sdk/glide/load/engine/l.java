package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import java.util.Map;
/* loaded from: classes6.dex */
public class l implements com.kwad.sdk.glide.load.c {

    /* renamed from: b  reason: collision with root package name */
    public final Object f35964b;

    /* renamed from: c  reason: collision with root package name */
    public final int f35965c;

    /* renamed from: d  reason: collision with root package name */
    public final int f35966d;

    /* renamed from: e  reason: collision with root package name */
    public final Class<?> f35967e;

    /* renamed from: f  reason: collision with root package name */
    public final Class<?> f35968f;

    /* renamed from: g  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.c f35969g;

    /* renamed from: h  reason: collision with root package name */
    public final Map<Class<?>, com.kwad.sdk.glide.load.h<?>> f35970h;
    public final com.kwad.sdk.glide.load.e i;
    public int j;

    public l(Object obj, com.kwad.sdk.glide.load.c cVar, int i, int i2, Map<Class<?>, com.kwad.sdk.glide.load.h<?>> map, Class<?> cls, Class<?> cls2, com.kwad.sdk.glide.load.e eVar) {
        this.f35964b = com.kwad.sdk.glide.g.j.a(obj);
        this.f35969g = (com.kwad.sdk.glide.load.c) com.kwad.sdk.glide.g.j.a(cVar, "Signature must not be null");
        this.f35965c = i;
        this.f35966d = i2;
        this.f35970h = (Map) com.kwad.sdk.glide.g.j.a(map);
        this.f35967e = (Class) com.kwad.sdk.glide.g.j.a(cls, "Resource class must not be null");
        this.f35968f = (Class) com.kwad.sdk.glide.g.j.a(cls2, "Transcode class must not be null");
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
            return this.f35964b.equals(lVar.f35964b) && this.f35969g.equals(lVar.f35969g) && this.f35966d == lVar.f35966d && this.f35965c == lVar.f35965c && this.f35970h.equals(lVar.f35970h) && this.f35967e.equals(lVar.f35967e) && this.f35968f.equals(lVar.f35968f) && this.i.equals(lVar.i);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        if (this.j == 0) {
            int hashCode = this.f35964b.hashCode();
            this.j = hashCode;
            int hashCode2 = (hashCode * 31) + this.f35969g.hashCode();
            this.j = hashCode2;
            int i = (hashCode2 * 31) + this.f35965c;
            this.j = i;
            int i2 = (i * 31) + this.f35966d;
            this.j = i2;
            int hashCode3 = (i2 * 31) + this.f35970h.hashCode();
            this.j = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.f35967e.hashCode();
            this.j = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.f35968f.hashCode();
            this.j = hashCode5;
            this.j = (hashCode5 * 31) + this.i.hashCode();
        }
        return this.j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f35964b + ", width=" + this.f35965c + ", height=" + this.f35966d + ", resourceClass=" + this.f35967e + ", transcodeClass=" + this.f35968f + ", signature=" + this.f35969g + ", hashCode=" + this.j + ", transformations=" + this.f35970h + ", options=" + this.i + '}';
    }
}
