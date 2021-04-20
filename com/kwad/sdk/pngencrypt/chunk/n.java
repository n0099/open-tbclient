package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes6.dex */
public class n extends aa {

    /* renamed from: h  reason: collision with root package name */
    public String f36450h;
    public byte[] i;

    public n(com.kwad.sdk.pngencrypt.k kVar) {
        super("iCCP", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        int c2 = b.c(dVar.f36432d);
        this.f36450h = b.a(dVar.f36432d, 0, c2);
        byte[] bArr = dVar.f36432d;
        if ((bArr[c2 + 1] & 255) != 0) {
            throw new PngjException("bad compression for ChunkTypeICCP");
        }
        int i = c2 + 2;
        int length = bArr.length - i;
        byte[] bArr2 = new byte[length];
        this.i = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, length);
    }
}
