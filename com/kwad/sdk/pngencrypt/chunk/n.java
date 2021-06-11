package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes7.dex */
public class n extends aa {

    /* renamed from: h  reason: collision with root package name */
    public String f36882h;

    /* renamed from: i  reason: collision with root package name */
    public byte[] f36883i;

    public n(com.kwad.sdk.pngencrypt.k kVar) {
        super("iCCP", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        int c2 = b.c(dVar.f36859d);
        this.f36882h = b.a(dVar.f36859d, 0, c2);
        byte[] bArr = dVar.f36859d;
        if ((bArr[c2 + 1] & 255) != 0) {
            throw new PngjException("bad compression for ChunkTypeICCP");
        }
        int i2 = c2 + 2;
        int length = bArr.length - i2;
        byte[] bArr2 = new byte[length];
        this.f36883i = bArr2;
        System.arraycopy(bArr, i2, bArr2, 0, length);
    }
}
