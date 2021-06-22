package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes7.dex */
public class ad extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f36942h;

    /* renamed from: i  reason: collision with root package name */
    public int f36943i;
    public int j;
    public int k;
    public int[] l;

    public ad(com.kwad.sdk.pngencrypt.k kVar) {
        super("tRNS", kVar);
        this.l = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.f36935e;
        if (kVar.f37019f) {
            this.f36942h = com.kwad.sdk.pngencrypt.n.b(dVar.f36957d, 0);
        } else if (!kVar.f37020g) {
            this.f36943i = com.kwad.sdk.pngencrypt.n.b(dVar.f36957d, 0);
            this.j = com.kwad.sdk.pngencrypt.n.b(dVar.f36957d, 2);
            this.k = com.kwad.sdk.pngencrypt.n.b(dVar.f36957d, 4);
        } else {
            int length = dVar.f36957d.length;
            this.l = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                this.l[i2] = dVar.f36957d[i2] & 255;
            }
        }
    }
}
