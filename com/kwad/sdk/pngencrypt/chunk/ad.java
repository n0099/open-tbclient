package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes3.dex */
public class ad extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f57099h;

    /* renamed from: i  reason: collision with root package name */
    public int f57100i;

    /* renamed from: j  reason: collision with root package name */
    public int f57101j;
    public int k;
    public int[] l;

    public ad(com.kwad.sdk.pngencrypt.k kVar) {
        super("tRNS", kVar);
        this.l = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.f57092e;
        if (kVar.f57180f) {
            this.f57099h = com.kwad.sdk.pngencrypt.n.b(dVar.f57112d, 0);
        } else if (!kVar.f57181g) {
            this.f57100i = com.kwad.sdk.pngencrypt.n.b(dVar.f57112d, 0);
            this.f57101j = com.kwad.sdk.pngencrypt.n.b(dVar.f57112d, 2);
            this.k = com.kwad.sdk.pngencrypt.n.b(dVar.f57112d, 4);
        } else {
            int length = dVar.f57112d.length;
            this.l = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                this.l[i2] = dVar.f57112d[i2] & 255;
            }
        }
    }
}
