package com.kwad.sdk.glide.load.engine.bitmap_recycle;
/* loaded from: classes3.dex */
public final class g implements a<byte[]> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.a
    public int a(byte[] bArr) {
        return bArr.length;
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.a
    public String a() {
        return "ByteArrayPool";
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.a
    public int b() {
        return 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.a
    /* renamed from: b */
    public byte[] a(int i) {
        return new byte[i];
    }
}
