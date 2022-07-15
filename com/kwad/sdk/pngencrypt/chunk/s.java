package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes5.dex */
public final class s extends p {
    public int h;
    public int i;
    public int j;
    public int k;
    public int[] l;

    public s(com.kwad.sdk.pngencrypt.k kVar) {
        super("tRNS", kVar);
        this.l = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.e;
        if (kVar.f) {
            this.h = com.kwad.sdk.pngencrypt.n.b(dVar.d, 0);
        } else if (!kVar.g) {
            this.i = com.kwad.sdk.pngencrypt.n.b(dVar.d, 0);
            this.j = com.kwad.sdk.pngencrypt.n.b(dVar.d, 2);
            this.k = com.kwad.sdk.pngencrypt.n.b(dVar.d, 4);
        } else {
            int length = dVar.d.length;
            this.l = new int[length];
            for (int i = 0; i < length; i++) {
                this.l[i] = dVar.d[i] & 255;
            }
        }
    }
}
