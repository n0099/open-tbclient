package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
/* loaded from: classes6.dex */
public final class u implements com.kwad.sdk.glide.load.c {

    /* renamed from: b  reason: collision with root package name */
    public static final com.kwad.sdk.glide.g.g<Class<?>, byte[]> f35997b = new com.kwad.sdk.glide.g.g<>(50);

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f35998c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.c f35999d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.c f36000e;

    /* renamed from: f  reason: collision with root package name */
    public final int f36001f;

    /* renamed from: g  reason: collision with root package name */
    public final int f36002g;

    /* renamed from: h  reason: collision with root package name */
    public final Class<?> f36003h;
    public final com.kwad.sdk.glide.load.e i;
    public final com.kwad.sdk.glide.load.h<?> j;

    public u(com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, com.kwad.sdk.glide.load.c cVar, com.kwad.sdk.glide.load.c cVar2, int i, int i2, com.kwad.sdk.glide.load.h<?> hVar, Class<?> cls, com.kwad.sdk.glide.load.e eVar) {
        this.f35998c = bVar;
        this.f35999d = cVar;
        this.f36000e = cVar2;
        this.f36001f = i;
        this.f36002g = i2;
        this.j = hVar;
        this.f36003h = cls;
        this.i = eVar;
    }

    private byte[] a() {
        byte[] b2 = f35997b.b(this.f36003h);
        if (b2 == null) {
            byte[] bytes = this.f36003h.getName().getBytes(com.kwad.sdk.glide.load.c.f35761a);
            f35997b.b(this.f36003h, bytes);
            return bytes;
        }
        return b2;
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f35998c.b(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f36001f).putInt(this.f36002g).array();
        this.f36000e.a(messageDigest);
        this.f35999d.a(messageDigest);
        messageDigest.update(bArr);
        com.kwad.sdk.glide.load.h<?> hVar = this.j;
        if (hVar != null) {
            hVar.a(messageDigest);
        }
        this.i.a(messageDigest);
        messageDigest.update(a());
        this.f35998c.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof u) {
            u uVar = (u) obj;
            return this.f36002g == uVar.f36002g && this.f36001f == uVar.f36001f && com.kwad.sdk.glide.g.k.a(this.j, uVar.j) && this.f36003h.equals(uVar.f36003h) && this.f35999d.equals(uVar.f35999d) && this.f36000e.equals(uVar.f36000e) && this.i.equals(uVar.i);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        int hashCode = (((((this.f35999d.hashCode() * 31) + this.f36000e.hashCode()) * 31) + this.f36001f) * 31) + this.f36002g;
        com.kwad.sdk.glide.load.h<?> hVar = this.j;
        if (hVar != null) {
            hashCode = (hashCode * 31) + hVar.hashCode();
        }
        return (((hashCode * 31) + this.f36003h.hashCode()) * 31) + this.i.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f35999d + ", signature=" + this.f36000e + ", width=" + this.f36001f + ", height=" + this.f36002g + ", decodedResourceClass=" + this.f36003h + ", transformation='" + this.j + "', options=" + this.i + '}';
    }
}
