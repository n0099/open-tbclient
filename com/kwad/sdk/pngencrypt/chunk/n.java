package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes3.dex */
public class n extends aa {

    /* renamed from: h  reason: collision with root package name */
    public String f57091h;

    /* renamed from: i  reason: collision with root package name */
    public byte[] f57092i;

    public n(com.kwad.sdk.pngencrypt.k kVar) {
        super("iCCP", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        int c2 = b.c(dVar.f57067d);
        this.f57091h = b.a(dVar.f57067d, 0, c2);
        byte[] bArr = dVar.f57067d;
        if ((bArr[c2 + 1] & 255) != 0) {
            throw new PngjException("bad compression for ChunkTypeICCP");
        }
        int i2 = c2 + 2;
        int length = bArr.length - i2;
        byte[] bArr2 = new byte[length];
        this.f57092i = bArr2;
        System.arraycopy(bArr, i2, bArr2, 0, length);
    }
}
