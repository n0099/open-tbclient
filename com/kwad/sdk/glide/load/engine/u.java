package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
/* loaded from: classes6.dex */
public final class u implements com.kwad.sdk.glide.load.c {

    /* renamed from: b  reason: collision with root package name */
    public static final com.kwad.sdk.glide.g.g<Class<?>, byte[]> f35613b = new com.kwad.sdk.glide.g.g<>(50);

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f35614c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.c f35615d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.c f35616e;

    /* renamed from: f  reason: collision with root package name */
    public final int f35617f;

    /* renamed from: g  reason: collision with root package name */
    public final int f35618g;

    /* renamed from: h  reason: collision with root package name */
    public final Class<?> f35619h;
    public final com.kwad.sdk.glide.load.e i;
    public final com.kwad.sdk.glide.load.h<?> j;

    public u(com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, com.kwad.sdk.glide.load.c cVar, com.kwad.sdk.glide.load.c cVar2, int i, int i2, com.kwad.sdk.glide.load.h<?> hVar, Class<?> cls, com.kwad.sdk.glide.load.e eVar) {
        this.f35614c = bVar;
        this.f35615d = cVar;
        this.f35616e = cVar2;
        this.f35617f = i;
        this.f35618g = i2;
        this.j = hVar;
        this.f35619h = cls;
        this.i = eVar;
    }

    private byte[] a() {
        byte[] b2 = f35613b.b(this.f35619h);
        if (b2 == null) {
            byte[] bytes = this.f35619h.getName().getBytes(com.kwad.sdk.glide.load.c.f35377a);
            f35613b.b(this.f35619h, bytes);
            return bytes;
        }
        return b2;
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f35614c.b(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f35617f).putInt(this.f35618g).array();
        this.f35616e.a(messageDigest);
        this.f35615d.a(messageDigest);
        messageDigest.update(bArr);
        com.kwad.sdk.glide.load.h<?> hVar = this.j;
        if (hVar != null) {
            hVar.a(messageDigest);
        }
        this.i.a(messageDigest);
        messageDigest.update(a());
        this.f35614c.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof u) {
            u uVar = (u) obj;
            return this.f35618g == uVar.f35618g && this.f35617f == uVar.f35617f && com.kwad.sdk.glide.g.k.a(this.j, uVar.j) && this.f35619h.equals(uVar.f35619h) && this.f35615d.equals(uVar.f35615d) && this.f35616e.equals(uVar.f35616e) && this.i.equals(uVar.i);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        int hashCode = (((((this.f35615d.hashCode() * 31) + this.f35616e.hashCode()) * 31) + this.f35617f) * 31) + this.f35618g;
        com.kwad.sdk.glide.load.h<?> hVar = this.j;
        if (hVar != null) {
            hashCode = (hashCode * 31) + hVar.hashCode();
        }
        return (((hashCode * 31) + this.f35619h.hashCode()) * 31) + this.i.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f35615d + ", signature=" + this.f35616e + ", width=" + this.f35617f + ", height=" + this.f35618g + ", decodedResourceClass=" + this.f35619h + ", transformation='" + this.j + "', options=" + this.i + '}';
    }
}
