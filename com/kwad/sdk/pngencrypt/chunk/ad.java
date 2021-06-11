package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes7.dex */
public class ad extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f36844h;

    /* renamed from: i  reason: collision with root package name */
    public int f36845i;
    public int j;
    public int k;
    public int[] l;

    public ad(com.kwad.sdk.pngencrypt.k kVar) {
        super("tRNS", kVar);
        this.l = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.f36837e;
        if (kVar.f36921f) {
            this.f36844h = com.kwad.sdk.pngencrypt.n.b(dVar.f36859d, 0);
        } else if (!kVar.f36922g) {
            this.f36845i = com.kwad.sdk.pngencrypt.n.b(dVar.f36859d, 0);
            this.j = com.kwad.sdk.pngencrypt.n.b(dVar.f36859d, 2);
            this.k = com.kwad.sdk.pngencrypt.n.b(dVar.f36859d, 4);
        } else {
            int length = dVar.f36859d.length;
            this.l = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                this.l[i2] = dVar.f36859d[i2] & 255;
            }
        }
    }
}
