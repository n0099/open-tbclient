package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes7.dex */
public final class l extends p {
    public long alY;
    public long alZ;
    public int ama;

    public l(com.kwad.sdk.pngencrypt.k kVar) {
        super("oFFs", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len != 9) {
            throw new PngjException("bad chunk length " + dVar);
        }
        long g = com.kwad.sdk.pngencrypt.n.g(dVar.data, 0);
        this.alY = g;
        if (g < 0) {
            this.alY = g + 4294967296L;
        }
        long g2 = com.kwad.sdk.pngencrypt.n.g(dVar.data, 4);
        this.alZ = g2;
        if (g2 < 0) {
            this.alZ = g2 + 4294967296L;
        }
        this.ama = com.kwad.sdk.pngencrypt.n.e(dVar.data, 8);
    }
}
