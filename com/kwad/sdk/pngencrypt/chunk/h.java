package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes3.dex */
public class h extends aa {
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;

    public h(com.kwad.sdk.pngencrypt.k kVar) {
        super("bKGD", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (this.e.f) {
            this.h = com.kwad.sdk.pngencrypt.n.b(dVar.d, 0);
        } else if (this.e.g) {
            this.l = dVar.d[0] & 255;
        } else {
            this.i = com.kwad.sdk.pngencrypt.n.b(dVar.d, 0);
            this.j = com.kwad.sdk.pngencrypt.n.b(dVar.d, 2);
            this.k = com.kwad.sdk.pngencrypt.n.b(dVar.d, 4);
        }
    }
}
