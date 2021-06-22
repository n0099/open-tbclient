package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import java.util.Map;
/* loaded from: classes7.dex */
public class l implements com.kwad.sdk.glide.load.c {

    /* renamed from: b  reason: collision with root package name */
    public final Object f36368b;

    /* renamed from: c  reason: collision with root package name */
    public final int f36369c;

    /* renamed from: d  reason: collision with root package name */
    public final int f36370d;

    /* renamed from: e  reason: collision with root package name */
    public final Class<?> f36371e;

    /* renamed from: f  reason: collision with root package name */
    public final Class<?> f36372f;

    /* renamed from: g  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.c f36373g;

    /* renamed from: h  reason: collision with root package name */
    public final Map<Class<?>, com.kwad.sdk.glide.load.h<?>> f36374h;

    /* renamed from: i  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.e f36375i;
    public int j;

    public l(Object obj, com.kwad.sdk.glide.load.c cVar, int i2, int i3, Map<Class<?>, com.kwad.sdk.glide.load.h<?>> map, Class<?> cls, Class<?> cls2, com.kwad.sdk.glide.load.e eVar) {
        this.f36368b = com.kwad.sdk.glide.g.j.a(obj);
        this.f36373g = (com.kwad.sdk.glide.load.c) com.kwad.sdk.glide.g.j.a(cVar, "Signature must not be null");
        this.f36369c = i2;
        this.f36370d = i3;
        this.f36374h = (Map) com.kwad.sdk.glide.g.j.a(map);
        this.f36371e = (Class) com.kwad.sdk.glide.g.j.a(cls, "Resource class must not be null");
        this.f36372f = (Class) com.kwad.sdk.glide.g.j.a(cls2, "Transcode class must not be null");
        this.f36375i = (com.kwad.sdk.glide.load.e) com.kwad.sdk.glide.g.j.a(eVar);
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof l) {
            l lVar = (l) obj;
            return this.f36368b.equals(lVar.f36368b) && this.f36373g.equals(lVar.f36373g) && this.f36370d == lVar.f36370d && this.f36369c == lVar.f36369c && this.f36374h.equals(lVar.f36374h) && this.f36371e.equals(lVar.f36371e) && this.f36372f.equals(lVar.f36372f) && this.f36375i.equals(lVar.f36375i);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        if (this.j == 0) {
            int hashCode = this.f36368b.hashCode();
            this.j = hashCode;
            int hashCode2 = (hashCode * 31) + this.f36373g.hashCode();
            this.j = hashCode2;
            int i2 = (hashCode2 * 31) + this.f36369c;
            this.j = i2;
            int i3 = (i2 * 31) + this.f36370d;
            this.j = i3;
            int hashCode3 = (i3 * 31) + this.f36374h.hashCode();
            this.j = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.f36371e.hashCode();
            this.j = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.f36372f.hashCode();
            this.j = hashCode5;
            this.j = (hashCode5 * 31) + this.f36375i.hashCode();
        }
        return this.j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f36368b + ", width=" + this.f36369c + ", height=" + this.f36370d + ", resourceClass=" + this.f36371e + ", transcodeClass=" + this.f36372f + ", signature=" + this.f36373g + ", hashCode=" + this.j + ", transformations=" + this.f36374h + ", options=" + this.f36375i + '}';
    }
}
