package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes6.dex */
public class n extends aa {

    /* renamed from: h  reason: collision with root package name */
    public String f33493h;

    /* renamed from: i  reason: collision with root package name */
    public byte[] f33494i;

    public n(com.kwad.sdk.pngencrypt.k kVar) {
        super("iCCP", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        int c2 = b.c(dVar.f33470d);
        this.f33493h = b.a(dVar.f33470d, 0, c2);
        byte[] bArr = dVar.f33470d;
        if ((bArr[c2 + 1] & 255) != 0) {
            throw new PngjException("bad compression for ChunkTypeICCP");
        }
        int i2 = c2 + 2;
        int length = bArr.length - i2;
        byte[] bArr2 = new byte[length];
        this.f33494i = bArr2;
        System.arraycopy(bArr, i2, bArr2, 0, length);
    }
}
