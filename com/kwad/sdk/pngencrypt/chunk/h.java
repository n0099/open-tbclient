package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes3.dex */
public class h extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f59313h;

    /* renamed from: i  reason: collision with root package name */
    public int f59314i;

    /* renamed from: j  reason: collision with root package name */
    public int f59315j;

    /* renamed from: k  reason: collision with root package name */
    public int f59316k;
    public int l;

    public h(com.kwad.sdk.pngencrypt.k kVar) {
        super("bKGD", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.f59281e;
        if (kVar.f59379f) {
            this.f59313h = com.kwad.sdk.pngencrypt.n.b(dVar.f59303d, 0);
        } else if (kVar.f59380g) {
            this.l = dVar.f59303d[0] & 255;
        } else {
            this.f59314i = com.kwad.sdk.pngencrypt.n.b(dVar.f59303d, 0);
            this.f59315j = com.kwad.sdk.pngencrypt.n.b(dVar.f59303d, 2);
            this.f59316k = com.kwad.sdk.pngencrypt.n.b(dVar.f59303d, 4);
        }
    }
}
