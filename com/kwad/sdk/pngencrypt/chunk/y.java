package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes5.dex */
public class y extends aa {
    public int h;

    public y(com.kwad.sdk.pngencrypt.k kVar) {
        super("sRGB", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (dVar.a == 1) {
            this.h = com.kwad.sdk.pngencrypt.n.a(dVar.d, 0);
            return;
        }
        throw new PngjException("bad chunk length " + dVar);
    }
}
