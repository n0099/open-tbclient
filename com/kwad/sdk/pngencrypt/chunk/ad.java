package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes7.dex */
public class ad extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f40633h;
    public int i;
    public int j;
    public int k;
    public int[] l;

    public ad(com.kwad.sdk.pngencrypt.k kVar) {
        super("tRNS", kVar);
        this.l = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.f40628e;
        if (kVar.f40684f) {
            this.f40633h = com.kwad.sdk.pngencrypt.n.b(dVar.f40643d, 0);
        } else if (!kVar.f40685g) {
            this.i = com.kwad.sdk.pngencrypt.n.b(dVar.f40643d, 0);
            this.j = com.kwad.sdk.pngencrypt.n.b(dVar.f40643d, 2);
            this.k = com.kwad.sdk.pngencrypt.n.b(dVar.f40643d, 4);
        } else {
            int length = dVar.f40643d.length;
            this.l = new int[length];
            for (int i = 0; i < length; i++) {
                this.l[i] = dVar.f40643d[i] & 255;
            }
        }
    }
}
