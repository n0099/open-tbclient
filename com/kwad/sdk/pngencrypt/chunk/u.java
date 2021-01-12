package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes4.dex */
public class u extends aa {
    private long h;
    private long i;
    private int j;

    public u(com.kwad.sdk.pngencrypt.k kVar) {
        super("pHYs", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (dVar.f10501a != 9) {
            throw new PngjException("bad chunk length " + dVar);
        }
        this.h = com.kwad.sdk.pngencrypt.n.c(dVar.d, 0);
        if (this.h < 0) {
            this.h += 4294967296L;
        }
        this.i = com.kwad.sdk.pngencrypt.n.c(dVar.d, 4);
        if (this.i < 0) {
            this.i += 4294967296L;
        }
        this.j = com.kwad.sdk.pngencrypt.n.a(dVar.d, 8);
    }
}
