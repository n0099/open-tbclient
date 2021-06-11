package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import java.util.Map;
/* loaded from: classes7.dex */
public class l implements com.kwad.sdk.glide.load.c {

    /* renamed from: b  reason: collision with root package name */
    public final Object f36270b;

    /* renamed from: c  reason: collision with root package name */
    public final int f36271c;

    /* renamed from: d  reason: collision with root package name */
    public final int f36272d;

    /* renamed from: e  reason: collision with root package name */
    public final Class<?> f36273e;

    /* renamed from: f  reason: collision with root package name */
    public final Class<?> f36274f;

    /* renamed from: g  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.c f36275g;

    /* renamed from: h  reason: collision with root package name */
    public final Map<Class<?>, com.kwad.sdk.glide.load.h<?>> f36276h;

    /* renamed from: i  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.e f36277i;
    public int j;

    public l(Object obj, com.kwad.sdk.glide.load.c cVar, int i2, int i3, Map<Class<?>, com.kwad.sdk.glide.load.h<?>> map, Class<?> cls, Class<?> cls2, com.kwad.sdk.glide.load.e eVar) {
        this.f36270b = com.kwad.sdk.glide.g.j.a(obj);
        this.f36275g = (com.kwad.sdk.glide.load.c) com.kwad.sdk.glide.g.j.a(cVar, "Signature must not be null");
        this.f36271c = i2;
        this.f36272d = i3;
        this.f36276h = (Map) com.kwad.sdk.glide.g.j.a(map);
        this.f36273e = (Class) com.kwad.sdk.glide.g.j.a(cls, "Resource class must not be null");
        this.f36274f = (Class) com.kwad.sdk.glide.g.j.a(cls2, "Transcode class must not be null");
        this.f36277i = (com.kwad.sdk.glide.load.e) com.kwad.sdk.glide.g.j.a(eVar);
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof l) {
            l lVar = (l) obj;
            return this.f36270b.equals(lVar.f36270b) && this.f36275g.equals(lVar.f36275g) && this.f36272d == lVar.f36272d && this.f36271c == lVar.f36271c && this.f36276h.equals(lVar.f36276h) && this.f36273e.equals(lVar.f36273e) && this.f36274f.equals(lVar.f36274f) && this.f36277i.equals(lVar.f36277i);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        if (this.j == 0) {
            int hashCode = this.f36270b.hashCode();
            this.j = hashCode;
            int hashCode2 = (hashCode * 31) + this.f36275g.hashCode();
            this.j = hashCode2;
            int i2 = (hashCode2 * 31) + this.f36271c;
            this.j = i2;
            int i3 = (i2 * 31) + this.f36272d;
            this.j = i3;
            int hashCode3 = (i3 * 31) + this.f36276h.hashCode();
            this.j = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.f36273e.hashCode();
            this.j = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.f36274f.hashCode();
            this.j = hashCode5;
            this.j = (hashCode5 * 31) + this.f36277i.hashCode();
        }
        return this.j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f36270b + ", width=" + this.f36271c + ", height=" + this.f36272d + ", resourceClass=" + this.f36273e + ", transcodeClass=" + this.f36274f + ", signature=" + this.f36275g + ", hashCode=" + this.j + ", transformations=" + this.f36276h + ", options=" + this.f36277i + '}';
    }
}
