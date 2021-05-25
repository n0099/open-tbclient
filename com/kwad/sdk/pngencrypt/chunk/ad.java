package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes6.dex */
public class ad extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f33384h;

    /* renamed from: i  reason: collision with root package name */
    public int f33385i;
    public int j;
    public int k;
    public int[] l;

    public ad(com.kwad.sdk.pngencrypt.k kVar) {
        super("tRNS", kVar);
        this.l = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.f33377e;
        if (kVar.f33461f) {
            this.f33384h = com.kwad.sdk.pngencrypt.n.b(dVar.f33399d, 0);
        } else if (!kVar.f33462g) {
            this.f33385i = com.kwad.sdk.pngencrypt.n.b(dVar.f33399d, 0);
            this.j = com.kwad.sdk.pngencrypt.n.b(dVar.f33399d, 2);
            this.k = com.kwad.sdk.pngencrypt.n.b(dVar.f33399d, 4);
        } else {
            int length = dVar.f33399d.length;
            this.l = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                this.l[i2] = dVar.f33399d[i2] & 255;
            }
        }
    }
}
