package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes5.dex */
public final class o extends p {
    public byte h;

    public o(com.kwad.sdk.pngencrypt.k kVar) {
        super("sTER", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.a == 1) {
            this.h = dVar.d[0];
            return;
        }
        throw new PngjException("bad chunk length " + dVar);
    }
}
