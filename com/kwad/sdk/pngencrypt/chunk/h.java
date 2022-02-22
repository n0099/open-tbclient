package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes4.dex */
public class h extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f57289h;

    /* renamed from: i  reason: collision with root package name */
    public int f57290i;

    /* renamed from: j  reason: collision with root package name */
    public int f57291j;
    public int k;
    public int l;

    public h(com.kwad.sdk.pngencrypt.k kVar) {
        super("bKGD", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.f57259e;
        if (kVar.f57347f) {
            this.f57289h = com.kwad.sdk.pngencrypt.n.b(dVar.f57279d, 0);
        } else if (kVar.f57348g) {
            this.l = dVar.f57279d[0] & 255;
        } else {
            this.f57290i = com.kwad.sdk.pngencrypt.n.b(dVar.f57279d, 0);
            this.f57291j = com.kwad.sdk.pngencrypt.n.b(dVar.f57279d, 2);
            this.k = com.kwad.sdk.pngencrypt.n.b(dVar.f57279d, 4);
        }
    }
}
