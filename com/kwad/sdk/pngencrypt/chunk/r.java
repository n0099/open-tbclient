package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes5.dex */
public final class r extends p {
    public int amh;
    public int ami;
    public int amj;
    public int hour;
    public int min;
    public int year;

    public r(com.kwad.sdk.pngencrypt.k kVar) {
        super("tIME", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len != 7) {
            throw new PngjException("bad chunk " + dVar);
        }
        this.year = com.kwad.sdk.pngencrypt.n.f(dVar.data, 0);
        this.amh = com.kwad.sdk.pngencrypt.n.e(dVar.data, 2);
        this.ami = com.kwad.sdk.pngencrypt.n.e(dVar.data, 3);
        this.hour = com.kwad.sdk.pngencrypt.n.e(dVar.data, 4);
        this.min = com.kwad.sdk.pngencrypt.n.e(dVar.data, 5);
        this.amj = com.kwad.sdk.pngencrypt.n.e(dVar.data, 6);
    }
}
