package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes8.dex */
public class h extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f55639h;

    /* renamed from: i  reason: collision with root package name */
    public int f55640i;

    /* renamed from: j  reason: collision with root package name */
    public int f55641j;
    public int k;
    public int l;

    public h(com.kwad.sdk.pngencrypt.k kVar) {
        super("bKGD", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.f55609e;
        if (kVar.f55697f) {
            this.f55639h = com.kwad.sdk.pngencrypt.n.b(dVar.f55629d, 0);
        } else if (kVar.f55698g) {
            this.l = dVar.f55629d[0] & 255;
        } else {
            this.f55640i = com.kwad.sdk.pngencrypt.n.b(dVar.f55629d, 0);
            this.f55641j = com.kwad.sdk.pngencrypt.n.b(dVar.f55629d, 2);
            this.k = com.kwad.sdk.pngencrypt.n.b(dVar.f55629d, 4);
        }
    }
}
