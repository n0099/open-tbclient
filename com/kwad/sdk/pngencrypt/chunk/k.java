package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes5.dex */
public class k extends s {
    int h;
    private int i;
    private byte[] j;

    public k(com.kwad.sdk.pngencrypt.k kVar) {
        super("fdAT", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        this.i = com.kwad.sdk.pngencrypt.n.c(dVar.d, 0);
        this.h = dVar.f10800a - 4;
        this.j = dVar.d;
    }
}
