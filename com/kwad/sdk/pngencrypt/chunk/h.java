package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes6.dex */
public class h extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f33412h;

    /* renamed from: i  reason: collision with root package name */
    public int f33413i;
    public int j;
    public int k;
    public int l;

    public h(com.kwad.sdk.pngencrypt.k kVar) {
        super("bKGD", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.f33377e;
        if (kVar.f33461f) {
            this.f33412h = com.kwad.sdk.pngencrypt.n.b(dVar.f33399d, 0);
        } else if (kVar.f33462g) {
            this.l = dVar.f33399d[0] & 255;
        } else {
            this.f33413i = com.kwad.sdk.pngencrypt.n.b(dVar.f33399d, 0);
            this.j = com.kwad.sdk.pngencrypt.n.b(dVar.f33399d, 2);
            this.k = com.kwad.sdk.pngencrypt.n.b(dVar.f33399d, 4);
        }
    }
}
