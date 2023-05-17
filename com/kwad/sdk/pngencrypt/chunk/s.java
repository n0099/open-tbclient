package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes9.dex */
public final class s extends p {
    public int amk;
    public int aml;
    public int amm;
    public int amn;
    public int[] amo;

    public s(com.kwad.sdk.pngencrypt.k kVar) {
        super("tRNS", kVar);
        this.amo = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.akJ;
        if (kVar.akQ) {
            this.amk = com.kwad.sdk.pngencrypt.n.f(dVar.data, 0);
        } else if (!kVar.akR) {
            this.aml = com.kwad.sdk.pngencrypt.n.f(dVar.data, 0);
            this.amm = com.kwad.sdk.pngencrypt.n.f(dVar.data, 2);
            this.amn = com.kwad.sdk.pngencrypt.n.f(dVar.data, 4);
        } else {
            int length = dVar.data.length;
            this.amo = new int[length];
            for (int i = 0; i < length; i++) {
                this.amo[i] = dVar.data[i] & 255;
            }
        }
    }
}
