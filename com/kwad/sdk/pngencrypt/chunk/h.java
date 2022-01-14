package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes3.dex */
public class h extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f57077h;

    /* renamed from: i  reason: collision with root package name */
    public int f57078i;

    /* renamed from: j  reason: collision with root package name */
    public int f57079j;
    public int k;
    public int l;

    public h(com.kwad.sdk.pngencrypt.k kVar) {
        super("bKGD", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.f57047e;
        if (kVar.f57135f) {
            this.f57077h = com.kwad.sdk.pngencrypt.n.b(dVar.f57067d, 0);
        } else if (kVar.f57136g) {
            this.l = dVar.f57067d[0] & 255;
        } else {
            this.f57078i = com.kwad.sdk.pngencrypt.n.b(dVar.f57067d, 0);
            this.f57079j = com.kwad.sdk.pngencrypt.n.b(dVar.f57067d, 2);
            this.k = com.kwad.sdk.pngencrypt.n.b(dVar.f57067d, 4);
        }
    }
}
