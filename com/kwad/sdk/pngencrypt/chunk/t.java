package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes5.dex */
public class t extends aa {
    public long h;
    public long i;
    public int j;

    public t(com.kwad.sdk.pngencrypt.k kVar) {
        super("oFFs", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (dVar.a != 9) {
            throw new PngjException("bad chunk length " + dVar);
        }
        long c = com.kwad.sdk.pngencrypt.n.c(dVar.d, 0);
        this.h = c;
        if (c < 0) {
            this.h = c + 4294967296L;
        }
        long c2 = com.kwad.sdk.pngencrypt.n.c(dVar.d, 4);
        this.i = c2;
        if (c2 < 0) {
            this.i = c2 + 4294967296L;
        }
        this.j = com.kwad.sdk.pngencrypt.n.a(dVar.d, 8);
    }
}
