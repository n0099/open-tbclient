package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes5.dex */
public class g extends aa {
    private int h;
    private int i;

    public g(com.kwad.sdk.pngencrypt.k kVar) {
        super("acTL", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        this.h = com.kwad.sdk.pngencrypt.n.c(dVar.d, 0);
        this.i = com.kwad.sdk.pngencrypt.n.c(dVar.d, 4);
    }
}
