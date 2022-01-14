package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes3.dex */
public class ad extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f57054h;

    /* renamed from: i  reason: collision with root package name */
    public int f57055i;

    /* renamed from: j  reason: collision with root package name */
    public int f57056j;
    public int k;
    public int[] l;

    public ad(com.kwad.sdk.pngencrypt.k kVar) {
        super("tRNS", kVar);
        this.l = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.f57047e;
        if (kVar.f57135f) {
            this.f57054h = com.kwad.sdk.pngencrypt.n.b(dVar.f57067d, 0);
        } else if (!kVar.f57136g) {
            this.f57055i = com.kwad.sdk.pngencrypt.n.b(dVar.f57067d, 0);
            this.f57056j = com.kwad.sdk.pngencrypt.n.b(dVar.f57067d, 2);
            this.k = com.kwad.sdk.pngencrypt.n.b(dVar.f57067d, 4);
        } else {
            int length = dVar.f57067d.length;
            this.l = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                this.l[i2] = dVar.f57067d[i2] & 255;
            }
        }
    }
}
