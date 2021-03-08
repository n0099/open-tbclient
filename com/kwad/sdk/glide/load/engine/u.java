package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
/* loaded from: classes3.dex */
final class u implements com.kwad.sdk.glide.load.c {
    private static final com.kwad.sdk.glide.g.g<Class<?>, byte[]> b = new com.kwad.sdk.glide.g.g<>(50);
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b c;
    private final com.kwad.sdk.glide.load.c d;
    private final com.kwad.sdk.glide.load.c e;
    private final int f;
    private final int g;
    private final Class<?> h;
    private final com.kwad.sdk.glide.load.e i;
    private final com.kwad.sdk.glide.load.h<?> j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, com.kwad.sdk.glide.load.c cVar, com.kwad.sdk.glide.load.c cVar2, int i, int i2, com.kwad.sdk.glide.load.h<?> hVar, Class<?> cls, com.kwad.sdk.glide.load.e eVar) {
        this.c = bVar;
        this.d = cVar;
        this.e = cVar2;
        this.f = i;
        this.g = i2;
        this.j = hVar;
        this.h = cls;
        this.i = eVar;
    }

    private byte[] a() {
        byte[] b2 = b.b(this.h);
        if (b2 == null) {
            byte[] bytes = this.h.getName().getBytes(f6709a);
            b.b(this.h, bytes);
            return bytes;
        }
        return b2;
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.c.b(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f).putInt(this.g).array();
        this.e.a(messageDigest);
        this.d.a(messageDigest);
        messageDigest.update(bArr);
        if (this.j != null) {
            this.j.a(messageDigest);
        }
        this.i.a(messageDigest);
        messageDigest.update(a());
        this.c.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof u) {
            u uVar = (u) obj;
            return this.g == uVar.g && this.f == uVar.f && com.kwad.sdk.glide.g.k.a(this.j, uVar.j) && this.h.equals(uVar.h) && this.d.equals(uVar.d) && this.e.equals(uVar.e) && this.i.equals(uVar.i);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        int hashCode = (((((this.d.hashCode() * 31) + this.e.hashCode()) * 31) + this.f) * 31) + this.g;
        if (this.j != null) {
            hashCode = (hashCode * 31) + this.j.hashCode();
        }
        return (((hashCode * 31) + this.h.hashCode()) * 31) + this.i.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.d + ", signature=" + this.e + ", width=" + this.f + ", height=" + this.g + ", decodedResourceClass=" + this.h + ", transformation='" + this.j + "', options=" + this.i + '}';
    }
}
