package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes6.dex */
public class h extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f34238h;

    /* renamed from: i  reason: collision with root package name */
    public int f34239i;
    public int j;
    public int k;
    public int l;

    public h(com.kwad.sdk.pngencrypt.k kVar) {
        super("bKGD", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.f34203e;
        if (kVar.f34287f) {
            this.f34238h = com.kwad.sdk.pngencrypt.n.b(dVar.f34225d, 0);
        } else if (kVar.f34288g) {
            this.l = dVar.f34225d[0] & 255;
        } else {
            this.f34239i = com.kwad.sdk.pngencrypt.n.b(dVar.f34225d, 0);
            this.j = com.kwad.sdk.pngencrypt.n.b(dVar.f34225d, 2);
            this.k = com.kwad.sdk.pngencrypt.n.b(dVar.f34225d, 4);
        }
    }
}
