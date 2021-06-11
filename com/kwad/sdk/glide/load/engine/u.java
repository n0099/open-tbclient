package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
/* loaded from: classes7.dex */
public final class u implements com.kwad.sdk.glide.load.c {

    /* renamed from: b  reason: collision with root package name */
    public static final com.kwad.sdk.glide.g.g<Class<?>, byte[]> f36305b = new com.kwad.sdk.glide.g.g<>(50);

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f36306c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.c f36307d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.c f36308e;

    /* renamed from: f  reason: collision with root package name */
    public final int f36309f;

    /* renamed from: g  reason: collision with root package name */
    public final int f36310g;

    /* renamed from: h  reason: collision with root package name */
    public final Class<?> f36311h;

    /* renamed from: i  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.e f36312i;
    public final com.kwad.sdk.glide.load.h<?> j;

    public u(com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, com.kwad.sdk.glide.load.c cVar, com.kwad.sdk.glide.load.c cVar2, int i2, int i3, com.kwad.sdk.glide.load.h<?> hVar, Class<?> cls, com.kwad.sdk.glide.load.e eVar) {
        this.f36306c = bVar;
        this.f36307d = cVar;
        this.f36308e = cVar2;
        this.f36309f = i2;
        this.f36310g = i3;
        this.j = hVar;
        this.f36311h = cls;
        this.f36312i = eVar;
    }

    private byte[] a() {
        byte[] b2 = f36305b.b(this.f36311h);
        if (b2 == null) {
            byte[] bytes = this.f36311h.getName().getBytes(com.kwad.sdk.glide.load.c.f36060a);
            f36305b.b(this.f36311h, bytes);
            return bytes;
        }
        return b2;
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f36306c.b(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f36309f).putInt(this.f36310g).array();
        this.f36308e.a(messageDigest);
        this.f36307d.a(messageDigest);
        messageDigest.update(bArr);
        com.kwad.sdk.glide.load.h<?> hVar = this.j;
        if (hVar != null) {
            hVar.a(messageDigest);
        }
        this.f36312i.a(messageDigest);
        messageDigest.update(a());
        this.f36306c.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof u) {
            u uVar = (u) obj;
            return this.f36310g == uVar.f36310g && this.f36309f == uVar.f36309f && com.kwad.sdk.glide.g.k.a(this.j, uVar.j) && this.f36311h.equals(uVar.f36311h) && this.f36307d.equals(uVar.f36307d) && this.f36308e.equals(uVar.f36308e) && this.f36312i.equals(uVar.f36312i);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        int hashCode = (((((this.f36307d.hashCode() * 31) + this.f36308e.hashCode()) * 31) + this.f36309f) * 31) + this.f36310g;
        com.kwad.sdk.glide.load.h<?> hVar = this.j;
        if (hVar != null) {
            hashCode = (hashCode * 31) + hVar.hashCode();
        }
        return (((hashCode * 31) + this.f36311h.hashCode()) * 31) + this.f36312i.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f36307d + ", signature=" + this.f36308e + ", width=" + this.f36309f + ", height=" + this.f36310g + ", decodedResourceClass=" + this.f36311h + ", transformation='" + this.j + "', options=" + this.f36312i + '}';
    }
}
