package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import java.util.Map;
/* loaded from: classes4.dex */
class l implements com.kwad.sdk.glide.load.c {

    /* renamed from: b  reason: collision with root package name */
    private final Object f10239b;
    private final int c;
    private final int d;
    private final Class<?> e;
    private final Class<?> f;
    private final com.kwad.sdk.glide.load.c g;
    private final Map<Class<?>, com.kwad.sdk.glide.load.h<?>> h;
    private final com.kwad.sdk.glide.load.e i;
    private int j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Object obj, com.kwad.sdk.glide.load.c cVar, int i, int i2, Map<Class<?>, com.kwad.sdk.glide.load.h<?>> map, Class<?> cls, Class<?> cls2, com.kwad.sdk.glide.load.e eVar) {
        this.f10239b = com.kwad.sdk.glide.g.j.a(obj);
        this.g = (com.kwad.sdk.glide.load.c) com.kwad.sdk.glide.g.j.a(cVar, "Signature must not be null");
        this.c = i;
        this.d = i2;
        this.h = (Map) com.kwad.sdk.glide.g.j.a(map);
        this.e = (Class) com.kwad.sdk.glide.g.j.a(cls, "Resource class must not be null");
        this.f = (Class) com.kwad.sdk.glide.g.j.a(cls2, "Transcode class must not be null");
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
            return this.f10239b.equals(lVar.f10239b) && this.g.equals(lVar.g) && this.d == lVar.d && this.c == lVar.c && this.h.equals(lVar.h) && this.e.equals(lVar.e) && this.f.equals(lVar.f) && this.i.equals(lVar.i);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        if (this.j == 0) {
            this.j = this.f10239b.hashCode();
            this.j = (this.j * 31) + this.g.hashCode();
            this.j = (this.j * 31) + this.c;
            this.j = (this.j * 31) + this.d;
            this.j = (this.j * 31) + this.h.hashCode();
            this.j = (this.j * 31) + this.e.hashCode();
            this.j = (this.j * 31) + this.f.hashCode();
            this.j = (this.j * 31) + this.i.hashCode();
        }
        return this.j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f10239b + ", width=" + this.c + ", height=" + this.d + ", resourceClass=" + this.e + ", transcodeClass=" + this.f + ", signature=" + this.g + ", hashCode=" + this.j + ", transformations=" + this.h + ", options=" + this.i + '}';
    }
}
