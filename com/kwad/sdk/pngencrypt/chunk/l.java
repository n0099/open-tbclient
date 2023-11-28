package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes10.dex */
public final class l extends p {
    public long aKN;
    public long aKO;
    public int aKP;

    public l(com.kwad.sdk.pngencrypt.k kVar) {
        super("oFFs", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len == 9) {
            long g = com.kwad.sdk.pngencrypt.n.g(dVar.data, 0);
            this.aKN = g;
            if (g < 0) {
                this.aKN = g + 4294967296L;
            }
            long g2 = com.kwad.sdk.pngencrypt.n.g(dVar.data, 4);
            this.aKO = g2;
            if (g2 < 0) {
                this.aKO = g2 + 4294967296L;
            }
            this.aKP = com.kwad.sdk.pngencrypt.n.e(dVar.data, 8);
            return;
        }
        throw new PngjException("bad chunk length " + dVar);
    }
}
