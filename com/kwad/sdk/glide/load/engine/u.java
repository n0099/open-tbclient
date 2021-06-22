package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
/* loaded from: classes7.dex */
public final class u implements com.kwad.sdk.glide.load.c {

    /* renamed from: b  reason: collision with root package name */
    public static final com.kwad.sdk.glide.g.g<Class<?>, byte[]> f36403b = new com.kwad.sdk.glide.g.g<>(50);

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f36404c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.c f36405d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.c f36406e;

    /* renamed from: f  reason: collision with root package name */
    public final int f36407f;

    /* renamed from: g  reason: collision with root package name */
    public final int f36408g;

    /* renamed from: h  reason: collision with root package name */
    public final Class<?> f36409h;

    /* renamed from: i  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.e f36410i;
    public final com.kwad.sdk.glide.load.h<?> j;

    public u(com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, com.kwad.sdk.glide.load.c cVar, com.kwad.sdk.glide.load.c cVar2, int i2, int i3, com.kwad.sdk.glide.load.h<?> hVar, Class<?> cls, com.kwad.sdk.glide.load.e eVar) {
        this.f36404c = bVar;
        this.f36405d = cVar;
        this.f36406e = cVar2;
        this.f36407f = i2;
        this.f36408g = i3;
        this.j = hVar;
        this.f36409h = cls;
        this.f36410i = eVar;
    }

    private byte[] a() {
        byte[] b2 = f36403b.b(this.f36409h);
        if (b2 == null) {
            byte[] bytes = this.f36409h.getName().getBytes(com.kwad.sdk.glide.load.c.f36158a);
            f36403b.b(this.f36409h, bytes);
            return bytes;
        }
        return b2;
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f36404c.b(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f36407f).putInt(this.f36408g).array();
        this.f36406e.a(messageDigest);
        this.f36405d.a(messageDigest);
        messageDigest.update(bArr);
        com.kwad.sdk.glide.load.h<?> hVar = this.j;
        if (hVar != null) {
            hVar.a(messageDigest);
        }
        this.f36410i.a(messageDigest);
        messageDigest.update(a());
        this.f36404c.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof u) {
            u uVar = (u) obj;
            return this.f36408g == uVar.f36408g && this.f36407f == uVar.f36407f && com.kwad.sdk.glide.g.k.a(this.j, uVar.j) && this.f36409h.equals(uVar.f36409h) && this.f36405d.equals(uVar.f36405d) && this.f36406e.equals(uVar.f36406e) && this.f36410i.equals(uVar.f36410i);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        int hashCode = (((((this.f36405d.hashCode() * 31) + this.f36406e.hashCode()) * 31) + this.f36407f) * 31) + this.f36408g;
        com.kwad.sdk.glide.load.h<?> hVar = this.j;
        if (hVar != null) {
            hashCode = (hashCode * 31) + hVar.hashCode();
        }
        return (((hashCode * 31) + this.f36409h.hashCode()) * 31) + this.f36410i.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f36405d + ", signature=" + this.f36406e + ", width=" + this.f36407f + ", height=" + this.f36408g + ", decodedResourceClass=" + this.f36409h + ", transformation='" + this.j + "', options=" + this.f36410i + '}';
    }
}
