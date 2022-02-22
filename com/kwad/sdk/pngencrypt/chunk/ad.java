package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes4.dex */
public class ad extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f57266h;

    /* renamed from: i  reason: collision with root package name */
    public int f57267i;

    /* renamed from: j  reason: collision with root package name */
    public int f57268j;
    public int k;
    public int[] l;

    public ad(com.kwad.sdk.pngencrypt.k kVar) {
        super("tRNS", kVar);
        this.l = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.f57259e;
        if (kVar.f57347f) {
            this.f57266h = com.kwad.sdk.pngencrypt.n.b(dVar.f57279d, 0);
        } else if (!kVar.f57348g) {
            this.f57267i = com.kwad.sdk.pngencrypt.n.b(dVar.f57279d, 0);
            this.f57268j = com.kwad.sdk.pngencrypt.n.b(dVar.f57279d, 2);
            this.k = com.kwad.sdk.pngencrypt.n.b(dVar.f57279d, 4);
        } else {
            int length = dVar.f57279d.length;
            this.l = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                this.l[i2] = dVar.f57279d[i2] & 255;
            }
        }
    }
}
