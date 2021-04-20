package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
/* loaded from: classes6.dex */
public final class u implements com.kwad.sdk.glide.load.c {

    /* renamed from: b  reason: collision with root package name */
    public static final com.kwad.sdk.glide.g.g<Class<?>, byte[]> f35902b = new com.kwad.sdk.glide.g.g<>(50);

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f35903c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.c f35904d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.c f35905e;

    /* renamed from: f  reason: collision with root package name */
    public final int f35906f;

    /* renamed from: g  reason: collision with root package name */
    public final int f35907g;

    /* renamed from: h  reason: collision with root package name */
    public final Class<?> f35908h;
    public final com.kwad.sdk.glide.load.e i;
    public final com.kwad.sdk.glide.load.h<?> j;

    public u(com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, com.kwad.sdk.glide.load.c cVar, com.kwad.sdk.glide.load.c cVar2, int i, int i2, com.kwad.sdk.glide.load.h<?> hVar, Class<?> cls, com.kwad.sdk.glide.load.e eVar) {
        this.f35903c = bVar;
        this.f35904d = cVar;
        this.f35905e = cVar2;
        this.f35906f = i;
        this.f35907g = i2;
        this.j = hVar;
        this.f35908h = cls;
        this.i = eVar;
    }

    private byte[] a() {
        byte[] b2 = f35902b.b(this.f35908h);
        if (b2 == null) {
            byte[] bytes = this.f35908h.getName().getBytes(com.kwad.sdk.glide.load.c.f35666a);
            f35902b.b(this.f35908h, bytes);
            return bytes;
        }
        return b2;
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f35903c.b(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f35906f).putInt(this.f35907g).array();
        this.f35905e.a(messageDigest);
        this.f35904d.a(messageDigest);
        messageDigest.update(bArr);
        com.kwad.sdk.glide.load.h<?> hVar = this.j;
        if (hVar != null) {
            hVar.a(messageDigest);
        }
        this.i.a(messageDigest);
        messageDigest.update(a());
        this.f35903c.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof u) {
            u uVar = (u) obj;
            return this.f35907g == uVar.f35907g && this.f35906f == uVar.f35906f && com.kwad.sdk.glide.g.k.a(this.j, uVar.j) && this.f35908h.equals(uVar.f35908h) && this.f35904d.equals(uVar.f35904d) && this.f35905e.equals(uVar.f35905e) && this.i.equals(uVar.i);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        int hashCode = (((((this.f35904d.hashCode() * 31) + this.f35905e.hashCode()) * 31) + this.f35906f) * 31) + this.f35907g;
        com.kwad.sdk.glide.load.h<?> hVar = this.j;
        if (hVar != null) {
            hashCode = (hashCode * 31) + hVar.hashCode();
        }
        return (((hashCode * 31) + this.f35908h.hashCode()) * 31) + this.i.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f35904d + ", signature=" + this.f35905e + ", width=" + this.f35906f + ", height=" + this.f35907g + ", decodedResourceClass=" + this.f35908h + ", transformation='" + this.j + "', options=" + this.i + '}';
    }
}
