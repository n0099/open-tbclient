package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes6.dex */
public class ad extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f36130h;
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
        com.kwad.sdk.pngencrypt.k kVar = this.f36124e;
        if (kVar.f36190f) {
            this.f36130h = com.kwad.sdk.pngencrypt.n.b(dVar.f36143d, 0);
        } else if (!kVar.f36191g) {
            this.i = com.kwad.sdk.pngencrypt.n.b(dVar.f36143d, 0);
            this.j = com.kwad.sdk.pngencrypt.n.b(dVar.f36143d, 2);
            this.k = com.kwad.sdk.pngencrypt.n.b(dVar.f36143d, 4);
        } else {
            int length = dVar.f36143d.length;
            this.l = new int[length];
            for (int i = 0; i < length; i++) {
                this.l[i] = dVar.f36143d[i] & 255;
            }
        }
    }
}
