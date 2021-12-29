package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes3.dex */
public class ad extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f59289h;

    /* renamed from: i  reason: collision with root package name */
    public int f59290i;

    /* renamed from: j  reason: collision with root package name */
    public int f59291j;

    /* renamed from: k  reason: collision with root package name */
    public int f59292k;
    public int[] l;

    public ad(com.kwad.sdk.pngencrypt.k kVar) {
        super("tRNS", kVar);
        this.l = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.f59281e;
        if (kVar.f59379f) {
            this.f59289h = com.kwad.sdk.pngencrypt.n.b(dVar.f59303d, 0);
        } else if (!kVar.f59380g) {
            this.f59290i = com.kwad.sdk.pngencrypt.n.b(dVar.f59303d, 0);
            this.f59291j = com.kwad.sdk.pngencrypt.n.b(dVar.f59303d, 2);
            this.f59292k = com.kwad.sdk.pngencrypt.n.b(dVar.f59303d, 4);
        } else {
            int length = dVar.f59303d.length;
            this.l = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                this.l[i2] = dVar.f59303d[i2] & 255;
            }
        }
    }
}
