package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes5.dex */
public class h extends aa {
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;

    public h(com.kwad.sdk.pngencrypt.k kVar) {
        super("bKGD", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.e;
        if (kVar.f) {
            this.h = com.kwad.sdk.pngencrypt.n.b(dVar.d, 0);
        } else if (kVar.g) {
            this.l = dVar.d[0] & 255;
        } else {
            this.i = com.kwad.sdk.pngencrypt.n.b(dVar.d, 0);
            this.j = com.kwad.sdk.pngencrypt.n.b(dVar.d, 2);
            this.k = com.kwad.sdk.pngencrypt.n.b(dVar.d, 4);
        }
    }
}
