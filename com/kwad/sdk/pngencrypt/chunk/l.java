package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes3.dex */
public class l extends aa {
    private double h;

    public l(com.kwad.sdk.pngencrypt.k kVar) {
        super("gAMA", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (dVar.f6921a != 4) {
            throw new PngjException("bad chunk " + dVar);
        }
        this.h = com.kwad.sdk.pngencrypt.n.c(dVar.d, 0) / 100000.0d;
    }
}
