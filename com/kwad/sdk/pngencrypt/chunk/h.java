package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes7.dex */
public class h extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f40652h;
    public int i;
    public int j;
    public int k;
    public int l;

    public h(com.kwad.sdk.pngencrypt.k kVar) {
        super("bKGD", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.f40628e;
        if (kVar.f40684f) {
            this.f40652h = com.kwad.sdk.pngencrypt.n.b(dVar.f40643d, 0);
        } else if (kVar.f40685g) {
            this.l = dVar.f40643d[0] & 255;
        } else {
            this.i = com.kwad.sdk.pngencrypt.n.b(dVar.f40643d, 0);
            this.j = com.kwad.sdk.pngencrypt.n.b(dVar.f40643d, 2);
            this.k = com.kwad.sdk.pngencrypt.n.b(dVar.f40643d, 4);
        }
    }
}
