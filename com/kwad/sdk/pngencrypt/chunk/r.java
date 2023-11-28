package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes10.dex */
public final class r extends p {
    public int aKW;
    public int aKX;
    public int aKY;
    public int hour;
    public int min;
    public int year;

    public r(com.kwad.sdk.pngencrypt.k kVar) {
        super("tIME", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len == 7) {
            this.year = com.kwad.sdk.pngencrypt.n.f(dVar.data, 0);
            this.aKW = com.kwad.sdk.pngencrypt.n.e(dVar.data, 2);
            this.aKX = com.kwad.sdk.pngencrypt.n.e(dVar.data, 3);
            this.hour = com.kwad.sdk.pngencrypt.n.e(dVar.data, 4);
            this.min = com.kwad.sdk.pngencrypt.n.e(dVar.data, 5);
            this.aKY = com.kwad.sdk.pngencrypt.n.e(dVar.data, 6);
            return;
        }
        throw new PngjException("bad chunk " + dVar);
    }
}
