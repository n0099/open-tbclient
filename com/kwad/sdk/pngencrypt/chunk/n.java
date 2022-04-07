package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes5.dex */
public class n extends aa {
    public String h;
    public byte[] i;

    public n(com.kwad.sdk.pngencrypt.k kVar) {
        super("iCCP", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        int c = b.c(dVar.d);
        this.h = b.a(dVar.d, 0, c);
        byte[] bArr = dVar.d;
        if ((bArr[c + 1] & 255) != 0) {
            throw new PngjException("bad compression for ChunkTypeICCP");
        }
        int i = c + 2;
        int length = bArr.length - i;
        byte[] bArr2 = new byte[length];
        this.i = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, length);
    }
}
