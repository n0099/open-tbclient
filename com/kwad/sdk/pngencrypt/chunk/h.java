package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes6.dex */
public class h extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f33483h;

    /* renamed from: i  reason: collision with root package name */
    public int f33484i;
    public int j;
    public int k;
    public int l;

    public h(com.kwad.sdk.pngencrypt.k kVar) {
        super("bKGD", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.f33448e;
        if (kVar.f33532f) {
            this.f33483h = com.kwad.sdk.pngencrypt.n.b(dVar.f33470d, 0);
        } else if (kVar.f33533g) {
            this.l = dVar.f33470d[0] & 255;
        } else {
            this.f33484i = com.kwad.sdk.pngencrypt.n.b(dVar.f33470d, 0);
            this.j = com.kwad.sdk.pngencrypt.n.b(dVar.f33470d, 2);
            this.k = com.kwad.sdk.pngencrypt.n.b(dVar.f33470d, 4);
        }
    }
}
