package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes6.dex */
public class ad extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f33455h;

    /* renamed from: i  reason: collision with root package name */
    public int f33456i;
    public int j;
    public int k;
    public int[] l;

    public ad(com.kwad.sdk.pngencrypt.k kVar) {
        super("tRNS", kVar);
        this.l = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.f33448e;
        if (kVar.f33532f) {
            this.f33455h = com.kwad.sdk.pngencrypt.n.b(dVar.f33470d, 0);
        } else if (!kVar.f33533g) {
            this.f33456i = com.kwad.sdk.pngencrypt.n.b(dVar.f33470d, 0);
            this.j = com.kwad.sdk.pngencrypt.n.b(dVar.f33470d, 2);
            this.k = com.kwad.sdk.pngencrypt.n.b(dVar.f33470d, 4);
        } else {
            int length = dVar.f33470d.length;
            this.l = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                this.l[i2] = dVar.f33470d[i2] & 255;
            }
        }
    }
}
