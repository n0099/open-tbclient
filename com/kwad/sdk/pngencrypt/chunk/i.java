package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes5.dex */
public class i extends aa {
    public double h;
    public double i;
    public double j;
    public double k;
    public double l;
    public double m;
    public double n;
    public double o;

    public i(com.kwad.sdk.pngencrypt.k kVar) {
        super("cHRM", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (dVar.a != 32) {
            throw new PngjException("bad chunk " + dVar);
        }
        this.h = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.d, 0));
        this.i = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.d, 4));
        this.j = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.d, 8));
        this.k = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.d, 12));
        this.l = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.d, 16));
        this.m = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.d, 20));
        this.n = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.d, 24));
        this.o = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.d, 28));
    }
}
