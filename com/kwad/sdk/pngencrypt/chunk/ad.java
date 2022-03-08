package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes8.dex */
public class ad extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f55616h;

    /* renamed from: i  reason: collision with root package name */
    public int f55617i;

    /* renamed from: j  reason: collision with root package name */
    public int f55618j;
    public int k;
    public int[] l;

    public ad(com.kwad.sdk.pngencrypt.k kVar) {
        super("tRNS", kVar);
        this.l = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.f55609e;
        if (kVar.f55697f) {
            this.f55616h = com.kwad.sdk.pngencrypt.n.b(dVar.f55629d, 0);
        } else if (!kVar.f55698g) {
            this.f55617i = com.kwad.sdk.pngencrypt.n.b(dVar.f55629d, 0);
            this.f55618j = com.kwad.sdk.pngencrypt.n.b(dVar.f55629d, 2);
            this.k = com.kwad.sdk.pngencrypt.n.b(dVar.f55629d, 4);
        } else {
            int length = dVar.f55629d.length;
            this.l = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                this.l[i2] = dVar.f55629d[i2] & 255;
            }
        }
    }
}
