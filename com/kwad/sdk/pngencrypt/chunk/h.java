package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes7.dex */
public class h extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f36872h;

    /* renamed from: i  reason: collision with root package name */
    public int f36873i;
    public int j;
    public int k;
    public int l;

    public h(com.kwad.sdk.pngencrypt.k kVar) {
        super("bKGD", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.f36837e;
        if (kVar.f36921f) {
            this.f36872h = com.kwad.sdk.pngencrypt.n.b(dVar.f36859d, 0);
        } else if (kVar.f36922g) {
            this.l = dVar.f36859d[0] & 255;
        } else {
            this.f36873i = com.kwad.sdk.pngencrypt.n.b(dVar.f36859d, 0);
            this.j = com.kwad.sdk.pngencrypt.n.b(dVar.f36859d, 2);
            this.k = com.kwad.sdk.pngencrypt.n.b(dVar.f36859d, 4);
        }
    }
}
