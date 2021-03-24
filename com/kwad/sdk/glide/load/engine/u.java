package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
/* loaded from: classes6.dex */
public final class u implements com.kwad.sdk.glide.load.c {

    /* renamed from: b  reason: collision with root package name */
    public static final com.kwad.sdk.glide.g.g<Class<?>, byte[]> f35612b = new com.kwad.sdk.glide.g.g<>(50);

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f35613c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.c f35614d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.c f35615e;

    /* renamed from: f  reason: collision with root package name */
    public final int f35616f;

    /* renamed from: g  reason: collision with root package name */
    public final int f35617g;

    /* renamed from: h  reason: collision with root package name */
    public final Class<?> f35618h;
    public final com.kwad.sdk.glide.load.e i;
    public final com.kwad.sdk.glide.load.h<?> j;

    public u(com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, com.kwad.sdk.glide.load.c cVar, com.kwad.sdk.glide.load.c cVar2, int i, int i2, com.kwad.sdk.glide.load.h<?> hVar, Class<?> cls, com.kwad.sdk.glide.load.e eVar) {
        this.f35613c = bVar;
        this.f35614d = cVar;
        this.f35615e = cVar2;
        this.f35616f = i;
        this.f35617g = i2;
        this.j = hVar;
        this.f35618h = cls;
        this.i = eVar;
    }

    private byte[] a() {
        byte[] b2 = f35612b.b(this.f35618h);
        if (b2 == null) {
            byte[] bytes = this.f35618h.getName().getBytes(com.kwad.sdk.glide.load.c.f35376a);
            f35612b.b(this.f35618h, bytes);
            return bytes;
        }
        return b2;
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f35613c.b(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f35616f).putInt(this.f35617g).array();
        this.f35615e.a(messageDigest);
        this.f35614d.a(messageDigest);
        messageDigest.update(bArr);
        com.kwad.sdk.glide.load.h<?> hVar = this.j;
        if (hVar != null) {
            hVar.a(messageDigest);
        }
        this.i.a(messageDigest);
        messageDigest.update(a());
        this.f35613c.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof u) {
            u uVar = (u) obj;
            return this.f35617g == uVar.f35617g && this.f35616f == uVar.f35616f && com.kwad.sdk.glide.g.k.a(this.j, uVar.j) && this.f35618h.equals(uVar.f35618h) && this.f35614d.equals(uVar.f35614d) && this.f35615e.equals(uVar.f35615e) && this.i.equals(uVar.i);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        int hashCode = (((((this.f35614d.hashCode() * 31) + this.f35615e.hashCode()) * 31) + this.f35616f) * 31) + this.f35617g;
        com.kwad.sdk.glide.load.h<?> hVar = this.j;
        if (hVar != null) {
            hashCode = (hashCode * 31) + hVar.hashCode();
        }
        return (((hashCode * 31) + this.f35618h.hashCode()) * 31) + this.i.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f35614d + ", signature=" + this.f35615e + ", width=" + this.f35616f + ", height=" + this.f35617g + ", decodedResourceClass=" + this.f35618h + ", transformation='" + this.j + "', options=" + this.i + '}';
    }
}
