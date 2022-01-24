package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes3.dex */
public class h extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f57122h;

    /* renamed from: i  reason: collision with root package name */
    public int f57123i;

    /* renamed from: j  reason: collision with root package name */
    public int f57124j;
    public int k;
    public int l;

    public h(com.kwad.sdk.pngencrypt.k kVar) {
        super("bKGD", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.f57092e;
        if (kVar.f57180f) {
            this.f57122h = com.kwad.sdk.pngencrypt.n.b(dVar.f57112d, 0);
        } else if (kVar.f57181g) {
            this.l = dVar.f57112d[0] & 255;
        } else {
            this.f57123i = com.kwad.sdk.pngencrypt.n.b(dVar.f57112d, 0);
            this.f57124j = com.kwad.sdk.pngencrypt.n.b(dVar.f57112d, 2);
            this.k = com.kwad.sdk.pngencrypt.n.b(dVar.f57112d, 4);
        }
    }
}
