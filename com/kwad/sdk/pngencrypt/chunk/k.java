package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes5.dex */
public class k extends s {
    public int h;
    public int i;
    public byte[] j;

    public k(com.kwad.sdk.pngencrypt.k kVar) {
        super("fdAT", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        this.i = com.kwad.sdk.pngencrypt.n.c(dVar.d, 0);
        this.h = dVar.a - 4;
        this.j = dVar.d;
    }
}
