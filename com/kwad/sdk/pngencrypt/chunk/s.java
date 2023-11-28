package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes10.dex */
public final class s extends p {
    public int aKZ;
    public int aLa;
    public int aLb;
    public int aLc;
    public int[] aLd;

    public s(com.kwad.sdk.pngencrypt.k kVar) {
        super("tRNS", kVar);
        this.aLd = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.aJz;
        if (kVar.aJG) {
            this.aKZ = com.kwad.sdk.pngencrypt.n.f(dVar.data, 0);
        } else if (kVar.aJH) {
            int length = dVar.data.length;
            this.aLd = new int[length];
            for (int i = 0; i < length; i++) {
                this.aLd[i] = dVar.data[i] & 255;
            }
        } else {
            this.aLa = com.kwad.sdk.pngencrypt.n.f(dVar.data, 0);
            this.aLb = com.kwad.sdk.pngencrypt.n.f(dVar.data, 2);
            this.aLc = com.kwad.sdk.pngencrypt.n.f(dVar.data, 4);
        }
    }
}
