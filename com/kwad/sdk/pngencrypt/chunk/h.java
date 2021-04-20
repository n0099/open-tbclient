package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes6.dex */
public class h extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f36444h;
    public int i;
    public int j;
    public int k;
    public int l;

    public h(com.kwad.sdk.pngencrypt.k kVar) {
        super("bKGD", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.f36413e;
        if (kVar.f36479f) {
            this.f36444h = com.kwad.sdk.pngencrypt.n.b(dVar.f36432d, 0);
        } else if (kVar.f36480g) {
            this.l = dVar.f36432d[0] & 255;
        } else {
            this.i = com.kwad.sdk.pngencrypt.n.b(dVar.f36432d, 0);
            this.j = com.kwad.sdk.pngencrypt.n.b(dVar.f36432d, 2);
            this.k = com.kwad.sdk.pngencrypt.n.b(dVar.f36432d, 4);
        }
    }
}
