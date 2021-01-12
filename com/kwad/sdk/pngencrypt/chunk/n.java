package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes4.dex */
public class n extends aa {
    private String h;
    private byte[] i;

    public n(com.kwad.sdk.pngencrypt.k kVar) {
        super("iCCP", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        int c = b.c(dVar.d);
        this.h = b.a(dVar.d, 0, c);
        if ((dVar.d[c + 1] & 255) != 0) {
            throw new PngjException("bad compression for ChunkTypeICCP");
        }
        int length = dVar.d.length - (c + 2);
        this.i = new byte[length];
        System.arraycopy(dVar.d, c + 2, this.i, 0, length);
    }
}
