package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes5.dex */
public class y extends aa {
    private int h;

    public y(com.kwad.sdk.pngencrypt.k kVar) {
        super("sRGB", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (dVar.f10801a != 1) {
            throw new PngjException("bad chunk length " + dVar);
        }
        this.h = com.kwad.sdk.pngencrypt.n.a(dVar.d, 0);
    }
}
