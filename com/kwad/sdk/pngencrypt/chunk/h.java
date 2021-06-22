package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes7.dex */
public class h extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f36970h;

    /* renamed from: i  reason: collision with root package name */
    public int f36971i;
    public int j;
    public int k;
    public int l;

    public h(com.kwad.sdk.pngencrypt.k kVar) {
        super("bKGD", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.f36935e;
        if (kVar.f37019f) {
            this.f36970h = com.kwad.sdk.pngencrypt.n.b(dVar.f36957d, 0);
        } else if (kVar.f37020g) {
            this.l = dVar.f36957d[0] & 255;
        } else {
            this.f36971i = com.kwad.sdk.pngencrypt.n.b(dVar.f36957d, 0);
            this.j = com.kwad.sdk.pngencrypt.n.b(dVar.f36957d, 2);
            this.k = com.kwad.sdk.pngencrypt.n.b(dVar.f36957d, 4);
        }
    }
}
